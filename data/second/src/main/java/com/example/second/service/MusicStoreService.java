package com.example.second.service;

import com.example.second.entity.*;
import com.example.second.repo.AlbumRepo;
import com.example.second.repo.CustomerRepo;
import com.example.second.repo.InvoiceRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/MusicStoreService")
public class MusicStoreService {

    private final AlbumRepo albumRepo;
    private final CustomerRepo customerRepo;
    private final InvoiceRepo invoiceRepo;

    public MusicStoreService(AlbumRepo albumRepo, CustomerRepo customerRepo, InvoiceRepo invoiceRepo) {
        this.albumRepo = albumRepo;
        this.customerRepo = customerRepo;
        this.invoiceRepo = invoiceRepo;
    }

    @GetMapping("user/{id}")
    public Customer getUser(@PathVariable int id) {
        var res = customerRepo.getUser(id);
        if (res.size() == 0) {
            throw new IllegalArgumentException();
        }
        return res.get(0);
    }

    @GetMapping("getArtistsByName/{artistName}")
    public List<Artist> getArtistsByName(@PathVariable String artistName) {
        return albumRepo.selectArtist(artistName);

    }
    @GetMapping("getAlbumsByArtistId/{id}")
    public Album getAlbumsByArtistId(@PathVariable int id) {
        var res = albumRepo.getAlbumsByArtistId(id);
        if (res.size() == 0) {
            throw new IllegalArgumentException();
        }
        return res.get(0);
    }
    @GetMapping("getTracksByAlbumId/{id}")
    public List<Track> getTracksByAlbumId(int id) {
        return albumRepo.getTracksByAlbumId(id);
    }

    public Invoice orderTrack(int trackId, List<Track> tracks, Customer customer) {
        var track = getTrackById(trackId, tracks);
        var invoice = invoiceRepo.creatInvoice(String.valueOf(customer.id()),
                customer.address(), customer.city(), customer.state(),
                customer.country(), customer.postCode(), String.valueOf(track.UnitPrice()));

        updateInvoiceItem(track, invoice);
        return invoice;
    }

    private void updateInvoiceItem(Track track, Invoice invoice) {
        invoiceRepo.updateInvoiceItem(String.valueOf(invoice.invoiceId()),
                String.valueOf(track.TrackId()), String.valueOf(track.UnitPrice()), "1");
    }

    private Track getTrackById(int trackId, List<Track> tracks) {
        for (int i = 0; i < tracks.size(); i++) {
            if (tracks.get(i).TrackId() == trackId) {
                return tracks.get(i);
            }
        }
        throw new IllegalArgumentException();
    }

    public void orderMoreTrack(int trackId, Invoice invoice,List<Track> tracks) {
        var track = getTrackById(trackId, tracks);
        invoiceRepo.updateInvoicePrice(invoice.invoiceId(),track.UnitPrice());
        updateInvoiceItem(track,invoice);
    }
}

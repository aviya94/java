package com.example.second.service;

import com.example.second.entity.*;
import com.example.second.repo.AlbumRepo;
import com.example.second.repo.CustomerRepo;
import com.example.second.repo.InvoiceRepo;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class MusicStoreService {

    private final AlbumRepo albumRepo;
    private final CustomerRepo customerRepo;
    private final InvoiceRepo invoiceRepo;

    public MusicStoreService(AlbumRepo albumRepo, CustomerRepo customerRepo, InvoiceRepo invoiceRepo) {
        this.albumRepo = albumRepo;
        this.customerRepo = customerRepo;
        this.invoiceRepo = invoiceRepo;
    }

    public Customer getUser( int id) {
        var res = customerRepo.getUser(id);
        if (res.size() == 0) {
            throw new IllegalArgumentException();
        }
        return res.get(0);
    }

    public List<Artist> getArtistsByName( String artistName) {
        return albumRepo.selectArtist(artistName);

    }

    public Album getAlbumsByArtistId( int id) {
        var res = albumRepo.getAlbumsByArtistId(id);
        if (res.size() == 0) {
            throw new IllegalArgumentException();
        }
        return res.get(0);
    }

    public List<Track> getTracksByAlbumId(int id) {
        return albumRepo.getTracksByAlbumId(id);
    }

    public Invoice creatInvoice(int customerId){
       var customer=  customerRepo.getUser(customerId).get(0);
       return invoiceRepo.creatInvoice(customer);
    }

    public void orderMoreTrack(int trackId, Invoice invoice) {
        var track = albumRepo.selectTrack(trackId);
        invoiceRepo.updateInvoicePrice(invoice.invoiceId(),track.UnitPrice());
        updateInvoiceItem(track,invoice);
    }

    private void updateInvoiceItem(Track track, Invoice invoice) {
        invoiceRepo.updateInvoiceItem(String.valueOf(invoice.invoiceId()),
                String.valueOf(track.TrackId()), String.valueOf(track.UnitPrice()), "1");
    }

    public Invoice orderTrack(int trackId, Customer customer) {
        var track = albumRepo.selectTrack(trackId);
        var invoice = invoiceRepo.creatInvoice(String.valueOf(customer.id()),
                customer.address(), customer.city(), customer.state(),
                customer.country(), customer.postCode(), String.valueOf(track.UnitPrice()));

        updateInvoiceItem(track, invoice);
        return invoice;
    }

}

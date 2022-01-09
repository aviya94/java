package com.example.second.service;

import com.example.second.entity.Album;
import com.example.second.entity.Artist;
import com.example.second.entity.Customer;
import com.example.second.entity.Track;
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

    public Customer getUser(int id) {
        var res = customerRepo.getUser(id);
        if (res.size() == 0) {
            throw new IllegalArgumentException();
        }
        return res.get(0);
    }

    public List<Artist> getArtistsByName(String artistName) {
        return albumRepo.selectArtist(artistName);

    }

    public Album getAlbumsByArtistId(int id) {
        var res = albumRepo.getAlbumsByArtistId(id);
        if (res.size() == 0) {
            throw new IllegalArgumentException();
        }
        return res.get(0);
    }

    public List<Track> getTracksByAlbumId(int id) {
        return albumRepo.getTracksByAlbumId(id);
    }

    public void orderTrack(int trackId, List<Track> tracks, Customer customer) {
        var track = getTrackById(trackId, tracks);
        var invoiceId = invoiceRepo.creatInvoice(String.valueOf(customer.id()),
                customer.address(), customer.city(), customer.state(),
                customer.country(), customer.postCode(), String.valueOf(track.UnitPrice()));

        invoiceRepo.updateInvoiceItem(String.valueOf(invoiceId.invoiceId()),
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
}

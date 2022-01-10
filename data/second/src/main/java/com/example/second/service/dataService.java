package com.example.second.service;

import com.example.second.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/MusicStoreService")
public class dataService {
    @Autowired
    MusicStoreService musicStoreService;

    @GetMapping("user/{id}")
    public Customer getUser(@PathVariable() int id) {
        return musicStoreService.getUser(id);
    }

    @GetMapping("getArtistsByName/{artistName}")
    public List<Artist> getArtistsByName(@PathVariable String artistName) {
        return musicStoreService.getArtistsByName(artistName);

    }

    @GetMapping("getAlbumsByArtistId/{id}")
    public Album getAlbumsByArtistId(@PathVariable int id) {
        return musicStoreService.getAlbumsByArtistId(id);
    }

    @GetMapping("getTracksByAlbumId/{id}")
    public List<Track> getTracksByAlbumId(@PathVariable int id) {
        return musicStoreService.getTracksByAlbumId(id);
    }

    @GetMapping("creatInvoice/{customerId}")
    public Invoice creatInvoice(@PathVariable int customerId) {
        return musicStoreService.creatInvoice(customerId);

    }

    @GetMapping ("orderMoreTrack/{trackId}/{invoiceId}")
    public void orderMoreTrack(@PathVariable int trackId,@PathVariable int invoiceId) {
        musicStoreService.orderMoreTrack(trackId, new Invoice(invoiceId));
    }


}

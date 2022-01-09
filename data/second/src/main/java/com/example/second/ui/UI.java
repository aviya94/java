package com.example.second.ui;

import com.example.second.entity.Artist;
import com.example.second.entity.Customer;
import com.example.second.entity.Track;
import com.example.second.repo.CustomerRepo;
import com.example.second.service.MusicStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class UI implements CommandLineRunner {

    private Scanner scanner=new Scanner(System.in);

    @Autowired
    MusicStoreService musicStoreService;

    @Override
    public void run(String... args) throws Exception {
        Customer customer = getCustomer();
        System.out.println(customer);
        List<Artist> artists = getArtists();
        System.out.println(artists);
        List<Track> tracks = getTracks();
        System.out.println(tracks);
        order(customer, tracks);

    }

    private void order(Customer customer, List<Track> tracks) {
        System.out.println("enter track id you want to buy");
        var trackId = scanner.nextInt();
        scanner.nextLine();
        musicStoreService.orderTrack(trackId, tracks, customer);
    }

    private List<Track> getTracks() {
        System.out.println("enter album id");
        var albumId = scanner.nextInt();
        scanner.nextLine();
        var tracks=musicStoreService.getTracksByAlbumId(albumId);
        return tracks;
    }

    private List<Artist> getArtists() {
        System.out.println("enter artist name");
        var name = scanner.nextLine();
        var artists=musicStoreService.getArtistsByName(name);
        return artists;
    }

    private Customer getCustomer() {
        System.out.println("enter id");
        var id = scanner.nextInt();
        scanner.nextLine();
        var customer=musicStoreService.getUser(id);
        return customer;
    }

}

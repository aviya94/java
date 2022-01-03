package com.example.first;

import com.example.first.entity.Album;
import com.example.first.entity.Customer;
import com.example.first.entity.Track;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cglib.core.internal.Function;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

@Setter
@Configuration
@ConfigurationProperties(prefix = "queries")
@Component
public class UI {
    private String idData;
    private String albums;
    private String track;
    private final Scanner scanner = new Scanner(System.in);
    @Autowired
    DatabaseConnector databaseConnector;

    public void run() {
        var user = getUser();
        user.forEach(System.out::println);
       var albums= getAlbums();
       albums.forEach(System.out::println);
        var track= choseAlbum();
        track.forEach(System.out::println);

    }

    private ArrayList<Track> choseAlbum() {
        System.out.println("enter album id:");
        var album = scanner.nextLine();
        Function<ResultSet , Track> function =(rs)-> {
            try {
                var trackId = rs.getInt("trackId");
                var name = rs.getString("name");

                return new Track(trackId,name);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return null;
        };
        var res= databaseConnector.getQueries(track,function,album);
        return res;
    }

    private ArrayList<Album> getAlbums() {
        Function<ResultSet , Album> function =(rs)-> {
            try {
                var albumId = rs.getInt("AlbumId");
                var title = rs.getString("Title");

                return new Album(albumId,title);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return null;
        };
        String[] a=new String[0];
        var res= databaseConnector.getQueries(albums,function,a);
        return res;
    }

    private ArrayList<Customer> getUser() {
        System.out.println("enter id");
        var id = scanner.nextLine();
        Function<ResultSet , Customer> function =(rs)-> {
            try {
                var name = rs.getString("name");
                var email = rs.getString("Email");
                var city = rs.getString("City");

                return new Customer(name, email, city);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return null;
        };
        var res= databaseConnector.getQueries(idData,function,id );
        return res;
    }
}

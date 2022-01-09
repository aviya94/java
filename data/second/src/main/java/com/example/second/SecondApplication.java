package com.example.second;

import com.example.second.data.StoreRepository;
import com.example.second.entity.Customer;
import com.example.second.repo.AlbumRepo;
import com.example.second.repo.CustomerRepo;
import com.example.second.repo.InvoiceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SecondApplication implements CommandLineRunner {
private Scanner scanner=new Scanner(System.in);
    public static void main(String[] args) {
        SpringApplication.run(SecondApplication.class, args);
    }
@Autowired
CustomerRepo customerRepo;
    @Autowired
    AlbumRepo albumRepo;
    @Autowired
    InvoiceRepo invoiceRepo;
    @Override
    public void run(String... args) throws Exception {
        System.out.println("enter id");
        var id = scanner.nextInt();
        scanner.nextLine();
        var res=customerRepo.getUser(id);
        System.out.println(res);
        System.out.println("enter artist name");
        var name = scanner.nextLine();
        var res2=albumRepo.selectArtist(name);
        System.out.println(res2);
        System.out.println("enter album id");
        var albumId = scanner.nextInt();
        var res3=albumRepo.getTracksByAlbumId(albumId);
        System.out.println(res2);
        System.out.println("enter track id you want to buy");
        var track = scanner.nextLine();
        invoiceRepo.creatInvoice("2","1","1","1","2");

    }
}

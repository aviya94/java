package com.experis;

import com.experis.Search.SearchByISBN;
import com.experis.Search.SearchByTitle;

import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.exit;

public class Menue {
    private LoadDatabase loadDatabase;
    private SearchByISBN searchByISBN;
    private SearchByTitle searchByTitle;

    public Menue() {
        loadDatabase = new LoadDatabase("C:\\Users\\user\\books-tons-of.txt");
        searchByISBN = new SearchByISBN(loadDatabase);
        searchByTitle = new SearchByTitle(loadDatabase);
        userChoise();
    }

    public void userChoise() {

        while (true) {
            System.out.println("[1. Search by ISBN]");
            System.out.println("[2. Search by Title]");
            System.out.println("[3. Exit]");
            Scanner scanner = new Scanner(System.in);

            try {
                int choise = scanner.nextInt();

                switch (choise) {
                    case 1: {
                        searchByISBN();
                        searchByISBN.print();
                        break;
                    }

                    case 2: {
                        searchByTitel();
                        searchByTitle.print();
                        break;
                    }

                    case 3: {
                        exit(0);
                    }

                    default: {
                        System.out.println("you need to click 1/2");
                        break;
                    }

                }

            } catch (InputMismatchException e) {
                System.out.println("you need to click only number");
            }
        }

    }

    private void searchByISBN() {
        System.out.println("please eneter ISBN");
        String choice = getChoice();
        searchByISBN.search(choice);
    }

    private void searchByTitel() {
        System.out.println("please eneter titel or partial titel");
        String choice = getChoice();
        searchByTitle.search(choice);
    }

    private String getChoice() {
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        return choice;
    }
}

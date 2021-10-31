package com.experis.start;

import com.experis.Search.SearchByISBN;
import com.experis.Search.SearchByTitle;
import com.experis.dataBase.Book;
import com.experis.dataBase.DataBase;
import com.experis.result.Print;
import com.experis.result.SearchResult;


import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.exit;

public class Menue {

    final private DataBase dataBase;
    private SearchByISBN searchByISBN;
    private SearchByTitle searchByTitle;


    public Menue(DataBase dataBase, ArrayList<String> ignorList) throws IOException {
        this.dataBase = dataBase;
        searchByISBN = new SearchByISBN(dataBase);
        searchByTitle = new SearchByTitle(dataBase, ignorList);
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
                        break;
                    }

                    case 2: {
                        searchByTitel();
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

    public void print(Book searchResult) {
        String resultString = SearchResult.result(searchResult, dataBase);

        print(resultString);
    }

    public void print(ArrayList<Book> searchResult) {
        String resultString = SearchResult.result(searchResult, dataBase);

        print(resultString);
    }

    private void print(String resultString) {

        if (resultString == null) {
            Print.print("not found books");
        } else {
            Print.print(resultString);
        }
    }

    private void searchByISBN() {
        System.out.println("please eneter ISBN");
        String choice = getChoice();
        searchByISBN.search(choice);
        print(searchByISBN.searchResult);
    }

    private void searchByTitel() {
        System.out.println("please eneter titel or partial titel");
        String choice = getChoice();
        searchByTitle.search(choice);
        print(searchByTitle.searchResult);
    }

    private String getChoice() {
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        return choice;
    }

}

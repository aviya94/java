package com.aviya.exchnage;
import java.util.Scanner;

public class Ui {
    private Scanner scanner = new Scanner(System.in);
    private Manager manager;

    public void runUi() {
        Boolean isOk = false;
        System.out.println(" Israel Bank or Europe bank");
        System.out.println("enter ILS OR EUR");

        while (isOk == false) {
            var value = scanner.nextLine();

            switch (value) {
                case "ILS" -> {
                    manager = new Manager("ILS");
                    isOk = true;
                    break;
                }
                case "EUR" -> {
                    manager = new Manager("EUR");
                    isOk = true;
                    break;
                }
                default -> {
                    System.out.println("Invalid string, try again");
                    break;
                }

            }
        }
        while (true) {
            System.out.println("enter from currency");
            var from = scanner.nextLine();
            System.out.println("enter to currency");
            var to = scanner.nextLine();
            System.out.println("enter amount");
            var amount = scanner.nextBigDecimal();
            manager.convert(from, to, amount);

        }

    }
}

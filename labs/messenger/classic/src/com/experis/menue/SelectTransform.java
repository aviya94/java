package com.experis.menue;

import com.experis.Transformation.CaesarEncryption;
import com.experis.Transformation.Censor;
import com.experis.Transformation.Transform;
import com.experis.Transformation.UpperCase;

import java.util.Scanner;
import java.util.function.Predicate;

public class SelectTransform {
    /*
    private Predicate<String> condition;
    private String massge;

    public SelectTransform(Predicate<String> condition,String massge) {
        this.condition = condition;
        this.massge=massge;
    }

    private Transform[] selectTransform() {
        Transform[] trans = new Transform[2];
        System.out.println("select 2 transfor:");
        System.out.println("1. clear");
        System.out.println("2.uppercase");
        System.out.println("3. Caesar encryption");
        System.out.println("4. Censor");
        Scanner scanner = new Scanner(System.in);
        try {
            for (int i = 0; i < 2; i++) {
                int select = scanner.nextInt();
                switch (select) {
                    case 1: {
                        break;
                    }
                    case 2: {
                        uppercase();
                        break;
                    }
                    case 3: {
                        encryption();
                        break;
                    }
                    case 4: {
                        Censor();
                        break;
                    }
                    default: {
                        System.out.println("you need enter only 1/2/3");
                    }
                }

            }
        } catch (IllegalArgumentException e) {
            System.out.println("you need enter only number");
        }
        return trans;
    }

    private String Censor() {
        Censor censor = new Censor(condition);
        return censor.transforn(massge);
    }

    private String encryption() {
        CaesarEncryption caesarEncryption = new CaesarEncryption();
        return caesarEncryption.transforn(massge);
    }

    private String uppercase() {
        UpperCase upperCase = new UpperCase();
        return upperCase.transforn(massge);
    }

     */
}

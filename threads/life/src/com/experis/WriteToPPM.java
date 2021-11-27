package com.experis;

import java.io.*;

public class WriteToPPM {
    private final String imageDir = "./resources/";
    private static int counter = 0;
    String fileName;
    DataOutputStream out;

    public WriteToPPM(int[][] mat) {
        counter++;
        try {
            fileName=imageDir +"gen-"+ counter + ".ppm";
            FileOutputStream file = new FileOutputStream(fileName);
            out = new DataOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        write(mat);

    }

    private void write(int[][] mat) {
        try {
            out.writeChars("p1");
            out.writeChars("#game Of Life");
            out.writeChars(mat.length+" "+ mat[0].length);


            for (int i=0; i<mat.length; i++) {
                for(int j=0; j<mat[0].length; j++) {
                    out.write(mat[i][j]);
                }
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

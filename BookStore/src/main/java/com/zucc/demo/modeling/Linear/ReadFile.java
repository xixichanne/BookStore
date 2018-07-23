package com.zucc.demo.modeling.Linear;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {

    public double[][] readFile(int rowCount, String fileName) {
        double[][] user_movie = new double[100000][4];

        try {
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            int i = 0;
            while (br.ready()) {
                line = br.readLine();
//                String[] data = line.split("\t");
                String[] data = line.split(",");
                for (int j = 0; j < data.length-1; j++) {
                    user_movie[i][j] = Double.parseDouble(data[j]);
                }
                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*return preference;*/
        return user_movie;

    }

    public double[] readFile2(int rowCount, String fileName) {
        double[] user_movie = new double[100000];

        try {
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            int i = 0;
            while (br.ready()) {
                line = br.readLine();
                String[] data = line.split(",");
                for (int j = 0; j < data.length; j++) {
                    user_movie[i] = Double.parseDouble(data[3]);
                }
                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*return preference;*/
        return user_movie;

    }

}

package com.zucc.demo.modeling;

import java.util.List;

public class CsvAvg {
    private CsvUtil csvUtil = new CsvUtil();
    private static String finaltrainFilePath = "D:\\个人资料\\桌面\\data\\ratings_train.csv";

    public static void main(String args[]) throws Exception {
        CsvAvg c = new CsvAvg();
        System.out.println(c.csvAvg(finaltrainFilePath, 0, 269284));
        if(c.csvAvg(finaltrainFilePath, 0, 269284)==-1){
            System.out.println("aaa");
        }
    }

    public float csvAvg(String csvFilePath, int col, int id) {
        List<String[]> strlist = csvUtil.readCSV(csvFilePath, col, id);
        if(strlist.size()==0)
            return -1;

        float avg = 0;
        // 遍历
        for (int row = 0; row < strlist.size(); row++) {
            // 取得第row行第0列的数据
            int value = Integer.parseInt(strlist.get(row)[2]);
            avg += value;
        }
        avg = avg / strlist.size();
        return avg;
    }

    public float csvAvg(String csvFilePath) {
        List<String[]> strlist = csvUtil.readCSV(csvFilePath);
        float avg = 0;
        // 遍历
        for (int row = 0; row < strlist.size(); row++) {
            // 取得第row行第0列的数据
            int value = Integer.parseInt(strlist.get(row)[2]);
            avg += value;
        }
        avg = avg / strlist.size();
        return avg;
    }

    public float csvAvg(String csvFilePath, int col0, int userid, int col1, int bookid) {
        List<String[]> strlist = csvUtil.readCSV(csvFilePath, col0, userid);
        List<String[]> strlist1 = csvUtil.readCSV(csvFilePath, col1, bookid);
        strlist.addAll(strlist1);
        if(strlist.size()==0)
            return -1;

        float avg = 0;
        // 遍历
        for (int row = 0; row < strlist.size(); row++) {
            // 取得第row行第0列的数据
            int value = Integer.parseInt(strlist.get(row)[2]);
            avg += value;
        }
        avg = avg / strlist.size();
        return avg;
    }
}

package com.zucc.demo.modeling;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class CsvUtil {

    public static void main(String args[]) throws Exception {

//        String[] str={"aaa","bbb"};
//        String[] str1={"aad","bbb"};
//        List<String[]> list=new ArrayList<>();
//        list.add(str1);
//        list.add(str);
//        writeCSV1(list, "D:\\个人资料\\桌面\\data\\abc.csv");

        List<String[]> result = readCSV("D:\\个人资料\\桌面\\data\\abc.csv");
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i)[0]);
        }
    }


    public static void writeCSV(int userid, List<RecommendedItem> recommendations, String csvFilePath) {
        try {
            // 创建CSV写对象 例如:CsvWriter(文件路径，分隔符，编码格式);
            CsvWriter csvWriter = new CsvWriter(csvFilePath, ',', Charset.forName("UTF-8"));
            // 写表头
//            String[] csvHeaders = {"userid", "bookid", "recommendscore"};
//            csvWriter.writeRecord(csvHeaders);
            // 写内容
            for (RecommendedItem recommendation : recommendations) {
                String[] csvContent = {userid + "", "" + recommendation.getItemID(), "" + recommendation.getValue()};
                csvWriter.writeRecord(csvContent);
            }
            csvWriter.close();
            System.out.println(csvFilePath + "文件已写入--------");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeCSV(List<String[]> list, String csvFilePath) {
        try {
            // 创建CSV写对象 例如:CsvWriter(文件路径，分隔符，编码格式);
            CsvWriter csvWriter = new CsvWriter(csvFilePath, ',', Charset.forName("UTF-8"));
            // 写表头
//            String[] csvHeaders = {"userid", "bookid", "rating"};
//            csvWriter.writeRecord(csvHeaders);
            // 写内容
            for (int i = 0; i < list.size(); i++) {
                String[] csvContent = new String[list.get(i).length];
                for (int j = 0; j < list.get(i).length; j++) {
                    csvContent[j] = list.get(i)[j];
                }
//                 {list.get(i)[0], list.get(i)[1], list.get(i)[2]};
                csvWriter.writeRecord(csvContent);
            }
            csvWriter.close();
            System.out.println(csvFilePath + "文件已写入--------");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static List<String[]> readCSV(String csvFilePath) {
        List<String[]> list = new ArrayList<>();
        try {
            // 用来保存数据
            ArrayList<String[]> csvFileList = new ArrayList<String[]>();
            // 创建CSV读对象 例如:CsvReader(文件路径，分隔符，编码格式);
            CsvReader reader = new CsvReader(csvFilePath, ',', Charset.forName("UTF-8"));
            // 逐行读入数据
            while (reader.readRecord()) {
                csvFileList.add(reader.getValues());
            }
            reader.close();
            // 遍历读取的CSV文件
            for (int row = 0; row < csvFileList.size(); row++) {
                String[] csvContent = new String[csvFileList.get(row).length];
                for (int j = 0; j < csvFileList.get(row).length; j++) {
                    csvContent[j] = csvFileList.get(row)[j];
                }
//                String[] csvContent = {csvFileList.get(row)[0], csvFileList.get(row)[1], csvFileList.get(row)[2]};
                list.add(csvContent);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List<String[]> readCSV(String csvFilePath, int col, int id) {
        List<String[]> list = new ArrayList<>();
        try {
            // 用来保存数据
            ArrayList<String[]> csvFileList = new ArrayList<String[]>();
            // 创建CSV读对象 例如:CsvReader(文件路径，分隔符，编码格式);
            CsvReader reader = new CsvReader(csvFilePath, ',', Charset.forName("UTF-8"));
            // 跳过表头 如果需要表头的话，这句可以忽略
//            reader.readHeaders();
            // 逐行读入除表头的数据
            while (reader.readRecord()) {
//                System.out.println(reader.getRawRecord());
                csvFileList.add(reader.getValues());
            }
            reader.close();

            // 遍历读取的CSV文件
            for (int row = 0; row < csvFileList.size(); row++) {
                // 取得第row行第0列的数据
                String cell = csvFileList.get(row)[col];
                int value = Integer.parseInt(cell);
                if (id == value) {
                    String[] csvContent = new String[csvFileList.get(row).length];
                    for (int j = 0; j < csvFileList.get(row).length; j++) {
                        csvContent[j] = csvFileList.get(row)[j];
                    }
//                    String[] csvContent = {csvFileList.get(row)[0], csvFileList.get(row)[1], csvFileList.get(row)[2]};
                    list.add(csvContent);
                }
            }
//            System.out.println(csvFilePath+"文件已读入--------" );
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }


    public static String[] read(String csvFilePath, int col, int id) {
        try {
            // 用来保存数据
            ArrayList<String[]> csvFileList = new ArrayList<String[]>();
            // 创建CSV读对象 例如:CsvReader(文件路径，分隔符，编码格式);
            CsvReader reader = new CsvReader(csvFilePath, ',', Charset.forName("UTF-8"));
            // 跳过表头 如果需要表头的话，这句可以忽略
//            reader.readHeaders();
            // 逐行读入除表头的数据
            while (reader.readRecord()) {
//                System.out.println(reader.getRawRecord());
                csvFileList.add(reader.getValues());
            }
            reader.close();

//            String[] csvContent=new String[3];

            // 遍历读取的CSV文件
            for (int row = 0; row < csvFileList.size(); row++) {
                // 取得第row行第0列的数据
                String cell = csvFileList.get(row)[col];
                int value = Integer.parseInt(cell);
                if (id == value) {
                    String[] csvContent = new String[csvFileList.get(row).length];
                    for (int j = 0; j < csvFileList.get(row).length; j++) {
                        csvContent[j] = csvFileList.get(row)[j];
                    }
//                    String[] csvContent = {csvFileList.get(row)[0], csvFileList.get(row)[1], csvFileList.get(row)[2]};
                    return csvContent;
                }
            }
//            System.out.println("------read--->" );
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }



}

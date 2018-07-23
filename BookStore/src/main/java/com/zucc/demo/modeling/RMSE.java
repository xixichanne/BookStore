package com.zucc.demo.modeling;

import java.util.ArrayList;
import java.util.List;

public class RMSE {
    private CsvUtil csvUtil = new CsvUtil();
    private static int userid = 3363;
    private static String testFilePath = "D:\\个人资料\\桌面\\data\\test.csv";

    private static String resultFilePath = "D:\\个人资料\\桌面\\data\\result_uiskr.csv";
    private static String finalresultFilePath = "D:\\个人资料\\桌面\\data\\final.csv";


    public static void main(String args[]) throws Exception {
        RMSE rmse = new RMSE();
        rmse.RSME1(finalresultFilePath);

    }

    public void RSME(int userid, String filePath) {
        List<String[]> result = csvUtil.readCSV(testFilePath, 0, userid);//测试集里用户为userid 读过的书

        List<Double> dif = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            int bookid = Integer.parseInt(result.get(i)[1]);//每本书
            int rating = Integer.parseInt(result.get(i)[2]);//真实评分
//            System.out.println("bookid:"+bookid);
//            System.out.println("rating:"+rating);

            String[] str = csvUtil.read(filePath, 1, bookid);
            if (str != null) {
                double recommend = Double.parseDouble(str[2]);//推荐评分
                dif.add(rating - recommend);
            }
        }
        double RSME = 0;
        for (int j = 0; j < dif.size(); j++) {
            RSME += Math.pow(dif.get(j), 2);//平方求和
        }
        RSME = Math.sqrt(RSME / dif.size());
        System.out.println("RSME:" + RSME);
    }


    public void RSME(String filePath) {
        List<String[]> result = csvUtil.readCSV(filePath);

        List<Float> dif = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            float rating_real = Float.parseFloat(result.get(i)[4]);//真实评分
            float rating_recommend = Float.parseFloat(result.get(i)[3]);//推荐评分
            dif.add(rating_real - rating_recommend);
        }
        double RSME = 0;
        for (int j = 0; j < dif.size(); j++) {
            RSME += Math.pow(dif.get(j), 2);//平方求和
        }
        RSME = Math.sqrt(RSME / dif.size());
        System.out.println("RSME:" + RSME);
    }

    public void RSME1(String filePath) {
        List<String[]> result = csvUtil.readCSV(filePath);

        List<Float> dif = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            float rating_real = Float.parseFloat(result.get(i)[3]);//真实评分

            float rating_recommend = (float)0.6297266495395023 * Float.parseFloat(result.get(i)[0])
                    + (float) 0.2998168673911683 * Float.parseFloat(result.get(i)[1])
                    + (float) 0.04006363088028275 * Float.parseFloat(result.get(i)[2]) + (float) 0.02651877464796408;
            dif.add(rating_real - (float) rating_recommend);
        }
        double RSME = 0;
        for (int j = 0; j < dif.size(); j++) {
            RSME += Math.pow(dif.get(j), 2);//平方求和
        }
        RSME = Math.sqrt(RSME / dif.size());
        System.out.println("RSME:" + RSME);
    }

}

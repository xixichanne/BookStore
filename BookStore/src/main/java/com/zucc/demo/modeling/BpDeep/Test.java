package com.zucc.demo.modeling.BpDeep;

import com.zucc.demo.modeling.CsvUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Test {

    private CsvUtil csvUtil = new CsvUtil();

    private static String resultFilePath = "D:\\个人资料\\桌面\\data\\result_uiskr.csv";
    private static String finalresultFilePath = "D:\\个人资料\\桌面\\data\\final.csv";


    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        Test test = new Test();
        test.Test();
    }


    public void Test() throws IOException {


        Bp bp = new Bp(3, 15, 10, 0.05);

        Random random = new Random();

        List<String[]> list = csvUtil.readCSV(finalresultFilePath);

        double[][] data = new double[list.size()][3];
        for (int i = 0; i < data.length; i++) {
            for (int i1 = 0; i1 < 3; i1++) {
                data[i][i1] = Double.parseDouble(list.get(i)[i1]);
            }
        }

        //设置目标数据，对应4个坐标数据的分类
        double[] target = new double[list.size()];
        for (int j = 0; j < target.length; j++) {
            target[j] = Double.parseDouble(list.get(j)[3]);
        }

        //迭代训练100次
        for (int n = 0; n < 1000; n++) {
            System.out.println(n);
            for (int i = 0; i < data.length; i++) {
                bp.train(data[i], target);
            }
        }

    }


    public void BpTest() throws IOException {

        Bp bp = new Bp(32, 15, 4, 0.05);

        Random random = new Random();

        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i != 6000; i++) {
            int value = random.nextInt();
            list.add(value);
        }

        for (int i = 0; i != 25; i++) {
            for (int value : list) {
                double[] real = new double[4];
                if (value >= 0)
                    if ((value & 1) == 1)
                        real[0] = 1;
                    else
                        real[1] = 1;
                else if ((value & 1) == 1)
                    real[2] = 1;
                else
                    real[3] = 1;

                double[] binary = new double[32];
                int index = 31;
                do {
                    binary[index--] = (value & 1);
                    value >>>= 1;
                } while (value != 0);

                bp.train(binary, real);


            }
        }


        System.out.println("训练完毕，下面请输入一个任意数字，神经网络将自动判断它是正数还是复数，奇数还是偶数。");

        while (true) {

            byte[] input = new byte[10];
            System.in.read(input);
            Integer value = Integer.parseInt(new String(input).trim());
            int rawVal = value;
            double[] binary = new double[32];
            int index = 31;
            do {
                binary[index--] = (value & 1);
                value >>>= 1;
            } while (value != 0);

            double[] result = new double[4];
            bp.predict(binary, result);


            double max = -Integer.MIN_VALUE;
            int idx = -1;

            for (int i = 0; i != result.length; i++) {
                if (result[i] > max) {
                    max = result[i];
                    idx = i;
                }
            }

            switch (idx) {
                case 0:
                    System.out.format("%d是一个正奇数\n", rawVal);
                    break;
                case 1:
                    System.out.format("%d是一个正偶数\n", rawVal);
                    break;
                case 2:
                    System.out.format("%d是一个负奇数\n", rawVal);
                    break;
                case 3:
                    System.out.format("%d是一个负偶数\n", rawVal);
                    break;
            }
        }
    }
}
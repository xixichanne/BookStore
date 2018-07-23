package com.zucc.demo.modeling.BpDeep;

import com.zucc.demo.modeling.CsvUtil;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BpDeepTest {

    private CsvUtil csvUtil = new CsvUtil();

    private static String finalresultFilePath = "D:\\个人资料\\桌面\\data\\final.csv";


    public static void main(String[] args) {
        BpDeepTest bpDeepTest = new BpDeepTest();
        bpDeepTest.Test();
//        bpDeepTest.bpTest();
    }

    public void Test() {
        //初始化神经网络的基本配置
        //第一个参数是一个整型数组，表示神经网络的层数和每层节点数，比如{3,10,10,10,10,2}表示输入层是3个节点，输出层是2个节点，中间有4层隐含层，每层10个节点
        //第二个参数是学习步长
        //第三个参数是动量系数
        BpDeep bp = new BpDeep(new int[]{3, 10, 10, 10, 10, 1}, 0.001, 0.1);

        List<String[]> list = csvUtil.readCSV(finalresultFilePath);

        double[][] data = new double[list.size()][3];
        for (int i = 0; i < data.length; i++) {
            for (int i1 = 0; i1 < 3; i1++) {
                data[i][i1] = Double.parseDouble(list.get(i)[i1]);
            }
        }

        //设置目标数据，对应4个坐标数据的分类
        double[][] target = new double[list.size()][1];
        for (int j = 0; j < target.length; j++) {
            target[j][0] = Double.parseDouble(list.get(j)[3]);
        }

        //迭代训练100次
        for (int n = 0; n < 100; n++) {
            System.out.println(n);
            for (int i = 0; i < data.length; i++) {
                bp.train(data[i], target[i]);
            }
        }

        List<Float> dif = new ArrayList<>();
        //根据训练结果来检验样本数据
        for (int j = 0; j < data.length; j++) {
            double[] result = bp.computeOut(data[j]);
//            DecimalFormat df = new DecimalFormat("#.00");
//            String str = df.format(result[0]);
//            System.out.println(str);
            System.out.println(Arrays.toString(data[j]) + ":" + Arrays.toString(result));
            dif.add((float) (target[j][0] - result[0]));
        }

        double RSME = 0;
        for (int j = 0; j < dif.size(); j++) {
            RSME += Math.pow(dif.get(j), 2);//平方求和
        }
        RSME = Math.sqrt(RSME / dif.size());
        System.out.println("RSME:" + RSME);

    }

    public void bpTest() {
        //初始化神经网络的基本配置
        //第一个参数是一个整型数组，表示神经网络的层数和每层节点数，比如{3,10,10,10,10,2}表示输入层是3个节点，输出层是2个节点，中间有4层隐含层，每层10个节点
        //第二个参数是学习步长
        //第三个参数是动量系数
        BpDeep bp = new BpDeep(new int[]{2, 10, 2}, 0.15, 0.8);

        //设置样本数据，对应上面的4个二维坐标数据
        double[][] data = new double[][]{{1, 2}, {2, 2}, {1, 1}, {2, 1}};
        //设置目标数据，对应4个坐标数据的分类
        double[][] target = new double[][]{{1, 0}, {0, 1}, {0, 1}, {1, 0}};

        //迭代训练5000次
        for (int n = 0; n < 100; n++)
            for (int i = 0; i < data.length; i++)
                bp.train(data[i], target[i]);

        //根据训练结果来检验样本数据
        for (int j = 0; j < data.length; j++) {
            double[] result = bp.computeOut(data[j]);
            System.out.println(Arrays.toString(data[j]) + ":" + Arrays.toString(result));
        }

        //根据训练结果来预测一条新数据的分类
        double[] x = new double[]{3, 1};
        double[] result = bp.computeOut(x);
        System.out.println(Arrays.toString(x) + ":" + Arrays.toString(result));
    }


}

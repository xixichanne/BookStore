package com.zucc.demo.modeling.Old;

import java.io.*;
import java.util.*;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.file.*;
import org.apache.mahout.cf.taste.impl.neighborhood.*;
import org.apache.mahout.cf.taste.impl.recommender.*;
import org.apache.mahout.cf.taste.impl.recommender.slopeone.SlopeOneRecommender;
import org.apache.mahout.cf.taste.impl.similarity.*;
import org.apache.mahout.cf.taste.model.*;
import org.apache.mahout.cf.taste.neighborhood.*;
import org.apache.mahout.cf.taste.recommender.*;
import org.apache.mahout.cf.taste.similarity.*;


public class MahoutDemo {
    // private TestMahout(){};

    public static void main(String args[]) throws Exception {

        MahoutDemo testMahout = new MahoutDemo();
        System.out.println("The baseUserCF Result:");
        testMahout.baseUserCF();
        System.out.println("The baseItemCF Result:");
        testMahout.baseItemCF();
        System.out.println("The baseSlopOne Result:");
        testMahout.baseSlopOne();
    }

    //基于用户相似度的协同过滤推荐实现
    public void baseUserCF() {
        try {
            // 1,构建模型
            DataModel dataModel = new FileDataModel(new File("D:\\个人资料\\桌面\\data\\train.csv"));
            //2,计算相似度
            UserSimilarity userSimilarity = new PearsonCorrelationSimilarity(dataModel);
            //3,查找K近邻
            UserNeighborhood userNeighborhood = new NearestNUserNeighborhood(2, userSimilarity, dataModel);
            //4,构造推荐引擎
            Recommender recommender = new GenericUserBasedRecommender(dataModel, userNeighborhood, userSimilarity);
            //为用户i推荐2个item
            for (int i = 2; i < 8; i++) {
                System.out.println("recommand for user:" + i);
                List<RecommendedItem> recommendations = recommender.recommend(i, 2);
                for (RecommendedItem recommendation : recommendations) {
                    System.out.println(recommendation);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TasteException e) {
            e.printStackTrace();
        }
    }

    //基于内容相似度的协同过滤推荐实现
    public void baseItemCF() {
        DataModel model;
        try {
            model = new FileDataModel(new File("D:\\个人资料\\桌面\\data\\train.csv"));
            ItemSimilarity itemsimilarity = new PearsonCorrelationSimilarity(model);
            Recommender recommender = new GenericItemBasedRecommender(model, itemsimilarity);
            List<RecommendedItem> recommendations = recommender.recommend(8, 4);
            for (RecommendedItem recommendation : recommendations) {
                System.out.println(recommendation);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (TasteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    //基于SlopOne的推荐实现
    public void baseSlopOne() {
        DataModel model;
        try {
            model = new FileDataModel(new File("D:\\个人资料\\桌面\\data\\train.csv"));
            Recommender recommender = new SlopeOneRecommender(model);
            List<RecommendedItem> recommendations = recommender.recommend(8, 4);
            for (RecommendedItem recommendation : recommendations) {
                System.out.println(recommendation);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("Io Error");
            e.printStackTrace();
        } catch (TasteException e) {
            // TODO Auto-generated catch block
            System.out.println("Taste Error");
            e.printStackTrace();
        }

    }

}
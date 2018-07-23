package com.zucc.demo.modeling.Old;

import com.zucc.demo.modeling.CsvUtil;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.recommender.slopeone.SlopeOneRecommender;
import org.apache.mahout.cf.taste.impl.similarity.EuclideanDistanceSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Mahout_User {

    private CsvUtil csvUtil = new CsvUtil();

    private static int userid = 3363;
    private static int K_userCF = 100;
    private static int BOOK_RECOMMEND_NUM = 100;//给用户推荐的数量

    private static String trainFilePath = "D:\\个人资料\\桌面\\data\\train.csv";

    private static String userCFFilePath = "D:\\个人资料\\桌面\\data\\" + userid + "_UserCF.csv";
    private static String itemCFFilePath = "D:\\个人资料\\桌面\\data\\" + userid + "_ItemCF.csv";
    private static String slopOneFilePath = "D:\\个人资料\\桌面\\data\\" + userid + "_SlopOne.csv";

    private static String dataFilePath = "D:\\个人资料\\桌面\\data\\" + userid + "_data.csv";

    public static void main(String args[]) throws Exception {

        Mahout_User testMahout = new Mahout_User();

        //用户
        System.out.println("The baseUserCF Result:");
        testMahout.baseUserCF(userid);

        //物品
        System.out.println("The baseItemCF Result:");
        testMahout.baseItemCF(userid);

        //SlopOne
        System.out.println("The baseSlopOne Result:");
        testMahout.baseSlopOne(userid);

    }

    //基于用户相似度的协同过滤推荐实现
    public void baseUserCF(int userid) {
        try {


         /*   //(1)----连接数据库部分
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setServerName("localhost");
            dataSource.setUser("root");
            dataSource.setPassword("123456");
            dataSource.setDatabaseName("bx");
            //(2)----使用MySQLJDBCDataModel数据源读取MySQL里的数据
            JDBCDataModel dataModel = new MySQLJDBCDataModel(dataSource, "table1", "userId", "itemId", "preference", "date");
*/


            // 1,构建模型
            DataModel dataModel = new FileDataModel(new File(trainFilePath));
            //2,计算相似度
//            UserSimilarity userSimilarity = new PearsonCorrelationSimilarity(dataModel);//皮尔逊距离
            UserSimilarity userSimilarity = new EuclideanDistanceSimilarity(dataModel);//欧氏距离
            //3,查找K近邻
            UserNeighborhood userNeighborhood = new NearestNUserNeighborhood(K_userCF, userSimilarity, dataModel);
            //4,构造推荐引擎
            Recommender recommender = new GenericUserBasedRecommender(dataModel, userNeighborhood, userSimilarity);

            //为用户userid推荐BOOK_FOR_YOU_NUM个item
            System.out.println("recommand for user:" + userid);
            List<RecommendedItem> recommendations = recommender.recommend(userid, BOOK_RECOMMEND_NUM);
            csvUtil.writeCSV(userid, recommendations, userCFFilePath);

            //用户对推荐的一百本书的模拟分
            List<String[]> result = new ArrayList<>();
            for (RecommendedItem recommendation : recommendations) {
                List<String[]> list = csvUtil.readCSV(trainFilePath, 1, (int) recommendation.getItemID());//每本书的所有评分
                result.addAll(list);
                System.out.println(recommendation);
            }
            //所有人对给用户推荐的一百本书的评分
            csvUtil.writeCSV(result, "D:\\个人资料\\桌面\\data\\" + userid + "_1.csv");

            List<String[]> result1 = csvUtil.readCSV(trainFilePath, 0, userid);//用户读过的书单
//            List<String[]> result2 = new ArrayList<>();
            for (int i = 0; i < result1.size(); i++) {
                int bookid = Integer.parseInt(result1.get(i)[1]);//每本书
                List<String[]> list1 = csvUtil.readCSV(trainFilePath, 1, bookid);//每本书的所有评分
                result.addAll(list1);//所有人对该用户读过的书的评分
            }

            //所有人对给用户推荐的一百本书的评分（除该用户）+所有人对该用户读过的书的评分（含该用户）
//            result.addAll(result2);
            csvUtil.writeCSV(result, dataFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TasteException e) {
            e.printStackTrace();
        }
    }

    //基于物品相似度的协同过滤推荐实现
    public void baseItemCF(int userid) {
        try {
            //数据模型
            DataModel model = new FileDataModel(new File(dataFilePath));
            //书籍相似度
            ItemSimilarity itemsimilarity = new EuclideanDistanceSimilarity(model);
            //物品推荐算法
            Recommender recommender = new GenericItemBasedRecommender(model, itemsimilarity);
            //计算得出推荐结果
            List<RecommendedItem> recommendations = recommender.recommend(userid, BOOK_RECOMMEND_NUM);
            csvUtil.writeCSV(userid, recommendations, itemCFFilePath);
//            List<String[]> result = new ArrayList<>();
            for (RecommendedItem recommendation : recommendations) {
//                List<String[]> list = readCSV(trainFilePath, 1, (int) recommendation.getItemID());//每本书的所有评分
//                result.addAll(list);
                System.out.println(recommendation);
            }
//            //给用户推荐的一百本书的其他人的评分
//            csvUtil.writeCSV1(result, "D:\\个人资料\\桌面\\data\\" + userid + "_1.csvUtil");
//
//            List<String[]> result1 = csvUtil.readCSV(trainFilePath, 0, userid);//用户读过的书单
//            List<String[]> result2 = new ArrayList<>();
//            for (int i = 0; i < result1.size(); i++) {
//                int bookid = Integer.parseInt(result1.get(i)[1]);//每本书
//                System.out.println(bookid);
//                List<String[]> list1 = csvUtil.readCSV(trainFilePath, 1, bookid);//每本书的所有评分
//                result2.addAll(list1);
//            }
//            result2.addAll(result);
//            //给用户推荐的一百本书的其他人的评分+该用户读过的书的所有人对他的评分
//            csvUtil.writeCSV1(result2, "D:\\个人资料\\桌面\\data\\" + userid + "_2.csvUtil");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (TasteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    //基于SlopOne的推荐实现
    public void baseSlopOne(int userid) {
        DataModel model;
        try {
            model = new FileDataModel(new File(dataFilePath));
            Recommender recommender = new SlopeOneRecommender(model);
            List<RecommendedItem> recommendations = recommender.recommend(userid, BOOK_RECOMMEND_NUM);
            csvUtil.writeCSV(userid, recommendations, slopOneFilePath);
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
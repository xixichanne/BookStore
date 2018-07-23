package com.zucc.demo.modeling;

import com.csvreader.CsvWriter;
import com.zucc.demo.dao.UserDAOImpl;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.recommender.knn.KnnItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.recommender.knn.NonNegativeQuadraticOptimizer;
import org.apache.mahout.cf.taste.impl.recommender.slopeone.SlopeOneRecommender;
import org.apache.mahout.cf.taste.impl.recommender.svd.ALSWRFactorizer;
import org.apache.mahout.cf.taste.impl.recommender.svd.SVDRecommender;
import org.apache.mahout.cf.taste.impl.similarity.EuclideanDistanceSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.lang.Float;

public class Mahout_System {

    private CsvUtil csvUtil = new CsvUtil();
    private CsvAvg csvAvg = new CsvAvg();
    private static int K_userCF = 10;
    private static int neighbor = 10;
    private static int BOOK_RECOMMEND_NUM = 100;//给用户推荐的数量

    private static String trainFilePath = "D:\\个人资料\\桌面\\data\\train_new.csv";
    private static String testFilePath = "D:\\个人资料\\桌面\\data\\test_new.csv";

    private static String resultFilePath = "D:\\个人资料\\桌面\\data\\result.csv";

    private static String finaltrainFilePath = "D:\\个人资料\\桌面\\data\\ratings_itemid.csv";
    private static String finaltestFilePath = "D:\\个人资料\\桌面\\data\\test_ratings_itemid.csv";
    private static String finalmodelFilePath = "D:\\个人资料\\桌面\\data\\test_ratings_itemid_model.csv";
    private static String finalpredictFilePath = "D:\\个人资料\\桌面\\data\\test_ratings_itemid_predict.csv";

    public static void main(String args[]) throws Exception {
        Mahout_System testMahout = new Mahout_System();
//        testMahout.recommend4(finaltestFilePath);
        testMahout.result(finalpredictFilePath);
    }

    public void recommend(String filePath) throws Exception {
        List<String[]> list = csvUtil.readCSV(filePath);
//        List<Recommend> recommendList = new ArrayList<>();
        List<String[]> recommendList = new ArrayList<>();
        try {
            for (int i = 0; i < list.size(); i++) {
                int userid = Integer.parseInt(list.get(i)[0]);
                int bookid = Integer.parseInt(list.get(i)[1]);
                float rating_real = Float.parseFloat(list.get(i)[2]);
//                Recommend r = new Recommend();
//                r.setUserid(userid);
//                r.setBookid(bookid);
//                r.setRating_real(rating_real);

                // 1,构建模型
                DataModel dataModel = new FileDataModel(new File(trainFilePath));
                //2,计算相似度
                UserSimilarity userSimilarity = new EuclideanDistanceSimilarity(dataModel);
                //3,查找K近邻
                UserNeighborhood userNeighborhood = new NearestNUserNeighborhood(K_userCF, userSimilarity, dataModel);
                //4,构造推荐引擎
                Recommender recommender_user = new GenericUserBasedRecommender(dataModel, userNeighborhood, userSimilarity);
                //5,得到推荐评分
                float rating_userCF = recommender_user.estimatePreference(userid, bookid);
//                r.setRating_userCF(rating_userCF);

                List<RecommendedItem> recommendations = recommender_user.recommend(userid, BOOK_RECOMMEND_NUM);
                String recommendFilePath = "D:\\个人资料\\桌面\\data\\" + userid + "_recommend.csv";

                List<String[]> result = new ArrayList<>();

                for (RecommendedItem recommendation : recommendations) {
                    List<String[]> list1 = csvUtil.readCSV(trainFilePath, 1, (int) recommendation.getItemID());//每本书的所有评分
                    result.addAll(list1);
//                    System.out.println(recommendation);
                }
                //所有人对给用户推荐的一百本书的评分

                List<String[]> result1 = csvUtil.readCSV(trainFilePath, 0, userid);//用户读过的书单
                for (i = 0; i < result1.size(); i++) {
                    int book_id = Integer.parseInt(result1.get(i)[1]);//每本书
                    List<String[]> list2 = csvUtil.readCSV(trainFilePath, 1, book_id);//每本书的所有评分
                    result.addAll(list2);//所有人对该用户读过的书的评分
                }

                List<String[]> list3 = csvUtil.readCSV(trainFilePath, 1, bookid);
                result.addAll(list3);
                //所有人对给用户推荐的一百本书的评分（除该用户）+所有人对该用户读过的书的评分（含该用户）
                csvUtil.writeCSV(result, recommendFilePath);


                //数据模型
                DataModel model = new FileDataModel(new File(recommendFilePath));
                //物品相似度
                ItemSimilarity itemsimilarity = new EuclideanDistanceSimilarity(model);
                //物品推荐算法
                Recommender recommender_item = new GenericItemBasedRecommender(model, itemsimilarity);
                float rating_itemCF = recommender_item.estimatePreference(userid, bookid);
//                r.setRating_itemCF(rating_itemCF);

                //SlopOne推荐算法
                Recommender recommender_slopone = new SlopeOneRecommender(model);
                float rating_slopone = recommender_slopone.estimatePreference(userid, bookid);
//                r.setRating_slopOne(rating_slopone);

                UserDAOImpl user = new UserDAOImpl();
//                if (!user.readUser(userid).getAge().equals("NULL")) {
//                    r.setAge(Integer.parseInt(user.readUser(userid).getAge()));
//                }

                String[] str = {"" + userid, "" + bookid, "" + user.readUser(userid).getAge(),
                        "" + rating_userCF, "" + rating_itemCF, "" + rating_slopone, "" + rating_real};
                recommendList.add(str);
            }
            csvUtil.writeCSV(recommendList, resultFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TasteException e) {
            e.printStackTrace();
        }
    }

    public void recommend1(String filePath) throws Exception {
        List<String[]> list = csvUtil.readCSV(filePath);
//        List<Recommend> recommendList = new ArrayList<>();
        List<String[]> recommendList = new ArrayList<>();
        try {

            for (int i = 0; i < list.size(); i++) {

//            for (int i = 0; i < 100; i++) {
                int userid = Integer.parseInt(list.get(i)[0]);
                int bookid = Integer.parseInt(list.get(i)[1]);
                float rating_real = Float.parseFloat(list.get(i)[2]);

                // 1,构建模型
                DataModel dataModel = new FileDataModel(new File(trainFilePath));
                //2,计算相似度
//                UserSimilarity userSimilarity = new EuclideanDistanceSimilarity(dataModel);
//                //3,查找K近邻
//                UserNeighborhood userNeighborhood = new NearestNUserNeighborhood(K_userCF, userSimilarity, dataModel);
//                //4,构造推荐引擎
//                Recommender recommender_user = new GenericUserBasedRecommender(dataModel, userNeighborhood, userSimilarity);
//                //5,得到推荐评分
//                Float rating_userCF = recommender_user.estimatePreference(userid, bookid);
//                if(rating_userCF.isNaN()){
//                    rating_userCF=(float)0;
//                }

                float rating_userCF = (float) 0;

                //物品相似度
                ItemSimilarity itemsimilarity = new EuclideanDistanceSimilarity(dataModel);
                //物品推荐算法
                Recommender recommender_item = new GenericItemBasedRecommender(dataModel, itemsimilarity);
                Float rating_itemCF = recommender_item.estimatePreference(userid, bookid);
                if (rating_itemCF.isNaN()) {
                    rating_itemCF = (float) 0;
                }
                //Knn推荐算法
//                Recommender recommender_knn = new KnnItemBasedRecommender(dataModel,itemsimilarity,new NonNegativeQuadraticOptimizer(),100);
//                float rating_knn = recommender_knn.estimatePreference(userid, bookid);


                //SVD推荐算法
                Recommender recommender_svd = new SVDRecommender(dataModel, new ALSWRFactorizer(dataModel, 10, 0.05, 10));
                Float rating_svd = recommender_svd.estimatePreference(userid, bookid);
                if (rating_svd.isNaN()) {
                    rating_svd = (float) 0;
                }

//                float rating_svd =(float)0;

                UserDAOImpl user = new UserDAOImpl();

                String[] str = {"" + userid, "" + bookid, "" + user.readUser(userid).getAge(),
                        "" + rating_userCF, "" + rating_itemCF, "" + rating_svd, "" + rating_real};
                recommendList.add(str);
            }
            csvUtil.writeCSV(recommendList, resultFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TasteException e) {
            e.printStackTrace();
        }
    }

    public void recommend2(String filePath) throws Exception {
        List<String[]> list = csvUtil.readCSV(filePath);
//        List<Recommend> recommendList = new ArrayList<>();
        List<String[]> recommendList = new ArrayList<>();
        try {
            //构建模型
            DataModel dataModel = new FileDataModel(new File(trainFilePath));

            UserSimilarity userSimilarity = new EuclideanDistanceSimilarity(dataModel);
            //3,查找K近邻
            UserNeighborhood userNeighborhood = new NearestNUserNeighborhood(K_userCF, userSimilarity, dataModel);
            //4,构造推荐引擎
            Recommender recommender_user = new GenericUserBasedRecommender(dataModel, userNeighborhood, userSimilarity);

            //物品相似度
            ItemSimilarity itemsimilarity = new EuclideanDistanceSimilarity(dataModel);
            //物品推荐算法
            Recommender recommender_item = new GenericItemBasedRecommender(dataModel, itemsimilarity);
            //SVD推荐算法
            Recommender recommender_svd = new SVDRecommender(dataModel, new ALSWRFactorizer(dataModel, 10, 0.05, 10));
            //Knn推荐算法
            Recommender recommender_knn = new KnnItemBasedRecommender(dataModel, itemsimilarity, new NonNegativeQuadraticOptimizer(), 100);


            for (int i = 0; i < list.size(); i++) {
                int userid = Integer.parseInt(list.get(i)[0]);
                int bookid = Integer.parseInt(list.get(i)[1]);
                float rating_real = Float.parseFloat(list.get(i)[2]);


                //user
                Float rating_userCF = recommender_user.estimatePreference(userid, bookid);
                if (rating_userCF.isNaN()) {
                    rating_userCF = (float) 0;
                }

                //item
                Float rating_itemCF = recommender_item.estimatePreference(userid, bookid);
                if (rating_itemCF.isNaN()) {
                    rating_itemCF = (float) 0;
                }
                //svd
                Float rating_svd = recommender_svd.estimatePreference(userid, bookid);
                if (rating_svd.isNaN()) {
                    rating_svd = (float) 0;
                }
                //Knn
                Float rating_knn = recommender_knn.estimatePreference(userid, bookid);
                if (rating_knn.isNaN()) {
                    rating_knn = (float) 0;
                }

                String[] str = {"" + rating_userCF, "" + rating_itemCF, "" + rating_svd, "" + rating_knn, "" + rating_real};
                recommendList.add(str);
            }

            csvUtil.writeCSV(recommendList, resultFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TasteException e) {
            e.printStackTrace();
        }
    }

    public void recommend3(String filePath) throws Exception {
        List<String[]> list = csvUtil.readCSV(filePath);

        List<String[]> recommendList = new ArrayList<>();
        DataModel dataModel = new FileDataModel(new File(finaltrainFilePath));
        //(1)----连接数据库部分
//        MysqlDataSource dataSource = new MysqlDataSource();
//        dataSource.setServerName("localhost");
//        dataSource.setUser("root");
//        dataSource.setPassword("123456");
//        dataSource.setDatabaseName("bx");
//        //(2)----使用MySQLJDBCDataModel数据源读取MySQL里的数据
//        JDBCDataModel dataModel = new MySQLJDBCDataModel(dataSource, "ratings_train", "user_id", "item_id", "score", null);
//        System.out.println(1);
        UserSimilarity userSimilarity = new EuclideanDistanceSimilarity(dataModel);
        //3,查找K近邻
        UserNeighborhood userNeighborhood = new NearestNUserNeighborhood(K_userCF, userSimilarity, dataModel);
        //4,构造推荐引擎
        Recommender recommender_user = new GenericUserBasedRecommender(dataModel, userNeighborhood, userSimilarity);

        //物品相似度
        ItemSimilarity itemsimilarity = new EuclideanDistanceSimilarity(dataModel);

        //物品推荐算法
        Recommender recommender_item = new GenericItemBasedRecommender(dataModel, itemsimilarity);

        //SVD推荐算法
        Recommender recommender_svd = new SVDRecommender(dataModel, new ALSWRFactorizer(dataModel, 10, 0.05, 10));
//        (dataModel, 10, 0.7, 3)

        //Knn推荐算法
        Recommender recommender_knn = new KnnItemBasedRecommender(dataModel, itemsimilarity, new NonNegativeQuadraticOptimizer(), neighbor);


        for (int i = 0; i < list.size(); i++) {
            System.out.println(i);
            int userid = Integer.parseInt(list.get(i)[0]);
            int bookid = Integer.parseInt(list.get(i)[1]);
            float rating_real = Float.parseFloat(list.get(i)[2]);

            FinalDAOImpl finalDAO = new FinalDAOImpl();
            boolean user = finalDAO.getUser(userid);
            boolean book = finalDAO.getBook(bookid);
            if (!book && user) {
                float rating_all = finalDAO.getAvgScore_user(userid);
                String[] str = {"" + rating_all, "" + rating_all, "" + rating_all, "" + rating_all, "" + rating_real};
                recommendList.add(str);
            } else if (!user && book) {
                float rating_all = finalDAO.getAvgScore_book(bookid);
                String[] str = {"" + rating_all, "" + rating_all, "" + rating_all, "" + rating_all, "" + rating_real};
                recommendList.add(str);
            } else if (!user && !book) {
                float rating_all = finalDAO.getAvgScore_all();
                String[] str = {"" + rating_all, "" + rating_all, "" + rating_all, "" + rating_all, "" + rating_real};
                recommendList.add(str);
            } else {

                //user
                Float rating_userCF = recommender_user.estimatePreference(userid, bookid);
                if (rating_userCF.isNaN()) {
                    rating_userCF = finalDAO.getAvgScore_userbook(userid, bookid);
                }
                //item
                Float rating_itemCF = recommender_item.estimatePreference(userid, bookid);
                if (rating_itemCF.isNaN()) {
                    rating_itemCF = finalDAO.getAvgScore_userbook(userid, bookid);
                }
                //svd
                Float rating_svd = recommender_svd.estimatePreference(userid, bookid);
                if (rating_svd.isNaN()) {
                    rating_svd = finalDAO.getAvgScore_userbook(userid, bookid);
                }
                //Knn
                Float rating_knn = recommender_knn.estimatePreference(userid, bookid);
                if (rating_knn.isNaN()) {
                    rating_knn = finalDAO.getAvgScore_userbook(userid, bookid);
                }

                String[] str = {"" + rating_userCF, "" + rating_itemCF, "" + rating_svd, "" + rating_knn, "" + rating_real};
                recommendList.add(str);
            }
        }
        csvUtil.writeCSV(recommendList, finalmodelFilePath);
    }

    public void recommend4(String filePath) throws Exception {
        List<String[]> list = csvUtil.readCSV(filePath);
        List<String[]> recommendList = new ArrayList<>();
        DataModel dataModel = new FileDataModel(new File(finaltrainFilePath));

        UserSimilarity userSimilarity = new EuclideanDistanceSimilarity(dataModel);
        UserNeighborhood userNeighborhood = new NearestNUserNeighborhood(K_userCF, userSimilarity, dataModel);
        Recommender recommender_user = new GenericUserBasedRecommender(dataModel, userNeighborhood, userSimilarity);

        ItemSimilarity itemsimilarity = new EuclideanDistanceSimilarity(dataModel);
        Recommender recommender_item = new GenericItemBasedRecommender(dataModel, itemsimilarity);

//        Recommender recommender_svd = new SVDRecommender(dataModel, new ALSWRFactorizer(dataModel, 10, 0.05, 10));
//        (dataModel, 10, 0.7, 3)

        Recommender recommender_knn = new KnnItemBasedRecommender(dataModel, itemsimilarity, new NonNegativeQuadraticOptimizer(), neighbor);

        float avg_all = csvAvg.csvAvg(finaltrainFilePath);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i);

            int userid = Integer.parseInt(list.get(i)[0]);
            int bookid = Integer.parseInt(list.get(i)[1]);
//            float rating_real = Float.parseFloat(list.get(i)[2]);

            float avg_user = csvAvg.csvAvg(finaltrainFilePath, 0, userid);
            float avg_book = csvAvg.csvAvg(finaltrainFilePath, 1, bookid);
            float avg_userbook = csvAvg.csvAvg(finaltrainFilePath, 0, userid, 1, bookid);

            if (avg_book == -1 && avg_user != -1) {//书不存在
                float rating_all = avg_user;//取user平均分
                String[] str = {"" + userid, "" + bookid, "" + rating_all, "" + rating_all, "" + rating_all};
                recommendList.add(str);
            } else if (avg_user == -1 && avg_book != -1) {//用户不存在
                float rating_all = avg_book;//取book平均分
                String[] str = {"" + userid, "" + bookid, "" + rating_all, "" + rating_all, "" + rating_all};
                recommendList.add(str);
            } else if (avg_book == -1 && avg_user == -1) {//都不存在
                float rating_all = avg_all;//所有书平均分
                String[] str = {"" + userid, "" + bookid, "" + rating_all, "" + rating_all, "" + rating_all};
                recommendList.add(str);
            } else {
                //user
                Float rating_userCF = recommender_user.estimatePreference(userid, bookid);
                if (rating_userCF.isNaN()) {
                    rating_userCF = avg_userbook;
                }
                //item
                Float rating_itemCF = recommender_item.estimatePreference(userid, bookid);
                if (rating_itemCF.isNaN()) {
                    rating_itemCF = avg_userbook;
                }
//                //svd
//                Float rating_svd = recommender_svd.estimatePreference(userid, bookid);
//                if (rating_svd.isNaN()) {
//                    rating_svd = avg_userbook;
//                }
                //Knn
                Float rating_knn = recommender_knn.estimatePreference(userid, bookid);
                if (rating_knn.isNaN()) {
                    rating_knn = avg_userbook;
                }
                String[] str = {"" + userid, "" + bookid, "" + rating_userCF, "" + rating_itemCF, "" + rating_knn};
                recommendList.add(str);
            }
        }
        csvUtil.writeCSV(recommendList, finalmodelFilePath);
    }

    public void result(String filePath) throws Exception {
        double[] theta = new double[]{0.6297266495395023, 0.2998168673911683, 0.04006363088028275, 0.02651877464796408};
        List<String[]> list = csvUtil.readCSV(finalmodelFilePath);
        CsvWriter csvWriter = new CsvWriter(filePath, ',', Charset.forName("UTF-8"));
        for (int i = 0; i < list.size(); i++) {
            float x0 = Float.parseFloat(list.get(i)[2]);
            float x1 = Float.parseFloat(list.get(i)[3]);
            float x2 = Float.parseFloat(list.get(i)[4]);
            String predict = "" + (theta[0] * x0 + theta[1] * x1 + theta[2] * x2 + theta[3]);
            String[] csvContent = {list.get(i)[0], list.get(i)[1], predict};
            csvWriter.writeRecord(csvContent);
        }
        csvWriter.close();
        System.out.println(filePath + "文件已写入--------");

    }

}
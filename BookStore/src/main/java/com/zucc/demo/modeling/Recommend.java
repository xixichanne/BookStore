package com.zucc.demo.modeling;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import com.zucc.demo.dao.BookDAOImpl;
import com.zucc.demo.model.BookVo;
import com.zucc.demo.model.RecommendBookVo;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.model.jdbc.MySQLJDBCDataModel;
import org.apache.mahout.cf.taste.impl.model.jdbc.ReloadFromJDBCDataModel;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.recommender.slopeone.SlopeOneRecommender;
import org.apache.mahout.cf.taste.impl.similarity.EuclideanDistanceSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.model.JDBCDataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Recommend {

    private static int BOOK_RECOMMEND_NUM = 20;//给用户推荐的数量
    private static String ratingsFilePath = "D:\\个人资料\\桌面\\data\\ratings.csv";

    public static MysqlDataSource dataSource = null;
    public static JDBCDataModel dataModel = null;
    public static ReloadFromJDBCDataModel model = null;
    public static ItemSimilarity itemsimilarity = null;
    public static Recommender recommender = null;

    public static void main(String args[]) throws Exception {
        Recommend recommend = new Recommend();
        recommend.baseItemCF_jdbc(3363);
    }

    public List<RecommendBookVo> baseItemCF_jdbc(int userid) throws TasteException {
        if (recommender == null) {
            //(1)----连接数据库部分
            dataSource = new MysqlDataSource();
            dataSource.setServerName("localhost");
            dataSource.setUser("root");
            dataSource.setPassword("123456");
            dataSource.setDatabaseName("bx");
            //(2)----使用MySQLJDBCDataModel数据源读取MySQL里的数据
            dataModel = new MySQLJDBCDataModel(dataSource, "ratings", "user_id",
                    "book_id", "book_rating", null);
            model = new ReloadFromJDBCDataModel(dataModel);
            //书籍相似度
            itemsimilarity = new EuclideanDistanceSimilarity(model);
            //物品推荐算法
            recommender = new GenericItemBasedRecommender(model, itemsimilarity);
            //计算得出推荐结果
        }

        List<RecommendBookVo> list = new ArrayList<>();

        List<RecommendedItem> recommendations = recommender.recommend(userid, BOOK_RECOMMEND_NUM);

        for (RecommendedItem recommendation : recommendations) {
            BookDAOImpl bookDAO = new BookDAOImpl();
            BookVo book = bookDAO.getBook((int) recommendation.getItemID());
            float rating = recommendation.getValue();
            RecommendBookVo recommendBook = new RecommendBookVo();
            recommendBook.setBook(book);
            recommendBook.setRating(rating);
            list.add(recommendBook);
            System.out.println(recommendation);
        }
        return list;
    }


    //基于物品相似度的协同过滤推荐实现
    public List<RecommendBookVo> baseItemCF_file(int userid) {
        List<RecommendBookVo> list = new ArrayList<>();
        try {
            //数据模型
            DataModel model = new FileDataModel(new File(ratingsFilePath));
            //书籍相似度
            ItemSimilarity itemsimilarity = new EuclideanDistanceSimilarity(model);
            //物品推荐算法
            Recommender recommender = new GenericItemBasedRecommender(model, itemsimilarity);
            //计算得出推荐结果
            List<RecommendedItem> recommendations = recommender.recommend(userid, BOOK_RECOMMEND_NUM);

            for (RecommendedItem recommendation : recommendations) {
                BookDAOImpl bookDAO = new BookDAOImpl();
                BookVo book = bookDAO.getBook((int) recommendation.getItemID());
                float rating = recommendation.getValue();
                RecommendBookVo recommendBook = new RecommendBookVo();
                recommendBook.setBook(book);
                recommendBook.setRating(rating);
                list.add(recommendBook);
                System.out.println(recommendation);
            }
            if (list.size() < 15) {
                List<RecommendBookVo> list1 = new ArrayList<>();
                int n = 15 - list.size();
                List<BookVo> books = new BookDAOImpl().getRandomBooks(n);
                for (int i = 0; i < books.size(); i++) {
                    RecommendBookVo recommendBook1 = new RecommendBookVo();
                    recommendBook1.setBook(books.get(i));
                    recommendBook1.setRating(0);
                    list1.add(recommendBook1);
                }
                list.addAll(list1);
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (TasteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }


}
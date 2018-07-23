package com.zucc.demo.dao;

import java.util.List;

public interface RatingDAO {
    public List loadRatingBooks(int userid) throws Exception;
    public void addRating(int userid, int bookid, String ISBN, int rating) throws Exception ;
    public int searchRating(int userid, String ISBN, int rating) throws Exception ;
}

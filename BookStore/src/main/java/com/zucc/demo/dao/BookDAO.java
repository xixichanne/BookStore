package com.zucc.demo.dao;

import com.zucc.demo.model.BookVo;

import java.util.List;

public interface BookDAO
{
    public BookVo getBook(String ISBN) ;
    public BookVo getBook(int id) ;
    public List<BookVo> getAllBooks() ;
    public List searchBook(String title)throws Exception;
    public List<BookVo> getRandomBooks(int n) ;



}
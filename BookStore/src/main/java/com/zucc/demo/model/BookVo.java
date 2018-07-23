package com.zucc.demo.model;

public class BookVo {
    private int id;
    private String isbn;
    private String title;
    private String author;
    private String year;
    private String publisher;
    private String image_url_s;
    private String image_url_m;
    private String image_url_l;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getImage_url_s() {
        return image_url_s;
    }

    public void setImage_url_s(String image_url_s) {
        this.image_url_s = image_url_s;
    }

    public String getImage_url_m() {
        return image_url_m;
    }

    public void setImage_url_m(String image_url_m) {
        this.image_url_m = image_url_m;
    }

    public String getImage_url_l() {
        return image_url_l;
    }

    public void setImage_url_l(String image_url_l) {
        this.image_url_l = image_url_l;
    }

/*    private int count;


    @Override
    public int compareTo(BookVo b) {
        int i = b.getCount() - this.getCount();
        if (i == 0)
            return b.getScore().compareTo(this.getScore());
        return i;
    }*/
}
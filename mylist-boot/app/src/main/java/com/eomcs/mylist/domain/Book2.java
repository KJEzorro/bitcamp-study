package com.eomcs.mylist.domain;

import java.sql.Date;

public class Book2 {
  String title;
  String author;
  String press;
  String feed;
  int page;
  int price;
  String listDate;
  Date readDate;

  public Book2() {
    System.out.println("Book() 호출됨");
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

  public String getPress() {
    return press;
  }

  public void setPress(String press) {
    this.press = press;
  }

  public String getFeed() {
    return feed;
  }

  public void setFeed(String feed) {
    this.feed = feed;
  }

  public int getPage() {
    return page;
  }

  public void setPage(int page) {
    this.page = page;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }


  public String getListDate() {
    return listDate;
  }


  public void setListDate(String listDate) {
    this.listDate = listDate;
  }


  public Date getReadDate() {
    return readDate;
  }


  public void setReadDate(Date readDate) {
    this.readDate = readDate;
  }


  @Override
  public String toString() {
    return "Book [title=" + title + ", author=" + author + ", press=" + press + ", feed=" + feed
        + ", page=" + page + ", price=" + price + ", listDate=" + listDate + ", readDate="
        + readDate + "]";
  }






}

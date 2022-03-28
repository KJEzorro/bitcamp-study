package com.eomcs.mylist.domain;

import java.sql.Date;

public class Book {
  int no;
  String title;
  String author;
  String press;
  String feed;
  Date readDate;
  int page;
  int price;
  String photo;

  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
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
  public Date getReadDate() {
    return readDate;
  }
  public void setReadDate(Date readDate) {
    this.readDate = readDate;
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
  public String getPhoto() {
    return photo;
  }
  public void setPhoto(String photo) {
    this.photo = photo;
  }

  @Override
  public String toString() {
    return "Book [no=" + no + ", title=" + title + ", author=" + author + ", press=" + press
        + ", feed=" + feed + ", readDate=" + readDate + ", page=" + page + ", price=" + price
        + ", photo=" + photo + "]";
  }



}

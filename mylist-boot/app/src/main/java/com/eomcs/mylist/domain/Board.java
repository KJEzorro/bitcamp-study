package com.eomcs.mylist.domain;


public class Board {
  String title;
  String content;
  int viewCount;
  java.sql.Date createdDate;


  public String getTitle() {
    return title;
  }


  public void setTitle(String title) {
    this.title = title;
  }


  public String getContent() {
    return content;
  }


  public void setContent(String content) {
    this.content = content;
  }


  public int getViewCount() {
    return viewCount;
  }


  public void setViewCount(int viewCount) {
    this.viewCount = viewCount;
  }


  public java.sql.Date getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(java.sql.Date createdDate) {
    this.createdDate = createdDate;
  }


  @Override
  public String toString() {
    return "Board [title=" + title + ", content=" + content + ", viewCount=" + viewCount
        + ", createdDate=" + createdDate + "]";
  }





}

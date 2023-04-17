package com.kotoriSystems.model;

import java.util.List;

import com.kotoriSystems.entity.Tutorial;

public class TutorialForm implements java.io.Serializable {
  private List<Tutorial> tutorials;
  private int currentPage;
  private long totalItems;
  private int totalPages;
  private int pageSize;
  private String keyword;
  private String message;

  public List<Tutorial> getTutorials() {
    return tutorials;
  }

  public void setTutorials(List<Tutorial> tutorials) {
    this.tutorials = tutorials;
  }

  public int getCurrentPage() {
    return currentPage;
  }

  public void setCurrentPage(int currentPage) {
    this.currentPage = currentPage;
  }

  public long getTotalItems() {
    return totalItems;
  }

  public void setTotalItems(long totalItems) {
    this.totalItems = totalItems;
  }

  public int getTotalPages() {
    return totalPages;
  }

  public void setTotalPages(int totalPages) {
    this.totalPages = totalPages;
  }

  public int getPageSize() {
    return pageSize;
  }

  public void setPageSize(int pageSize) {
    this.pageSize = pageSize;
  }

  public String getKeyword() {
    return keyword;
  }

  public void setKeyword(String keyword) {
    this.keyword = keyword;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}

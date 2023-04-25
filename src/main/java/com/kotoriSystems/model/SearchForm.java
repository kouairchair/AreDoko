package com.kotoriSystems.model;

import java.util.List;

import com.kotoriSystems.entity.are_doko.Item;

public class SearchForm implements java.io.Serializable {
  private List<Item> items;
  private int currentPage;
  private long totalItems;
  private int totalPages;
  private int pageSize;
  private String itemName;
  private String message;

  public List<Item> getItems() {
    return items;
  }

  public void setItems(List<Item> items) {
    this.items = items;
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

  public String getItemName() {
    return itemName;
  }

  public void setItemName(String itemName) {
    this.itemName = itemName;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}

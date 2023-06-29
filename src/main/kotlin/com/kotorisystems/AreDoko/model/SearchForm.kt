package com.kotoriSystems.model;

import com.kotoriSystems.entity.Item;
import java.io.Serializable;

data class SearchForm(
  var items: List<Item> = emptyList(),
  var currentPage: Int = 0,
  var totalPages: Int = 0,
  var pageSize: Int = 0,
  var itemName: String = "",
  var message: String = "",
  var totalItems: Long = 0
) : Serializable

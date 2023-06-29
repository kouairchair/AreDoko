package com.kotoriSystems.controller;

import kotlin.collections.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kotoriSystems.entity.Item;
import com.kotoriSystems.model.SearchForm;
import com.kotoriSystems.repository.ItemRepository;

@Controller
class ItemController(private var itemRepository : ItemRepository) {

  @GetMapping("/items/new")
  fun addItem(@ModelAttribute item : Item) : String {
    return "home_form"
  }

  @PostMapping("/items/save")
  fun saveItem(@ModelAttribute item : Item, redirectAttributes : RedirectAttributes) : String {
    try {
      println("testtest saveItem name" + item.name + "," + item.location?.name + "," + item.
      locationDetail + "," + item.genre?.id + "," + item.genre?.name)
      val existingItem = itemRepository.findById(item.id)
          .orElseThrow { IllegalArgumentException("Invalid item Id:" + item.id) }
      existingItem.name = item.name
      itemRepository.save(existingItem)
      redirectAttributes.addFlashAttribute("message", "The Item has been saved successfully!")
    } catch (e : Exception) {
      println("testtest exception:" + e.message)
      redirectAttributes.addAttribute("message", e.message)
    }

    return "redirect:items"
  }

  @GetMapping("/items")
  fun listItem(@ModelAttribute form : SearchForm) : String {
    val items = itemRepository.findAll()
    for (item in items) {
      println("testtest item:" + item.id + "," + item.name + "," + item.location?.name + "," + item.locationDetail + "," + item.genre?.name)
    }
    form.items = items
    return "home"
  }

  @GetMapping("/items/{id}")
  fun updateItem(@PathVariable("id") id : Long, model : Model, redirectAttributes : RedirectAttributes) : String {
    try {
      // idに対応するItemを取得
      val existingItem = itemRepository.findById(id)
          .orElseThrow { IllegalArgumentException("Invalid item Id:" + id) }
      println("testtest existingItem:" + existingItem.id + "," + existingItem.name + "," + existingItem.location?.name + ","
      + existingItem.locationDetail + "," + existingItem.genre?.name)

      model.addAttribute("item", existingItem)
      model.addAttribute("pageTitle", "Edit Item (ID: " + id + ")")

      return "home_form"
    } catch (e : Exception) {
      redirectAttributes.addFlashAttribute("message", e.message)
      return "redirect:/items"
    }

  }

  @GetMapping("/items/{id}/delete")
  fun deleteItem(@PathVariable("id") id : Long, redirectAttributes : RedirectAttributes) : String {
    try {
      itemRepository.deleteById(id)
      redirectAttributes.addFlashAttribute("message", "The Item with id=" + id + " has been deleted successfully!")
    } catch (e : Exception) {
      redirectAttributes.addFlashAttribute("message", e.message)
    }

    return "redirect:/items"
  }
}

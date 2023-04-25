package com.kotoriSystems.controller.are_doko;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kotoriSystems.entity.are_doko.Item;
import com.kotoriSystems.model.SearchForm;
import com.kotoriSystems.repository.are_doko.ItemRepository;

@Controller
public class ItemController {

  @Autowired
  private ItemRepository itemRepository;

  // @Autowired
  // private LocationRepository locationRepository;

  // @Autowired
  // private GenreRepository genreRepository;

  @GetMapping("/items/new")
  public String addItem(@ModelAttribute Item item) {
    return "item_form";
  }

  @PostMapping("/items/save")
  public String saveItem(@ModelAttribute Item item, RedirectAttributes redirectAttributes) {
    try {
      System.out.println("testtest saveItem:" + item.getId() + "," + item.getName() + "," + item.getLocation().getName() + ","
          + item.getLocationDetail() + "," + item.getGenre().getName());
      itemRepository.save(item);

      redirectAttributes.addFlashAttribute("message", "The Item has been saved successfully!");
    } catch (Exception e) {
      redirectAttributes.addAttribute("message", e.getMessage());
    }

    return "redirect:items";
  }

  @GetMapping("/items")
  public String listItem(@ModelAttribute SearchForm form) {
    List<Item> items = itemRepository.findAll();

    for (Item item : items) {
      System.out.println("testtest item:" + item.getId() + "," + item.getName() + "," + item.getLocation().getName() + ","
          + item.getLocationDetail() + "," + item.getGenre().getName());
    }

    form.setItems(items);
    return "are_doko/home";
  }

  @GetMapping("/items/{id}")
  public String updateItem(@PathVariable("id") long id, Model model,
      RedirectAttributes redirectAttributes) {
    try {
      // idに対応するItemを取得
      Item existingItem = itemRepository.findById(id)
          .orElseThrow(() -> new IllegalArgumentException("Invalid item Id:" + id));
      System.out.println("testtest existingItem:" + existingItem.getId() + "," + existingItem.getName() + "," + existingItem.getLocation().getName() + ","
      + existingItem.getLocationDetail() + "," + existingItem.getGenre().getName());

      model.addAttribute("item", existingItem);
      model.addAttribute("pageTitle", "Edit Item (ID: " + id + ")");

      return "are_doko/home_form";
    } catch (Exception e) {
      redirectAttributes.addFlashAttribute("message", e.getMessage());
      return "redirect:/items";
    }

  }

  @GetMapping("/items/{id}/delete")
  public String deleteItem(@PathVariable("id") long id, RedirectAttributes redirectAttributes) {
    try {
      itemRepository.deleteById(id);

      redirectAttributes.addFlashAttribute("message", "The Item with id=" + id + " has been deleted successfully!");
    } catch (Exception e) {
      redirectAttributes.addFlashAttribute("message", e.getMessage());
    }

    return "redirect:/are_doko/home";
  }
}

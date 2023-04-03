// package com.kotoriSystems.controller.are_doko;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.ModelAttribute;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestParam;

// import com.kotoriSystems.entity.are_doko.Item;
// import com.kotoriSystems.repository.are_doko.ItemRepository;

// @Controller
// public class ItemController {

//   @Autowired
//   private ItemRepository itemRepository;

//   // @Autowired
//   // private LocationRepository locationRepository;

//   // @Autowired
//   // private GenreRepository genreRepository;

//   @GetMapping("/items/add")
//   public String addItem(Model model) {
//     model.addAttribute("item", new Item(null, null, null, null, null, null));
//     // model.addAttribute("locations", locationRepository.findAll());
//     // model.addAttribute("genres", genreRepository.findAll());
//     return "additem";
//   }

//   @PostMapping("/items")
//   public String saveItem(@ModelAttribute Item item) {
//     itemRepository.save(item);
//     return "redirect:are_doko/home";
//   }

//   @GetMapping("/items")
//   public String listItem(Model model, @RequestParam(required = false) String keyword,
//   @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "3") int size) {
//     List<Item> items = itemRepository.findAll();
//     for (Item item : items) {
//       // print all fields of each item, separated by a comma
//       System.out.println(item.getId() + "," + item.getName() + "," + item.getLocation() + ","
//           + item.getLocationDetail() + "," + item.getGenre());
//     }

//     model.addAttribute("items", items);
//     return "are_doko/home";
//   }

//   @PostMapping("/items/{id}")
//   public String updateItem(@PathVariable("id") long id, @ModelAttribute Item item) {
//     // idに対応するItemを取得
//     Item existingItem = itemRepository.findById(id)
//         .orElseThrow(() -> new IllegalArgumentException("Invalid item Id:" + id));

//     // 更新内容を反映
//     existingItem.setName(item.getName());
//     existingItem.setLocation(item.getLocation());
//     existingItem.setLocationDetail(item.getLocationDetail());
//     existingItem.setGenre(item.getGenre());

//     // 更新を保存
//     itemRepository.save(existingItem);

//     return "redirect:/are_doko/home";
//   }

//   @GetMapping("/items/{id}/delete")
//   public String deleteItem(@PathVariable("id") long id) {
//     // idに対応するItemを取得
//     Item item = itemRepository.findById(id)
//         .orElseThrow(() -> new IllegalArgumentException("Invalid item Id:" + id));

//     // Itemを削除
//     itemRepository.delete(item);

//     return "redirect:/are_doko/home";
//   }
// }

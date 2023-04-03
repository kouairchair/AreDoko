package com.kotoriSystems.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kotoriSystems.api.PushyAPI;
import com.kotoriSystems.entity.Tutorial;
import com.kotoriSystems.repository.TutorialRepository;

@Controller
public class TutorialController {

  @Autowired
  private TutorialRepository tutorialRepository;

  @Autowired
  ResourceLoader resourceLoader;

  // root path for image files
  private String FILE_PATH_ROOT = "/static/";

  @GetMapping("/images/{filename}")
  public @ResponseBody byte[] getImage(@PathVariable("filename") String filename) throws IOException {
    return getFile(filename, "images/");
  }

  @GetMapping("/js/{filename}")
  public @ResponseBody byte[] getJs(@PathVariable("filename") String filename) throws IOException {
    return getFile(filename, "js/");
  }

  //TODO:仮実装
  @GetMapping("/{filename}")
  public @ResponseBody byte[] getJsWork(@PathVariable("filename") String filename) throws IOException {
    // リソースファイルを読み込み
    Resource resource = resourceLoader.getResource("classpath:" + filename);
    InputStream imageStream = resource.getInputStream();

    // byteへ変換
    return IOUtils.toByteArray(imageStream);
  }

  @GetMapping("/others/{filename}")
  public @ResponseBody byte[] getOther(@PathVariable("filename") String filename) throws IOException {
    return getFile(filename, "others/");
  }

  private @ResponseBody byte[] getFile(String filename, String subDir) throws IOException {
    // リソースファイルを読み込み
    Resource resource = resourceLoader.getResource("classpath:" + FILE_PATH_ROOT + subDir + filename);
    InputStream imageStream = resource.getInputStream();

    // byteへ変換
    return IOUtils.toByteArray(imageStream);
  }

  @GetMapping("/")
  public String getAll(Model model, @RequestParam(required = false) String keyword,
  @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "3") int size) {
    try {
      List<Tutorial> tutorials = new ArrayList<Tutorial>();
      Pageable paging = PageRequest.of(page - 1, size);

      Page<Tutorial> pageTuts;
      if (keyword == null) {
        pageTuts = tutorialRepository.findAll(paging);
      } else {
        pageTuts = tutorialRepository.findByTitleContainingIgnoreCase(keyword, paging);
        model.addAttribute("keyword", keyword);
      }

      tutorials = pageTuts.getContent();

      model.addAttribute("tutorials", tutorials);
      model.addAttribute("currentPage", pageTuts.getNumber() + 1);
      model.addAttribute("totalItems", pageTuts.getTotalElements());
      model.addAttribute("totalPages", pageTuts.getTotalPages());
      model.addAttribute("pageSize", size);
    } catch (Exception e) {
      model.addAttribute("message", e.getMessage());
    }

    return "tutorials";
  }

  @GetMapping("/tutorials/new")
  public String addTutorial(Model model) {
    Tutorial tutorial = new Tutorial();
    tutorial.setPublished(true);

    model.addAttribute("tutorial", tutorial);
    model.addAttribute("pageTitle", "Create new Tutorial");

    sendSamplePush();

    return "tutorial_form";
  }

  @PostMapping("/tutorials/save")
  public String saveTutorial(Tutorial tutorial, RedirectAttributes redirectAttributes) {
    try {
      tutorialRepository.save(tutorial);

      redirectAttributes.addFlashAttribute("message", "The Tutorial has been saved successfully!");
    } catch (Exception e) {
      redirectAttributes.addAttribute("message", e.getMessage());
    }

    return "redirect:/tutorials";
  }

  @GetMapping("/tutorials/{id}")
  public String editTutorial(@PathVariable("id") Integer id, Model model, RedirectAttributes redirectAttributes) {
    try {
      Tutorial tutorial = tutorialRepository.findById(id).get();

      model.addAttribute("tutorial", tutorial);
      model.addAttribute("pageTitle", "Edit Tutorial (ID: " + id + ")");

      return "tutorial_form";
    } catch (Exception e) {
      redirectAttributes.addFlashAttribute("message", e.getMessage());

      return "redirect:/tutorials";
    }
  }

  @GetMapping("/tutorials/delete/{id}")
  public String deleteTutorial(@PathVariable("id") Integer id, Model model, RedirectAttributes redirectAttributes) {
    try {
      tutorialRepository.deleteById(id);

      redirectAttributes.addFlashAttribute("message", "The Tutorial with id=" + id + " has been deleted successfully!");
    } catch (Exception e) {
      redirectAttributes.addFlashAttribute("message", e.getMessage());
    }

    return "redirect:/tutorials";
  }

  @GetMapping("/tutorials/{id}/published/{status}")
  public String updateTutorialPublishedStatus(@PathVariable("id") Integer id, @PathVariable("status") boolean published,
  Model model, RedirectAttributes redirectAttributes) {
    try {
      tutorialRepository.updatePublishedStatus(id, published);

      String status = published ? "published" : "disabled";
      String message = "The Tutorial id=" + id + " has been " + status;

      redirectAttributes.addFlashAttribute("message", message);
    } catch (Exception e) {
      redirectAttributes.addFlashAttribute("message", e.getMessage());
    }

    return "redirect:/tutorials";
  }

  private static void sendSamplePush() {
    // Prepare list of target device tokens
    List<String> deviceTokens = new ArrayList<>();

    // Add your device tokens here
    deviceTokens.add("cdd92f4ce847efa5c7f");

    // Convert to String[] array
    String[] to = deviceTokens.toArray(new String[deviceTokens.size()]);

    // Optionally, send to a publish/subscribe topic instead
    // String to = '/topics/news';

    // Set payload (any object, it will be serialized to JSON)
    Map<String, String> payload = new HashMap<>();

    // Add "message" parameter to payload
    payload.put("message", "Hello World!");

    // iOS notification fields
    Map<String, Object> notification = new HashMap<>();

    notification.put("badge", 1);
    notification.put("sound", "ping.aiff");
    notification.put("title", "Test Notification");
    notification.put("body", "Hello World \u270c");

    // Prepare the push request
    PushyAPI.PushyPushRequest push = new PushyAPI.PushyPushRequest(payload, to, notification);

    try {
      // Try sending the push notification
      PushyAPI.sendPush(push);
    }
    catch (Exception exc) {
      // Error, print to console
      System.out.println(exc.toString());
    }
  }

}

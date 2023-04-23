package com.kotoriSystems.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kotoriSystems.entity.Tutorial;
import com.kotoriSystems.model.TutorialForm;
import com.kotoriSystems.repository.TutorialRepository;

/**
 * チュートリアル画面のコントローラー
 */
@Controller
public class TutorialController {

  @Autowired
  private TutorialRepository tutorialRepository;

  /**
   * チュートリアルの一覧を返す
   *
   * @param tutorialForm
   * @param page
   * @param size
   * @return
   */
  @GetMapping("/tutorials")
  public String getAll(@ModelAttribute TutorialForm tutorialForm, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "3") int size) {
    try {
      List<Tutorial> tutorials = new ArrayList<Tutorial>();
      Pageable paging = PageRequest.of(page - 1, size);

      Page<Tutorial> pageTuts;
      String keyword = tutorialForm.getKeyword();
      if (keyword == null) {
        pageTuts = tutorialRepository.findAll(paging);
      } else {
        pageTuts = tutorialRepository.findByTitleContainingIgnoreCase(keyword, paging);
        tutorialForm.setKeyword(keyword);
      }

      tutorials = pageTuts.getContent();

      tutorialForm.setTutorials(tutorials);
      tutorialForm.setCurrentPage(pageTuts.getNumber() + 1);
      tutorialForm.setTotalItems(pageTuts.getTotalElements());
      tutorialForm.setTotalPages(pageTuts.getTotalPages());
      tutorialForm.setPageSize(size);

      // do some heavy random calculation processes
      if (tutorials.size() == 2) {
        for (int i = 0; i < 500000; i++) {
          int a = (int) (Math.random() * 500000);
          int b = (int) (Math.random() * 500000);
          int c = a * b;
        }
      }

    } catch (Exception e) {
      tutorialForm.setMessage(e.getMessage());
    }

    return "tutorials";
  }

  /**
   * チュートリアルの一覧を返す
   * TODO:htmlのフォームから直接submitして上記getAllメソッドで一覧を返せば良いし、GETメソッドで良いのだが、JSを介したPOST動くか確認のために実装したメソッド
   *
   * @param tutorialForm
   * @param page
   * @param size
   * @return
   */
  @PostMapping("/tutorials")
  public String getTutorials(@ModelAttribute TutorialForm tutorialForm,
      @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "3") int size) {
      // log all tutorialForm's fields
      System.out.println("testtest keyword: " + tutorialForm.getKeyword());
      System.out.println("testtest currentPage: " + tutorialForm.getCurrentPage());
      System.out.println("testtest totalItems: " + tutorialForm.getTotalItems());
      System.out.println("testtest totalPages: " + tutorialForm.getTotalPages());
      System.out.println("testtest pageSize: " + tutorialForm.getPageSize());
      System.out.println("testtest message: " + tutorialForm.getMessage());

      try {
        List<Tutorial> tutorials = new ArrayList<Tutorial>();
        Pageable paging = PageRequest.of(page - 1, size);

        Page<Tutorial> pageTuts;
        String keyword = tutorialForm.getKeyword();
        if (keyword == null) {
          pageTuts = tutorialRepository.findAll(paging);
        } else {
          pageTuts = tutorialRepository.findByTitleContainingIgnoreCase(keyword, paging);
          tutorialForm.setKeyword(keyword);
        }

        tutorials = pageTuts.getContent();

        System.out.println("testtest tutorials length: " + tutorials.size());
        tutorialForm.setTutorials(tutorials);
        tutorialForm.setCurrentPage(pageTuts.getNumber() + 1);
        tutorialForm.setTotalItems(pageTuts.getTotalElements());
        tutorialForm.setTotalPages(pageTuts.getTotalPages());
        tutorialForm.setPageSize(size);
      } catch (Exception e) {
        tutorialForm.setMessage(e.getMessage());
      }

      return "tutorials";
  }

  /**
   * チュートリアルの新規作成画面を返す
   *
   * @param model
   * @return
   */
  @GetMapping("/tutorials/new")
  public String addTutorial(Model model) {
    Tutorial tutorial = new Tutorial();
    tutorial.setPublished(true);

    model.addAttribute("tutorial", tutorial);
    model.addAttribute("pageTitle", "Create new Tutorial");

    return "tutorial_form";
  }

  /**
   * チュートリアルの新規作成
   *
   * @param tutorial
   * @param redirectAttributes
   * @return
   */
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

  /**
   * チュートリアルの編集画面を返す
   *
   * @param id
   * @param model
   * @param redirectAttributes
   * @return
   */
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

  /**
   * チュートリアルの削除
   *
   * @param id
   * @param model
   * @param redirectAttributes
   * @return
   */
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

  /**
   * チュートリアルの公開状態を更新
   *
   * @param id
   * @param published
   * @param model
   * @param redirectAttributes
   * @return
   */
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
}

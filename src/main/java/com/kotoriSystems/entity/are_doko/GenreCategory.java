package com.kotoriSystems.entity.are_doko;

import javax.persistence.*;

@Entity
@Table(name = "genre_category")
public class GenreCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    public GenreCategory(Long id, String name) {
      this.id = id;
      this.name = name;
    }

    public GenreCategory() {}

    public GenreCategory(String name) {
        this.name = name;
    }

    public Long getId() {
      return id;
    }

    public void setId(Long id) {
      this.id = id;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }
}

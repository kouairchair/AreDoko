// package com.kotoriSystems.entity.are_doko;

// import javax.persistence.*;

// @Entity
// @Table(name = "genre")
// public class Genre {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @Column(nullable = false)
//     private String name;

//     @ManyToOne(fetch = FetchType.LAZY)
//     @JoinColumn(name = "sub_category_id", nullable = false)
//     private GenreCategory category;

//     public Genre(Long id, String name, GenreCategory category) {
//       this.id = id;
//       this.name = name;
//       this.category = category;
//     }

//     public Genre() {}

//     public Genre(String name, GenreCategory category) {
//         this.name = name;
//         this.category = category;
//     }

//     public Long getId() {
//       return id;
//     }

//     public void setId(Long id) {
//       this.id = id;
//     }

//     public String getName() {
//       return name;
//     }

//     public void setName(String name) {
//       this.name = name;
//     }

//     public GenreCategory getCategory() {
//       return category;
//     }

//     public void setCategory(GenreCategory category) {
//       this.category = category;
//     }
// }

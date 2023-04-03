// package com.kotoriSystems.entity.are_doko;

// import javax.persistence.*;

// @Entity
// @Table(name = "location_sub_category")
// public class LocationSubCategory {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @Column(nullable = false)
//     private String name;

//     @ManyToOne
//     @JoinColumn(name = "category_id", nullable = false)
//     private LocationCategory category;

//     public LocationSubCategory(Long id, String name, LocationCategory category) {
//       this.id = id;
//       this.name = name;
//       this.category = category;
//     }

//     public LocationSubCategory() {}

//     public LocationSubCategory(String name, LocationCategory category) {
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

//     public LocationCategory getCategory() {
//       return category;
//     }

//     public void setCategory(LocationCategory category) {
//       this.category = category;
//     }
// }

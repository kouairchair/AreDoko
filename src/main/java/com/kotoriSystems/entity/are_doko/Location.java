// package com.kotoriSystems.entity.are_doko;

// import javax.persistence.*;

// @Entity
// @Table(name = "location")
// public class Location {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @Column(nullable = false)
//     private String name;

//     @ManyToOne(fetch = FetchType.LAZY)
//     @JoinColumn(name = "sub_category_id", nullable = false)
//     private LocationSubCategory subCategory;

//     public Location(Long id, String name, LocationSubCategory subCategory) {
//       this.id = id;
//       this.name = name;
//       this.subCategory = subCategory;
//     }

//     public Location() {}

//     public Location(String name, LocationSubCategory subCategory) {
//         this.name = name;
//         this.subCategory = subCategory;
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

//     public LocationSubCategory getSubCategory() {
//       return subCategory;
//     }

//     public void setSubCategory(LocationSubCategory subCategory) {
//       this.subCategory = subCategory;
//     }
// }

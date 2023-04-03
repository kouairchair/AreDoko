// package com.kotoriSystems.entity.are_doko;

// import javax.persistence.*;

// @Entity
// @Table(name = "item")
// public class Item {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @Column(nullable = false)
//     private String name;

//     @ManyToOne(fetch = FetchType.LAZY)
//     @JoinColumn(name = "location_id", nullable = false)
//     private Location location;

//     @Column(name = "location_detail")
//     private String locationDetail;

//     @Column(name = "user_ids")
//     private String userIds;

//     @ManyToOne(fetch = FetchType.LAZY)
//     @JoinColumn(name = "genre_id", nullable = false)
//     private Genre genre;

//     public Item(Long id, String name, Location location, String locationDetail, String userIds, Genre genre) {
//       this.id = id;
//       this.name = name;
//       this.location = location;
//       this.locationDetail = locationDetail;
//       this.userIds = userIds;
//       this.genre = genre;
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

//     public Location getLocation() {
//       return location;
//     }

//     public void setLocation(Location location) {
//       this.location = location;
//     }

//     public String getLocationDetail() {
//       return locationDetail;
//     }

//     public void setLocationDetail(String locationDetail) {
//       this.locationDetail = locationDetail;
//     }

//     public String getUserIds() {
//       return userIds;
//     }

//     public void setUserIds(String userIds) {
//       this.userIds = userIds;
//     }

//     public Genre getGenre() {
//       return genre;
//     }

//     public void setGenre(Genre genre) {
//       this.genre = genre;
//     }
// }

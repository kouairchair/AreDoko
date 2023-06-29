package com.kotoriSystems.entity;

import javax.persistence.*;
// import com.kotoriSystems.entity.LocationCategory;

@Entity
@Table(name = "location_subcategory")
data class LocationSubCategory(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id : Long = 0,

    var name : String = "",

    // @ManyToOne(cascade = [CascadeType.PERSIST])
    // @JoinColumn(name = "category_id")
    // var category : LocationCategory? = null
)
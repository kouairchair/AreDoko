package com.kotoriSystems.entity;

import javax.persistence.*;
import com.kotoriSystems.entity.LocationSubCategory;

@Entity
@Table(name = "location")
data class Location(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id : Long = 0,

    var name : String = "",

    @ManyToOne(cascade = [CascadeType.PERSIST])
    @JoinColumn(name = "sub_category_id", nullable = false)
    var subCategory : LocationSubCategory
)

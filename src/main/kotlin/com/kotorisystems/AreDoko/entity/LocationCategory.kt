package com.kotoriSystems.entity;

import javax.persistence.*;

@Entity
@Table(name = "location_category")
data class LocationCategory(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id : Long = 0,

    var name : String = ""
)

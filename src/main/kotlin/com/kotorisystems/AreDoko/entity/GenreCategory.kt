package com.kotoriSystems.entity;

import javax.persistence.*;

@Entity
@Table(name = "genre_category")
data class GenreCategory(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id : Long = 0,

    var name : String = ""
)

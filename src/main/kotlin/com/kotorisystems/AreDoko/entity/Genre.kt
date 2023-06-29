package com.kotoriSystems.entity;

import javax.persistence.*;

@Entity
@Table(name = "genre") 
data class Genre(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id : Long = 0,

    var name : String = "",

    @ManyToOne(cascade = [CascadeType.PERSIST])
    @JoinColumn(name = "category_id")
    var category : GenreCategory? = null
)
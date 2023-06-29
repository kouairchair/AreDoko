package com.kotoriSystems.entity;

import javax.persistence.*;

@Entity
@Table(name = "item")
data class Item(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id : Long = 0,

    var name : String = "",

    @ManyToOne(cascade = [CascadeType.PERSIST])
    @JoinColumn(name = "location_id")
    var location : Location? = null,

    var locationDetail : String = "",

    var userIds : String = "",

    @ManyToOne(cascade = [CascadeType.PERSIST])
    @JoinColumn(name = "genre_id")
    var genre : Genre? = null
)

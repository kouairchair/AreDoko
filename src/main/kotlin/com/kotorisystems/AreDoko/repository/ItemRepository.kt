package com.kotoriSystems.repository;

import kotlin.collections.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kotoriSystems.entity.Item;

@Repository
@Transactional
interface ItemRepository : JpaRepository<Item, Long> {
    fun findByLocation(location : String) : List<Item>
    fun findByLocationDetail(locationDetail : String) : List<Item>
    fun findByUserIds(userIds : String) : List<Item>
    fun findByGenre(genre : String) : List<Item>
    fun findByGenreDetail(genreDetail : String) : List<Item>
    fun findByLocationAndLocationDetail(location : String, locationDetail : String) : List<Item>
    fun findByLocationAndUserIds(location : String, userIds : String) : List<Item>
    fun findByLocationAndGenre(location : String, genre : String) : List<Item>
    fun findByLocationAndGenreDetail(location : String, genreDetail : String) : List<Item>
    fun findByLocationAndLocationDetailAndUserIds(location : String, locationDetail : String, userIds : String) : List<Item>
    fun findByLocationAndLocationDetailAndGenre(location : String, locationDetail : String, genre : String) : List<Item>
    fun findByLocationAndLocationDetailAndGenreDetail(location : String, locationDetail : String, genreDetail : String) : List<Item>
    fun findByLocationAndUserIdsAndGenre(location : String, userIds : String, genre : String) : List<Item>
    fun findByLocationAndUserIdsAndGenreDetail(location : String, userIds : String, genreDetail : String) : List<Item>
    fun findByLocationAndGenreAndGenreDetail(location : String, genre : String, genreDetail : String) : List<Item>
    fun findByLocationAndLocationDetailAndUserIdsAndGenre(location : String, locationDetail : String, userIds : String, genre : String) : List<Item>
    fun findByLocationAndLocationDetailAndUserIdsAndGenreDetail(location : String, locationDetail : String, userIds : String, genreDetail : String) : List<Item>
    fun findByLocationAndLocationDetailAndGenreAndGenreDetail(location : String, locationDetail : String, genre : String, genreDetail : String) : List<Item>
    fun findByLocationAndUserIdsAndGenreAndGenreDetail(location : String, userIds : String, genre : String, genreDetail : String) : List<Item>
    fun findByLocationAndLocationDetailAndUserIdsAndGenreAndGenreDetail(location : String, locationDetail : String, userIds : String, genre : String, genreDetail : String) : List<Item>

    // @Query("UPDATE Tutorial t SET t.published = :published WHERE t.id = :id")
    // @Modifying
    // fun updatePublishedStatus(@Param("id") id : Long, @Param("published") published : Boolean)
}

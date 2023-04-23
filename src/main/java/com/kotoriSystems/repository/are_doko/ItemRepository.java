package com.kotoriSystems.repository.are_doko;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kotoriSystems.entity.are_doko.Item;

@Repository
@Transactional
public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findByLocation(String location);

    // @Query("UPDATE Tutorial t SET t.published = :published WHERE t.id = :id")
    // @Modifying
    // public void updatePublishedStatus(Integer id, boolean published);
}

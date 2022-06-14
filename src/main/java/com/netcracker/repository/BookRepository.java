package com.netcracker.repository;

import com.netcracker.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE books SET name = :newName WHERE id = :id", nativeQuery = true)
    void updateNameById(@Param("newName") String newName, @Param("id") int id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE books SET price = :newPrice WHERE id = :id", nativeQuery = true)
    void updatePriceById(@Param("newPrice") int newPrice, @Param("id") int id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE books SET warehouse = :newWarehouse WHERE id = :id", nativeQuery = true)
    void updateWarehouseById(@Param("newWarehouse") String newWarehouse, @Param("id") int id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE books SET count = :newCount WHERE id = :id", nativeQuery = true)
    void updateCountById(@Param("newCount") int newCount, @Param("id") int id);
}
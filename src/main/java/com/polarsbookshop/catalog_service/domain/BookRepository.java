package com.polarsbookshop.catalog_service.domain;


import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface BookRepository
    extends CrudRepository<Book, Long> {

    Optional<Book> findByIsbn(String isbn);

    boolean existsByIsbn(String isbn);

    @Modifying
    @Query("delete from Book where isbn = :isbn") //custom SQL query
    //more on customization https://spring.io/projects/spring-data
    @Transactional
    void deleteByIsbn(String isbn);

}
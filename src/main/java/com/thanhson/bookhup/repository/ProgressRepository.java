package com.thanhson.bookhup.repository;

import com.thanhson.bookhup.model.Book;
import com.thanhson.bookhup.model.Genre;
import com.thanhson.bookhup.model.Progress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProgressRepository extends JpaRepository<Progress, Long> {
//    List<Progress> findByStatus(String status);
}

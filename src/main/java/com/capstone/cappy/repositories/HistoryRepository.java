package com.capstone.cappy.repositories;

import com.capstone.cappy.models.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryRepository extends JpaRepository<History, Long> {

    List<History> getAllByUser(long user_id);

    void deleteAllById(long id);


}

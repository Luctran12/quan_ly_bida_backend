package org.example.quan_ly_bida_backend.repository;

import org.example.quan_ly_bida_backend.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface StatusRepo extends JpaRepository<Status, Integer> {
    public Status findById(int id);

    public List<Status> findByDate(LocalDate date);



//    @Query(value = "SELECT * FROM status WHERE date = '?1'", nativeQuery = true)
//    List<Status> findByDate(String date);

}

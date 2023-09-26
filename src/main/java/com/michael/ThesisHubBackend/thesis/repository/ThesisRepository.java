package com.michael.ThesisHubBackend.thesis.repository;

import com.michael.ThesisHubBackend.thesis.entity.Thesis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ThesisRepository extends JpaRepository<Thesis, Integer> {
    @Query(name = "SELECT * FROM thesis WHERE thesis_id = :1",nativeQuery = true)
    Optional<Thesis> findByThesisId(@Param("thesis_id") Integer thesis_id);
}

package com.nmscinemas.nms_cinemas_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nmscinemas.nms_cinemas_backend.entity.Theatre;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre, Long> {

}

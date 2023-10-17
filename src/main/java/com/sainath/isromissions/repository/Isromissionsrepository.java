package com.sainath.isromissions.repository;

import com.sainath.isromissions.models.Isromissions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Isromissionsrepository extends JpaRepository<Isromissions, Integer> {

}

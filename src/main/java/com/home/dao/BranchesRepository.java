package com.home.dao;

import com.home.model.Branches;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchesRepository extends JpaRepository<Branches, Long> {
}

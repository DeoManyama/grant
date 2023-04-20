package com.example.grant.Repository;

import com.example.grant.Entity.Grant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GrandRepository extends JpaRepository<Grant, Long> {
}

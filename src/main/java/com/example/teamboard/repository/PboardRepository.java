package com.example.teamboard.repository;

import com.example.teamboard.entity.Member;
import com.example.teamboard.entity.Pboard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PboardRepository extends JpaRepository<Pboard,Long> {

    Page<Pboard> findByMember_Email(String email, Pageable pageable);
    Member findByMember_Email(String email);
}

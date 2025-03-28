package com.example.teamboard.repository;

import com.example.teamboard.dto.MemberDTO;
import com.example.teamboard.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

    public Member findByEmail(String email);

}

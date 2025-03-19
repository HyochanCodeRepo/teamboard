package com.example.teamboard.repository;

import com.example.teamboard.entity.Board;
import com.example.teamboard.entity.Pboard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BoardRepository extends JpaRepository<Board,Long> {

//    @Query("select p from Pboard p where p.pboardTitle like concat() ")
//    public Page<Pboard> selectTitle(String keyword, Pageable pageable);

}

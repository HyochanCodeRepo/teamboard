package com.example.teamboard.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "boardNum")
    private Long boardNum;  //pk번호

    @Column(nullable = false)
    private String boardTitle;  //제목
    @Column(nullable = false)
    private String boardContent;    //내용

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_num")
    private Member member;  //작성자
}

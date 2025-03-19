package com.example.teamboard.dto;

import com.example.teamboard.entity.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BoardDTO {
    private Long boardNum;  //pk번호
    private String boardTitle;  //제목
    private String boardContent;    //내용
    private Member member;  //작성자
}

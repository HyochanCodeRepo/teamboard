package com.example.teamboard.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MemberDTO {

    private Long memberNum;

    private String name;
    private String addr;
    private String email;

}

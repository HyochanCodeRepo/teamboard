package com.example.teamboard.dto;

import com.example.teamboard.constant.Role;
import jakarta.persistence.Column;
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
    private String password;
    private String addr;
    private String email;

    private Role role;

}

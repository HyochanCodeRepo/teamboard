package com.example.teamboard.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class PasswordDTO {
    private String password;
    private String newpassword1;
    private String newpassword2;
}

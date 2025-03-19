package com.example.teamboard.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_num")
    private Long memberNum;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String addr;
    @Column(nullable = false, unique = true)
    private String email;

}

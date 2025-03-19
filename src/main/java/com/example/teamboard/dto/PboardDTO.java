package com.example.teamboard.dto;

import com.example.teamboard.entity.Member;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class PboardDTO {


    private Long pboardNum;

    private String pboardTitle;

    private String pboardContent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberNum")
    private Member member;

}

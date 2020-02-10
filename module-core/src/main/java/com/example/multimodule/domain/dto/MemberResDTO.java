package com.example.multimodule.domain.dto;

import com.example.multimodule.domain.Member;
import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberResDTO {
    private String name;
    private String nickName;

    @Builder
    public MemberResDTO(String name, String nickName) {
        this.name = name;
        this.nickName = nickName;
    }

    public static MemberResDTO from(Member member) {
        return MemberResDTO.builder()
                .name(member.getName())
                .nickName(member.getNickName())
                .build();
    }
}

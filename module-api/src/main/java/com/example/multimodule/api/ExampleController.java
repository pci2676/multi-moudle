package com.example.multimodule.api;

import com.example.multimodule.domain.Member;
import com.example.multimodule.domain.dto.MemberResDTO;
import com.example.multimodule.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class ExampleController {

    private final MemberRepository memberRepository;

    @GetMapping
    public ResponseEntity<MemberResDTO> get() {
        Member member = memberRepository.save(new Member("이름", "별명"));
        return ResponseEntity.ok().body(MemberResDTO.from(member));
    }
}

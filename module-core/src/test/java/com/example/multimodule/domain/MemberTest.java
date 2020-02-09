package com.example.multimodule.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MemberTest {

    @DisplayName("멀티모듈 테스트")
    @Test
    void test1() {
        Member member = new Member("test", "test");

        assertThat(member.getName()).isEqualTo("test");
    }
}
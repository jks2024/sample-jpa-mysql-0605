package com.hd.sample_jpa_mysql_0605.controller;

import com.hd.sample_jpa_mysql_0605.dto.*;
import com.hd.sample_jpa_mysql_0605.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j // Log 메시지 출력을 위한 어노테이션
@RestController  // Rest API (GET, POST, PUT, DELETE)
@RequiredArgsConstructor  // 생성자를 통한 의존성 주입을 받기위해서 생성자를 자동 생성
@CrossOrigin(origins = {
        "http://localhost:3000",
        "http://localhost:5173"
})
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    // 회원 가입
    @PostMapping("/signup")  // Body에 정보를 싣는 방식, 정보가 보여지지 않음
    public ResponseEntity<MemberResDto> signup(@RequestBody MemberReqDto memberReqDto) {
        return ResponseEntity.ok(authService.signUp(memberReqDto));
    }

    // 로그인
    @PostMapping("/login")
    public ResponseEntity<TokenDto> login(@RequestBody MemberReqDto memberReqDto) {
        return ResponseEntity.ok(authService.login(memberReqDto));
    }
}

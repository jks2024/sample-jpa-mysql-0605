package com.hd.sample_jpa_mysql_0605.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")  // GET 방식
public class RestApiTestController {
    @GetMapping("/hello")
    public String getHello() {
        return "안녕하세요. 스프링부트 입니다.";
    }
    @GetMapping("/board/{variable}")  // URL 경로에 값을 포함하여 요청하는 방식
    public String getVariable(@PathVariable String variable) {
        return variable;
    }
    @GetMapping("/req")    // RequestParam : 쿼리 형식으로 값을 전달 하는 방식
    public String getReqParam(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String company) {
        return name + " " + email + " " + company;

    }

}

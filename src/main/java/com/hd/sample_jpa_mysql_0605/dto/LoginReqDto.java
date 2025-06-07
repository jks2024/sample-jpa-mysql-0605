package com.hd.sample_jpa_mysql_0605.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor // 기본 생성자, 역직렬화 시 반드시 필요
// @Data // 모드 어노테이션을 한번에 적용
@ToString // 자동 오버라이딩
public class LoginReqDto {
    private String email;
    private String pwd;
}

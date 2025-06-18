package com.hd.sample_jpa_mysql_0605.dto;

import com.hd.sample_jpa_mysql_0605.constant.Authority;
import com.hd.sample_jpa_mysql_0605.entity.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@Setter
@NoArgsConstructor
public class MemberReqDto {
    private String pwd;
    private String name;
    private String image;
    private String email;
    public Member toEntity(PasswordEncoder passwordEncoder) {
        return Member.builder()
                .email(email)
                .pwd(passwordEncoder.encode(pwd))
                .name(name)
                .image(image)
                .authority(Authority.ROLE_USER)
                .build();
    }
    public UsernamePasswordAuthenticationToken toAuthentication() {
        return new UsernamePasswordAuthenticationToken(email, pwd);
    }

}

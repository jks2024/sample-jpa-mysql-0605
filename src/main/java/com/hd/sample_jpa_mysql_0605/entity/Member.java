package com.hd.sample_jpa_mysql_0605.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "member")
@Getter @Setter
@ToString
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "member_id")
    private Long id;

    @Column(length = 100)
    private String name;

    @Column(nullable = false)
    private String pwd;

    @Column(unique = true, length = 150)
    private String email;

    @Column(length = 255)
    private String image;

    private LocalDateTime regDate;

    @PrePersist  // DB에 INSERT 되기전에 실행되는 메서드
    private void prePersist() {
        this.regDate = LocalDateTime.now();
    }
}

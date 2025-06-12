package com.hd.sample_jpa_mysql_0605.entity;

import com.hd.sample_jpa_mysql_0605.constant.ItemSellStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString   // toString() 오버라이드를 자동으로 해줌
@Entity     // 해당 클래스가 엔티티임을 나타냄, 즉 DB Table로 생성됨
@Table(name="item")  // 해당 클래스가 DB Table 생성시 생성될 이름 지정, 소문자로 생성
public class Item {
    @Id   // 기본키 필드 지정, 유일한 값, not null, 반드시 있어야 함
    @Column(name="item_id")  // DB로 생성될 컬럼 이름을 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String itemNm;  // 상품명

    @Column(name="price", nullable = false)
    private int price;

    @Column(nullable = false)  // stock_number, 스케이크 표기법으로 자동 변경 됨
    private int stockNumber;  // 재고 수량

    @Lob   // 대용량 문자열 처리
    @Column(nullable = false)
    private String itemDetail;

    @Enumerated(EnumType.STRING)
    private ItemSellStatus itemSellStatus;

    private LocalDateTime regTime;
    private LocalDateTime updateTime;
}

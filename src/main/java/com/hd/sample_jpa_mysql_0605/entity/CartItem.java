package com.hd.sample_jpa_mysql_0605.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter @Setter @ToString
public class CartItem {
    @Id
    @GeneratedValue  // 생성전략을 지정하지 않으면 AUTO
    @Column(name="cart_item_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)  // 여러 CartItem이 하나의 Cart 에 속하므로 N:1
    @JoinColumn(name="cart_id")
    private Cart cart;

    @ManyToOne(fetch = FetchType.LAZY)  // 여러 CartItem이 하나의 Item에 속하므로 N:1
    @JoinColumn(name="item_id")
    private Item item;

    private int count;
}

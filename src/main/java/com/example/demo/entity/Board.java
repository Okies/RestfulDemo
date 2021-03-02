package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name= "tbl_board")
@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bid;

    @Column(length = 200, nullable = false)
    private String title;

    @Column(length = 5000, nullable = false)
    private String content;

    @Column(length = 30, nullable = false)
    private String password;

    @Column(length = 30, nullable = false)
    private String createdId;
}

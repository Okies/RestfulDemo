package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@ToString
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Board extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200, nullable = false)
    private String title;

    @Column(length = 5000, nullable = false)
    private String content;

    @Column(length = 30, nullable = false)
    private String password;

    @Column(length = 30, nullable = false)
    private String createdId;
}

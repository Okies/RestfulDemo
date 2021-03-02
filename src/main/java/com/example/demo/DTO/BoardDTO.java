package com.example.demo.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class BoardDTO {

    private Long bid;

    private String title;

    private String content;

    private String password;

    private String createdId;
}

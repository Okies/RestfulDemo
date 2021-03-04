package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardDTO {

    private Long id;

    private String title;

    private String content;

    private String createdId;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String password;
}

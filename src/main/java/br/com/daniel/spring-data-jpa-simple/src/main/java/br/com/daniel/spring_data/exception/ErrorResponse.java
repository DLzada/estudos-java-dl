package br.com.daniel.spring_data.exception;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {

    private String message;
    private Integer status;
}

package br.com.daniel.spring_security_gym.exception;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {

    private String message;
    private Integer status;
}

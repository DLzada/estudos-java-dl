package br.com.daniel.spring_data.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExercicioDto {

    @NotBlank
    private String nome;
    @NotBlank
    private String grupoMuscular;
}

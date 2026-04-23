package br.com.daniel.spring_produtos.dto;

import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDto {
    private String nome;
    private BigDecimal preco;
    private Integer quantidade;
}
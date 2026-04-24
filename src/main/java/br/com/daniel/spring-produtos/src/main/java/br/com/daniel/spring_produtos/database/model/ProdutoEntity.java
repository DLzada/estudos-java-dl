package br.com.daniel.spring_produtos.database.model;

import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoEntity {
    private Integer id;
    private String nome;
    private BigDecimal preco;
    private Integer quantidade;
}

## Banco de Dados

### Embora o repositório seja focado em java, também irei estudar/abordar conceitos de banco de dados...

### SQL 
**SQL (Structured Query Language)** é a linguagem padrão para gerenciar e manipular bancos de dados relacionais. Ela permite `criar` tabelas, `consultar`, `inserir`, `atualizar` e `excluir` dados usando comandos simples baseados em inglês, sendo essencial para analistas e desenvolvedores. Exemplos comuns incluem `SELECT`, `INSERT`, `UPDATE` e `DELETE`.

**Conceitos Básicos de SQL**
* **Banco de Dados Relacional:** Conjunto de dados organizados em tabelas relacionadas entre si.
* **Tabela:** Estrutura básica, semelhante a uma planilha, com colunas e linhas.
* **Coluna (`Atributo`):** Define o tipo de dado (ex: nome, idade, e-mail).
* **Linha (`Registro`):** Uma entrada específica na tabela.
* **Chave Primária (`Primary Key`):** Identificador único de cada linha em uma tabela (ex: ID).
* **Chave Estrangeira (`Foreign Key`):** Campo que relaciona uma tabela a outra. 

**Principais Categorias de Comandos**
* **DML (Data Manipulation Language):** Manipula dados (`SELECT`, `INSERT`, `UPDATE`, `DELETE`).
* **DDL (Data Definition Language):** Define a estrutura (`CREATE`, `ALTER`, `DROP`).

**Exemplos Práticos de SQL**

* Selecionar todos os dados de uma tabela (`SELECT`):
``` 
    SELECT * FROM clientes;
```

* Selecionar colunas específicas e ordenar (`SELECT`, `ORDER BY`):
```
    SELECT nome, email FROM clientes ORDER BY nome ASC;
```

* Inserir novos dados (`INSERT`):
```
    INSERT INTO clientes (nome, email) VALUES ('João Silva', 'joao@email.com');
```

* Atualizar Dados (`UPDATE`):
```
    UPDATE clientes SET email = 'novo_email@email.com' WHERE id = 1;
```

* Excluir Dados (`Delete`):
```
    DELETE FROM clientes WHERE id = 1;
```

### MER e DER
`MER` (Modelo Entidade-Relacionamento) e `DER` (Diagrama Entidade-Relacionamento) são ferramentas cruciais de modelagem de dados. O MER é o modelo conceitual (teórico) que define entidades, atributos e relacionamentos. O DER é a representação gráfica (visual) desse modelo, materializando o projeto com chaves primárias e estrangeiras para implementação do banco. 

**Diferenças Principais (MER vs DER):**
* **MER (Modelo):** É abstrato, focado em regras de negócio e planejamento textual, focado na estrutura.
* **DER (Diagrama):** É o desenho visual, utilizando símbolos (retângulos, losangos) para representar tabelas e conexões.
* **Foco:** O **MER** define o que armazenar; o **DER** define como estruturar visualmente.

**O que compõe o MER e DER**
* **Entidade:** Objeto do mundo real (ex: `Cliente`, `Produto`).
* **Atributo:** Propriedade da entidade (ex: `CPF`, `Nome`).
* **Relacionamento:** Conexão entre entidades (ex: `Cliente compra Produto`).
* **Cardinalidade:** Quantidade de relacionamentos (ex: `1:1`, `1:N`, `N:N`).

**Exemplo Prático: Sistema de Vendas**
* **Entidades:** `CLIENTE`, `PEDIDO`, `PRODUTO`.
* **Atributos:**

    * **CLIENTE:** ID_Cliente (Chave Primária), Nome, Endereço.
    * **PEDIDO:** ID_Pedido, Data, Valor Total.
    * **PRODUTO:** ID_Produto, Nome, Preço.
  
* **Relacionamentos e Cardinalidade:**

  > CLIENTE --(1:N)-- PEDIDO (Um cliente pode fazer vários pedidos, um pedido pertence a um cliente).
  PEDIDO --(N:N)-- PRODUTO (Um pedido tem vários produtos, um produto pode estar em vários pedidos).

<div align="center">
  <img src="modelo.jpg" width="400" />
</div>
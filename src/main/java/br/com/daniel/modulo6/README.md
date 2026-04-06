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
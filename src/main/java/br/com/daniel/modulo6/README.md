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
---

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

### Tabelas, colunas e Registros

Tabelas em bancos de dados relacionais funcionam como planilhas, organizando dados em colunas (campos/atributos que definem o tipo de informação, como Nome ou Preço) e registros (linhas/entradas únicas de dados, como um cliente específico). Eles estruturam informações em um formato tabular rígido (SQL).

**Componentes de um Banco de Dados**
* **Tabela (`Table`):** Estrutura fundamental que organiza dados sobre um tema específico (ex: `Clientes`, `Produtos`).
* **Coluna (`Campo/Attribute`):** Define o tipo de dado armazenado (ex: `ID`, `Nome`, `Data_Nascimento`). Cada coluna tem um tipo (`texto`, `número`, `data`).
* **Registro (`Linha/Registro`):** Uma entrada individual e única na tabela (ex: os dados de um cliente específico como "João", "25 anos", "Rua A").
* **Chave Primária (`Primary Key`):** Um identificador único para cada registro, garantindo que não haja duas linhas idênticas.

<table>
  <thead>
    <tr>
      <th>ID (PK)</th>
      <th>Nome</th>
      <th>Email</th>
      <th>Telefone</th>
      <th>Data_Cadastro</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>1</td>
      <td>Ana Silva</td>
      <td>ana@email.com</td>
      <td>9999-0001</td>
      <td>2023-01-15</td>
    </tr>
    <tr>
      <td>2</td>
      <td>Bruno Souza</td>
      <td>bruno@email.com</td>
      <td>9999-0002</td>
      <td>2023-02-10</td>
    </tr>
    <tr>
      <td>3</td>
      <td>Carla Dias</td>
      <td>carla@email.com</td>
      <td>9999-0003</td>
      <td>2023-03-05</td>
    </tr>
  </tbody>
</table>

* **Tabela:** Clientes
* **Colunas:** ID, Nome, Email, Telefone, Data_Cadastro.
* **Registro:** A linha 2 | Bruno Souza | bruno@email.com | 9999-0002 | 2023-02-10.

**Exemplo em SQL:**
```
    -- Criando uma tabela
    CREATE TABLE Clientes (
        ID INT PRIMARY KEY,
        Nome VARCHAR(100),
        Email VARCHAR(100),
        Data_Cadastro DATE
    );
    
    -- Inserindo um registro
    INSERT INTO Clientes (ID, Nome, Email, Data_Cadastro)
    VALUES (1, 'Ana Silva', 'ana@email.com', '2023-01-15');
```
---

### JOINs
Consultas com junções (JOINs) e subconsultas em SQL são ferramentas essenciais para combinar e filtrar dados de múltiplas tabelas. JOIN conecta tabelas por colunas relacionadas (INNER, LEFT), sendo geralmente mais eficiente. Subconsultas são consultas aninhadas que isolam lógica complexa, usadas frequentemente no WHERE ou FROM para cálculos específicos.

**Junções (JOINs) **
A `INNER JOIN` combina registros de duas tabelas (ex: Clientes e Pedidos) que possuem valores correspondentes em ambas.

```
    SELECT Pedidos.ID, Clientes.Nome, Pedidos.DataPedido
    FROM Pedidos
    INNER JOIN Clientes ON Pedidos.ClienteID = Clientes.ID;
```

**Subconsultas (Subqueries)**
Uma subconsulta pode ser usada para filtrar dados baseados no resultado de outra tabela (ex: produtos com preço acima da média).

```
    SELECT Nome, Preco
    FROM Produtos
    WHERE Preco > (SELECT AVG(Preco) FROM Produtos);
```

**Principais Diferenças e Casos de Uso:**
* **JOINs:** Melhor para listar dados de tabelas relacionadas e quando há grande volume de dados.
* **Subconsultas:** Ideal para filtrar (usando IN, EXISTS) ou quando se precisa de um valor único de outra tabela (escalar).
* **Dica:** Utilize explicacao SQL para treinar. Subconsultas no FROM (também conhecidas como tabelas derivadas) podem aumentar a legibilidade.

**Exemplo Combinado (Complexo):**
Selecionar clientes que fizeram pedidos acima da média total.

```
    SELECT Nome
    FROM Clientes
    WHERE ID IN (
        SELECT ClienteID 
        FROM Pedidos 
        WHERE Total > (SELECT AVG(Total) FROM Pedidos)
    );
```
---

### NoSql

Os bancos NoSQL são bancos de dados não relacionais focados em escalabilidade horizontal e flexibilidade de esquema. Os principais tipos incluem Chave-Valor (simples/rápido), Documento (JSON/BSON, ex: MongoDB), Família de Colunas (alto desempenho/colunas largas, ex: Cassandra) e Grafos.

**Tipos de Bancos NoSQL**
* **Banco Chave-Valor (Key-Value Store):** O modelo mais simples, armazena dados como pares (chave-valor), onde a chave é única.
  * **Exemplos:** Redis, Amazon DynamoDB.
  * **Uso:** Carrinhos de compras, cache de sessão, perfis de usuário.
* **Banco de Documentos (Document Store):** Armazena dados em documentos, geralmente formato JSON ou BSON, permitindo estruturas flexíveis (heterogêneas).
  * **Exemplos:** MongoDB, Couchbase.
  * **Uso:** Sistemas de gerenciamento de conteúdo (CMS), catálogos de produtos.
* **Banco de Família de Colunas (Column-Family Store):** Organiza dados em colunas largas, não em linhas, permitindo que cada linha tenha colunas diferentes.
  * **Exemplos:** Apache Cassandra, HBase.
  * **Uso:** IoT, dados de séries temporais, Data Warehousing.

**Exemplos no MongoDB (Banco de Documentos)** - O MongoDB armazena dados em coleções (equivalente a tabelas) de documentos (equivalente a linhas) no formato JSON/BSON.
* Exemplo de inserção de um documento no MongoDB:

```
    db.usuarios.insertOne({
        "_id": ObjectId("60d5ec4a02222134567890ab"),
        "nome": "João Silva",
        "idade": 30,
        "email": "joao@email.com",
        "habilidades": ["NoSQL", "MongoDB", "Data Science"], // Array
        "endereco": { // Subdocumento
            "rua": "Rua A",
            "cidade": "Picuí"
        }
    })
```
* Exemplo de consulta no MongoDB:
```
    // Buscar usuário por nome
    db.usuarios.find({ "nome": "João Silva" })
    
    // Buscar todos os usuários de uma cidade específica (subdocumento)
    db.usuarios.find({ "endereco.cidade": "Picuí" })
```

**Principais características do MongoDB:**

* **Flexibilidade:** Novos campos podem ser adicionados sem alterar o esquema da tabela inteira.
* **Performance:** Alta velocidade de leitura e gravação.
* **Escalabilidade:** Suporte a sharding para escalonamento horizontal.
---
### Schema Design e boas praticas
O design de schema no MongoDB é um processo flexível e voltado para documentos (BSON), que prioriza o desempenho de leitura e a forma como a aplicação acessa os dados, em vez de focar apenas na normalização, como nos bancos relacionais. Diferente do SQL, o MongoDB permite que documentos na mesma coleção tenham estruturas diferentes, oferecendo agilidade no desenvolvimento.

**Conceitos Fundamentais de Schema Design**
* **Documentos Incorporados (Embedding):** Relacionar dados armazenando-os juntos dentro de um único documento.
* **Referências (Referencing/Linking):** Armazenar documentos em coleções separadas e usar _id para referenciá-los (semelhante a chaves estrangeiras).
* **Desnormalização:** Duplicar dados para evitar joins e acelerar leituras.
* **Validação de Schema:** Definir regras (via $jsonSchema) para garantir a integridade dos dados em produção, limitando a flexibilidade apenas onde necessário.
* **Padrões de Acesso:** O design deve ser baseado em como sua aplicação lê e escreve os dados, não como eles se relacionam teoricamente.

**Boas Práticas e Estratégias**
* **Dados acessados juntos devem ser armazenados juntos:** Essa é a regra principal para otimização.
* **Prefira Embedding (Incorporar) por padrão:** Use para relações 1:1 ou 1:poucos, onde a leitura precisa ser rápida.
* **Use Referencing para dados grandes ou dinâmicos:** Evite arrays que crescem sem limites ("unbounded arrays").
* **Evite documentos gigantes:** Limite o tamanho para garantir performance, lembrando que documentos não podem exceder 16MB.
* **Indexe campos de consulta:** Campos usados em $match, $sort ou $lookup devem ser indexados.
* **Planeje a Evolução:** Use o Schema Versioning Pattern para lidar com mudanças na estrutura dos dados ao longo do tempo.

**Exemplos de Schema Design**
**A. Incorporação (Embedding) - Recomendado para "um-para-poucos"** - Ideal para dados que mudam pouco e são lidos juntos, como endereço de um usuário.

```json
// Coleção users
{
  "_id": ObjectId("1"),
  "nome": "João Silva",
  "endereco": {
    "rua": "Rua A",
    "cidade": "São Paulo"
  }
}
```

**B. Referência (Referencing) - Recomendado para "um-para-muitos" grande** - Ideal quando o "muitos" pode crescer indefinidamente (ex: logs, pedidos).

```json
// Coleção orders (Pedidos)
{
  "_id": ObjectId("101"),
  "data": "2026-04-09",
  "cliente_id": ObjectId("1"), // Referência
  "itens": [...]
}
```

**C. Padrão de Subconjunto (Subset Pattern)** - Útil quando você tem muitos dados, mas a aplicação só precisa de um subconjunto frequentemente.
**Exemplo:** O perfil do filme e os 10 últimos comentários (em vez de todos os 5000 comentários).

```json
{
  "_id": ObjectId("1"),
  "titulo": "Inception",
  "diretor": "Christopher Nolan",
  "ultimos_comentarios": [ // Embed apenas os recentes
    {"user": "ana", "texto": "Otimo filme!"},
    {"user": "bob", "texto": "Muito confuso."}
  ]
}
```

**D. Padrão de Bucket (Bucket Pattern)** - Ideal para dados de séries temporais (IoT, telemetria) para evitar muitos documentos pequenos.
```json
{
  "sensor_id": "sensor_01",
  "dia": "2026-04-09",
  "leituras": [ // Agrupando dados do dia
    {"timestamp": ISODate("..."), "valor": 20},
    {"timestamp": ISODate("..."), "valor": 22}
  ]
}
```

<table>
  <caption>Boas Práticas de Modelagem NoSQL</caption>
  <thead>
    <tr>
      <th scope="col">Situação</th>
      <th scope="col">Recomendação</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>Relação 1:1</td>
      <td><code>Incorporar (Embed)</code></td>
    </tr>   
    <tr>
      <td>Relação 1:Poucos (estáticos)</td>
      <td><code>Incorporar (Embed)</code></td>
    </tr>
    <tr>
      <td>Relação 1:Muitos (ilimitado)</td>
      <td><code>Referenciar (Parent Ref)</code></td>
    </tr>
    <tr>
      <td>Dados acessados juntos</td>
      <td><code>Incorporar (Embed)</code></td>
    </tr>
    <tr>
      <td>Dados compartilhados</td>
      <td><code>Referenciar (Reference)</code></td>
    </tr>
  </tbody>
</table>
---

### Manipulação de Dados - CRUD

**Criar (Create - Inserção)** - Adiciona novos documentos a uma coleção.
* `insertOne()`: Insere um único documento.
* `insertMany()`: Insere múltiplos documentos. 

```json
// Exemplo: Inserindo um filme
db.filmes.insertOne({
  titulo: "Matrix",
  genero: "Sci-Fi",
  ano: 1999,
  elenco: ["Keanu Reeves", "Laurence Fishburne"]
})
```

**Ler (Read - Consulta)** - Seleciona documentos de uma coleção baseada em critérios.
* `find()`: Retorna documentos.
* `findOne()`: Retorna o primeiro documento que corresponde ao critério.

```json
// Exemplo: Buscar filmes de 1999
db.filmes.find({ ano: 1999 })

// Exemplo: Buscar um filme pelo título
db.filmes.findOne({ titulo: "Matrix" })
```

**Atualizar (Update)** - Modifica documentos existentes.
* `updateOne()`: Atualiza o primeiro documento que corresponde ao filtro.
* `updateMany()`: Atualiza todos os documentos que correspondem ao filtro.
* **Operadores comuns:** `$set` (define valor), `$inc` (incrementa), `$push` (adiciona item a array). 

```json
// Exemplo: Atualizar o ano de um filme
db.filmes.updateOne(
  { titulo: "Matrix" },
  { $set: { ano: 2000 } }
)

// Exemplo: Adicionar um novo ator ao elenco
db.filmes.updateOne(
  { titulo: "Matrix" },
  { $push: { elenco: "Carrie-Anne Moss" } }
)
```

**Deletar (Delete)** - Remove documentos de uma coleção.
* `deleteOne()`: Remove o primeiro documento que corresponde ao filtro.
* `deleteMany()`: Remove todos os documentos que correspondem ao filtro.

```json
// Exemplo: Deletar um filme pelo título
db.filmes.deleteOne({ titulo: "Matrix" })

// Exemplo: Deletar todos os filmes com ano inferior a 1990
db.filmes.deleteMany({ ano: { $lt: 1990 } })
```
### JUNIT
O JUnit é o framework de testes unitários mais popular para a linguagem Java. Ele é amplamente utilizado para validar o comportamento de pequenas unidades de código (métodos e classes) de forma automatizada, garantindo que o software funcione conforme o esperado.

**Conceitos Principais do JUnit 5**
* **Teste Unitário:** Valida a menor parte testável do código (geralmente um método) isoladamente.
* **Asserções (`Assertions`):** Métodos que verificam se o resultado esperado é igual ao resultado real.
* **Anotações:** Define como os métodos de teste devem ser executados (ex: `@Test`, `@BeforeEach`).
* **Fixture (Setup/Teardown):** Preparação do ambiente antes do teste e limpeza após o teste.
* **Testes Parametrizados:** Executa o mesmo teste múltiplas vezes com dados diferentes.

<table>
  <thead>
    <tr>
      <th>Anotação</th>
      <th>Descrição</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td> <code>@Test</code></td>
      <td>Define que o método é um caso de teste.</td>
    </tr>   
    <tr>
      <td><code>@BeforeEach</code></td>
      <td>Executado antes de cada método de teste (@Test). Usado para inicializar objetos.</td>
    </tr>
    <tr>
      <td><code>@AfterEach</code></td>
      <td>Executado após cada método de teste. Usado para limpar recursos.</td>
    </tr>
    <tr>
      <td><code>@BeforeAll</code></td>
      <td>Executado uma vez antes de todos os testes da classe (deve ser static).</td>
    </tr>
    <tr>
      <td><code>@AfterAll</code></td>
      <td>Executado uma vez após todos os testes da classe (deve ser static).</td>
    </tr>
    <tr>
      <td><code>@Disabled</code></td>
      <td>Ignora o teste na execução.</td>
    </tr>
    <tr>
      <td><code>@DisplayName</code></td>
      <td>Define um nome personalizado para o teste na IDE.</td>
    </tr>
  </tbody>
</table>


**Exemplos Práticos em Java**
Para usar os exemplos, certifique-se de importar o JUnit 5 (`org.junit.jupiter.api.*`) e JUnit Jupiter Assertions (`org.junit.jupiter.api.Assertions.*`).

**A. Exemplo Básico (Assertions)** - Testa se a soma de dois números está correta.

```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculadoraTest {

    @Test
    public void testSoma() {
        Calculadora calc = new Calculadora();
        int resultado = calc.somar(2, 3);
        // Esperado, Atual, Mensagem
        assertEquals(5, resultado, "2 + 3 deve ser 5");
    }
}
```

**B.Exemplo com Setup e Teardown** - Utiliza `@BeforeEach` para criar uma nova instância antes de cada teste. 

```java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ListaTest {
    private ArrayList<String> lista;

    @BeforeEach
    public void setup() {
        lista = new ArrayList<>();
        lista.add("Item 1");
    }

    @Test
    public void testListaNaoVazia() {
        assertTrue(lista.size() > 0);
    }
}
```

**C.Exemplo de Asserções Avançadas** - Verifica exceções, nulidade e igualdade.

```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UsuarioTest {
    @Test
    public void testVerificacoes() {
        String nome = "JUnit";
        String nulo = null;

        assertNotNull(nome);
        assertNull(nulo);
        assertSame(nome, "JUnit"); // Verifica referência
        assertThrows(ArithmeticException.class, () -> {
            int i = 1 / 0; // Testa se lança exceção
        });
    }
}
```

**D. Teste Parametrizado** - Executa o teste várias vezes com os dados da `@CsvSource`.

```java
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParametrizadoTest {

    @ParameterizedTest
    @CsvSource({
        "1, 1, 2",
        "2, 3, 5",
        "10, 20, 30"
    })
    public void testSomaParametrizada(int a, int b, int esperado) {
        Calculadora calc = new Calculadora();
        assertEquals(esperado, calc.somar(a, b));
    }
}
```

**Vantagens do JUnit**
* **Automatização:** Testes rápidos e automáticos.
* **Qualidade:** Detecta bugs precocemente.
* **Refatoração Segura:** Garante que mudanças no código não quebrem funcionalidades existentes.
* **Documentação:** Serve como exemplo de como utilizar o código.
* **Integração:** Compatível com ferramentas de build como Maven e Gradle e todas as principais IDEs (Eclipse, IntelliJ).

**Assumptions (Suposições)** - `org.junit.jupiter.api.Assumptions`
As suposições são usadas para verificar se as pré-condições para um teste são verdadeiras. Se a suposição falhar (false), o teste é abortado (ignorado), mas não falha.
* `assumeTrue(...)`: Executa o teste apenas se a condição for verdadeira.
* `assumeFalse(...)`: Executa o teste apenas se a condição for falsa.
* `assumingThat(...)`: Executa um bloco de código se a condição for verdadeira, mas continua o teste depois, independentemente do resultado.

**Exemplo de Assumptions**

```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assumptions.*;

class AssumptionTest {
    @Test
    void testOnlyOnDevEnvironment() {
        String env = System.getProperty("env");
        // O teste só continua se env for "DEV"
        assumeTrue("DEV".equals(env), "Aborted: Não é ambiente de DEV");
        
        // ... código do teste
    }

    @Test
    void testInDifferentEnvironments() {
        String env = System.getProperty("env");
        // Executa lógica específica se for Windows
        assumingThat("WIN".equals(env), () -> {
            // ... lógica Windows
        });
        // Esta parte roda sempre
    }
}
```

**Testes Condicionais (Anotações)** - `org.junit.jupiter.api.condition`
O JUnit 5 oferece anotações para habilitar ou desabilitar testes com base no ambiente operacional, variáveis de sistema, propriedades Java ou scripts.

**A. Condições de Sistema Operacional** (`@EnabledOnOs`, `@DisabledOnOs`)
```java
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

class OsConditionTest {
    @Test
    @EnabledOnOs(OS.WINDOWS)
    void onlyOnWindows() {
        // Roda apenas no Windows
    }
}
```
**B.Condições Java** (`@EnabledOnJre`, `@DisabledOnJre`)
```java
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.JRE;

@Test
@EnabledOnJre(JRE.JAVA_17)
void onlyOnJava17() {
    // Roda apenas com Java 17
}
```

**C. Variáveis de Ambiente e Propriedades** (`@EnabledIfEnvironmentVariable`, `@EnabledIfSystemProperty`)

```java
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;

@Test
@EnabledIfEnvironmentVariable(named = "DB_TYPE", matches = "POSTGRES")
void onlyOnPostgres() {
    // Roda se a variável de ambiente DB_TYPE for POSTGRES
}
```

* **D. Desabilitar Testes** (`@Disabled`)
```java
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Disabled("Ainda não implementado")
@Test
void testSkipped() {
    // Este teste será ignorado
}
```

### Mockito
O Mockito é a biblioteca de "mocking" mais popular para Java, usada para criar objetos simulados (mocks) que imitam o comportamento de classes reais em testes unitários. Seu objetivo principal é isolar a classe que você está testando de suas dependências externas, como bancos de dados ou APIs.

**Conceitos Básicos** - Para dominar o Mockito, você precisa entender quatro pilares
* **Mock:** Um objeto falso que substitui uma classe real. Ele não executa o código original, apenas registra as chamadas e retorna o que você mandar.
* **Stubbing (Configuração de Comportamento):** Definir o que o mock deve retornar quando um método específico for chamado (ex: "quando chamar getUser, retorne este objeto fixo").
* **Verification (Verificação):** Checar se um método do mock foi realmente chamado, quantas vezes e com quais parâmetros.
* **Spy:** Uma "cópia" de um objeto real. Ele executa o código original, mas permite que você monitore chamadas ou altere apenas alguns métodos específicos.

**Anotações Principais** - No JUnit 5, usamos a extensão `MockitoExtension.class` para habilitar as anotações:
* `@Mock`: Cria uma instância simulada da dependência.
* `@InjectMocks`: Cria a instância da classe que será testada e injeta automaticamente nela os mocks criados com @Mock.
* `@Spy`: Cria um objeto parcial (mistura de real e mock).

**Exemplos Práticos** - Configurando o Teste

```java
@ExtendWith(MockitoExtension.class)
class UsuarioServiceTest {

    @Mock
    private UsuarioRepository repository; // Dependência simulada

    @InjectMocks
    private UsuarioService service; // Classe sendo testada
}
```


**Exemplo de Stubbing (Simular retorno)** - Dizemos ao Mockito para retornar um valor específico quando um método for chamado.

```java
@Test
void deveRetornarUsuarioQuandoExistir() {
    Usuario mockUsuario = new Usuario(1, "Ana");
    
    // Configuração (Stub)
    Mockito.when(repository.findById(1)).thenReturn(Optional.of(mockUsuario));

    // Execução
    Usuario resultado = service.buscarPorId(1);

    // Asserção (JUnit)
    assertEquals("Ana", resultado.getNome());
}
```


**Exemplo de Verificação (Checar chamadas)** - Garante que o código executou uma ação importante, como salvar no banco.

```java
@Test
void deveChamarSaveNoRepository() {
    Usuario novoUsuario = new Usuario("Carlos");
    
    service.salvar(novoUsuario);

    // Verifica se o método save foi chamado exatamente 1 vez com qualquer objeto Usuario
    Mockito.verify(repository, Mockito.times(1)).save(any(Usuario.class));
}
```

**Exemplo de Lançamento de Exceção** - Útil para testar como sua aplicação lida com erros inesperados.

```java
@Test
void deveLancarErroQuandoBancoFalhar() {
    // Configura o mock para lançar erro
    Mockito.when(repository.save(any())).thenThrow(new RuntimeException("Erro de conexão"));

    // Verifica se a exceção é propagada
    assertThrows(RuntimeException.class, () -> service.salvar(new Usuario()));
}
```

## Modulo 5 - Spring Boot

O Spring Boot é um framework Java de código aberto, baseado no Spring Framework, projetado para facilitar e acelerar o desenvolvimento de aplicações Java, especialmente microsserviços e APIs web.
A sua principal filosofia é "Just Run" (Apenas execute), focando na produtividade ao reduzir drasticamente a necessidade de configurações manuais (o famoso boilerplate), permitindo que o desenvolvedor foque na regra de negócio.

**Principais Características**

* **Configuração Automática (Auto-configuration):** O Spring Boot analisa as dependências no seu projeto e configura automaticamente os componentes necessários.
* **Servidores Embutidos:** Inclui contêineres como Tomcat, Jetty ou Undertow, permitindo rodar a aplicação como um arquivo JAR independente, sem precisar instalar um servidor separado.
* **Starters Opinativos:** Dependências que agrupam bibliotecas comuns, simplificando a gestão de versões e configurações.
* **Funcionalidades de Produção:** Oferece métricas, health checks e configuração externa de forma nativa.

**Principais Spring Boot Starters:** Os "starters" são um conjunto de descritores de dependência convenientes que você pode incluir em sua aplicação.

* `spring-boot-starter-web`: Essencial para construir aplicações web, incluindo APIs RESTful usando Spring MVC e o servidor Tomcat embutido.
* `spring-boot-starter-data-jpa`: Facilita a persistência de dados, incluindo Hibernate (ORM) e Spring Data JPA para interações com bancos de dados relacionais.
* `spring-boot-starter-security`: Oferece autenticação e autorização configuradas de forma automática para proteger sua aplicação.
* `spring-boot-starter-test`: Traz dependências essenciais para testes, como JUnit, Hamcrest e Mockito.
* `spring-boot-starter-actuator`: Fornece recursos prontos para produção, permitindo monitorar e gerenciar sua aplicação (métricas, saúde, info).
* `spring-boot-starter-validation`: Adiciona suporte para validação de beans (JSR-303/JSR-380), como usar @NotNull ou @Size.
* `spring-boot-starter-amqp`: Utilizado para soluções de mensageria baseadas em AMQP e RabbitMQ.

Para iniciar um projeto com essas tecnologias, a ferramenta recomendada é o [Spring Initializr](http://start.spring.io/) .

---

### Beans X Components

Beans e Components no Spring Boot são objetos gerenciados pelo contêiner IoC (Inversão de Controle). `@Component` é usado para detecção automática de classes próprias (`@Service`, `@Repository`), enquanto `@Bean` é utilizado em métodos dentro de classes `@Configuration` para registrar instâncias manualmente, comum para classes de bibliotecas de terceiros. 

**O que são Beans e Components**
* **Bean:** É qualquer objeto instanciado, montado e gerenciado pelo contêiner IoC do Spring.
* `@Component`: Anotação a nível de classe que instrui o Spring a detectá-la automaticamente através de component scanning e transformá-la em um Bean.
* `@Bean`: Anotação a nível de método usada dentro de classes @Configuration para definir explicitamente um Bean, geralmente para instanciar classes de terceiros. 


**Exemplos Práticos**
* Usando `@Component` (Autodetecção) - Ideal para classes que você cria e mantém o código-fonte (Services, Controllers, Repositories).

```java
    import org.springframework.stereotype.Component;
    
    @Component
    public class MeuServico {
        public String executar() {
            return "Serviço executado!";
        }
    }
```

* Usando `@Bean` (Configuração Explícita) - Ideal quando você precisa configurar um objeto de uma biblioteca externa, como o RestTemplate. 

```java
    import org.springframework.context.annotation.Bean;
    import org.springframework.context.annotation.Configuration;
    import org.springframework.web.client.RestTemplate;
    
    @Configuration
    public class AppConfig {
    
        @Bean
        public RestTemplate restTemplate() {
            // Exemplo de configuração manual
            return new RestTemplate();
        }
    }
```

**Resumo de Quando Usar**
* Use `@Component` para suas próprias classes (`@Service`, `@Repository`, `@Controller`).
* Use `@Bean` quando não puder anotar a classe diretamente (ex: instanciar `DataSource`, `RestTemplate`, ou configurar uma lib externa).

---

### Application Proprerties - @Value

A anotação `@Value` no Spring Boot injeta valores de configuração de arquivos application.properties ou application.yml diretamente em campos de classes Java, permitindo acesso fácil a parâmetros externos. Também aceita valores padrão usando a sintaxe `${propriedade:default}`. É ideal para configurações simples e injeções pontuais.

**Exemplos de Uso do `@Value`** - Configuração no application.properties:

```
# src/main/resources/application.properties
app.nome=MinhaAplicacao
app.versao=1.0.0
app.limite=50
```

**Injeção com `@Value` no Java:**
```java
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppConfig {

    // Injeta o valor de app.nome
    @Value("${app.nome}")
    private String nomeApp;

    // Injeta com valor padrão se app.versao não existir
    @Value("${app.versao:0.0.0}")
    private String versaoApp;

    // Injeta um valor numérico
    @Value("${app.limite}")
    private int limite;

    public void exibirConfiguracao() {
        System.out.println("Nome: " + nomeApp + ", Versão: " + versaoApp + ", Limite: " + limite);
    }
}
```

---

### Configuration Properties

Configuration Properties no `Spring Boot` permitem externalizar configurações da aplicação (banco de dados, portas, chaves de API) usando arquivos `application.properties` ou `application.yml`. Elas facilitam a alteração de comportamentos sem recompilar o código, usando `@Value` para valores simples ou `@ConfigurationProperties` para mapear grupos de propriedades. 

**Principais Formas de Configuração e Exemplos:**
* **Arquivo `application.properties` (Padrão):**

```
# Porta da aplicação
server.port=8081
# Configuração de Banco de Dados
spring.datasource.url=jdbc:mysql://localhost:3306/meudb
spring.datasource.username=root
spring.datasource.password=123456
```

* **Arquivo `application.yml` (Mais organizado):**

```yml
server:
  port: 8081
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/meudb
    username: root
    password: 123456
```

**Anotação `@ConfigurationProperties` (Recomendado para grupos)** - Agrupa propriedades relacionadas com um prefixo, proporcionando tipagem forte.

```java
@Configuration
@ConfigurationProperties(prefix = "app.security")
public class SecurityProperties {
    private String token;
    private int timeout;
    // getters e setters
}
// No application.yml: app.security.token=xyz, app.security.timeout=30  
```

**Profiles (Ambientes diferentes):**
Use `application-dev.yml` (desenvolvimento) ou `application-prod.yml` (produção). Ative no `application.properties`: `spring.profiles.active=prod`.

---

### Conceito ORM e JPA

**ORM** (Object-Relational Mapping) e **JPA** (Java Persistence API) são conceitos fundamentais para o desenvolvimento Java moderno, permitindo que desenvolvedores manipulem bancos de dados relacionais utilizando o paradigma orientado a objetos. O **ORM** atua como uma ponte, enquanto a **JPA** padroniza como essa ponte é construída em Java.

* **Conceito ORM (Mapeamento Objeto-Relacional)** - O ORM é uma técnica que mapeia tabelas de um banco de dados relacional para classes em uma linguagem orientada a objetos (como Java), e vice-versa.
    * **Problema:** Bancos relacionais usam tabelas/linhas, enquanto Java usa objetos/classes.
    * **Solução ORM:** Transforma automaticamente objetos Java em SQL (`INSERT`, `UPDATE`, `SELECT`) e vice-versa.
    * **Benefícios:** Produtividade, redução de código SQL manual, portabilidade de banco de dados e manutenção facilitada.
  
* **Conceito JPA (Java Persistence API)** - A JPA é uma especificação Java (um conjunto de regras e interfaces) para o mapeamento objeto-relacional.
  * Ela define como as anotações e APIs devem funcionar para persistir objetos Java.
  * **JPA** não é um framework, mas sim um padrão. Para usá-la, é necessário um provedor (implementação), sendo o `Hibernate` o mais popular.
  * Outros provedores incluem **EclipseLink e OpenJPA**.
  
* **Exemplo de Mapeamento JPA** - O mapeamento é feito usando anotações da JPA (`javax.persistence.*` ou `jakarta.persistence.*`) sobre as classes Java (Entidades).
> **Entidade Básica** - `Produto.java`

```java
    import jakarta.persistence.Entity;
    import jakarta.persistence.Id;
    import jakarta.persistence.GeneratedValue;
    import jakarta.persistence.GenerationType;
    import jakarta.persistence.Column;
    import jakarta.persistence.Table;
    
    @Entity // Define que a classe é uma entidade JPA
    @Table(name = "produtos") // Mapeia para a tabela 'produtos' no banco
    public class Produto {
    
        @Id // Define a chave primária
        @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incremento
        private Long id;
    
        @Column(name = "nome_produto", nullable = false, length = 100) // Configura a coluna
        private String nome;
    
        private double preco; // Mapeado automaticamente com o mesmo nome
    
        // Getters e Setters
    }
```

* **Mapeamento de Relacionamento (`Pedido - Cliente`)**
```java
    @Entity
    public class Pedido {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
    
        // Muitos pedidos para um cliente (N:1)
        @ManyToOne
        @JoinColumn(name = "cliente_id") // Define a FK
        private Cliente cliente;
    }
```

**Componentes Chave**
* `@Entity`: Declara a classe como uma entidade persistente.
* `@Id`: Identifica o atributo chave primária.
* `@Table`: Define nome, schema e catálogos da tabela.
* `@Column`: Mapeia detalhes da coluna (nome, tamanho, nulidade).
* `@ManyToOne` / `@OneToMany` / `@OneToOne` / `@ManyToMany`: Definem relacionamentos entre entidades.
* `persistence.xml`: Arquivo de configuração que define o provedor (`Hibernate`), banco de dados e credenciais.

---

### Jpa Repository

Ao utilizar o JpaRepository, você não precisa escrever implementações de banco de dados ou consultas SQL para operações comuns; o Spring gera essas implementações automaticamente em tempo de execução.

**Principais Funcionalidades:** O `JpaRepository` estende outras interfaces (`CrudRepository` e `PagingAndSortingRepository`), oferecendo um conjunto completo de ferramentas:

* **Operações CRUD:** Métodos prontos como `save()`, `findById()`, `findAll()`, `deleteById()` e `count()`.
* **Paginação e Ordenação:** Suporte nativo para retornar listas paginadas e ordenadas através de parâmetros como `Pageable` e `Sort`.
* **Query Methods:** Você pode criar consultas apenas definindo o nome do método (ex: `findByEmail(String email)`), e o Spring gera a consulta SQL automaticamente.
* **Consultas Personalizadas:** Permite o uso da anotação `@Query` para escrever consultas complexas em `JPQL` ou `SQL` nativo diretamente na interface.

**Exemplo Prático**
1. Entidade (`Entity`):

```java
    @Entity
    public class Produto {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String nome;
        private Double preco;
        // Getters e Setters
    }
```

2. Repository Interface:

```java
    import org.springframework.data.jpa.repository.JpaRepository;
    import org.springframework.stereotype.Repository;
    import java.util.List;
    
    @Repository
    public interface ProdutoRepository extends JpaRepository<Produto, Long> {
        // Busca automática por nome
        List<Produto> findByNome(String nome);
        
        // Busca produtos com preço maior que o valor informado
        List<Produto> findByPrecoGreaterThan(Double preco);
    }
```

3. Uso no Service/Controller:

```java
    @Autowired
    private ProdutoRepository produtoRepository;
    
    public void exemploUso() {
        Produto p = new Produto();
        p.setNome("Notebook");
        p.setPreco(3500.0);
        produtoRepository.save(p); // Salvar
    
        List<Produto> produtos = produtoRepository.findAll(); // Buscar todos
    }
```


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


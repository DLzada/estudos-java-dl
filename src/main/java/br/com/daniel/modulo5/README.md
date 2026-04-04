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
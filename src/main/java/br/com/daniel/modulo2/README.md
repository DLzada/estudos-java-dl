# Módulo 2: Orientação a Objetos (POO) 
> Objetivo: Sair do código procedural (tudo no main) e construir sistemas modulares, seguros e reutilizáveis. Conceito Chave: Java é noun-oriented (orientado a substantivos/coisas). Primeiro você cria a "Coisa" (Classe), depois define o que ela faz (Métodos).

---

## 📘 Tópico 1: Classes, Atributos, Métodos,Objetos e Memória (Onde eles vivem?)
Entenda a diferença entre a Planta (Classe) e a Casa Construída (Objeto).

### **Classe:** O molde/template. Não ocupa memória de execução.
   * **Padrão de Nomear Classes:** 
      > PascalCase: Primeira letra de cada palavra maiúscula
     
   * **Como Criar uma Classe:**
      ```java
         public class Contador{
            ...
         } 
      ```

### **Atributos:** Características das classes.
   * **Padrão de Nomear Atributos e métodos:**
      > camelCase: apenas a partir da segunda palavra que as letras ficam maiúsculas
     
   * **Adicionando Atributos:**
      ```java
         public class Contador{
            int primeiraParcela;
            int segundaParcela;
         }
      ```
      
### **Métodos:** Comportamento que os objetos criados tem.
  * **Tambem utiliza padrão de nomear camelCase** : apenas a partir da segunda palavra que as letras ficam maiúsculas
     
  * **Adicionando Métodos:**
      ```java
         public class Contador{
            int primeiraParcela;
            int segundaParcela;

            public int somarParcelas(){
                int total = primeiraParcela + segundaParcela;
                return total;
            }
         }
      ```
      
### **Objeto:** A instância viva na memória Heap. Dentro da classe principal do projeto, a que carrega o método main, podemos instanciar nosso objeto.
  * **Criando Objetos:**
      ```java
         public class Main{
            public static void main(String[] args){
                Contador contador = new Contador();
            }
         }
      ```
  * **Preenchendo Atributos com Valores:** 
      ```java
         public class Main{
            public static void main(String[] args){
                Contador contador = new Contador();

                contador.primeiraParcela = 100;
                contador.segundaParcela = 77;
            }
         }
      ```
  * **Chamando o método somarValores:** 
      ```java
         public class Main{
            public static void main(String[] args){
                Contador contador = new Contador();

                contador.primeiraParcela = 100;
                contador.segundaParcela = 77;

                int total = contador.somarParcelas();
                System.out.println(total)
            }
         }
      ```
      
### **Referência:** A variável na Stack (memória rápida) que aponta para o endereço na Heap.

> Código Pragmático do tópico em (classesObjetos/Carro.java e TesteCarro.java)

---

## 📘 Tópico 2: Encapsulamento e Modificadores (Segurança)
**Encapsulamento:** O princípio dele é trazer a preocupação com os acesso aos atributose métodos dentro de uma classe garantindo que os atributos não sejam alterados durante a execução ou que um mátodo restrito da classe não seja executado.

### 2.1 - Modificadores de acesso:

`public`: O modificador public permite que todas as classes dentro ou fora do mesmo pacote que a classe dona do atributo tenha acesso a ela.

`private`: O modificador private impede que qualquer classe dentro ou fora da mesma classe dona do atributo ou método tenha acesso a ela.

`protected`: O modificador protected permite que apenas as classes dentro do mesmo pacote que a classe dona do atributo/método tenha acesso a eles.

`default` (sem nada): O comportamento de acesso quando não declaramos um modificador é parecido com o do protected, apenas classe e interfaces dentro do mesmo pacote podem acessar o atributo ou mátodo.

**Exemplo:**
```java
         public class Contador{
            private int primeiraParcela;
            private int segundaParcela;

            public int somarParcelas(){
                int total = primeiraParcela + segundaParcela;
                return total;
            }
         }
```

> Declarando os atributos da classe contador como privados, não podemos mais realizar acessar livremente os atributos e preenchê-los como antes, utilizando o nome do objeto e os atributos.

```java
         // NAO FUNCIONA MAIS
          Contador contador = new Contador();
          contador.primeiraParcela = 100;
          contador.segundaParcela = 77;
```
Agora para que possamos preencher os atributos desse objeto devemos contar com o método construtor, já usamos ele naturalmente quando instânciamos a classe, ele está ali presente em todos os exemplos usados até agora. Quando usamos `new Contador();` estamos justamente chamando o método construtor que literalmente constrói a instância da nossa classe.
> OBS: A palavra `new` sempre vai representar uma nova instância de um objeto.

### 2.2 - Método Constructor:

Agora como os modificadores de acesso ao atributo da nossa classe Contador devemos criar um novo constructor para preencher esses atributos. Dentro da classe vamos criar um método que carrega o modificador de acesso `public` e que carrega `exatamente o nome da classe`. Também vamos adicionar os 2 parâmetros nesse método, que são os parâmetros que vamos receber os valores e usá-los no método para preencher nossos atributos.

**Exemplo - Classe:**
```java
         public class Contador {
            private int primeiraParcela;
            private int segundaParcela;

            public Contador(int primeiraParcela, int segundaParcela) {
                this.primeiraParcela = primeiraParcela;
                this.segundaParcela = segundaParcela;
            }
        
            public int somarParcelas() {
                return primeiraParcela + segundaParcela;
            }
        }
```

**Classe principal com o método main:**
```java
         public class Main{
            public static void main(String []args){
                Contador contador = new Contador(100,77);
                int total = contador.somarParcelas();
                System.out.printl("A soma das parcelas é: " + total);
            }
         }
```

### 2.3 - Sobrecarga de Construtores:
Em alguns casos temos a necessidade de ter mais de uma forma de construir um objeto de uma class. Nesses casos contamos com a sobrecarga de construtores que permite realizar diferente tipos de construções de instâncias de uma classe.

**Exemplo - Classe:**
```java
         public class Contador {
            private int primeiraParcela;
            private int segundaParcela;

            public Contador(int primeiraParcela, int segundaParcela) {
                this.primeiraParcela = primeiraParcela;
                this.segundaParcela = segundaParcela;
            }
        
            public Contador(int primeiraParcela) {
                this.primeiraParcela = primeiraParcela;
                this.segundaParcela = 0;
            }

            public int somarParcelas() {
                return primeiraParcela + segundaParcela;
            }
        }
```

**Classe principal com o método main:**
```java
         public class Main{
            public static void main(String []args){
                Contador contadorUm = new Contador(100,77);
                Contador contadorDois = new Contador(100);
                
            }
         }
```

### 2.4 - Métodos Gets e Setters:
Outra forma de dar acesso a atributos privados é através dos métodos Get e Set de cada atributo. Um método get é criado para retornar o valor do atributo enquanto o méto set é feito para alterar o valor de um atributo.
  * Get = Pegar
  * Set = Inserir
    
Esses métodos são totalmente opcionais e devem ser criados apenas se for necessário o acesso a esse atributo, isso faz sentido quando pensamos que alguns atributos de controle de classes não devem ser alterados, apenas visualizados (get) ou apenas alterados e não visualizados (set). Os métodos set e get também podem carregar alguma regra de negócio específica antes de alterar o valor no caso do set, por exemplo, assim garantimos que o atributo será peenchido apenas com valores corretos.

**Classe Contador:**
```java
         public class Contador{

            private primeiraParcela;
            private segundaParcela;

            public int getPrimeiraParcela(){
              return primeiraParcela();
            }

            public void setPrimeiraParcela(int primeiraParcela){
              this.primeiraParcela = primeiraParcela;
            }

            public int getSegundaParcela(){
              return segundaParcela();
            }

            public void setSegundaParcela(int segundaParcela){
              this.segundaParcela = segundaParcela;
            }
         }
```

Vale ressaltar que o padrão dos nomes dos métodos Get e Set são fundamentais para o funcionamento de alguns framework como Spring que procura esses métodos para criar ou receber um Json.

**Regra de ouro:** Nunca deixe seus atributos públicos. Se alguém puder fazer conta.saldo = -5000, seu sistema falhou.

> Código Pragmático do tópico em (encapsulamento/ContaBancaria.java)

---

## 📘 Tópico 3: Herança e Polimorfismo (O Poder do "É Um")
Não repita código. Se Gerente tem nome e Programador tem nome, crie um Funcionario.

## 3.1 - Herança: 
Um dos principais pilares de um liguagem orientada a objetos. POr meio dela é possível realizar reaproveitamento de códigos através da criação de uma classe base (Também conhecida como superclasse), que permite que diversas outras classes (chamadas de subclasses ou classes derivadas) recebam características em comum de sua classe mãe. 

### 3.1.1 - Utilizando Herança
Suponhamos que nós fomos contratado para desenvolver um sistema de gestão para a escola X. Em uma das etapas, percebemos que precisaríamos criar duas classe: uma classe chamada técnicos admistrativos e uma classe chamada professores. Por mais que ambas possuam características e permissões diferentes, ambas possuem nome, telefone e cpf, por exemplo. 
Neste Caso, ao invés de criar duas classes independentes com os mesmo atributos, podemos criar uma classe "mãe" chamada funcionário, na qual professores e técnicos irão herdar todas as características que eles possuem em comum. Isso não significa que eles terão as mesmas características, afinal, alunos e professores ainda são classes independentes, porém, ambos terão nome, cpf e telefone que herdaram de sua classe base.
Primeiro, vamos observar o conteúdo da classe funcionário, e posteriormente, vamos criar uma relação de hereança entre a classe Funcionário e a classe professores, alegando que um professor é um funcionário.

**Classe Funcionário:**
```java
         public class Funcionario{

            private String nome;
            private String telefone;
            private String cpf;

            public Funcionario(String nome, String telefone, String cpf){
                this.nome = nome;
                this.telefone = telefone;
                this.cpf = cpf;
            }

            public String getNome(){
              return nome;
            }

            public String getTelefone(){
              return telefone;
            }

            public String getCpf(){
              return cpf;
            }
         }
     
```

No código abaixo iremos estabelecer uma relação de herança entre a classe **Funcionario** e suas subclasses: **Professor** e **TecnicoAdministrativo**.

```java
          public class Professor extends Funcionario{
            // Conteudo da subclasse Professor
          }

          public class TecnicoAdministrativo extends Funcionario{
            // Conteudo da subclasse Tecnico Administrativo
          }
     
```
### 3.1.2 - This e Super
**This:** Este comando é fundamntal na criação dos "setter" em nosso código. Afinal, a responsabilidade desse comando é fazer referência a algum atributo encapsulado dentro de sua própria classe, como por exemplo, se quisermos criar os setters em nossa class Funcionario.

```java
          public class Funcionario{

            private String nome;
            private String telefone;
            private String cpf;

            public Funcionario(String nome, String telefone, String cpf){
                this.nome = nome;
                this.telefone = telefone;
                this.cpf = cpf;
            }

            public String getNome(){
              return nome;
            }

            public String getTelefone(){
              return telefone;
            }

            public String getCpf(){
              return cpf;
            }

            public void setNome(String nome){
              this.nome = nome;
            }

            public void setTelefone(String telefone){
              this.telefone = telefone;
            }

            public void setCpf(String cpf){
              this.cpf = cpf;
            }

         }
     
```
Repare que dentro do **setNome**, nós recebemos uma string como argumento e inserimos essa string recebida dentro do `this.nome`. Nesse caso, como o comando `this` foi acionado, nós estamos incrementando o argumento recebido   diretamente no atributo declarado em cima da classe, é como se estivéssemos fazendo uma ligação direta ao `private String nome;`, conectando o conteúdo do método ao dado encapsulado anteriormente. Uma informação interessante, é que o comando this é opcional quando, no método, o nome dos parâmetros são diferentes dos atributos.

**Super:** Já o Super, ao invés de fazer referência a um atributo dentro da própria classe, ele faz referência direta a atributos e métodos presentes dentro de sua superclasse, na qual você estabeleceu uma relação de herança. Em termos técnicos, você estará invocando o construtor de sua superclasse **Funcionario**, fazendo com que professores e técnicos administrativos tenham acesso aos dados então encapsulados de sua classe base.

```java
          public class Professor extends Funcionario{
            public Professor(String nome, String telefone, String cpf){
              super(nome, telefone, cpf);
            }

          }

          public class TecnicoAdministrativo extends Funcionario{
            public TecnicoAdministrativo(String nome, String telefone, String cpf){
              super(nome, telefone, cpf);
            }
          }
```

No exemplo acima, podemos ver uma aplicação clássica do comando **super**. Onde criamos o método contrutor das classes, nós invocamos também através do comando `super` as características herdadas da classe mãe, sendo elas: nome, telefone e cpf. Com isso, conseguimos por meio da herança aproveitar os atributos criados na classe base em nossas subclasses, diminuindo o tempo de criação e aumentando a qualidade do código.

Em resumo, o `this` possui a responsabilidade de criar uma conexão entre o método e os atributos encapsulados dentro de sua própria classe, enquanto o `super`, é utilizado sempre que desejamos acessa/manipular atributos e métodos estruturados na classe mãe de nossa subclasse em questão.

## 3.2 - Polimorfismo

De modo genérico, polimorfismo significa "muitas vezes". Na prática, o termo é utilizado quando temos duas ou mais classes derivadas da mesma superclasse compartilhando métodos de mesma assinatura, porém, com comportamentos diferentes.

Para se compreender melhor o mesmo na prática, vamos trabalhar com um exemplo de formas geométricas. Inicialmente, vamos criar uma classe genérica chamada **FormasGeometricas** e estabelecer uma relação  de herança entre esta classe com suas duas subclasses: **Circulo** e **Quadrado**.

```java
          public class FormasGeometricas{
            ...
          }

          public class Circulo extends FormasGeometricas{
            ...
          }

          public class Quadrado extends FormasGeometricas{
            ...
          }

```

Depois de criar as classes, vamos criar um método que será responsável por calcular a área de cada uma das formas geométricas. Porém, temos um grande problema:

  * Para calcular a área do quadrado, nós necessitamos de um lado, afinal, um quadrado nada mais é do que uma forma de quatro lados iguais.
  * Já para calcular a área do cículom nós precisamos so raio, que é a distância do centro até a borda do círculo.
Neste caso, precisamos de um método comum para ambas as classes que deve respeitar as suas características.

```java
          public class FormasGeometricas{
            public double calcularArea(){
              return 0;
            }
          }

```

Acima criamos o método na classe base que por enquanto vai retornar 0, afinal vamos reescrevê-lo nas subclasses com a mesma assinatura mas com comportamentos diferentes, respeitando as especificidades de cada classe. Processo conhecido como **polimorfismo dinâmico**, onde uma subclasse redefine um método presente na superclasse.

```java
          public class Circulo extends FormasGeometricas{
            double raio;

            public Circulo(double raio){
              this.raio = raio;
            }

            @Override
            public double calcularArea(){
              double area = 0;
              area = 3.14 * raio * raio;
              return area;
            }
          }

```

Acima, temos a reescrita do método criado na superclasse dentro da subclasse **Circulo**. O método possui a mesma assinatura, porém, o conteúdo é diferente retornando o cálculo da área do círculo (3.14 * raio * raio).

```java
          public class Quadrado extends FormasGeometricas{
            double lado;

            public Circulo(double lado){
              this.lado = lado;
            }

            @Override
            public double calcularArea(){
              double area = 0;
              area = lado * lado;
              return area;
            }
          }
```

Acima, temos também a sobreposiçao do método **CalcularArea**, da classe `Quadrado`, onde o método possui a mesma assinatura de sua classe base, porém retornando o cáculo da área do quadrado `(lado * lado)`. Como podemos perceber em amabas as classes, sempre que um método é sobreposto, a palavra `@Override` aparece por cima do método, representando uma sobreposição.

> Código Pragmático do tópico em (herancaPolimorfismo)

---

## 📘 Tópico 4: Classes Abstratas

Classes abstratas são classes genéricas que possuem um nível tão alto de abstração que não faz mais sentido criar objetos a partir dela. Uma grande característica das classes abstratas é que elas não podem ser instanciadas, apenas herdadas, servindo apenas como molde para classes concretas que serão geradas a partir delas, como podemos ver no exemplo abaixo:

```java
          public abstract class Animal{
            //Conteundo da classe
          }

          public class Baleia extends Animal{
            //Conteundo da classe
          }

          public class Cachorro extends Animal{
            //Conteundo da classe
          }

          public class Papagaio extends Animal{
            //Conteundo da classe
          }
```
No exemplo acima, podemos observar a criação de uma classe abstrata chamada "Animal", tendo uma relação de herança com as outras classes presentes no código. Sempre que queremos criar uma classe abstrata, devemos utilizar o comando `abstract class`, assim o java compreenderá que aquele elemento é uma classe abstrata, que pode ser herdada por outras classes concretas, mas jamais instanciada.

### 4.1 - Métodos Abstratas
Métodos abstratos são métodos que não possuem corpo, apenas assinatura e esses métodos devem ser obrigatoriamente implementados dentro de suas classes filhas com o objetivo de definir o comportamento específico de cada uma, Exemplo:

```java
          public abstract class Animal{
            abstract void formaDeMover();
          }

          public class Baleia extends Animal{
            @Override
            public void formaDeMover(){
              System.out.println("Nadando");
            }
          }

          public class Cachorro extends Animal{
            @Override
            public void formaDeMover(){
              System.out.println("Andando");
            }
          }

          public class Papagaio extends Animal{
            @Override
            public void formaDeMover(){
              System.out.println("Voando");
            }
          }
```

No exemplo acima, podemos observar a criação de um método abstrato `abstract void formaDeMover();` dentro de uma classe abstrata. Como afirmamos anteriormente, este método não possui conteúdo, mas deve obrigatoriamente ser implementado em suas subclasses com suas especificações. Neste Caso em específico, todos os animais possuem suas formas de se mover, implementando o conceito abstrato de "Se mover".

### 4.2 - Classes Abstratas x Classes concretas

<table>
  <tbody>
    <tr>
      <th>Classe Abstratas</th>
      <th>Classes Concretas</th>
    </tr>
    <tr>
      <td><b>Não pode ser instanciada</b>, mas pode estabeler relação de <b>herança</b>.</td>
      <td>Pode ser <b>instanciada</b> e pode estabelecer relação de <b>herança</b>.</td>
    </tr>
    <tr>
      <td>Pode receber métodos abstratos e métodos concretos (Com implementação).</td>
      <td>Pode conter <b>apenas</b> métodos concretos, com implementação.</td>
    </tr>

  </tbody>
</table>

## 📘 Tópico 5: Interfaces (O Contrato Absoluto)

Interfaces são estruturas que definem um contrato de comportamento que as classes devem seguir. Elas são, por padrão, 100% abstratas, o que significa que elas apenas definem "o que" deve ser feito, deixando para a classe a responsabilidade de implementar o "como".

### 5.1 - Diferenciais Estratégicos
* **Múltiplos Contratos:** Uma das maiores vantagens é que uma classe pode implementar **múltiplas interfaces**, superando a limitação da herança única do Java (onde só se pode herdar de uma classe pai).
* **Base do Spring Boot:** Este conceito é crucial, pois o ecossistema Spring é quase inteiramente baseado em interfaces para permitir que diferentes componentes se comuniquem de forma desacoplada.

> Código Pragmático (interfaces)

---

### LocalDate - Java:

O LocalDate é uma classe imutável que representa uma data sem fuso horário (fuso horário zero/local) no formato ISO-8601 (AAAA-MM-DD).

```java
    import java.time.LocalDate;

    public class Main {
        public static void main(String[] args) {
    
            // Captura a data atual do sistema
            LocalDate localDate = LocalDate.now();
    
            // Exibe a data completa (AAAA-MM-DD)
            System.out.println(localDate);
    
            // Extraindo informações específicas da data
            System.out.println("Dia da semana (nome): " + localDate.getDayOfWeek().name());
            
            // Dia da semana
            System.out.println("Dia da semana (ordinal): " + localDate.getDayOfWeek().getValue());
            
            System.out.println("Mes (nome): " + localDate.getMonthValue());
            System.out.println("Mes (ordinal): " + localDate.getMonth().name());
            System.out.println("Ano: " + localDate.getYear());
            
            // Verificação de ano bissexto
            System.out.println("Ano bissexto: " + localDate.isLeapYear());
            
            // Informações sobre a duração do período
            System.out.println("Número de dias do mês: " + localDate.lengthOfMonth());
            System.out.println("Número de dias do ano: " + localDate.lengthOfYear());
        }
    }
```
---

## Local Date Time: 

O LocalDateTime é uma classe imutável que representa a combinação de Data e Hora. É a escolha ideal quando você precisa registrar o momento exato de um evento (como o horário de uma venda ou a criação de um post).
**O que é?** Diferente do LocalDate, ele armazena a precisão do tempo.

> Formato padrão: AAAA-MM-DDTHH:MM:SS.nnn (O 'T' separa a data da hora).

```java
    import java.time.LocalDateTime;
    import java.time.format.DateTimeFormatter;
    
    public class EstudoLocalDateTime {
        public static void main(String[] args) {
            
            // 1. Captura data e hora atual
            LocalDateTime agora = LocalDateTime.now();
            System.out.println("Agora: " + agora);
    
            // 2. Criando uma data e hora específica (Ex: 25/12/2026 às 20:30)
            LocalDateTime natal = LocalDateTime.of(2026, 12, 25, 20, 30);
            System.out.println("Natal: " + natal);
    
            // 3. Extraindo informações
            System.out.println("Hora: " + agora.getHour());
            System.out.println("Minuto: " + agora.getMinute());
            System.out.println("Segundo: " + agora.getSecond());
    
            // 4. Manipulação (Retorna nova instância)
            LocalDateTime daquiDuasHoras = agora.plusHours(2);
            LocalDateTime semanaPassada = agora.minusWeeks(1);
    
            // 5. Formatação (Padrão Brasileiro)
            DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            System.out.println("Formatado: " + agora.format(formatador));
        }
    }
```

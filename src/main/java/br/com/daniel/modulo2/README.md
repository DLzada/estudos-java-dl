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

**Regra de ouro:** Nunca deixe seus atributos públicos. Se alguém puder fazer conta.saldo = -5000, seu sistema falhou.

> Código Pragmático do tópico em (encapsulamento/ContaBancaria.java)

---

## 📘 Tópico 3: Herança e Polimorfismo (O Poder do "É Um")
Não repita código. Se Gerente tem nome e Programador tem nome, crie um Funcionario.

* **extends:** Herda tudo que não é privado.

* **super:** Chama construtor ou método da classe pai.

* **@Override:** Sobrescreve um comportamento padrão.

* **Polimorfismo:** Tratar objetos diferentes de forma genérica.

> Código Pragmático do tópico em (herancaPolimorfismo)

---

## 📘 Tópico 4: Interfaces (O Contrato Absoluto)
 Isso é crucial. O Spring Boot é baseado em Interfaces. Uma interface diz O QUE fazer, não COMO. Classes podem implementar MÚLTIPLAS interfaces (mas só herdam de UMA classe).

> Código Pragmático (interfaces)

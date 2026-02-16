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

<table>
  <tbody>
    <tr>
      <th>Modificador</th>
      <th>Detalhes</th>
    </tr>
    <tr>
      <td> public </td>
      <td> O modificador public permite que todas as classes dentro ou fora do mesmo pacote que a classe dona do atributo tenha acesso a ela.</td>
    </tr>


  </tbody>
</table>

`private`: Só a própria classe vê.

`public`: Todo mundo vê.

`protected`: Só filhos e classes do mesmo pacote veem.

`default` (sem nada): Só classes do mesmo pacote.

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

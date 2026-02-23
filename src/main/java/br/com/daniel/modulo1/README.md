# Módulo 1: Fundamentos da Linguagem e Memória

## 📘 Tópico 1: A "Máquina" (JVM e o Main)
Em Java, tudo roda dentro de uma máquina virtual (JVM). O código começa sempre num método específico.

* Conceito:

`public`: Visível para a JVM iniciar.

`static`: Não precisa criar um objeto (new) para rodar.

`void`: Não retorna valor.

`String[] args`: Recebe parâmetros da linha de comando.

> Código Pragmático do Tópico em (Main.java)

---

## 📘 Tópico 2: Memória - Primitivos vs Wrappers
Aqui é onde 90% dos erros de NullPointerException nascem.

**Conceito:**

* **Primitivos (int, double, boolean):** Armazenam o valor direto na memória Stack. São rápidos e nunca são nulos. Padrão é 0 ou false.

* **Wrappers (Integer, Double, Boolean):** São Classes (Objetos). Armazenam uma referência na Stack que aponta para um objeto na Heap. Podem ser null.

### **Tipos Primitivos:**

<table>
  <tbody>
    <tr>
      <th>Tipos</th>
      <th>Sobre</th>
    </tr>
    <tr>
      <td><b>byte</b></td>
      <td>8 bits - Armazenam números inteiros de -128 à 127</td>
    </tr>
    <tr>
      <td><b>short</b></td>
      <td>16 bits - Armazenam números inteiros de -32.768 à 32.767</td>
    </tr>
    <tr>
      <td><b>int</b></td>
      <td>32 bits - Armazenam números inteiros de -2.147.483.648 à 2.147.483.647</td>
    </tr>
    <tr>
      <td><b>long</b></td>
      <td>32 bits - Armazenam números inteiros de -2^63 à 2^63</td>
    </tr>
  </tbody>
</table>


### Palavras Reservadas Java (Nao nomear nada com elas): 

<table >
  <thead>
    <tr>
      <th>Categoria</th>
      <th>Palavras-Chave</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td><strong>Tipos Primitivos</strong></td>
      <td>boolean, byte, char, double, float, int, long, short</td>
    </tr>
    <tr>
      <td><strong>Controle de Fluxo</strong></td>
      <td>break, case, continue, default, do, else, for, if, return, switch, while</td>
    </tr>
    <tr>
      <td><strong>Tratamento de Erros</strong></td>
      <td>assert, catch, finally, throw, throws, try</td>
    </tr>
    <tr>
      <td><strong>Modificadores</strong></td>
      <td>abstract, final, native, private, protected, public, static, strictfp, synchronized, transient, volatile</td>
    </tr>
    <tr>
      <td><strong>Definições/Estrutura</strong></td>
      <td>class, enum, extends, implements, import, interface, package, super, this, void</td>
    </tr>
    <tr>
      <td><strong>Outros / Literais</strong></td>
      <td>instanceof, new, true, false, null</td>
    </tr>
    <tr>
      <td><strong>Não Utilizadas (Reservadas)</strong></td>
      <td>const, goto</td>
    </tr>
  </tbody>
</table>

> Código Pragmático do tópico em (TiposDados.java)

---

## 📘 Tópico 3: O Pool de Strings (Imutabilidade)
Strings em Java são especiais. Se você não entender isso, vai criar bugs de lógica.

**Conceito:**

* Strings são imutáveis. Uma vez criada, não muda. Se você concatenar, o Java cria uma nova String na memória.

* **String Pool:** Uma área especial da memória para economizar espaço.

> Código Pragmático do Tópico em (StringMaster.java)

---

## 📘 Tópico 4: Arrays e Controle de Fluxo
Diferente do JS/TS, Arrays em Java têm tamanho fixo. Nasceu com 5 posições, morre com 5.

> Código Pragmático (ArraysLoop.java)

---

### Operadores de comparação 

<table>
  <tbody>
    <tr>
      <th>Operador</th>
      <th>Siginificado</th>
      <th>Exemplo</th>
    </tr>
    <tr>
      <td>==</td>
      <td>Igual</td>
      <td>x == y</td>
    </tr>
    <tr>
      <td>!=</td>
      <td>Diferente</td>
      <td>x != y</td>
    </tr>
    <tr>
      <td>></td>
      <td>Maior que</td>
      <td>x > y</td>
    </tr>
    <tr>
      <td><</td>
      <td>Menor que</td>
      <td>x < y</td>
    </tr>
    <tr>
      <td>>=</td>
      <td>Maior ou igual que</td>
      <td>x >= y</td>
    </tr>
    <tr>
      <td><=</td>
      <td>Menor ou igual que</td>
      <td>x <= y</td>
    </tr>

  </tbody>
</table>

### Operadores Lógicos

<table>
  <tbody>
    <tr>
      <th>X</th>
      <th>Y</th>
      <th>X && Y </th>
      <th>X || Y</th>
      <th>!X</th>
    </tr>
    <tr>
      <td>true</td>
      <td>true</td>
      <td>true</td>
      <td>true</td>
      <td>false</td>
    </tr>
    <tr>
      <td>true</td>
      <td>false</td>
      <td>false</td>
      <td>true</td>
      <td>false</td>
    </tr>
    <tr>
      <td>false</td>
      <td>true</td>
      <td>false</td>
      <td>true</td>
      <td>true</td>
    </tr>
    <tr>
      <td>false</td>
      <td>false</td>
      <td>false</td>
      <td>false</td>
      <td>true</td>
    </tr>
  </tbody>
</table>

### Fluxo de controle (If - else - else if)
> Verifica a idade com as seguintes condições

```java
      public class Main{
        public static void main(String[] args){
            int idade = 17;
            if(idade >= 18){
              System.out.println("Acesso liberado")
            } else if(idade == 17){
              System.out.println("Só pode entrar com um responsável!")
            } else{
              System.out.println("Nao pode entrar")
            }
        }
      }
```

> Verificando com If - else - else if:

```java
      public class Main{
        public static void main(String[] args){
            float provaSemestral = 7, tcc = 8, av1 = 10, av2 = 8;
            double mediaFinal = provaSemestral * 0.5 + tcc * 0.3 ((av1 + av2) / 2) * 0.2;

            System.out.println("A media final é: " + mediaFinal);

            if(mediaFinal >= 6){
              System.out.println("Aprovado");
            } else if(mediaFinal >= 3){
              System.out.println("Está na recuperação");
            } else{
              System.out.println("Reprovado");
            }
        }
      }
```
---

### Recebendo valores de entrada:
 
```java
import java.util.Scanner;

      public class Main{
        public static void main(String[] args){
            Scanner entrada = new Scanner(System.in); // Inicializa o Scanner

            System.out.println("Informe a nota da prova semestral: ");
            float provaSemestral = entrada.nextFloat();

            System.out.println("Informe a nota do seu TCC: ");
            float tcc = entrada.nextFloat();

            System.out.println("Informe a nota da Avaliação 1: ");
            float av1 = entrada.nextFloat();

            System.out.println("Informe a nota da Avaliação 2: ");
            float av2 = entrada.nextFloat();

            double mediaFinal = provaSemestral * 0.5 + tcc * 0.3 ((av1 + av2) / 2) * 0.2;
            System.out.println("A media final é: " + medialFinal);

            if(mediaFinal >= 6){
              System.out.println("Aprovado");
            } else if(mediaFinal >= 3){
              System.out.println("Está na recuperação");
            } else{
              System.out.println("Reprovado");
            }
        }
      }
```

---

### Operadores Ternários - condicao ? se verdadeiro colocar comando : se falso colocar comando

> Ex: Implemente um programa que recebe a quantidade de laranjas que o cliente deseja comprar e se o pagamento será por pix ou não (boolean).
Caso a quantidade de laranjas seja menor do que 10, o valor de cada laranja será R$ 2,50. Caso seja maior ou igual a 10, o valor será R$ 2,00.Se o pagamento for por pix, será adicionado um desconto de 10%.

```java
import java.util.Scanner;

      public class Main{
        public static void main(String[] args){
            Scanner entrada = new Scanner(System.in); // Inicializa o Scanner

            System.out.println("Informe a quantidade de laranjas: ");
            var laranjas = entrada.nextInt();

            System.out.println("A forma de pagamento é PIX? (true ou false): ");
            boolean pix = entrada.nextBoolean();

            double valor = laranjas < 10 ? 2.5 : 2;
            double desconto = pix == true ? 0.9 : 1;

            double valorFinal = valor * laranjas * desconto;

  	        System.out.println("Valor: " + valorFinal);
        }
      }
```

---

###Switch case:

```java
import java.util.Scanner;

      public class Main{
        public static void main(String[] args){
            Scanner leitor = new Scanner(System.in); // Inicializa o Scanner

            System.out.println("Escolha: \n"
                               + "1 - Pesquisar usuário \n"
                               + "2 - Cadastrar usuário \n"
                               + "3 - Abrir pedido \n"
                               + "4 - Fechar pedido \n"      
                                          );
            int opcao = leitor.nextInt();
            //Com If e else
            /*
            *if(opcao == 1){
            *    System.out.println(opcao + " - Pesquisar Usuário");
            *} else if(opcao == 2){
            *    System.out.println(opcao + " - Cadastrar Usuário");
            *} else if(opcao == 3){
            *    System.out.println(opcao + " - Abrir pedido");
            *} else if(opcao == 4){
            *    System.out.println(opcao + " - Fechar pedido");
            *} else{
            *    System.out.println("Opção inválida");
            *}
            */

            //Com Switch case
            swich (opcao){
                case 1:
                  System.out.println(opcao + " - Pesquisar Usuário");
                  break;
                case 2:
                  System.out.println(opcao + " - Cadastrar Usuário");
                  break;
                case 3:
                  System.out.println(opcao + " - Abrir pedido");
                  break;
                case 4:
                  System.out.println(opcao + " - Fechar pedido");
                  break;
                default:
                  System.out.println(opcao + " - Opcao Invalida")
            }  
        }
      }
```
---

### Cometários em Java:
```java
    public class Main{
        public static void main(String[] args){
            //inpultando a primeira nota
            int nota1 = 8;

            //inpultando a segunda nota
            int nota2 = 5;

            //Impultando a quantidade de notas
            var qantNotas = 2;

            /*
              Para calcular a media eu soma as notas e divido pela quantidade de notas - Isto é um comentário de Bloco
            */
            double media = (nota1 + nota2)/ quantNotas;

            System.out.println("A média é: " + media);
        }
      }
```

---

### Comparando dados

### Tabela Verdade 1

> Só vou ao mercado se **não** estiver chovendo e se eu tiver dinheiro.

<table>
  <tbody>
    <tr>
      <th>Está Chovendo</th>
      <th>Tenho Dinheiro</th>
      <th>Vou ao mercado</th>
    </tr>
    <tr>
      <td>Verdade</td>
      <td>Verdade</td>
      <td>Falso</td>
    </tr>
    <tr>
      <td>Falso</td>
      <td>Verdade</td>
      <td>Verdadeiro</td>
    </tr>
    <tr>
      <td>Verdadeiro</td>
      <td>Falso</td>
      <td>Falso</td>
    </tr>
    <tr>
      <td>Falso</td>
      <td>Falso</td>
      <td>Falso</td>
    </tr>

  </tbody>
</table>

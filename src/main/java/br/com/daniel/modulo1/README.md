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
            //declarando a primeira nota
            int nota1 = 8;

            //declarando a segunda nota
            int nota2 = 5;

            //declarando a quantidade de notas
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

### Estruturas de repetição: 
As estruturas de repetição, conhecidas também como loops, são ferramentas essenciais na programação em Java. Elas permitem que um bloco de código seja executado repetidamente enquanto uma condição é verdadeira. Essa funcionalidade é especialmente útil quando precisamos automatizar tarefas repetitivas, como iterar sobre coleções de dados ou realizar cálculos complexos em ciclos.

Em Java, as principais estruturas de repetição são: `for`, `while`, `do-while` e `for-each`. Cada uma delas tem características específicas e é mais adequada para determinados contextos. 

**For:**

O loop `for` é amplamente utilizado quando o número de iterações é conhecido antecipadamente. Ele possui três componentes principais: inicialização, condição e incremento. Esse tipo de estrutura é ideal quando trabalhamos com intervalos definidos, como em contagens ou iterações sobre arrays com tamanho fixo.
> Estrutura:
```java
        // Estrutura:
        for(<inicializacao>; <condicao>; <incremento ou decremento>){
          ...
        }    
```

> Exemplo 1:
```java
        public class Main{
          public static void main(String[] args){
              // Exemplo
              for(int i = 0; i < 50; i++){
                System.out.println(i);
              }
          }
        }  
```

> Exemplo 2:
```java
        import java.util.Scanner;

        public class Main{
          public static void main(String[] args){

              Scanner leitor = new Scanner(System.in); // Inicializa o Scanner
              System.out.println("Digite o numero de alunos: ");
              int qtd = leitor.nextInt();

              double somaNotas = 0;
  
              for(int i = 0; i < qtd; i++){
                 System.out.println("Digite a nota do " + (i + 1) + " aluno");
                 double nota = nextFloat();

                 if(nota < 0 || nota > 10){
                  System.out.println("Nota invalida");
                  i--; 
                 } else{
                    somaNotas += nota;
                 }
              }
              double media = somaNotas/qtd;
              System.out.println("A média de Nota da turma é: " + media);   
          }
        }
```

**While - Enquanto:**

Por outro lado, o loop `while` é indicado quando não sabemos de antemão quantas vezes o código precisará ser repetido, mas temos uma condição que será verificada a cada ciclo. Enquanto essa condição for verdadeira, o bloco de código continuará sendo executado.
> Um exemplo prático seria a leitura de dados em um sistema até que o usuário insira um comando específico para encerrar.

> Estrutura:
```java
      while(<condição lógica>){
      ...
      }
```

> Exemplo:
```java
      public class Main{
        public static void main(String[] args){
          int i = 0;
          while(i <= 50){
            System.out.println(i);
            i++;
          }  
        }
      }
```

**Do While:**

A estrutura `do-while` funciona de maneira semelhante ao `while`, mas com uma diferença importante: ela garante que o bloco de código será executado pelo menos uma vez, pois a condição de verificação só ocorre após a execução do código. Essa peculiaridade é útil em situações onde é necessário executar uma ação antes de verificar se a condição de término foi atingida, como quando pedimos uma entrada de dados ao usuário e queremos garantir que ele sempre faça uma primeira tentativa.

> Estrutura:
```java
      do{
        //instruções
      } while(<condição lógica>)
```

> Exemplo:
```java
      int i = 0;
      do{
        System.out.println(i)
        i++;
      } while(i <= 50);
```

**For each:**

Outra estrutura amplamente usada é o `for-each`, uma variação simplificada do `for` que é ideal para percorrer coleções, como arrays ou listas, sem a necessidade de controlar manualmente os índices. Ele permite iterar diretamente sobre os elementos da coleção, tornando o código mais limpo e fácil de entender. Ao utilizar o `for-each`, o desenvolvedor se livra da preocupação com detalhes de controle, como o tamanho da coleção ou o incremento de um contador, e foca diretamente no processamento dos dados.

> Estrutura
```java
    for (Tipo item : colecao) {
    // Código a ser executado com o 'item'
    }
```

> Exemplo 1 (Array de Strings):
```java
  public class Main {
      public static void main(String[] args) {
          String[] tecnologias = {"Java", "Next.js", "Spring Boot", "Prisma"};
  
          System.out.println("Minha stack atual:");
          for (String tech : tecnologias) {
              System.out.println("- " + tech);
          }
      }
  }
```

> Exemplo 2 (soma de números):
```java
  public class Main {
      public static void main(String[] args) {
          int[] notas = {8, 9, 7, 10};
          int soma = 0;
  
          for (int nota : notas) {
              soma += nota;
          }
  
          System.out.println("Soma total: " + soma);
      }
  }
```

### Aviso importante sobre loops:
> Apesar de serem ferramentas poderosas, é necessário seguir algumas boas práticas ao utilizar as estruturas de repetição. Evitar loops infinitos é uma delas. Um loop infinito ocorre quando a condição de término nunca é alcançada, resultando em uma execução contínua do bloco de código, o que pode causar travamentos ou consumo excessivo de recursos. Outra recomendação é utilizar os comandos `break` e `continue` com moderação. O `break` interrompe o loop imediatamente, enquanto o `continue` faz com que a próxima iteração seja executada, pulando o código restante do ciclo atual. Embora úteis em certos cenários, o uso excessivo desses comandos pode prejudicar a legibilidade do código e dificultar sua manutenção.

> 1. Break: O break encerra o loop imediatamente. Ele "quebra" a estrutura e pula para a primeira linha de código após o bloco de repetição.
> Exemplo: Imagine que você está procurando um erro específico em um log de 1000 linhas. Assim que encontrar, não precisa ler o resto.

```java
  for (int i = 1; i <= 10; i++) {
      if (i == 5) {
          System.out.println("Achei o 5! Parando a busca...");
          break; // Sai do loop completamente
      }
      System.out.println("Verificando número: " + i);
  }
```
> 2. **Continue** : O continue pula a iteração atual. Ele ignora o que vem abaixo dele e volta para o topo do loop para a próxima rodada (ou para a verificação da condição).
> Exemplo: Imprimir apenas números ímpares (pulando os pares).
```java
  for (int i = 1; i <= 10; i++) {
      if (i % 2 == 0) {
          continue; // Pula para o próximo 'i' sem executar o print abaixo
      }
      System.out.println("Número ímpar: " + i);
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

## Módulo 3 - Collections

### Array e Listas:

Arrays (vetores) em Java possuem tamanho fixo e são ideais para dados estáticos, enquanto Listas (ArrayList) são redimensionáveis e flexíveis para dados dinâmicos. Ambos armazenam elementos sequenciais (iniciados em 0), mas listas oferecem métodos avançados (add, remove, size) e armazenam apenas objetos, enquanto arrays aceitam tipos primitivos.

**Principais Diferenças e Uso:**

* **Arrays (String[], int[]):**
    * **Tamanho Fixo:** Não pode ser alterado após a criação.
    * **Desempenho:** Mais rápido para acesso direto pelo índice.
    * **Uso:** Quando o número de elementos é conhecido e constante.
    * **Exemplo:** `int[] numeros = new int[5];`


* **Listas (ArrayList, LinkedList):**
    * **Tamanho Dinâmico:** Redimensiona automaticamente ao adicionar ou remover elementos.
    * **Flexibilidade:** Métodos como add(), remove(), contains(), size() facilitam a manipulação.
    * **Uso:** Quando o tamanho da coleção pode mudar.
    * **Exemplo:** `List<String> nomes = new ArrayList<>();`


* **Conversão entre Listas e Arrays:**
    * **Lista para Array:** Utilize o método list.toArray().
    * **Array para Lista:** Utilize Arrays.asList(array) ou new ArrayList<>(Arrays.asList(array)).


* **Principais Métodos de Listas (ArrayList):**
* **add(elemento)**: Adiciona ao final.
* **get(index)**: Acessa um elemento.
* **remove(index)**: Remove por posição.
* **size()**: Retorna o tamanho atual.

---

### Set: 

Um Set em Java é uma coleção da interface java.util.Set que não permite elementos duplicados e garante a unicidade, sendo ideal para conjuntos matemáticos ou coleções únicas. Diferente da List, não garante ordem específica (dependendo da implementação). As implementações principais são HashSet (rápido, sem ordem), LinkedHashSet (ordem de inserção) e TreeSet (ordenado naturalmente).

* **Principais Características:**
    * **Sem Duplicatas:** Tentar adicionar um elemento existente não altera o set.

* **Implementações:**
    * **HashSet:** Alta performance, ideal quando a ordem não importa.
    * **LinkedHashSet:** Mantém a ordem em que os elementos foram inseridos.
    * **TreeSet:** Ordena os elementos de forma crescente ou por um Comparator.
    * **Métodos Comuns:** `add()`, `remove()`, `contains()`, `size()`, `isEmpty()`.


* **Exemplo de Uso:**

```java
    Set<String> set = new HashSet<>();
    set.add("Maçã");
    set.add("Banana");
    set.add("Maçã"); // Este será ignorado pois já existe
    System.out.println(set); // Saída: [Banana, Maçã] (a ordem pode variar)
```

> Use Set quando precisar de exclusividade de elementos e performance de busca.
---

## Map
O `Map` em Java é uma estrutura de dados da `java.util` que armazena pares chave-valor, onde cada chave é única e mapeia para um valor. É ideal para buscas rápidas, inserção e remoção. Implementações comuns incluem `HashMap` (sem ordem), `TreeMap` (ordenado pelas chaves) e `LinkedHashMap` (ordem de inserção).

* **Principais Características:**
    * **Chaves Únicas:** Não permite chaves duplicadas; novos valores para chaves existentes sobrescrevem o anterior.
    * **Valores Duplicados:** Valores podem ser repetidos.
    * **Performance:** `HashMap` oferece alto desempenho (tempo constante médio) para operações básicas.

* **Principais Implementações:**
  * **`HashMap` (Mais Comum):** Não garante nenhuma ordem dos elementos.
  * **`TreeMap` (Ordenado):** Mantém as chaves em ordem natural ou personalizada.
  * **`LinkedHashMap` (Ordem de Inserção):** Mantém a ordem em que os elementos foram inseridos.

* **Exemplo Prático (HashMap):**

```java
import java.util.HashMap;
import java.util.Map;

public class ExemploMap {
    public static void main(String[] args) {
        // Criando um Map (Chave: String, Valor: Integer)
        Map<String, Integer> idades = new HashMap<>();

        // Adicionando elementos (put)
        idades.put("Alice", 25);
        idades.put("Bob", 30);
        idades.put("Charlie", 22);

        // Acessando um valor (get)
        System.out.println("Idade da Alice: " + idades.get("Alice")); // Saída: 25

        // Iterando sobre o Map
        for (Map.Entry<String, Integer> entrada : idades.entrySet()) {
            System.out.println(entrada.getKey() + " - " + entrada.getValue());
        }
    }
}
```

* **Métodos Importantes:** 
  * `put(K chave, V valor)`: Insere ou atualiza um par.
  * `get(Object chave):` Retorna o valor associado à chave.
  * `remove(Object chave):` Remove o par da chave especificada.
  * `containsKey(Object chave):` Verifica se a chave existe.
  * `keySet():` Retorna um conjunto (Set) de todas as chaves.
  * `values():` Retorna uma coleção (Collection) de todos os valores. 

---

## Tipos primitivos e Wrappers:

Em Java, tipos primitivos (int, double, boolean, etc.) armazenam valores simples diretamente na memória, sendo rápidos e eficientes. Classes Wrappers (Integer, Double, Boolean, etc.) são objetos que encapsulam esses tipos, permitindo funcionalidades de orientação a objetos, como o uso em coleções, aceitando null e fornecendo métodos utilitários, com conversão automática (autoboxing).

* **Tipos Primitivos vs. Classes Wrappers**: Os tipos primitivos são a base da linguagem e definidos por palavras-chave minúsculas. Os wrappers são classes que correspondem a cada tipo primitivo, com nomes que iniciam em maiúscula.

    <table>
        <thead>
            <tr>
                <th>Tipo Primitivo</th>
                <th>Descrição</th>
                <th>Classe Wrapper</th>
                <th>Exemplo de Uso</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td><code>byte</code></td>
                <td>Inteiro de 8-bit</td>
                <td><code>Byte</code></td>
                <td><code>Byte b = 10;</code></td>
            </tr>
            <tr>
                <td><code>short</code></td>
                <td>Inteiro de 16-bit</td>
                <td><code>Short</code></td>
                <td><code>Short s = 100;</code></td>
            </tr>
            <tr>
                <td><code>int</code></td>
                <td>Inteiro de 32-bit</td>
                <td><code>Integer</code></td>
                <td><code>Integer i = 1000;</code></td>
            </tr>
            <tr>
                <td><code>long</code></td>
                <td>Inteiro de 64-bit</td>
                <td><code>Long</code></td>
                <td><code>Long l = 10000L;</code></td>
            </tr>
            <tr>
                <td><code>float</code></td>
                <td>Ponto flutuante 32-bit</td>
                <td><code>Float</code></td>
                <td><code>Float f = 10.5f;</code></td>
            </tr>
            <tr>
                <td><code>double</code></td>
                <td>Ponto flutuante 64-bit</td>
                <td><code>Double</code></td>
                <td><code>Double d = 10.5;</code></td>
            </tr>
            <tr>
                <td><code>char</code></td>
                <td>Caractere Unicode</td>
                <td><code>Character</code></td>
                <td><code>Character c = 'A';</code></td>
            </tr>
            <tr>
                <td><code>boolean</code></td>
                <td>Valor lógico (t/f)</td>
                <td><code>Boolean</code></td>
                <td><code>Boolean bool = true;</code></td>
            </tr>
        </tbody>
    </table>

* **Diferenças Principais:**
    * **Armazenamento:** Primitivos armazenam o valor diretamente na stack. Wrappers são objetos, armazenando a referência na stack e o valor na heap.
    * **Valor Nulo:** Wrappers podem ser null, úteis para representar ausência de dados, enquanto primitivos sempre têm um valor padrão (ex: 0, false).
    * **Performance:** Primitivos são mais rápidos e consomem menos memória.
    * **Coleções:** Estruturas de dados, como ArrayList, só aceitam objetos (Wrappers), não tipos primitivos.


* **Autoboxing e Unboxing:** O Java realiza automaticamente a conversão entre o tipo primitivo e sua classe wrapper correspondente:
    * **Autoboxing:** Converter primitivo para objeto (ex: int para Integer).
    * **Unboxing:** Converter objeto para primitivo (ex: Integer para int).


* **Exemplo:**
```java
    Integer wrapperInt = 10; // Autoboxing
    int primitivoInt = wrapperInt; // Unboxing
```
* **Principais Métodos dos Wrappers:** As classes wrapper oferecem métodos estáticos para conversão e manipulação, como parseInt ou valueOf;

```java
    int i = Integer.parseInt("123"); // Converte String para primitivo
    String s = Integer.toString(i); // Converte primitivo para String
```

---

---
### Principais métodos de **String**:
* Manipulação e Informação:

    * **length()**: Retorna o número de caracteres na string.
    * **charAt(int index)**: Retorna o char em um índice específico (começando em 0).
    * **substring(int beginIndex, int endIndex)**: Retorna uma nova string que é uma parte da original.
    * **concat(String str)**: Concatena a string especificada ao final da string atual.
    * **trim()**: Remove espaços em branco do início e do fim da string.
    * **strip()** (Java 11+): Semelhante ao trim(), mas suporta Unicode.

* Comparação e Busca:

    * equals(Object anObject): Compara o conteúdo das strings, retornando verdadeiro se forem iguais.
    * equalsIgnoreCase(String anotherString): Compara strings ignorando diferenças entre maiúsculas e minúsculas.
    * contains(CharSequence s): Verifica se a string contém a sequência informada.
    * indexOf(String str): Retorna o índice da primeira ocorrência de uma substring.
    * startsWith(String prefix): Verifica se a string começa com um determinado prefixo.
    * endsWith(String suffix): Verifica se a string termina com um determinado sufixo.

* Transformação:

    * toUpperCase() / toLowerCase(): Converte a string para maiúsculas ou minúsculas.
    * replace(char oldChar, char newChar): Substitui ocorrências de um caractere ou sequência por outra.
    * split(String regex): Divide a string em um array de strings com base em uma expressão regular.
    * valueOf(): Método estático que converte outros tipos de dados (int, long, etc.) para uma String.
---

### BibDecimal():

> A classe BigDecimal do Java é essencial para aplicações que requerem alta precisão nos cálculos, como em contextos financeiros e científicos. Diferente dos tipos primitivos como double, BigDecimal evita imprecisões, oferecendo métodos específicos para operações aritméticas e modos de arredondamento configuráveis.

```java
import java.math.BigDecimal;

public class BigDecimalExample {
    public static void main(String[] args) {
        BigDecimal value1 = new BigDecimal("100.25");
        BigDecimal value2 = new BigDecimal("50.10");

        BigDecimal sum = value1.add(value2);

        System.out.println("Value 1: " + value1);
        System.out.println("Value 2: " + value2);
        System.out.println("Sum: " + sum);
    }
}
```
---

### Enum
> Em Java, enum (enumeração) é um tipo especial de classe usada para definir coleções fixas de constantes imutáveis (ex: dias da semana, status de pedido). Criado com a palavra-chave enum, ele aumenta a segurança de tipos, legibilidade e manutenibilidade do código, garantindo que apenas valores predefinidos sejam utilizados.

* **Constantes:** As instâncias são fixas, imutáveis e geralmente declaradas em MAIÚSCULAS.
* **Tipo de Classe:** Enums podem ter atributos, métodos e construtores (privados).
* **Herança:** Herdam implicitamente de java.lang.Enum, não podendo estender outras classes.
* **Métodos Integrados:** `values()` (retorna todas as constantes) e `valueOf()` (converte string para enum).


* **Exemplo:**

```java
  // Declaração do Enum
  public enum DiaSemana {
      SEGUNDA, TERCA, QUARTA, QUINTA, SEXTA, SABADO, DOMINGO;
  }
  
  // Uso no código
  DiaSemana hoje = DiaSemana.SEGUNDA;
  
  if (hoje == DiaSemana.SEGUNDA) {
      System.out.println("Começo da semana!");
  }
```

## Classe Optional

A classe java.util.Optional<T (introduzida no Java 8) é um contêiner que pode ou não conter um valor não nulo, usada para evitar NullPointerException e tornar o código mais limpo e seguro. Ela indica explicitamente que um valor pode estar ausente, dispensando verificações manuais de null

* **Principais métodos:**
    * `Optional.of(valor)`: Cria um Optional com um valor não nulo.
    * `Optional.ofNullable(valor)`: Cria um Optional que pode conter nulo.
    * `isPresent()`: Retorna true se houver valor, false caso contrário.
    * `ifPresent(Consumer)`: Executa uma ação se o valor estiver presente.
    * `get()`: Retorna o valor, mas lança exceção se estiver vazio (use com cuidado).
    * `orElse(padrao)`: Retorna o valor ou um padrão se vazio.
    * `orElseGet(Supplier)`: Retorna o valor ou gera um padrão via Supplier.
  

* Exemplo:
```java
    import java.util.Optional;
    
    public class ExemploOptional {
        public static void main(String[] args) {
            String nome = null;
            Optional<String> opt = Optional.ofNullable(nome);
    
            // Imprime "Visitante" se nome for null
            System.out.println(opt.orElse("Visitante")); 
        }
    }

```

## Stream API

A Stream API foi introduzida no Java 8, em 2014, e trouxe consigo uma das maiores revoluções da linguagem: a capacidade de processar coleções de forma declarativa e fluida, usando expressões lambda e pipelines de dados. Em vez de escrever código dizendo “faça isso, depois aquilo”, você cria um fluxo de operações encadeadas como se estivesse montando uma linha de produção de dados. O resultado é um código menor, mais expressivo e mais próximo da lógica real do problema.

* **Exemplo simples:** Digamos que queira filtrar uma lista de números, pegar apenas os pares e dobrar o valor de cada um.
  * Jeito clássico:
    * Modo tradicional (imperativo) 
```java
       List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6);
       List<Integer> resultado = new ArrayList<>();
        
       for (Integer n : numeros) {
       if (n % 2 == 0) {
       resultado.add(n * 2);
       }
       }
        
       System.out.println(resultado);
```

  * O mesmo exemplo só que com Stream API:
    * Modo funcional (declarativo) 
```java
      List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6);
      List<Integer> resultado = numeros.stream()
                                        .filter(n -> n % 2 == 0)
                                        .map(n -> n * 2)
                                        .toList();
      System.out.println(resultado);
```
O mais fascinante da Stream API é que ela traz conceitos da programação funcional, um paradigma que valoriza funções puras, imutabilidade e processamento declarativo.
Um bom exemplo é o trio filter-map-reduce, considerado o coração das Streams:

```java
    int soma = Arrays.asList(1, 2, 3, 4, 5, 6).stream()
                  .filter(n -> n % 2 == 0)
                  .map(n -> n * 2)
                  .reduce(0, Integer::sum);
    
    System.out.println(soma); // Saída: 12
```
* Um bom poder real das Streams é quando precisa-se filtrar listas de objetos.
  * Método convencional: 
    ```java
        List<Pessoa> maioresDeIdade = new ArrayList<>();
        for (Pessoa p : pessoas) {
            if (p.getIdade() >= 18) {
                maioresDeIdade.add(p);
            }
        }
    ```
    
  * Com Streams: 
    ```java
    List<Pessoa> maioresDeIdade = pessoas.stream()
                                      .filter(p -> p.getIdade() >= 18)
                                      .toList();
    ```
* Outro Exemplo, ordenamento dos nomes de forma alfabética:
    ```java
        List<String> nomes = pessoas.stream()
                                .filter(p -> p.getIdade() >= 18)
                                .map(Pessoa::getNome)
                                .sorted()
                                .toList();
    ```
  
* **Stream Paralelas:**

Outro ponto incrível da Stream API é o paralelismo simplificado. Basta trocar .stream() por .parallelStream(), e o Java distribui o trabalho entre múltiplos núcleos do processador.


```java
long count = lista.parallelStream()
                .filter(n -> n > 100)
                .count();
```

Esse tipo de processamento é extremamente útil em grandes volumes de dados, pois você consegue um ganho de performance sem precisar gerenciar threads manualmente.

Mas é importante lembrar: o paralelismo nem sempre é vantajoso em listas pequenas, pois há custo de coordenação entre as threads. Saber quando usar é parte da maturidade com a API.
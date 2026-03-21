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

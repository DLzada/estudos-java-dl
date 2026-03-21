## Módulo 3 - Collections

### Array e Listas

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
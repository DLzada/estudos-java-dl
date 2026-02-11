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

---

> Código Pragmático do tópico em (TiposMemoria.java)

## 📘 Tópico 3: O Pool de Strings (Imutabilidade)
Strings em Java são especiais. Se você não entender isso, vai criar bugs de lógica.

**Conceito:**

* Strings são imutáveis. Uma vez criada, não muda. Se você concatenar, o Java cria uma nova String na memória.

* **String Pool:** Uma área especial da memória para economizar espaço.

> Código Pragmático do Tópico em (StringMaster.java):
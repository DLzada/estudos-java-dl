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
      <th style="padding: 10px;">Categoria</th>
      <th style="padding: 10px;">Palavras-Chave</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td style="padding: 10px;"><strong>Tipos Primitivos</strong></td>
      <td style="padding: 10px;">boolean, byte, char, double, float, int, long, short</td>
    </tr>
    <tr>
      <td style="padding: 10px;"><strong>Controle de Fluxo</strong></td>
      <td style="padding: 10px;">break, case, continue, default, do, else, for, if, return, switch, while</td>
    </tr>
    <tr>
      <td style="padding: 10px;"><strong>Tratamento de Erros</strong></td>
      <td style="padding: 10px;">assert, catch, finally, throw, throws, try</td>
    </tr>
    <tr>
      <td style="padding: 10px;"><strong>Modificadores</strong></td>
      <td style="padding: 10px;">abstract, final, native, private, protected, public, static, strictfp, synchronized, transient, volatile</td>
    </tr>
    <tr>
      <td style="padding: 10px;"><strong>Definições/Estrutura</strong></td>
      <td style="padding: 10px;">class, enum, extends, implements, import, interface, package, super, this, void</td>
    </tr>
    <tr>
      <td style="padding: 10px;"><strong>Outros / Literais</strong></td>
      <td style="padding: 10px;">instanceof, new, true, false, null</td>
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

## Comparando dados

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

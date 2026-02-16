# Módulo 2: Orientação a Objetos (POO) 
> Objetivo: Sair do código procedural (tudo no main) e construir sistemas modulares, seguros e reutilizáveis. Conceito Chave: Java é noun-oriented (orientado a substantivos/coisas). Primeiro você cria a "Coisa" (Classe), depois define o que ela faz (Métodos).

---

## 📘 Tópico 1: Classes, Objetos e Memória (Onde eles vivem?)
Entenda a diferença entre a Planta (Classe) e a Casa Construída (Objeto).

* **Classe:** O molde/template. Não ocupa memória de execução.

* **Objeto: **A instância viva na memória Heap.

* **Referência:** A variável na Stack (memória rápida) que aponta para o endereço na Heap.

> Código Pragmático do tópico em (classesObjetos/Carro.java e TesteCarro.java)

---

## 📘 Tópico 2: Encapsulamento e Modificadores (Segurança)
**Regra de ouro:** Nunca deixe seus atributos públicos. Se alguém puder fazer conta.saldo = -5000, seu sistema falhou.

`private`: Só a própria classe vê.

`public`: Todo mundo vê.

`protected`: Só filhos e classes do mesmo pacote veem.

`default` (sem nada): Só classes do mesmo pacote.

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

---

### Padrão de Nomear Classes: 
> PascalCase: Primeira letra de cada palavra maiúscula

### Padrão de Nomear atributos e métodos:
> camelCase: Apenas a Letra da Segunda palavra em maiúsculo

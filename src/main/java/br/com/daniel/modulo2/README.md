# Módulo 2: Orientação a Objetos (POO) 
> Objetivo: Sair do código procedural (tudo no main) e construir sistemas modulares, seguros e reutilizáveis. Conceito Chave: Java é noun-oriented (orientado a substantivos/coisas). Primeiro você cria a "Coisa" (Classe), depois define o que ela faz (Métodos).

## 📘 Tópico 1: Classes, Objetos e Memória (Onde eles vivem?)
Entenda a diferença entre a Planta (Classe) e a Casa Construída (Objeto).

* **Classe:** O molde/template. Não ocupa memória de execução.

* **Objeto: **A instância viva na memória Heap.

* **Referência:** A variável na Stack (memória rápida) que aponta para o endereço na Heap.

> Código Pragmático do tópico em (Carro.java e TesteCarro.java)

---

## 📘 Tópico 2: Encapsulamento e Modificadores (Segurança)
**Regra de ouro:** Nunca deixe seus atributos públicos. Se alguém puder fazer conta.saldo = -5000, seu sistema falhou.

`private`: Só a própria classe vê.

`public`: Todo mundo vê.

`protected`: Só filhos e classes do mesmo pacote veem.

`default` (sem nada): Só classes do mesmo pacote.

Código Pragmático do tópico em (ContaBancaria.java)
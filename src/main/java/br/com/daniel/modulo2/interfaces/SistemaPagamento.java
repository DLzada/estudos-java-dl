package br.com.daniel.modulo2.interfaces;

// O CONTRATO
interface ProcessadorPagamento {
    void processar(double valor); // Todo processador TEM que ter esse método
}

// IMPLEMENTAÇÃO 1
class Pix implements ProcessadorPagamento {
    public void processar(double valor) {
        System.out.println("Gerando QRCode para R$" + valor);
    }
}

// IMPLEMENTAÇÃO 2
class Cartao implements ProcessadorPagamento {
    public void processar(double valor) {
        System.out.println("Chamando operadora de cartão para R$" + valor);
    }
}

class Loja {
    // A Loja não depende de Pix ou Cartão. Depende da INTERFACE (Abstração).
    // Isso é Injeção de Dependência (Princípio do SOLID).
    public void finalizarCompra(ProcessadorPagamento meioPagamento, double valor) {
        meioPagamento.processar(valor);
    }
}
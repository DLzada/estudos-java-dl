package interfaces.ex02;

class EmailService implements ServicoNotificacao{

    @Override
    public void enviarMensagens(String mensagem) {
        System.out.println("EMAIL: enviando mensagem pelo email... "  + mensagem);
    }
}

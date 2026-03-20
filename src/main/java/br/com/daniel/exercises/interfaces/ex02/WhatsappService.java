package interfaces.ex02;

class WhatsappService implements ServicoNotificacao{

    @Override
    public void enviarMensagens(String mensagem) {
        System.out.println("Enviando mensagem pelo WhatsApp... " + mensagem);
    }
}

package interfaces.ex02;

class WhatsappService implements ServicoNotificacao{

    @Override
    public void enviarMensagem(String mensagem) {
        System.out.println("WhatsApp: Enviando mensagem pelo WhatsApp... " + mensagem);
    }
}

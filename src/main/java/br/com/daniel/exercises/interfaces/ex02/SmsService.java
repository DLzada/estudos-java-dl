package interfaces.ex02;

class SmsService implements ServicoNotificacao{

    @Override
    public void enviarMensagens(String mensagem) {
        System.out.println("SMS: eviando mensagem... " + mensagem);
    }
}

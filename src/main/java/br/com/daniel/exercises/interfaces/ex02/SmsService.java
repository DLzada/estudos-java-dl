package interfaces.ex02;

class SmsService implements ServicoNotificacao{

    @Override
    public void enviarMensagem(String mensagem) {
        System.out.println("SMS: eviando mensagem... " + mensagem);
    }
}

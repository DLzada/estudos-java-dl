package interfaces.ex02;

class RedesSociaisService implements ServicoNotificacao{

    @Override
    public void enviarMensagens(String mensagem) {
        System.out.println("Enviando mensagem para redes sociais... " + mensagem);
    }
}

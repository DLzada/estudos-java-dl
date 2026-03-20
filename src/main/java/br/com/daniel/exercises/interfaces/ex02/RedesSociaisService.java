package interfaces.ex02;

class RedesSociaisService implements ServicoNotificacao{

    @Override
    public void enviarMensagem(String mensagem) {
        System.out.println("Redes Sociais: Enviando mensagem para redes sociais... " + mensagem);
    }
}

package interfaces.ex02;

import java.util.ArrayList;
import java.util.List;

public class SistemaMarketing {
    private List<ServicoNotificacao> servicos = new ArrayList<>();

    public void addServico(ServicoNotificacao servico){
        servicos.add(servico);
    }

    public void dispararCampanha(String mensagem){
        System.out.println("=== Iniciando campanha de Marketing ===");
        for (ServicoNotificacao servico : servicos){
            servico.enviarMensagem(mensagem);
        }
        System.out.println("-----Finalizando campanha----");
    }

    public static void main(String[] args) {
        SistemaMarketing marketing = new SistemaMarketing();

        marketing.addServico(new SmsService());
        marketing.addServico(new EmailService());
        marketing.addServico(new RedesSociaisService());
        marketing.addServico(new WhatsappService());

        String minhaMensegem = "Olá! Produtos com até 50% de desconto, somente HOJE!";
        marketing.dispararCampanha(minhaMensegem);
    }
}

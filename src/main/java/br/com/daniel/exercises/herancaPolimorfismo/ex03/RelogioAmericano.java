package herancaPolimorfismo.ex03;

public class RelogioAmericano extends Relogio{
    public RelogioAmericano(int hora, int minuto, int segundo) {
        super(hora, minuto, segundo);
    }

    @Override
    public String getHoraFormatada(){
        int h = getHora();
        String sufixo = (h >= 12) ? " PM" : " AM";
        if(h == 0) h = 12;
        else if (h > 12) h -= 12;

        return String.format("%02d:%02d:%02d%s", h, getMinuto(), getSegundo(), sufixo);
    }

    @Override
    public void sincronizar(Relogio outroRelogio) {
        this.setHora(outroRelogio.getHora());
        this.setMinuto(outroRelogio.getMinuto());
        this.setSegundo(outroRelogio.getSegundo());
        System.out.println("Relógio Americano sincronizado!");
    }


}

public class Circulo implements Shape{
    private double raio;

    public Circulo(double raio) {
        this.raio = raio;
    }

    @Override
    public double getArea(){
        return Math.PI * (raio * raio);
    }

    @Override
    public double getPerimetro(){
        return 2 * Math.PI * raio;
    }
}

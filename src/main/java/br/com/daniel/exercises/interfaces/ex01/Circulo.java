public class Circulo implements Shape{
    private double raio;

    public Circulo(double raio) {
        this.raio = raio;
    }

    @Override
    public double getArea(){
        return Math.PI * (raio * raio);
    }
}

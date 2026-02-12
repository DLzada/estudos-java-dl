public class Retangulo implements Shape {
    private double altura;
    private double largura;

    public Retangulo(double altura, double largura) {
        this.altura = altura;
        this.largura = largura;
    }

    @Override
    public double getArea(){
        return altura * largura;
    }

    @Override
    public double getPerimetro(){
        return altura * 2 + largura * 2;
    }
}

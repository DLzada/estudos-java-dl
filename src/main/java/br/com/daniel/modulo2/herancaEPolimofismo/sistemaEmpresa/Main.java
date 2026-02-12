package br.com.daniel.modulo2.herancaEPolimofismo;

public class Main {
    public static void main(String[] args) {
        //Employee employee = new Employee();
        Manager manager = new Manager();
       //Salesman salesman = new Salesman();

        manager.setName("Jose");
        manager.setLogin("jose");
        manager.setPassword("123456");

        System.out.println(manager.getName());
        System.out.println(manager.getLogin());
        System.out.println(manager.getPassword());
    }


}

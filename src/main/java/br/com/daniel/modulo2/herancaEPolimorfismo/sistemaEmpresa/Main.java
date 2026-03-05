package br.com.daniel.modulo2.herancaEPolimofismo.sistemaEmpresa;

public class Main {
    public static void main(String[] args) {
        //Employee employee = new Employee();
        //Salesman salesman = new Salesman();
        Employee manager = new Manager();
        printEmployee(new Manager());
        printEmployee(new Salesman());
    }

    public static void printEmployee(Employee employee){
        employee.setName("Jose");
        ((Manager)employee).setLogin("jose");
        ((Manager)employee).setPassword("123456");

        System.out.printf("=======%s=======\n", employee.getClass().getCanonicalName());
        System.out.println(employee.getName());
        System.out.println(((Manager)employee).getLogin());
        System.out.println(((Manager)employee).getPassword());
        System.out.printf("==============");
    }

}

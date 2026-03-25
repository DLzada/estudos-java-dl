package br.com.daniel.crud;

import br.com.daniel.crud.dao.UserDAO;
import br.com.daniel.crud.model.MenuOption;
import br.com.daniel.crud.model.UserModel;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    private final static UserDAO dao = new UserDAO();
    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Bem vindo ao cadastro de usuários, selecione a operação desejada");
        System.out.println("1 - Cadastrar");
        System.out.println("2 - Atualizar");
        System.out.println("3 - Excluir");
        System.out.println("4 - Buscar por identificador");
        System.out.println("5 - Listar");
        System.out.println("6 - Sair");
        var userInput = scanner.nextInt();
        while (true){
            var selectOption = MenuOption.values()[userInput -1];

            switch (selectOption){
                case SAVE -> {
                    var user = requestUserInfo();
                }
            }
        }
    }

    private static UserModel requestUserInfo(){
        System.out.println("Informe o nome do usuário");
        var name = scanner.next();
        System.out.println("Informe o email do usuário");
        var email = scanner.next();
        System.out.println("Informe a data de nascimento do usuário (dd/MM/yyyy)");
        var birthdayString = scanner.next();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        var birthday = OffsetDateTime.parse(birthdayString, formatter);
        return new UserModel(0, name, email, birthday);
    }
}
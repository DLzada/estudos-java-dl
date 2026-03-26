package br.com.daniel.crud;

import br.com.daniel.crud.dao.UserDAO;
import br.com.daniel.crud.exception.CustomException;
import br.com.daniel.crud.exception.EmptyStorageException;
import br.com.daniel.crud.exception.UserNotFoundException;
import br.com.daniel.crud.exception.ValidatorException;
import br.com.daniel.crud.model.MenuOption;
import br.com.daniel.crud.model.UserModel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static br.com.daniel.crud.validator.UserValidator.verifyModel;

public class Main {

    private final static UserDAO dao = new UserDAO();
    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true){
            System.out.println("Bem vindo ao cadastro de usuários, selecione a operação desejada");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Atualizar");
            System.out.println("3 - Excluir");
            System.out.println("4 - Buscar por identificador");
            System.out.println("5 - Listar");
            System.out.println("6 - Sair");
            var userInput = scanner.nextInt();
            var selectOption = MenuOption.values()[userInput -1];

            switch (selectOption){
                case SAVE -> {
                    try {
                        var user = dao.save(requestToSave());
                        System.out.printf("Usuario cadastrado %s!", user);
                    } catch (CustomException ex) {
                        System.out.println(ex.getMessage());
                        ex.printStackTrace();
                    }


                }
                case UPDATE -> {
                    try{
                        var user =  dao.update(requestUpdate());
                        System.out.printf("Usuario atualizado %s", user);
                    } catch (UserNotFoundException | EmptyStorageException ex){
                        System.out.println(ex.getMessage());
                    }catch (CustomException ex){
                        System.out.println(ex.getMessage());
                        ex.printStackTrace();
                    }
                    finally {
                        System.out.println("====================");
                    }
                }
                case DELETE -> {
                    try{
                        var id = requestId();
                        dao.delete(id);
                        System.out.printf("Usuário com ID %s excluído com sucesso!%n", id);
                    } catch (UserNotFoundException | EmptyStorageException ex){
                        System.out.println(ex.getMessage());
                    }finally {
                        System.out.println("====================");
                    }
                }

                case FIND_BY_ID -> {
                    try {
                        var id = requestId();
                        var user = dao.findById(id);
                        System.out.printf("Usuario com id %s: ", id);
                        System.out.println(user);
                    }catch (UserNotFoundException | EmptyStorageException ex){
                        System.out.println(ex.getMessage());
                    }finally {
                        System.out.println("====================");
                    }
                }
                case FIND_ALL -> {
                    var users = dao.findAll();
                    System.out.printf("Usuários cadastrados");
                    System.out.println("================");
                    users.forEach(System.out::println);
                    System.out.println("========fimm=======");
                }
                case EXIT -> System.exit(0);
            }
        }
    }

    private static long requestId(){
        System.out.println("Informe o identificador do usuário");
        return scanner.nextLong();
    }

    private static UserModel requestToSave() {
        System.out.println("Informe o nome do usuário");
        var name = scanner.next();
        System.out.println("Informe o email do usuário");
        var email = scanner.next();
        System.out.println("Informe a data de nascimento do usuário (dd/MM/yyyy)");
        var birthdayString = scanner.next();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        var birthday = LocalDate.parse(birthdayString, formatter);
        return validateInputs(0, name, email, birthday);
    }

    private static UserModel validateInputs(final long id, final String name, final String email, final LocalDate birthday){
        var user = new UserModel(0, name, email, birthday);
        try{
            verifyModel(user);
            return user;
        } catch (ValidatorException ex){
            throw new CustomException("O seu modelo contem erros: " + ex.getMessage(), ex);
        }

    }

    private static UserModel requestUpdate() {
        System.out.println("Informe o identificador do usuário");
        var id = scanner.nextLong();
        System.out.println("Informe o nome do usuário");
        var name = scanner.next();
        System.out.println("Informe o email do usuário");
        var email = scanner.next();
        System.out.println("Informe a data de nascimento do usuário (dd/MM/yyyy)");
        var birthdayString = scanner.next();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        var birthday = LocalDate.parse(birthdayString, formatter);
        return validateInputs(id, name, email, birthday);
    }
}
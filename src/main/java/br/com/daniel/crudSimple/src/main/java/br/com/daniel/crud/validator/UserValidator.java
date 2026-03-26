package br.com.daniel.crud.validator;

import br.com.daniel.crud.exception.ValidatorException;
import br.com.daniel.crud.model.UserModel;

public class UserValidator {
    private UserValidator(){

    }

    public static void verifyModel(final UserModel model) throws ValidatorException{
        if (StringIsBlank(model.getName()))
            throw  new ValidatorException("Informe um nome válido");
        if (model.getName().length() <= 1)
            throw  new ValidatorException("O nome deve ter pelo mais que 1 caractere");
        if (StringIsBlank(model.getEmail()))
            throw  new ValidatorException("Informe um e-mail válido");
        if((!model.getEmail().contains("@")) || (!model.getEmail().contains(".")))
            throw  new ValidatorException("Informe um email válido!");
    }

    private static boolean StringIsBlank(final String value){
        return value == null || value.isBlank();
    }
}

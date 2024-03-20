package br.com.fiap.enlace.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class TipoServicoValidator implements ConstraintValidator<TipoServico, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return false; 
        }

        // Tipos de serviço de casamento válidos
        String[] tiposValidos = {"FOTOGRAFIA", "BUFFET", "DECORAÇÃO"};

        // Verifica se o valor está presente no array de tipos válidos
        for (String tipo : tiposValidos) {
            if (tipo.equals(value)) {
                return true;
                 // Se encontrado, a validação é bem-sucedida
            }
        }

        return false; 
        // Se não encontrado, a validação falha
    }
}


package br.com.viasoft.igormailservice.core.validations.impl;

import br.com.viasoft.igormailservice.core.validations.IValidation;
import br.com.viasoft.igormailservice.core.exceptions.BusinessException;
import br.com.viasoft.igormailservice.core.helper.ValidatorHelper;

public abstract class BaseValidation<T> implements IValidation<T> {

    protected void validadeEmail(String actor, int size, String emailValue) {
        ValidatorHelper.nullOrEmpty(emailValue, String.format("E-mail de %s nao informado!", actor));
        ValidatorHelper.lessThanEqual(emailValue, size, String.format("E-mail de %s excede %d caracteres!", actor, size));
        ValidatorHelper.email(emailValue, String.format("E-mail de %s invalido!", actor));
    }

    protected void validadeText(String actor, int size, String textValue) {
        ValidatorHelper.nullOrEmpty(textValue, String.format("%s nao informado!", actor));
        ValidatorHelper.lessThanEqual(textValue, size, String.format("%s excede %d caracteres!", actor, size));
    }

    @Override
    public void validate(T data) {
        if (data == null) {
            throw new BusinessException("O objeto de requisiçao ou resposta nao pode ser null.");
        }
    }
}
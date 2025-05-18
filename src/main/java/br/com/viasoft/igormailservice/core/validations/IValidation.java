package br.com.viasoft.igormailservice.core.validations;

public interface IValidation<T> {
    void validate(T data);
}

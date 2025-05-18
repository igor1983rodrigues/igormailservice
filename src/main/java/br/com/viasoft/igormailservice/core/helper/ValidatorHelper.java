package br.com.viasoft.igormailservice.core.helper;

import br.com.viasoft.igormailservice.core.exceptions.BusinessException;
import java.util.regex.Pattern;

public class ValidatorHelper {

    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,}$",
            Pattern.CASE_INSENSITIVE);

    public static void nullOrEmpty(String value) {
        nullOrEmpty(value, "Nao pode ser nulo ou vazio.");
    }

    public static void nullOrEmpty(String value, String message) {
        if (value == null || "".equalsIgnoreCase(value.replaceAll("(\\t| )", ""))) {
            throw new BusinessException(message);
        }
    }

    public static void lessThanEqual(String value, int to) {
        lessThanEqual(value, to, String.format("Nao pode ser maior que %s!", to));
    }

    public static void lessThanEqual(String value, int to, String message) {
        if (value.length() > to) {
            throw new BusinessException(message);
        }
    }

    public static void email(String value) {
        email(value, "E-mail invalido!");
    }

    public static void email(String value, String message) {
        if (!EMAIL_PATTERN.matcher(value).matches()) {
            throw new BusinessException(message);
        }
    }
}

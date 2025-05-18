package br.com.viasoft.igormailservice.core.helper;

public class Printer {

    public static <T> void console(String label, T data) {
        String serializedContent = Serializer.serialize(data);

        System.out.printf("%s: %s%n", label, serializedContent);
    }
}

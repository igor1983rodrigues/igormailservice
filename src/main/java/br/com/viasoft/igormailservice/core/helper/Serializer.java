package br.com.viasoft.igormailservice.core.helper;

import br.com.viasoft.igormailservice.core.exceptions.BusinessException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Serializer {

    public static <T> String serialize(T content) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper
                    .writerWithDefaultPrettyPrinter()
                    .writeValueAsString(content);
        } catch (JsonProcessingException ex) {
            throw new BusinessException(ex.getMessage(), ex);
        }
    }
}

package br.com.viasoft.igormailservice.core.validations.impl;

import br.com.viasoft.igormailservice.core.validations.IRequestValidation;
import br.com.viasoft.igormailservice.dto.RequestMailDTO;
import org.springframework.stereotype.Component;

@Component
public class RequestValidation extends BaseValidation<RequestMailDTO> implements IRequestValidation {

    @Override
    public void validate(RequestMailDTO data) {
        super.validate(data);
    }
}

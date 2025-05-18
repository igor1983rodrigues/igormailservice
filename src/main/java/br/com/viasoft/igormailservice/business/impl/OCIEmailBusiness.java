package br.com.viasoft.igormailservice.business.impl;

import br.com.viasoft.igormailservice.business.IEmailBusiness;
import br.com.viasoft.igormailservice.core.validations.IOCIEmailValidation;
import br.com.viasoft.igormailservice.core.validations.IRequestValidation;
import br.com.viasoft.igormailservice.dto.EmailOciDTO;
import br.com.viasoft.igormailservice.dto.RequestMailDTO;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnExpression("'${mail.integracao}'.toUpperCase() == 'OCI'")
public class OCIEmailBusiness extends BaseEmailBusiness<EmailOciDTO> implements IEmailBusiness<EmailOciDTO> {

    public OCIEmailBusiness(IRequestValidation requestValidation,  IOCIEmailValidation responseValidation) {
        super("OCI", requestValidation, responseValidation);
    }

    @Override
    public EmailOciDTO convertMailRequestDTO(RequestMailDTO requestMail) {

        return new EmailOciDTO(requestMail);
    }
}

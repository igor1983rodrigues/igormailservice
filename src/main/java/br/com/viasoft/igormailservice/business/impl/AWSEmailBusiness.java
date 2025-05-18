package br.com.viasoft.igormailservice.business.impl;

import br.com.viasoft.igormailservice.business.IEmailBusiness;
import br.com.viasoft.igormailservice.core.validations.IAWSEmailValidation;
import br.com.viasoft.igormailservice.core.validations.IRequestValidation;
import br.com.viasoft.igormailservice.dto.EmailAwsDTO;
import br.com.viasoft.igormailservice.dto.RequestMailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnExpression("'${mail.integracao}'.toUpperCase() == 'AWS'")
public class AWSEmailBusiness extends BaseEmailBusiness<EmailAwsDTO> implements IEmailBusiness<EmailAwsDTO> {

    @Autowired
    public AWSEmailBusiness(IRequestValidation requestValidation, IAWSEmailValidation responseValidation) {
        super("AWS", requestValidation, responseValidation);
    }

    @Override
    public EmailAwsDTO convertMailRequestDTO(RequestMailDTO requestMail) {
        return new EmailAwsDTO(requestMail);
    }
}

package br.com.viasoft.igormailservice.core.validations.impl;

import br.com.viasoft.igormailservice.core.validations.IAWSEmailValidation;
import br.com.viasoft.igormailservice.dto.EmailAwsDTO;
import org.springframework.stereotype.Component;

@Component
public class AWSEmailValidation extends BaseValidation<EmailAwsDTO> implements IAWSEmailValidation {

    @Override
    public final void validate(EmailAwsDTO data) {
        super.validate(data);

        validadeEmail("destinatario", 45, data.getRecipient());
        validadeEmail("remetente", 45, data.getSender());
        validadeText("Nome de destinatario", 60, data.getRecipientName());
        validadeText("Assunto", 120, data.getSubject());
        validadeText("Conteudo", 256, data.getContent());

    }
}

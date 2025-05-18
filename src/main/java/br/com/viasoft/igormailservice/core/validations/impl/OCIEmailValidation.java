package br.com.viasoft.igormailservice.core.validations.impl;

import br.com.viasoft.igormailservice.core.validations.IOCIEmailValidation;
import br.com.viasoft.igormailservice.dto.EmailOciDTO;
import org.springframework.stereotype.Component;

@Component
public class OCIEmailValidation extends BaseValidation<EmailOciDTO> implements IOCIEmailValidation {

    @Override
    public void validate(EmailOciDTO data) {
        super.validate(data);

        validadeEmail("destinatario", 40, data.getRecipientEmail());
        validadeEmail("remetente", 40, data.getSenderEmail());
        validadeText("Nome de destinatario", 50, data.getRecipientName());
        validadeText("Assunto", 100, data.getSubject());
        validadeText("Conteudo", 250, data.getBody());
    }
}

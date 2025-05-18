package br.com.viasoft.igormailservice.dto;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailAwsDTO {

    //E-mail destinatário: Max: 45 caracteres
    @Size(max = 45)
    private String recipient;

    //Nome destinatário. Max: 60 caracteres
    @Size(max = 60)
    private String recipientName;

    //E-mail remetente. Max: 45 caracteres
    @Size(max = 45)
    private String sender;

    //Assunto do e-mail. Max: 120 caracteres
    @Size(max = 120)
    private String subject;

    //Conteúdo do e-mail. Max: 256 caracteres
    @Size(max = 256)
    private String content;

    public EmailAwsDTO(RequestMailDTO requestMail) {
        this.recipient = requestMail.getRecipientMail();
        this.recipientName = requestMail.getRecipientName();
        this.sender = requestMail.getSenderMail();
        this.subject = requestMail.getSubject();
        this.content = requestMail.getContent();
    }
}

package br.com.viasoft.igormailservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailOciDTO {
    //E-mail destinatário: Max: 40 caracteres
    @NotBlank
    @Email
    @Size(max = 40, message = "E-mail do destinatario nao pode exceder a 40 cacteres.")
    private String recipientEmail;

    //Nome destinatário. Max: 50 caracteres
    @NotBlank
    @Size(max = 50, message = "Nome do destinatario nao pode exceder a 50 cacteres.")
    private String recipientName;

    //E-mail remetente. Max: 40 caracteres
    @NotBlank
    @Email
    @Size(max = 40, message = "E-mail do remetente nao pode exceder a 40 cacteres.")
    private String senderEmail;

    //Assunto do e-mail. Max: 100 caracteres
    @NotBlank
    @Size(max = 100, message = "Assunto nao pode exceder a 100 cacteres.")
    private String subject;

    //Conteúdo do e-mail. Max: 250 caracteres
    @NotBlank
    @Size(max = 250, message = "Corpo de mensagem nao pode exceder a 250 cacteres.")
    private String body;

    public EmailOciDTO(RequestMailDTO requestMail) {
        this.recipientEmail = requestMail.getRecipientMail();
        this.body = requestMail.getContent();
        this.senderEmail = requestMail.getSenderMail();
        this.subject = requestMail.getSubject();
        this.recipientName = requestMail.getRecipientName();
    }
}

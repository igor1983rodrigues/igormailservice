package br.com.viasoft.igormailservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestMailDTO {
    //E-mail do destinatário
    @NotBlank(message = "O e-mail do destinatario e obrigatorio!")
    @Email(message = "O e-mail do destinatario nao e invalido!")
    private String recipientMail;
    //Nome do destinatário
    private String recipientName;
    //Email do remetente
    @NotBlank(message = "O e-mail do remetente e obrigatorio!")
    @Email(message = "O e-mail do remetente nao e invalido!")
    private String senderMail;
    //Assunto
    private String subject;
    //Conteúdo
    private String content;
}

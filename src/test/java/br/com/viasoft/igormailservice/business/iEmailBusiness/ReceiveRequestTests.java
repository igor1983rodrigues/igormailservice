package br.com.viasoft.igormailservice.business.iEmailBusiness;

import br.com.viasoft.igormailservice.business.IEmailBusiness;
import br.com.viasoft.igormailservice.business.impl.AWSEmailBusiness;
import br.com.viasoft.igormailservice.business.impl.OCIEmailBusiness;
import br.com.viasoft.igormailservice.core.exceptions.BusinessException;
import br.com.viasoft.igormailservice.core.validations.IAWSEmailValidation;
import br.com.viasoft.igormailservice.core.validations.IOCIEmailValidation;
import br.com.viasoft.igormailservice.core.validations.IRequestValidation;
import br.com.viasoft.igormailservice.core.validations.impl.AWSEmailValidation;
import br.com.viasoft.igormailservice.core.validations.impl.OCIEmailValidation;
import br.com.viasoft.igormailservice.core.validations.impl.RequestValidation;
import br.com.viasoft.igormailservice.dto.EmailAwsDTO;
import br.com.viasoft.igormailservice.dto.EmailOciDTO;
import br.com.viasoft.igormailservice.dto.RequestMailDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ReceiveRequestTests {

    private IEmailBusiness<EmailAwsDTO> emailAwsBusiness;
    private IEmailBusiness<EmailOciDTO> emailOciBusiness;

    @BeforeEach
    public void setUp() {
        IAWSEmailValidation awsEmailValidation = new AWSEmailValidation();
        IOCIEmailValidation ociEmailValidation = new OCIEmailValidation();
        IRequestValidation requestValidation = new RequestValidation();

        emailAwsBusiness = new AWSEmailBusiness(requestValidation, awsEmailValidation);
        emailOciBusiness = new OCIEmailBusiness(requestValidation, ociEmailValidation);
    }

    @Test
    public void setEmailAwsBusinessReceiveRequestTest() {
        Exception exception = assertThrows(BusinessException.class, () -> emailAwsBusiness.receiveRequest(null));
        assertTrue(exception.getMessage().equalsIgnoreCase("O objeto de requisiçao ou resposta nao pode ser null."));

        RequestMailDTO requestObject = new RequestMailDTO();
        exception = assertThrows(BusinessException.class, () -> emailAwsBusiness.receiveRequest(requestObject));
        assertTrue(exception.getMessage().equalsIgnoreCase("E-mail de destinatario nao informado!"));

        requestObject.setRecipientMail("llllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllll");
        exception = assertThrows(BusinessException.class, () -> emailAwsBusiness.receiveRequest(requestObject));
        assertTrue(exception.getMessage().equalsIgnoreCase("E-mail de destinatario excede 45 caracteres!"));

        requestObject.setRecipientMail("llllllllllllllllllllllll");
        exception = assertThrows(BusinessException.class, () -> emailAwsBusiness.receiveRequest(requestObject));
        assertTrue(exception.getMessage().equalsIgnoreCase("E-mail de destinatario invalido!"));

        requestObject.setRecipientMail("email@gmail.com");
        exception = assertThrows(BusinessException.class, () -> emailAwsBusiness.receiveRequest(requestObject));
        assertTrue(exception.getMessage().equalsIgnoreCase("E-mail de remetente nao informado!"));

        requestObject.setSenderMail("email@gmail.com");
        exception = assertThrows(BusinessException.class, () -> emailAwsBusiness.receiveRequest(requestObject));
        assertTrue(exception.getMessage().equalsIgnoreCase("Nome de destinatario nao informado!"));

        requestObject.setRecipientName("Name Name Name Name Name Name Name Name Name Name Name Name Name Name Name Name Name Name Name Name Name Name Name Name Name Name Name Name Name Name Name Name Name Name Name Name Name Name Name Name Name Name Name Name Name Name Name Name Name Name Name Name Name Name Name Name Name ");
        exception = assertThrows(BusinessException.class, () -> emailAwsBusiness.receiveRequest(requestObject));
        assertTrue(exception.getMessage().equalsIgnoreCase("Nome de destinatario excede 60 caracteres!"));

        requestObject.setRecipientName("Any name");
        exception = assertThrows(BusinessException.class, () -> emailAwsBusiness.receiveRequest(requestObject));
        assertTrue(exception.getMessage().equalsIgnoreCase("Assunto nao informado!"));

        requestObject.setSubject("Any subject Any subject Any subject Any subject Any subject Any subject Any subject Any subject Any subject Any subject Any subject Any subject Any subject Any subject Any subject Any subject Any subject Any subject Any subject Any subject Any subject Any subject Any subject Any subject Any subject Any subject Any subject Any subject Any subject Any subject Any subject Any subject Any subject Any subject Any subject Any subject Any subject Any subject ");
        exception = assertThrows(BusinessException.class, () -> emailAwsBusiness.receiveRequest(requestObject));
        assertTrue(exception.getMessage().equalsIgnoreCase("Assunto excede 120 caracteres!"));

        requestObject.setSubject("Any subject");
        exception = assertThrows(BusinessException.class, () -> emailAwsBusiness.receiveRequest(requestObject));
        assertTrue(exception.getMessage().equalsIgnoreCase("Conteudo nao informado!"));

        requestObject.setContent("Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content ");
        exception = assertThrows(BusinessException.class, () -> emailAwsBusiness.receiveRequest(requestObject));
        assertTrue(exception.getMessage().equalsIgnoreCase("Conteudo excede 256 caracteres!"));

        requestObject.setContent("Any content");
        String label = emailAwsBusiness.receiveRequest(requestObject);
        assertEquals(label, "AWS");
    }

    @Test
    public void setEmailOciBusinessReceiveRequestTest() {
        Exception exception = assertThrows(BusinessException.class, () -> emailOciBusiness.receiveRequest(null));
        assertTrue(exception.getMessage().equalsIgnoreCase("O objeto de requisiçao ou resposta nao pode ser null."));

        RequestMailDTO requestObject = new RequestMailDTO();
        exception = assertThrows(BusinessException.class, () -> emailOciBusiness.receiveRequest(requestObject));
        assertTrue(exception.getMessage().equalsIgnoreCase("E-mail de destinatario nao informado!"));

        requestObject.setRecipientMail("llllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllll");
        exception = assertThrows(BusinessException.class, () -> emailOciBusiness.receiveRequest(requestObject));
        assertTrue(exception.getMessage().equalsIgnoreCase("E-mail de destinatario excede 40 caracteres!"));

        requestObject.setRecipientMail("llllllllllllllllllllllll");
        exception = assertThrows(BusinessException.class, () -> emailOciBusiness.receiveRequest(requestObject));
        assertTrue(exception.getMessage().equalsIgnoreCase("E-mail de destinatario invalido!"));

        requestObject.setRecipientMail("email@gmail.com");
        exception = assertThrows(BusinessException.class, () -> emailOciBusiness.receiveRequest(requestObject));
        assertTrue(exception.getMessage().equalsIgnoreCase("E-mail de remetente nao informado!"));

        requestObject.setSenderMail("email@gmail.com");
        exception = assertThrows(BusinessException.class, () -> emailOciBusiness.receiveRequest(requestObject));
        assertTrue(exception.getMessage().equalsIgnoreCase("Nome de destinatario nao informado!"));

        requestObject.setRecipientName("Name Name Name Name Name Name Name Name Name Name Name Name Name Name Name Name Name Name Name Name Name Name Name Name Name Name Name Name Name Name Name Name Name Name Name Name Name Name Name Name Name Name Name Name Name Name Name Name Name Name Name Name Name Name Name Name Name ");
        exception = assertThrows(BusinessException.class, () -> emailOciBusiness.receiveRequest(requestObject));
        assertTrue(exception.getMessage().equalsIgnoreCase("Nome de destinatario excede 50 caracteres!"));

        requestObject.setRecipientName("Any name");
        exception = assertThrows(BusinessException.class, () -> emailOciBusiness.receiveRequest(requestObject));
        assertTrue(exception.getMessage().equalsIgnoreCase("Assunto nao informado!"));

        requestObject.setSubject("Any subject Any subject Any subject Any subject Any subject Any subject Any subject Any subject Any subject Any subject Any subject Any subject Any subject Any subject Any subject Any subject Any subject Any subject Any subject Any subject Any subject Any subject Any subject Any subject Any subject Any subject Any subject Any subject Any subject Any subject Any subject Any subject Any subject Any subject Any subject Any subject Any subject Any subject ");
        exception = assertThrows(BusinessException.class, () -> emailOciBusiness.receiveRequest(requestObject));
        assertTrue(exception.getMessage().equalsIgnoreCase("Assunto excede 100 caracteres!"));

        requestObject.setSubject("Any subject");
        exception = assertThrows(BusinessException.class, () -> emailOciBusiness.receiveRequest(requestObject));
        assertTrue(exception.getMessage().equalsIgnoreCase("Conteudo nao informado!"));

        requestObject.setContent("Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content Any content ");
        exception = assertThrows(BusinessException.class, () -> emailOciBusiness.receiveRequest(requestObject));
        assertTrue(exception.getMessage().equalsIgnoreCase("Conteudo excede 250 caracteres!"));

        requestObject.setContent("Any content");
        String label = emailOciBusiness.receiveRequest(requestObject);
        assertEquals(label, "OCI");
    }
}

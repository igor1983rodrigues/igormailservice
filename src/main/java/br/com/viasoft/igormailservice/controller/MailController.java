package br.com.viasoft.igormailservice.controller;

import br.com.viasoft.igormailservice.business.IEmailBusiness;
import br.com.viasoft.igormailservice.core.exceptions.BusinessException;
import br.com.viasoft.igormailservice.dto.RequestMailDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/receivemail")
@CrossOrigin(origins = "*")
public class MailController {

    private final IEmailBusiness<?> emailBusiness;

    @Autowired
    public MailController(IEmailBusiness<?> emailBusiness) {
        this.emailBusiness = emailBusiness;
    }

    @PostMapping
    public Object receive(@Valid @RequestBody RequestMailDTO inputInfo) {
        try {
            emailBusiness.receiveRequest(inputInfo);
            return ResponseEntity.status(204).body("Envio de e-mail realizado com sucesso.");
        } catch (BusinessException ex) {
            return ResponseEntity.status(500).body(ex);
        } catch (Exception ex) {
            return ResponseEntity.status(400).body(ex);
        }
    }
}

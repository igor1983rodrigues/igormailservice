package br.com.viasoft.igormailservice.business.impl;

import br.com.viasoft.igormailservice.business.IEmailBusiness;
import br.com.viasoft.igormailservice.core.validations.IRequestValidation;
import br.com.viasoft.igormailservice.core.validations.IValidation;
import br.com.viasoft.igormailservice.core.helper.Printer;
import br.com.viasoft.igormailservice.dto.RequestMailDTO;

public abstract class BaseEmailBusiness<T> implements IEmailBusiness<T> {

    private final String label;
    private final IValidation<T> responseValidation;
    private final IRequestValidation requestValidation;

    public BaseEmailBusiness(String label, IRequestValidation requestValidation, IValidation<T> responseValidation) {
        this.label = label;
        this.requestValidation = requestValidation;
        this.responseValidation = responseValidation;
    }

    protected String getLabel() {
        return label;
    }

    @Override
    public final String receiveRequest(RequestMailDTO requestMail) {

        requestValidation.validate(requestMail);

        T emailInfoResponse = convertMailRequestDTO(requestMail);

        responseValidation.validate(emailInfoResponse);

        Printer.console(label, emailInfoResponse);

        return label;
    }
}

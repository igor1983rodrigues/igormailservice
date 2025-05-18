package br.com.viasoft.igormailservice.business;

import br.com.viasoft.igormailservice.dto.RequestMailDTO;

public interface IEmailBusiness<T> {

    T convertMailRequestDTO(RequestMailDTO requestMail);

    String receiveRequest(RequestMailDTO requestMail);
}

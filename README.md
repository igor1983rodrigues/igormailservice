# Projeto para testes igormailservice
API que trata de envio de e-mail para serviços AWS ou OCI

## Visão geral
Dado o objeto de e-mail a ser enviado, contento nome e e-mail de destino, e-mail do emissor, assunto e conteúdo, o serviço <strong>igormailservice<strong> precisa ser capaz de recebê-lo e formatar aos modelos AWS ou OCI, conforme estabelecido nas propriedades da aplicação.

## Ficha técnica
* Java v17
* Maven v3.6.3
* Spring Boot v3.4.5
* Spring Web v3.4.5
* Swagger - OpenApi
* jUnitTest v5
* Lombok
* Webservice Rest
* Princípio de responsabilidade única em SOLID

## Design pattenrs
* Template Method para o uso de classes abstratas como base
* Strategy para aplicação de interfaces de validação
* Dependence Injection
* Factory Method implicito para emcapsular a conversão de DTO de saída

# Modo de uso
Acesse o arquivo application.properties, ou application.yaml, dentro dos <i>resources</i>, e procure pela propriedade <code>mail.integracao</code> (crie ela, caso não existir), e defina seus valores como <u>OCI</u> ou <u>AWS</u>.

Ao iniciar a execução da apicação, abra o postman, e insira as propriedades:
* URL: http://localhost:8080/api/receivemail
* Verbo: POST
Em body, marque RAW, e entre com a seguinte estrutura do JSON:
<pre>
{
  "recipientMail": "destinatario@email.br",
  "recipientName": "Destinatário",
  "senderMail": "remetente@mail.br",
  "subject": "Algum assunto",
  "content": "Algum conteúdo"
}
</pre>
Caso quiseres, podes usar o <b>Swagger</b> através da http://localhost:8080/swagger-ui/index.html, e para api-docs, http://localhost:8080/v3/api-docs.

As propriedades do e-mail não podem ser vazias, e há alguns critérios particulares para o caso AWS e OCI:
* E-mail de destino: Para AWS, o máximo permitido é 45, e para OCI, 40;
* Nome do destinatário: Máximo de 60 para AWS, e 50 para OCI;
Rementente: 45 para AWS e 40 para OCI;
* Assunto: 120 para AWS e 100 para OCI;
* Conteúdo: 256 para AWS e 250 para OCI.


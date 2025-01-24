# Aplicação de Busca de CEP

Esta é uma aplicação RESTful que permite consultar e obter informações detalhadas de um CEP específico ou listar todos os CEPs disponíveis. A aplicação também salva um histórico das consultas realizadas, registrando o CEP consultado e a data e hora de cada consulta.

## Funcionalidades

### 1. Consulta por CEP
- **Endereço:** `/cep/{cep}`
- **Método:** GET
- **Descrição:** Retorna informações detalhadas de um endereço associado a um CEP específico.

**Parâmetros:**
- `cep`: O CEP a ser consultado.

**Exemplo de resposta:**
```json
{
  "cep": "12231520",
  "logradouro": "logradouro 1",
  "bairro": "bairro 1",
  "uf": "uf 1",
  "estado": "estado 1"
}
```

### 2. Listar todos os CEPs
- **Endereço:** `/cep`
- **Método:** GET
- **Descrição:** Retorna uma lista com todos os registros de CEP, incluindo logradouro, bairro, estado e UF.

**Exemplo de resposta:**
```json
[
  {
    "cep": "12231520",
    "logradouro": "logradouro 1",
    "bairro": "bairro 1",
    "uf": "uf 1",
    "estado": "estado 1"
  },
  {
    "cep": "12231521",
    "logradouro": "logradouro 2",
    "bairro": "bairro 2",
    "uf": "uf 2",
    "estado": "estado 2"
  }
]
```

## Como Executar

### Pré-requisitos

- JDK 17 ou superior
- Docker


### Instruções

1. Clone o repositório:
 -  git clone https://github.com/luizavramos/BuscaCep

2. Navegue até o diretório do projeto:
 -  cd cep-api

3. Compile o projeto (se Maven estiver instalado):
 -  mvn clean install

4. Execute o Docker Compose:
 -  docker-compose up


## Histórico de Consultas

Todas as consultas realizadas são registradas em um banco de dados MongoDB. A tabela contém os seguintes campos:

- **CEP:** O CEP consultado.
- **Data e Hora:** O timestamp da consulta.

Este histórico pode ser consultado e analisado conforme necessário para auditoria ou monitoramento.

## Testes

Você pode testar a aplicação utilizando ferramentas como **Postman** ou **Swagger UI**, que estará disponível em:

[http://localhost:8090/swagger-ui.html](http://localhost:8090/swagger-ui.html)

Isso permitirá que você interaja diretamente com a API, testando os endpoints descritos anteriormente.
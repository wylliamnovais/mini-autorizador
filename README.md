# Mini Autorizador
Desafio técnico para avaliação dos conhecimentos. O mesmo foi criado uma API de micro transação

## Instalação
```bash
SDK --> Java 11
Banco --> MySql
IDE --> Intellij
```

## Documentação da API
### Version: 1.0.0

### /transacoes

#### POST
##### Summary:

Endpoint Responsável por Atualizar o Saldo do Cartao.

##### Description:

Método para Atualizar o Saldo do Cartao.

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | Transação executada com Sucesso |
| 422 | Erro da Aplicação |
| 500 | Erro do Servidor |

### /cartoes

#### POST
##### Summary:

Endpoint Responsável por criar a Cartao.

##### Description:

Método para criar a Cartao.

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | Cartao Cadastrada |
| 422 | Erro da Aplicação |
| 500 | Erro do Servidor |

### /cartoes/{numeroCartao}

#### GET
##### Summary:

Endpoint Responsável por Consultar o saldo do Cartão.

##### Description:

Método para consulta do saldo do Cartao.

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| numeroCartao | path | Numero Cartão. | Yes | string |

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | Obtenção com sucesso: |
| 404 | Erro da Aplicação |
| 500 | Erro do Servidor |




## 🔗 Links
[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/wyllsc/)
[![twitter](https://img.shields.io/badge/twitter-1DA1F2?style=for-the-badge&logo=twitter&logoColor=white)](https://twitter.com/wyllsc)
[![whatsapp](https://img.shields.io/badge/whatsapp-0A66C2?style=for-the-badge&logo=whatsapp&logoColor=white)](https://wa.me/5561983133874)

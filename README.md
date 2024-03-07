# InkVerse

InkVerse - Marketplace para o mercado de tatuagem

## Requisitos

- [ ] CRUD de Contas
- [ ] CRUD de Portfólios
- [ ] CRUD de Agendas
- [ ] CRUD de Projetos Disponíveis {produto}
- [ ] Autenticação
- [ ] Dashboard

## Documentação da API

### Endpoints relacionados a tela de Login do App do Tatuador (Painel Profissional)

- [Login](#login)
- [Login Apple](#apple)
- [Login Google](#google)
- [Esqueceu Senha](#esqueceu-senha)
- [Criar conta](#criar-conta)

## Login

`POST` /login : Realiza a autenticação do usuário tatuador utilizando email e senha.

#### Corpo da Requisição

|campo|tipo|obrigatório|descrição
|-----|----|:-----------:|---------
|email|string|sim|O email do usuário tatuador
|senha|string|sim|A senha do usuário tatuador

#### Exemplo de Requisição

```js
//POST /login
{
    "email": "exemplo@dominio.com",
    "senha": "senha123"
}
```

#### Exemplo de Resposta

```js
{
    "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c"
}
```

#### Códigos de Status [status code]

|código|descrição
|------|---------
|200|Autenticação bem sucedida
|400|Validação falhou. Verifique o corpo da requisição
|401|Credenciais inválidas. Verifique o email e senha fornecidos
|404|Usuário não encontrado

## Login Apple

`POST` /login/apple : Realiza a autenticação do usuário tatuador utilizando a autenticação da Apple.

#### Corpo da Requisição

|campo|tipo|obrigatório|descrição
|-----|----|:-----------:|---------
|token|string|sim|O token de autenticação Apple

#### Exemplo de Requisição

```js
//POST /login/apple
{
    "token": "apple_token_here"
}
```

#### Exemplo de Resposta

```js
{
    "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c"
}
```

#### Códigos de Status [status code]

|código|descrição
|------|---------
|200|Autenticação bem sucedida
|400|Validação falhou. Verifique o corpo da requisição
|401|Credenciais inválidas. Verifique o email e senha fornecidos

## Login Google

`POST` /login/google : Realiza a autenticação do usuário tatuador utilizando a autenticação do Google.

#### Corpo da Requisição

|campo|tipo|obrigatório|descrição
|-----|----|:-----------:|---------
|token|string|sim|O token de autenticação do Google

#### Exemplo de Requisição

```js
//POST /login/google
{
    "token": "google_token_here"
}
```

#### Exemplo de Resposta

```js
{
    "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c"
}
```

#### Códigos de Status [status code]

|código|descrição
|------|---------
|200|Autenticação bem sucedida
|400|Validação falhou. Verifique o corpo da requisição
|401|Credenciais inválidas. Verifique o email e senha fornecidos

## Esqueceu Senha

`POST` /esqueceu-senha : Envia um email de recuperação de senha para o usuário tatuador.

#### Corpo da Requisição

|campo|tipo|obrigatório|descrição
|-----|----|:-----------:|---------
|email|string|sim|O email do usuário tatuador

#### Exemplo de Requisição

```js
//POST /esqueceu-senha
{
    "email": "exemplo@dominio.com"
}
```

#### Exemplo de Resposta

```js
{
     "message": "Email de recuperação de senha enviado com sucesso"
}
```

#### Códigos de Status [status code]

|código|descrição
|------|---------
|200|Autenticação bem sucedida
|400|Validação falhou. Verifique o corpo da requisição
|404|Usuário não encontrado

## Criar Conta

`POST` /criar-conta : Cria uma nova conta de usuário tatuador.

#### Corpo da Requisição

|campo|tipo|obrigatório|descrição
|-----|----|:-----------:|---------
|nome|string|sim|O nome do usuário tatuador
|email|string|sim|O email do usuário tatuador
|senha|string|sim|A senha do usuário tatuador

#### Exemplo de Requisição

```js
//POST /criar-conta
{
    "nome": "Exemplo",
    "email": "exemplo@dominio.com",
    "senha": "senha123"
}
```

#### Exemplo de Resposta

```js
{
    "message": "Conta criada com sucesso"
}
```

#### Códigos de Status [status code]

|código|descrição
|------|---------
|200|Autenticação bem sucedida
|400|Validação falhou. Verifique o corpo da requisição
|409|Conflito. O email já está em uso por outra conta


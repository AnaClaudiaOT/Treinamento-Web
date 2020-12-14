# language: pt
# charset: UTF-8
@CRUD
Funcionalidade: CRUD de usuários

  @CREATE
  Cenário: Criar um novo usuario
    Dado que o usuario esta no sistema Agapito Server
    E o usuario escolhe o menu usuarios
    E o usuario clica no botão novo usuario
    E o usuario preenche o campo "login" com "Ana Claudia"
    E o usuario preenche o campo "nome completo" com "Ana Oliveira"
    E o usuario preenche o campo "email" com "ana@ana.com"
    E o usuario preenche o campo "idade" com "28"
    Quando o usuario clicar em salvar
    Então o usuario deveria ver a mensagem "Usuário foi criado com sucesso."

  @READ
  Cenário: Consultar um novo usuario
    Dado que o usuario esta no sistema Agapito Server
    E o usuario escolhe o menu usuarios
    E o usuario clica no botão novo usuario
    E o usuario preenche o campo "login" com "Ana Claudia"
    E o usuario preenche o campo "nome completo" com "Ana Oliveira"
    E o usuario preenche o campo "email" com "ana@ana.com"
    E o usuario preenche o campo "idade" com "28"
    E o usuario clicar em salvar
    E o usuario clicar em voltar
    Quando o usuario consultar o ultimo usuario cadastrado
    Então o usuario deveria ver "login" com "Ana Claudia"
    E o usuario deveria ver "nome completo" com "Ana Oliveira"
    E o usuario deveria ver "email" com "ana@ana.com"
    E o usuario deveria ver "idade" com "28"

  @UPDATE
  Cenário: Alterar um usuario
    Dado que o usuario esta no sistema Agapito Server
    E o usuario escolhe o menu usuarios
    E o usuario clica no botão novo usuario
    E o usuario preenche o campo "login" com "Teste"
    E o usuario preenche o campo "nome completo" com "Testando"
    E o usuario preenche o campo "email" com "Teste"
    E o usuario preenche o campo "idade" com "18"
    E o usuario clicar em salvar
    E o usuario clicar em voltar
    Quando o usuario editar o ultimo usuario cadastrado
    E o usuario preenche o campo "nome completo" com "Teste" na Edição
    E o usuario clicar em salvar na Edição
    E o usuario clicar em voltar
    E o usuario consultar o ultimo usuario cadastrado
    Então o usuario deveria ver "login" com "Teste"
    E o usuario deveria ver "nome completo" com "Teste"
    E o usuario deveria ver "email" com "Teste"
    E o usuario deveria ver "idade" com "18"

  @DELETE
  Cenário: Deletar um usuario
    Dado que o usuario esta no sistema Agapito Server
    E o usuario escolhe o menu usuarios
    E o usuario clica no botão novo usuario
    E o usuario preenche o campo "login" com "Ana Claudia"
    E o usuario preenche o campo "nome completo" com "Ana Oliveira"
    E o usuario preenche o campo "email" com "ana@ana.com"
    E o usuario preenche o campo "idade" com "28"
    E o usuario clicar em salvar
    E o usuario clicar em voltar
    Quando o usuario deleta o ultimo usuario cadastrado
    E o usuario confirma a deleção
    Então o usuario não deveria ver o registro deletado

  @SCHEMA
  Esquema do Cenário: exemplo de scenario outline <id>

    Dado que o usuario esta no sistema Agapito Server
    E o usuario escolhe o menu usuarios
    E que o usuario acabou de cadastrar o codigo "<id>"
    E o usuario consultar o ultimo usuario cadastrado
    Então o usuario deveria ver "login" com "<login>"

    Exemplos:
      | id   | login   |
      | 3630 | asdfsaf |
      | 3632 | bugluna |
      | 3642 | teste   |

  @sintetico
  Cenário: Criar um novo usuario
    Dado que o usuario esta no sistema Agapito Server
    E o usuario escolhe o menu usuarios
    Quando o usuario criar um novo registro
    Então o usuario deveria ver a mensagem "Usuário foi criado com sucesso."
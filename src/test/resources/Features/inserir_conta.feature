#language: pt
Funcionalidade: Cadastro de contas
  Como um usuário
  Gostaria de cadastrar contas
  Para que eu possa distribuir meu dinheiro de uma forma mais organizada

  # Modelo de cenário declarativo
  Contexto:
    Dado que eu desejo adicionar uma conta

  Esquema do Cenário: Deve validar regras cadastro contas
    Quando adiciono a conta "<conta>"
    Então recebo a mensagem "<mensagem>"
    Exemplos:
      | conta            | mensagem                           |
      | Conta de Teste   | Conta adicionada com sucesso!      |
      |                  | Informe o nome da conta            |
      | Conta mesmo nome | Já existe uma conta com esse nome! |


  # Modelo de cenário imperativo
#  Contexto:
#    Dado que estou acessando a aplicação
#    Quando informo o usuário "userTeste@email.com"
#    E a senha "password"
#    E seleciono entrar
#    Então visualizo a página inicial
#    Quando seleciono Contas
#    E seleciono Adicionar

#  Esquema do Cenário: Deve validar regras cadastro contas
#    Quando informo a conta "<conta>"
#    E seleciono Salvar
#    Então recebo a mensagem "<mensagem>"
#    Exemplos:
#    | conta            | mensagem                           |
#    | Conta de Teste   | Conta adicionada com sucesso!      |
#    |                  | Informe o nome da conta            |
#    | Conta mesmo nome | Já existe uma conta com esse nome! |


  # Passos sem a utilização de esquema de cenário, cenário tradicional
  @ignore
  Cenário: Deve inserir uma conta com sucesso
    E informo a conta "Conta de Teste"
    E seleciono Salvar
    Então a conta é inserida com sucesso

  @ignore
  Cenário: Não deve inserir uma conta sem nome
    E informo a conta ""
    E seleciono Salvar
    Então sou notificado que o nome da conta é obrigatório

  @ignore
  Cenário: Não deve inserir uma conta com nome já existente
    E informo a conta "Conta mesmo nome"
    E seleciono Salvar
    Então sou notificado que já existe uma conta com esse nome
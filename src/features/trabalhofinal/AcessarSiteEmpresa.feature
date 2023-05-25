#language:pt
Funcionalidade: Acessar site de uma empresa que trabalha ou que deseja trabalhar
  Contexto:
    Dado que o usuário acessou o navegador

  @acessar_e_validar_site_da_empresa
  Cenário: Acessar e validar site da empresa Softplan
    Dado que o usuário está na página de pesquisa do Google
    E que ele pesquisou o nome da empresa "Softplan Florianópolis" na barra de pesquisa
    Quando ele clicar no primeiro link na lista de resultados
    Então ele deve ser redirecionado para o site da Sofplan
    E no final da página deve estar escrito "Softplan Planejamento e Sistemas S.A."

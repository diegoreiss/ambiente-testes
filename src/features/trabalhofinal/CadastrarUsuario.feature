#language:pt
Funcionalidade: Cadastrar Usuário

  Contexto:
    Dado que o usuário entrou na modal Campo de Treinamento

  @validar_cadastro_de_usuario
  Esquema do Cenário: Cadastro de usuário com todos os campos
    Dado que o usuário preencheu os campos obrigatorios <campos obrigatórios>
    E ele preencheu os campos opcionais <campos opcionais>
    Quando ele clicar no botão cadastrar
    Então uma caixa com a mensagem "Cadastrado!" aparecerá
    E os dados inseridos pelo usuário devem ser exibidos abaixo da mensagem
    Exemplos:
      | campos obrigatórios    | campos opcionais                                   |
      | Nome, Sobrenome e Sexo | Comida favorita, Escolaridade, Esportes, Sugestões |


  @validar_campos_obrigatorios
  Esquema do Cenário: Os campos Nome, Sobrenome e Sexo são obrigatorios
    Dado que o usuário não preencheu o campo <campo obrigatório>
    Quando ele clicar no botão cadastrar
    Então um alerta deve aparecer para ele com a mensagem "<campo obrigatório> eh obrigatorio"
    Exemplos:
      | campo obrigatório |
      | Nome              |
      | Sobrenome         |
      | Sexo              |

  @validar_campo_comida_favorita
  Esquema do Cenário: Não pode selecionar Vegetariano e <comida> juntos
    Dado que o usuário preencheu os campos obrigatorios Nome, Sobrenome e Sexo
    E no campo comida favorita ele selecionou Vegetariano e "<comida>" juntos
    Quando ele clicar no botão cadastrar
    Então um alerta deve aparecer para ele com a mensagem "Tem certeza que voce eh vegetariano?"
    Exemplos:
      | comida |
      | Carne  |
      | Frango |

  @validar_campo_esportes
  Esquema do Cenário: Não pode selecionar "O que eh esporte?" e <esporte> juntos
    Dado que o usuário preencheu os campos obrigatorios Nome, Sobrenome e Sexo
    E no campo esportes ele selecionou "O que eh esporte?" e <esporte> juntos
    Quando ele clicar no botão cadastrar
    Então um alerta deve aparecer para ele com a mensagem "Voce faz esporte ou nao?"
    Exemplos:
      | esporte                            |
      | Natação, Futebol, Corrida e Karate |
      | Futebol, Corrida e Karate          |
      | Corrida e Karate                   |
      | Karate                             |


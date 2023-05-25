package stepdefinitions;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import util.stepdefinitions.CadastrarUsuarioUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CadastrarUsuarioStep {

    CadastrarUsuarioUtil cadastrarUsuarioUtil = new CadastrarUsuarioUtil();

    // @validar_cadastro_de_usuario

    @Dado("que o usuário entrou na modal Campo de Treinamento")
    public void que_o_usuário_entrou_na_modal_Campo_de_Treinamento() {
        this.cadastrarUsuarioUtil.inicializaDriver();
        this.cadastrarUsuarioUtil.acessarCampoDeTreinamento();
    }

    @Dado("que o usuário preencheu os campos obrigatorios Nome, Sobrenome e Sexo")
    public void que_o_usuário_preencheu_os_campos_obrigatorios_Nome_Sobrenome_e_Sexo() {
        this.cadastrarUsuarioUtil.preencherCamposObrigatorios();
    }

    @Dado("ele preencheu os campos opcionais Comida favorita, Escolaridade, Esportes, Sugestões")
    public void ele_preencheu_os_campos_opcionais_Comida_favorita_Escolaridade_Esportes_Sugestões() {
        this.cadastrarUsuarioUtil.preencherCamposOpcionais();
    }

    @Quando("ele clicar no botão cadastrar")
    public void ele_clicar_no_botão_cadastrar() {
        this.cadastrarUsuarioUtil.apertarBotaoCadastrar();
    }

    @Então("uma caixa com a mensagem {string} aparecerá")
    public void uma_caixa_com_a_mensagem_aparecerá(String string) {
        this.cadastrarUsuarioUtil.validarMensagemCadastrado(string);
    }

    @Então("os dados inseridos pelo usuário devem ser exibidos abaixo da mensagem")
    public void os_dados_inseridos_pelo_usuário_devem_ser_exibidos_abaixo_da_mensagem() {
        this.cadastrarUsuarioUtil.validarDadosUsuarioCadastrado();
    }

    // @validar_campos_obrigatorios

    @Dado("que o usuário não preencheu o campo Nome")
    public void que_o_usuário_não_preencheu_o_campo_Nome() {
        this.cadastrarUsuarioUtil.testCampoSobrenome();
        this.cadastrarUsuarioUtil.testCampoSexo();
    }

    @Então("um alerta deve aparecer para ele com a mensagem {string}")
    public void um_alerta_deve_aparecer_para_ele_com_a_mensagem(String string) {
        this.cadastrarUsuarioUtil.validarAlert(string);
    }

    @Dado("que o usuário não preencheu o campo Sobrenome")
    public void que_o_usuário_não_preencheu_o_campo_Sobrenome() {
        this.cadastrarUsuarioUtil.testCampoNome();
        this.cadastrarUsuarioUtil.testCampoSexo();
    }

    @Dado("que o usuário não preencheu o campo Sexo")
    public void que_o_usuário_não_preencheu_o_campo_Sexo() {
        this.cadastrarUsuarioUtil.testCampoNome();
        this.cadastrarUsuarioUtil.testCampoSobrenome();
    }

    // @validar_campo_comida_favorita

    @Dado("no campo comida favorita ele selecionou Vegetariano e {string} juntos")
    public void no_campo_comida_favorita_ele_selecionou_Vegetariano_e_juntos(String string) {
        this.cadastrarUsuarioUtil.preencherCheckboxesCampoComidaFavorita(string);
    }

    // @validar_campo_esportes

    @Dado("no campo esportes ele selecionou {string} e Natação, Futebol, Corrida e Karate juntos")
    public void no_campo_esportes_ele_selecionou_e_Natação_Futebol_Corrida_e_Karate_juntos(String string) {
        List<String> nomeEsportes = new ArrayList<>(Arrays.asList("Natacao", "Futebol", "Corrida", "Karate", string));
        this.cadastrarUsuarioUtil.selecionarValoresCampoEsportes(nomeEsportes);
    }

    @Dado("no campo esportes ele selecionou {string} e Futebol, Corrida e Karate juntos")
    public void no_campo_esportes_ele_selecionou_e_Futebol_Corrida_e_Karate_juntos(String string) {
        List<String> nomeEsportes = new ArrayList<>(Arrays.asList("Futebol", "Corrida", "Karate", string));
        this.cadastrarUsuarioUtil.selecionarValoresCampoEsportes(nomeEsportes);
    }

    @Dado("no campo esportes ele selecionou {string} e Corrida e Karate juntos")
    public void no_campo_esportes_ele_selecionou_e_Corrida_e_Karate_juntos(String string) {
        List<String> nomeEsportes = new ArrayList<>(Arrays.asList("Corrida", "Karate", string));
        this.cadastrarUsuarioUtil.selecionarValoresCampoEsportes(nomeEsportes);
    }

    @Dado("no campo esportes ele selecionou {string} e Karate juntos")
    public void no_campo_esportes_ele_selecionou_e_Karate_juntos(String string) {
        List<String> nomeEsportes = new ArrayList<>(Arrays.asList("Karate", string));
        this.cadastrarUsuarioUtil.selecionarValoresCampoEsportes(nomeEsportes);
    }
}

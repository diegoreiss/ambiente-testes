package stepdefinitions;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import util.stepdefinitions.AcessarSiteEmpresaUtil;

public class AcessarSiteEmpresaStep {

    AcessarSiteEmpresaUtil acessarSiteEmpresaUtil = new AcessarSiteEmpresaUtil();

    @Dado("que o usuário acessou o navegador")
    public void que_o_usuário_acessou_o_navegador() {
        this.acessarSiteEmpresaUtil.inicializaDriver();
    }

    @Dado("que o usuário está na página de pesquisa do Google")
    public void que_o_usuário_está_na_página_de_pesquisa_do_Google() {
        this.acessarSiteEmpresaUtil.acessarSiteGoogle();
    }

    @Dado("que ele pesquisou o nome da empresa {string} na barra de pesquisa")
    public void que_ele_pesquisou_o_nome_da_empresa_na_barra_de_pesquisa(String string) {
        this.acessarSiteEmpresaUtil.pesquisarNomeEmpresa(string);
    }

    @Quando("ele clicar no primeiro link na lista de resultados")
    public void ele_clicar_no_primeiro_link_na_lista_de_resultados() {
        this.acessarSiteEmpresaUtil.acessarPrimeiroLink();
    }

    @Então("ele deve ser redirecionado para o site da Sofplan")
    public void ele_deve_ser_redirecionado_para_o_site_da_Sofplan() {
        this.acessarSiteEmpresaUtil.validarSiteCorrespondente();
    }

    @Então("no final da página deve estar escrito {string}")
    public void no_final_da_página_deve_estar_escrito(String string) {
        this.acessarSiteEmpresaUtil.validarSiteEmpresa(string);
    }
}

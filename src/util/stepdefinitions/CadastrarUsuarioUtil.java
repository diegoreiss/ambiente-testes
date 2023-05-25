package util.stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import util.webdriver.WebDriverUtil;

import java.util.List;

public class CadastrarUsuarioUtil extends WebDriverUtil {
    public void acessarCampoDeTreinamento() {
        String campoDeTreinamentoPath = "file:///" + System.getProperty("user.dir") + "/html/componentes.html";
        this.webDriver.get(campoDeTreinamentoPath);
    }

    public void testCampoNome() {
        WebElement campoNome = this.webDriver.findElement(By.id("elementosForm:nome"));
        campoNome.sendKeys("Diego");
    }

    public void testCampoSobrenome() {
        WebElement campoNome = this.webDriver.findElement(By.id("elementosForm:sobrenome"));
        campoNome.sendKeys("Reis");
    }

    public void testCampoSexo() {
        WebElement campoSexo = this.webDriver.findElement(By.id("elementosForm:sexo:0"));
        campoSexo.click();
    }

    private void testCampoComidaFavorita() {
        WebElement campoComidaFavorita = this.webDriver.findElement(By.id("elementosForm:comidaFavorita:2"));
        campoComidaFavorita.click();
    }

    private void testCampoEscolaridade() {
        WebElement campoEscolaridade = this.webDriver.findElement(By.id("elementosForm:escolaridade"));
        Select select = new Select(campoEscolaridade);
        select.selectByValue("superior");
    }

    private void testCampoEsportes() {
        WebElement campoEsportes = this.webDriver.findElement(By.id("elementosForm:esportes"));
        Select select = new Select(campoEsportes);
        select.selectByValue("Corrida");
    }

    private void testCampoSugestoes() {
        WebElement campoSugestoes = this.webDriver.findElement(By.id("elementosForm:sugestoes"));
        campoSugestoes.sendKeys("Java com selenium!");
    }

    public void preencherCamposObrigatorios() {
        this.testCampoNome();
        this.testCampoSobrenome();
        this.testCampoSexo();
    }

    public void preencherCamposOpcionais() {
        this.testCampoComidaFavorita();
        this.testCampoEscolaridade();
        this.testCampoEsportes();
        this.testCampoSugestoes();
    }

    public void apertarBotaoCadastrar() {
        WebElement buttonCadastrar = this.webDriver.findElement(By.id("elementosForm:cadastrar"));
        buttonCadastrar.click();
    }

    private WebElement getContainerCadastro() {
        return this.webDriver.findElement(By.id("resultado"));
    }

    public void validarMensagemCadastrado(String mensagemEsperada) {
        String textSpanAtual = getContainerCadastro().findElement(By.tagName("span")).getText();
        Assert.assertEquals(mensagemEsperada, textSpanAtual);
    }

    public void validarDadosUsuarioCadastrado() {
        String[] esperado = {"Diego", "Reis", "Masculino", "Pizza", "superior", "Corrida", "Java com selenium!"};
        String[] atual = new String[esperado.length];

        List<WebElement> valores = this.webDriver
                .findElement(By.id("resultado"))
                .findElements(By.tagName("div"));

        for (int i = 0; i < atual.length; i++) {
            atual[i] = valores.get(i).findElement(By.tagName("span")).getText();
        }

        Assert.assertArrayEquals(esperado, atual);

        this.encerraDriver();
    }

    private String getMessageAlertAtual() {
        return this.webDriver.switchTo().alert().getText();
    }

    private void acceptAlert() {
        this.webDriver.switchTo().alert().accept();
    }

    public void preencherCheckboxesCampoComidaFavorita(String nomeComida) {
        List<WebElement> elements = this.webDriver
                .findElement(By.id("elementosForm:comidaFavorita"))
                .findElement(By.tagName("tbody"))
                .findElement(By.tagName("tr"))
                .findElements(By.tagName("td"));

        elements.forEach(element -> {
            String labelElementText = element.findElement(By.tagName("label")).getText();

            if (labelElementText.equals(nomeComida) || labelElementText.equals("Vegetariano")) {
                WebElement inputElement = element.findElement(By.tagName("input"));
                inputElement.click();
            }
        });
    }

    public void validarAlert(String mensagem) {
        Assert.assertEquals(mensagem, this.getMessageAlertAtual());

        this.acceptAlert();
        this.encerraDriver();
    }

    public void selecionarValoresCampoEsportes(List<String> esportes) {
        WebElement selectElementCampoEsportes = this.webDriver.findElement(By.id("elementosForm:esportes"));
        Select selectEsportes = new Select(selectElementCampoEsportes);

        esportes.forEach(selectEsportes::selectByVisibleText);
    }
}

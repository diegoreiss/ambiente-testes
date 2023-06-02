package util.stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import util.webdriver.WebDriverUtil;


public class AcessarSiteEmpresaUtil extends WebDriverUtil {

    public void acessarSiteGoogle() {
        String url = "https://www.google.com.br/";
        this.webDriver.get(url);
    }

    public void pesquisarNomeEmpresa(String nomeParaPesquisar) {
        String xpath = "//*[@id=\"APjFqb\"]";
        WebElement barraPesquisaElement = this.webDriver.findElement(By.xpath(xpath));

        barraPesquisaElement.sendKeys(nomeParaPesquisar);
        barraPesquisaElement.sendKeys(Keys.ENTER);
    }

    public void acessarPrimeiroLink() {
        String xpath = "//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div/div/div[1]/a";
        WebElement linkEmpresaElement = this.webDriver.findElement(By.xpath(xpath));

        linkEmpresaElement.click();
    }

    public void validarSiteCorrespondente() {
        String urlEsperado = "https://www.softplan.com.br/";
        String urlAtual = this.webDriver.getCurrentUrl();

        Assert.assertEquals(urlEsperado, urlAtual);
    }

    public void validarSiteEmpresa(String nomeEmpresaEsperado) {
        String xpathH2 = "/html/body/footer/div[1]/div/div[2]/h2";

        WebElement h2NomeEmpresa = this.webDriver.findElement(By.xpath(xpathH2));

        Assert.assertEquals(nomeEmpresaEsperado, h2NomeEmpresa.getText());

        this.encerraDriver();
    }
}

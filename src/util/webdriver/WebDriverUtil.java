package util.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverUtil {
    protected WebDriver webDriver;

    protected WebDriverUtil() {
        String webDriverPath = System.getProperty("user.dir") + "/driver/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", webDriverPath);
    }

    public void inicializaDriver() {
        this.webDriver = new ChromeDriver();
        this.webDriver.manage().window().maximize();
    }

    public void encerraDriver() {
        if (this.webDriver != null) {
            this.webDriver.close();
        }
    }
}

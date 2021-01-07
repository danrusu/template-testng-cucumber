package common.ui.webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

public class WebDriverSupplier {

    private WebDriverSupplier() {
    }

    public static WebDriver chromeDriverSupplier() {
        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.silentOutput", "true");
        return new ChromeDriver();
    }

    public static WebDriver ieDriverSupplier() {
        WebDriverManager.iedriver().setup();
        return new InternetExplorerDriver();
    }

    public static WebDriver firefoxDriverSupplier() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    public static WebDriver operaDriverSupplier() {
        WebDriverManager.operadriver().setup();
        return new OperaDriver();
    }
}

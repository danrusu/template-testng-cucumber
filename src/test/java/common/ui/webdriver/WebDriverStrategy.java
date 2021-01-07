package common.ui.webdriver;

import org.openqa.selenium.WebDriver;

import java.util.function.Supplier;

public enum WebDriverStrategy {
    CHROME(WebDriverSupplier::chromeDriverSupplier),
    IE(WebDriverSupplier::ieDriverSupplier),
    FIREFOX(WebDriverSupplier::firefoxDriverSupplier),
    OPERA(WebDriverSupplier::operaDriverSupplier);

    private final Supplier<WebDriver> webDriverSupplier;

    WebDriverStrategy(final Supplier<WebDriver> webDriverSupplier) {
        this.webDriverSupplier = webDriverSupplier;
    }

    public WebDriver getDriver() {
        return webDriverSupplier.get();
    }
}
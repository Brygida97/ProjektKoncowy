package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Properties config;
    public static Properties testdata;

    public TestBase(){
        try {
            config = new Properties();
            FileInputStream file = new FileInputStream(System.getProperty("user.dir") +
                    "/src/main/java/config/config.properties");
            config.load(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            testdata = new Properties();
            FileInputStream file = new FileInputStream(System.getProperty("user.dir") +
                    "/src/main/java/testdata/testdata.properties");
            testdata.load(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void initialization(){
        DesiredCapabilities capabilities;

        String url = config.getProperty("URL");
        String browser = config.getProperty("browser");
        String pageLoadTimeout = config.getProperty("pageLoadTimeout");
        String windowsMaximize = config.getProperty("windowsMaximize");
        String deleteAllCookies = config.getProperty("deleteAllCookies");
        String waitTimeout = config.getProperty("waitTimeout");

        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +
                        "/src/main/resources/chromedriver");
                capabilities = DesiredCapabilities.chrome();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--incognito");
                capabilities.setCapability(ChromeOptions.CAPABILITY, options);

                driver = new ChromeDriver(capabilities);
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") +
                        "/src/main/resources/geckodriver");

                capabilities = DesiredCapabilities.firefox();
                capabilities.setCapability("browser.privatebrowsing.autostart", true);
                driver = new FirefoxDriver(capabilities);

                break;
        }

        if(deleteAllCookies.equalsIgnoreCase("true")) {
            driver.manage().deleteAllCookies();
        }
        if(windowsMaximize.equalsIgnoreCase("true")){
            driver.manage().window().maximize();
        }

        driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(pageLoadTimeout), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Integer.parseInt(waitTimeout));

        driver.get(url);

    }

}

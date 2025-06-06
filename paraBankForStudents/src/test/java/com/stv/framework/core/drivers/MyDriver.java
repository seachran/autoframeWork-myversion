package com.stv.framework.core.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.logging.Logger;

public class MyDriver {
    private static final Logger logger = Logger.getLogger(MyDriver.class.getName());
    private static WebDriver driver;

    /**
     * Возвращает экземпляр WebDriver.
     * Определяет, какой браузер запускать, на основе системного свойства `-Dbrowser`.
     */
    public static WebDriver getDriver() {
        if (driver == null) {
            String browser = System.getProperty("browser", "chrome").toLowerCase();
            switch (browser) {
                case "firefox":
                    setFireFox();
                    break;
                case "chrome":
                default:
                    setChromeDriver();
                    break;
            }
        }
        return driver;
    }

    /**
     * Инициализация ChromeDriver.
     */
    private static void setChromeDriver() {
        logger.info("Запуск Chrome браузера...");
        // Укажите путь к chromedriver при необходимости:
        // System.setProperty("webdriver.chrome.driver", "C:\\Chromedriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
    }

    /**
     * Инициализация FirefoxDriver.
     */
    private static void setFireFox() {
        logger.info("Запуск Firefox браузера...");
        // Укажите путь к geckodriver при необходимости:
        // System.setProperty("webdriver.gecko.driver", "C:\\drivers\\geckodriver.exe");
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--width=1200");
        options.addArguments("--height=800");
        driver = new FirefoxDriver(options);
    }

    /**
     * Завершает работу драйвера и очищает ссылку.
     */
    public static void resetDriver() {
        if (driver != null) {
            logger.info("Закрытие браузера...");
            driver.quit();
            driver = null;
        }
    }
}

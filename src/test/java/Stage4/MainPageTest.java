package Stage4;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;

public class MainPageTest extends AbstractTest {

    @Test
    @DisplayName("Авторизация")
    @Description("Тест проверяет авторизацию")
    @Severity(SeverityLevel.NORMAL)
    void mainMenuAuth() {
        MainMenu mainMenu = new MainMenu(getWebDriver());
        mainMenu
                .clickLogin("3186")
                .clickPassword("3f4366aeb9")
                .clickLoginButton()
                .clickHome();
        Assertions.assertEquals("https://test-stand.gb.ru/", getWebDriver().getCurrentUrl());
    }

    @Test
    @DisplayName("Неправильный логин")
    @Description("Тест проверяет авторизацию с неправильным логином")
    @Severity(SeverityLevel.MINOR)
    void mainMenuLogin() {
        MainMenu mainMenu = new MainMenu(getWebDriver());
        mainMenu
                .clickLogin("123")
                .clickPassword("3f4366aeb9")
                .clickLoginButton();
        Assertions.assertEquals("https://test-stand.gb.ru/login", getWebDriver().getCurrentUrl());
    }

    @Test
    @DisplayName("Неправильный пароль")
    @Description("Тест проверяет авторизацию с неправильным паролем")
    @Severity(SeverityLevel.MINOR)
    void mainMenuPassword() {
        MainMenu mainMenu = new MainMenu(getWebDriver());
        mainMenu
                .clickLogin("3186")
                .clickPassword("123")
                .clickLoginButton();
        Assertions.assertEquals("https://test-stand.gb.ru/login", getWebDriver().getCurrentUrl());
    }

    @Test
    @DisplayName("Логин кириллицей")
    @Description("Тест проверяет авторизацию с кириллицей")
    @Severity(SeverityLevel.MINOR)
    void mainMenuCyrilic() {
        MainMenu mainMenu = new MainMenu(getWebDriver());
        mainMenu
                .clickLogin("Капибара")
                .clickPassword("ffdad40f1d")
                .clickLoginButton()
                .clickHome();
        Assertions.assertEquals("https://test-stand.gb.ru/", getWebDriver().getCurrentUrl());
    }

    @Test
    @DisplayName("Логин больше 20 символов")
    @Description("Тест проверяет авторизацию с логином больше 20-ти символов")
    @Severity(SeverityLevel.MINOR)
    void mainMenuLongLogin() {
        MainMenu mainMenu = new MainMenu(getWebDriver());
        mainMenu
                .clickLogin("AmazonkaKillerWrestler")
                .clickPassword("d70513e978")
                .clickLoginButton()
                .clickHome();
        Assertions.assertEquals("https://test-stand.gb.ru/", getWebDriver().getCurrentUrl());
    }

    @Test
    @DisplayName("Логин меньше 3 символов")
    @Description("Тест проверяет авторизацию с логином меньше 3-х символов")
    @Severity(SeverityLevel.MINOR)
    void mainMenuShortLogin() {
        MainMenu mainMenu = new MainMenu(getWebDriver());
        mainMenu
                .clickLogin("Ja")
                .clickPassword("375ee26098")
                .clickLoginButton()
                .clickHome();
        Assertions.assertEquals("https://test-stand.gb.ru/", getWebDriver().getCurrentUrl());
    }

    @Test
    @DisplayName("Открыть публикацию")
    @Description("Тест проверяет открытие публикации")
    @Severity(SeverityLevel.MINOR)
    void mainMenuPost() {
        MainMenu mainMenu = new MainMenu(getWebDriver());
        mainMenu
                .clickLogin("3186")
                .clickPassword("3f4366aeb9")
                .clickLoginButton()
                .clickHome()
                .clickPicture()
                .clickPostPicture();
        Assertions.assertEquals("https://test-stand.gb.ru/posts/10746", getWebDriver().getCurrentUrl());
    }

    @Test
    @DisplayName("Проверка данных публикации")
    @Description("Тест проверяет публикацию на наличие картинки и заголовка")
    @Severity(SeverityLevel.MINOR)
    void mainMenuPost2() {
        MainMenu mainMenu = new MainMenu(getWebDriver());
        mainMenu
                .clickLogin("3186")
                .clickPassword("3f4366aeb9")
                .clickLoginButton()
                .clickHome()
                .clickPicture()
                .clickPostPicture();
        Assertions.assertEquals("https://test-stand.gb.ru/posts/10746", getWebDriver().getCurrentUrl());
        Assertions.assertTrue(getWebDriver().getTitle().equals("Поке"), "страница недоступна"); //Проверка загаловка
        Assertions.assertTrue(getWebDriver().findElement(By.xpath("//*[@id=\"app\"]/main/div/div[1]/div/div[3]")).getText().equals("Традиционно поке делают с рисом, но если заменить его на киноа, блюдо получится более лёгким.")); //Проверка текста
        Assertions.assertTrue(getWebDriver().findElement(By.xpath("//*[@id=\"app\"]/main/div/div[1]/div/div[2]")).isDisplayed()); //Проверка отображения картинки

    }

    @Test
    @DisplayName("Открыть следующую страницу")
    @Description("Тест проверяет открытие следующей страницы")
    @Severity(SeverityLevel.MINOR)
    void mainMenuNextPage() {
        MainMenu mainMenu = new MainMenu(getWebDriver());
        mainMenu
                .clickLogin("3186")
                .clickPassword("3f4366aeb9")
                .clickLoginButton()
                .clickHome()
                .clickNextPage();
        Assertions.assertEquals("https://test-stand.gb.ru/", getWebDriver().getCurrentUrl());
    }

    @Test
    @DisplayName("Открыть предыдущую страницу")
    @Description("Тест проверяет открытие предыдущей страницы")
    @Severity(SeverityLevel.MINOR)
    void mainMenupreviousPage() {
        MainMenu mainMenu = new MainMenu(getWebDriver());
        mainMenu
                .clickLogin("3186")
                .clickPassword("3f4366aeb9")
                .clickLoginButton()
                .clickHome()
                .clickNextPage()
                .clickPreviousPage();
        Assertions.assertEquals("https://test-stand.gb.ru/", getWebDriver().getCurrentUrl());
    }
    
}
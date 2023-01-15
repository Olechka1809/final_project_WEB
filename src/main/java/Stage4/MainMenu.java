package Stage4;

import org.checkerframework.checker.signature.qual.FieldDescriptorForPrimitive;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MainMenu extends AbstractPage {

    @FindBy(xpath = "//*[@id=\"login\"]/div[1]/label")
    private WebElement login;

    @FindBy(xpath = "//*[@id=\"login\"]/div[2]/label")
    private WebElement password;

    @FindBy(xpath = "//*[@id=\"login\"]/div[3]/button")
    private WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"app\"]/main/nav/a/span")
    private WebElement home;

    @FindBy(xpath = "//*[@id=\"app\"]/main/div/div[3]/div[1]/a[1]")
    private WebElement picture;

    @FindBy(xpath = "//*[@id=\"app\"]/main/div/div[1]/div/div[2]")
    private WebElement postPicture;

    @FindBy(xpath = "//*[@id=\"app\"]/main/div/div[3]/div[2]/div/a[2]")
    private WebElement nextPage;

    @FindBy(xpath = "//*[@id=\"app\"]/main/div/div[3]/div[2]/div/a[1]")
    private WebElement previousPage;


    public MainMenu(WebDriver driver) {
        super(driver);
    }

    public MainMenu clickLogin(String value){
        login.click();
        login.sendKeys(value);
        return this;
    }
    public MainMenu clickPassword(String value){
        password.click();
        password.sendKeys(value);
        return this;
    }

    public MainMenu clickLoginButton(){
        loginButton.click();
        return this;
    }

    public MainMenu clickHome(){
        home.click();
        return this;
    }

    public MainMenu clickPicture(){
        picture.click();
        return this;
    }

    public MainMenu clickPostPicture(){
        postPicture.click();
        return this;
    }

    public MainMenu clickNextPage(){
        nextPage.click();
        return this;
    }

    public MainMenu clickPreviousPage(){
        previousPage.click();
        return this;
    }


}

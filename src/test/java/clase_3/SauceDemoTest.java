package clase_3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SauceDemoTest {
    private WebDriver driver;
    //private SoftAssert softAssert;
    @BeforeMethod
    public void initTests(){
        //softAssert = new SoftAssert();


        System.setProperty(
                "webdriver.chrome.driver",
                System.getProperty("user.dir") + "/src/test/resources/drivers/windows/chromedriver.exe");

        driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com/");
    }
    @Test
    public void loginTest(){

        //Pasos del login

        WebElement userName = driver.findElement(By.id("user-name"));
        userName.sendKeys("standard_user");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        WebElement btnLogin = driver.findElement(
                By.xpath("//input[@data-test='login-button']")
        );
        btnLogin.click();

        //Ya iniciada la sesion
        WebElement btnCarrito = driver.findElement(By.className("shopping_cart_link"));

        //Verificación
        Assert.assertTrue(btnCarrito.isDisplayed(), "El carrito no es visible");
    }


    @Test
    public void testErrorPassword(){
        //Pasos del login

        WebElement userName = driver.findElement(By.id("user-name"));
        userName.sendKeys("standard_user");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("fruta");

        WebElement btnLogin = driver.findElement(
                By.xpath("//input[@data-test='login-button']")
        );
        btnLogin.click();

        //Mensaje de error
        WebElement lblMessage = driver.findElement(
                By.xpath("//div[@class='error-message-container error']")
        );

        //Verificación
        //softAssert.assertTrue(!lblMessage.isDisplayed(), "El mensaje de error no es visible");
        //softAssert.assertEquals(lblMessage.getText(),
                //"epic sadface: Username and password do not match any user in this service",
                //"El mensaje de error no es el correcto");

        Assert.assertTrue(lblMessage.isDisplayed(), "El mensaje de error no es visible");
        Assert.assertEquals(lblMessage.getText(),
                "Epic sadface: Username and password do not match any user in this service",
                "El mensaje de error no es el correcto");

    }


    @Test
    public void testErrorUserName(){
        //Pasos del login

        WebElement userName = driver.findElement(By.id("user-name"));
        userName.sendKeys("pepito");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        WebElement btnLogin = driver.findElement(
                By.xpath("//input[@data-test='login-button']")
        );
        btnLogin.click();

        //Mensaje de error
        WebElement lblMessage = driver.findElement(
                By.xpath("//div[@class='error-message-container error']")
        );

        //Verificación
        Assert.assertTrue(lblMessage.isDisplayed(), "El mensaje de error no es visible");
        Assert.assertEquals(lblMessage.getText(),
                "Epic sadface: Username and password do not match any user in this service",
                "El mensaje de error no es el correcto");
    }

    @AfterMethod
    public void endTests(){
        //Cierra el browser
        driver.quit();

        //softAssert.assertAll();
    }
}

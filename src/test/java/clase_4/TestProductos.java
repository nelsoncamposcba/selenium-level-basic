package clase_4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TestProductos {
    private WebDriver driver;

    @BeforeMethod
    public void initTests(){
        System.setProperty(
                "webdriver.chrome.driver",
                System.getProperty("user.dir") + "/src/test/resources/drivers/windows/chromedriver.exe");

        driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com/");
    }

    @AfterMethod
    public void endTests(){
        //Cierra el browser
        driver.quit();
    }


    @Test
    public void ordenPorDefault(){
        //Seccion de elementos
        WebElement txtUserName = driver.findElement(By.id("user-name"));
        WebElement txtPassword = driver.findElement(By.id("password"));
        WebElement btnLogin = driver.findElement(By.id("login-button"));

        //Flujo de inicio de sesion
        txtUserName.sendKeys("standard_user");
        txtPassword.sendKeys("secret_sauce");
        btnLogin.click();


        List<WebElement> nombresProductos = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        List<String> nombres = new ArrayList<>();

        for (WebElement nombre: nombresProductos) {
            nombres.add(nombre.getText());
        }
    }
}

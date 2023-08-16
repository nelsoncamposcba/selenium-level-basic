package clase_4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InicioSesion {
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
        //driver.quit();
    }


    @Test
    public void inicioSesionCorrecto(){
        //Seccion de elementos
        WebElement txtUserName = driver.findElement(By.id("user-name"));
        WebElement txtPassword = driver.findElement(By.id("password"));
        WebElement btnLogin = driver.findElement(By.id("login-button"));

        //Flujo de inicio de sesion
        txtUserName.sendKeys("standard_user");
        txtPassword.sendKeys("secret_sauce");
        btnLogin.click();

        //Seccion validaciones
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html", "La url no es la correcta");
    }

    @Test
    public void inicioSesionIncorrectoPassword(){
        //Seccion de elementos
        WebElement txtUserName = driver.findElement(By.id("user-name"));
        WebElement txtPassword = driver.findElement(By.id("password"));
        WebElement btnLogin = driver.findElement(By.id("login-button"));

        //Flujo de inicio de sesion
        txtUserName.sendKeys("standard_user");
        txtPassword.sendKeys("password_incorrecto");
        btnLogin.click();

        WebElement lblMessageError = driver.findElement(By.xpath("//div[@class='error-message-container error']"));

        //Seccion validaciones
        Assert.assertTrue(lblMessageError.isDisplayed(),"El mensaje de error no es visible");
    }

    @Test
    public void cierreSesionCorrecto() throws InterruptedException {
        //Seccion de elementos
        WebElement txtUserName = driver.findElement(By.id("user-name"));
        WebElement txtPassword = driver.findElement(By.id("password"));
        WebElement btnLogin = driver.findElement(By.id("login-button"));

        //Flujo de inicio de sesion
        txtUserName.sendKeys("standard_user");
        txtPassword.sendKeys("secret_sauce");
        btnLogin.click();


        WebElement btnBurger = driver.findElement(By.className("bm-burger-button"));
        btnBurger.click();

        WebElement btnLogout = driver.findElement(By.id("logout_sidebar_link"));
        btnLogout.click();

        //NO es buena practica usarlo
        Thread.sleep(5000);

        Assert.assertTrue(driver.findElement(By.id("login-button")).isDisplayed(), "El boton de Login no se encuentra visible");
        //Assert.assertTrue(btnLogin.isEnabled(), "El boton de Login no se encuentra habilitado");
    }
}

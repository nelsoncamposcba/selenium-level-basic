package clase_4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCarrito {
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
    public void agregarProducto(){
        //Seccion de elementos
        WebElement txtUserName = driver.findElement(By.id("user-name"));
        WebElement txtPassword = driver.findElement(By.id("password"));
        WebElement btnLogin = driver.findElement(By.id("login-button"));

        //Flujo de inicio de sesion
        txtUserName.sendKeys("standard_user");
        txtPassword.sendKeys("secret_sauce");
        btnLogin.click();


        WebElement btnAddLabsBackpack = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        btnAddLabsBackpack.click();

        WebElement countProducts = driver.findElement(By.className("shopping_cart_badge"));
        Assert.assertEquals(countProducts.getText(), "1", "La cantidad de productos en el carrito no es la correcta");
    }

    @Test
    public void realizarCompra(){
        //Seccion de elementos
        WebElement txtUserName = driver.findElement(By.id("user-name"));
        WebElement txtPassword = driver.findElement(By.id("password"));
        WebElement btnLogin = driver.findElement(By.id("login-button"));

        //Flujo de inicio de sesion
        txtUserName.sendKeys("standard_user");
        txtPassword.sendKeys("secret_sauce");
        btnLogin.click();

        //Agregamos un producto al carrito
        WebElement btnAddLabsBackpack = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        btnAddLabsBackpack.click();
        WebElement countProducts = driver.findElement(By.className("shopping_cart_badge"));
        Assert.assertEquals(countProducts.getText(), "1", "La cantidad de productos en el carrito no es la correcta");


        //Flujo de compra
        WebElement btnCarrito = driver.findElement(By.className("shopping_cart_link"));
        btnCarrito.click();
        WebElement btnCheckout = driver.findElement(By.id("checkout"));
        btnCheckout.click();

        //Formulario del comprador
        WebElement txtFirstName = driver.findElement(By.name("firstName"));
        WebElement txtLastName = driver.findElement(By.name("lastName"));
        WebElement txtPostalCode = driver.findElement(By.name("postalCode"));
        WebElement btnContinueCheckout = driver.findElement(By.name("continue"));

        txtFirstName.sendKeys("Nelson");
        txtLastName.sendKeys("Campos");
        txtPostalCode.sendKeys("5000");
        btnContinueCheckout.click();

        WebElement btnFinishCheckout = driver.findElement(By.name("finish"));
        btnFinishCheckout.click();

        WebElement btnBackToProducts = driver.findElement(By.name("back-to-products"));
        WebElement completeContainer = driver.findElement(By.id("checkout_complete_container"));

        Assert.assertTrue(completeContainer.isDisplayed(), "No se visualiza el mensaje de compra realizada");
        Assert.assertTrue(btnBackToProducts.isEnabled(), "El boton para volver a los productos no se encuentra habilitado");
        btnBackToProducts.click();

        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html", "La url no es la correcta");

    }
}

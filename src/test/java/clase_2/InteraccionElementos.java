package clase_2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InteraccionElementos {

    public static void main(String[] args) {
        System.setProperty(
                "webdriver.chrome.driver",
                System.getProperty("user.dir") + "/src/test/resources/drivers/windows/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com/");

        //WebElement userName = driver.findElement(By.id("user-name"));
        WebElement userName = driver.findElement(
                By.xpath("//input[@class='input_error form_input']")
        );
        userName.sendKeys("Test Automatizado");


        WebElement btnLogin = driver.findElement(
                By.xpath("//input[@data-test='login-button']")
        );
        btnLogin.click();

        //Cierra todas las ventanas del browser
        //driver.quit();
    }
}

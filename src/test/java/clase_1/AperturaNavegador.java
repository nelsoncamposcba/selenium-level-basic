package clase_1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AperturaNavegador {

    public static void main(String[] args) {
        //Seteamos la property para el browser que deseamos abrir
        //con la ubicación del driver
        // Para chrome
        //  - property => webdriver.chrome.driver
        //  - value => ubicación de chromedriver
        System.setProperty(
                "webdriver.chrome.driver",
                System.getProperty("user.dir") + "/src/test/resources/drivers/windows/chromedriver.exe");

        //Creamos un WebDriver del tipo del browser
        WebDriver driver = new ChromeDriver();

        //mediante el método get, le indicamos la url a visitar
        driver.get("https://www.google.com/");

        //Cierra la ventana del navegador que se tiene foco
        //driver.close();
        //Cierra todas las ventanas del browser
        driver.quit();

    }
}

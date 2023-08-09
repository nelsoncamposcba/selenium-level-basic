package clase_2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class RadioButton {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty(
                "webdriver.chrome.driver",
                System.getProperty("user.dir") + "/src/test/resources/drivers/windows/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://demo.guru99.com/test/radio.html");

        //Obtenemos el elemento
        List<WebElement> radios = driver.findElements(By.xpath("//input[@type='radio']"));

        //Hacemos click en la opcion 1
        radios.get(0).click();

        for (WebElement _radio: radios) {
            System.out.println(_radio.getText() + " es seleccionado?: " + _radio.isSelected());

            //Thread.sleep(5000);
        }
    }
}

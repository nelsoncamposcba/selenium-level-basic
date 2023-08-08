package clase_1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloseQuit {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/drivers/windows/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.webroot.com/services/popuptester1.htm");
        //driver.close();
        driver.quit();

    }
}

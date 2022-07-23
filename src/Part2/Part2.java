package Part2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Part2 {

    public static void main(String[] args) {



        System.setProperty("webdriver.chrome.driver", "C:\\Chrome Driver\\chromedriver.exe" );
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://demo.applitools.com/");
        driver.manage().window().maximize();

        WebElement userNameBox = driver.findElement(By.id("username"));
        userNameBox.sendKeys("ttechno@gmail.com");

        WebElement pwdBox = driver.findElement(By.id("password"));
        pwdBox.sendKeys("techno123.");

        WebElement signInButton = driver.findElement(By.id("log-in"));
        signInButton.click();


        WebElement redHeader = driver.findElement(By.id("time"));
        String str = redHeader.getText();

        String currentURL = driver.getCurrentUrl();


        System.out.println("String str is: " + str);
        System.out.println("Current URL is: " + currentURL);


        driver.quit();





    }

}

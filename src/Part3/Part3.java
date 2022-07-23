package Part3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Part3 {

    public static void main(String[] args) throws InterruptedException {

//        We got the success message without any exception.
//        However, sometimes it's working, sometimes it's getting stuck at the last page.
//        We tried this code with only implicitlyWait and with ThreadSleeps.
//        We tried to avoid using threadSleep but it gets stuck.
//        This is the final that was working.


        System.setProperty("webdriver.chrome.driver", "C:\\Chrome Driver\\chromedriver.exe" );
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        String expectedInput = "teddy bear";

        driver.get("https://www.snapdeal.com/");
        driver.manage().window().maximize();

        Thread.sleep(3000);
        WebElement searchBox = driver.findElement(By.id("inputValEnter"));
        searchBox.sendKeys(expectedInput);

        WebElement searchButton = driver.findElement(By.cssSelector("button[onclick=\"submitSearchForm('go_header');\"]"));
        searchButton.click();

        Thread.sleep(3000);

        WebElement searchResult = driver.findElement(By.cssSelector("#searchMessageContainer>div>span"));
        String searchResultText = searchResult.getText();
        System.out.println(searchResultText);

        String currentURL = driver.getCurrentUrl();
        System.out.println("Current URL is " + currentURL);

        WebElement snapLogo = driver.findElement(By.cssSelector("div>div[class='header_wrapper']>div>a:nth-of-type(1)>img"));
        snapLogo.click();

        Thread.sleep(3000);

        String currentURLafterClickLogo = driver.getCurrentUrl();
        System.out.println("Current URL after clicking the logo is " + currentURLafterClickLogo);

        Thread.sleep(3000);
        driver.navigate().back();

        Thread.sleep(3000);
        WebElement searchBox2 = driver.findElement(By.id("inputValEnter"));
        String valueInSearchBox = searchBox2.getAttribute("value");


        if (valueInSearchBox.equals(expectedInput)) {
            System.out.println("Success!");
        } else {
            System.out.println("BUG");
        }




        driver.quit();










    }

}

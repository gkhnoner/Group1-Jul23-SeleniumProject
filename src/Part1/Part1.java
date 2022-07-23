package Part1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Part1 {

    public static void main(String[] args) {


//        We are not 100% sure on .contains() if the website is broken.
//        Lets say our address is "Address" and when we submit, it prints "Banana"
//        but display is gonna be "Permananet Address :Banana" which still
//        contains "Address".
//        However, we couldnt locate only address part.



        System.setProperty("webdriver.chrome.driver", "C:\\Chrome Driver\\chromedriver.exe" );
        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/text-box");
        driver.manage().window().maximize();

        String testName = "Automation";
        String testEmail = "Testing@gmail.com";
        String testCurrentAddress = "Testing Current Address";
        String testPermAddress = "Testing Permanent Address";

        WebElement fullNameBox = driver.findElement(By.id("userName"));
        fullNameBox.sendKeys(testName);

        WebElement eMailBox = driver.findElement(By.id("userEmail"));
        eMailBox.sendKeys(testEmail);

        WebElement currentAddBox = driver.findElement(By.id("currentAddress"));
        currentAddBox.sendKeys(testCurrentAddress);

        WebElement permaAddBox = driver.findElement(By.id("permanentAddress"));
        permaAddBox.sendKeys(testPermAddress);

        WebElement clickButton = driver.findElement(By.id("submit"));
        clickButton.click();

        WebElement displayName = driver.findElement(By.id("name"));
        String textName = displayName.getText();

        WebElement displayEmail = driver.findElement(By.id("email"));
        String textEmail = displayEmail.getText();

        WebElement displayCurrentAdd = driver.findElement(By.cssSelector("p#currentAddress"));
        String textCurrentAdd = displayCurrentAdd.getText();

        WebElement displayPermaAdd = driver.findElement(By.cssSelector("p#permanentAddress"));
        String textPermaAdd = displayPermaAdd.getText();

        if (textName.contains(testName)) {
            System.out.println("Name is successful!");
        } else {
            System.out.println("Name has a BUG");
        }

        if (textEmail.contains(testEmail)) {
            System.out.println("Email is successful!");
        } else {
            System.out.println("Email has a BUG");
        }

        if (textCurrentAdd.contains(testCurrentAddress)) {
            System.out.println("Current address is successful!");
        } else {
            System.out.println("Current address has a BUG");
        }

        if (textPermaAdd.contains(testPermAddress)) {
            System.out.println("Permanent address is successful");
        } else {
            System.out.println("Permanent address has a BUG");
        }



        driver.quit();









    }

}

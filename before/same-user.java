import org.openqa.selenium.By;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class test3 {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("file:///C:/Users/arifcem.kapar/Desktop/login.html");


        driver.findElement(By.id("signupEmail")).clear();
        driver.findElement(By.id("signupPassword")).clear();
        driver.findElement(By.id("signupPassword2")).clear();

        driver.findElement(By.id("signupEmail")).sendKeys("admin@deneme.com.tr");
        driver.findElement(By.id("signupPassword")).sendKeys("123456");
        driver.findElement(By.id("signupPassword2")).sendKeys("123456");

        driver.findElement(By.id("signupBtn")).click();

        Alert alert2 = wait.until(ExpectedConditions.alertIsPresent());
        String text2 = alert2.getText();
        System.out.println(text2);
        alert2.accept();

        if (!text2.contains("zaten var")) {
            throw new AssertionError("Duplicate user testi FAIL!");
        }
        driver.quit();
    }
}

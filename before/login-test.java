import org.openqa.selenium.By;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class test2 {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("file:///C:/Users/arifcem.kapar/Desktop/login.html");


        driver.findElement(By.id("loginEmail")).sendKeys("yanlis@gmail.com");
        driver.findElement(By.id("loginPassword")).sendKeys("111111");
        driver.findElement(By.id("loginBtn")).click();


        Alert alert1 = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println(alert1.getText());
        alert1.accept();


        driver.findElement(By.id("loginEmail")).clear();
        driver.findElement(By.id("loginPassword")).clear();


        driver.findElement(By.id("loginEmail")).sendKeys("admin@deneme.com.tr");
        driver.findElement(By.id("loginPassword")).sendKeys("123456");
        driver.findElement(By.id("loginBtn")).click();


        Alert alert2 = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println(alert2.getText());
        alert2.accept();

        driver.quit();
    }
}

import org.openqa.selenium.By;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class test1 {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("file:///C:/Users/arifcem.kapar/Desktop/login.html");



        driver.findElement(By.id("signupEmail")).sendKeys("test@gmail.com");
        driver.findElement(By.id("signupPassword")).sendKeys("123");
        driver.findElement(By.id("signupPassword2")).sendKeys("456");

        driver.findElement(By.id("signupBtn")).click();

        Alert alert1 = wait.until(ExpectedConditions.alertIsPresent());
        String text1 = alert1.getText();
        System.out.println(text1);
        alert1.accept();

        if (!text1.contains("Şifreler uyuşmuyor")) {
            throw new AssertionError("Şifre kontrol testi FAIL!");
        }
        driver.quit();
    }
}

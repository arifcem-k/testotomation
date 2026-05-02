import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class testng {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("file:///C:/Users/arifcem.kapar/Desktop/login.html");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    //  TEST 1 - password-test.java
    @Test(priority = 1)
    public void passwordMismatchTest() {

        driver.findElement(By.id("signupEmail")).sendKeys("test@gmail.com");
        driver.findElement(By.id("signupPassword")).sendKeys("123");
        driver.findElement(By.id("signupPassword2")).sendKeys("456");
        driver.findElement(By.id("signupBtn")).click();

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String text = alert.getText();
        alert.accept();

        Assert.assertTrue(text.contains("Şifreler uyuşmuyor"),
                "Şifre kontrol testi FAIL!");
    }

    //  TEST 2 - login-test.java
    @Test(priority = 2)
    public void loginTest() {


        driver.findElement(By.id("loginEmail")).sendKeys("yanlis@gmail.com");
        driver.findElement(By.id("loginPassword")).sendKeys("111111");
        driver.findElement(By.id("loginBtn")).click();

        Alert alert1 = wait.until(ExpectedConditions.alertIsPresent());
        String text1 = alert1.getText();
        alert1.accept();

        Assert.assertTrue(text1.toLowerCase().contains("hatalı"));


        driver.findElement(By.id("loginEmail")).clear();
        driver.findElement(By.id("loginPassword")).clear();

        driver.findElement(By.id("loginEmail")).sendKeys("admin@deneme.com.tr");
        driver.findElement(By.id("loginPassword")).sendKeys("123456");
        driver.findElement(By.id("loginBtn")).click();

        Alert alert2 = wait.until(ExpectedConditions.alertIsPresent());
        String text2 = alert2.getText();
        alert2.accept();

        Assert.assertTrue(text2.toLowerCase().contains("başarılı"));
    }

    //  TEST 3 - same-user.java
    @Test(priority = 3)
    public void duplicateUserTest() {

        driver.findElement(By.id("signupEmail")).sendKeys("admin@deneme.com.tr");
        driver.findElement(By.id("signupPassword")).sendKeys("123456");
        driver.findElement(By.id("signupPassword2")).sendKeys("123456");
        driver.findElement(By.id("signupBtn")).click();

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String text = alert.getText();
        alert.accept();

        Assert.assertTrue(text.toLowerCase().contains("zaten var"),
                "Duplicate user testi FAIL!");
    }

    //  TEST 4 - save-test.java
    @Test(priority = 4)
    public void successfulSignupTest() {

        driver.findElement(By.id("signupEmail")).sendKeys("yeniuser@gmail.com");
        driver.findElement(By.id("signupPassword")).sendKeys("123456");
        driver.findElement(By.id("signupPassword2")).sendKeys("123456");
        driver.findElement(By.id("signupBtn")).click();

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String text = alert.getText();
        alert.accept();

        Assert.assertTrue(text.contains("Kayıt başarılı"),
                "Signup testi FAIL!");
    }
}

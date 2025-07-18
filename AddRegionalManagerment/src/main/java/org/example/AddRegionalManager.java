package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class AddRegionalManager {

    WebDriver driver;

    driver = new ChromeDriver();
    wait = new WebDriverWait(driver, Duration.ofSeconds(20));
}

@Test
public void testLogin() {
    login();
}

public void login() {
    WebDriver driver;
    driver.get("https://staging-admin.parkengage.com/");
    driver.manage().window().maximize();

    WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//button[text()='Login']")));
    loginButton.click();

    wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));

    driver.findElement(By.name("email")).sendKeys("your_email@domain.com"); // Use your actual email
    driver.findElement(By.name("password")).sendKeys("your_plain_text_password"); // Use your actual password

    driver.findElement(By.xpath("//button[@type='submit']")).click();

    try {
        Thread.sleep(15000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }

    String dashboardUrl = driver.getCurrentUrl();
    System.out.println("Dashboard URL: " + dashboardUrl);
}

@AfterClass
public void tearDown() {
    if (driver != null) {
        driver.quit();
    }
}


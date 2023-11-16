package main.java.demo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class Automate_post_on_linkedin {
    ChromeDriver driver;

    public Automate_post_on_linkedin() {

        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void endTest() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    public void linkedinPost() throws InterruptedException {

        System.out.println("Start Test case : linkedinPost");
        
        // Navigate to https://www.linkedin.com/  
        String url = "https://in.linkedin.com/ ";
        driver.get(url);
        // Enter the username Using Locator "ID" session_key | sendKeys("<username>")
        WebElement username = driver.findElement(By.id("session_key"));
        // Enter the password Using Locator "ID" session_key | sendKeys("<password>")
        WebElement password = driver.findElement(By.id("session_password"));

        Actions action = new Actions(driver);
        action.sendKeys(username,"shailesh.harsure1@gmail.com").sendKeys(Keys.TAB).sendKeys(password,"Panchmukhi@3496").perform();
        // Click Sign In Using Locator "XPath" //button[contains(text(),'Sign in')]
        driver.findElement(By.xpath("//button[contains(text(),'Sign in')]")).click();

        // Wait for the page to load  10000
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//div[text()='Welcome, Shailesh!']")));
        } 
        catch(RuntimeException e){
            System.out.println("Exception : Unable to locate the element within the specified time");
        }    

        // Click the Start a post button Using Locator "XPath" //span[text() = 'Start a post']/../parent::button
        driver.findElement(By.xpath("//span[text()='Start a post']")).click();
        // Wait for the pop up to appear  3000
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@id ='share-to-linkedin-modal__header']/button")));       
        // Click on the button at the top left corner Using Locator "XPath" //h2[@id ='share-to-linkedin-modal__header']/button
        driver.findElement(By.xpath("//h2[@id ='share-to-linkedin-modal__header']/button")).click();
        // Click on 'Collections only' Using Locator "ID" CONNECTIONS_ONLY
        driver.findElement(By.id("CONNECTIONS_ONLY")).click();
        // Click "Done" button Using Locator "XPath" //span[text() = 'Done']
        driver.findElement(By.xpath("//span[text() = 'Done']")).click();
        // Click the Add media button Using Locator "XPath" //button[@aria-label ='Add media']//span[@class ='share-promoted-detour-button__icon-container']]
        driver.findElement(By.xpath("//button[@aria-label ='Add media']//span[@class ='share-promoted-detour-button__icon-container']")).click();
        
        // Upload the picture Using Locator "XPath" input[@type='file'] | sendKeys("<file path>")
        WebElement uploadImage = driver.findElement(By.xpath("//input[@type='file']"));
        uploadImage.sendKeys("F:\\Crio.Do_QA in Automation Testing\\img_Snap.png");
        
        // Click Next button Using Locator "XPath" //span[text()= 'Next']
        driver.findElement(By.xpath("//span[text()= 'Next']")).click();
        // Click Post button Using Locator "XPath" //span[text() = 'Post']
        driver.findElement(By.xpath("//span[text()= 'Post']")).click();

        // Verfly if the image has been posted in timeline successfully Using Locator "XPath" //img[@alt='image preview'] | is Displayed();
        boolean status = driver.findElement(By.xpath("//img[@alt='image preview']")).isDisplayed();

        System.out.println("Image is displayed on the timeline" + status);

    }    
}
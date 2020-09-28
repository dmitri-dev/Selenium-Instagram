package com.example.instagram_test;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.Random;

public class MainPageTest {
    public WebDriver driver = setDriver();
    public Actions actions = new Actions(driver);
    public Random rand = new Random();
    public int setAttempts = 3;
    public int followRate = 10;
    public String username = "sudokevin";
    public String password = "jhunter";
    public WebDriver setDriver() {
        System.setProperty("webdriver.chrome.driver", "C:/Programs/chromedriver_win32/chromedriver.exe");
        return new ChromeDriver();
    }
    public List<WebElement> getPosts(int attempts) throws InterruptedException {
        Thread.sleep(1000);
        List<WebElement> posts = driver.findElements(By.cssSelector("div._9AhH0"));
        if (!posts.isEmpty()) {
            return posts;
        } else if (attempts > 0) {
            getPosts(--attempts);
        }
        return posts;
    }
    public void getPost(List<WebElement> posts) throws InterruptedException {
        Thread.sleep(1000);
        int random = rand.nextInt((posts.size()) - 1);
        posts.get(random).click();
        Thread.sleep(1000);
        boolean isPhoto = !driver.findElements(By.cssSelector("button.sqdOP.yWX7d._8A5w5")).isEmpty();
        if (!isPhoto) {
            System.out.println("Invalid Post");
            actions.sendKeys(Keys.ESCAPE).build().perform();
            getPost(posts);
        }
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("button.sqdOP.yWX7d._8A5w5")).click();
    }
    public void getFollowers(List<WebElement> people, int attempts) throws InterruptedException {
        Thread.sleep(1000);
        if (people.size() > followRate) {
            follow(people, followRate);
        } else if (attempts > 0) {
            driver.navigate().refresh();
            getFollowers(people, --attempts);
        }
    }
    public void follow(List<WebElement> people, int followRate) throws InterruptedException {
        Thread.sleep(1000);
        if (followRate > 0) {
            people.get(people.size() - followRate).click();
            follow(people, --followRate);
        }
    }

    @Test
    public void openPage() throws InterruptedException {
        driver.get("https://www.instagram.com/");

        // LOGIN
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@aria-label='Phone number, username, or email']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@aria-label='Password']")).sendKeys(password);
        Thread.sleep(1000);
        List<WebElement> buttons = driver.findElements(By.tagName("button"));
        buttons.get(1).click();
        Thread.sleep(1000);
        driver.findElement(By.tagName("button")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("button.sqdOP.L3NKy.y3zKF")).click();
        Thread.sleep(2000);
        driver.findElement(By.tagName("button")).click();

//        buttons = driver.findElements(By.xpath("//button[@tabindex='0']"));
//        buttons.get(1).click();
//
//        // EXPLORE PAGE
//        Thread.sleep(1000);
//        List<WebElement> icons = driver.findElements(By.cssSelector("svg._8-yf5"));
//        icons.get(2).click();
//        Thread.sleep(1000);
//        //-----------------------//
//        /*
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
//        Thread.sleep(1000);
//        */
//        //-----------------------//
//        List<WebElement> posts = getPosts(setAttempts);
//        //-----------------------//
////        System.out.println(posts);
//        //-----------------------//
//
//        // POST
//        getPost(posts);
//
//        // LIKES
//        Thread.sleep(1000);
//        List<WebElement> people = driver.findElements(By.cssSelector("button.sqdOP.L3NKy.y3zKF"));
//        getFollowers(people, setAttempts);
//        for (WebElement person : people) {
//            System.out.println(person);
//        }
    }
}
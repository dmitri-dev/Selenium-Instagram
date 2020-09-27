package com.example.instagram_test;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Random;

public class MainPageTest {
    public int followRate = 10;
    public String username = "sudokevin";
    public String password = "jhunter";
    public WebDriver setDriver() {
        System.setProperty("webdriver.chrome.driver", "C:/Programs/chromedriver_win32/chromedriver.exe");
        return new ChromeDriver();
    }
    public List<WebElement> getPosts(WebDriver driver, int i) throws InterruptedException {
        Thread.sleep(1000);
        List<WebElement> posts = driver.findElements(By.cssSelector("div._9AhH0"));
        if (!posts.isEmpty()) {
            return posts;
        } else if (i < 3) {
            getPosts(driver, i + 1);
        }
        return posts;
    }

    @Test
    public void openPage() throws InterruptedException {
        WebDriver driver = setDriver();
        driver.get("https://www.instagram.com/");

        // LOGIN
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@aria-label='Phone number, username, or email']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@aria-label='Password']")).sendKeys(password);
        Thread.sleep(1000);
        List<WebElement> buttons = driver.findElements(By.tagName("button"));
        buttons.get(1).click();
        Thread.sleep(2000);
        driver.findElement(By.tagName("button")).click();
        Thread.sleep(1000);
        buttons = driver.findElements(By.xpath("//button[@tabindex='0']"));
        buttons.get(1).click();

        // EXPLORE PAGE
        Thread.sleep(1000);
        List<WebElement> icons = driver.findElements(By.cssSelector("svg._8-yf5"));
        icons.get(2).click();
        Thread.sleep(1000);
        //-----------------------//
        /*
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
        Thread.sleep(1000);
        */
        //-----------------------//
        List<WebElement> posts = getPosts(driver, 0);
        //-----------------------//
//        System.out.println(posts);
        //-----------------------//
        Random rand = new Random();
        int random = rand.nextInt((posts.size()) - 1);
        posts.get(random).click();

        // POST (IMAGE / VIDEO)
        Thread.sleep(2000);
        boolean photo = true;
        try {
            driver.findElement(By.cssSelector("button.sqdOP.yWX7d._8A5w5")).click();
        } catch (Exception e) {
            System.out.println(e + "\n" + "Like Button Not Found");
            photo = false;
        }
        if (!photo) {
            System.out.println("Not Photo");
            driver.findElement(By.cssSelector(""));
        }

        // Likes
        List<WebElement> people = driver.findElements(By.cssSelector("button.sqdOP.L3NKy.y3zKF"));
        if (!people.isEmpty()) {
            if (followRate > people.size()) {
                for (int i = 0; i <= people.size(); i++) {
                    people.get(i).click();
                }
            } else {
                for (int i = 0; i <= followRate; i++) {
                    people.get(i).click();
                }
            }
        }
    }
}
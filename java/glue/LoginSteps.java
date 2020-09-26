package glue;

import cucumber.api.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginSteps extends Driver {
    public String username = "sudokevin";
    public String password = "jhunter";

    @When("Launch Instagram")
    public void launch_instagram() throws Throwable {
        driver.get("https://www.instagram.com/");
        Thread.sleep(2000);
    }

    @Then("^Enter username and password$")
    public void enter_credentials() throws Throwable {
        driver.findElement(By.xpath("//input[@aria-label='Phone number, username, or email']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@aria-label='Password']")).sendKeys(password);
    }

    @And("^Log in$")
    public void log_in() throws Throwable {
        Thread.sleep(1000);
        List<WebElement> buttons = driver.findElements(By.tagName("button"));
        buttons.get(1).click();
        Thread.sleep(2000);
        driver.findElement(By.tagName("button")).click();
        Thread.sleep(1000);
        buttons = driver.findElements(By.xpath("//button[@tabindex='0']"));
        buttons.get(1).click();
    }
}

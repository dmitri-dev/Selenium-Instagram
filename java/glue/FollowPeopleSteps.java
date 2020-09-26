package glue;

import cucumber.api.java.en.*;
import org.openqa.selenium.WebDriver;

public class FollowPeopleSteps extends Driver {
    WebDriver driver = getDriver();

    @Given("Navigate to Explore Page")
    public void navigate_to_Explore_Page() throws Throwable {
        driver.navigate().to("https://instagram.com/");
    }

    @When("Click on random photo")
    public void click_on_random_photo() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("Click on likes")
    public void click_on_likes() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("Follow People")
    public void follow_People() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @And("Navigate to homepage")
    public void navigate_to_homepage() {
    }
}

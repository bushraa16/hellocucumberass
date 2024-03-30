import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyStepdefs {
    private WebDriver driver;

    @Given("^user goes to the \"([^\"]*)\"$")
    public void user_goes_to_url(String url) {
        driver = new ChromeDriver();
        driver.get(url);
    }

    @Then("^user waits for 5 seconds$")
    public void user_waits() throws InterruptedException {
        Thread.sleep(5000);
    }

    @And("^verifies that the page title contains the word \"([^\"]*)\"$")
    public void verifies_page(String expectedTitle) {
        // Get the actual page title
        String actualTitle = driver.getTitle();

        // Assert that the expected word is present in the page title
        if (actualTitle.contains(expectedTitle)) {
            System.out.println("Page title contains the word: " + expectedTitle);
        } else {
            System.out.println("Page title does not contain the word: " + expectedTitle);
        }
    }

    @And("^closes the page$")
    public void closes_the_page() {
        // Close the browser and quit the WebDriver
        driver.quit();
    }}
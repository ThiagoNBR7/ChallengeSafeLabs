package steps;

import io.cucumber.java.Before;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.After;

public class CreateAnAccountStep {

    public WebDriver driver;
    public WebDriverWait wait;

    @Before
    public void open() {
        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @Given("since i'm on the registration screen")
    public void since_i_m_on_the_registration_screen() {
        String url = "http://automationpractice.com/index.php?controller=my-account";
        driver.get(url);
    }

    @When("fill the field {string}")
    public void fill_the_field(String emailAddress) {
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div[1]/form/div/div[2]/input")).sendKeys(emailAddress);
    }

    @And("click in Create an account")
    public void click_in_create_an_account() {
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div[1]/form/div/div[3]/button")).click();
    }

    @And("click in Tile Mr or Mrs")
    public void click_in_tile_mr_or_mrs() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("id_gender1")));
        driver.findElement(By.id("id_gender1")).click();
    }

    @And("fill the fields {string} and {string}")
    public void fill_the_fields_and(String firstName, String lastName) {
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/div[1]/div[2]/input")).sendKeys(firstName);
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/div[1]/div[3]/input")).sendKeys(lastName);
    }

    @And("fill the field in {string}")
    public void fill_the_field_in(String password) {
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/div[1]/div[5]/input")).sendKeys(password);
    }

    @And("select the Date Of Birth")
    public void select_the_date_of_birth() {
        driver.findElement(By.id("days")).sendKeys("1");
        driver.findElement(By.id("months")).sendKeys("January");
        driver.findElement(By.id("years")).sendKeys("2000");
    }

    @And("fill the fields {string} and select in {string}")
    public void fill_the_fields_and_select_in(String company, String address) {
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/div[2]/p[3]/input")).sendKeys(company);
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/div[2]/p[4]/input")).sendKeys(address);
    }

    @And("fill the field {string} and select in {string}")
    public void fill_the_field_and_select_in(String city, String state) {
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/div[2]/p[6]/input")).sendKeys(city);
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/div[2]/p[7]/div/select")).sendKeys(state);
    }

    @And("fill the field to {string} and select in {string}")
    public void fill_the_field_to_and_select_in(String postalCode, String country) {
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/div[2]/p[8]/input")).sendKeys(postalCode);
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/div[2]/p[9]/div/select")).sendKeys(country);
    }

    @And("fill the fields in {string} and {string}")
    public void fill_the_fields_in_and(String addInformation, String homeFone) {
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/div[2]/p[10]/textarea")).sendKeys(addInformation);
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/div[2]/p[12]/input")).sendKeys(homeFone);
    }

    @And("fill the fields the {string} and {string}")
    public void fill_the_fields_the_and(String mobileFone, String references) {
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/div[2]/p[13]/input")).sendKeys(mobileFone);
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/div[2]/p[14]/input")).sendKeys(references);
    }

    @And("click in Register")
    public void click_in_register() {
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/div[4]/button")).click();
    }

    @Then("one must find {string}")
    public void one_must_find(String sceneryType) {
        if (sceneryType.equals("Filld with Sucess")) {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/p/text()")));
            String outTxt = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/p/text()")).getText();
            String expectedTxt = "Welcome to your account. Here you can manage all of your personal information and orders.";
            Assert.assertEquals(expectedTxt, outTxt);
        }
    }

    @After
    public void close() {
        driver.quit();
    }

}

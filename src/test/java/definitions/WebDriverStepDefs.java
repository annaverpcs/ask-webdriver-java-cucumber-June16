package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
//import static org.testng.Assert.assertEquals;
import static org.junit.Assert.assertEquals;
import static support.TestContext.getDriver;

public class WebDriverStepDefs {
    @Given("I navigate {string}")
    public void iNavigate(String sURL) {
        switch (sURL) {
            case "google":
                getDriver().get("https://www.google.com/");
                break;
            case "duckduckgo":
                getDriver().get("https://duckduckgo.com");
                break;
            case "quote":
                getDriver().get("https://skryabin.com/market/quote.html");
                break;
            default:
                System.out.println("No URL found");
        }
    }

    @And("I print page details")
    public void iPrintPageDetails() {
        System.out.println(getDriver().getTitle());
        System.out.println(getDriver().getCurrentUrl());
        System.out.println(getDriver().getWindowHandle());
    }

    @When("I type {string} into email field")
    public void iTypeIntoEmailField(String sEmail) {
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys(sEmail);
    }

    @And("I click Submit button")
    public void iClickSubmitButton() {
        getDriver().findElement(By.xpath("//button[@id='formSubmit']")).click();

    }

    @Then("error message {string} should be displayed")
    public void errorMessageShouldBeDisplayed(String sMessage) {
        String sActualMessage = getDriver().findElement(By.xpath("//label[@id='email-error']")).getText();
        System.out.println(sActualMessage);
        assertThat(sActualMessage.equals(sMessage)).isTrue();

    }

    @When("Click on Name field")
    public void clickOnNameField() {
        getDriver().findElement(By.xpath("//input[@id='name']")).click();
    }

    @Then("I open Name dialog window")
    public void iOpenNameDialogWindow() {
        getDriver().findElement(By.xpath("//div[@id='nameDialog']")).isDisplayed();
        String sName = getDriver().findElement(By.xpath("//span[@class='ui-dialog-title']")).getText();
        assertThat(sName.equals("Name")).isTrue();
    }

    @Then("I type {string} as First Name {string} as Middle Name {string} as Last Name and validate the Full name is {string}")
    public void iTypeAsFirstNameAsMiddleNameAsLastNameAndValidateTheFullNameIs(String sFirstName, String sMiddleName, String sLastName, String sFullName) {
        getDriver().findElement(By.xpath(" //input[@id='firstName']")).sendKeys(sFirstName);
        getDriver().findElement(By.xpath(" //input[@id='middleName']")).sendKeys(sMiddleName);
        getDriver().findElement(By.xpath(" //input[@id='lastName']")).sendKeys(sLastName);
        getDriver().findElement(By.xpath("//span[contains(text(),'Save')]")).click();
        String sActualName = sFirstName + " " + sMiddleName + " " + sLastName;
        System.out.println("Actual Name is " + sActualName);
        System.out.println("Expected Name is " + sFullName);
        //assertThat(sActualName.equals(sFullName));
        assertEquals(sActualName, sFullName);
        Boolean isPresent = getDriver().findElement(By.xpath("//input[@id='name' and @value='" + sFullName + "']")).isDisplayed();
        System.out.println(isPresent);
        assertEquals(true, isPresent);

    }
}



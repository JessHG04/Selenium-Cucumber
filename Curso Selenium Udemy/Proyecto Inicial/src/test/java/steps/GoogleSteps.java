// 2º Tras definir los escenarios (.features), se definen los pasos y cómo estos se ejecutan
package steps;

//Import de Cucumber
import io.cucumber.java.en.*;
//import org.junit.Assert;
import pages.GooglePage;

public class GoogleSteps {
    GooglePage google = new GooglePage(); //Page Googe
    //Para evitar ambigüedad con otros test que empiecen igual, se añade el ^ al inicio
    // y $ al final
    @Given("^I am on the Google search page$")
    public void navigateToGoogle(){
        google.navigateToGoogle();
    }

    @When("^I enter the search criteria: (.+)$")
    public void enterSearchCriteria(String searchCriteria){
        google.enterSearchCriteria(searchCriteria);
    }

    @And("^Click on the search button$")
    public void clickSearchButton(){
        google.clickGoogleSearch();
    }

    @Then("^The browser show the results$")
    public void validateResults(){
        //Assert.assertEquals("Texto que esperamos", google.firstResult());
    }

}
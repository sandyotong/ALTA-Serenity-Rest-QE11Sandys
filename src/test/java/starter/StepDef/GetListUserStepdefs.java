package starter.StepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;

public class GetListUserStepdefs {
    @Steps
    ReqresAPI reqresAPI;
    @Given("Get list users with page {string}")
    public void getListUsersWithPage(String page) {
        reqresAPI.getListUsersInvalidParamPage(page);
    }

    @Then("Should return status code {int} Not Found")
    public void shouldReturnStatusCodeNotFound(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }
}

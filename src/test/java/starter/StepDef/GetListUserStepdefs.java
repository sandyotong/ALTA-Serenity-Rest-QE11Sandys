package starter.StepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;

public class GetListUserStepdefs {
    @Steps
    ReqresAPI reqresAPI;

    //Negative Case 1
    @Given("Get list users with page {string}")
    public void getListUsersWithPage(String page) {
        reqresAPI.getListUsersInvalidParamPage(page);
    }

    @Then("Should return status code {int} Not Found")
    public void shouldReturnStatusCodeNotFound(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    //Negative Case 2
    @Given("Page {int} is an invalid parameter for get a list of users")
    public void pageIsAnInvalidParameterForGetAListOfUsers(int page) {
        reqresAPI.getListUsersValidParamPage(page);
    }

    //Negative Case 3
    @Given("Empty parameter page for get list users")
    public void emptyParameterPageForGetListUsers() {
        reqresAPI.getListUsersInvalidParamPage("");
    }
}

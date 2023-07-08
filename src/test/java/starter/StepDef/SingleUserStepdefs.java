package starter.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Utils.Constans;
import starter.reqres.ReqresAPI;
import starter.reqres.ReqresResponses;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class SingleUserStepdefs {
    @Steps
    ReqresAPI reqresAPI;

    @Given("Get single user with id {int}")
    public void getSingleUserWithId(int id) {
        reqresAPI.getSingleUser(id);
    }

    @When("Send get single user")
    public void sendGetSingleUser() {
        SerenityRest.when().get(ReqresAPI.GET_SINGLE_USER);
    }

    @Then("Should return status code {int} OK")
    public void shouldReturnStatusCodeOK(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @And("Response body id should be {int}")
    public void responseBodyIdShouldBe(int id) {
        SerenityRest.then()
                .body(ReqresResponses
                        .DATA_ID,equalTo(id));
    }

    @And("Validate json scheme single user with valid parameter id")
    public void validateJsonSchemeSingleUserWithValidParameterId() {
        File json = new File(Constans.JSON_SCHEMA+"/SingleUserJson/SingleUserJSONSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Negative Case 1
    @Given("Get single user with exceed id {}")
    public void getSingleUserWithExceedId(int id) {
        reqresAPI.getSingleUser(id);
    }

    //Negative Case 2
    @Given("Get single user with first name {string}")
    public void getSingleUserWithFirstName(String firstName) {
        reqresAPI.getInvalidSingleUser(firstName);
    }

    @When("Send request get single user")
    public void sendRequestGetSingleUser() {
        SerenityRest.when().get(ReqresAPI.GET_INVALID_SINGLE_USER);
    }
}

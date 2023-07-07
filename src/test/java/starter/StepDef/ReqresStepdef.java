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

public class ReqresStepdef {
    @Steps
    ReqresAPI reqresAPI;
    @Given("Get list users with valid parameter page {int}")
    public void getListUsersWithValidParameterPage(int page) {
        reqresAPI.getListUsersValidParamPage(page);
    }

    @When("Send request get list users")
    public void sendRequestGetListUsers() {
        SerenityRest.when().get(ReqresAPI.GET_LIST_USERS);
    }

    @Then("Status code should be {int} OK")
    public void statusCodeShouldBeOK(int ok) {
        SerenityRest.then().statusCode(ok);
    }

    @And("Response body page value should be {int}")
    public void responseBodyPageValueShouldBe(int page) {
        SerenityRest.and()
                .body(ReqresResponses.PAGE,equalTo(page));
    }

    //POST
    @Given("Post create user with valid json")
    public void postCreateUserWithValidJson() {
        File json = new File(Constans.REQ_BODY+"/User.json");
        reqresAPI.postCreateUser(json);
    }

    @When("Send request post create user")
    public void sendRequestPostCreateUser() {
        SerenityRest.when()
                .post(ReqresAPI.POST_CREATE_USER);
    }

    @Then("Status code should be {int} Created")
    public void statusCodeShouldBeCreated(int created) {
        SerenityRest.then()
                .statusCode(created);
    }

    @And("Response body name was {string} and job was {string}")
    public void responseBodyNameWasAndJobWas(String name, String job) {
        SerenityRest.and()
                .body(ReqresResponses.NAME,equalTo(name))
                .body(ReqresResponses.JOB,equalTo(job));
    }
    @And("Validate post create user JSON Schema")
    public void validatePostCreateUserJSONSchema() {
        File json = new File(Constans.JSON_SCHEMA+"/CreateUserJSONSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //PUT
    @Given("Put update user with valid id {int} and json")
    public void putUpdateUserWithValidIdAndJson(int id) {
        File json = new File(Constans.REQ_BODY+"/UpdateJson/UpdateUser.json");
        reqresAPI.putUpdateUser(id,json);
    }

    @When("Send response put update user")
    public void sendResponsePutUpdateUser() {
        SerenityRest.when()
                .put(ReqresAPI.PUT_UPDATE_USER);
    }
    @And("Validate update list user JSON Schema")
    public void validateUpdateListUserJSONSchema() {
        File json = new File(Constans.JSON_SCHEMA+"/UpdateUserJSONSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //DELETE
    @Given("Delete user with valid id {int}")
    public void deleteUserWithValidId(int id) {
        reqresAPI.deleteUser(id);
    }

    @When("Send request delete user")
    public void sendDeleteUser() {
        SerenityRest.when()
                .delete(ReqresAPI.DELETE_USER);
    }

    @Then("Status code should be {int} No Content")
    public void statusCodeShouldBeNoContent(int noContent) {
        SerenityRest.then()
                .statusCode(noContent);
    }
}

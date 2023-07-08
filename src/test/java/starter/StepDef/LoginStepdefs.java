package starter.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import jnr.constants.Constant;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Utils.Constans;
import starter.reqres.ReqresAPI;
import starter.reqres.ReqresResponses;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class LoginStepdefs {
    @Steps
    ReqresAPI reqresAPI;

    //Positive Case1
    @Given("User login with valid email and password")
    public void userLoginWithValidEmailAndPassword() {
        File json = new File(Constans.REQ_BODY+"/LoginJson/LoginValid.json");
        reqresAPI.loginUser(json);
    }

    @When("Send request post login user")
    public void sendRequestPostLoginUser() {
        SerenityRest.when().post(ReqresAPI.LOGIN_USER);
    }

    @And("Response body token should be {string}")
    public void responseBodyTokenShouldBe(String token) {
        SerenityRest.then().body(ReqresResponses.TOKEN,equalTo(token));
    }

    @And("Validate json schema success login user")
    public void validateJsonSchemaSuccessLoginUser() {
        File json = new File(Constans.JSON_SCHEMA+"/LoginJSONSchema/LoginValidJSONSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Negative Case 2
    @Given("User login with valid email and blank password")
    public void userLoginWithValidEmailAndBlankPassword() {
        File json = new File(Constans.REQ_BODY+"/LoginJson/LoginBlank.json");
        reqresAPI.loginUser(json);
    }

    @And("Response error body should be {string}")
    public void responseErrorBodyShouldBe(String error) {
        SerenityRest.then().body(ReqresResponses.ERROR_MASSAGE,equalTo(error));
    }

    @And("Validate json schema failed login user with valid email and blank password")
    public void validateJsonSchemaFailedLoginUserWithValidEmailAndBlankPassword() {
        File json = new File(Constans.JSON_SCHEMA+"/LoginJSONSchema/LoginInvalidJSONSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Negative Case 3
    @Given("User login with unregister email and password")
    public void userLoginWithUnregisterEmailAndPassword() {
        File json = new File(Constans.REQ_BODY+"/LoginJson/LoginInvalidEmailPassword.json");
        reqresAPI.loginUser(json);
    }

    @And("Validate json schema failed login user with unregister email and password")
    public void validateJsonSchemaFailedLoginUserWithUnregisterEmailAndPassword() {
        File json = new File(Constans.JSON_SCHEMA+"/LoginJSONSchema/LoginInvalidJSONSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}

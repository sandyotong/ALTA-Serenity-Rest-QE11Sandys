package starter.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Utils.Constans;
import starter.reqres.ReqresAPI;
import starter.reqres.ReqresResponses;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class RegisterStepdefs {
    @Steps
    ReqresAPI reqresAPI;

    //Positive Case 1
    @Given("User register with valid email and password")
    public void userRegisterWithValidEmailAndPassword() {
        File json = new File(Constans.REQ_BODY+"/RegisterJson/RegisterUserValid.json");
        reqresAPI.registerUser(json);
    }
    @When("Send request post register user")
    public void sendRequestPostRegisterUser() {
        SerenityRest.when().post(ReqresAPI.REGISTER_USER);
    }

    @And("Response body id should be {int} and token {string}")
    public void responseBodyIdShouldBeAndToken(int id, String token) {
        SerenityRest.then()
                .body(ReqresResponses.ID,equalTo(id))
                .body(ReqresResponses.TOKEN,equalTo(token));
    }

    @And("Validate json schema success register user")
    public void validateJsonSchemaSuccessRegisterUser() {
        File json = new File(Constans.JSON_SCHEMA+"/RegisterJsonSchema/RegisterUserValidJSONSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Negative Case 1
    @Given("User register with valid email and blank password")
    public void userRegisterWithValidEmailAndBlankPassword() {
        File json = new File(Constans.REQ_BODY+"/RegisterJson/RegisterUserInvalidPassword.json");
        reqresAPI.registerUser(json);
    }

    @And("Response body error should be {string}")
    public void responseBodyErrorShouldBe(String error) {
        SerenityRest.then().body(ReqresResponses.ERROR_MASSAGE,equalTo(error));
    }

    @And("Validate json schema failed register user with valid email and blank password")
    public void validateJsonSchemaFailedRegisterUserWithValidEmailAndBlankPassword() {
        File json = new File(Constans.JSON_SCHEMA+"/RegisterJsonSchema/RegisterUserInvalidJSONSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Negative Case 2
    @Given("User register with blank email and valid password")
    public void userRegisterWithBlankEmailAndValidPassword() {
        File json = new File(Constans.REQ_BODY+"/RegisterJson/BlankEmail.json");
        reqresAPI.registerUser(json);
    }

    //Negative Case 3
    @Given("User register with not valid email format")
    public void userRegisterWithNotValidEmailFormat() {
        File json = new File(Constans.REQ_BODY+"/RegisterJson/NotValidEmail.json");
        reqresAPI.registerUser(json);
    }

    //Negative Case 4
    @Given("User register with Empty request body for register")
    public void userRegisterWithEmptyRequestBodyForRegister() {
        File json = new File(Constans.REQ_BODY+"/RegisterJson/Blank.json");
        reqresAPI.registerUser(json);
    }
}

package starter.StepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Utils.Constans;
import starter.reqres.ReqresAPI;

import java.io.File;

public class CreatUserStepdefs {

    @Steps
    ReqresAPI reqresAPI;
    @Given("Post create user with invalid json")
    public void postCreateUserWithInvalidJson() {
        File json = new File(Constans.REQ_BODY+"/CreateJson/CreateBlankId.json");
        reqresAPI.postCreateUser(json);
    }

    @Then("Status code should be {int} Bad Request")
    public void statusCodeShouldBeBadRequest(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @Given("Post create user with category name, job, and hobby")
    public void postCreateUserWithCategoryNameJobAndHobby() {
        File json = new File(Constans.REQ_BODY+"/CreateJson/CreateInvalidHobby.json");
        reqresAPI.postCreateUser(json);
    }

    @Given("Post create user with category name and job is 5678")
    public void postCreateUserWithCategoryNameAndJobIs() {
        File json = new File(Constans.REQ_BODY+"/CreateJson/CreateInvalidJob.json");
        reqresAPI.postCreateUser(json);
    }

    @Given("Post create user with name is $AND! and job is QA Engineer")
    public void postCreateUserWithNameIs$ANDAndJobIsQAEngineer() {
        File json = new File(Constans.REQ_BODY+"/CreateJson/CreateInvalidName.json");
        reqresAPI.postCreateUser(json);
    }
}

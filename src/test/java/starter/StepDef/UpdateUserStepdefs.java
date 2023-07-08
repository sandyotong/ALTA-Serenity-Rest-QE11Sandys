package starter.StepDef;

import io.cucumber.java.en.Given;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Utils.Constans;
import starter.reqres.ReqresAPI;

import java.io.File;

public class UpdateUserStepdefs {
    @Steps
    ReqresAPI reqresAPI;

    //Negative Case 1
    @Given("Put update user with valid id {int} and invalid json")
    public void putUpdateUserWithValidIdAndInvalidJson(int id) {
        File json = new File(Constans.REQ_BODY+"/UpdateJson/UpdateInvalidHobby.json");
        reqresAPI.putUpdateUser(id,json);
    }

    //Negative Case 2
    @Given("Put update user with empty name and job with id {int}")
    public void putUpdateUserWithEmptyNameAndJobWithId(int id) {
        File json = new File(Constans.REQ_BODY+"/UpdateJson/UpdateInvalidBlank.json");
        reqresAPI.putUpdateUser(id,json);
    }

    //Negative Case 3
    @Given("Put update user with empty name and valid job with id {int}")
    public void putUpdateUserWithEmptyNameAndValidJobWithId(int id) {
        File json = new File(Constans.REQ_BODY+"/UpdateJson/UpdateInvalidName.json");
        reqresAPI.putUpdateUser(id,json);
    }

    //Negative Case 4
    @Given("Put update user with valid name and empty job with id {int}")
    public void putUpdateUserWithValidNameAndEmptyJobWithId(int id) {
        File json = new File(Constans.REQ_BODY+"/UpdateJson/UpdateInvalidJob.json");
        reqresAPI.putUpdateUser(id,json);
    }
}

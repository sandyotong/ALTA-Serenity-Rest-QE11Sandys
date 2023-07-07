package starter.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Utils.Constans;
import starter.reqres.ReqresAPI;

import java.io.File;

public class PatchUpdateUserStepdefs {
    @Steps
    ReqresAPI reqresAPI;
    @Given("Patch update user with valid id {int} json")
    public void patchUpdateUserWithValidIdJson(int id){
        File json = new File(Constans.REQ_BODY+"/PatchJson/PatchUpdateValid.json");
        reqresAPI.patchUpdateUser(id,json);
    }

    @When("Send patch update user")
    public void sendPatchUpdateUser() {
        SerenityRest.when().patch(ReqresAPI.PATCH_UPDATE_USER);
    }

    @And("Validate patch update user JSON Schema")
    public void validatePatchUpdateUserJSONSchema() {
        File json = new File(Constans.JSON_SCHEMA+"/UpdateUserJSONSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Patch update user with empty name and job with id {int}")
    public void patchUpdateUserWithEmptyNameAndJobWithId(int id) {
        File json = new File(Constans.REQ_BODY+"/PatchJson/PatchUpdateBlank.json");
        reqresAPI.patchUpdateUser(id,json);
    }
}

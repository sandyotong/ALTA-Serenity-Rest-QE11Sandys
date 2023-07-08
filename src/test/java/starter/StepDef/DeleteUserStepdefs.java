package starter.StepDef;

import io.cucumber.java.en.Given;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;

public class DeleteUserStepdefs {
    @Steps
    ReqresAPI reqresAPI;

    //Negative Case 1
    @Given("Delete user with invalid id {string}")
    public void deleteUserWithInvalidId(String id) {
        reqresAPI.deleteInvalidUser(id);
    }
}

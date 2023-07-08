package starter.StepDef;

import io.cucumber.java.en.Given;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;

public class DeleteUserStepdefs {
    @Steps
    ReqresAPI reqresAPI;

    //Negative Case 1
    @Given("Page {int} is an invalid parameter for delete a list of users")
    public void pageIsAnInvalidParameterForDeleteAListOfUsers(int id) {
        reqresAPI.deleteUser(id);
    }

    //Negative Case 2
    @Given("Delete user with invalid id {string}")
    public void deleteUserWithInvalidId(String id) {
        reqresAPI.deleteInvalidUser(id);
    }

}

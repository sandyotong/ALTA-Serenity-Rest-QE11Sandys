package starter.reqres;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Utils.Constans;

import java.io.File;

public class ReqresAPI {
    public static String GET_LIST_USERS = Constans.BASE_URL + "/api/users?page={page}";
    public static String POST_CREATE_USER = Constans.BASE_URL + "/api/users";
    public static String PUT_UPDATE_USER = Constans.BASE_URL + "/api/users/{id}";
    public static String DELETE_USER = Constans.BASE_URL + "/api/users/{id}";

    //GET
    @Step("Get list users")
    public void getListUsers(int page){
        SerenityRest.given()
                .pathParam("page", page);
    }

    //POST
    @Step("Post create new user")
    public void postCreateUser(File json){
        SerenityRest.given()
                .contentType(ContentType
                        .JSON).body(json);
    }

    //PUT
    @Step("Put update user")
    public void putUpdateUser(int id, File json){
        SerenityRest.given().pathParam("id",id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    //DELETE
    @Step("Delete user")
    public void deleteUser(int id){
        SerenityRest.given()
                .pathParam("id",id);
    }
}

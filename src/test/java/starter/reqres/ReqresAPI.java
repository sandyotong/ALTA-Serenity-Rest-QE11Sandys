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
    public static String PATCH_UPDATE_USER = Constans.BASE_URL+"/api/users/{id}";
    public static String GET_SINGLE_USER = Constans.BASE_URL+"/api/users/{id}";
    public static String GET_INVALID_SINGLE_USER = Constans.BASE_URL+"/api/users/{firstName}";
    public static String GET_SINGLE_RESOURCE = Constans.BASE_URL+"/api/unknown/{id}";
    public static String LOGIN_USER = Constans.BASE_URL+"/api/login";
    public static String REGISTER_USER = Constans.BASE_URL+"/api/register";

    //GET
    @Step("Get list users with valid parameter page")
    public void getListUsersValidParamPage(int page) {
        SerenityRest.given()
                .pathParam(ReqresResponses.PAGE,page);
    }
    @Step("Get single user")
    public void getSingleUser(int id) {
        SerenityRest.given()
                .pathParam(ReqresResponses.ID,id);
    }
    @Step("Get single resource")
    public void getSingleResource(int id) {
        SerenityRest.given()
                .pathParam(ReqresResponses.ID,id);
    }
    @Step("Get invalid single user")
    public void getInvalidSingleUser(String firstName) {
        SerenityRest.given()
                .pathParam(ReqresResponses.FIRST_NAME,firstName);
    }
    @Step("Get list users with invalid parameter page")
    public void getListUsersInvalidParamPage(String page) {
        SerenityRest.given()
                .pathParam(ReqresResponses.PAGE,page);
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

    //PATCH
    @Step("Patch update user")
    public void patchUpdateUser(int id, File json) {
        SerenityRest.given()
                .pathParam(ReqresResponses.ID,id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    //REGISTER
    @Step("Register user")
    public void registerUser (File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    //LOGIN
    @Step("Login user")
    public void loginUser (File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    //DELETE
    @Step("Delete user")
    public void deleteUser(int id){
        SerenityRest.given()
                .pathParam(ReqresResponses.ID ,id);
    }
    @Step("Delete invalid user")
    public void deleteInvalidUser(String id) {
        SerenityRest.given()
                .pathParam(ReqresResponses.ID,id);
    }
}

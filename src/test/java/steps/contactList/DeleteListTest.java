package steps.contactList;

import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import config.UserConfig;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class DeleteListTest {
    @Then("Change contact list properties")
    public void testDeleteOneContact() {
        Map<String, String> params = new HashMap<>();

        params.put("format", UserConfig.getFormat());
        params.put("api_key", UserConfig.getApiKey());
        params.put("list_id", UserConfig.getListId());


        RestAssured.baseURI = UserConfig.getBaseURI();
        RestAssured.basePath = "/deleteList";

        given()
                .contentType("application/json")
                .queryParams(params)
                .when()
                .post()
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);
    }
}
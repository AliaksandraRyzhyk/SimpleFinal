package steps.contactList;

import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import config.UserConfig;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class GetListTest {
    @Then("Get a final list of all available contacts")
    public void testGetContactList() {
        Map<String, String> params = new HashMap<>();

        params.put("format", UserConfig.getFormat());
        params.put("api_key", UserConfig.getApiKey());

        RestAssured.baseURI = UserConfig.getBaseURI();
        RestAssured.basePath = "/getLists";

        Response response = given()
                .contentType("application/json")
                .queryParams(params)
                .when()
                .get()
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();

        String jsonStr = response.asString();

        Assertions.assertNotNull(jsonStr);
    }
}

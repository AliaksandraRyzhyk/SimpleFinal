package steps.contactList;

import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import config.UserConfig;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class CreateListTest {
    @Then("Create a new contact list")
    public void testCreateNewContact() {
        Map<String, String> params = new HashMap<>();

        params.put("format", UserConfig.getFormat());
        params.put("api_key", UserConfig.getApiKey());
        params.put("title", UserConfig.getTitle());

        RestAssured.baseURI = UserConfig.getBaseURI();
        RestAssured.basePath = "/createList";

        String responseId = given()
                .contentType("application/json")
                .queryParams(params)
                .when()
                .post()
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .jsonPath()
                .getString("result.id");

        System.out.println("New client id: " + responseId);

        Assertions.assertNotNull(responseId);
    }
}



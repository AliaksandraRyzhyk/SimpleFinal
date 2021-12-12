package steps.emailTemplate;

import config.UserConfig;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class GetTemplates {
    @Then("Get a list of all templates created both through the UniSender personal account and through the API")
    public void getEmailTemplate() {
        Map<String, String> params = new HashMap<>();

        params.put("format", UserConfig.getFormat());
        params.put("api_key", UserConfig.getApiKey());

        RestAssured.baseURI = UserConfig.getBaseURI();
        RestAssured.basePath = "/getTemplates";

        given()
                .contentType("application/json")
                .queryParams(params)
                .when()
                .get()
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);
    }
}

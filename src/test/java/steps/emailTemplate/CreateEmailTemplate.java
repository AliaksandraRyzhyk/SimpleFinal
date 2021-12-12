package steps.emailTemplate;

import config.UserConfig;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;

public class CreateEmailTemplate {
    private static String response;

    @Then("Create the message template for mass mailing")
    public void createTemplate() {
        Map<String, String> params = new HashMap<>();

        params.put("format", UserConfig.getFormat());
        params.put("api_key", UserConfig.getApiKey());
        params.put("title", UserConfig.getTitleTemplate());
        params.put("subject", UserConfig.getSubject());
        params.put("body", UserConfig.getBody());


        RestAssured.baseURI = UserConfig.getBaseURI();
        RestAssured.basePath = "/createEmailTemplate";

        setResponse(given()
                .contentType("application/json")
                .queryParams(params)
                .when()
                .post()
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .extract().jsonPath().getString("result.template_id"));

    }

    public static String getResponse() {
        return response;
    }

    public static void setResponse(String responseNew) {
        response = responseNew;
    }
}



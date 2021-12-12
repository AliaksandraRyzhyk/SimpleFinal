package steps.emailTemplate;

import config.UserConfig;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class UpdateEmailTemplate {
    @Then("Update the email template for mass mailing")
    public void updateTemplate() {
        String response = CreateEmailTemplate.getResponse();
        Map<String, String> params = new HashMap<>();

        params.put("format", UserConfig.getFormat());
        params.put("api_key", UserConfig.getApiKey());
        params.put("template_id", response);
        params.put("title", UserConfig.getTitleTemplate() + " 2021");

        RestAssured.baseURI = UserConfig.getBaseURI();
        RestAssured.basePath = "/updateEmailTemplate";

        String responseWarnings = given()
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
                .getString("warnings");

        Assertions.assertNotNull(responseWarnings);
    }
}



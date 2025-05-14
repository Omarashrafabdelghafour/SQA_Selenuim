import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
@Test
public class Lab9 {

    @Test
    public void testBasicResponse() {
        Response response = RestAssured.get("https://reqres.in/api/users?page=2");

        System.out.println("Status Code: " + response.statusCode());
        System.out.println("Response Body: " + response.getBody().asString());
        System.out.println("Status Line: " + response.statusLine());

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }

    @Test
    public void testStatusCode() {
        given().
                when().
                get("https://reqres.in/api/users?page=2").
                then().
                statusCode(200);
    }

    @Test
    public void testResponseBodyAndHeaders() {
        given().
                when().
                get("https://reqres.in/api/users?page=2").
                then().
                statusCode(200).
                body("data.id[1]", equalTo(8)).
                body("data.first_name", hasItems("Michael", "Lindsay")).
                contentType(ContentType.JSON).
                // Only assert Content-Encoding if you're sure the API returns it
                        header("Content-Encoding", equalTo("gzip")).
                log().all();
    }

    @Test
    public void testPutRequest() {
        JSONObject request = new JSONObject();
        request.put("name", "chaya");
        request.put("job", "BAAA");

        given()
                .header("Content-Type", "application/json")
                .body(request.toJSONString())
                .when()
                .put("https://reqres.in/api/users/2")
                .then()
                .statusCode(200)
                .body("name", equalTo("chaya"))
                .body("job", equalTo("BAAA"))
                .log().all();}
}

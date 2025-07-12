import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;


public class ApiTests {
    @Test
    void Create_user (){

        // AAA -> Arrange -> Act -> Assert
        String body = """
                {
                  "id": 0,
                  "username": "string",
                  "firstName": "string",
                  "lastName": "string",
                  "email": "string",
                  "password": "string",
                  "phone": "string",
                  "userStatus": 0
                }
                """;
        Response response = given ()
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .baseUri("https://petstore.swagger.io/v2")
                .when()
                .body(body).post("/user")
                .andReturn();
        int actualCode = response.getStatusCode();
        Assertions.assertEquals(200,actualCode);
    }
    @Test
    void Create_user2 (){

        // AAA -> Arrange -> Act -> Assert
        String body2 = """
                {
                  "id": 0,
                  "username": "string",
                  "firstName": "string",
                  "lastName": "string",
                  "email": "string",
                  "password": "string",
                  "phone": "string",
                  "userStatus": 0
                }
                """;
        given ()
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .baseUri("https://petstore.swagger.io/v2")
                .when()
                .body(body2)
                .post("/user")
                    .then()
                        .statusCode(200)
                            .body("code",equalTo(200))
                .body("type",equalTo("unknown"))
                .body("message",notNullValue(String.class));

        //int actualCode = response.getStatusCode();
        //Assertions.assertEquals(200,actualCode);
    }

}

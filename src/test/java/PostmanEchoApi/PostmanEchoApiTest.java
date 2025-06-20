package PostmanEchoApi;

import io.restassured.RestAssured;
import org.junit.jupiter.api.*;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PostmanEchoApiTest {
    @BeforeAll
    static void setup() {
        RestAssured.baseURI = "https://postman-echo.com"; // Общий URL для всех тестов
    }
    // GET
    @Test
    void getRequest_ShouldReturnQueryParams() {
        given()
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .when()
                .get("/get")
                .then()
                .statusCode(200)
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"));
    }
    // POST (JSON)
    @Test
    void postRequest_ShouldReturnJsonBody() {
        given()
                .contentType("application/json")
                .body("{\"name\":\"Bob\"}")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("json.name", equalTo("Bob"));
    }
    // POST (Form Data)
    @Test
    void postFormData_ShouldReturnFormParams() {
        given()
                .contentType("multipart/form-data")  //  Тут был application/x-www-form-urlencoded, а это неправильный контент тайп
                .multiPart("key", "value")          // формирование form-data
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("form.key", equalTo("value")); // Проверка поля form, а не json
    }
    // PUT
    @Test
    void putRequest_ShouldReturnRequestBody() {
        given()
                .body("Updated data")
                .when()
                .put("/put")
                .then()
                .statusCode(200)
                .body("data", equalTo("Updated data"));
    }
    // PATCH
    @Test
    void patchRequest_ShouldModifyResource() {
        given()
                .body("Partial update")
                .when()
                .patch("/patch")
                .then()
                .statusCode(200)
                .body("data", equalTo("Partial update"));
    }
    // DELETE
    @Test
    void deleteRequest_ShouldReturnSuccess() {
        when()
                .delete("/delete")
                .then()
                .statusCode(200)
                .body("url", containsString("/delete"));
    }
}
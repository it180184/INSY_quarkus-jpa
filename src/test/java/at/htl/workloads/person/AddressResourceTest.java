package at.htl.workloads.person;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@QuarkusTest
public class AddressResourceTest {

    @Test
    public void addAddressTest () {
        given().pathParam("ssn", "123456789")
                .when().contentType(ContentType.JSON).body("{\n" +
                        "  \"street\": \"Musterstraße\",\n" +
                        "  \"houseNo\": \"1\",\n" +
                        "  \"zipCode\": \"1234\",\n" +
                        "  \"town\": \"Musterdorf\",\n" +
                        "  \"country\": \"Österreich\"\n" +
                        "}").post("/api/address/{ssn}").then().statusCode(200);
    }

    @Test
    public void getCityNamesTest() {
        given().when().get("/api/address/all/cities").then().statusCode(200).body(is("[\"Musterdorf\"]"));
    }
}

package in.reqres.specifications;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import props.TestData;

public class Specification {
    /**
     * @return RequestSpecification
     */
    public static RequestSpecification requestSpec() {
        String baseUrl = TestData.url.baseUrlReqres();
        return new RequestSpecBuilder()
                .setBaseUri(baseUrl)
                .setContentType("application/json")
                .build();
    }

    public static ResponseSpecification responseSpec(Integer statusCode) {
        return new ResponseSpecBuilder()
                .expectStatusCode(statusCode)
                .build();
    }

    public static void installAllSpec(Integer statusCode){
        RestAssured.requestSpecification = requestSpec();
        RestAssured.responseSpecification = responseSpec(statusCode);
    }
}

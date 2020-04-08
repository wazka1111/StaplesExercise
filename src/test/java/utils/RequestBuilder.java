package utils;

import Model.Student;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RequestBuilder {
    public Response sendGETRequest_Student(Student student) {
        Response response = given()
                .log()
                .ifValidationFails()
                .when()
                .get(student.getId());
        return response;
    }

    public Response sendPOSTRequest_Student(Student student) {
        String requestBody = JsonConnector.jsonSerializerStudent(student);
        Response response = given()
                .contentType("application/json")
                .log()
                .ifValidationFails()
                .when()
                .body(requestBody)
                .post();
        return response;
    }
}

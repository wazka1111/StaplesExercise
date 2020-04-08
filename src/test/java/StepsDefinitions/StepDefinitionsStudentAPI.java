package StepsDefinitions;

import Model.Student;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import utils.JsonConnector;
import utils.RequestBuilder;

import java.io.File;
import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class StepDefinitionsStudentAPI {
    private final static String DATA_PATH = "src/test/java/TestData/Student.json";
    private static Student student = JsonConnector.fillStudentData(new File(DATA_PATH));
    Response response;
    RequestBuilder requestBuilder;

    @Given("New student object is created")
    public void newStudentObjectIsCreated() throws IOException {
        requestBuilder = new RequestBuilder();
    }

    @When("User perform POST operation")
    public void userPerformPOSTOperation() {
        response = requestBuilder.sendPOSTRequest_Student(student);
    }

    @Then("User is able to see response with new student details")
    public void userIsAbleToSeeResponseWithNewStudentDetails() {
        int responseStudentId = response
                .then()
                .log()
                .ifValidationFails()
                .body("first_name", is(student.getFirst_name()))
                .body("last_name", is(student.getLast_name()))
                .body("middle_name", is(student.getMiddle_name()))
                .body("date_of_birth", is(student.getDate_of_birth()))
                .extract().path("id");
        student.setId(String.valueOf(responseStudentId));
        response = null;
    }

    @Given("New student is created in the system")
    public void new_student_is_created_in_the_system() {
        requestBuilder = new RequestBuilder();
    }

    @When("User perform GET operation")
    public void user_perform_GET_operation() {
        response = requestBuilder.sendGETRequest_Student(student);
    }

    @Then("Valid status code is visible in the response")
    public void valid_status_code_is_visible_in_the_response() {
        response.then()
                .log()
                .ifValidationFails()
                .statusCode(200);
        response = null;
    }

    @Given("New student is created in the system with unique id")
    public void new_student_is_created_in_the_system_with_unique_id() {
        requestBuilder = new RequestBuilder();
    }

    @Then("Valid student id is visible in the response")
    public void valid_student_id_is_visible_in_the_response() {
        int id = response.then()
                .log()
                .ifValidationFails()
                .extract().path("data.id");
        assertThat(student.getId(), equalTo(String.valueOf(id)));
        response = null;
    }

    @Given("New student is created in the system with first_name")
    public void new_student_is_created_in_the_system_with_first_name() {
        requestBuilder = new RequestBuilder();
    }

    @Then("Valid student first_name is visible in the response")
    public void valid_student_first_name_is_visible_in_the_response() {
        String first_name = response.then()
                .log()
                .ifValidationFails()
                .extract().path("data.first_name");
        assertThat(student.getFirst_name(), equalTo(String.valueOf(first_name)));
        response = null;
    }

    @Given("New student is created in the system with middle_name")
    public void new_student_is_created_in_the_system_with_middle_name() {
        requestBuilder = new RequestBuilder();
    }

    @Then("Valid student middle_name is visible in the response")
    public void valid_student_middle_name_is_visible_in_the_response() {
        String middle_name = response.then()
                .log()
                .ifValidationFails()
                .extract().path("data.middle_name");
        assertThat(student.getMiddle_name(), equalTo(String.valueOf(middle_name)));
        response = null;
    }

    @Given("New student is created in the system with last_name")
    public void new_student_is_created_in_the_system_with_last_name() {
        requestBuilder = new RequestBuilder();
    }

    @Then("Valid student last_name is visible in the response")
    public void valid_student_last_name_is_visible_in_the_response() {
        String last_name = response.then()
                .log()
                .ifValidationFails()
                .extract().path("data.last_name");
        assertThat(student.getLast_name(), equalTo(String.valueOf(last_name)));
        response = null;
    }

    @Given("New student is created in the system with date_of_birth")
    public void new_student_is_created_in_the_system_with_date_of_birth() {
        requestBuilder = new RequestBuilder();
    }

    @Then("Valid student date_of_birth is visible in the response")
    public void valid_student_date_of_birth_is_visible_in_the_response() {
        String date_of_birth = response.then()
                .log()
                .ifValidationFails()
                .extract().path("data.date_of_birth");
        assertThat(student.getDate_of_birth(), equalTo(String.valueOf(date_of_birth)));
        response = null;
    }
}

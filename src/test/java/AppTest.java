import Base.Base;
import Model.Student;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import utils.JsonConnector;
import utils.RequestBuilder;
import utils.TestListener;

import java.io.File;
import java.io.IOException;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(TestListener.class)   //define reaction for various test status after execution
public class AppTest extends Base {
    private Student student;
    private final static String DATA_PATH = "src/test/java/TestData/Student.json";
    RequestBuilder responseBuilder;

    @BeforeAll
    public  void setUp() throws IOException {
        student= JsonConnector.fillStudentData(new File(DATA_PATH));
        responseBuilder = new RequestBuilder();
    }
    // -----------POST section------------------------------------
    @Test
    @Order(1)
    @Tag("post")
    @Tag("student")
    public void PostStudent_CreateNewStudent() {
        Response response = responseBuilder.sendPOSTRequest_Student(student);
         int responseStudentId=response
                 .then()
                 .log()
                 .ifValidationFails()
                 .body("first_name", is(student.getFirst_name()))
                 .body("last_name", is(student.getLast_name()))
                 .body("middle_name", is(student.getMiddle_name()))
                 .body("date_of_birth", is(student.getDate_of_birth()))
                 .extract().path("id");
        student.setId(String.valueOf(responseStudentId));
    }
    //------------GET section-------------------------------------
    @Test
    @Order(2)
    @Tag("get")
    @Tag("student")
    public void GetStudent_StatusCodeTest() {
        Response response = responseBuilder.sendGETRequest_Student(student);
        response.then()
                .log()
                .ifValidationFails()
                .statusCode(200);
    }

    @Test
    @Order(3)
    @Tag("get")
    @Tag("student")
    public void GetStudent_ContentTest_Id() {
        Response response = responseBuilder.sendGETRequest_Student(student);
        int id = response.then()
                .log()
                .ifValidationFails()
                .extract().path("data.id");
        assertThat(student.getId(), equalTo(String.valueOf(id)));
    }

    @Test
    @Order(4)
    @Tag("get")
    @Tag("student")
    public void GetStudent_ContentTest_FirstName() {
        Response response = responseBuilder.sendGETRequest_Student(student);
        String first_name = response.then()
                .log()
                .ifValidationFails()
                .extract().path("data.first_name");
        assertThat(student.getFirst_name(), equalTo(String.valueOf(first_name)));
    }

    @Test
    @Order(5)
    @Tag("get")
    @Tag("student")
    public void GetStudent_ContentTest_MiddleName() {
        Response response = responseBuilder.sendGETRequest_Student(student);
        String middle_name = response.then()
                .log()
                .ifValidationFails()
                .extract().path("data.middle_name");
        assertThat(student.getMiddle_name(), equalTo(String.valueOf(middle_name)));
    }

    @Test
    @Order(6)
    @Tag("get")
    @Tag("student")
    public void GetStudent_ContentTest_LastName() {
        Response response = responseBuilder.sendGETRequest_Student(student);
        String last_name = response.then()
                .log()
                .ifValidationFails()
                .extract().path("data.last_name");
        assertThat(student.getLast_name(), equalTo(String.valueOf(last_name)));
    }

    @Test
    @Order(6)
    @Tag("get")
    @Tag("student")
    public void GetStudent_ContentTest_BirthDate() {
        Response response = responseBuilder.sendGETRequest_Student(student);
        String date_of_birth = response.then()
                .log()
                .ifValidationFails()
                .extract().path("data.date_of_birth");
        assertThat(student.getDate_of_birth(), equalTo(String.valueOf(date_of_birth)));
    }
}

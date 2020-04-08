package Base;

import TestData.Data;
import com.google.gson.JsonParseException;
import groovyjarjarantlr4.v4.runtime.RuleDependencies;
import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import utils.JsonConnector;
import java.io.File;
import java.io.IOException;

public class Base {
    private static Data data;
    private final static String DATA_PATH = "src/test/java/TestData/Data.json";


    @BeforeAll
    public static void init() throws JsonParseException, IOException {
        data= JsonConnector.readData(new File(DATA_PATH));
        RestAssured.baseURI = data.getBaseURI();
        RestAssured.basePath = data.getBasePath();
        //RestAssured.port = data.getPort();   //not necessary for this scenario
    }

    @AfterEach
    public void printEnd() {
        System.out.println("-------------Test finish-------");
    }
}

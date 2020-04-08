package StepsDefinitions;

import TestData.Data;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.RestAssured;
import utils.JsonConnector;

import java.io.File;

public class Hooks {
    private static Data data;
    private final static String DATA_PATH = "src/test/java/TestData/Data.json";

    @Before(order = 1)                //executed before each single scenario
    public void initTitle(Scenario scenario) {
        System.out.println("START. SCENARIO NAME = " + scenario.getName());
    }

    @Before(order = 2)                //executed before each single scenario
    public void initData(Scenario scenario) {
        data= JsonConnector.readData(new File(DATA_PATH));
        RestAssured.baseURI = data.getBaseURI();
        RestAssured.basePath = data.getBasePath();
        //RestAssured.port = data.getPort();   //not necessary for this scenario
    }


    @After                              //executed after each single scenario
    public void tearDown(Scenario scenario) {

        System.out.println("AFTER. SCENARIO NAME =  " + scenario.getName() + ". STATUS =  " + scenario.getStatus());
    }
}


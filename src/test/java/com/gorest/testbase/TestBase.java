package com.gorest.testbase;

import com.gorest.utils.TestsUtils;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;

public class TestBase extends TestsUtils {


    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://gorest.co.in";
        RestAssured.basePath = "/public/v2";

    }
}

package com.gorest.testsuite;

import com.gorest.testbase.TestBase;
import io.restassured.response.ValidatableResponse;
import org.codehaus.groovy.util.ListHashMap;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class PostsExtractionTest extends TestBase {
    static ValidatableResponse response;
    public PostsExtractionTest(){
        response = given()
                .queryParam("page", 1)
                .queryParam("per_page", 25)
                .when()
                .get("/posts")
                .then().statusCode(200);
    }

    //1. Extract the title
    @Test
    public void test001() {
        List<String> allTitle = response.extract().path("title");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("All titles are : " + allTitle);
        System.out.println("------------------End of Test---------------------------");
    }

    //2. Extract the total number of record
    @Test
    public void test002() {
        List<Integer> totalRecord = response.extract().path("id");
        int size = totalRecord.size();

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Total number of record " + size);
        System.out.println("------------------End of Test---------------------------");
    }

    //3. Extract the body of 15th record
    @Test
    public void test003() {
        String record = response.extract().path("[14].body");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("15th Record's body : " + record);
        System.out.println("------------------End of Test---------------------------");
    }

    //4. Extract the user_id of all the records
    @Test
    public void test004() {
        List<Object> ids = response.extract().path("id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("All user's Ids : " + ids);
        System.out.println("------------------End of Test---------------------------");
    }

    //5. Extract the title of all the records
    @Test
    public void test005() {
        List<String> titles = response.extract().path("title");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("All user's titles : " + titles);
        System.out.println("------------------End of Test---------------------------");
    }

    //6. Extract the title of all records whose user_id = 5428
    @Test
    public void test006() {
        List<Object> ids =response.extract().path("findAll{it.user_id == 5428}.title");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Title of user_id = 5428 : "+ ids);
        System.out.println("------------------End of Test---------------------------");
    }

    //7. Extract the body of all records whose id = 2671
    @Test
    public void test007() {
        List<Object> bodyRecord =response.extract().path("findAll{it.id == 2670}.body");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Records body of id = 2670 is : "+ bodyRecord);
        System.out.println("------------------End of Test---------------------------");
    }


}

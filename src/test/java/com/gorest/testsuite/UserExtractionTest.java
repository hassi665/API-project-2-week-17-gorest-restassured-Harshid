package com.gorest.testsuite;

import com.gorest.testbase.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class UserExtractionTest extends TestBase {
    static ValidatableResponse response;

        public UserExtractionTest(){
           response = given()
                   .queryParam("page", 1)
                   .queryParam("per_page", 20)
                   .when()
                   .get("/users")
                   .then().statusCode(200);
       }

       //1. Extract the all Ids
    @Test
    public void test001() {
        List<Integer> allIds = response.extract().path("id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("All Ids are : " + allIds);
        System.out.println("------------------End of Test---------------------------");
    }
    // 2. Extract the all Names
    @Test
    public void test002() {
        List<String> allNames = response.extract().path("name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("All Names are : " + allNames);
        System.out.println("------------------End of Test---------------------------");
    }
    //3. Extract the name of 5th object
    @Test
    public void test003() {
        String userName = response.extract().path("[4].name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Name of 5th object is : " + userName);
        System.out.println("------------------End of Test---------------------------");
    }
    //4. Extract the names of all object whose status = inactive
    @Test
    public void test004() {
        List<String> inactiveNames =response.extract().path("findAll{it.status == 'inactive'}.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("All in-active status objects are : "+ inactiveNames);
        System.out.println("------------------End of Test---------------------------");
    }
    //5. Extract the gender of all the object whose status = active
    @Test
    public void test005() {
        List<String> activeGender =response.extract().path("findAll{it.status == 'active'}.gender");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("All active genders are : "+ activeGender);
        System.out.println("------------------End of Test---------------------------");
    }
    //6. Print the names of the object whose gender = female
    @Test
    public void test006() {
        List<String> femaleName =response.extract().path("findAll{it.gender == 'female'}.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("All the female gender names are : "+ femaleName);
        System.out.println("------------------End of Test---------------------------");
    }
    //7. Get all the emails of the object where status = inactive
    @Test
    public void test007() {
        List<String> inactiveEmails =response.extract().path("findAll{it.status == 'inactive'}.email");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("In-active emails are : "+ inactiveEmails);
        System.out.println("------------------End of Test---------------------------");
    }
    //8. Get the ids of the object where gender = male
    @Test
    public void test008() {
        List<Object> gendersIds =response.extract().path("findAll{it.gender == 'male'}.id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("All ids for gender = male : "+ gendersIds);
        System.out.println("------------------End of Test---------------------------");
    }
    //9. Get all the status
    @Test
    public void test009() {
        List<String> status = response.extract().path("status");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("All object's status are : " + status);
        System.out.println("------------------End of Test---------------------------");
    }
    //10. Get email of the object where name = Karthik Dubashi IV
    @Test
    public void test010() {
        List<String> email =response.extract().path("findAll{it.name == 'Bhishma Asan PhD'}.email");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Email of the object who's name = Bhishma Asan PhD : "+ email);
        System.out.println("------------------End of Test---------------------------");
    }
    //11. Get gender of id = 5471
    @Test
    public void test011() {
        List<String> gender =response.extract().path("findAll{it.id == 5223}.gender");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Gender of id = 5223 : "+ gender);
        System.out.println("------------------End of Test---------------------------");
    }
}

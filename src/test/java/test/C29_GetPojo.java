package test;

import baseUrl.DummyBaseUrl;
import io.restassured.internal.common.assertion.Assertion;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.PojoDummyData;
import pojos.PojoDummyExpectedBody;
import pojos.PojoHerokuappExpectedBody;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C29_GetPojo extends DummyBaseUrl {
    /*
    http://dummy.restapiexample.com/api/v1/employee/3 url’ine bir GET request
     gonderdigimizde donen response’un asagidaki gibi oldugunu test edin.
    Response Body
    {
    "status":"success",
    "data":{
            "id":3,
            "employee_name":"Ashton Cox",
            "employee_salary":86000,
            "employee_age":66,
            "profile_image":""
            },
    "message":"Successfully!Record has been fetched."
    }
     */
    @Test
    public void get01(){
        // 1 - url hazırla

        specDummy.pathParams("pp1","employee","pp2",3);

        // 2 - expected data hazırla

        PojoDummyData data = new PojoDummyData(3,"Ashton Cox",86000,66,"");

        PojoDummyExpectedBody expBody = new PojoDummyExpectedBody("success",data,"Successfully! Record has been fetched.");

        // 3 - Response'ı kaydet

        Response response =given().spec(specDummy).when().get("/{pp1}/{pp2}");


        // 4 - Assertion

        PojoDummyExpectedBody respPojo = response.as(PojoDummyExpectedBody.class);

        assertEquals(expBody.getStatus(),respPojo.getStatus());
        assertEquals(expBody.getMessage(),respPojo.getMessage());
        assertEquals(expBody.getData().getEmployee_name(),respPojo.getData().getEmployee_name());
        assertEquals(expBody.getData().getEmployee_salary(),respPojo.getData().getEmployee_salary());
        assertEquals(expBody.getData().getEmployee_age(),respPojo.getData().getEmployee_age());
        assertEquals(expBody.getData().getProfile_image(),respPojo.getData().getProfile_image());
        assertEquals(expBody.getData().getId(),respPojo.getData().getId());
    }
}

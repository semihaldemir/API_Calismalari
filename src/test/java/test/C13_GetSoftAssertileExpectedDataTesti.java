package test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class C13_GetSoftAssertileExpectedDataTesti {
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
        "message":"Successfully! Record has been fetched."
        }
        */
    @Test
    public void get01(){
        // 1 - Url hazırla
        String url = "http://dummy.restapiexample.com/api/v1/employee/3";

        // 2 - Expected Data hazırla
        JSONObject innerBody = new JSONObject();
        innerBody.put("id",3);
        innerBody.put("employee_name","Ashton Cox");
        innerBody.put("employee_salary",86000);
        innerBody.put("employee_age",66);
        innerBody.put("profile_image","");

        JSONObject expBody= new JSONObject();

        expBody.put("status","success");
        expBody.put("data",innerBody);
        expBody.put("message","Successfully! Record has been fetched.");

        // 3 - Response'i kaydet

        Response response = given().when().get(url);

        // 4 - Assertion

        JsonPath resjPath=response.jsonPath();

        SoftAssert softAssert=new SoftAssert();

        softAssert.assertEquals(resjPath.get("status"),expBody.get("status"));
        softAssert.assertEquals(resjPath.get("message"),expBody.get("message"));
        softAssert.assertEquals(resjPath.get("data.id"),expBody.getJSONObject("data").get("id"));
        softAssert.assertEquals(resjPath.get("data.employee_name"),expBody.getJSONObject("data").get("employee_name"));
        softAssert.assertEquals(resjPath.get("data.employee_salary"),expBody.getJSONObject("data").get("employee_salary"));
        softAssert.assertEquals(resjPath.get("data.employee_age"),expBody.getJSONObject("data").get("employee_age"));
        softAssert.assertEquals(resjPath.get("data.profile_image"),expBody.getJSONObject("data").get("profile_image"));

        softAssert.assertAll();

    }
}

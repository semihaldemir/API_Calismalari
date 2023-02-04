package test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class C14_Put_SoftAssertIleExpectedDataTesti {
    /*
    http://dummy.restapiexample.com/api/v1/update/21 url’ine asagidaki
    body’ye sahip bir PUT request gonderdigimizde donen response’un asagidaki gibi oldugunu test edin.

            Request Body
            {
                "status":"success",
                "data":{
                        "name":“Ahmet",
                        "salary":"1230",
                        "age":"44",
                        "id":40
                        }
            }

            Response Body

            {
            "status":"success",
            "data":{
                "status":"success",
                "data":{
                        "name":“Ahmet",
                        "salary":"1230",
                        "age":"44",
                        "id":40
                        }
                   },
            "message":"Successfully! Record has been updated."
            }
                 */
    @Test
    public void post01(){
    // 1 - Url ve body hazırla hazırla
    String url = "http://dummy.restapiexample.com/api/v1/update/21";




    // 1 - url ve body hazırla
    JSONObject innerBody = new JSONObject();
        innerBody.put("name","Ahmet");
        innerBody.put("salary","1230");
        innerBody.put("age","44");
        innerBody.put("id",40);

        JSONObject reqbody = new JSONObject();
        reqbody.put("status","success");
        reqbody.put("data",innerBody);

    // 2 - Expected Data hazırla
        JSONObject expData = new JSONObject();
        expData.put("status","success");
        expData.put("data",innerBody);
        expData.put("message","Successfully! Record has been updated.");

    // 3 - Response'i kaydet
        Response response=  given().
                                contentType(ContentType.JSON).
                            when().
                                body(reqbody.toString()).
                                post(url);

        response.prettyPrint();

    // 4 - Assertion

        JsonPath respJPath = response.jsonPath();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(respJPath.get("status"),expData.get("status"));
        softAssert.assertEquals(respJPath.get("message"),expData.get("message"));
        softAssert.assertEquals(respJPath.get("data.data.name"),expData.getJSONObject("data").getJSONObject("data").get("name"));
        softAssert.assertEquals(respJPath.get("data.data.salary"),expData.getJSONObject("data").getJSONObject("data").get("salary"));
        softAssert.assertEquals(respJPath.get("data.data.age"),expData.getJSONObject("data").getJSONObject("data").get("age"));
        softAssert.assertEquals(respJPath.get("data.data.age"),expData.getJSONObject("data").getJSONObject("data").get("age"));
        softAssert.assertEquals(respJPath.get("data.status"),expData.getJSONObject("data").get("status"));

        softAssert.assertAll();
    }
}

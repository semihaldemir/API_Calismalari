package test;

import baseUrl.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testData.TestDataJsonPlaceHolder;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C19_PutTestDataClassKullanimi extends JsonPlaceHolderBaseUrl {
    /*
    https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki body’e sahip bir PUT
    request yolladigimizda donen response’in
    status kodunun 200, content type’inin “application/json; charset=utf-8”,
    Connection header degerinin “keep-alive”
    ve response body’sinin asagida verilen ile ayni oldugunu test ediniz

    Request Body

        {
        "title":"Ali",
        "body":"Merhaba",
        "userId":10,
        "id":70
        }

    Expected Data

        {
        "title":"Ali",
        "body":"Merhaba",
        "userId":10,
        "id":70
        }
  */
    @Test
    public void put01(){
        // 1 - url ve body hazırla
        specJsonPlace.pathParams("pp1","posts","pp2",70);

        TestDataJsonPlaceHolder testDataJsonPlaceHolder =new TestDataJsonPlaceHolder();

        JSONObject reqBody = testDataJsonPlaceHolder.requestBodyOlusturJson();

        // 2 - expected data oluştur

        JSONObject expData = testDataJsonPlaceHolder.requestBodyOlusturJson();

        // 3 - response'ı kaydet

        Response response = given().
                                spec(specJsonPlace).
                                contentType(ContentType.JSON).
                            when().
                                body(reqBody.toString()).
                                put("/{pp1}/{pp2}");
        response.prettyPrint();

        // 4 - Assertion

        assertEquals(testDataJsonPlaceHolder.basariliStatusCode,response.getStatusCode());
        assertEquals(testDataJsonPlaceHolder.contentType,response.contentType());
        assertEquals(testDataJsonPlaceHolder.connectionHeader,response.getHeader("Connection"));

        JsonPath resJP = response.jsonPath(); // body'i test etmek için jsonpath'e ihtiyacımız var

        assertEquals(expData.get("title"),resJP.get("title"));
        assertEquals(expData.get("body"),resJP.get("body"));
        assertEquals(expData.get("userId"),resJP.get("userId"));
        assertEquals(expData.get("id"),resJP.get("id"));
    }

}

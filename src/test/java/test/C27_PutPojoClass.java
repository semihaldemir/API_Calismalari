package test;

import baseUrl.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.POJOJsonPlaceHolder;
import testData.TestDataJsonPlaceHolder;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class C27_PutPojoClass extends JsonPlaceHolderBaseUrl {
    /*
    C27_Put_PojoClass
 https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki
 body’e sahip bir PUT request yolladigimizda donen response’in
 response body’sinin asagida verilen ile ayni oldugunu test ediniz
     Request Body
    {
    "title":"Ahmet",
    "body":"Merhaba",
    "userId":10,
    "id":70
    }
    Expected Body
    {
    "title":"Ahmet",
    "body":"Merhaba",
    "userId":10,
    "id":70
    }
     */
    @Test
    public void put01(){
        // 1 - url ve body hazırla
        specJsonPlace.pathParams("pp1","posts","pp2",70);

       POJOJsonPlaceHolder reqBody = new POJOJsonPlaceHolder("Ahmet","Merhaba",10,70);

        System.out.println("reqbody: "+reqBody);

        // 2 - expected data hazırla

        POJOJsonPlaceHolder expData = new POJOJsonPlaceHolder("Ahmet","Merhaba",10,70);

        System.out.println("expData: "+expData);

        // 3 - Response'ı kaydet

        Response response = given().
                                spec(specJsonPlace).
                                contentType(ContentType.JSON).
                            when().
                                body(reqBody). // javaya ait bir obje olduğu için tostring'e gerek yok
                                put("/{pp1}/{pp2}");

        response.prettyPrint();

        // 4 - Assertion

        POJOJsonPlaceHolder respPOJO = response.as(POJOJsonPlaceHolder.class);

        Assert.assertEquals(expData.getBody(),respPOJO.getBody());
        Assert.assertEquals(expData.getId(),respPOJO.getId());
        Assert.assertEquals(expData.getUserId(),respPOJO.getUserId());
        Assert.assertEquals(expData.getBody(),respPOJO.getBody());
    }

}

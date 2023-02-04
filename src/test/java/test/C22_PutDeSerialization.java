package test;

import baseUrl.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import testData.TestDataJsonPlaceHolder;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static io.restassured.RestAssured.given;

public class C22_PutDeSerialization extends JsonPlaceHolderBaseUrl {
/*
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

    Expected Data :

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

        specJsonPlace.pathParams("pp1", "posts", "pp2",70);

                // şimdi tets datanın içine map oluşturuyoruz

        TestDataJsonPlaceHolder testDataJsonPlaceHolder = new TestDataJsonPlaceHolder();

        HashMap<String, Object> reqBody = testDataJsonPlaceHolder.requestBodyOlusturMap();

        // 2 - expected data hazırla

        HashMap<String,Object> expDataMap = testDataJsonPlaceHolder.requestBodyOlusturMap();

        // 3 - response'ı kaydet

        Response response = given().
                                spec(specJsonPlace).
                                contentType(ContentType.JSON).
                            when().
                                body(reqBody).      // reqBody.toString demiyoruz çünkü map javay ait bir yapı
                                put("/{pp1}/{pp2}");

        response.prettyPrint();
            // map göndersek te contenttype json olduğu için response json olarak gelir

        // 4 - Assertion

        // önceki uygulamalarda response'ı Jsonpath'e dönüştürüyorduk.
        // Ancak şimdi response'ı Hashmap'e dönüştürcez

        // Not : Bizim hazirlamis oldugumuz Expected Data Map formatinda.
        // Bize response'dan donen Response Body ise Json formatinda
        // Ikisini Assert methodlari icerisinde kiyaslayabilmemiz icin oncelikle
        // response'i map formatina parse etmemiz gerekiyor.


        HashMap<String,Object> resMap = response.as(HashMap.class);

        Assert.assertEquals(testDataJsonPlaceHolder.basariliStatusCode,response.getStatusCode());
                //direk response üzerinden temel bilgi olduğu için ulaşabiliyoruz
        Assert.assertEquals(expDataMap.get("title"),resMap.get("title"));
        Assert.assertEquals(expDataMap.get("id"),resMap.get("id"));
        Assert.assertEquals(expDataMap.get("body"),resMap.get("body"));
        Assert.assertEquals(expDataMap.get("userId"),resMap.get("userId"));

    }
}

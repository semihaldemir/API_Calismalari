package test;

import baseUrl.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import java.net.URL;

import static io.restassured.RestAssured.given;

public class C16_BaseUrlHerokuapp extends JsonPlaceHolderBaseUrl {
    /*
    Class icinde 21-  https://restful-booker.herokuapp.com/booking endpointine
    bir GET request gonderdigimizde donen
    response’un status code’unun 200 oldugunu ve
    Response’ta 12 booking oldugunu test edin
 Test metodu olusturun ve asagidaki testleri yapin

 2- https://restful-booker.herokuapp.com/booking
 endpointine asagidaki body’ye sahip bir POST request gonderdigimizde
 donen response’un status code’unun 200 oldugunu ve
 “firstname” degerinin “Ahmet” oldugunu test edin

 {    "firstname" : "Ahmet",
      "lastname" : “Bulut",
      "totalprice" : 500,
      "depositpaid" : false,
      "bookingdates" : {
                "checkin" : "2021-06-01",
                "checkout" : "2021-06-10"
       },
      "additionalneeds" : "wi-fi"
       }
     */
    @Test
    public void post01(){
        // 1 - url ve body oluştur kaydet
        specJsonPlace.pathParam("pp1","booking");

        JSONObject innerJsonBody = new JSONObject();

        innerJsonBody.put("checkin","2021-06-01");
        innerJsonBody.put("checkout","2021-06-10");

        JSONObject reqBody = new JSONObject();

        reqBody.put("firstname","Ahmet");
        reqBody.put("lastname","Bulut");
        reqBody.put("totalprice",500);
        reqBody.put("depositpaid",false);
        reqBody.put("bookingdates",innerJsonBody);
        reqBody.put("additionalneeds","wi-fi");

        // 2 - expected datayı oluştur

        // 3 - response'ı kaydet

        Response response = given().
                                    spec(specJsonPlace).
                                    contentType(ContentType.JSON).
                            when().
                                    post("/{pp1}");

        response.prettyPrint();

        // 4 -Assertion




    }
}

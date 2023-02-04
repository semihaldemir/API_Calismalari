package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C04_PutResponseBilgileriAssertion {
    /*
        https://jsonplaceholder.typicode.com/posts/70 url’ine asagidaki
        Json formatindaki body ile bir PUT request gonderdigimizde
                {
                "title":"Ahmet",
                "body":"Merhaba",
                "userId":10,
                "id":70
                }
        donen Response’un,

            status code’unun 200,
            ve content type’inin application/json; charset=utf-8,
            ve Server isimli Header’in degerinin cloudflare,
            ve status Line’in HTTP/1.1 200 OK
      */

    @Test
    public void put01(){
        // 1 - REquest Url ve Body hazırla
           // ** 3P için body gerekiyordu

        String url = "https://jsonplaceholder.typicode.com/posts/70";

        JSONObject reqBody= new JSONObject();
        reqBody.put("title","Ahmet");
        reqBody.put("body","Merhaba");
        reqBody.put("userId",10);
        reqBody.put("id",70);

        System.out.println(reqBody);

        // 2 - Soruda istendiyse expected data hazırla
            // ** istenmemiş

        // 3 - Response'ı kaydet


        Response response = given().
                contentType(ContentType.JSON).    //body'i hangi formatta göndereceğimizi önce tanımlıyoruz
                when().body(reqBody.toString()).  // body json objesi olarak olarak hazırlanıyorsa toString ile gönd gerekir
                put(url);

        response.prettyPrint();

        // 4 - Assertion
/*
        status code’unun 200,
                ve content type’inin application/json; charset=utf-8,
                ve Server isimli Header’in degerinin cloudflare,
                ve status Line’in HTTP/1.1 200 OK
  */
        response.
                then().
                assertThat().
                statusCode(200).
                contentType("application/json; charset=utf-8").
                header("Server","cloudflare").
                statusLine("HTTP/1.1 200 OK");



    }
}

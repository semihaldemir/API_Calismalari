package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C05_GetResponseBodyTesti {
/*
    https://jsonplaceholder.typicode.com/posts/44 url'ine bir GET request yolladigimizda
    donen Response'in
         status code'unun 200,
         ve content type'inin ContentType.JSON,
         ve response body'sinde bulunan userId'nin 5,
         ve response body'sinde bulunan title'in "optio dolor molestias sit"
         oldugunu test edin.
     */
    @Test
    public void get01(){
        // 1 - Url hazırla
        String url = "https://jsonplaceholder.typicode.com/posts/44";

        // 2- Soruda isteniyorsa expected data hazırla
                // istenmiyor

        // 3- Response'ı kaydet

        Response response = given().when().get(url);

        response.prettyPrint();

        // 4- Assertion

        response.
                then().
                assertThat().
                statusCode(200).    //status code'unun 200,
                contentType(ContentType.JSON).  //content type'inin ContentType.JSON,
                body("userId",Matchers.equalTo(5)).     //response body'sinde bulunan userId'nin 5,
                body("title",Matchers.equalTo("optio dolor molestias sit"));    //response body'sinde bulunan title'in "optio dolor molestias sit"
    }
}

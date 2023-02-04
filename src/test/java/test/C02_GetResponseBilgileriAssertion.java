package test;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C02_GetResponseBilgileriAssertion {
    /*
        https://restful-booker.herokuapp.com/booking/10 url’ine bir GET request
        gonderdigimizde donen Response’un,
        status code’unun 200,
        ve content type’inin application/json; charset=utf-8,
        ve Server isimli Header’in degerinin Cowboy,
        ve status Line’in HTTP/1.1 200 OK
        oldugunu test edin.
         */
    @Test
    public void get01(){
        // 1 - gerekli olan URL ve Body'i hazırla

        String url = "https://restful-booker.herokuapp.com/booking/69";

        // 2 - Soruda isteniyorsa Expected Data hazırla

        // 3 - Donen Response'ı kaydet

        Response response = given().when().get(url);

        //response.prettyPrint(); -> normalde run ederken yazdırılmaz, ağır gelen bir koddur

        // 4 - Assertion

        response.
                then().
                assertThat().
                statusCode(200).  //**status code’unun 200,
                contentType("application/json; charset=utf-8"). //**content type’inin application/json; charset=utf-8,
                header("Server","Cowboy") //**Server isimli Header’in degerinin Cowboy,
                .statusLine("HTTP/1.1 200 OK"); //**status Line’in HTTP/1.1 200 OK
    }
}

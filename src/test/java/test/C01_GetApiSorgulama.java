package test;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C01_GetApiSorgulama {
    /*
        https://restful-booker.herokuapp.com/booking/256884 url’ine
        bir GET request gonderdigimizde donen Response’un,
        status code’unun 200,
        ve content type’inin application/json; charset=utf-8,
        ve Server isimli Header’in degerinin Cowboy,
        ve status Line’in HTTP/1.1 200 OK
        ve response suresinin 5 sn’den kisa oldugunu manuel olarak test ediniz.
         */
    @Test
    public void get01(){
        // 1 - Gonderecegimiz Request icin gerekli olan URL ve ihtiyacimiz varsa Body hazirla

        String url="https://restful-booker.herokuapp.com/booking/275";

        // 2 - Eger soruda bize verilmisse Expected Data hazirla

        // 3 - Bize donen Response'i Actual Data olarak kaydet

        Response response = given().when().get(url);
        response.prettyPrint();

        // 4 - Expected Data ile Actual datanin karsilastirmasi - Assertion

        System.out.println("status code: "+response.statusCode());
        System.out.println("content type: "+response.contentType());
        System.out.println("erver Header'ın Değeri: "+response.getHeader("Server"));
        System.out.println("status line: "+response.getStatusLine());
        System.out.println("Responce Suresi: "+response.getTime());

    }
}

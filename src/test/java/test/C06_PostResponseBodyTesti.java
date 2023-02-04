package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C06_PostResponseBodyTesti {
    /*  https://jsonplaceholder.typicode.com/posts
         url’ine asagidaki body ile bir POST request gonderdigimizde
        {
        "title":"API",
        "body":"API ogrenmek ne guzel",
        "userId":10,
        }
        donen Response’un,
        status code’unun 201,
        ve content type’inin application/json
        ve Response Body'sindeki,
        "title"'in "API" oldugunu
        "userId" degerinin 100'den kucuk oldugunu
        "body" nin "API" kelimesi icerdigini
        test edin.
      */
    @Test
    public void post01(){
       // 1- Url ve Body hazırla

        String url = "https://jsonplaceholder.typicode.com/posts";

        JSONObject reqBody = new JSONObject();

        reqBody.put("title","API");
        reqBody.put("body","API ogrenmek ne guzel");
        reqBody.put("userId",10);

        //System.out.println(reqBody);

        // 2 - Expected data hazırla

        // 3 - Response'ı kaydet

        Response response = given(). // post'ta body göndermemiz gerekiyor. body gönderirken de data formatını söylememiz gerekiyor
                                    contentType(ContentType.JSON).
                            when().
                                    body(reqBody.toString()). // json olduğu için toStringle gönderiyoruz
                                    post(url);

        //response.prettyPrint(); --> Yazdırma komutları ağır olduğu için genelde yazdırılmaz

        // 4 - Assertion

        response.
                then().assertThat().
                statusCode(201).
                contentType("application/json").
                body("title", equalTo("API")).
                body("userId", lessThan(100)).
                body("body",Matchers.containsString("API"));


    }
    @Test
    public void post02(){
        // 1- Url ve Body hazırla

        String url = "https://jsonplaceholder.typicode.com/posts";

        JSONObject reqBody = new JSONObject();

        reqBody.put("title","API");
        reqBody.put("body","API ogrenmek ne guzel");
        reqBody.put("userId",10);

        System.out.println(reqBody);

        // 2 - Expected data hazırla

        // 3 - Response'ı kaydet

        Response response = given(). // post'ta body göndermemiz gerekiyor. body gönderirken de data formatını söylememiz gerekiyor
                contentType(ContentType.JSON).
                when().
                body(reqBody.toString()). // json olduğu için toStringle gönderiyoruz
                        post(url);

        //response.prettyPrint(); --> Yazdırma komutları ağır olduğu için genelde yazdırılmaz

        // 4 - Assertion

        response.
                then().assertThat().
                statusCode(201).
                contentType("application/json").
                body("title", equalTo("API"),
                "userId",lessThan(100),
                "body",containsString("API"));

        // burada her seferinde tek tek body koymak yerine body() leri kaldırdık araya virgul koyduk
        // Matchers.containsString gibi method kullanmak yerine Matchers. kısmını siliyoruz
        // import kısmına "import static org.hamcrest.Matchers.*;" yazıyoruz
        // O zaman diğer bütün Matchers clasından metodları kabul eder.


    }

}

package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.mapper.ObjectMapper;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.specification.RedirectSpecification;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

import java.io.File;
import java.io.InputStream;
import java.security.KeyStore;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class DummyBaseUrl {
    protected RequestSpecification specDummy;

    @Before
    public void setUp() {
        specDummy = new RequestSpecBuilder().setBaseUri("http://dummy.restapiexample.com/api/v1").build();
    }



}

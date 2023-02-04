package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

import javax.print.DocFlavor;

public class JsonPlaceHolderBaseUrl {

    protected RequestSpecification specJsonPlace;

    @Before
    public void setUp(){

        specJsonPlace = new RequestSpecBuilder().
                        setBaseUri("https://jsonplaceholder.typicode.com").
                        build();

    }
}
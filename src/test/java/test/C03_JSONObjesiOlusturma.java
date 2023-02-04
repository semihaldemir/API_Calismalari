package test;

import org.json.JSONObject;
import org.junit.Test;

public class C03_JSONObjesiOlusturma {
/*
    Asagidaki JSON Objesini olusturup konsolda yazdirin.

    {
        "title":"Ahmet",
        "body":"Merhaba",
        "userId":1
    }
    */
    @Test
    public void jsonObje01(){

        JSONObject ilkJsonObject=new JSONObject();

        ilkJsonObject.put("title","Ahmet");
        ilkJsonObject.put("body","Merhaba");
        ilkJsonObject.put("userId",1);

        System.out.println(ilkJsonObject);
    }

    @Test
    public void JsonObje02(){
        /*
                {
                 "firstname":"Jim",
                 "additionalneeds":"Breakfast",
                 "bookingdates":{
                         "checkin":"2018-01-01",
                         "checkout":"2019-01-01"
                    },
                  "totalprice":111,
                  "depositpaid":true,
                  "lastname":"Brown"
                  }
         */

        JSONObject innerJsonObject=new JSONObject();

        innerJsonObject.put("checkin","2018-01-01");
        innerJsonObject.put("checkout","2019-01-01");

        JSONObject body = new JSONObject();

        body.put("firstname","Jim");
        body.put("additionalneeds","Breakfast");
        body.put("bookingdates",innerJsonObject);
        body.put("totalprice",111);
        body.put("depositpaid",true);
        body.put("lastname","Brown");

        System.out.println(body);




    }
}

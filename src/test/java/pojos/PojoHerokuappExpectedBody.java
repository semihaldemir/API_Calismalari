package pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // getter setter oluşturur
@NoArgsConstructor // parametresiz constructor oluşturur
@AllArgsConstructor// parametreli cons. oluşturur
public class PojoHerokuappExpectedBody {
    /*
    {
                        "firstname":"Ahmet",
                        "lastname":"Bulut",
                        "totalprice":500,
                        "depositpaid":false,
                        "bookingdates":{
                            "checkin":"2021-06-01",
                            "checkout":"2021-06-10"
                                        }
                        ,
                        "additionalneeds":"wi-fi"
                              }
     */
    private int bookingId;
    private PojoHerokiappBooking booking;


}

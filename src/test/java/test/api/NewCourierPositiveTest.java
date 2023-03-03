package test.api;

import com.client.CourierCustomer;
import com.model.Courier;
import com.model.RandomCourier;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;

public class NewCourierPositiveTest {
    CourierCustomer courierCustomer = new CourierCustomer();
    Courier courier = new RandomCourier();

    @Test
    @DisplayName("request returns correct status code")
    public void checkNewCourierStatusCode() {
        ValidatableResponse validatableResponse = courierCustomer.newCourier(courier)
                .then().assertThat().statusCode(201)
                .body("ok", equalTo(true));
    }

    @After
    public void deleteCourier() {
        courierCustomer.deleteCourier(courier);
    }
}

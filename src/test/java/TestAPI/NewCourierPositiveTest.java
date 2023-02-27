package TestAPI;

import API.Client.CourierCustomer;
import API.Model.Courier;
import API.Model.RandomCourier;
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
                .then().assertThat().statusCode(201);
    }

    @Test
    @DisplayName("successful request returns ok: true;")
    public void checkNewCourierSuccessTrue() {
        courierCustomer.newCourier(courier)
                .then().assertThat().body("ok", equalTo(true));
    }

    @After
    public void deleteCourier() {
        courierCustomer.deleteCourier(courier);
    }
}

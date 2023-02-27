package TestAPI;

import API.Client.CourierCustomer;
import API.Model.Courier;
import API.Model.RandomCourier;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;

public class NewCourierNegativeTest {
    String randomLogin = RandomStringUtils.random(10, true, false);
    String randomPass = RandomStringUtils.random(10, true, true);
    String randomName = RandomStringUtils.random(10, true, false);
    CourierCustomer courierCustomer = new CourierCustomer();
    Courier courier = new RandomCourier();

    @Test
    @DisplayName("No Login, the request returns 400 status code and the request returns an error message")
    public void checkNewCourierWithoutLoginResponseBody() {
        courier = new Courier("", randomPass, randomName);
        courierCustomer.newCourier(courier)
                .then().assertThat().statusCode(400)
                .body("message", equalTo("Недостаточно данных для создания учетной записи"));
    }

    @Test
    @DisplayName("No Password, the request returns 400 status code and the request returns an error message")
    public void checkNewCourierWithoutPassword() {
        courier = new Courier(randomLogin, "", randomName);
        courierCustomer.newCourier(courier)
                .then().assertThat().statusCode(400)
                .body("message", equalTo("Недостаточно данных для создания учетной записи"));
    }

    @Test
    @DisplayName("Creation of two couriers with equal login. Expect status code 409.")
    public void checkNewCourierWithSameCredentialsResponseBody() {
        courierCustomer.newCourier(courier);
        courierCustomer.newCourier(courier)
                .then().assertThat().statusCode(409)
                .body("message", equalTo("Этот логин уже используется. Попробуйте другой."));
    }

    @After
    public void deleteCourier() {
        courierCustomer.deleteCourier(courier);
    }
}

package test.api;

import com.client.CourierCustomer;
import com.model.Courier;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.notNullValue;

public class LoginCourierPositiveTest {
    String randomLogin = RandomStringUtils.random(10, true, false);
    String randomPass = RandomStringUtils.random(10, true, true);
    String randomName = RandomStringUtils.random(10, true, false);
    CourierCustomer courierCustomer = new CourierCustomer();
    Courier courier = new Courier(randomLogin, randomPass, randomName);

    @Test
    @DisplayName("successful request returns id")
    public void checkLoginCourierSuccessReturnId() {
        courierCustomer.newCourier(courier);
        courierCustomer.loginCourier(courier)
                .then().assertThat().body("id", notNullValue());
    }

    @After
    public void deleteCourier() {
        courierCustomer.deleteCourier(courier);
    }
}

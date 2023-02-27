package TestAPI;

import API.Client.OrderCustomer;
import API.Model.Order;
import API.Model.RandomOrder;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.notNullValue;

public class NewOrdersPositiveTest {
    OrderCustomer orderCustomer = new OrderCustomer();
    Order order = new RandomOrder(null);

    @Test
    public void newOrder() {
        orderCustomer.newOrder(order)
                .then().assertThat().statusCode(201)
                .and()
                .body("track", notNullValue());
    }
}

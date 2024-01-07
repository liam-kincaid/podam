package uk.co.jemos.podam.test.unit.steps;

import static org.apache.commons.lang3.StringUtils.isNoneBlank;
import static org.apache.commons.lang3.StringUtils.isNotEmpty;
import static org.junit.jupiter.api.Assertions.*;

import net.serenitybdd.annotations.Step;
import uk.co.jemos.podam.test.dto.docs.example.Address;
import uk.co.jemos.podam.test.dto.docs.example.Article;
import uk.co.jemos.podam.test.dto.docs.example.BankAccount;
import uk.co.jemos.podam.test.dto.docs.example.Client;
import uk.co.jemos.podam.test.dto.docs.example.Country;
import uk.co.jemos.podam.test.dto.docs.example.Order;
import uk.co.jemos.podam.test.dto.docs.example.OrderItem;

import java.util.Calendar;
import java.util.List;

/**
 * Created by tedonema on 21/06/2015.
 */
public class WalkThroughSteps {


    @Step("Then the BankAccount POJO should be correctly filled")
    public void theBankAccountPojoShouldBeCorrectlyFilled(BankAccount pojo) {

        assertNotNull(pojo, "The bank account cannot be null!");

        assertNotEquals(0, pojo.getAccount(), "The bank account cannot be zero!");
        assertNotEquals(0.0D, pojo.getBalance(), "The account balance cannot be zero!");
        assertTrue(isNotEmpty(pojo.getBank()), "The bank name cannot be empty!");
        assertTrue(isNotEmpty(pojo.getSortCode()), "The sort code cannot be empty!");
    }

    @Step("Then the Address POJO should be correctly filled")
    public void theAddressPojoShouldBeCorrectlyFilled(Address pojo) {

        assertNotNull(pojo, "The address cannot be null!");
        assertNotNull(pojo.getAddress1(), "The address1 cannot be null!");
        assertNotNull(pojo.getAddress2(), "The address2 cannot be null!");
        assertNotNull(pojo.getCity(), "The city cannot be null!");
        assertNotNull(pojo.getZipCode(), "The zipCode cannot be null!");

        theCountryPojoShouldBeCorrectlyFilled(pojo.getCountry());
    }


    @Step("Then the Order POJO should be correctly filled")
    public void theOrderPojoShouldBeCorrectlyFilled(Order pojo) {

        assertNotNull(pojo, "The pojo cannot be null!");

        assertNotEquals(0, pojo.getId(), "The order id must not be zero!");

        Calendar createDate = pojo.getCreateDate();
        assertNotNull(createDate, "The create date must not be null!");

        assertNotEquals(0.0D, pojo.getTotalAmount(), "The order total amount must not be zero!");

        List<OrderItem> orderItems = pojo.getOrderItems();
        assertNotNull(orderItems, "The order items must not be null!");
        assertFalse(orderItems.isEmpty(), "The order items must not be empty!");

        int expectedNbrElements = 5;

        assertEquals(orderItems.size(), expectedNbrElements, "The expected number of elements " + expectedNbrElements + " does not match the actual number: " + orderItems.size());

        for (OrderItem orderItem : orderItems) {

            theOrderItemPojoShouldBeCorrectlyFilled(orderItem);
        }
    }


    @Step("Then the OrderItem POJO should be correctly filled")
    public void theOrderItemPojoShouldBeCorrectlyFilled(OrderItem pojo) {

        assertNotNull(pojo, "The pojo cannot be null!");
        assertNotEquals(0, pojo.getId(), "The order item id cannot be zero!");
        assertNotEquals(0.0D, pojo.getLineAmount(), "The order item line amount cannot be zero!");
        assertNull(pojo.getNote(), "The Order Item note must be null because of @PodamExclude annotation");

        theArticlePojoShouldBeCorrectlyFilled(pojo.getArticle());
    }

    @Step("Then the Article POJO should be correctly filled")
    public void theArticlePojoShouldBeCorrectlyFilled(Article pojo) {
        assertNotNull(pojo, "The pojo cannot be null!");

        int expectedMaxValue = 100000;

        assertTrue(pojo.getId() <= expectedMaxValue, "The article id max value must not exceed ");

        assertNotNull(pojo.getItemCost(), "The item cost cannot be null!");
        assertNotEquals(0.0D, pojo.getItemCost(), "The item cost must have a value different from zero!");

        assertNotNull(pojo.getDescription(), "The article description cannot be null!");
    }

    @Step("Then the Country POJO should be correctly filled")
    public void theCountryPojoShouldBeCorrectlyFilled(Country pojo) {
        assertNotNull(pojo, "The pojo cannot be null!");

        String countryCode = pojo.getCountryCode();
        assertNotNull(countryCode, "The country Code cannot be null!");
        int countryCodeLength = 2;
        assertEquals( countryCode.length(), countryCodeLength, "The length of the country code must be " + countryCodeLength + "! but was " + countryCode.length());
        assertNotEquals(0, pojo.getCountryId(), "country id must be different from zero!");
        assertTrue(isNoneBlank(pojo.getDescription()), "The country description must not be empty!");
    }

    @Step("Then the Client POJO should be correctly filled")
    public void theClientPojoShouldBeCorrectlyFilled(Client pojo) {
        assertNotNull(pojo, "The pojo cannot be null!");

        assertTrue(isNoneBlank(pojo.getFirstName()), "The client's first name cannot be empty!");

        String expectedFirstName = "Michael";
        assertEquals(expectedFirstName, pojo.getFirstName(), "The client's first name is not ");

        assertTrue(isNoneBlank(pojo.getLastName()), "The client's last name cannot be empty!");

        assertNotNull(pojo.getDateCreated(), "The date created cannot be null!");

        List<Order> orders = pojo.getOrders();
        assertNotNull(orders, "The orders cannot be null!");
        int expectedOrdersNbr = 3;
        assertEquals(orders.size(), expectedOrdersNbr, "The expected number of orders is " + expectedOrdersNbr);

        for (Order order : orders) {
            theOrderPojoShouldBeCorrectlyFilled(order);
        }

        List<Address> addresses = pojo.getAddresses();
        assertNotNull(addresses, "The addresses cannot be null!");
        int expectedAddressesNbr = 2;
        assertEquals(addresses.size(), expectedAddressesNbr, "The expected number of addresses is " + expectedAddressesNbr);

        for (Address address : addresses) {
            theAddressPojoShouldBeCorrectlyFilled(address);
        }

        List<BankAccount> bankAccounts = pojo.getBankAccounts();

        for (BankAccount bankAccount : bankAccounts) {
            theBankAccountPojoShouldBeCorrectlyFilled(bankAccount);
        }
    }
}

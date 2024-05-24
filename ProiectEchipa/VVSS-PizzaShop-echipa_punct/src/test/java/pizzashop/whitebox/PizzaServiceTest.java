package pizzashop.whitebox;

import org.junit.jupiter.api.Test;
import pizzashop.model.Payment;
import pizzashop.model.PaymentType;
import pizzashop.service.PizzaService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PizzaServiceTest {

    private final PizzaService service = new PizzaService(null, null);

    @Test
    void getTotalAmountPaymentTypeEqualTest() {
        PaymentType paymentType = PaymentType.Card;
        Payment payment = new Payment(1, paymentType, 100.0f);
        List<Payment> paymentList = new ArrayList<>();

        paymentList.add(payment);

        double result = service.getTotalAmount(paymentList, paymentType);

        assertEquals(100.0f, result);
    }

    @Test
    void getTotalAmountPaymentTypeNotEqualTest() {
        PaymentType paymentType = PaymentType.Card;
        Payment payment = new Payment(1, paymentType, 100.0f);
        List<Payment> paymentList = new ArrayList<>();

        paymentList.add(payment);

        double result = service.getTotalAmount(paymentList, PaymentType.Cash);

        assertEquals(0.0f, result);
    }

    @Test
    void getTotalAmountEmptyListTest() {
        PaymentType paymentType = PaymentType.Card;
        List<Payment> paymentList = new ArrayList<>();

        double result = service.getTotalAmount(paymentList, paymentType);

        assertEquals(0.0f, result);
    }

    @Test
    void getTotalAmountNullListTest() {
        PaymentType paymentType = PaymentType.Card;

        double result = service.getTotalAmount(null, paymentType);

        assertEquals(0.0f, result);
    }

    @Test
    void getTotalAmountPaymentTypeNotAlwaysEqualTest() {
        PaymentType paymentType = PaymentType.Card;
        Payment payment1 = new Payment(1, PaymentType.Card, 100.0f);
        Payment payment2 = new Payment(1, PaymentType.Cash, 100.0f);
        List<Payment> paymentList = new ArrayList<>();

        paymentList.add(payment1);
        paymentList.add(payment2);

        double result = service.getTotalAmount(paymentList, paymentType);

        assertEquals(100.0f, result);
    }
}

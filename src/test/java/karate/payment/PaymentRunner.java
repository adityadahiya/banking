package karate.payment;

import com.intuit.karate.junit5.Karate;

public class PaymentRunner {
    @Karate.Test
    Karate testAll() {
        return Karate.run().relativeTo(getClass());
}
}
package karate.account;

import com.intuit.karate.junit5.Karate;

public class AccountRunner {
    @Karate.Test
    Karate testAll() {
        return Karate.run().relativeTo(getClass());
}
}
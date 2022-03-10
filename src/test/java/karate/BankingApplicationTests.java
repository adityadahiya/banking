package karate;

import com.intuit.karate.junit5.Karate;
import com.intuit.karate.junit5.Karate.Test;
//import org.junit.Test;

//import com.intuit.karate;


class BankingApplicationTests {

	@Karate.Test
	Karate testAll() {
        return Karate.run().relativeTo(getClass());
    }

}


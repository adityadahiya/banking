package com.lloyds.banking;

import com.intuit.karate.junit5.Karate;
import com.intuit.karate.junit5.Karate.Test;
//import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//import com.intuit.karate;


class BankingApplicationTests {

	@Karate.Test
	Karate testAll() {
        return Karate.run().relativeTo(getClass());
    }

}
// @RunWith(SpringRunner.class)
// @SpringBootTest
// public class BankingApplicationTests {

// 	@Test
// 	public void contextLoads() throws Exception  {
// 	}

// }

package com.affleck.Affleck;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AffleckApplicationTests {

	@Test
	public void contextLoads() {
		Map<String, String> map = new HashMap<>();
		System.out.print("aaaaaaaaaaa"+(1<<30));
	}

}

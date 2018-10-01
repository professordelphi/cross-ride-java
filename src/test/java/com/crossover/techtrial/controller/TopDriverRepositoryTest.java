/**
 * 
 */
package com.crossover.techtrial.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.crossover.techtrial.dto.TopDriverDTO;


/**
 * @author Marcos Amaral 29-09-2018
 *
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class TopDriverRepositoryTest {
	
	TopDriverDTO topDriverDTO =new TopDriverDTO();

	
	@Before
	public void setUp() throws Exception
	{
		
		
		topDriverDTO.setAverageDistance(5.0);
		topDriverDTO.setEmail("august@ig.com");
		topDriverDTO.setMaxRideDurationInSecods((30l*60l*60l));
		topDriverDTO.setName("August");
		topDriverDTO.setTotalRideDurationInSeconds(32000l);
		
				
	}
	
	
	
	@Test
	public void testNameDrivers()
	{
		String name="August";
		assertEquals(name, topDriverDTO.getName());
	}
	
	

}

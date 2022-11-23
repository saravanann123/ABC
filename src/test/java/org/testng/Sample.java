package org.testng;

import java.util.Date;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Sample {

	@BeforeClass

	public void before() {
		System.out.println("browse launch");
	}

	@AfterClass
 
	public void after() {
		System.out.println("quit");
	}

	@BeforeMethod void beforetime() {

		Date d = new Date();
		System.out.println("starting time " + d);

	}

	@AfterMethod
	public void enddate() {
		Date d = new Date();
		System.out.println(" ending time" + d);
	}

	@Test

	public void tc1() {

		System.out.println(" test 1 ");
	}

	@Test
	public void tc2() {
		System.out.println(" test 2 ");
	}
	@Test
	public void tc3() {
		System.out.println("test 3 ");
	}
}

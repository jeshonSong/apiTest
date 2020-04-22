package com.song.apitest.bean;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public abstract class ApiTestTemplate {

	public abstract void setup();
	public abstract void run();
	public abstract void teardown();
	
	@Test
	public void test() {
		run();
	}

	@BeforeMethod
	public void beforeMethod() {
		setup();
	}

	@AfterMethod
	public void afterMethod() {
		teardown();
	}

	@BeforeClass
	public void beforeClass() {

	}

	@AfterClass
	public void afterClass() {

	}

}

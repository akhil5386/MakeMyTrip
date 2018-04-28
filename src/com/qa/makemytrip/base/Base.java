package com.qa.makemytrip.base;

import org.testng.SkipException;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Base {

	String testCase;
	String username;
	String password;
	
	@BeforeSuite
	public void initObj() {
		testCase = System.getProperty("TestCase");
		username=System.getProperty("UserName");
		password=System.getProperty("Password");
	}

	@Test(priority = 1)
	public void test1() {
		if (testCase.contains("Test1")) {
			System.out.println("Test Case 1");
		} else {
			throw new SkipException("Test Case is skipped");
		}
	}

	@Test(priority = 2)
	public void test2() {
		if (testCase.contains("Test2")) {
			System.out.println("Test Case 2");
		} else {
			throw new SkipException("Test Case is skipped");
		}
	}

	@Test(priority = 3)
	public void test3() {
		if (testCase.contains("Test3")) {
			System.out.println(username);
		} else {
			throw new SkipException("Test Case is skipped");
		}
	}

	@Test(priority = 4)
	public void test4() {
		if (testCase.contains("Test4")) {
			System.out.println(password);
		} else {
			throw new SkipException("Test Case is skipped");
		}
	}

	@Test(priority = 5)
	public void test5() {
		if (testCase.contains("Test5")) {
			System.out.println("Test Case 5");
		} else {
			throw new SkipException("Test Case is skipped");
		}
	}

	@Test(priority = 6)
	public void test6() {
		if (testCase.contains("Test6")) {
			System.out.println("Test Case 6");
		} else {
			throw new SkipException("Test Case is skipped");
		}
	}

}

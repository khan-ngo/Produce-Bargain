package com.jdbUseCaseWebAppProject.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	UserServiceParameterizedTest.class,
	UserServiceTest.class,
	ProductServiceParameterizedTest.class,
	ProductServiceTest.class

})
public class AllTests {

}




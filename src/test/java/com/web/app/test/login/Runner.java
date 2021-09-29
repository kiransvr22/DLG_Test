package com.web.app.test.login;

import io.cucumber.testng.AbstractTestNGCucumberTests;

@io.cucumber.testng.CucumberOptions(features = "src/test/java/features/login.feature", glue = {"com/web/app/test/login"})
public class Runner extends AbstractTestNGCucumberTests{
}

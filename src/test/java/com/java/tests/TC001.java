package com.java.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.java.allure.BaseClass;

import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

public class TC001 extends BaseClass{
	
	@Story("Enter Username In The Field")
	@Epic("Testing Login Function")
	@Test(priority=0, description="Setting Username")
	public void TC1() {
		driver.get("https://demo.guru99.com/v4/");
		driver.findElement(By.cssSelector("[name='uid']")).clear();
		driver.findElement(By.cssSelector("[name='uid']")).sendKeys("mngr177126");
		
	}
	
	@Description("Entering Password In The Field")
	@Test(priority=1, description="Setting Password")
	public void TC2() {
		
		driver.findElement(By.cssSelector("[name='password']")).clear();
		driver.findElement(By.cssSelector("[name='password']")).sendKeys("haqEjYv");
		
	}
	
	@Severity(SeverityLevel.BLOCKER)
	@Description("Clicking On Submit Button")
	@Test(priority=2, description="Clicking On Submit Button")
	public void TC3() {

	driver.findElement(By.cssSelector("[name='btnLogin']")).click();
	
	}
	
	@Step("Verify Login Into The Page")
	@Test(priority=3)
	@Attachment
	public String verifyLogin() {
		
		String UserId = driver.findElement(By.cssSelector("td[style='color: green']")).getText();
		Assert.assertEquals(UserId, "Manger Id : mngr177126");
		return UserId;
	}
}

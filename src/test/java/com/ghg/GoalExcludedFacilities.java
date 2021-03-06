/*
Author name - Arun Patel
*/

package com.ghg;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GoalExcludedFacilities extends TestBase {
	
	public GoalExcludedFacilities(){
		super();
	}
	
	WebElement e;
	@BeforeMethod
	public void setUp() throws InterruptedException{
		initialization();
driver.findElement(By.xpath("//a[normalize-space()='OK']")).click();
		
		WebElement e=driver.findElement(By.xpath("//span[@id='mainContentPlaceHolder_GridLeft_lblGroupName2_0']"));
		Thread.sleep(2000);
		e = driver.findElement(By.xpath("//span[@id='mainContentPlaceHolder_GridLeft_lblGroupName2_3']"));
		ScrollWindow.scrollIntoView(e, driver);
				e.click();
		Thread.sleep(2000);	
	}

	@Test(priority = 1, groups = "Goal Excluded Facilities C1-C4")
	public void ReportC1() throws InterruptedException {

		driver.findElement(By.xpath("//a[contains(text(),'C-1')]")).click();
		Thread.sleep(2000);
		WebElement C1 = driver.findElement(By.xpath("//span[normalize-space()='Report Filter/Options']"));
		Assert.assertTrue(C1.isDisplayed());
		Thread.sleep(2000);
	}

	@Test(priority = 2, groups = "Goal Excluded Facilities C1-C4")
	public void ReportC2() throws InterruptedException {

		driver.findElement(By.xpath("//a[contains(text(),'C-2')]")).click();
		Thread.sleep(2000);
		WebElement C2 = driver.findElement(By.xpath("//span[normalize-space()='Report Filter/Options']"));
		Assert.assertTrue(C2.isDisplayed());
		Thread.sleep(2000);
	}

	@Test(priority = 3, groups = "Goal Excluded Facilities C1-C4")
	public void ReportC3() throws InterruptedException {

		driver.findElement(By.xpath("//a[contains(text(),'C-3')]")).click();
		Thread.sleep(2000);
		WebElement C3 = driver.findElement(By.xpath("//span[normalize-space()='Report Filter/Options']"));
		Assert.assertTrue(C3.isDisplayed());
		Thread.sleep(2000);
	}

	@Test(priority = 4, groups = "Goal Excluded Facilities C1-C4")
	public void ReportC4() throws InterruptedException {

		driver.findElement(By.xpath("//a[contains(text(),'C-4')]")).click();
		Thread.sleep(2000);
		WebElement C4 = driver.findElement(By.xpath("//span[normalize-space()='Report Filter/Options']"));
		Assert.assertTrue(C4.isDisplayed());
		Thread.sleep(2000);
	}

	
	@AfterMethod
	public void teardown() {
		
		driver.close();
	}

}

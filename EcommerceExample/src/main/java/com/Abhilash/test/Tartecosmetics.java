package com.Abhilash.test;

import java.awt.AWTException;
import java.awt.Event;
import java.awt.Robot;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Tartecosmetics {

	WebDriver driver;

	@BeforeSuite
	public void LaunchBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\HP\\eclipse-workspace\\UnicodeTestMachineAutomation\\src\\main\\java\\com\\tartecosmetics\\lib\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@BeforeTest
	public void NavigateToWebsite() throws AWTException {
		WebDriverWait wait = new WebDriverWait(driver, 20);

		driver.get("https://tartecosmetics.com/");

		Robot r = new Robot();
		r.keyPress(Event.ESCAPE);
		r.keyRelease(Event.ESCAPE);
		
		System.out.println("Robot escaped");

	}

	@Test
	public void SelectNewArrial() {
		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[contains(text(),'new arrivals')])[1]")))
				.click();

	}

	@Test(priority = 2)
	public void SelectItem1FromNewArrival() {

		WebElement CocealerUntilScroll = driver
				.findElement(By.xpath("(//span[@class='product-name-desktop'][contains(text(),'concealer')])[1]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", CocealerUntilScroll);

		CocealerUntilScroll.click();
	}

	@Test(priority = 3)
	public void AddItem1ForBag() {

		WebElement AddBagButtonUntilScroll = driver.findElement(By.xpath("//button[@id='add-to-cart']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", AddBagButtonUntilScroll);

		driver.findElement(By.xpath("//button[@id='add-to-cart']")).click();
	}

	@Test(priority = 4)
	public void addItem2() throws InterruptedException {

		driver.get("https://tartecosmetics.com/");
		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[contains(text(),'new arrivals')])[1]")))
				.click();
		WebElement CocealerUntilScroll = driver
				.findElement(By.xpath("(//span[@class='product-name-desktop'][contains(text(),'concealer')])[1]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", CocealerUntilScroll);

		CocealerUntilScroll.click();

		WebElement AddBagButtonUntilScroll = driver.findElement(By.xpath("//button[@id='add-to-cart']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", AddBagButtonUntilScroll);

		driver.findElement(By.xpath("//button[@id='add-to-cart']")).click();
	}

	@Test(priority = 5, description = "Item removing task")
	public void RemoveItemfromBag() {
		WebDriverWait wait = new WebDriverWait(driver, 20);

		driver.get("https://tartecosmetics.com/en_IN/bag");

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"(*//button[@name='dwfrm_cart_shipments_i0_items_i0_deleteProduct']//*[local-name()='svg'])[1]")))
				.click();

	}

}

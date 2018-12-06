package testes;


import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

class UsandoSeleniumTest {

	private WebDriver driver;
	private WebElement searchBox;
	private WebElement searchResults;

	@BeforeEach
	public void openBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@AfterEach
	public void closeBrowser() {
		driver.quit();
	}

	@Test
	public void search() {
		driver.get("https://www.google.com.br");

		searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("IFPE - Instituto Federal de Pernambuco");
		searchBox.submit();

		searchResults = driver.findElement(By.cssSelector("#search"));

		assertTrue(driver.getTitle().startsWith("IFPE - Instituto Federal de Pernambuco"));
	}
}
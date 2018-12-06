package testes;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

class PesquisaGoogle {
	private WebDriver driver;

	@BeforeEach
	public void abrirBrowser() throws Exception {
		WebDriverManager.chromedriver().setup();
		this.driver = new ChromeDriver();
	}

	@AfterEach
	public void fecharBrowser() throws Exception {
		this.driver.quit();
	}

	@Test
	void testar() {
		this.driver.get("https://www.google.com");
		
		WebElement elemento = driver.findElement(By.name("q"));
		
		elemento.sendKeys("Instituto Federal de Educação, Ciência e Tecnologia de Pernambuco");
		
		elemento.submit();
		
		var resultados = driver.findElements(By.tagName("h3"));
		
		for(WebElement we: resultados) {
			System.out.println(we.getText());
		}
	}

}

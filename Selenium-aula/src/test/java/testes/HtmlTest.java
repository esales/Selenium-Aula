package testes;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HtmlTest {
private WebDriver driver;
	
	
	@BeforeEach
	public void preTeste() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	@AfterEach
	public void posTeste() {
		driver.quit();
	}
	
	@Test
	public void testar() {
		String usuario = "teste";
		String senha = "abcde";
		String opcao = "2";
		
		driver.get("http://localhost:80/selenium");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement campoUsuario = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("iptUsuario")));
		
		campoUsuario.sendKeys(usuario);
		
		WebElement campoSenha = driver.findElement(By.id("iptSenha"));
		campoSenha.sendKeys(senha);
		
		WebElement campoOpcao = driver.findElement(By.id("sctOpcao"));
		List<WebElement> opcoes = campoOpcao.findElements(By.tagName("option"));
		for (WebElement itemOpcao:opcoes) {
			if (itemOpcao.getText().equals(opcao)) {
				itemOpcao.click();
			}
		}		
		WebElement botao = driver.findElement(By.id("botao"));
		botao.click();
		
		WebElement usuarioRecebido = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("usuario")));
		WebElement senhaRecebida = driver.findElement(By.id("senha"));
		WebElement opcaoRecebida = driver.findElement(By.id("opcao"));
		
		assertEquals(usuario, usuarioRecebido.getText());
		assertEquals(senha, senhaRecebida.getText());
		assertEquals(opcao, opcaoRecebida.getText());

		driver.close();
		
//		driver.navigate().back();
//		WebDriverWait wait2 = new WebDriverWait(driver, 5);
//		WebElement ultimo = wait2.until(ExpectedConditions.presenceOfElementLocated(By.tagName("input"))); 
//		assertNotNull(ultimo);
//		
//		
//		Actions actions = (new Actions(driver));
//		actions.pause(100);
		
	}
}
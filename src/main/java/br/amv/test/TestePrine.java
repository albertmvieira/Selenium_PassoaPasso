package br.amv.test;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import br.amv.core.DSL;
import br.amv.core.DriverFactory;

public class TestePrine {
	
	private DSL dsl;

	@Before
	public void inicializa(){
		dsl = new DSL();
	}
	
	@After
	public void finaliza(){
		DriverFactory.killDriver();
	}

	@Test
	public void deveInteragirComRadioPrime(){
		DriverFactory.getDriver().get("https://www.primefaces.org/showcase/ui/input/oneRadio.xhtml");
		dsl.clicarRadio(By.xpath("//input[@id='j_idt86:console:0']/../..//span"));
		Assert.assertTrue(dsl.isRadioMarcado("j_idt86:console:0"));
		dsl.clicarRadio(By.xpath("//label[.='PS4']/..//span"));
		Assert.assertTrue(dsl.isRadioMarcado("j_idt86:console:1"));
	}
	
	@Test
	public void deveInteragirComSelectPrime(){
		DriverFactory.getDriver().get("https://www.primefaces.org/showcase/ui/input/oneMenu.xhtml");
		dsl.selecionarComboPrime("j_idt86:console", "Xbox One");
		Assert.assertEquals("Xbox One", dsl.obterTexto("j_idt86:console_label"));
	}
}
package steps;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.openqa.selenium.WebElement;
import pages.HomePage;
import pages.ResultadoBuscaPage;
import suporte.Generator;
import suporte.Screenshot;
import suporte.Web;

import static org.junit.Assert.assertEquals;

public class StepsOrcamentos {
	private WebDriver driver;
	private HomePage homePage;

	@Before
	public void before() {
		driver = Web.createChorme();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@After
	public void after() {
		driver.quit();
	}

	@Dado("que esteja na pagina: {string}")
	public void que_esteja_na_pagina(String url) {
		driver.get(url);
	}

	@Quando("eu preencher os campos necessários")
	public void preencher_campos_necessarios() throws IOException {
		homePage = new HomePage(driver);
		homePage.testPreencherFormulario();
	}

	@Então("vou receber o orcamento escolhido por email")
	public void vou_receber_orcamento_por_email() throws IOException {
		homePage.testResultado();
	}
}

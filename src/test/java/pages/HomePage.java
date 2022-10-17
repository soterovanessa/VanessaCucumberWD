package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import suporte.DadosTeste;
import suporte.Generator;
import suporte.Screenshot;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class HomePage {
	
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public void testPreencherFormulario() throws IOException {

		//Clicar na opção Motorcycle
		//Aba Enter Vehicle Data
		driver.findElement(By.id(DadosTeste.tipo)).click();

		Select selectMake = new Select(driver.findElement(By.id("make")));
		selectMake.selectByValue(DadosTeste.make);

		Select selectModel = new Select(driver.findElement(By.id("model")));
		selectModel.selectByValue(DadosTeste.model);

		driver.findElement(By.id("cylindercapacity")).sendKeys(DadosTeste.cylindercapacity);
		driver.findElement(By.id("engineperformance")).sendKeys(DadosTeste.engineperformance);
		driver.findElement(By.id("dateofmanufacture")).sendKeys(DadosTeste.dateofmanufacture);

		Select selectNumber = new Select(driver.findElement(By.id("numberofseatsmotorcycle")));
		selectNumber.selectByValue(DadosTeste.numberofseatsmotorcycle);

		driver.findElement(By.id("listprice")).sendKeys(DadosTeste.listprice);
		driver.findElement(By.id("annualmileage")).sendKeys(DadosTeste.annualmileage);
		driver.findElement(By.id("nextenterinsurantdata")).click();


		//Aba Enter Insurant Data

		driver.findElement(By.id("firstname")).sendKeys(DadosTeste.firstname);
		driver.findElement(By.id("lastname")).sendKeys(DadosTeste.lastname);
		driver.findElement(By.id("birthdate")).sendKeys(DadosTeste.birthdate);
		driver.findElement(By.xpath("//form[@id='insurance-form']/div/section[2]/div[4]/p/label[2]/span")).click();
		driver.findElement(By.id("streetaddress")).sendKeys(DadosTeste.streetaddress);

		Select selectCountry = new Select(driver.findElement(By.id("country")));
		selectCountry.selectByValue(DadosTeste.country);

		driver.findElement(By.id("zipcode")).sendKeys(DadosTeste.zipcode);
		driver.findElement(By.id("city")).sendKeys(DadosTeste.city);

		Select selectOcupation = new Select(driver.findElement(By.id("occupation")));
		selectOcupation.selectByValue(DadosTeste.occupation);

		driver.findElement(By.xpath("//form[@id='insurance-form']/div/section[2]/div[10]/p/label[3]/span")).click();
		driver.findElement(By.id("website")).sendKeys(DadosTeste.website);
		driver.findElement(By.id("nextenterproductdata")).click();

		//Aba Enter Product Data

		driver.findElement(By.id("startdate")).sendKeys(DadosTeste.startdate);

		Select selectInsurance = new Select(driver.findElement(By.id("insurancesum")));
		selectInsurance.selectByValue(DadosTeste.insurancesum);

		Select selectDamage = new Select(driver.findElement(By.id("damageinsurance")));
		selectDamage.selectByValue(DadosTeste.damageinsurance);

		driver.findElement(By.xpath("//label[contains(.,'Euro Protection')]")).click();
		driver.findElement(By.id("nextselectpriceoption")).click();

		//Aba Select Price Option
		driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/form/div/section[4]/section/div[1]/table/tfoot/tr/th[2]/label[2]/span")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.findElement(By.id("nextsendquote")).click();

		//Aba Send Quote

		driver.findElement(By.id("email")).sendKeys(DadosTeste.email);
		driver.findElement(By.id("phone")).sendKeys(DadosTeste.phone);
		driver.findElement(By.id("username")).sendKeys(DadosTeste.username);
		driver.findElement(By.id("password")).sendKeys(DadosTeste.password);
		driver.findElement(By.id("confirmpassword")).sendKeys(DadosTeste.confirmpassword);
		driver.findElement(By.id("sendemail")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	public void testResultado() throws IOException{

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		WebElement messageAlert = driver.findElement(By.xpath("/html/body/div[4]/h2\n"));
		String textMessageAlert = messageAlert.getText();
		assertEquals("Sending e-mail success!", textMessageAlert);

		String screenshotArquivo = "C:\\Users\\Vagner\\IdeaProjects\\VanessaCucumberWD\\prints\\" + Generator.dataHoraParaArquivo() + ".jpg";
		Screenshot.take(driver, screenshotArquivo);
	}
}

package com.uniovi.tests;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.uniovi.tests.pageobjects.PO_HomeView;
import com.uniovi.tests.pageobjects.PO_LoginView;
import com.uniovi.tests.pageobjects.PO_PrivateView;
import com.uniovi.tests.pageobjects.PO_Properties;
import com.uniovi.tests.pageobjects.PO_RegisterView;
import com.uniovi.tests.pageobjects.PO_View;
import com.uniovi.tests.util.SeleniumUtils;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class NotaneitorComplementariosTests {
    // En Windows (Debe ser la versión 65.0.1 y desactivar las actualizacioens
    // automáticas)):
    static String PathFirefox65 = "C:\\Program Files\\Mozilla Firefox\\firefox.exe";
    static String Geckdriver024 = "C:\\Users\\MediaSiero\\Desktop\\Cosas\\Universidad\\3º\\2º Semestre\\SDI\\Practica\\PL-SDI-Sesión5-material\\geckodriver024win64.exe";
    static WebDriver driver = getDriver(PathFirefox65, Geckdriver024);
    static String URL = "http://localhost:8090";

    public static WebDriver getDriver(String PathFirefox, String Geckdriver) {
	System.setProperty("webdriver.firefox.bin", PathFirefox);
	System.setProperty("webdriver.gecko.driver", Geckdriver);
	WebDriver driver = new FirefoxDriver();
	return driver;
    }

    // Antes de cada prueba se navega al URL home de la aplicación
    @Before
    public void setUp() {
	driver.navigate().to(URL);
    }

    // Después de cada prueba se borran las cookies del navegador
    @After
    public void tearDown() {
	driver.manage().deleteAllCookies();
    }

    // Antes de la primera prueba
    @BeforeClass
    static public void begin() {
    }

    // Al finalizar la última prueba
    @AfterClass
    static public void end() {
	// Cerramos el navegador al finalizar las pruebas
	driver.quit();
    }

    // PR01
    @Test
    public void PR01() {
	PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
	PO_LoginView.fillForm(driver, "99999988F", "123456");
	PO_View.checkElement(driver, "text", "99999988F");
	PO_PrivateView.addProfessor(driver, "71965705Q", "Alejandro", "Alvarez", "Software");
	PO_View.checkElement(driver, "text", "Alejandro");
	PO_PrivateView.logout(driver);
    }

    @Test
    public void PR02() {
	PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
	PO_LoginView.fillForm(driver, "99999988F", "123456");
	PO_View.checkElement(driver, "text", "99999988F");
	PO_PrivateView.addProfessor(driver, "71965705R", "A", "Alvarez", "Software");
	PO_RegisterView.checkKey(driver, "Error.signup.name.length", PO_Properties.getSPANISH());
	PO_PrivateView.addProfessor(driver, "71965705Z", "Alejandro", "Alvarez", "S");
	PO_RegisterView.checkKey(driver, "Error.signup.categoria.length", PO_Properties.getSPANISH());
	PO_PrivateView.logout(driver);
    }

    @Test
    public void PR03() {
	PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
	PO_LoginView.fillForm(driver, "99999993D", "123456");
	PO_View.checkElement(driver, "text", "99999993D");
	List<WebElement> elementos = PO_View.checkElement(driver, "free", "//li[contains(@id, 'professors-menu')]/a");
	elementos.get(0).click();
	SeleniumUtils.EsperaCargaPaginaNoTexto(driver, "Agregar Profesor", PO_View.getTimeout());
	PO_PrivateView.logout(driver);
	PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
	PO_LoginView.fillForm(driver, "99999990A", "123456");
	PO_View.checkElement(driver, "text", "99999990A");
	elementos = PO_View.checkElement(driver, "free", "//li[contains(@id, 'professors-menu')]/a");
	elementos.get(0).click();
	SeleniumUtils.EsperaCargaPaginaNoTexto(driver, "Agregar Profesor", PO_View.getTimeout());
    }
}

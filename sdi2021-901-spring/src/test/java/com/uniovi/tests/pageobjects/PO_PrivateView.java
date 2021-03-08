package com.uniovi.tests.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.uniovi.tests.util.SeleniumUtils;

public class PO_PrivateView extends PO_NavView {
    static public void fillFormAddMark(WebDriver driver, int userOrder, String descriptionp, String scorep) {
	// Esperamos 5 segundo a que carge el DOM porque en algunos equipos falla
	SeleniumUtils.esperarSegundos(driver, 5);
	// Seleccionamos el alumnos userOrder
	new Select(driver.findElement(By.id("user"))).selectByIndex(userOrder);
	// Rellenemos el campo de descripción
	WebElement description = driver.findElement(By.name("description"));
	description.clear();
	description.sendKeys(descriptionp);
	WebElement score = driver.findElement(By.name("score"));
	score.click();
	score.clear();
	score.sendKeys(scorep);
	By boton = By.className("btn");
	driver.findElement(boton).click();
    }

    static public void logout(WebDriver driver) {
	PO_PrivateView.clickOption(driver, "logout", "class", "btn-primary");
	PO_View.checkElement(driver, "text", "Identifícate");
    }

    static public void addMark(WebDriver driver, String desc, String score) {
	// Pinchamos en la opción de menu de Notas: //li[contains(@id, 'marks-menu')]/a
	List<WebElement> elementos = PO_View.checkElement(driver, "free", "//li[contains(@id, 'marks-menu')]/a");
	elementos.get(0).click();
	// Esperamos a aparezca la opción de añadir nota: //a[contains(@href,
	// 'mark/add')]
	elementos = PO_View.checkElement(driver, "free", "//a[contains(@href, 'mark/add')]");
	// Pinchamos en agregar Nota.
	elementos.get(0).click();
	// Ahora vamos a rellenar la nota. //option[contains(@value, '4')]
	PO_PrivateView.fillFormAddMark(driver, 3, desc, score);
	// Esperamos a que se muestren los enlaces de paginación la lista de notas
	elementos = PO_View.checkElement(driver, "free", "//a[contains(@class, 'page-link')]");
	// Nos vamos a la última página
	elementos.get(3).click();
	// Comprobamos que aparece la nota en la pagina
	elementos = PO_View.checkElement(driver, "text", "Nota Nueva 1 zzzzzzzzzzzzzzz");
    }
}
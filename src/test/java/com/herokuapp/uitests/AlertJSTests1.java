package com.herokuapp.uitests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

    public class AlertJSTests1 extends BaseTest {

        @Test
        public void testJavaScriptConfirmAlert() {
            // Знаходимо елемент кнопки і викликаємо алерт
            WebElement confirmButton = BaseTest.driver.findElement(By.xpath("//button[text()='Click for JS Confirm']"));
            confirmButton.click();

            // Використання JavascriptExecutor для виклику алерту
            JavascriptExecutor jsExecutor = (JavascriptExecutor) BaseTest.driver;
            jsExecutor.executeScript("confirm('Are you sure?');");

            // Отримання тексту алерту
            Alert alert = BaseTest.driver.switchTo().alert();
            String alertText = alert.getText();

            // Виведення інформації про алерт в консоль
            System.out.println("You clicked: " + alertText);

            String result = getResult();
            Assert.assertEquals(result, "You clicked: Cancel");

            // Прийняття алерту
            alert.accept();
        }

        private String getResult() {
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) BaseTest.driver;
            return javascriptExecutor.executeScript("return document.getElementById('result').textContent").toString();
        }
    }
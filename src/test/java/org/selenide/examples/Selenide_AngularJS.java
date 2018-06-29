package org.selenide.examples;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;

public class Selenide_AngularJS {

    @BeforeTest
    public void setUp() throws InvalidFormatException {
        System.setProperty("webdriver.chrome.driver","C:\\Projects\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverRunner.setWebDriver(driver);
        open("https://angularjs.org/");
    }

    @Test
    public void test()
    {
        $(By.xpath("//input[@ng-model='yourName']")).setValue("Selenide");
        String getValue = $(By.xpath("//h1[@class='ng-binding']")).getText();

        Assert.assertEquals(getValue, "Hello Selenide!");

        $(By.xpath("//input[@ng-model='todoList.todoText']")).setValue("Selenide Test");

        $(By.xpath("//input[@class='btn-primary']")).click();

        getValue = $(By.xpath("/html/body/div[2]/div[3]/div[2]/div[2]/div/ul/li[3]/label/span")).getText();

        Assert.assertEquals(getValue, "Selenide Test");

        $(By.xpath("//input[@ng-model='projectList.search']")).setValue("AngularJS");



        if ($(By.linkText("AngularJS")).isDisplayed())
        {
            System.out.println("Item found");
        }

    }
    @AfterTest
    public void tearDown()
    {
        close();
    }

}

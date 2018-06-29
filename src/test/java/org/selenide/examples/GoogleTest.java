package org.selenide.examples;

import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class GoogleTest {
    @Test
    public void UserCanSearchKeywordWithGoogle() throws Exception {
        //open
        open("https://www.google.com/");
        //type a word
        $(By.name("q")).setValue("Selenide").pressEnter();
        //assert
        $$(By.xpath("//h3[@class='r']")).shouldHave(size(10));
        $(By.xpath("//h3[@class='r']")).shouldHave(text("Concise UI tests In Java "));

    }
}

package com.sazhina.page;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class JBMainPage {
    String URL = "https://www.jetbrains.com/";
    String menuButton = ".main-menu-item__action--button";


    public JBMainPage openMainPage() {
        open(URL);
        return this;
    }

    public JBMainPage selectTab(String tabName) {
        $$(byText(tabName)).first().click();
        return this;
    }

    public void checkTabName(String tabName) {
        $("[data-test-marker=\"" + tabName + "\"]").shouldHave(text(tabName));
    }

    public JBMainPage clickItemByIndex(int index) {
        $(menuButton, index).click();
        return this;
    }
}

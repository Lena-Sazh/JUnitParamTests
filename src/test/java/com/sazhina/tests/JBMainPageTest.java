package com.sazhina.tests;

import com.sazhina.domain.MenuItem;
import com.sazhina.page.JBMainPage;
import com.sazhina.utils.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class JBMainPageTest extends TestBase {

    private final JBMainPage mainPage = new JBMainPage();

    static Stream<Arguments> MethodSource() {
        return Stream.of(
                Arguments.of(
                        0, "Developer Tools"
                ),
                Arguments.of(
                        1, "Team Tools"
                ),
                Arguments.of(
                        2, "Learning Tools"
                ),
                Arguments.of(
                        3, "Solutions"
                ),
                Arguments.of(
                        4, "Store"
                )
        );
    }

    @MethodSource("MethodSource")
    @ParameterizedTest()
    @DisplayName("Method Source Test")
    void testMethodSource(int index, String tabName) {
        mainPage.openMainPage()
                .clickItemByIndex(index)
                .checkTabName(tabName);
    }

    @CsvSource({
            "Developer Tools",
            "Team Tools",
            "Learning Tools",
            "Solutions",
            "Store"
    })

    @ParameterizedTest()
    @DisplayName("CSV Source Test")
    void testCSVSource(String tabName) {
        mainPage.openMainPage()
                .selectTab(tabName)
                .checkTabName(tabName);
    }

    @EnumSource(value = MenuItem.class)
    @ParameterizedTest()
    @DisplayName("Enum Source Test")
    void testEnumSource(MenuItem menuItem) {
        mainPage.openMainPage()
                .selectTab(menuItem.getTabName())
                .checkTabName(menuItem.getTabName());
    }
}
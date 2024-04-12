package qa.guru.allure;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920Х1080";
        Configuration.pageLoadStrategy = "eager";


    }

    @AfterEach
    void afterEach() {
        closeWebDriver();
    }
}

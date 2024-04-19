package qa.guru.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideTest extends TestBase {

    @Test
    @Tag("Minimum")
    @Feature("Issue в репозитории")
    @Story("Поиск Issue")
    @Owner("rakeya")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Поиск столбца Рейтинг в разделе хабы с использованием selenide")
    public void testHabrSearch() {

        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.browser = "firefox";

        open("https://habr.com/");

        // открыть вкладку "все потоки"
        $("[href='/ru/articles/']").click();


        //перейти на хабы
        $("[href='/ru/hubs/']").click();

        // вводим в поиск "карьера"
        $("input[name='searchQuery']").setValue("карьера");

        $(".tm-input-text-decorated__label").click();

        $(withText("Рейтинг")).should(Condition.exist);
    }

}

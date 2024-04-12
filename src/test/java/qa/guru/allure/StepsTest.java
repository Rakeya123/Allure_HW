package qa.guru.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.attachment;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class StepsTest extends TestBase{

    @Test
    @Feature("Issue в репозитории")
    @Story("Поиск Issue")
    @Owner("rakeya")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Поиск столбца Рейтинг в разделе хабы с использованием steps и lambda")
    public void testLambdaStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу Habr", () -> {
            open("https://habr.com/");

        });
        step("Открываем вкладку хабы ", () -> {
            $("[href='/ru/articles/']").click();
            $("[href='/ru/hubs/']").click();
        });

        step("Вводим в строку поиска Карьера", () -> {
            $("input[name='searchQuery']").setValue("карьера");
            $(".tm-input-text-decorated__label").click();
        });

        step("Проверяем наличие столбца рейтинга", () -> {
            $(withText("Рейтинг")).should(Condition.exist);
            attachment("Source", webdriver().driver().source());
        });
    }

    @Test
    @Feature("Issue в репозитории")
    @Story("Поиск Issue")
    @Owner("rakeya")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Поиск столбца Рейтинг в разделе хабы с использованием аннотаций")
    public void testAnnotatedStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        WebSteps steps = new WebSteps();
        steps.openMainPage();
        steps.openPageHab();
        steps.setValueCareer();
        steps.shouldHaveColumnRating();
        steps.takeScreenshot();

    }

}

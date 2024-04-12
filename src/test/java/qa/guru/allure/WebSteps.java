package qa.guru.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WebSteps {

    @Step("Открываем страницу Habr")
    public void openMainPage() {
        open("https://habr.com/");
    }

    @Step("Открываем вкладку хабы")
    public void openPageHab() {
        $("[href='/ru/articles/']").click();
        $("[href='/ru/hubs/']").click();
    }

    @Step("Вводим в поиск {Карьера} ")
    public void setValueCareer() {

        $("input[name='searchQuery']").setValue("Карьера");
        $(".tm-input-text-decorated__label").click();
    }

    @Step("Проверяем наличие Столбца {Рейтинг}")
    public void shouldHaveColumnRating () {
        $(withText("Рейтинг")).should(Condition.exist);
    }

    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot)WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}

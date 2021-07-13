package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;

public class SelenideTest {

    private static final String Base_URL = "https://github.com";
    private static final String REPOSITORY = "selenide";


    @Step("Открываем главную страницу")
    public void shouldFindSelenideGitHub(String base_URL) {
        //Configuration.timeout=2000;
        Selenide.open(Base_URL);
    }

        /* Configuration.baseUrl="https://github.com";
        Selenide.open("/user");
         $ = element */

    @Step("Ищем selenide ${repository}")
    public void searchForRepository(String repository) {
        Selenide.$("[name=q]").setValue(REPOSITORY).pressEnter();
    }

    @Step("Выбираем первый пункт в списке")
    public void goToRepository() {
        Selenide.$$("ul.repo-list li").first().$("a").click();
    }

    @Step("Проверяем")
    public void shouldSearch() {
        Selenide.$("h1").shouldHave(Condition.text("selenide / selenide"));
    }
}

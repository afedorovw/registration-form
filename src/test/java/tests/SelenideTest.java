package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

public class SelenideTest {

    @Test
    void shouldFindSelenideGitHub() {
        //Configuration.timeout=2000;
        Selenide.open("https://github.com");
        //Configuration.baseUrl="https://github.com";
        //Selenide.open("/user");
        // $ = element
        Selenide.$("[name=q]").setValue("selenide").pressEnter();
        Selenide.$$("ul.repo-list li").first().$("a").click();
        Selenide.$("h1").shouldHave(Condition.text("selenide / selenide"));
    }
}

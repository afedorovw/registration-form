package io;

import org.junit.jupiter.api.Test;
import tests.SelenideTest;

public class MethodStep {
    final SelenideTest steps = new SelenideTest();

    private static final String Base_URL = "https://github.com";
    private static final String REPOSITORY = "selenide";

    @Test
    public void testSearchSelenide() {
        steps.shouldFindSelenideGitHub(Base_URL);
        steps.searchForRepository(REPOSITORY);
        steps.goToRepository();
        steps.shouldSearch();
    }
}

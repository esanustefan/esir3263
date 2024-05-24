package org.echipa_punct.features.search;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.echipa_punct.steps.serenity.EndUserSteps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("org/echipa_punct/features/search/data.csv")
public class SearchByKeywordStory {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public EndUserSteps userSteps;

    public String searchKeyword;
    public String searchFailedText;
    public String searchResultText;

    // Metoda de configurare care setează proprietatea înainte de rularea testului
    @Before
    public void setUp() {
        // Setează calea către executabilul GeckoDriver
        System.setProperty("webdriver.gecko.driver", "C:\\drivers\\geckodriver-v0.32.2-win64\\geckodriver.exe");
        //C:\\drivers\\geckodriver-v0.32.2-win64\\geckodriver.exe
    }

    @Test
    public void searching_by_keyword_should_display_result() {
        userSteps.opens_the_home_page();
        userSteps.types_in_search_field_and_presses_enter(searchKeyword);
        if (searchKeyword.length() < 3) {
            userSteps.should_see_failed_search_notice(searchFailedText);
        } else {
            userSteps.should_see_text_in_search_results(searchResultText);
        }
    }
}

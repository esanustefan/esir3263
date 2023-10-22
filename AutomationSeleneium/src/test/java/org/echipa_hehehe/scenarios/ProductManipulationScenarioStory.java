package org.echipa_hehehe.scenarios;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.echipa_hehehe.steps.serenity.EndUserSteps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("org/echipa_hehehe/scenarios/data.csv")
public class ProductManipulationScenarioStory {

    @Managed(uniqueSession = true, driver = "chrome")
    public WebDriver webdriver;

    @Steps
    public EndUserSteps userSteps;

    public String searchKeyword;
    public String firstSearchResultText;
    public Integer reviewStars;
    public String reviewNickname;
    public String reviewSummary;
    public String reviewTextBlock;

    static public String ADDED_TO_SHOPPING_CART_MESSAGE_TEMPLATE = "You added ? to your shopping cart.";
    static public String EMPTY_CART_MESSAGE = "You have no items in your shopping cart.";
    static public String REVIEW_SUBMITTED_FOR_MODERATION_MESSAGE = "You submitted your review for moderation.";

    @Test
    public void searching_and_manipulating_product() {
        searching_by_text_should_display_first_product();
        opens_first_product_and_adds_to_cart_should_display_success();
        removes_from_cart_should_display_empty_cart();
        adds_a_review_should_display_success();
    }

    public void searching_by_text_should_display_first_product() {
        userSteps.opens_the_home_page();
        userSteps.types_in_search_field_and_presses_enter(searchKeyword);
        userSteps.should_see_text_as_first_search_result(firstSearchResultText);
    }

    public void opens_first_product_and_adds_to_cart_should_display_success() {
        userSteps.opens_the_first_search_result();
        userSteps.clicks_on_first_size();
        userSteps.clicks_on_first_color();
        userSteps.clicks_on_add_to_cart();
        String message= ADDED_TO_SHOPPING_CART_MESSAGE_TEMPLATE.replaceFirst("[?]",firstSearchResultText);
        userSteps.should_see_text_in_page_success_alert(message);
    }

    public void removes_from_cart_should_display_empty_cart() {
        userSteps.clicks_on_cart();
        userSteps.clicks_on_first_remove_from_cart();
        userSteps.clicks_on_confirm_remove_from_cart();
        userSteps.should_see_empty_cart_message(EMPTY_CART_MESSAGE);
    }

    public void adds_a_review_should_display_success() {
        userSteps.clicks_on_add_review();
        userSteps.clicks_on_review_stars(reviewStars);
        userSteps.types_in_review_nickname_field(reviewNickname);
        userSteps.types_in_review_summary_field(reviewSummary);
        userSteps.types_in_review_text_block_field(reviewTextBlock);
        userSteps.clicks_on_submit_review();
        userSteps.should_see_text_in_page_success_alert(REVIEW_SUBMITTED_FOR_MODERATION_MESSAGE);
    }
}
package org.echipa_hehehe.steps.serenity;

import net.thucydides.core.annotations.Step;
import org.echipa_hehehe.pages.LumaMagentoPage;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class EndUserSteps {

    LumaMagentoPage ecommercePage;

    @Step
    public void opens_the_home_page() {
        ecommercePage.open();
    }

    @Step
    public void types_in_search_field_and_presses_enter(String keyword) {
        ecommercePage.type_in_search_field_and_presses_enter(keyword);
    }

    @Step
    public void should_see_failed_search_notice(String failedSearchMessage) {
        assertThat(ecommercePage.getFailedSearchNotice(), containsString(failedSearchMessage));
    }

    @Step
    public void should_see_text_in_search_results(String text) {
        assertThat(ecommercePage.getSearchResults(), hasItem(containsString(text)));
    }

    @Step
    public void should_see_text_as_first_search_result(String text) {
        assertThat(ecommercePage.getSearchResults().get(0), containsString(text));
    }

    @Step
    public void opens_the_first_search_result() {
        ecommercePage.click_on_first_search_result();
    }

    @Step
    public void clicks_on_first_size() {
        ecommercePage.click_on_first_size();
    }

    @Step
    public void clicks_on_first_color() {
        ecommercePage.click_on_first_color();
    }

    @Step
    public void clicks_on_add_to_cart() {
        ecommercePage.click_on_add_to_cart();
    }

    @Step
    public void should_see_text_in_page_success_alert(String text) {
        assertThat(ecommercePage.getAlertSuccessMessage(), containsString(text));
    }

    @Step
    public void clicks_on_cart() {
        ecommercePage.click_on_cart();
    }

    @Step
    public void clicks_on_first_remove_from_cart() {
        ecommercePage.click_on_first_remove_from_cart();
    }

    @Step
    public void clicks_on_confirm_remove_from_cart() {
        ecommercePage.click_on_confirm_remove_from_cart();
    }

    @Step
    public void should_see_empty_cart_message(String text) {
        assertThat(ecommercePage.getEmptyCartMessage(), containsString(text));
    }

    @Step
    public void clicks_on_add_review() {
        ecommercePage.click_on_add_review();
    }

    @Step
    public void clicks_on_review_stars(int stars) {
        ecommercePage.click_on_review_stars(stars);
    }

    @Step
    public void types_in_review_nickname_field(String text) {
        ecommercePage.type_in_review_nickname_field(text);
    }

    @Step
    public void types_in_review_summary_field(String text) {
        ecommercePage.type_in_review_summary_field(text);
    }

    @Step
    public void types_in_review_text_block_field(String text) {
        ecommercePage.type_in_review_text_block_field(text);
    }

    @Step
    public void clicks_on_submit_review() {
        ecommercePage.click_on_submit_review();
    }
}
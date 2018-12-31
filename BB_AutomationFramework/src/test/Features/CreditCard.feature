Feature: Validation of Credit Card

Background:
Given I Launch the BB Gateway page
Then I should verify the "GATEWAY_PAGE" load
And I take screenshot as "bb_gateway_page"
And I launch the "CREDIT_CARD" from "CARDS" section

Scenario: CC Eligibility fill
Then I should verify the "CC_LANDINGPAGE" load
And I take screenshot as "cc_landing_page"

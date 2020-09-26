# Created by Pro at 9/22/2020
  @follow
Feature: Follow People
  Scenario: Follow
    Given Navigate to Explore Page
    When Click on random photo
    Then Click on likes
    Then Follow People
    And Navigate to homepage
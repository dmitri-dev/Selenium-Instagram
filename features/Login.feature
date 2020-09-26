# Created by Dmitri at 9/15/2020
  @login
Feature: Login

  Scenario: Login to Instagram Homepage
    When Launch Instagram
    Then Enter username and password
    And Log in
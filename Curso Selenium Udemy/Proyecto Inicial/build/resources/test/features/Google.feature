# 1º Paso es definir los comportamientos esperados del software, los escenarios.
# Se usa para BDD (Behaviour Driven Development - desarrollo de acuerdo al comportamiento de la aplicación)
# El lenguaje utilizado es Gherkin

Feature: Test Google search funcionality

Rule: The user can enter a search criteria and the app have to return results.

#@Test @Smoke @Regression
@Test
Scenario Outline: As a user I enter a search criteria in Google
    Given I am on the Google search page
    When I enter the search criteria: <searchCriteria>
    And Click on the search button
    Then The browser show the results

    Examples:
    |searchCriteria |
    |Gato           |
    |Silla          |
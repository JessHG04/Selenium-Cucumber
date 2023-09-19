# 1º Paso es definir los comportamientos esperados del software, los escenarios.
# Se usa para BDD (Behaviour Driven Development - desarrollo de acuerdo al comportamiento de la aplicación)
# El lenguaje utilizado es Gherkin

Feature: Test Google search funcionality

Scenario: As a user I enter a search criteria in Google
    Given I am on the Google search page
    When I enter a search criteria
    And Click on the search button
    Then The results match the criteria
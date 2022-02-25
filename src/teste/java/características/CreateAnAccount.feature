
Feature: Create An Account
    #I like client
    #Want fill the form
    #For create my account in site

  Scenario Outline: Create An Account
    Given since i'm on the registration screen
    When fill the field <emailAddress>
    And click in Create an account
    And click in Title Mr or Mrs
    And fill the fields <firstName> and <lastName>
    And fill the field in <password>
    And select the Date Of Birth
    And fill the fields <company> and <address>
    And fill the fields <city> and select in <state>
    And fill the field to <postalCode> and select in <country>
    And fill the fields in <addInformation> and <homeFone>
    And fill the fields the <mobileFone> and <references>
    And click in Register
    Then one must find <sceneryType>

    Examples:
      | sceneryType       | emailAddress      | firstName | lastName | password   | company     | address        | city     | state    | postalCode | country       | addInformation | homeFone      | mobileFone    | references        |
      |"Filld with Sucess"|"dodonio@gmail.com"|"Dodonio"  |"Rick"    |"dodonio123"|"DodonioCorp"|"Bedford Avenue"|"Brooklyn"|"New York"|"11219"     |"United States"|"This is a test"|"5542999556612"|"5542999556688"|"My house is black"|

Feature: Login in to DLG Application

  Scenario Outline: add items to cart:[<UsingData>]

    Given launch the application
    And Enter the Username and Password
    Then Verify the Condition
    And close browser

     Examples: 
      | UsingData          |
      | Signin             |
    
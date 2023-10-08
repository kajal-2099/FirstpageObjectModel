Feature: this feature covered all the test cases related to login functionality

  #Scenario: Test OrangeHRM login with valid credential
  #Given user has already opened a browser
  #And enters the required application url
  #When user enters a valid username
  #And enter valida password
  #And click on login button
  #Then user should be able to reach home page of OrangeHRM
  #And close the browser
  Scenario Outline: Test OrangeHRM login with <flow> credential
    Given user has already opened a browser and enters the required application <url>
    When user enters a valid username<username>
    And enter valida password<password>
    And click on login button
    Then user should be able to reach home page of OrangeHRM<homePageUrl>
    And close the browser

    Examples: 
      | flow    | url                                                                | username | password | homePageUrl |
      | valid   | https://opensource-demo.orangehrmlive.com/web/index.php/auth/login | Admin    | admin123 | dashboard   |
      | invalid | https://opensource-demo.orangehrmlive.com/web/index.php/auth/login | Admin2   | admin123 | login       |
      | invalid | https://opensource-demo.orangehrmlive.com/web/index.php/auth/login | ""       | ""       | login       |

  Scenario Outline: Test OrangeHRM login-logout with <flow> credential
    Given user has already opened a browser and enters the required application <url>
    When user enters a valid username<username>
    And enter valida password<password>
    And click on login button
    And click on user profile 
    And click on logout
    Then validate after logout user navigated back to login page<LoginPageUrl>
    And close the browser

    Examples: 
      | flow  | url                                                                | username | password | LoginPageUrl |
      | valid | https://opensource-demo.orangehrmlive.com/web/index.php/auth/login | Admin    | admin123 | dashboard   |

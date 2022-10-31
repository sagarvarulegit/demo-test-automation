Feature: Login
  @testdata=sample_website_login_data.yml
  Scenario: Valid Login Test
    When I login with valid credentials
    Then I should message "Login Successful!"

  @testdata=sample_website_login_data.yml
  Scenario: Valid Login Test
    When I login with invalid credentials
    Then I should message "Login Failed!"
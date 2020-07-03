Feature: Validate the user successful and unsuccessfull login ,when user is login into application with valid and invalid credentials

  Scenario: successful login with valid credentials
    Given Step 1: Launch the pearson application url as "Pearson.com"
    """
    Pearson application should be launched
    """

    And  Step 2: Validate the title and username and password on login page
    """
    Login page title ,username and password should be validated
    """

    And Step 3: To check login button enabled or not on login page
    """
    Login button should be enabled
    """

    When Step 4: Enter valid username as 'User1' and password as 'Test123' and click on login button
    """
    Home page should be displayed
    """

    Then Step 5: Validate home page title once login into application
    """
    Home page title should be validated
    """

  Scenario: Unsuccessful login with valid username and invalid password
    Given Step 1: Launch the pearson application url as "Pearson.com"
    """
    Pearson application should be launched
    """
    And  Step 2: Validate the title and username and password on login page
    """
    Login page title ,username and password should be validated
    """
    And  Step 3: To check login button enabled or not on login page
    """
    Login button should be enabled
    """
    When Step 4: Enter valid username as 'User11' and invalid password as 'Test123' and click on login button
    """
    Error message should be displayed
    """
    Then Step 5: Unable to login into the application and display error message after login with invalid password
    """
    Error message should be validated once login with invalid password
    """

  Scenario: Unsuccessful login with invalid password and tried multiple times
    Given Step 1: Launch the pearson application url as "Pearson.com"
    """
    Pearson application should be launched
    """
    And  Step 2: Validate the title and username and password on login page
    """
    Login page title ,username and password should be validated
    """
    And  Step 3: To check login button enabled or not on login page
    """
    Login button should be enabled
    """
    When Step 4: Enter valid username as 'User11' and invalid password as 'Test123' multiple times and click on login
    """
    User blocker message should be displayed
    """
    Then Step 5: Unsuccessful and user locked error message displayed after login with invalid password multiple times
    """
    User locked error message should be validated once login with invalid password multiple times
    """


@SauceDemo
  Feature: SauceDemo Check Test Cases

    @AllEmpty
    Scenario Outline: Empty Username & Empty Password
      Given User at home page
      When Click login button
      Then Check "<error>" massage about username
      Examples:
      |error                    |
      |Username is required     |

    @EmptyPassword
    Scenario Outline: Empty Password
      Given User at home page
      When Write "<username>" for username field
      When Click login button
      Then Check "<error>" massage about password
      Examples:
      |username     |error               |
      |abcdefg      |Password is required|

    @EmptyUsername
    Scenario Outline: Empty Username
      Given User at home page
      When Write "<password>" for password field
      When Click login button
      Then Check "<error>" massage about password
      Examples:
        |password   |error               |
        |123456     |Username is required|

    @FalseLogin
    Scenario Outline: Correct Username & False Password
      Given User at home page
      When Write Correct "<username>" for username field
      When Write False "<password>" for password field
      When Click login button
      Then Check "<error>" message about don't match
      Examples:
        |username       |error                                                      |password|
        |problem_user   |Username and password do not match any user in this service|abc123  |

    @FalseLogin2
    Scenario Outline: False Username & Correct Password
      Given User at home page
      When Write False "<username>" for username field
      When Write Correct "<password>" for password field
      When Click login button
      Then Check "<error>" message about don't match
      Examples:
        |username  |error                                                      |password        |
        |abcd      |Username and password do not match any user in this service|secret_sauce    |

    @CorrectLogin
    Scenario Outline: Correct Username & Correct Password
      Given User at home page
      When Write Correct "<username>" for username field
      When Write Correct "<password>" for password field
      When Click login button
      Then Check Successful login
      Examples:
        |username     |password    |
        |problem_user |secret_sauce|
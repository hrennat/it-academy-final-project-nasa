Feature: Asteroids - Near Earth Object Web Service

  Scenario: Fetch all asteroids
    Given There are asteroids
    When User fetch all asteroids
    Then Amount is greater than 0

  Scenario: Fetch an asteroid and its name
    Given There are asteroids
    When User fetch an asteroid
    Then the name of asteroid is retrieved


  Scenario: Fetch all asteroids if date limit  more than 7 day
    Given There are asteroids
    When User tries to fetch all asteroids
    Then error_message is received


  Scenario: Fetch all asteroids but api_key is missing
    Given There are asteroids
    When User tries to fetch asteroids
    Then message is received

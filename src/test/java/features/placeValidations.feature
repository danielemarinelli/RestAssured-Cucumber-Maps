Feature: Validating Place API's

  Scenario: Verify if Place is being successfully added using AppPlaceAPI
    Given add place payload
    When user calls "AddPlaceAPI" with "POST" http request
    Then the API call is success with status code 200
    And "status" in response body in "OK"
    And "scope" in response body in "APP"










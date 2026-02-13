Feature: Validating Place API's

  Scenario Outline: Verify if Place is being successfully added using AppPlaceAPI
    Given add place payload "<name>" "<language>" "<address>" "<url>"
    When user calls "AddPlaceAPI" with "POST" http request
    Then the API call is success with status code 200
    And "status" in response body in "OK"
    And "scope" in response body in "APP"
    And verify place_Id created maps to "<name>" using "AddPlaceAPI"


    Examples:
      | name | language | address  | url                |
      | Kiki | English  | Kentucky | http://www.nfl.com |
#      | Keno | Spanish  | Madrid   | http://www.nfl.es  |











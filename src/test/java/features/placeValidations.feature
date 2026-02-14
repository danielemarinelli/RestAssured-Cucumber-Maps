Feature: Validating Place API's

  @AddPlace
  Scenario Outline: Verify if Place is being successfully added using AppPlaceAPI
    Given add place payload "<name>" "<language>" "<address>" "<url>"
    When user calls "AddPlaceAPI" with "POST" http request
    Then the API call is success with status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"
    And verify place_Id created maps to "<name>" using "AddPlaceAPI"


    Examples:
      | name | language | address  | url                |
      | Kiki | English  | Kentucky | http://www.nfl.com |
#      | Keno | Spanish  | Madrid   | http://www.nfl.es  |

  @DeletePlace
  Scenario: Verify if Delete Place functionality is working
    Given DeletePlace Payload
    When user calls "DeletePlaceAPI" with "POST" http request
    Then the API call is success with status code 200
    And "status" in response body is "OK"








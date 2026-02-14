package stepDefinitions;

import io.cucumber.java.Before;

import java.io.IOException;

public class Hooks {  // Hooks are needed to perform preconditions before and after scenarios

    @Before("DeletePlace")  // in this case, before DeletePlace scenario, perform this method below:
                            // where I can will run it only when place_id is null (that means I did not ran the @AddPlace scenario)
    public void beforeScenario() throws IOException {
        stepDefinition sd = new stepDefinition();
        if(stepDefinition.placeIdFromResponse==null) { // run this section only is @AddPlace
            sd.add_place_payload("Daniele", "Italian", "Rome 00152", "www.italy.it");
            sd.user_calls_with_http_request("AddPlaceAPI", "POST");
            sd.verify_place_id_created_maps_to_using("Daniele", "GetPlaceAPI");
        }

    }
}

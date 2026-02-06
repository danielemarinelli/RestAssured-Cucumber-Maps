package resources;

import POJO.AddPlace;
import POJO.Location;
import java.util.ArrayList;
import java.util.List;

public class DataSetBuild {

    public AddPlace addPlacePayload() {
        AddPlace ap = new AddPlace();
        ap.setAccuracy(100);
        ap.setAddress("Piazza Venezia 14");
        ap.setLanguage("French");
        ap.setName("Spiderman");
        ap.setPhone_number("+(39)0010001533");
        ap.setWebsite("www.nfl.com");
        List<String> ty = new ArrayList<>();
        ty.add("rb");
        ty.add("wr");
        ty.add("lb");
        ap.setTypes(ty);
        Location loc = new Location();
        loc.setLat(-38.383494);
        loc.setLng(53.427362);
        ap.setLocation(loc);
        return ap;
    }
}

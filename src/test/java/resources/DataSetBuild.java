package resources;

import POJO.AddPlace;
import POJO.Location;
import java.util.ArrayList;
import java.util.List;

public class DataSetBuild {

    public AddPlace addPlacePayload() {
        AddPlace ap = new AddPlace();
        ap.setAccuracy(100);
        ap.setAddress("287 Fairways USA");
        ap.setLanguage("French");
        ap.setName("Incredible Hulk");
        ap.setPhone_number("+(39)0010001533");
        ap.setWebsite("www.marvel.com");
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

    public AddPlace addPlacePayload(String nam, String lan, String add, String web) {
        AddPlace ap = new AddPlace();
        ap.setAccuracy(100);
        ap.setAddress(add);
        ap.setLanguage(lan);
        ap.setName(nam);
        ap.setPhone_number("+(39)0010001533");
        ap.setWebsite(web);
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

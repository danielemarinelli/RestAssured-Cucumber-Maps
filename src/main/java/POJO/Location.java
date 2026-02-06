package POJO;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Location {

    private double lat;
    private double lng;

     /* Getters and Setters can be bypassed because imported dependency lombok that
    has @Getter @Setter

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public void setLng(double lng) {
        this.lng = lng;
    } */



}

package resources;
//enum is a special class in java which has collection of constants or methods
public enum APIroutes {

    addPlaceAPI("/maps/api/place/add/json"),
    getPlaceAPI("/maps/api/place/get/json"),
    deletePlaceAPI("/maps/api/place/delete/json");
    private String route;

    APIroutes(String route){
        this.route=route;
    }

    public String getRoute(){
        return route;
    }


}

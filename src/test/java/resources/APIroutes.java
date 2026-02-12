package resources;
//enum is a special class in java which has collection of constants or methods
public enum APIroutes {

    AddPlaceAPI("/maps/api/place/add/json"),  // AddPlaceAPI must be SAME to what it is in feature file
    GetPlaceAPI("/maps/api/place/get/json"),
    DeletePlaceAPI("/maps/api/place/delete/json");
    private String route;

    APIroutes(String route){
        this.route=route;
    }

    public String getRoute(){
        return route;
    }

}

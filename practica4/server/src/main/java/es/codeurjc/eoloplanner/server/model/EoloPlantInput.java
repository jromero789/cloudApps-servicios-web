package es.codeurjc.eoloplanner.server.model;

public class EoloPlantInput {

    private Long id;
	private String city;
	private String planning;

    


    public EoloPlantInput() {
    }
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getPlanning() {
        return planning;
    }
    public void setPlanning(String planning) {
        this.planning = planning;
    }

    
}

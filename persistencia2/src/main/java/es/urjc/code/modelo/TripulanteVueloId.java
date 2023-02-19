package es.urjc.code.modelo;

import jakarta.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class TripulanteVueloId implements Serializable {
    private Long tripulanteId;
    private Long vueloId;

    public TripulanteVueloId() {}

    public TripulanteVueloId(Long tripulanteId, Long vueloId) {
        this.tripulanteId = tripulanteId;
        this.vueloId = vueloId;
    }

    public Long getTripulanteId() {
        return tripulanteId;
    }

    public void setTripulanteId(Long tripulanteId) {
        this.tripulanteId = tripulanteId;
    }

    public Long getVueloId() {
        return vueloId;
    }

    public void setVueloId(Long vueloId) {
        this.vueloId = vueloId;
    }
}

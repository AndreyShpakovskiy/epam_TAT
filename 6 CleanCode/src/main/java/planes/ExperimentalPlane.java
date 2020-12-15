package planes;

import models.ExperimentalPlaneClassificationLevel;
import models.ExperimentalPlaneType;

public class ExperimentalPlane extends Plane{

    private ExperimentalPlaneType experimentalPlaneType;
    private ExperimentalPlaneClassificationLevel planeClassification;

    public ExperimentalPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, ExperimentalPlaneType experimentalPlaneType, ExperimentalPlaneClassificationLevel classificationLevel) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.experimentalPlaneType = experimentalPlaneType;
        this.planeClassification = classificationLevel;
    }

    public ExperimentalPlaneClassificationLevel getClassificationLevel(){
        return planeClassification;
    }

    public void setClassificationLevel(ExperimentalPlaneClassificationLevel classificationLevel){
        this.planeClassification = classificationLevel;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "experimentalPlane{" +
                "model='" + model + '\'' +
                '}';
    }
}

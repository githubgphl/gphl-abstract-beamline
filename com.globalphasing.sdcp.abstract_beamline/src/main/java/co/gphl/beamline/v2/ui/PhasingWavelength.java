package co.gphl.beamline.v2.ui;

import co.gphl.beamline.v2.IdentifiedElement;

public interface PhasingWavelength extends IdentifiedElement {

    double getWavelength();
    String getRole();

}

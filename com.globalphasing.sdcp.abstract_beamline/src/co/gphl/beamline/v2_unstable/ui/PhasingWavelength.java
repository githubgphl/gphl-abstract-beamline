package co.gphl.beamline.v2_unstable.ui;

import co.gphl.beamline.v2_unstable.IdentifiedElement;

public interface PhasingWavelength extends IdentifiedElement {

	double getWavelength();
	String getRole();
	
}

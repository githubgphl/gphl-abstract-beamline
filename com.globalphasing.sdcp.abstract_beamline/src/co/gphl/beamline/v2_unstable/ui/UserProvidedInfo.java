package co.gphl.beamline.v2_unstable.ui;

import java.util.List;

public interface UserProvidedInfo {

	short getSpaceGroup();
	float getExpectedResolution();
	List<PhasingWavelength> getPhasingWavelength();
}

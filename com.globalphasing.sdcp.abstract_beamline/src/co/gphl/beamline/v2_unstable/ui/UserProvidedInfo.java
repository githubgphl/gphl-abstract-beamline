package co.gphl.beamline.v2_unstable.ui;

import java.util.List;

import co.gphl.beamline.v2_unstable.domain_types.CrystalSystem;

public interface UserProvidedInfo {

    short getSpaceGroup();
    float getExpectedResolution();
    List<PhasingWavelength> getPhasingWavelength();
    boolean isSetLattice();
	CrystalSystem getLattice();
}

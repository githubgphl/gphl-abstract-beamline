package co.gphl.beamline.v2_unstable.ui;

import java.util.List;
import java.util.Set;

import co.gphl.beamline.v2_unstable.domain_types.AnomalousScatterer;
import co.gphl.beamline.v2_unstable.domain_types.CrystalSystem;
import co.gphl.beamline.v2_unstable.domain_types.UnitCell;

public interface UserProvidedInfo {

    short getSpaceGroup();
    UnitCell getCell();
    boolean isSetCell();
    float getExpectedResolution();
    Set<PhasingWavelength> getPhasingWavelengths();
    boolean isSetLattice();
	CrystalSystem getLattice();
	Set<AnomalousScatterer> getScatterers();
	Boolean isAnisotropic();
	
	/**
	 * @deprecated use {@link #getPhasingWavelengths()}
	 */
	@Deprecated
    List<PhasingWavelength> getPhasingWavelength();
	
}

package co.gphl.beamline.v2_unstable.ui;

import java.util.Set;

import co.gphl.beamline.v2_unstable.domain_types.AnomalousScatterer;
import co.gphl.beamline.v2_unstable.domain_types.CrystalFamily;
import co.gphl.beamline.v2_unstable.domain_types.PointGroup;
import co.gphl.beamline.v2_unstable.domain_types.UnitCell;

public interface UserProvidedInfo {

    Short getSpaceGroup();
    boolean isSetSpaceGroup();
    UnitCell getCell();
    boolean isSetCell();
    float getExpectedResolution();

    /** @deprecated use {@link #isSetCrystalFamily()} */
    @Deprecated boolean isSetLattice();
    boolean isSetCrystalFamily();

    /** use {@link #getCrystalFamily()} */
    @Deprecated CrystalFamily getLattice();
    CrystalFamily getCrystalFamily();

    boolean isSetPointGroup();
    PointGroup getPointGroup();
    Set<AnomalousScatterer> getScatterers();
    Boolean isAnisotropic();
    
}

package co.gphl.beamline.v2.ui;

import java.util.Set;

import co.gphl.beamline.v2.domain_types.AnomalousScatterer;
import co.gphl.beamline.v2.domain_types.CrystalClass;
import co.gphl.beamline.v2.domain_types.UnitCell;

public interface UserProvidedInfo {

    String getSpaceGroupString();
    boolean isSetSpaceGroupString();
    Short getSpaceGroup();
    boolean isSetSpaceGroup();
    Set<CrystalClass> getCrystalClasses();
    UnitCell getCell();
    boolean isSetCell();
    
    float getExpectedResolution();

    Set<AnomalousScatterer> getScatterers();
    Boolean isAnisotropic();
    
}

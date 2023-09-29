package co.gphl.beamline.v2_unstable.ui;

import java.net.URI;
import java.util.Set;

import co.gphl.beamline.v2_unstable.domain_types.AnomalousScatterer;
import co.gphl.beamline.v2_unstable.domain_types.CrystalClass;
import co.gphl.beamline.v2_unstable.domain_types.UnitCell;

public interface UserProvidedInfo {

    String getSpaceGroupString();
    boolean isSetSpaceGroupString();
    Short getSpaceGroup();
    boolean isSetSpaceGroup();
    Set<CrystalClass> getCrystalClasses();
    UnitCell getCell();
    boolean isSetCell();
    URI getReferenceReflectionFile();
    boolean isSetReferenceReflectionFile();
    
    float getExpectedResolution();

    Set<AnomalousScatterer> getScatterers();
    Boolean isAnisotropic();
    
}

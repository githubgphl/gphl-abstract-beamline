/*
 * Copyright © 2023 by Global Phasing Ltd. and Diamond Light Source.
 * All rights reserved.
 * 
 * Author(s): Peter Keller.
 * 
 * This code is part of the "ASTRA message bus vocabulary", i.e. message payload
 * definitions for the "message bus component" of the "Automated STRAtegies"
 * (ASTRA) project.
 * 
 * The ASTRA project is a collaboration between Global Phasing Ltd. (GPhL) and
 * Diamond Light Source (DLS).
 * 
 * Any possession or use of any software that belongs to the ASTRA message bus
 * vocabulary (in either source or compiled form) other than by GPhL or DLS is
 * only permitted with the written consent of both GPhL and DLS.
 * 
 */
package co.gphl.beamline.v2_unstable.information;

import java.util.Set;

import co.gphl.beamline.v2_unstable.Payload;
import co.gphl.beamline.v2_unstable.domain_types.CrystalClass;
import co.gphl.beamline.v2_unstable.instrumentation.BcsDetectorSetting;
import co.gphl.beamline.v2_unstable.ui.IndexingSolution;
import co.gphl.beamline.v2_unstable.ui.PhasingWavelength;

public interface SelectedLattice extends Payload {

    IndexingSolution getIndexingSolution();
    
    boolean isSetStrategyDetectorSetting();
    BcsDetectorSetting getStrategyDetectorSetting();
    
    boolean isSetStrategyWavelength();
    PhasingWavelength getStrategyWavelength();
    
    boolean isSetStrategyControl();
    String getStrategyControl();

    boolean isSetUserSpaceGroup();
    Short getUserSpaceGroup();
    
    int sizeOfUserCrystalClasses();
    Set<CrystalClass> getUserCrystalClasses();
    
}

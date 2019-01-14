/**
 * Copyright © 2019 by Global Phasing Ltd. All rights reserved
 *
 * This software is proprietary to and embodies the confidential
 * technology of Global Phasing Limited (GPhL).
 *
 * Any possession or use (including but not limited to duplication, reproduction
 * and dissemination) of this software (in either source or compiled form) is
 * forbidden except where an agreement with GPhL that permits such possession or
 * use is in force.
 *
 */
package co.gphl.beamline.v2_unstable.instrumentation;

import java.util.List;

/**
 * Detector setting that is created BCS-side. This allows a BCS-specific
 * calculation of resolution and distance-specific values of ORGX/ORGY
 * to be provided to the workflow.
 * 
 * @author pkeller
 *
 */
public interface BcsDetectorSetting extends DetectorSetting {

    /**
     * Retrieves the resolution that corresponds to the detector position.
     * This resolution will take account of beamline-specific factors and
     * conventions. The wavelength at which the calculation is done is implied
     * at the current time; a future version will provide it explicitly.
     * 
     * @return resolution corresponding to the detector position.
     */
    float getResolution();
    
    /**
     * Retrieves the values of ORGX/ORGY that correspond to the detector position.
     * 
     * @return ORGX/ORGY, or {@code null} if the values are not avilable from the BCS.
     */
    double[] getOrgxy();
    
}

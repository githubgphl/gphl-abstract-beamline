/*
 * Copyright © 2015 by Global Phasing Ltd. All rights reserved
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

package co.gphl.beamline.v2_unstable.information;

import java.util.Map;
import java.util.UUID;

import co.gphl.beamline.v2_unstable.instrumentation.BeamstopSetting;
import co.gphl.beamline.v2_unstable.instrumentation.GoniostatSetting;

/**
 * @author pkeller
 *
 */
public interface SampleCentred {

    double getImageWidth();
    
    /**
     * Return number of images in a wedge. May be {@code null}
     * for a non-interleaved strategy.
     * 
     * @return
     */
    Integer getWedgeWidth();
    
    double getExposure();
    double getAttenuation();
    BeamstopSetting getBeamstopSetting();
    Map<UUID, GoniostatSetting> getGoniostatSetting();
    
}

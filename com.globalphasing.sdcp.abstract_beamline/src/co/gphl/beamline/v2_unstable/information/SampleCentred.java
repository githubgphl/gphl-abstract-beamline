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

import java.util.List;
import java.util.Map;
import java.util.UUID;

import co.gphl.beamline.v2_unstable.data_collection.Scan;
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
    
    /** 
     * A list of interleaving variables, from slowest-varying to
     * fastest varying. The characters are selected from the
     * following:
     * 
     * <ul>
     * <li>{@code g}: Goniostat (sample orientation)</li>
     * <li>{@code b}: Beam (wavelength/energy)</li>
     * <li>{@code d}: Detector position (distance, two-theta)</li>
     * <li>{@code s}: {@link Scan} (the list of required scans at particular
     * settings of the other three variables).
     * </ul>
     * 
     * If an interleaving variable only has one value in the current
     * strategy, that variable may be omitted from this list 
     * 
     * <p>N.B. The correct place, usage and form of this parameter
     * is still undecided. For now, we assume that it is supplied
     * after the geometric strategy has been worked out but before
     * the data collection has been derived from it.</p> 
     */
    List<Character> getInterleaveOrder();
}

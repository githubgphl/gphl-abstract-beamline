/*
 * Copyright © 2014 by Global Phasing Ltd. All rights reserved
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
package co.gphl.beamline.v2_unstable.data_collection;

import java.util.Set;

import co.gphl.beamline.v2_unstable.IdentifiedElement;
import co.gphl.beamline.v2_unstable.instrumentation.BeamSetting;
import co.gphl.beamline.v2_unstable.instrumentation.BeamstopSetting;
import co.gphl.beamline.v2_unstable.instrumentation.DetectorSetting;
import co.gphl.beamline.v2_unstable.instrumentation.GoniostatSetting;

public interface Sweep extends IdentifiedElement {
    
    GoniostatSetting getGoniostatSetting();
    DetectorSetting getDetectorSetting();
    BeamSetting getBeamSetting();
    BeamstopSetting getBeamstopSetting();
    String getScanAxis();
    double getWidth();
    double getStart();
    Integer getSweepGroup();
    boolean isSetSweepGroup();
    Set<Scan> getScans();
    
}

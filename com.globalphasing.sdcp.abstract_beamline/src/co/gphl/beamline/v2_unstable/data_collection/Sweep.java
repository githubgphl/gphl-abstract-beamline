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

import java.util.UUID;

import co.gphl.beamline.v2_unstable.instrumentation.BeamSetting;
import co.gphl.beamline.v2_unstable.instrumentation.BeamstopSetting;
import co.gphl.beamline.v2_unstable.instrumentation.DetectorSetting;
import co.gphl.beamline.v2_unstable.instrumentation.GoniostatSetting;
import co.gphl.beamline.v2_unstable.instrumentation.SweepWidth;

public interface Sweep {

    UUID getId();
    GoniostatSetting getGoniostatSetting();
    DetectorSetting getDetectorSetting();
    BeamSetting getBeamSetting();
    BeamstopSetting getBeamstopSetting();
    SweepWidth getWidth();
    String getScanAxis();
    double getStart();

}

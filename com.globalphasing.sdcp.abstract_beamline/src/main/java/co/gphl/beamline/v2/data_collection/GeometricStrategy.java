/*
 * Copyright © 2015, 2021 by Global Phasing Ltd. All rights reserved
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

package co.gphl.beamline.v2.data_collection;

import java.util.List;
import java.util.Set;

import co.gphl.beamline.v2.IdentifiedElement;
import co.gphl.beamline.v2.Payload;
import co.gphl.beamline.v2.instrumentation.BeamSetting;
import co.gphl.beamline.v2.instrumentation.DetectorSetting;

/**
 * @author pkeller
 *
 */
public interface GeometricStrategy extends IdentifiedElement, Payload {

    Set<Sweep> getSweeps();
    boolean isInterleaved();
    List<Double> getAllowedWidths();
    int getDefaultWidthIdx();
    boolean isUserModifiable();
    boolean isSetSweepRepeat();
    Integer getSweepRepeat();
    boolean isSetSweepOffset();
    Double getSweepOffset();    
    
    DetectorSetting getDefaultDetectorSetting();
    BeamSetting getDefaultBeamSetting();
    
}

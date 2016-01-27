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
package co.gphl.beamline.v2_unstable.instrumentation;

import java.util.Map;
import java.util.Set;

import co.gphl.beamline.v2_unstable.IdentifiedElement;

public interface PositionerSetting
    extends IdentifiedElement {
    
    Map<String, Double> getAxisSettings();
    
    // Map-like methods
    boolean containsAxisSetting(String axis);
    Double getAxisSetting(String axis);
    boolean isAxisSettingsEmpty();
    int axisSettingsSize();
    Set<String> axisSettingsNames();
    Set<Map.Entry<String, Double>> axisSettingsSet();
}

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

package co.gphl.beamline.v2_unstable.data_collection;

import java.util.List;
import java.util.Set;

import co.gphl.beamline.v2_unstable.IdentifiedElement;
import co.gphl.beamline.v2_unstable.Payload;

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
    
    /**
     * @deprecated use {@link #getSweeps()}
     */
    @Deprecated
    Set<Sweep> getSweep();
    
    /**
     * @deprecated use {@link #isInterleaved()}
     */
    @Deprecated
    boolean isInterleave();
    
}

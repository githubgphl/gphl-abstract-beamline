/**
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
package co.gphl.beamline.v2_unstable.instrumentation;

import java.util.UUID;

/**
 * @author pkeller
 *
 */
public interface GoniostatTranslation extends PositionerSetting {

    @Deprecated
    UUID getRotationId();
    @Deprecated
    UUID getNewRotationId();
    @Deprecated
    boolean isSetNewRotationId();
    
    GoniostatRotation getActualRotation();
    UUID getActualRotationId();
    UUID getRequestedRotationId();
    
    /** Check to see if this instance contains a beamline-updated orientation.
     * 
     * @return {@code true} if the actual rotation is different from the requested rotation.
     */
    boolean isRotationModified();
    
}

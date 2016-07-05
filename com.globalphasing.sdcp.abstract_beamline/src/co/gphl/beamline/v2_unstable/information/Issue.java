/**
 * Copyright © 2016 by Global Phasing Ltd. All rights reserved
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

import co.gphl.beamline.v2_unstable.IdentifiedElement;

/**
 * @author pkeller
 *
 */
public interface Issue extends IdentifiedElement {

    String getComponent();
    int getCode();
    String getMessage();

    /**
     * Extracts the timestamp from the {@link #getId() id} and returns it
     * converted to milliseconds since 1970-01-01T00:00.000Z.
     * 
     * @return timestamp
     * @see java.lang.System#currentTimeMillis()
     */
    long getMilliTimestamp();
    
}

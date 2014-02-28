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

import java.util.UUID;

public abstract class InstrumentationParamsImpl 
    implements InstrumentationParams {

    protected UUID uuid;
    
    protected InstrumentationParamsImpl(UUID uuid) {
        if ( uuid == null )
            throw new IllegalArgumentException("Must instantiate with a non-null UUID");
        this.uuid = uuid;
    }
    
    @Override
    public UUID getId() {
        return this.uuid;
    }
    
}

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

import java.util.List;
import java.util.UUID;

import co.gphl.beamline.v2_unstable.IdentifiedElement;
import co.gphl.beamline.v2_unstable.Payload;

public interface CollectionProposal extends IdentifiedElement, Payload {

    String getRelativeImageDir();
    
    // LinkedHashSet<Scan> might be better, if CollectionProposal::scans is
    // changed to {unique, ordered} (which it probably ought to be)
    List<? extends Scan> getScans();
    GeometricStrategy getStrategy();

    /**
     * @deprecated use {@link #getScans()}
     */
    @Deprecated
    List<? extends Scan> getCollection();

    /**
     * @deprecated use {@link #getId()}
     */
    @Deprecated
    UUID getCollectionId();
    
}

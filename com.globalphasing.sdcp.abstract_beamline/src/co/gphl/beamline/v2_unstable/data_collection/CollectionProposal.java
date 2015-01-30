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

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import co.gphl.beamline.v2_unstable.IdentifiedElement;

public interface CollectionProposal extends Serializable, IdentifiedElement {

    UUID getCollectionId();
    UUID getStrategyId();
    String getRelativeImageDir();
    List<? extends Scan> getCollection();
    Set<? extends Sweep> getSummary();

}

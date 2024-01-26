/*
 * Copyright © 2015, 2024 by Global Phasing Ltd. All rights reserved
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

import java.util.Map;
import java.util.Set;
import java.util.UUID;

import co.gphl.beamline.v2_unstable.Payload;
import co.gphl.beamline.v2_unstable.instrumentation.GoniostatTranslation;

/**
 * @author pkeller
 *
 */
public interface CollectionDone extends Payload {

    UUID getProposalId();
    @Deprecated String getImageRoot();
    int getStatus();
    boolean isSetImageRoot();
    boolean getProcWithLatticeParams();
    Set<UUID> getScanIds();
    /**
     * Get the centring id that was used for {@code scanId}.
     * 
     * @param scanId
     * @return centring id
     * @throws IllegalArgumentException if {@code scanId} is not in the set returned by {@link #getScanIds()}
     * @throws NullPointerException if {@code scanId == null}
     */
    UUID getCentringId(UUID scanId);
    /**
     * Get the BCS-provided centring that was used for the scan.
     * 
     * @param scanId
     * @return centring instance, or {@code null} if the BCS did not provide a centring for this scan.
     * @throws IllegalArgumentException if {@code scanId} is not in the set returned by {@link #getScanIds()}
     * @throws NullPointerException if {@code scanId == null}
     */
    GoniostatTranslation getCentring(UUID scanId);
    
    Map<UUID, UUID> getScanIdMap();
    Map<UUID, GoniostatTranslation> getCentringIdMap();
}

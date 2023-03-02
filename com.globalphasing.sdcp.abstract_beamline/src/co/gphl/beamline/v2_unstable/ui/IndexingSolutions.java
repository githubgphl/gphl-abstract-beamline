/**
 * Copyright © 2023 by Global Phasing Ltd. All rights reserved
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
package co.gphl.beamline.v2_unstable.ui;

import java.util.List;

import co.gphl.beamline.v2_unstable.domain_types.IndexingFormat;

/**
 * @author pkeller
 *
 */
public interface IndexingSolutions {

    String getHeader();
    boolean isSetHeader();
    IndexingFormat getFormat();
    List<IndexingSolution> getSolutions();
    @Deprecated String asXdsString();

}

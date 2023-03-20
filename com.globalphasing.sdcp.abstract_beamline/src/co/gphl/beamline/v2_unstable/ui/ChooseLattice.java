/*
 * Copyright © 2015, 2023 by Global Phasing Ltd. and Diamond Light Source.
 * All rights reserved.
 * 
 * Author(s): Peter Keller.
 * 
 * This code is part of the "ASTRA message bus vocabulary", i.e. message payload
 * definitions for the "message bus component" of the "Automated STRAtegies"
 * (ASTRA) project.
 * 
 * The ASTRA project is a collaboration between Global Phasing Ltd. (GPhL) and
 * Diamond Light Source (DLS).
 * 
 * Any possession or use of any software that belongs to the ASTRA message bus
 * vocabulary (in either source or compiled form) other than by GPhL or DLS is
 * only permitted with the written consent of both GPhL and DLS.
 * 
 */

package co.gphl.beamline.v2_unstable.ui;

import java.util.List;
import java.util.Set;

import co.gphl.beamline.v2_unstable.Payload;
import co.gphl.beamline.v2_unstable.domain_types.CrystalFamily;
import co.gphl.beamline.v2_unstable.domain_types.IndexingFormat;
import co.gphl.beamline.v2_unstable.domain_types.UnitCell;

public interface ChooseLattice extends Payload {

    IndexingFormat getIndexingFormat();
    
    /**
     * Get the Bravais lattice(s) implied by the user's choice of crystal symmetry.
     * Normally the returned set will contain at most one string, but for a monoclinic
     * crystal system the set will be {mC, mI}.
     * 
     * N.B. The behaviour of this method has changed compared to previous versions.
     * The instance may have been instantiated specifying the crystal family, in
     * which case this method will return an empty set. In this case, the crystal
     * family is available by using the {@link #getCrystalFamily()} method.
     * 
     * @return a set of 1 or 2 strings representing the Bravais Lattice, or the empty
     * set if a spacegroup for the sample was not provided at the start of the workflow.
     * 
     */
    Set<String> getLattices();
    boolean isSetLattices();
    
    /**
     * Get the crystal family implied by the user's choice of crystal symmetry.
     * 
     * @return crystal family or {@code null} if the user did not specify any crystal symmetry.
     */
    CrystalFamily getCrystalFamily();
    boolean isSetCrystalFamily();
    
    UnitCell getUserProvidedCell();
    boolean isSetUserProvidedCell();
    
    String getIndexingHeader();
    boolean isSetIndexingHeader();
    
    List<IndexingSolution> getIndexingSolutions();
    
    @Deprecated
    String getIndexingSolutionsAsIdxrefString();

}

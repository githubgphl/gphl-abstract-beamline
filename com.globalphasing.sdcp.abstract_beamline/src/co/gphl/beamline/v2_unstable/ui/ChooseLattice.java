/*
 * Copyright © 2015, 2017 by Global Phasing Ltd. and Diamond Light Source.
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

import java.util.Set;

import co.gphl.beamline.v2_unstable.Payload;
import co.gphl.beamline.v2_unstable.domain_types.CrystalSystem;
import co.gphl.beamline.v2_unstable.domain_types.IndexingFormat;

public interface ChooseLattice extends Payload {

    IndexingFormat getFormat();
    
    /**
     * Get the Bravais lattice(s) implied by the user's choice of crystal symmetry.
     * Normally the returned set will contain at most one string, but for a monoclinic
     * crystal system the set will be {mC, mI}.
     * 
     * N.B. The behaviour of this method has changed compared to previous versions.
     * The instance may have been instantiated specifying the crystal system, in
     * which case this method will return an empty set. In this case, the crystal
     * system is available by using the {@link #getCrystalSystem()} method.
     * 
     * @return a set of 1 or 2 strings representing the Bravais Lattice, or the empty
     * set if a spacegroup for the sample was not provided at the start of the workflow.
     * 
     */
    Set<String> getLattices();
    
    boolean isSetLattices();
    
    /**
     * Get the crystal system implied by the user's choice of crystal symmetry.
     * 
     * @return crystal system or {@code null} if the user did not specify any crystal symmetry.
     */
    CrystalSystem getCrystalSystem();
    
    boolean isSetCrystalSystem();
    String getSolutions();

}

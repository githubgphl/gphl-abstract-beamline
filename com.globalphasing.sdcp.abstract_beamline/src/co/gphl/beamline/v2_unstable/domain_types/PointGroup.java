/**
 * Copyright © 2017 by Global Phasing Ltd. All rights reserved
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
package co.gphl.beamline.v2_unstable.domain_types;

import static co.gphl.beamline.v2_unstable.domain_types.CrystalSystem.*;

/**
 * Enumeration of the point groups needed to allow for user specification.
 * This enumeration is for user interface purposes only, and
 * is not crystallographically complete. Centrosymmetric point groups
 * are omitted. {@link #PG32 32} includes {@code 321} and {@code 312},
 * since making a choice from the three trigonal point groups specifies
 * the space group (apart from screw axes, but they are never required
 * in the context of the Abstract Beamline Interface).
 * 
 * @author pkeller
 *
 */
public enum PointGroup {

    PG1(TRICLINIC, 1),
    PG2(MONOCLINIC, 3),
    PG222(ORTHORHOMBIC, 16),
    PG4(TETRAGONAL, 75), PG422(TETRAGONAL, 89),
    PG3(TRIGONAL, 143), 
    /* There is no reason to prefer P 3 1 2 (149) over P 3 2 1 (150) here,
     * but we have to specify one */
    PG32(TRIGONAL, 149),
    PG6(HEXAGONAL, 168), PG622(HEXAGONAL, 177),
    PG23(CUBIC, 195), PG432(CUBIC, 207);
    
    private final CrystalSystem crystalSystem;
    private final short primitiveSpaceGroup;
    
    PointGroup(CrystalSystem crystalSystem, int primitiveSpaceGroup) {
        this.crystalSystem = crystalSystem;
        this.primitiveSpaceGroup = (short) primitiveSpaceGroup;
    }
    
    public String toString() {
        return this.name().substring(2);
    }
    
    public CrystalSystem getCrystalSystem() {
        return this.crystalSystem;
    }
    
    public short getPrimitiveSpaceGroup() {
        return this.primitiveSpaceGroup;
    }
}

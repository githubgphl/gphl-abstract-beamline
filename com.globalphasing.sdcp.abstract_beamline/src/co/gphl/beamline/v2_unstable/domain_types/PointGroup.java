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
    
    /**
     * Returns point group specified by name.
     * 
     * @param name point group name, with or without {@code "PG"} prefix.
     * @return PointGroup value
     */
    public static PointGroup getByName(String name) {
        if ( name.startsWith("PG") )
            return PointGroup.valueOf(name);
        else
            return PointGroup.valueOf("PG" + name);
    }
    
    /**
     * Return the point group to which a space group belongs. Only
     * non-centrosymmetric space groups for now
     * 
     * @param spacegroupNumber
     * @return point group
     */
    public static PointGroup pointGroup(int spacegroupNumber) {
        if (spacegroupNumber < 1 || spacegroupNumber >= sg2pg.length)
            throw new IllegalArgumentException(
                    "There is no space group number " + spacegroupNumber);
        if (sg2pg[spacegroupNumber] == null)
            throw new IllegalArgumentException(
                    "We don't handle centrosymmetric space groups such as "
                            + spacegroupNumber);

        return sg2pg[spacegroupNumber];
    }
    
    private static final PointGroup[] sg2pg = { null, // 0 is null: we use 1-based SG numbers
            PG1, null, PG2, PG2, PG2, null, null, null, null, null, // 1-10
            null, null, null, null, null, PG222, PG222, PG222, PG222, PG222, // 11-20
            PG222, PG222, PG222, PG222, null, null, null, null, null, null, // 21-30
            null, null, null, null, null, null, null, null, null, null, // 31-40
            null, null, null, null, null, null, null, null, null, null, // 41-50
            null, null, null, null, null, null, null, null, null, null, // 51-60
            null, null, null, null, null, null, null, null, null, null, // 61-70
            null, null, null, null, PG4, PG4, PG4, PG4, PG4, PG4, // 71-80
            null, null, null, null, null, null, null, null, PG422, PG422, // 81-90
            PG422, PG422, PG422, PG422, PG422, PG422, PG422, PG422, null, null, // 91-100
            null, null, null, null, null, null, null, null, null, null, // 101-110
            null, null, null, null, null, null, null, null, null, null, // 111-120
            null, null, null, null, null, null, null, null, null, null, // 121-130
            null, null, null, null, null, null, null, null, null, null, // 131-140
            null, null, PG3, PG3, PG3, PG3, null, null, PG32, PG32, // 141-150
            PG32, PG32, PG32, PG32, PG32, null, null, null, null, null, // 151-160
            null, null, null, null, null, null, null, PG6, PG6, PG6, // 161-170
            PG6, PG6, PG6, null, null, null, PG622, PG622, PG622, PG622, // 171-180
            PG622, PG622, null, null, null, null, null, null, null, null, // 181-190
            null, null, null, null, PG23, PG23, PG23, PG23, PG23, null, // 191-200
            null, null, null, null, null, null, PG432, PG432, PG432, PG432, // 201-210
            PG432, PG432, PG432, PG432, null, null, null, null, null, null, // 211-220
            null, null, null, null, null, null, null, null, null, PG432 }; // 221-230
    
}

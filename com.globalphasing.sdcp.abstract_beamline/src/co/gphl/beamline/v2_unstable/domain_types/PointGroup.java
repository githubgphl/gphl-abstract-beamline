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

import static co.gphl.beamline.v2_unstable.domain_types.CrystalFamily.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
    PG3(HEXAGONAL, 143), 
    /* There is no reason to prefer P 3 1 2 (149) over P 3 2 1 (150) here,
     * but we have to specify one */
    PG32(HEXAGONAL, 149),
    PG6(HEXAGONAL, 168), PG622(HEXAGONAL, 177),
    PG23(CUBIC, 195), PG432(CUBIC, 207);
    
    private final CrystalFamily crystalFamily;
    private final short primitiveSpaceGroup;
    
    PointGroup(CrystalFamily crystalFamily, int primitiveSpaceGroup) {
        this.crystalFamily = crystalFamily;
        this.primitiveSpaceGroup = (short) primitiveSpaceGroup;
    }
    
    public String toString() {
        return this.name().substring(2);
    }
    
    public CrystalFamily getCrystalFamily() {
        return this.crystalFamily;
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
        PointGroup retval;
        try {
            retval = pointGroupBySpaceGroup.get(spacegroupNumber);
        }
        catch ( IndexOutOfBoundsException e ) {
            throw new IllegalArgumentException("There is no space group number " + spacegroupNumber, e);
        }
        
        if (retval == null)
            throw new IllegalArgumentException(
                    spacegroupNumber == 0 ?
                            "There is no space group number 0" :
                            "We don't handle centrosymmetric space groups such as "
                                + spacegroupNumber
                      );

        return retval;
    }
    
    private static final List<PointGroup> pointGroupBySpaceGroup;
    
    static {
        // 231 not 230 because we are using the index of the array as the spacegroup 
        // without applying any offset, so we need an extra element for sg2pg[0]
        final PointGroup[] sg2pg = new PointGroup[231];
        sg2pg[1] = PG1;
        // Parameters 2 and three of Arrays.fill are:
        //   fromIndex inclusive
        //   toIndex   exclusive
        Arrays.fill(sg2pg, 3, 6, PG2);
        Arrays.fill(sg2pg, 16, 25, PG222);
        Arrays.fill(sg2pg, 75, 81, PG4);
        Arrays.fill(sg2pg, 89, 99, PG422);
        Arrays.fill(sg2pg, 143, 147, PG3);
        Arrays.fill(sg2pg, 149, 156, PG32);
        Arrays.fill(sg2pg, 168, 174, PG6);
        Arrays.fill(sg2pg, 177, 183, PG622);
        Arrays.fill(sg2pg,  195, 200, PG23);
        Arrays.fill(sg2pg,  207, 215, PG432);
        
        pointGroupBySpaceGroup = Collections.unmodifiableList(Arrays.asList(sg2pg));
    }
}

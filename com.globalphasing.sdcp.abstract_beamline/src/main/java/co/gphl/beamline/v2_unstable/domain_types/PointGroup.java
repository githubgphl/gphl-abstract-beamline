/**
 * Copyright © 2017, 2023 by Global Phasing Ltd. All rights reserved
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
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Enumeration of the point groups needed to allow for user specification.
 * This enumeration is for user interface purposes only, and
 * is not crystallographically complete. Centrosymmetric point groups
 * are omitted.
 * 
 * @author pkeller
 *
 */
public enum PointGroup implements SpaceGroupSet {

    PG1(TRICLINIC,      CrystalClass.P1),
    PG2(MONOCLINIC,     CrystalClass.P2,   CrystalClass.C2),
    PG222(ORTHORHOMBIC, CrystalClass.P222, CrystalClass.C222, CrystalClass.F222, CrystalClass.I222),
    PG4(TETRAGONAL,     CrystalClass.P4,   CrystalClass.I4),
    PG422(TETRAGONAL,   CrystalClass.P422, CrystalClass.I422),
    PG3(HEXAGONAL,      CrystalClass.P3,   CrystalClass.R3), 
    PG32(HEXAGONAL,     CrystalClass.P312, CrystalClass.P321, CrystalClass.R32),
    PG6(HEXAGONAL,      CrystalClass.P6),
    PG622(HEXAGONAL,    CrystalClass.P622),
    PG23(CUBIC,         CrystalClass.P23,  CrystalClass.F23,  CrystalClass.I23),
    PG432(CUBIC,        CrystalClass.P432, CrystalClass.F432, CrystalClass.I432);
    
    private final CrystalFamily crystalFamily;
    private final Set<CrystalClass> crystalClasses;
    
    PointGroup(CrystalFamily crystalFamily, CrystalClass... crystalClasses) {
        this.crystalFamily = crystalFamily;
        this.crystalClasses = Collections.unmodifiableSet( Stream.of(crystalClasses).collect(Collectors.toSet()) );
    }
    
    public String toString() {
        return this.name().substring(2);
    }
    
    public CrystalFamily getCrystalFamily() {
        return this.crystalFamily;
    }
    
    public Set<CrystalClass> getCrystalClasses() {
        return this.crystalClasses;
    }
    
    @Override
    public Set<Short> getSpaceGroups() {
        return this.crystalClasses.stream().flatMap( s -> s.getSpaceGroups().stream() ).collect(Collectors.toSet());
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

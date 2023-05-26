/*
 * Copyright © 2023 by Global Phasing Ltd. and Diamond Light Source.
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
package co.gphl.beamline.v2_unstable.domain_types;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Enumeration of arithmetic crystal classes
 * 
 * @apiNote The enumeration names start, rather than end, with the centring
 *          character because of Java identifier naming rules. The methods
 *          {@link #toString()}, {@link #fromString(String)} and
 *          {@link #fromStringList(String...)} deal with the conventional names
 *          (e.g. <em>222C</em>, <em>432F</em> etc.)
 * 
 * @author pkeller
 *
 */
public enum CrystalClass implements SpaceGroupSet {

    P1  (PointGroup.PG1,   1),
    P2  (PointGroup.PG2,   3, 4),
    C2  (PointGroup.PG2,   5),
    P222(PointGroup.PG222, 16, 17, 18, 19),
    C222(PointGroup.PG222, 20, 21),
    F222(PointGroup.PG222, 22),
    I222(PointGroup.PG222, 23, 24),
    P4  (PointGroup.PG4,   75, 76, 77, 78),
    I4  (PointGroup.PG4,   79, 80),
    P422(PointGroup.PG422, 89, 90, 91, 92, 93, 94, 95, 96),
    I422(PointGroup.PG422, 97, 98),
    P3  (PointGroup.PG3,   143, 144, 145),
    R3  (PointGroup.PG3,   146),
    P32 (PointGroup.PG32,  149, 150, 151, 152, 153, 154),
    R32 (PointGroup.PG32,  155),
    P6  (PointGroup.PG6,   168, 169, 170, 171, 172, 173),
    P622(PointGroup.PG622, 177, 178, 179, 180, 181, 182),
    P23 (PointGroup.PG23,  195, 198),
    F23 (PointGroup.PG23,  196),
    I23 (PointGroup.PG23,  197, 199),
    P432(PointGroup.PG432, 207, 208, 212, 213),
    F432(PointGroup.PG432, 209, 210),
    I432(PointGroup.PG432, 211, 214);
    
    final private Set<Short> spaceGroups;
    final private PointGroup pointGroup;
    final static private CrystalClass[] sgTable = new CrystalClass[231];
    
    static {
        for ( CrystalClass c: CrystalClass.values() ) {
            for ( Short sg: c.spaceGroups )
                sgTable[sg] = c;
        }
    }
    
    CrystalClass(PointGroup pointGroup, int... spaceGroups) {
        Set<Short> sgset = new HashSet<>();
        for ( int s: spaceGroups ) {
            sgset.add( (short) s);
        }
        
        this.spaceGroups = Collections.unmodifiableSet(sgset);
        this.pointGroup = pointGroup;
    }
    
    @Override
    public Set<Short> getSpaceGroups() {
        return this.spaceGroups;
    }
    
    @Override
    public String toString() {
        return name().substring(1) + name().substring(0, 1);
    }
    
    public PointGroup getPointGroup() {
        return this.pointGroup;
    }
    
    static public CrystalClass fromString(String name) {
        CrystalClass retval = null;
        try {
            retval = CrystalClass.valueOf( name.substring(name.length()-1) + name.substring(0, name.length()-1) );
        }
        catch (IllegalArgumentException e) {
            throw new RuntimeException("Cannot convert '" + name + "' to an arithmetic crytstal class", e);
        }
        return retval;
    }
    
    static public Set<CrystalClass> fromStringList(String... names) {
        Set<CrystalClass> retval = Arrays.stream(names).map(CrystalClass::fromString).collect(Collectors.toSet());
        return Collections.unmodifiableSet(retval);
    }
    
    static public CrystalClass fromSpaceGroup(Short sg) {
        if ( sg < 1 || sg > 230 )
            throw new IllegalArgumentException("Space group numbers must be in the range 1 <= sg <= 230. "
                    + "We got: " + Short.toString(sg) );
        CrystalClass retval = sgTable[sg];
        if ( retval == null )
            throw new IllegalArgumentException("We don't deal with centrosymmetric space groups here. "
                    + "We got: " + Short.toString(sg) );
        return retval;
    }
}

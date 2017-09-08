/*
 * Copyright © 2014, 2017 by Global Phasing Ltd. All rights reserved
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

public enum CrystalSystem {

    TRICLINIC('a'), MONOCLINIC('m'), ORTHORHOMBIC('o'), TETRAGONAL('t'),
    TRIGONAL('h'), HEXAGONAL('h'), CUBIC('c');
    
    private final Character xdsChar;
    
    CrystalSystem(Character xdsChar) {
        this.xdsChar = xdsChar;
    }
    
    public Character getXdsChar() {
        return this.xdsChar;
    }
    
    public static CrystalSystem getByXdsChar(char xdsChar) {
        if ( xdsChar == 'h')
            return HEXAGONAL;
        for ( CrystalSystem s: CrystalSystem.values() ) {
            if ( xdsChar == s.xdsChar )
                return s;
        }
        
        throw new IllegalArgumentException("Cannot translate '" + xdsChar +
                "' to a crystal family");
        
    }
    
}

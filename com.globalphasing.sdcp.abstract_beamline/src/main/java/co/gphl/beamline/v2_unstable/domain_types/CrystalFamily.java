/*
 * Copyright © 2014, 2023 by Global Phasing Ltd. All rights reserved
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

public enum CrystalFamily {

    TRICLINIC('a'), MONOCLINIC('m'), ORTHORHOMBIC('o'),
    TETRAGONAL('t'), HEXAGONAL('h'), CUBIC('c');
    
    private final Character pearsonChar;
    
    CrystalFamily(Character pearsonChar) {
        this.pearsonChar = pearsonChar;
    }
    
    /**
     * Returns the character representing the crystal family that is used
     * in the Pearson symbols for the Bravais lattices that belong to the
     * crystal family.
     * 
     * @return crystal family as the character used in Pearson symbols
     */
    public Character getPearsonChar() {
        return this.pearsonChar;
    }
    
    public static CrystalFamily getByPearsonChar(char pearsonChar) {
        for ( CrystalFamily s: CrystalFamily.values() ) {
            if ( pearsonChar == s.pearsonChar )
                return s;
        }
        
        throw new IllegalArgumentException("Cannot translate '" + pearsonChar +
                "' to a crystal family");
        
    }
    
}

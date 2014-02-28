/*
 * Copyright © 2014 by Global Phasing Ltd. All rights reserved
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

//This class implements a DataType. Keep it immutable!

public class AnomalousScatterer {

    private final ChemicalElement element;
    private final AbsorptionEdge edge;
    
    // TODO: write a constructor that takes string arguments
    
    public AnomalousScatterer(ChemicalElement element, AbsorptionEdge edge) {
        this.element = element;
        this.edge = edge;
    }

    public ChemicalElement getElement() {
        return element;
    }

    public AbsorptionEdge getEdge() {
        return edge;
    }
    

    
}

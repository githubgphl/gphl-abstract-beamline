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

import java.util.Arrays;

//This class implements a DataType. Keep it immutable!

public class UnitCell {

    private double[] lengths, angles;
    
    public UnitCell(double a, double b, double c,
            double alpha, double beta, double gamma) {
        this.lengths = new double[] {a,b,c};
        this.angles  = new double[] {alpha, beta, gamma};
    }
    
    public double[] getLengths() {
        return Arrays.copyOf(this.lengths, 3);
    }
    
    public double[] getAngles() {
        return Arrays.copyOf(this.angles, 3);
    }
    
}

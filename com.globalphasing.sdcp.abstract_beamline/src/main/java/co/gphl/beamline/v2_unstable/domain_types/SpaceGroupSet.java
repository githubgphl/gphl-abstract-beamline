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

import java.util.Set;

/**
 * Type that represents something that is a set of space groups.
 * 
 * @author pkeller
 *
 */
public interface SpaceGroupSet {

    Set<Short> getSpaceGroups();
    
}

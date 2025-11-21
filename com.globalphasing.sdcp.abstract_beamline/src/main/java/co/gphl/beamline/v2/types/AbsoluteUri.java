/**
 * Copyright © 2025 by Global Phasing Ltd. All rights reserved
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
package co.gphl.beamline.v2.types;

/**
 * Supertype for locators/retrievers for resources handled by the BCS
 */
public interface AbsoluteUri {

    /**
     * Getter for scheme of URI
     * 
     * @return scheme
     */
    String getScheme();

}

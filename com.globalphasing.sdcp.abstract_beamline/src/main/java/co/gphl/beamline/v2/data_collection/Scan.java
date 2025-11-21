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
package co.gphl.beamline.v2.data_collection;

import java.util.Map;

import co.gphl.beamline.v2.IdentifiedElement;
import co.gphl.beamline.v2.instrumentation.ScanExposure;
import co.gphl.beamline.v2.instrumentation.ScanWidth;

public interface Scan extends IdentifiedElement {

    ScanExposure getExposure();
    int getImageStartNum();
    ScanWidth getWidth();
    double getStart();
    Sweep getSweep();    
    
    Map<String, String> getFilenameParams();
    String getFilenameParam(String key);
    boolean isFilenameParamsEmpty();
    int sizeOfFilenameParams();
    boolean filenameParamsContainsKey(String key);
}

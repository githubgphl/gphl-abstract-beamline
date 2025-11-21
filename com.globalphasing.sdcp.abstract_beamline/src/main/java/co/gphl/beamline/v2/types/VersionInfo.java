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

public interface VersionInfo extends SimpleVersionInfo {

    /**
     * Build time as used in SemVer build metadata for the GPhL workflow application follows this human-readable format.
     * 
     * @see java.time.format.DateTimeFormatter
     * @see <a href="https://semver.org/">https://semver.org/</a>
     */
    String BuildTimeFormat = "yyyyMMddHHmm";
    /**
     * Build times formatted according to {@link BuildTimeFormat} is always expressed in UTC
     */
    String BuildTimeZone = "UTC";
    
    String getBuildmetadata();
    String toString();
    
    /**
     * Gets build time expressed as seconds since the start of the epoch (i.e. 1970-01-01T00:00:00Z)
     * @return
     */
    Long getBuildTime();
    
    /**
     * Check whether the version indicates that the build was from a clean, version-tagged checkout
     * @return {@code true} if the build was from a clean checkout with a version tag, {@code false} otherwise.
     */
    boolean isClean();
    
}

package co.gphl.beamline.v2_unstable.ui;

import java.util.UUID;

public interface PriorInformation {

    UUID getSampleId();
    boolean isSetSampleName();
    String getSampleName();
    // For future use. 
    // URL getReflectionFile();
    boolean isSetUserProvidedInfo();
    UserProvidedInfo getUserProvidedInfo();
    boolean isSetRootDirectory();
    String getRootDirectory();
}

package co.gphl.beamline.v2_unstable.ui;

import java.util.UUID;

public interface PriorInformation {

    UUID getSampleId();
    String getSampleName();
    // For future use. 
    // URL getReflectionFile();
    UserProvidedInfo getUserProvidedInfo();
    String getRootDirectory();
}

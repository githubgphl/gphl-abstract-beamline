package co.gphl.beamline.v2_unstable.ui;

import java.util.UUID;

import co.gphl.beamline.v2_unstable.Payload;

public interface PriorInformation extends Payload {

    UUID getSampleId();
    boolean isSetSampleName();
    String getSampleName();
    boolean isSetUserProvidedInfo();
    UserProvidedInfo getUserProvidedInfo();
    boolean isSetRootDirectory();
    String getRootDirectory();
}

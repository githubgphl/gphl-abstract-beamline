package co.gphl.beamline.v2.ui;

import java.util.UUID;

import co.gphl.beamline.v2.Payload;

public interface PriorInformation extends Payload {

    UUID getSampleId();
    boolean isSetSampleName();
    String getSampleName();
    boolean isSetUserProvidedInfo();
    UserProvidedInfo getUserProvidedInfo();
    boolean isSetRootDirectory();
    String getRootDirectory();
}

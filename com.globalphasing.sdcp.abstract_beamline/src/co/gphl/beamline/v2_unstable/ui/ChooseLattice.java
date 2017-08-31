package co.gphl.beamline.v2_unstable.ui;

import java.util.Set;

import co.gphl.beamline.v2_unstable.Payload;
import co.gphl.beamline.v2_unstable.domain_types.IndexingFormat;

public interface ChooseLattice extends Payload {

    IndexingFormat getFormat();
    Set<String> getLattices();
    String getSolutions();

}

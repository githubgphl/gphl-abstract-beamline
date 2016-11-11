package co.gphl.beamline.v2_unstable.ui;

import java.util.List;

import co.gphl.beamline.v2_unstable.Payload;
import co.gphl.beamline.v2_unstable.domain_types.IndexingFormat;

public interface ChooseLattice extends Payload {

    IndexingFormat getFormat();
    List<String> getLattice();
    String getSolutions();

}

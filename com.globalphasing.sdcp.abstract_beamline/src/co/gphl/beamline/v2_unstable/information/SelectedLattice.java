package co.gphl.beamline.v2_unstable.information;

import java.util.List;

import co.gphl.beamline.v2_unstable.Payload;
import co.gphl.beamline.v2_unstable.domain_types.IndexingFormat;

public interface SelectedLattice extends Payload {

    IndexingFormat getFormat();
    List<String> getIndexingSolution();

}

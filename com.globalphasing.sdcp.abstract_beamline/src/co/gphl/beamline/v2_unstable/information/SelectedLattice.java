package co.gphl.beamline.v2_unstable.information;

import java.util.List;

import co.gphl.beamline.v2_unstable.domain_types.IndexingFormat;

public interface SelectedLattice {

	IndexingFormat getFormat();
	List<String> getIndexingSolution();
	
}

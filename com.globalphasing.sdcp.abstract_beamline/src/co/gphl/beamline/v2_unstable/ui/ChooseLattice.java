package co.gphl.beamline.v2_unstable.ui;

import java.util.List;

import co.gphl.beamline.v2_unstable.domain_types.IndexingFormat;

public interface ChooseLattice {

	IndexingFormat getFormat();
	List<String> getLattice();
	String getSolutions();
	
}

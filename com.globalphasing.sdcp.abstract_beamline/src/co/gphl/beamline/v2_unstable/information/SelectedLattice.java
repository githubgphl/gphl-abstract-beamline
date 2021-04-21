package co.gphl.beamline.v2_unstable.information;

import java.util.List;

import co.gphl.beamline.v2_unstable.Payload;
import co.gphl.beamline.v2_unstable.domain_types.IndexingFormat;
import co.gphl.beamline.v2_unstable.instrumentation.BcsDetectorSetting;
import co.gphl.beamline.v2_unstable.ui.PhasingWavelength;

public interface SelectedLattice extends Payload {

    IndexingFormat getFormat();
    List<String> getIndexingSolution();
    
    boolean isSetStrategyDetectorSetting();
    BcsDetectorSetting getStrategyDetectorSetting();
    
    boolean isSetStrategyWavelength();
    PhasingWavelength getStrategyWavelength();
    
    boolean isSetStrategyControl();
    String getStrategyControl();

}

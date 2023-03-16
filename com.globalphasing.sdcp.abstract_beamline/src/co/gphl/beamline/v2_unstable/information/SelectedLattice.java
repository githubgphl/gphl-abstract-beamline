package co.gphl.beamline.v2_unstable.information;

import co.gphl.beamline.v2_unstable.Payload;
import co.gphl.beamline.v2_unstable.domain_types.PointGroup;
import co.gphl.beamline.v2_unstable.instrumentation.BcsDetectorSetting;
import co.gphl.beamline.v2_unstable.ui.IndexingSolution;
import co.gphl.beamline.v2_unstable.ui.PhasingWavelength;

public interface SelectedLattice extends Payload {

    IndexingSolution getIndexingSolution();
    
    boolean isSetStrategyDetectorSetting();
    BcsDetectorSetting getStrategyDetectorSetting();
    
    boolean isSetStrategyWavelength();
    PhasingWavelength getStrategyWavelength();
    
    boolean isSetStrategyControl();
    String getStrategyControl();

    boolean isSetUserPointGroup();
    PointGroup getUserPointGroup();
    
}

// OK for this module to be completely open: it only contains
// public interface definitions and so needs no encapsulation at all
open module com.globalphasing.sdcp.abstract_beamline {
    exports co.gphl.beamline.v2;
    exports co.gphl.beamline.v2.control;
    exports co.gphl.beamline.v2.data_collection;
    exports co.gphl.beamline.v2.domain_types;
    exports co.gphl.beamline.v2.information;
    exports co.gphl.beamline.v2.instrumentation;
    exports co.gphl.beamline.v2.ui;
    exports co.gphl.beamline.v2.types;
}

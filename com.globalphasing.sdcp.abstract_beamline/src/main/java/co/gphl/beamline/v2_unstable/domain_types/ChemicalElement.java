/*
 * Copyright © 2014 by Global Phasing Ltd. All rights reserved
 *
 * This software is proprietary to and embodies the confidential
 * technology of Global Phasing Limited (GPhL).
 *
 * Any possession or use (including but not limited to duplication, reproduction
 * and dissemination) of this software (in either source or compiled form) is
 * forbidden except where an agreement with GPhL that permits such possession or
 * use is in force.
 *
 */
package co.gphl.beamline.v2_unstable.domain_types;

public enum ChemicalElement {

    // N.B. sulfur, aluminium and caesium are IUPAC spellings
    // For the latest IUPAC periodic table see
    // http://iupac.org/reports/periodic_table/

    H("hydrogen"), HE("helium"), LI("lithium"), BE("beryllium"),
    B("boron"), C("carbon"), N("nitrogen"), O("oxygen"), F("fluorine"),
    NE("neon"), NA("sodium"), MG("magnesium"), AL("aluminium"),
    SI("silicon"), P("phosphorus"), S("sulfur"), CL("chlorine"),
    AR("argon"), K("potassium"), CA("calcium"), SC("scandium"),
    TI("titanium"), V("vanadium"), CR("chromium"), MN("manganese"),
    FE("iron"), CO("cobalt"), NI("nickel"), CU("copper"), ZN("zinc"),
    GA("gallium"), GE("germanium"), AS("arsenic"), SE("selenium"),
    BR("bromine"), KR("krypton"), RB("rubidium"), SR("strontium"),
    Y("yttrium"), ZR("zirconium"), NB("niobium"), MO("molybdenum"),
    TC("technetium"), RU("ruthenium"), RH("rhodium"), PD("palladium"),
    AG("silver"), CD("cadmium"), IN("indium"), SN("tin"), SB("antimony"),
    TE("tellurium"), I("iodine"), XE("xenon"), CS("caesium"),
    BA("barium"), LA("lanthanum"), CE("cerium"), PR("praseodymium"),
    ND("neodymium"), PM("promethium"), SM("samarium"), EU("europium"),
    GD("gadolinium"), TB("terbium"), DY("dysprosium"), HO("holmium"),
    ER("erbium"), TM("thulium"), YB("ytterbium"), LU("lutetium"),
    HF("hafnium"), TA("tantalum"), W("tungsten"), RE("rhenium"),
    OS("osmium"), IR("iridium"), PT("platinum"), AU("gold"),
    HG("mercury"), TL("thallium"), PB("lead"), BI("bismuth"),
    PO("polonium"), AT("astatine"), RN("radon"), FR("francium"),
    RA("radium"), AC("actinium"), TH("thorium"), PA("protactinium"),
    U("uranium"),
    
    NP("neptunium"), PU("plutonium"), AM("americium"), CM("curium"),
    BK("berkelium"), CF("californium"), ES("einsteinium"), FM("fermium"),
    MD("mendelevium"), NO("nobelium"), LR("lawrencium"),
    RF("rutherfordium"), DB("dubnium"), SG("seaborgium"), BH("bohrium"),
    HS("hassium"), MT("meitnerium"), DS("darmstadtium"),
    RG("roentgenium"), CN("copernicium"), UUT("ununtrium"),
    FL("flerovium"), UUP("ununpentium"), LV("livermorium"),
    ;
    
    private String elementName;
    
    ChemicalElement(String elementName) {
        this.elementName = elementName;
    }

    public int atomicNumber() {
        return this.ordinal() + 1;
    }
    
    public String elementName() {
        return this.elementName;
    }
    
    public String symbol() {
        
        String name = this.name();
        if (name.length() == 1)
            return name;
        
        return name.charAt(0) + name.substring(1).toLowerCase();
    }
    
}

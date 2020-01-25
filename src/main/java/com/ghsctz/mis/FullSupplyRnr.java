package com.ghsctz.mis;

public class FullSupplyRnr {


    private int rnrid;
    private String supplyingfacility;
    private String productcode;
    private String productcategory;
    private String  product;
    private int periodid;
    private String processingperiodname;
    private int programid;
    private String programname;
    private int facilityid;
    private String facilityname;
    private String facilitycode;
    private int facilitytypeid;
    private String facilitytypename;
    private int zone_id;
    private String zonename;
    private int region_id;
    private String regionname;
    private int district_id;
    private String districtname;
    private int parent;
    private String  dispensingunit;
    private int  beginningbalance;
    private int  quantityreceived;
    private int  quantitydispensed;
    private int  stockinhand;
    private int  quantityapproved;
    private int  totallossesandadjustments;
    private int  minmonthsofstock;
    private int  maxmonthsofstock;
    private int  nominalmaxmonth;
    private int  amc;
    private boolean emergency;
    private int productcategoryid;
    private int productid;
    private String strength;
    private int packsize;
    private String dosageunitcode;
    private int normalizedconsumption;

    private String status;
    private boolean tracer;


    public FullSupplyRnr(int rnrid, String supplyingfacility, String productcode, String productcategory, String product,
                         int periodid, int programid, String programname, int facilityid, String facilityname,
                         String facilitycode, int facilitytypeid, String facilitytypename, int zone_id, String zonename,
                         int region_id, String regionname, int district_id, String districtname, int parent, String dispensingunit,
                         int beginningbalance, int quantityreceived, int quantitydispensed, int stockinhand, int quantityapproved,
                         int totallossesandadjustments, int minmonthsofstock, int maxmonthsofstock, int nominalmaxmonth, int amc,
                         boolean emergency, String processingperiodname, int productcategoryid, int productid, String strength,
                         int packsize, String dosageunitcode, int normalizedconsumption, String status, boolean tracer) {
        this.rnrid = rnrid;
        this.supplyingfacility = supplyingfacility;
        this.productcode = productcode;
        this.productcategory = productcategory;
        this.product = product;
        this.periodid = periodid;
        this.programid = programid;
        this.programname = programname;
        this.facilityid = facilityid;
        this.facilityname = facilityname;
        this.facilitycode = facilitycode;
        this.facilitytypeid = facilitytypeid;
        this.facilitytypename = facilitytypename;
        this.zone_id = zone_id;
        this.zonename = zonename;
        this.region_id = region_id;
        this.regionname = regionname;
        this.district_id = district_id;
        this.districtname = districtname;
        this.parent = parent;
        this.dispensingunit = dispensingunit;
        this.beginningbalance = beginningbalance;
        this.quantityreceived = quantityreceived;
        this.quantitydispensed = quantitydispensed;
        this.stockinhand = stockinhand;
        this.quantityapproved = quantityapproved;
        this.totallossesandadjustments = totallossesandadjustments;
        this.minmonthsofstock = minmonthsofstock;
        this.maxmonthsofstock = maxmonthsofstock;
        this.nominalmaxmonth = nominalmaxmonth;
        this.amc = amc;
        this.emergency = emergency;
        this.processingperiodname = processingperiodname;
        this.productcategoryid=productcategoryid;
        this.productid = productid;
        this.strength = strength;
        this.packsize = packsize;
        this.dosageunitcode=dosageunitcode;
        this.normalizedconsumption = normalizedconsumption;
        this.status=status;
        this.tracer=tracer;
    }



    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isTracer() {
        return tracer;
    }

    public void setTracer(boolean tracer) {
        this.tracer = tracer;
    }


    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }

    public int getPacksize() {
        return packsize;
    }

    public void setPacksize(int packsize) {
        this.packsize = packsize;
    }

    public String getDosageunitcode() {
        return dosageunitcode;
    }

    public void setDosageunitcode(String dosageunitcode) {
        this.dosageunitcode = dosageunitcode;
    }

    public int getNormalizedconsumption() {
        return normalizedconsumption;
    }

    public void setNormalizedconsumption(int normalizedconsumption) {
        this.normalizedconsumption = normalizedconsumption;
    }


    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }


    public int getProductcategoryid() {
        return productcategoryid;
    }

    public void setProductcategoryid(int productcategoryid) {
        this.productcategoryid = productcategoryid;
    }

    public String getProcessingperiodname() {
        return processingperiodname;
    }

    public void setProcessingperiodname(String processingperiodname) {
        this.processingperiodname = processingperiodname;
    }


    public String getSupplyingfacility() {
        return supplyingfacility;
    }

    public void setSupplyingfacility(String supplyingfacility) {
        this.supplyingfacility = supplyingfacility;
    }

    public String getProgramname() {
        return programname;
    }

    public void setProgramname(String programname) {
        this.programname = programname;
    }

    public String getFacilityname() {
        return facilityname;
    }

    public void setFacilityname(String facilityname) {
        this.facilityname = facilityname;
    }

    public String getFacilitycode() {
        return facilitycode;
    }

    public void setFacilitycode(String facilitycode) {
        this.facilitycode = facilitycode;
    }

    public int getFacilitytypeid() {
        return facilitytypeid;
    }

    public void setFacilitytypeid(int facilitytypeid) {
        this.facilitytypeid = facilitytypeid;
    }

    public String getFacilitytypename() {
        return facilitytypename;
    }

    public void setFacilitytypename(String facilitytypename) {
        this.facilitytypename = facilitytypename;
    }

    public String getZonename() {
        return zonename;
    }

    public void setZonename(String zonename) {
        this.zonename = zonename;
    }

    public String getRegionname() {
        return regionname;
    }

    public void setRegionname(String regionname) {
        this.regionname = regionname;
    }

    public String getDistrictname() {
        return districtname;
    }

    public void setDistrictname(String districtname) {
        this.districtname = districtname;
    }

    public boolean isEmergency() {
        return emergency;
    }

    public void setEmergency(boolean emergency) {
        this.emergency = emergency;
    }

    public String getProductcode() {
        return productcode;
    }

    public void setProductcode(String productcode) {
        this.productcode = productcode;
    }
    public int getRnrid() {
        return rnrid;
    }


    public String getProductcategory() {
        return productcategory;
    }

    public void setProductcategory(String productcategory) {
        this.productcategory = productcategory;
    }


    public void setRnrid(int rnrid) {
        this.rnrid = rnrid;
    }



    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getPeriodid() {
        return periodid;
    }

    public void setPeriodid(int periodid) {
        this.periodid = periodid;
    }

    public int getProgramid() {
        return programid;
    }

    public void setProgramid(int programid) {
        this.programid = programid;
    }

    public int getFacilityid() {
        return facilityid;
    }

    public void setFacilityid(int facilityid) {
        this.facilityid = facilityid;
    }

    public int getZone_id() {
        return zone_id;
    }

    public void setZone_id(int zone_id) {
        this.zone_id = zone_id;
    }

    public int getRegion_id() {
        return region_id;
    }

    public void setRegion_id(int region_id) {
        this.region_id = region_id;
    }

    public int getDistrict_id() {
        return district_id;
    }

    public void setDistrict_id(int district_id) {
        this.district_id = district_id;
    }

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    public String getDispensingunit() {
        return dispensingunit;
    }

    public void setDispensingunit(String dispensingunit) {
        this.dispensingunit = dispensingunit;
    }

    public int getBeginningbalance() {
        return beginningbalance;
    }

    public void setBeginningbalance(int beginningbalance) {
        this.beginningbalance = beginningbalance;
    }

    public int getQuantityreceived() {
        return quantityreceived;
    }

    public void setQuantityreceived(int quantityreceived) {
        this.quantityreceived = quantityreceived;
    }

    public int getQuantitydispensed() {
        return quantitydispensed;
    }

    public void setQuantitydispensed(int quantitydispensed) {
        this.quantitydispensed = quantitydispensed;
    }

    public int getStockinhand() {
        return stockinhand;
    }

    public void setStockinhand(int stockinhand) {
        this.stockinhand = stockinhand;
    }

    public int getQuantityapproved() {
        return quantityapproved;
    }

    public void setQuantityapproved(int quantityapproved) {
        this.quantityapproved = quantityapproved;
    }

    public int getTotallossesandadjustments() {
        return totallossesandadjustments;
    }

    public void setTotallossesandadjustments(int totallossesandadjustments) {
        this.totallossesandadjustments = totallossesandadjustments;
    }

    public int getMinmonthsofstock() {
        return minmonthsofstock;
    }

    public void setMinmonthsofstock(int minmonthsofstock) {
        this.minmonthsofstock = minmonthsofstock;
    }

    public int getMaxmonthsofstock() {
        return maxmonthsofstock;
    }

    public void setMaxmonthsofstock(int maxmonthsofstock) {
        this.maxmonthsofstock = maxmonthsofstock;
    }

    public int getNominalmaxmonth() {
        return nominalmaxmonth;
    }

    public void setNominalmaxmonth(int nominalmaxmonth) {
        this.nominalmaxmonth = nominalmaxmonth;
    }

    public int getAmc() {
        return amc;
    }

    public void setAmc(int amc) {
        this.amc = amc;
    }

    public FullSupplyRnr() {
    }


}

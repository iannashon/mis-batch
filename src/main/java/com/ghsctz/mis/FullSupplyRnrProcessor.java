package com.ghsctz.mis;

import org.springframework.batch.item.ItemProcessor;

public class FullSupplyRnrProcessor  implements ItemProcessor<FullSupplyRnr, FullSupplyRnr>{

    @Override
    public FullSupplyRnr process(final FullSupplyRnr fullSupplyRnr) throws Exception {
        final int rnrid = fullSupplyRnr.getRnrid();
        final int district_id = fullSupplyRnr.getDistrict_id();
        final int region_id = fullSupplyRnr.getRegion_id();
        final int zone_id = fullSupplyRnr.getZone_id();
        final int periodid = fullSupplyRnr.getPeriodid();
        final int programid = fullSupplyRnr.getProgramid();
        final int amc = fullSupplyRnr.getAmc();
        final int beginningbalance = fullSupplyRnr.getBeginningbalance();
        final int maxmonthsofstock = fullSupplyRnr.getMaxmonthsofstock();
        final int minmonthsofstock = fullSupplyRnr.getMinmonthsofstock();
        final int nominalmaxmonth = fullSupplyRnr.getNominalmaxmonth();
        final int quantityapproved = fullSupplyRnr.getQuantityapproved();
        final int parent = fullSupplyRnr.getParent();
        final int stockinhand = fullSupplyRnr.getStockinhand();
        final int totallossesandadjustments = fullSupplyRnr.getTotallossesandadjustments();
        final int quantitydispensed = fullSupplyRnr.getQuantitydispensed();
        final String product = fullSupplyRnr.getProduct();
        final int facilityid = fullSupplyRnr.getFacilityid();
        final String dispensingunit = fullSupplyRnr.getDispensingunit();
        final int quantityreceived = fullSupplyRnr.getQuantityreceived();
        final String productcategory = fullSupplyRnr.getProductcategory();
        final String supplyingFacility = fullSupplyRnr.getSupplyingfacility();
        final String productcode = fullSupplyRnr.getProductcode();
        final String programname = fullSupplyRnr.getProgramname();
        final String facilityname = fullSupplyRnr.getFacilityname();
        final String facilitycode = fullSupplyRnr.getFacilitycode();
        final int facilitytypeid = fullSupplyRnr.getFacilitytypeid();
        final String facilitytypename = fullSupplyRnr.getFacilitytypename();
        final String zonename = fullSupplyRnr.getZonename();
        final String regionname = fullSupplyRnr.getRegionname();
        final String districtname = fullSupplyRnr.getDistrictname();
        final boolean emergency = fullSupplyRnr.isEmergency();
        final String processingperiodname = fullSupplyRnr.getProcessingperiodname();
        final int productcategoryid =fullSupplyRnr.getProductcategoryid();
        final int productid=fullSupplyRnr.getProductid();
        final String strength= fullSupplyRnr.getStrength();
        final int packsize = fullSupplyRnr.getPacksize();
        final String dosageunitcode= fullSupplyRnr.getDosageunitcode();
        final int normalizedconsumption = fullSupplyRnr.getNormalizedconsumption();
        final String status=fullSupplyRnr.getStatus();
        final boolean tracer = fullSupplyRnr.isTracer();



        return new FullSupplyRnr(rnrid, supplyingFacility, productcode, productcategory, product, periodid, programid,
                programname, facilityid, facilityname, facilitycode, facilitytypeid, facilitytypename, zone_id, zonename,
                region_id, regionname, district_id, districtname, parent, dispensingunit, beginningbalance, quantityreceived,
                quantitydispensed, stockinhand, quantityapproved, totallossesandadjustments, minmonthsofstock, maxmonthsofstock,
                nominalmaxmonth, amc, emergency, processingperiodname, productcategoryid, productid,  strength,
         packsize,  dosageunitcode,  normalizedconsumption,status, tracer);
    }
}

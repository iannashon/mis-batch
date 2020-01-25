package com.ghsctz.mis;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.*;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {


    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;



    @Bean
    ItemReader<FullSupplyRnr> reader(@Qualifier("openlmisDb") DataSource dataSource) {
        JdbcCursorItemReader<FullSupplyRnr> databaseReader = new JdbcCursorItemReader<>();

        databaseReader.setDataSource(dataSource);
        databaseReader.setSql("select gz.region_name as supplyingfacility ,rli.rnrid, rli.productcode, rli.productcategory, rli.product, r.periodid, \n" +
                "                r.programid, pr.name as programname, r.facilityid, f.name as facilityname, f.code as facilitycode, f.typeid as facilitytypeid,\n" +
                "                ft.name as facilitytypename, gz.zone_id, gz.zone_name as zonename, gz.region_id,gz.region_name as regionname,\n" +
                "                 gz.district_id,gz.district_name as districtname,\n" +
                "                 gz.parent, rli.dispensingunit, beginningbalance, quantityreceived, quantitydispensed,\n" +
                "                 stockinhand, quantityapproved, totallossesandadjustments,\n" +
                "                 coalesce(fap.minmonthsofstock, 0) , fap.maxmonthsofstock,  rli.amc, r.emergency, pp.name as processingperiodname," +
                "                 pgp.productcategoryid as productcategoryid, ft.nominalmaxmonth as nominalmaxmonth, p.id as productid , p.strength,\n" +
                "                 rli.packsize,  ds.code,  rli.normalizedconsumption, r.status, p.tracer \n" +
                "                 from requisition_line_items rli\n" +
                "                 join requisitions r on r.id = rli.rnrid\n" +
                "                 join facilities f on f.id=r.facilityid\n" +
                "                 JOIN facility_types ft ON ft.id = f.typeid\n" +
                "                 JOIN programs pr on pr.id=r.programid\n" +
                "                 JOIN processing_periods pp on pp.id=r.periodid\n" +
                "                 join vw_districts gz on gz.district_id = f.geographiczoneid\n" +
                "                 join products p on p.code=rli.productcode\n" +
                "                 JOIN dosage_units ds ON ds.id = p.dosageunitid" +
                "                 JOIN program_products pgp ON r.programid = pgp.programid AND p.id = pgp.productid\n" +
                "                 JOIN facility_approved_products fap ON ft.id = fap.facilitytypeid AND fap.programproductid = pgp.id\n" +
                "                 where r.status in ('IN_APPROVAL', 'RELEASED', 'APPROVED', 'RELEASED_NO_ORDER') and rli.skipped=false and p.fullsupply=true \n");

        databaseReader.setRowMapper(new BeanPropertyRowMapper<>(FullSupplyRnr.class));

        return databaseReader;
    }


    private Map<String, Order> sortByModifiedDate() {
        Map<String, Order> sortConfiguration = new HashMap<>();
        sortConfiguration.put("modifieddate", Order.DESCENDING);
        return sortConfiguration;
    }

    @Bean
    public FullSupplyRnrProcessor processor() {
        return new FullSupplyRnrProcessor();
    }


    @Bean
    public JdbcBatchItemWriter<FullSupplyRnr> writer(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<FullSupplyRnr>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("INSERT INTO requisition_line_items_report ( rnrid, productcode, productcategory, product, periodid, programid, \n" +
                        "            programname, facilityid, facilityname, facilitycode, facility_type_id, \n" +
                        "            facilitytypename, supplyingfacility, zone_id, zonename, region_id, \n" +
                        "            regionname, district_id, districtname, parent, dispensingunit, \n" +
                        "            beginningbalance, quantityreceived, quantitydispensed, stockinhand, \n" +
                        "            quantityapproved, totallossesandadjustments, minmonthsofstock, \n" +
                        "            maxmonthsofstock, amc, emergency, processingperiodname, productcategoryid, nominalmaxmonth, productid," +
                        "            strength, packsize,  dosageunitcode,  normalizedconsumption, status, tracer) VALUES" +
                        " ( :rnrid, :productcode, :productcategory, :product, :periodid, :programid, \n" +
                        "            :programname, :facilityid, :facilityname, :facilitycode, :facilitytypeid, \n" +
                        "            :facilitytypename, :supplyingfacility, :zone_id, :zonename, :region_id, \n" +
                        "            :regionname, :district_id, :districtname, :parent, :dispensingunit, \n" +
                        "            :beginningbalance, :quantityreceived, :quantitydispensed, :stockinhand, \n" +
                        "            :quantityapproved, :totallossesandadjustments, :minmonthsofstock, \n" +
                        "            :maxmonthsofstock, :amc, :emergency, :processingperiodname, :productcategoryid, :nominalmaxmonth, :productid," +
                        "            :strength, :packsize,  :dosageunitcode,  :normalizedconsumption, :status, :tracer)")
                .dataSource(dataSource)
                .build();
    }


    @Bean
    public Job importRequisitions(JobCompletionNotificationListener listener, Step step1) {
        return jobBuilderFactory.get("importUserJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step1)
                .end()
                .build();
    }

    @Bean
    public Step step1(JdbcBatchItemWriter<FullSupplyRnr> writer, DataSource dataSource) {
        return stepBuilderFactory.get("step1")
                .<FullSupplyRnr, FullSupplyRnr> chunk(10)
                .reader(reader(dataSource))
                .processor(processor())
                .writer(writer)
                .build();
    }
}


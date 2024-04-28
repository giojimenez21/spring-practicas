package com.jasper.reports.service.impl;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.jasper.reports.entities.Pet;
import com.jasper.reports.service.PdfService;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class PdfServiceImpl implements PdfService {
    @Override
    public byte[] exportPets(List<Pet> listPets) throws FileNotFoundException, JRException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("petsData", new JRBeanCollectionDataSource(listPets));
        JasperPrint report = JasperFillManager.fillReport(
            JasperCompileManager.compileReport(ResourceUtils.getFile("classpath:petsReport.jrxml").getAbsolutePath()), 
            params, 
            new JREmptyDataSource()
        );
        byte[] reportFinal = JasperExportManager.exportReportToPdf(report);
        return reportFinal;
    }

}

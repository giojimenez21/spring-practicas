package com.jasper.reports.service;

import java.io.FileNotFoundException;
import java.util.List;

import com.jasper.reports.entities.Pet;

import net.sf.jasperreports.engine.JRException;

public interface PdfService {
    public byte[] exportPets(List<Pet> listPets)  throws FileNotFoundException, JRException;
}

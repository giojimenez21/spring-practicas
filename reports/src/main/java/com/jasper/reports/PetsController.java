package com.jasper.reports;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jasper.reports.entities.Pet;
import com.jasper.reports.service.PdfService;

import jakarta.validation.Valid;
import net.sf.jasperreports.engine.JRException;

import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("api/pets")
public class PetsController {
    @Autowired
    private PdfService pdfService;

    @PostMapping("/export-to-pdf")
    public ResponseEntity<byte[]> exportToPdf(@RequestBody @Valid List<Pet> pets) throws FileNotFoundException, JRException {
        byte[] reportPets = pdfService.exportPets(pets);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("petsReport", "petsReport.pdf");
        return ResponseEntity.ok().headers(headers).body(reportPets);
    }
}

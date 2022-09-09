package com.example.demo.services;

import com.example.demo.entities.Conversion;
//import lombok.var;
import com.example.demo.models.ConversionDTO;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.fit.pdfdom.PDFDomTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

//import org.w3c.dom.Document;
import org.w3c.dom.Document;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import com.example.demo.repositories.IConversionRepository;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.UUID;


//import com.aspose.pdf.*;

@Service
@Slf4j
public class ConversionService implements IConversionService {

    @Autowired
    private  IConversionRepository conversionRepository;


    @Override
    public Flux<Conversion> getConversions() {

        return conversionRepository.findAll();

    }

    @Override
    public Mono<Conversion> createConversion(@RequestBody ConversionDTO conversionDTO)  {

        var conversion = new Conversion();
//        Path _dataDir = Paths.get("/home/admin1/pdf-examples/Samples");
//        // Open the source PDF document
//        Document pdfDocument = new Document(_dataDir + "PDFToHTML.pdf");
//
//        // Save the file into MS document format
//        pdfDocument
//        pdfDocument.save(_dataDir + "output_out.html", SaveFormat.Html);

//// load the PDF file using PDFBox
////        File f = new File("C:/Users/mohd.khan/Downloads/");
////        log.info(f.getAbsolutePath());
//        log.info("Hello World");
//        PDDocument pdf = PDDocument.load(new File("C:/Users/mohd.khan/Pictures/cow.pdf"));
//        log.info(pdf.toString());
//// create the DOM parser
//        PDFDomTree parser = new PDFDomTree();
//// parse the file and get the DOM Document
//        Document dom = parser.createDOM(pdf);
//       // log.info(dom.toString());
//
//
//        log.info(dom.toString());


//        PDDocument pdf = PDDocument.load(new File("C:/Users/mohd.khan/Pictures/Sample/cow.pdf"));
//        Writer output = new PrintWriter("C:/Users/mohd.khan/Pictures/Sample/pdf.html", "utf-8");
        try
        {


            FileUtils.copyURLToFile(new URL(conversionDTO.getPdfUrl()),new File("C:/Users/mohd.khan/Pictures/Sample/SW.pdf"));
            PDDocument pdf = PDDocument.load(new File("C:/Users/mohd.khan/Pictures/Sample/SW.pdf"));
            Writer output = new PrintWriter(conversionDTO.getConvertedPath());
            new PDFDomTree().writeText(pdf, output);

            output.close();
        }
        catch(IOException e){
            throw new RuntimeException(e);
        }




        Date dt = new Date();

        conversion.setConversionId(UUID.randomUUID().toString());
        conversion.setStatus("Converted");
        conversion.setPdfUrl(conversionDTO.getPdfUrl());
        conversion.setConvertedPath(conversionDTO.getConvertedPath());
        conversion.setCreatedTime(dt.toString());
        conversion.setModifiedTime(dt.toString());
        return conversionRepository.save(conversion);
    }


}

package com.example.demo.generatepdf;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.globalresponse.GlobalResponse;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CreatePdfController {

	@Autowired
	CreatePdfService createpdf;

	@PostMapping(name = "/generatepdf")
	public GlobalResponse createPdf(@RequestBody @Valid PdfRequest request) {

		GlobalResponse response = new GlobalResponse();
		byte[] byteArray = createpdf.createPdf(request);
		
		response.setData(byteArray);
		response.setMessage("Pdf Generated");
		response.setStatus(true);
	
		return response;
	}

}

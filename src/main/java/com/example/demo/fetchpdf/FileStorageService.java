package com.example.demo.fetchpdf;

import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.globalresponse.GlobalResponse;
import com.itextpdf.forms.PdfAcroForm;
import com.itextpdf.forms.fields.PdfFormField;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;

@Service
public class FileStorageService {

	public GlobalResponse storeFile(MultipartFile file) {

		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		GlobalResponse globalResponse = new GlobalResponse();
		PdfDataResponse pdfResponse = new PdfDataResponse();

		try {
			PdfReader reader = new PdfReader(fileName);
			PdfDocument document = new PdfDocument(reader);
			PdfAcroForm acroForm = PdfAcroForm.getAcroForm(document, false);
			Map<String, PdfFormField> fields = acroForm.getFormFields();

			pdfResponse.setFirstname(fields.get("firstname").getValueAsString());
			pdfResponse.setMiddlename(fields.get("middlename").getValueAsString());
			pdfResponse.setLastname(fields.get("lastname").getValueAsString());
			pdfResponse.setFatherfirstname(fields.get("ffirstname").getValueAsString());
			pdfResponse.setFathermiddlename(fields.get("fmiddlename").getValueAsString());
			pdfResponse.setFatherlastname(fields.get("flastname").getValueAsString());
			pdfResponse.setDob(fields.get("dob").getValueAsString());
			pdfResponse.setPobCityid(fields.get("pobCityId").getValueAsString());
			pdfResponse.setPobStateid(fields.get("pobStateId").getValueAsString());
			pdfResponse.setPan(fields.get("pan").getValueAsString());
			pdfResponse.setAddress(fields.get("address").getValueAsString());
			pdfResponse.setAddressStateid(fields.get("addressStateId").getValueAsString());
			pdfResponse.setAddressCityid(fields.get("addressCityId").getValueAsString());
			pdfResponse.setAddressPin(fields.get("addressPin").getValueAsString());
			pdfResponse.setEmail(fields.get("email").getValueAsString());
			pdfResponse.setPhone(fields.get("phone").getValueAsString());

			globalResponse.setData(pdfResponse);
			globalResponse.setMessage("Data Extracted");
			globalResponse.setStatus(true);

			document.close();
			reader.close();
		} catch (IOException ex) {
			throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
		}

		return globalResponse;
	}

}

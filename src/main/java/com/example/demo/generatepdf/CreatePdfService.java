package com.example.demo.generatepdf;

import java.io.Serializable;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.globalresponse.GlobalResponse;
import com.example.demo.model.City;
import com.example.demo.model.State;
import com.example.demo.repository.CityRepository;
import com.example.demo.repository.StateRepository;
import com.itextpdf.forms.PdfAcroForm;
import com.itextpdf.forms.fields.PdfButtonFormField;
import com.itextpdf.forms.fields.PdfFormField;
import com.itextpdf.forms.fields.PdfTextFormField;
import com.itextpdf.io.font.FontConstants;
import com.itextpdf.io.source.ByteArrayOutputStream;
import com.itextpdf.kernel.color.DeviceRgb;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.annot.PdfAnnotation;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.property.TextAlignment;

@Service
public class CreatePdfService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2227753213628505257L;

	@Autowired
	private CityRepository cityRepository;

	@Autowired
	private StateRepository stateRepository;

	public byte[] createPdf(PdfRequest request) {

		GlobalResponse globalResponse = new GlobalResponse();
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		try (PdfWriter writer = new PdfWriter(outputStream); PdfDocument pdf = new PdfDocument(writer);) {
			PageSize ps = PageSize.A4;
			pdf.setDefaultPageSize(ps);

			Document document = new Document(pdf);

			PdfFont font = PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);
			Paragraph head1 = new Paragraph("Applicant’s Identifying information:").setTextAlignment(TextAlignment.CENTER).setFontSize(18);
			head1.setFontColor(new DeviceRgb(226, 123, 53));
			head1.setFont(font);
			document.add(head1);

			Paragraph para2 = new Paragraph("Applicant's name:");
			para2.setMarginTop(20);
			para2.setFontSize(11);
			document.add(para2);

			PdfDocument pdfDocument = document.getPdfDocument();

			PdfAcroForm form = PdfAcroForm.getAcroForm(pdfDocument, true);

			PdfTextFormField firstnameField = PdfTextFormFieldFactory.createTextField(pdfDocument, new Rectangle(160, 733, 110, 15),
					"firstname", request.getFirstname());

			PdfTextFormField middlenameField = PdfTextFormFieldFactory.createTextField(pdfDocument, new Rectangle(280, 733, 110, 15),
					"middlename", request.getMiddlename());

			PdfTextFormField lastnameField = PdfTextFormFieldFactory.createTextField(pdfDocument, new Rectangle(400, 733, 110, 15),
					"lastname", request.getLastname());
			form.addField(firstnameField);
			form.addField(middlenameField);
			form.addField(lastnameField);

			Paragraph para3 = new Paragraph("Father’s Name :");
			para3.setMarginTop(3);
			para3.setFontSize(11);
			document.add(para3);

			PdfTextFormField ffirstnameField = PdfTextFormFieldFactory.createTextField(pdfDocument, new Rectangle(160, 711, 110, 15),
					"ffirstname", request.getFatherfirstname());

			PdfTextFormField fmiddlenameField = PdfTextFormFieldFactory.createTextField(pdfDocument, new Rectangle(280, 711, 110, 15),
					"fmiddlename", request.getFathermiddlename());

			PdfTextFormField flastnameField = PdfTextFormFieldFactory.createTextField(pdfDocument, new Rectangle(400, 711, 110, 15),
					"flastname", request.getFatherlastname());
			form.addField(ffirstnameField);
			form.addField(fmiddlenameField);
			form.addField(flastnameField);

			Paragraph para4 = new Paragraph("Date of Birth :");
			para4.setMarginTop(3);
			para4.setFontSize(11);
			document.add(para4);

			PdfTextFormField dob = PdfTextFormFieldFactory.createTextField(pdfDocument, new Rectangle(160, 689, 110, 15), "dob",
					request.getDob());
			form.addField(dob);

			Paragraph para5 = new Paragraph("Place of Birth :");
			para5.setMarginTop(3);
			para5.setFontSize(11);
			document.add(para5);

			PdfTextFormField pobStateId = PdfTextFormFieldFactory.createTextField(pdfDocument, new Rectangle(160, 900, 110, 15),
					"pobStateId", request.getBirthstateid().toString());
			pobStateId.setVisibility(PdfAnnotation.HIDDEN);

			PdfTextFormField addressStateId = PdfTextFormFieldFactory.createTextField(pdfDocument, new Rectangle(160, 900, 110, 15),
					"addressStateId", request.getAddressstateid().toString());
			pobStateId.setVisibility(PdfAnnotation.HIDDEN);

			PdfTextFormField addressCityId = PdfTextFormFieldFactory.createTextField(pdfDocument, new Rectangle(160, 900, 110, 15),
					"addressCityId", request.getAddresscityid().toString());
			pobStateId.setVisibility(PdfAnnotation.HIDDEN);

			PdfTextFormField pobCityId = PdfTextFormFieldFactory.createTextField(pdfDocument, new Rectangle(280, 900, 110, 15), "pobCityId",
					request.getBirthcityid().toString());
			pobCityId.setVisibility(PdfAnnotation.HIDDEN);

			Optional<State> optstatename = stateRepository.findById(request.getBirthstateid());
			State statename = optstatename.get();

			PdfTextFormField pobState = PdfTextFormFieldFactory.createTextField(pdfDocument, new Rectangle(160, 667, 110, 15), "pobState",
					statename.getStatename());

			Optional<City> optcityname = cityRepository.findById(request.getBirthcityid());
			City cityname = optcityname.get();

			PdfTextFormField pobCity = PdfTextFormFieldFactory.createTextField(pdfDocument, new Rectangle(280, 667, 110, 15), "pobCity",
					cityname.getCityname());

			form.addField(pobState);
			form.addField(pobCity);
			form.addField(addressStateId);
			form.addField(addressCityId);
			form.addField(pobStateId);
			form.addField(pobCityId);

			Paragraph para6 = new Paragraph("PAN# :");
			para6.setMarginTop(3);
			para6.setFontSize(11);
			document.add(para6);

			PdfTextFormField pan = PdfTextFormFieldFactory.createTextField(pdfDocument, new Rectangle(160, 645, 110, 15), "pan",
					request.getPancard());

			form.addField(pan);

			Paragraph head2 = new Paragraph("Contact Details:").setTextAlignment(TextAlignment.CENTER).setFontSize(18);
			head2.setFontColor(new DeviceRgb(226, 123, 53));
			head2.setMarginTop(30);
			head2.setFont(font);
			document.add(head2);

			Paragraph para7 = new Paragraph("Permanent Address :");
			para7.setMarginTop(20);
			para7.setFontSize(11);
			document.add(para7);

			PdfAcroForm form1 = PdfAcroForm.getAcroForm(pdfDocument, true);

			PdfTextFormField address = PdfTextFormFieldFactory.createTextField(pdfDocument, new Rectangle(160, 487, 160, 70), "address",
					request.getAddress());

			address.setMultiline(true);
			address.setScroll(true);

			Optional<State> optaddressstatename = stateRepository.findById(request.getAddressstateid());
			State addressstatename = optaddressstatename.get();

			PdfTextFormField addressState = PdfTextFormFieldFactory.createTextField(pdfDocument, new Rectangle(160, 465, 160, 15),
					"addressState", addressstatename.getStatename());

			Optional<City> optaddresscityname = cityRepository.findById(request.getAddresscityid());
			City addresscityname = optaddresscityname.get();

			PdfTextFormField addressCity = PdfTextFormFieldFactory.createTextField(pdfDocument, new Rectangle(340, 465, 160, 15),
					"addressCity", addresscityname.getCityname());

			PdfTextFormField addressPin = PdfTextFormFieldFactory.createTextField(pdfDocument, new Rectangle(160, 443, 160, 15),
					"addressPin", request.getAddresspincode());

			form1.addField(address);
			form1.addField(addressState);
			form1.addField(addressCity);
			form1.addField(addressPin);

			Paragraph para8 = new Paragraph("Email Address :");
			para8.setMarginTop(97);
			para8.setFontSize(11);
			document.add(para8);

			PdfTextFormField email = PdfTextFormFieldFactory.createTextField(pdfDocument, new Rectangle(160, 421, 160, 15), "email",
					request.getEmail());
			form1.addField(email);

			Paragraph para9 = new Paragraph("Phone :");
			para9.setMarginTop(3);
			para9.setFontSize(11);
			document.add(para9);

			PdfTextFormField phone = PdfTextFormFieldFactory.createTextField(pdfDocument, new Rectangle(160, 399, 160, 15), "phone",
					request.getPhone());

			phone.setFieldFlags(PdfFormField.FF_READ_ONLY);
			form1.addField(phone);

			PdfButtonFormField checkField = PdfFormField.createCheckBox(pdfDocument, new Rectangle(160, 365, 11, 11), "checkbox", "On",
					PdfFormField.TYPE_CHECK);
			checkField.setReadOnly(true);
			form.addField(checkField);

			Paragraph para10 = new Paragraph("I certify that the above information about me is accurate and true.");
			para10.setMarginTop(16);
			para10.setMarginLeft(140);
			para10.setFontSize(9);
			document.add(para10);

			Paragraph p = new Paragraph("Full Name                                                   Today's Date");
			p.setMarginLeft(140);
			p.setMarginTop(14);
			p.setFontSize(8);
			document.add(p);

			PdfTextFormField fullname = PdfTextFormFieldFactory.createTextField(pdfDocument, new Rectangle(170, 320, 130, 15), "fullname",
					request.getFirstname() + " " + request.getLastname());
			form1.addField(fullname);

			PdfTextFormField date = PdfTextFormFieldFactory.createTextField(pdfDocument, new Rectangle(320, 320, 140, 15), "date",
					new Date().toString());
			form1.addField(date);

			document.close();

		
		} catch (Exception e) {

			globalResponse.setData(null);
			globalResponse.setMessage("Unable to create Pdf");
			globalResponse.setStatus(false);

		}
		return outputStream.toByteArray();
	}
}

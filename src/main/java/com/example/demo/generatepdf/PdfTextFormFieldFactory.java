package com.example.demo.generatepdf;

import com.itextpdf.forms.fields.PdfFormField;
import com.itextpdf.forms.fields.PdfTextFormField;
import com.itextpdf.kernel.color.DeviceRgb;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;

public class PdfTextFormFieldFactory {

	private PdfTextFormFieldFactory() {

	}

	public static PdfTextFormField createTextField(PdfDocument doc, Rectangle rect, String name, String value) {

		PdfTextFormField textField = PdfFormField.createText(doc, rect, name, value);
		textField.setReadOnly(true);
		textField.setBackgroundColor(new DeviceRgb(226, 226, 226));

		return textField;

	}

}

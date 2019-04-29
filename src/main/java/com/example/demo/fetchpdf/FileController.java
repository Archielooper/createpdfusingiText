package com.example.demo.fetchpdf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.globalresponse.GlobalResponse;

@RestController
public class FileController {

	@Autowired
	private FileStorageService fileStorageService;

	@PostMapping("/uploadFile")
	public GlobalResponse uploadFile(@RequestParam("file") MultipartFile file) {
		return fileStorageService.storeFile(file);

	}
}
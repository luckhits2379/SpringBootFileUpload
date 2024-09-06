package com.ng.springboot.fileupload;

import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class FileUploadController {

	@PostMapping("/upload/")
	public ResponseEntity<String> uploadFile(MultipartFile file, HttpServletRequest request) throws IOException {

		if (!file.getContentType().equalsIgnoreCase("image/jpeg")) {

			return ResponseEntity.badRequest().body("Only JPEG is allowed");
		}

		byte[] bytArr = file.getBytes();

		FileOutputStream foi = new FileOutputStream(
				"/Users/nirmalgurjar/Documents/workspace-spring-tool-suite-4-4.24.0.RELEASE/SpringBootFileUpload/src/main/resources/static/"
						+ file.getOriginalFilename());
		foi.write(bytArr);
		foi.close();

		return ResponseEntity.ok("File Upload Successfully");

	}
}

package com.ng.springboot.fileupload;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.validation.Valid;

@Controller
public class ErrorHandlingController {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping("/error/")
	public ResponseEntity<Object> checkError(@Valid @RequestBody Error error, BindingResult result) {

		System.out.println("inside checkError");

		System.out.println(error);

		if (result.hasErrors()) {

			Map<String, List<String>> errorMap = new HashMap();

			for (FieldError e : result.getFieldErrors()) {

				if (!errorMap.containsKey(e.getObjectName())) {

					errorMap.put(e.getObjectName(), new LinkedList());
				}

				errorMap.get(e.getObjectName()).add(e.getDefaultMessage());
			}

			return ResponseEntity.badRequest().body(errorMap);
		}

		return ResponseEntity.accepted().body("All inputs are valid");

	}

}

package com.example.demo.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.example.demo.service.DocService;

import jakarta.websocket.server.PathParam;

@Controller
public class DocController {
	@Autowired
	private DocService ds;
	
	@GetMapping("/")
	public String index(Model m) {
		m.addAttribute("docs", ds.getAllDocs());
		return "index.jsp";
	}
	
	@PostMapping("/")
	public RedirectView inputImage(@RequestParam(value="image") MultipartFile image,RedirectAttributes r) {
		int n = ds.saveImage(image);
		if(n==0)
			r.addFlashAttribute("msg", "upload failed");
		else
			r.addFlashAttribute("msg", "uploaded succesfully");
		return new RedirectView("/");
	}
}

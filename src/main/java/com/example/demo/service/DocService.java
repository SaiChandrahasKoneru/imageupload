package com.example.demo.service;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Doc;
import com.example.demo.repository.DocRepository;

@Service
public class DocService {
	@Autowired
	private DocRepository dr;
	
	
	
	public int saveImage(MultipartFile mf) {
		try {
		 dr.save(new Doc(mf.getOriginalFilename(),mf.getContentType(),Base64.getEncoder().encodeToString(mf.getBytes())));
		}
		catch(Exception e) {
			System.out.println(e);
			return 0;
		}
		 return 1;
	}



	public List<Doc> getAllDocs() {
		return dr.findAll();
	}
	
	
}

package com.velox.itsm.controller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.velox.itsm.service.InventiveService;

@Controller
@RequestMapping("/Inventive")
public class InventiveController {

	@Autowired
	InventiveService inventiveService;
	
	
	@RequestMapping(value = { "/DownloadFile" }, method = RequestMethod.GET)
	public ResponseEntity<InputStreamResource> downloadFile(HttpServletRequest request) throws FileNotFoundException  {
		
		String filename1=request.getParameter("filename");
		System.out.println("filename1 "+filename1);
		ResponseEntity<InputStreamResource> responseEntity=null;
		String filename="C:\\SCM\\".concat(filename1);		
		System.out.println("filenamefilenamefilenamefilenamefilename "+filename);
		
		File file = new File(filename);
		boolean exist=file.exists();
		System.out.println("existornot: "+exist);
		if(exist!=true)
		{
			System.out.println("filename "+file.getName()+"**exist**"+exist);
			System.out.println("filenamefilename");
			request.setAttribute("FileExist", "NotFound");
		}
//		if (file.exists()) {
//		    System.out.println("File exists: " + filename);
//		} else {
//		    System.out.println("File does NOT exist: " + filename);
//		}
		System.out.println("filename "+file.getName()+"**exist**"+exist);
		InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
		
		

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
		headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
		headers.add("Pragma", "no-cache");
		headers.add("Expires", "0");

		 responseEntity = ResponseEntity.ok().headers(headers).contentLength(file.length())
				//.contentType(MediaType.parseMediaType("application/txt")).body(resource);
				.contentType(MediaType.APPLICATION_OCTET_STREAM).body(resource);

		 System.out.println("responseEntity****"+responseEntity);
		
		return responseEntity;
	}
	

//	  @RequestMapping(value = { "/Exportdata" }, method = RequestMethod.GET)
//	    public ResponseEntity<FileSystemResource> exportData(HttpServletRequest request) {
//	        String filePath = "C:\\SCM\\ExportAllData";
//	  //      String filename = request.getParameter("filename");
//	        String filename = "ExportPO2024Feb21.xlsx2024Feb21.zip";
//	        System.out.println("filename888"+filename);
//	        File file = new File(filePath, filename);
//
//	        if (!file.exists()) {
//	            // Handle the case where the file does not exist
//	           
//	        }
//
//	        FileSystemResource resource = new FileSystemResource(file);
//
//	        HttpHeaders headers = new HttpHeaders();
//	        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + file.getName()); // Here we use only the file name
//	        headers.add(HttpHeaders.CACHE_CONTROL, "no-cache, no-store, must-revalidate");
//	        headers.add(HttpHeaders.PRAGMA, "no-cache");
//	        headers.add(HttpHeaders.EXPIRES, "0");
//
//	        return ResponseEntity.ok()
//	                .headers(headers)
//	                .contentLength(file.length())
//	                .contentType(MediaType.APPLICATION_OCTET_STREAM)
//	                .body(resource);
//	    }
	
	
	@RequestMapping(value = { "/Exportdata" }, method = RequestMethod.GET)
	public ResponseEntity<FileSystemResource> exportData(HttpServletRequest request) {
		String filename = request.getParameter("filename");

		String excelFilePath = "C:\\SCM\\ExportAllData\\"+filename; // Path to the Excel file
	    String filename2 = filename.replace(".xlsx", "");

	    String zipFilePath = "C:\\SCM\\ExportAllData\\"+filename2+".zip"; // Path for the ZIP file
	    System.out.println("zippspfd "+zipFilePath);
	    
	    try {
	        // Create a zip output stream
	        FileOutputStream fos = new FileOutputStream(zipFilePath);
	        ZipOutputStream zipOut = new ZipOutputStream(fos);

	        // Add the Excel file to the zip archive
	        File fileToZip = new File(excelFilePath);
	        FileInputStream fis = new FileInputStream(fileToZip);
	        ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
	        zipOut.putNextEntry(zipEntry);

	        // Write the Excel file content to the zip output stream
	        byte[] bytes = new byte[1024];
	        int length;
	        while ((length = fis.read(bytes)) >= 0) {
	            zipOut.write(bytes, 0, length);
	        }

	        // Close the input stream and the zip entry
	        fis.close();
	        zipOut.closeEntry();

	        // Close the zip output stream
	        zipOut.close();

	        // Prepare the file system resource for the zip file
	        File zipFile = new File(zipFilePath);
	        FileSystemResource resource = new FileSystemResource(zipFile);

	        // Prepare HTTP headers
	        HttpHeaders headers = new HttpHeaders();
	        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + zipFile.getName());
	        headers.add(HttpHeaders.CACHE_CONTROL, "no-cache, no-store, must-revalidate");
	        headers.add(HttpHeaders.PRAGMA, "no-cache");
	        headers.add(HttpHeaders.EXPIRES, "0");

	        // Return the response entity with the zip file
	        return ResponseEntity.ok()
	                .headers(headers)
	                .contentLength(zipFile.length())
	                .contentType(MediaType.APPLICATION_OCTET_STREAM)
	                .body(resource);
	    } catch (IOException e) {
	        e.printStackTrace();
	        // Handle the exception if needed
	        return (ResponseEntity<FileSystemResource>) ResponseEntity.ok();
	    }
	}
	
	
	@RequestMapping(value = { "/DownloadRFPFile" }, method = RequestMethod.GET)
	public ResponseEntity<InputStreamResource> DownloadRFPFile(HttpServletRequest request) throws FileNotFoundException  {
		
		String filename1=request.getParameter("filename");
		System.out.println("filename1 "+filename1);
		ResponseEntity<InputStreamResource> responseEntity=null;
		String filename="C:\\SCM\\ComplianceFileUpload\\".concat(filename1);		
		System.out.println("filenamefilenamefilenamefilenamefilename "+filename);
		
		File file = new File(filename);
		boolean exist=file.exists();
		System.out.println("existornot: "+exist);
		if(exist!=true)
		{
			System.out.println("filename "+file.getName()+"**exist**"+exist);
			System.out.println("filenamefilename");
			request.setAttribute("FileExist", "NotFound");
		}
//		if (file.exists()) {
//		    System.out.println("File exists: " + filename);
//		} else {
//		    System.out.println("File does NOT exist: " + filename);
//		}
		System.out.println("filename "+file.getName()+"**exist**"+exist);
		InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
		headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
		headers.add("Pragma", "no-cache");
		headers.add("Expires", "0");

		 responseEntity = ResponseEntity.ok().headers(headers).contentLength(file.length())
				//.contentType(MediaType.parseMediaType("application/txt")).body(resource);
				.contentType(MediaType.APPLICATION_OCTET_STREAM).body(resource);

		 System.out.println("responseEntity****"+responseEntity);
		
		return responseEntity;
	}
	
	
	
	// Single invoice file
	@RequestMapping(value = { "/DownloadInvoiceFile" }, method = RequestMethod.GET)
	public ResponseEntity<InputStreamResource> DownloadInvoiceFile(HttpServletRequest request) throws FileNotFoundException  {
		
		String filename1=request.getParameter("filename");
		System.out.println("filename1 "+filename1);
		ResponseEntity<InputStreamResource> responseEntity=null;
		String filename="C:\\SCM\\PO_Invoice\\".concat(filename1);		
		System.out.println("filenamefilenamefilenamefilenamefilename "+filename);
		
		File file = new File(filename);
		boolean exist=file.exists();
		System.out.println("existornot: "+exist);
		if(exist!=true)
		{
			System.out.println("filename "+file.getName()+"**exist**"+exist);
			System.out.println("filenamefilename");
			request.setAttribute("FileExist", "NotFound");
		}

		System.out.println("filename "+file.getName()+"**exist**"+exist);
		InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
		headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
		headers.add("Pragma", "no-cache");
		headers.add("Expires", "0");

		 responseEntity = ResponseEntity.ok().headers(headers).contentLength(file.length())
				//.contentType(MediaType.parseMediaType("application/txt")).body(resource);
				.contentType(MediaType.APPLICATION_OCTET_STREAM).body(resource);

		 System.out.println("responseEntity****"+responseEntity);
		
		return responseEntity;
	}
	
	
	// Multiple invoice files 
	@RequestMapping(value = { "/DownloadInvoiceFiles" }, method = RequestMethod.GET)
	public ResponseEntity<InputStreamResource> DownloadInvoiceFiles(HttpServletRequest request) {
	    String filenamesParam = request.getParameter("filename");
	    System.out.println("Received filenames: " + filenamesParam);
	    
//	    if (filenamesParam == null || filenamesParam.isEmpty()) {
//	        return ResponseEntity.badRequest()
//	                .body(new InputStreamResource(new ByteArrayInputStream(new byte[0])));
//	    }

	    String[] filenames = filenamesParam.split(",");
	    String basePath = "C:\\SCM\\PO_Invoice\\";
	    
	    try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
	         ZipOutputStream zipOut = new ZipOutputStream(baos)) {
	        
	        boolean anyFileAdded = false;
	        
	        for (String filename : filenames) {
	            String trimmedName = filename.trim();
	            File file = new File(basePath + trimmedName);
	            
	            if (file.exists()) {
	                anyFileAdded = true;
	                ZipEntry zipEntry = new ZipEntry(trimmedName);
	                zipOut.putNextEntry(zipEntry);
	                
	                try (FileInputStream fis = new FileInputStream(file)) {
	                    byte[] buffer = new byte[1024];
	                    int length;
	                    while ((length = fis.read(buffer)) > 0) {
	                        zipOut.write(buffer, 0, length);
	                    }
	                }
	                zipOut.closeEntry();
	            } else {
	                System.out.println("File not found: " + trimmedName);
	            }
	        }
	        
//	        if (!anyFileAdded) {
//	            request.setAttribute("FileExist", "NotFound");
//	            return ResponseEntity.notFound()
//	                    .body(new InputStreamResource(new ByteArrayInputStream(new byte[0])));
//	        }
	        
	        zipOut.finish();
	        
	        byte[] zipBytes = baos.toByteArray();
	        InputStreamResource resource = new InputStreamResource(new ByteArrayInputStream(zipBytes));
	        
	        HttpHeaders headers = new HttpHeaders();
	        headers.add("Content-Disposition", "attachment; filename=\"invoices.zip\"");
	        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
	        headers.add("Pragma", "no-cache");
	        headers.add("Expires", "0");
	        
	        return ResponseEntity.ok()
	                .headers(headers)
	                .contentLength(zipBytes.length)
	                .contentType(MediaType.APPLICATION_OCTET_STREAM)
	                .body(resource);
	        
	    } catch (IOException e) {
	        System.out.println("Error creating zip file: " + e.getMessage());
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                .body(new InputStreamResource(new ByteArrayInputStream(new byte[0])));
	    }
	}
	
}
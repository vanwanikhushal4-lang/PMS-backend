package in.co.velox.fileSending.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import in.co.velox.fileSending.service.AgentCommunication;
import in.co.velox.fileSending.service.FileService;
//import javassist.bytecode.Descriptor.Iterator;

@Controller
@RequestMapping(value = "/")
public class AppController {

	@Autowired
	FileService fservice;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam("username") String uname, @RequestParam("password") String pass,
			HttpSession session) {
		if (uname.equals(System.getenv("SCM_FILE_TRANSFER_USER")) && pass.equals(System.getenv("SCM_FILE_TRANSFER_PASSWORD"))) {

			session.setAttribute("username", uname);
			return "CreateFiles";
		} else {
			return "Home";
		}

	}

	@RequestMapping(value = "/LOGOUT", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("username");
		return "Home";
	}

	@RequestMapping(value = { "/send" }, method = RequestMethod.GET)
	public String sendFiles(ModelMap model) {
		System.out.println("Inside UploadEnggData method");

		return "CreateFiles";
	}

	@RequestMapping(value = { "/sendFile" }, method = RequestMethod.POST)
	public String sendFilesMode(@RequestParam("file_name") MultipartFile empPic,
			@RequestParam("bytesC") String byteValue, @RequestParam("DestF") String destFP, HttpServletRequest req,
			HttpServletResponse res, ModelMap countMap) throws Exception {
		long count = 0;
//		PrintWriter out=null;

		System.out.println("Inside UploadEnggData method");

		System.out.println("File NAmeeeeeeee " + empPic.getOriginalFilename());

		System.out.println("File NAmeeeeeeee " + empPic);

		System.out.println("Byte Value" + byteValue);
		String temp = null;
		File serverFile = null;
		String rootPath = null;
		String myFileFileName = empPic.getOriginalFilename();
		String values = "";
		try {
//			out=res.getWriter();
			try {
				String imagefilePath;
				imagefilePath = "D:\\Temp123\\";
				File file1 = new File(imagefilePath);
				if (!file1.exists()) {
					if (file1.mkdir()) {
						System.out.println("Directory is created!");
					} else {
						System.out.println("Failed to create directory!");
					}
				}
			} catch (Exception e) {
				System.out.println("directory create exception" + e);
			}
			try {
				byte[] bytes = empPic.getBytes();

				// Creating the directory to store file
				rootPath = "D:\\VeloxTemp\\";
				File dir = new File(rootPath + File.separator);
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				temp = dir.getAbsolutePath() + File.separator + empPic.getOriginalFilename();
				System.out.println(dir.getAbsolutePath() + File.separator + empPic.getOriginalFilename());
				serverFile = new File(dir.getAbsolutePath() + File.separator + empPic.getOriginalFilename());
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();
				count = fservice.processData(temp, byteValue, destFP);

				File f1 = new File(temp);
				boolean status = f1.delete();

				System.out.println("Deleted :" + status);
//				out.print(count);

			} catch (Exception e) {
				System.out.println("Exception in FIle Create:" + e);
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		countMap.addAttribute("count", count);

		return "CreateFiles";
	}

	@RequestMapping(value = { "/send2" }, method = RequestMethod.GET)
	public String sendFiles2(ModelMap model) {
		System.out.println("Inside sendFiles2 method");

		return "SessionFileAssign";
	}

	@RequestMapping(value = { "/getFilesMethod" }, method = RequestMethod.POST)
	public String getFilesMethod(ModelMap model, @RequestParam("totalF") String tfiles,
			@RequestParam("sessionF") String dfiles, @RequestParam("DestiF") String dLocation,
			@RequestParam("MSIFL") String MSIFL, @RequestParam("MSIL") String MSIL, @RequestParam("time") int interval,
			@RequestParam("command") String command) {
		System.out.println("Inside getFilesMethod");

		try {
			JSONArray send = new JSONArray();

//			Reading JSON			

			File tempFile = new File("C:\\Session.json");
			boolean exists = tempFile.exists();

			if (exists) {
				JSONParser parser1 = new JSONParser();
				JSONArray b = (JSONArray) parser1.parse(new FileReader("C:\\Session.json"));

				for (Object o : b) {
					JSONObject obj2 = (JSONObject) o;
					JSONObject obj3 = new JSONObject();

					obj3.put("SourceLocation", obj2.get("SourceLocation").toString());
					obj3.put("TotalPacketFiles", Integer.parseInt(obj2.get("TotalPacketFiles").toString()));
					obj3.put("IsFile", obj2.get("IsFile").toString());
					obj3.put("TotalSessionFiles", Integer.parseInt(obj2.get("TotalSessionFiles").toString()));
					obj3.put("DestLocation", obj2.get("DestLocation").toString());
					obj3.put("IsFileCommand", obj2.get("IsFileCommand").toString());
					obj3.put("TimeInterval", Integer.parseInt(obj2.get("TimeInterval").toString()));
					obj3.put("PacketSize", Integer.parseInt(obj2.get("PacketSize").toString()));
					obj3.put("MSIFolderLocation", obj2.get("MSIFolderLocation").toString());
					obj3.put("Hash", obj2.get("Hash").toString());
					obj3.put("MSILocation", obj2.get("MSILocation").toString());

					send.add(obj3);

				}

			}

			JSONObject obj = new JSONObject();
			obj.put("TotalPacketFiles", Integer.parseInt(tfiles));
			obj.put("TotalSessionFiles", Integer.parseInt(dfiles));
			obj.put("PacketSize", 1024);
			obj.put("SourceLocation", "D:\\sptemp\\");
			obj.put("DestLocation", dLocation);
			obj.put("MSIFolderLocation", MSIFL);
			obj.put("MSILocation", MSIL);
			obj.put("TimeInterval", interval);
			obj.put("Hash", "ABABABABA");
			obj.put("IsFileCommand", command);
			obj.put("IsFile", "true");

			send.add(obj);

			try (FileWriter file = new FileWriter("C:\\Session.json")) {

				file.write(send.toJSONString());
				file.flush();

			} catch (IOException e) {
				e.printStackTrace();
			}

			System.out.println("Successfully Copied JSON Object to File...");
			System.out.println("JSON Object: " + obj);

		} catch (Exception e) {
			System.out.println("Exception in FIle Create:" + e);
			e.printStackTrace();
		}

		return "SessionFileAssign";
	}

	@RequestMapping(value = { "/addCommand" }, method = RequestMethod.GET)
	public String addCommands(ModelMap model) {
		System.out.println("Inside addCommands method");

		return "AddCommand";
	}

	@RequestMapping(value = { "/addCommandSuccess" }, method = RequestMethod.POST)
	public String addCommandSuccess(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("Inside addCommandSuccess method");

		String command = req.getParameter("command");
		String time = req.getParameter("time");

		System.out.println("COmmand :" + command);
		System.out.println("Timeout :" + time);

		String temp[] = command.split(",");
		String tempTime[] = time.split(",");

		System.out.println("Temp Array:" + temp);

		JSONArray send = new JSONArray();

		for (int i = 0; i < temp.length; i++) {
			JSONObject obj = new JSONObject();
			obj.put("Command", temp[i]);
			obj.put("Timeout", tempTime[i]);
			obj.put("IsFile", "false");

			send.add(obj);
		}

		try (FileWriter file = new FileWriter("C:\\Commands.json")) {

			file.write(send.toJSONString());
			file.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Send Data: " + send);
		return "AddCommand";
	}

	@RequestMapping(value = { "/bulkUpload" }, method = RequestMethod.GET)
	public String bulkUpload(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("Inside bulkUpload method");

		return "BulkUpload";
	}

	@RequestMapping(value = { "/bulkUploadFile" }, method = RequestMethod.POST)
	public String readBulkFile(@RequestParam("bulkFile") MultipartFile empPic, HttpServletRequest req,
			HttpServletResponse res) {
		System.out.println("Inside readBulkFile method");

		String temp = null;
		File serverFile = null;
		String rootPath = null;
		String myFileFileName = empPic.getOriginalFilename();
		String values = "";

		JSONArray finalDataArray = new JSONArray();

		try {
			byte[] bytes = empPic.getBytes();

			// Creating the directory to store file
			rootPath = "D:\\BulkTemp\\";
			File dir = new File(rootPath + File.separator);
			if (!dir.exists())
				dir.mkdirs();

			// Create the file on server
			temp = dir.getAbsolutePath() + File.separator + empPic.getOriginalFilename();
			System.out.println(dir.getAbsolutePath() + File.separator + empPic.getOriginalFilename());
			serverFile = new File(dir.getAbsolutePath() + File.separator + empPic.getOriginalFilename());
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
			stream.write(bytes);
			stream.close();

//			FIle Creation Completed

//			Reading File

			InputStream ExcelFileToRead = new FileInputStream(
					dir.getAbsolutePath() + File.separator + empPic.getOriginalFilename());
			XSSFWorkbook wb = new XSSFWorkbook(ExcelFileToRead);
			XSSFWorkbook test = new XSSFWorkbook();
			XSSFSheet sheet = wb.getSheetAt(0);
			XSSFRow row;
			XSSFCell cell;
			Iterator rows = sheet.rowIterator();
			while (rows.hasNext()) {
				JSONObject obj = new JSONObject();
				row = (XSSFRow) rows.next();
				Iterator cells = row.cellIterator();
				while (cells.hasNext()) {
					cell = (XSSFCell) cells.next();

//	            	System.out.println("Cell number"+cell.getColumnIndex());
					if (row.getRowNum() == 0) {

					} else {

						if (cell.getColumnIndex() == 0) {
							obj.put("IPADDRESS", cell.getStringCellValue());
//	                		System.out.println("Column1"+cell.getStringCellValue()+" ");
						}
						if (cell.getColumnIndex() == 1) {
							obj.put("ATMID", cell.getStringCellValue());
//	                		System.out.println("Column2"+cell.getStringCellValue()+" ");
						}
					}
				}
				if (row.getRowNum() == 0) {

				} else {
					finalDataArray.add(obj);
				}
//				System.out.println();
			}

			try (FileWriter file = new FileWriter("C:\\IP_Details.json")) {

				file.write(finalDataArray.toJSONString());
				file.flush();

			} catch (IOException e) {
				e.printStackTrace();
			}

			System.out.println("Final Array" + finalDataArray);

			File f1 = new File(temp);
			boolean status = f1.delete();

			System.out.println("Deleted :" + status);

		} catch (Exception e) {
			System.out.println("Exception in FIle Create:" + e);
			e.printStackTrace();
		}

		return "BulkUpload";
	}

	@RequestMapping(value = { "/sendCommand" }, method = RequestMethod.GET)
	public String sendCommand(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("Inside sendCommand method");

		return "SendCommands";
	}

	@RequestMapping(value = { "/getIp" }, method = RequestMethod.POST)
	public String getIp(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("Inside getIp method");

		PrintWriter out = null;

		try {
			out = res.getWriter();
			JSONParser parser = new JSONParser();
			JSONArray a = (JSONArray) parser.parse(new FileReader("C:\\IP_Details.json"));
			String ip = "";

			for (Object o : a) {
				JSONObject obj = (JSONObject) o;

				String name = (String) obj.get("IPADDRESS");
//				System.out.println(name);
				ip += name + ",";

			}
			out.print(ip);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}

		return "SendCommands";
	}

	@RequestMapping(value = { "/getCommands" }, method = RequestMethod.POST)
	public String getCommands(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("Inside getCommands method");

		PrintWriter out = null;

		try {
			out = res.getWriter();
			JSONParser parser = new JSONParser();
			JSONArray send = new JSONArray();
			JSONArray a = (JSONArray) parser.parse(new FileReader("C:\\Commands.json"));
			String ip = "";

			for (Object o : a) {
				JSONObject obj = (JSONObject) o;
				JSONArray data1 = new JSONArray();

				String name = (String) obj.get("Command");
				System.out.println(name);
				ip += name + ",";
				data1.add(name);
				send.add(data1);
			}
			out.print(send);
			System.out.println(send);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}

		return "SendCommands";
	}

	@RequestMapping(value = { "/getDataFortype" }, method = RequestMethod.GET)
	public String getDataFortype(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("Inside getDataFortype method");

		PrintWriter out = null;
		String type = req.getParameter("type");

		if (type.equalsIgnoreCase("file")) {

			try {
				out = res.getWriter();
				JSONParser parser = new JSONParser();
				JSONArray a = (JSONArray) parser.parse(new FileReader("C:\\Session.json"));
				String ip = "";

				for (Object o : a) {
					JSONObject obj = (JSONObject) o;

					String name = (String) obj.get("DestLocation");
					System.out.println(name);
					ip += name + ",";

				}
				out.print(ip);

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				out.close();
			}

		} else {

			try {
				out = res.getWriter();
				JSONParser parser = new JSONParser();
				JSONArray a = (JSONArray) parser.parse(new FileReader("C:\\Commands.json"));
				String ip = "";

				for (Object o : a) {
					JSONObject obj = (JSONObject) o;

					String name = (String) obj.get("Command");
					System.out.println(name);
					ip += name + ",";

				}
				out.print(ip);

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				out.close();
			}
		}

		return "SendCommands";
	}

	@RequestMapping(value = { "/generateFinalJson" }, method = RequestMethod.POST)
	public String generateFinalJson(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("Inside generateFinalJson method");

		JSONArray send = new JSONArray();

		String type = req.getParameter("type");
		String typeValue = req.getParameter("typeVal");
		String ips = req.getParameter("ip");
		
//		System.out.println("##" + type);
//		System.out.println("###" + typeValue);

		String type1[] = type.split(",");
		String typeValue1[] = typeValue.split(",");
		String ips1[]=ips.split(",");
		
		System.out.println("##" + type1);
		System.out.println("###" + typeValue1);
		System.out.println("####" + ips1);
		
		for (int i = 0; i < type1.length; i++) {
			if (type1[i].toString().equalsIgnoreCase("file")) {

				try {
					System.out.println("Inside File");
					JSONParser parser = new JSONParser();
					JSONArray a = (JSONArray) parser.parse(new FileReader("C:\\Session.json"));
					String ip = "";

					for (Object o : a) {
						JSONObject obj = (JSONObject) o;

						String name = (String) obj.get("DestLocation");
						System.out.println("Name: " + name);

						if (name.equalsIgnoreCase(typeValue1[i])) {

							System.out.println("Obejct MAtch");
							JSONObject data1 = new JSONObject();

							data1.put("SourceLocation", obj.get("SourceLocation").toString());
							data1.put("IsFile", obj.get("IsFile").toString());
							data1.put("TotalPacketFiles", Integer.parseInt(obj.get("TotalPacketFiles").toString()));
							data1.put("TotalSessionFiles", Integer.parseInt(obj.get("TotalSessionFiles").toString()));
							data1.put("PacketSize", Integer.parseInt(obj.get("PacketSize").toString()));
							data1.put("DestLocation", obj.get("DestLocation").toString());
							data1.put("MSIFolderLocation", obj.get("MSIFolderLocation").toString());
							data1.put("MSILocation", obj.get("MSILocation").toString());
							data1.put("TimeInterval", Integer.parseInt(obj.get("TimeInterval").toString()));
							data1.put("Hash", obj.get("Hash").toString());
							data1.put("IsFileCommand", obj.get("IsFileCommand").toString());

							send.add(data1);
						}

					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (type1[i].toString().equalsIgnoreCase("command")) {

				try {
					System.out.println("Inside Command");
					JSONParser parser1 = new JSONParser();
					JSONArray b = (JSONArray) parser1.parse(new FileReader("C:\\Commands.json"));
					String ip = "";

					for (Object o : b) {
						JSONObject obj1 = (JSONObject) o;

						String name = (String) obj1.get("Command");
						System.out.println("Name :" + name);
						if (name.equalsIgnoreCase(typeValue1[i])) {

							System.out.println("Obejct MAtch Command");
							JSONObject data2 = new JSONObject();

							data2.put("Command", obj1.get("Command").toString());
							data2.put("IsFile", obj1.get("IsFile").toString());
							send.add(data2);
						}

					}

				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}
		
		JSONArray ipArray=new JSONArray();
		
		
		for(int k=0;k<ips1.length;k++) {
			JSONObject ipObject=new JSONObject();
			String tempIP=ips1[k].toString();
			ipObject.put("IPADDRESS", ips1[k]);
			ipArray.add(ipObject);
		}
		
		
		
		try (FileWriter file = new FileWriter("C:\\ScanPlusTSS.json")) {

			file.write(send.toJSONString());
			file.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try (FileWriter file = new FileWriter("C:\\SelectedIp.json")) {

			file.write(ipArray.toJSONString());
			file.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}		
		
		AgentCommunication com = null;

		try {
			
			com = new AgentCommunication("192.168.0.8", 10103);
			String response = com.requestFor(ipArray.toString()+"=" + send.toString());
			System.out.println("Response from server :"+response);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return "SendCommands";
	}

}

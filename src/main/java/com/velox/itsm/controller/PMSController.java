package com.velox.itsm.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.velox.itsm.service.PmsService;

@Controller
@RequestMapping("/PMS")
public class PMSController {

	@Autowired
	PmsService pmsService;

//	@RequestMapping(value = { "/UpdateProfile" }, method = RequestMethod.GET)
//	public String UpdateProfile(ModelMap model) {
//
//		return "/UpdateProfile";
//	}
//	

	@RequestMapping(value = { "/getProjectDetails" }, method = RequestMethod.POST)
	public JSONArray getProjectDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;
		String sname = null;

		try {
			out = response.getWriter();

//			String partnerprojectname = request.getParameter()

			JSONArray final_response = pmsService.getAssigneProjectNames();

			System.out.println("MastersControllerrrr reponse isnnnnnnnnn = " + final_response);

			out.print(final_response);

			System.out.println("SITE NAME GET SUCCESS" + final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		return null;

	}

	@RequestMapping(value = { "/getProjectNameDetails" }, method = RequestMethod.POST)
	public JSONArray getProjectNameDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;
		String sname = null;

		try {
			out = response.getWriter();

//			String partnerprojectname = request.getParameter()

			JSONArray final_response = pmsService.getProjectNames();

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("SITE NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		return null;

	}

	// Mayur Chnages 03/24
	// Requirement Docs RD get Function Names
	@RequestMapping(value = { "/getNameDetails" }, method = RequestMethod.POST)
	public JSONArray getNameDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;
		String sname = null;
		try {
			out = response.getWriter();
//			String moduleName = request.getParameter("mNameup");
			// System.out.println("ticketype:::"+location);
			JSONArray final_response = pmsService.getNameDetails();

			out.print(final_response);

			// System.out.println("SITE NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;
	}

	/// In RD Get get Designation Name Details
	@RequestMapping(value = { "/getDesignationNameDetails" }, method = RequestMethod.POST)
	public JSONArray getDesignationNameDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;
		String sname = null;
		try {
			out = response.getWriter();
//			String moduleName = request.getParameter("mNameup");
			// System.out.println("ticketype:::"+location);
			JSONArray final_response = pmsService.getDesignationNameDetails();

			out.print(final_response);

			// System.out.println("SITE NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;
	}

	/// Get User Name in RD
	@RequestMapping(value = { "/getUserNameDetails" }, method = RequestMethod.POST)
	public JSONArray getUserNameDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;
		String sname = null;
		try {
			out = response.getWriter();
			String desigName = request.getParameter("userName");
			// System.out.println("ticketype:::"+location);
			JSONArray final_response = pmsService.getUserNameDetails(desigName);

			out.print(final_response);

			// System.out.println("SITE NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;
	}

	/// Onchange Event on UserID
	@RequestMapping(value = { "/getUserId" }, method = RequestMethod.POST)
	public JSONArray getUserId(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;
		String sname = null;
		try {
			out = response.getWriter();
			String userid = request.getParameter("userID");
			// System.out.println("ticketype:::"+location);
			JSONArray final_response = pmsService.getUserId(userid);

			out.print(final_response);

			// System.out.println("SITE NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;
	}

	// RD Create
	@RequestMapping(value = { "/saveNewRD" }, method = RequestMethod.POST)
	public String saveNewRD(@RequestParam("uploadRDFile") MultipartFile[] rdFile,
			@RequestParam("maskedFile") MultipartFile[] maskedPOFile, HttpServletRequest request,
			HttpServletResponse response, HttpSession session, @RequestParam("scopeofWork") MultipartFile[] ScopeWork,
			@RequestParam("RFPFile") MultipartFile[] RFPFile, @RequestParam("otherFile") MultipartFile[] otherFile) {
		PrintWriter out = null;

		try {
			HttpSession htt = request.getSession(true);
			String poNumber = request.getParameter("poNumber");
			String producSuiteNames = request.getParameter("producSuiteNames");
			String Securitytool = request.getParameter("Securitytool");
			String ProdManager = request.getParameter("ProdManager");
			String functionName = request.getParameter("functionName");
			String noteType = request.getParameter("noteType");
			String userid = request.getParameter("userid");
			String username = request.getParameter("username");
			String uname = (String) htt.getAttribute("username");

			System.out.println("rdFile rdFile rdFile " + rdFile);

			out = response.getWriter();
			out.print(pmsService.saveNewRD(rdFile, maskedPOFile, poNumber, producSuiteNames, Securitytool, ProdManager,
					functionName, noteType, username, userid, uname, ScopeWork, RFPFile, otherFile));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
		return null;
	}

	// UD Create
	// UD Create
	@RequestMapping(value = { "/saveNewUD" }, method = RequestMethod.POST)
	public JSONArray saveNewUD(@RequestParam("fileInput") MultipartFile[] udFile,
			@RequestParam("otherFileInput") MultipartFile[] otherFile, ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session, String alldata) {
		PrintWriter out = null;

		try {
			out = response.getWriter();

			HttpSession htt = request.getSession(true);
			String poNumber = request.getParameter("poNumber");
			String producSuiteNames = request.getParameter("producSuiteNames");
			String Securitytool = request.getParameter("Securitytool");
			String ProdManager = request.getParameter("ProdManager");
			String functionName = request.getParameter("functionName");
			String noteType = request.getParameter("noteType");
			String userid = request.getParameter("userid");
			String username = request.getParameter("username");
			String uname = (String) htt.getAttribute("username");
			String Teamlead = request.getParameter("Teamlead");
			String note = request.getParameter("not");
			String Dev = request.getParameter("Dev");
			String rd_id = request.getParameter("rd_id");

			String projectdesc = request.getParameter("projectDesc");
			String projectobj = request.getParameter("projectObj");
			String projectscope = request.getParameter("projectScope");
			String funcreq = request.getParameter("funcReq");
			String nonfuncreq = request.getParameter("nonFuncReq");
			String techreq = request.getParameter("techReq");
			String startdate = request.getParameter("startDate");
			String enddate = request.getParameter("endDate");

			String final_response = pmsService.saveNewUD(udFile, otherFile, poNumber, producSuiteNames, Securitytool,
					ProdManager, functionName, noteType, userid, username, uname, Teamlead, note, Dev, rd_id,
					projectdesc, projectobj, projectscope, funcreq, nonfuncreq, techreq, startdate, enddate);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return null;
	}

	// 04
	/// In RD Get get Designation Name Details
	@RequestMapping(value = { "/getProjectHeadList" }, method = RequestMethod.POST)
	public JSONArray getProjectHeadList(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;
		String sname = null;
		try {
			out = response.getWriter();

			JSONArray final_response = pmsService.getProjectHeadList();

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;
	}

	// 04

	@RequestMapping(value = { "/SavePKMeeting" }, method = RequestMethod.POST)
	public String SavePKMeeting(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			@RequestParam("uploadMom") MultipartFile[] uploadMom,
			@RequestParam("planUploadMom") MultipartFile[] planUploadMom) {
		PrintWriter out = null;
		try {
			out = response.getWriter();
			HttpSession htt = request.getSession(true);
			String uname = (String) htt.getAttribute("username");
			String fullname = (String) htt.getAttribute("fullname");
			System.out.println("usernamemeeem login==" + uname);

			String crno = request.getParameter("crno");
			String tid = request.getParameter("uid");
			String projhead = request.getParameter("selectedprojectHead");
			String salemgr = request.getParameter("selectedSalesManager");

			String prodmgr = request.getParameter("selectedProductManager");
			String startdate = request.getParameter("startdate");
			String typeofmeet = request.getParameter("typeofmeet");
			String typeofrm = request.getParameter("selectedTypesRoom");
			String roomCapacity = request.getParameter("roomCapacity");
			String meetingResource = request.getParameter("meetingResource");
			String vpersonmeeting = request.getParameter("vpersonmeeting");
			String vpresourcemeeting = request.getParameter("vpresourcemeeting");
			String meetingTypes = request.getParameter("meetingTypes");
			String meetingTypesvideo = request.getParameter("meetingTypesvideo");
			String link = request.getParameter("link");
			String poNumber = request.getParameter("poNumber");
			

			String finals = pmsService.SavePKMeeting(uname, fullname, crno, tid, projhead, salemgr, prodmgr, startdate,
					typeofmeet, typeofrm, roomCapacity, meetingResource, vpersonmeeting, vpresourcemeeting,
					meetingTypes, meetingTypesvideo, uploadMom, planUploadMom, link, poNumber);
			out.print(finals);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

	// 1st Multichecbox Row

	// 4/1
	@RequestMapping(value = { "/getProjectHead" }, method = RequestMethod.POST)
	public JSONArray getProjectHead(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;
		String sname = null;
		try {
			out = response.getWriter();
//							String userid = request.getParameter("userID");
			// System.out.println("ticketype:::"+location);
			JSONArray final_response = pmsService.getProjectHead();

			out.print(final_response);

			// System.out.println("SITE NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;
	}

	@RequestMapping(value = { "/getSalesManager" }, method = RequestMethod.POST)
	public JSONArray getSalesManager(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;
		String sname = null;
		try {
			out = response.getWriter();
			JSONArray final_response = pmsService.getSalesManager();

			out.print(final_response);

			// System.out.println("SITE NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;
	}

	@RequestMapping(value = { "/getProductionManager" }, method = RequestMethod.POST)
	public JSONArray getProductionManager(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;
		String sname = null;
		try {
			out = response.getWriter();
			JSONArray final_response = pmsService.getProductionManager();

			out.print(final_response);

			// System.out.println("SITE NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;
	}

	@RequestMapping(value = { "/getroomdetails" }, method = RequestMethod.POST)
	public JSONArray getroomdetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;
		String sname = null;
		try {
			out = response.getWriter();
			JSONArray final_response = pmsService.getroomdetails();

			out.print(final_response);

			// System.out.println("SITE NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;
	}

	@RequestMapping(value = { "/Devpendingtask" }, method = RequestMethod.GET)
	public String Devpendingtask(ModelMap model) {

		return "Pms/Devpendingtask";

	}

	@RequestMapping(value = { "/pendingdevtask" }, method = RequestMethod.POST)
	public JSONArray pendingdevtask(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;

		try {
			out = response.getWriter();

			String uname = (String) session.getAttribute("username");
			String company = (String) session.getAttribute("usercompany");
			String userfullname = (String) session.getAttribute("fullname");

			JSONArray final_response = pmsService.pendingdevtask(uname, company, userfullname);

			System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			System.out.println("username GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;

	}

	@RequestMapping(value = { "/ViewDeveloperPendingDetails" }, method = RequestMethod.GET)
	public String ViewDeveloperPendingDetails(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("Inside ViewDeveloperPendingDetails method");

		String crno = request.getParameter("crno");
		String tid = request.getParameter("tid");

		return "Pms/ViewDeveloperPendingDetails";
	}

	@RequestMapping(value = { "/UdApprovedByMD" }, method = RequestMethod.GET)
	public String UdApprovedByMD(ModelMap model) {

		return "Pms/UdApprovedByMD";

	}

	@RequestMapping(value = { "/ViewUDDocuments" }, method = RequestMethod.POST)
	public JSONArray ViewUDDocuments(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;
		String sname = null;
		try {
			out = response.getWriter();
			JSONArray final_response = pmsService.ViewUDDocuments();

			out.print(final_response);

			// System.out.println("SITE NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;
	}

	// 09/24
	@RequestMapping(value = { "/ViewRdPendingDetailsMD" }, method = RequestMethod.POST)
	public void ViewRdPendingDetailsMD(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Inside ViewRdPendingDetailsMD method");

		String crno = request.getParameter("crno");
//			String tid = request.getParameter("tid");
//				int crno1=Integer.parseInt(crno);
		PrintWriter out = null;
		try {

			HttpSession htt = request.getSession(true);

			System.out.println("usernamemeeem login==" + crno);
//		            System.out.println("usernamemeeem login==" + tid);

			out = response.getWriter();
			JSONArray array = (JSONArray) pmsService.ViewRdPendingDetailsMD(crno);
			System.out.println("List value: " + array);
			out.print(array);
		} catch (Exception e) {
			System.out.println("Exception in ApprovalMDData method: " + e);
		}

	}

	@RequestMapping(value = { "/apprvlRdByMe" }, method = RequestMethod.POST)
	public JSONArray apprvlRdByMe(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside  revisedProposalPendingDetailsMD Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			JSONArray final_response = pmsService.apprvlRdByMe();

			System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		// return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/apprvlUdDocuments" }, method = RequestMethod.POST)
	public JSONArray apprvlUdDocuments(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside  apprvlUdDocuments Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			JSONArray final_response = pmsService.apprvlUdDocuments();

			System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		// return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/ViewUdPendingDetailsMD" }, method = RequestMethod.POST)
	public void ViewUdPendingDetailsMD(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Inside ViewUdPendingDetailsMD method");

		String crno = request.getParameter("crno");
		String uid = request.getParameter("uid");
//				int crno1=Integer.parseInt(crno);
		PrintWriter out = null;
		try {

			HttpSession htt = request.getSession(true);

			System.out.println("usernamemeeem login==" + crno);
//				System.out.println("usernamemeeem login==" + uid);

			out = response.getWriter();
			JSONArray array = (JSONArray) pmsService.ViewUdPendingDetailsMD(crno);
			System.out.println("List value: " + array);
			out.print(array);
		} catch (Exception e) {
			System.out.println("Exception in ApprovalMDData method: " + e);
		}

	}

	// 9/1
	// Save TaskDetails
	@RequestMapping(value = { "/saveTaskDetails" }, method = RequestMethod.POST)
	public JSONArray saveTaskDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session, String alldata) {
		PrintWriter out = null;

		try {
			out = response.getWriter();

			String PONumb = request.getParameter("PONumb");
			String date = request.getParameter("date");
			String customername = request.getParameter("customername");
			String productLicense = request.getParameter("productLicense");
			String ImplementorName = request.getParameter("ImplementorName");
			String ImplementorNumber = request.getParameter("ImplementorNumber");
			String cusImplementorEmail = request.getParameter("cusImplementorEmail");
			String SalesManagerName = request.getParameter("SalesManagerName");
			String EndCustomerName = request.getParameter("EndCustomerName");
			String EndCustomerNumber = request.getParameter("EndCustomerNumber");
			String paymentTermsPO = request.getParameter("paymentTermsPO");
			String description = request.getParameter("description");

			String final_response = pmsService.saveTaskDetails(PONumb, date, customername, productLicense,
					ImplementorName, ImplementorNumber, cusImplementorEmail, SalesManagerName, EndCustomerName,
					EndCustomerNumber, paymentTermsPO, description, alldata);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return null;
	}

	//
	@RequestMapping(value = { "/getImplemetorFORMData" }, method = RequestMethod.POST)
	public void getImplemetorFORMData(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Inside getPendingFORM3Data method");

		String crno = request.getParameter("crno");
		String tid = request.getParameter("tid");
//		int crno1=Integer.parseInt(crno);
		PrintWriter out = null;
		try {

			HttpSession htt = request.getSession(true);
			String uname = (String) htt.getAttribute("username");

			String fullname = (String) htt.getAttribute("fullname");
			System.out.println("usernamemeeem login==" + uname);
			System.out.println("usernamemeeem login==" + crno);
			System.out.println("usernamemeeem login==" + tid);

			out = response.getWriter();
			JSONArray array = (JSONArray) pmsService.getImplemetorFORMData(crno, uname, tid, fullname);
			System.out.println("List value: " + array);
			out.print(array);
		} catch (Exception e) {
			System.out.println("Exception in getAttachmentCSData method: " + e);
		}

	}

//		11/24
	@RequestMapping(value = { "/viewapprvlRdByMe" }, method = RequestMethod.POST)
	public void viewapprvlRdByMe(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Inside viewapprvlRdByMe method");

		String crno = request.getParameter("crno");
		System.out.println("controller Cr no : " + crno);

//				String tid = request.getParameter("tid");
//					int crno1=Integer.parseInt(crno);
		PrintWriter out = null;
		try {

			HttpSession htt = request.getSession(true);

			System.out.println("usernamemeeem login==" + crno);
//			            System.out.println("usernamemeeem login==" + tid);

			out = response.getWriter();
			JSONArray array = (JSONArray) pmsService.viewapprvlRdByMe(crno);
			System.out.println("List value: " + array);
			out.print(array);
		} catch (Exception e) {
			System.out.println("Exception in viewapprvlRdByMe method: " + e);
		}

	}

	// 11/24
	@RequestMapping(value = { "/UdApprovedByMD" }, method = RequestMethod.POST)
	public String ApprovedUDByMD(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside  ApprovedUDByMD Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();
			HttpSession htt = request.getSession(true);
			String uname = (String) htt.getAttribute("username");

			JSONArray final_response = pmsService.ApprovedUDByMD(uname);

			System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		// return "Dashboard";
		return null;

	}

//		11/24
	@RequestMapping(value = { "/ViewUdApprovedByMD" }, method = RequestMethod.POST)
	public void ViewUdApprovedByMD(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Inside ViewUdApprovedByMD method");

		String crno = request.getParameter("crno");
		System.out.println("controller Cr no : " + crno);

//				String tid = request.getParameter("tid");
//					int crno1=Integer.parseInt(crno);
		PrintWriter out = null;
		try {

			HttpSession htt = request.getSession(true);

			System.out.println("usernamemeeem login==" + crno);
//			            System.out.println("usernamemeeem login==" + tid);

			out = response.getWriter();
			JSONArray array = (JSONArray) pmsService.ViewUdApprovedByMD(crno);
			System.out.println("List value: " + array);
			out.print(array);
		} catch (Exception e) {
			System.out.println("Exception in ViewUdApprovedByMD method: " + e);
		}

	}

	// 12/24
	@RequestMapping(value = { "/RejectedCMDetails" }, method = RequestMethod.POST)
	public void RejectedCMDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside RejectedCMDetails method");

		PrintWriter out = null;
		try {

			String uname = (String) session.getAttribute("username");
			String company = (String) session.getAttribute("usercompany");
			System.out.println("usernamemeeem login==" + uname);

			out = response.getWriter();
			JSONArray array = (JSONArray) pmsService.RejectedCMDetails(uname, company);
			System.out.println("List value: " + array);
			out.print(array);
		} catch (Exception e) {
			System.out.println("Exception in RejectedCMDetails method: " + e);
		}

	}

	// implementor task data
	@RequestMapping(value = { "/getDevTaskData" }, method = RequestMethod.POST)
	public void getDevTaskData(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		// System.out.println("Inside getApprovaalSaleMngData method");

		String crno = request.getParameter("crno");
		String tid = request.getParameter("tid");
//					int crno1=Integer.parseInt(crno);
		PrintWriter out = null;
		try {

			HttpSession htt = request.getSession(true);
			String uname = (String) htt.getAttribute("username");
			System.out.println("usernamemeeem login==" + uname);
			System.out.println("usernamemeeem login==" + crno);
			System.out.println("usernamemeeem login==" + tid);

			out = response.getWriter();
			JSONArray array = (JSONArray) pmsService.getDevTaskData(crno, uname, tid);
			System.out.println("List value: " + array);
			out.print(array);
		} catch (Exception e) {
			System.out.println("Exception in getAttachmentCSData method: " + e);
		}

	}

//				15/24
	@RequestMapping(value = { "/getRdDetailsTable" }, method = RequestMethod.POST)
	public String getRdDetailsTable(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside  getRdDetailsTab@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			JSONArray final_response = pmsService.getRdDetailsTable();

			System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		// return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/getUdDetailsTable" }, method = RequestMethod.POST)
	public String getUdDetailsTable(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside  getUdDetailsTable ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			JSONArray final_response = pmsService.getUdDetailsTable();

			System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		// return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/getProjectKickMeetingTable" }, method = RequestMethod.POST)
	public String getProjectKickMeetingTable(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside  getProjectKickMeetingTable@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			JSONArray final_response = pmsService.getProjectKickMeetingTable();

			System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		// return "Dashboard";
		return null;

	}

//				16/24
	@RequestMapping(value = { "/ApproveRdDetailsByMD" }, method = RequestMethod.POST)
	public void ApproveRdDetailsByMD(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Inside ApproveRdDetailsByMD method");

		String crno = request.getParameter("crno");
		String status = request.getParameter("status");

		System.out.println("crno  " + crno);

		PrintWriter out = null;
		try {
//						HttpSession htt = request.getSession(true);

			out = response.getWriter();
			String result = pmsService.ApproveRdDetailsByMD(crno, status);
			System.out.println("Result value: " + result);
			out.print(result);
		} catch (Exception e) {
			System.out.println("Exception in Asave Company: " + e);
		}

	}

//				16/24
	@RequestMapping(value = { "/ApproveUDDetailsByMD" }, method = RequestMethod.POST)
	public void ApproveUDDetailsByMD(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Inside ApproveUDDetailsByMD method");

		PrintWriter out = null;
		try {
//						HttpSession htt = request.getSession(true);
			out = response.getWriter();
			String crno = request.getParameter("crno");
			String status = request.getParameter("status");

			HttpSession htt = request.getSession(true);
			String uname = (String) htt.getAttribute("username");
			String prodManager = request.getParameter("prodManager");

			String result = pmsService.ApproveUDDetailsByMD(crno, status, uname, prodManager);
			System.out.println("Result value: " + result);
			out.print(result);
		} catch (Exception e) {
			System.out.println("Exception in ApproveUDDetailsByMD: " + e);
		}

	}

	// 16
	@RequestMapping(value = { "/gettaskdetails" }, method = RequestMethod.POST)
	public JSONArray gettaskdetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;
		String sname = null;
		try {
			out = response.getWriter();
			JSONArray final_response = pmsService.gettaskdetails();

			out.print(final_response);

			// System.out.println("SITE NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;
	}

	// 16/1
	// Save Day wise Task Details
	@RequestMapping(value = { "/saveDayWiseTask" }, method = RequestMethod.POST)
	public JSONArray saveDayWiseTask(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session, String taskData) {
		PrintWriter out = null;

		try {
			out = response.getWriter();
			HttpSession htt = request.getSession(true);
			String userfullname = (String) session.getAttribute("fullname");
			System.out.println(" funame " + taskData);
			
			

			String final_response = pmsService.saveDayWiseTask(taskData, userfullname);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return null;
	}

	@RequestMapping(value = { "/saveMainTask" }, method = RequestMethod.POST)
	public JSONArray saveMainTask(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		PrintWriter out = null;

		try {
			out = response.getWriter();
			HttpSession htt = request.getSession(true);
			String uname = (String) htt.getAttribute("username");

			String functionName = request.getParameter("functionName");
			String moduleName = request.getParameter("moduleName");
			String responsibility = request.getParameter("responsibility");
			String managerName = request.getParameter("managerName");
			String teamLeader = request.getParameter("teamLeader");
			String developer = request.getParameter("developer");
			String startdate = request.getParameter("startdate");
			String enddate = request.getParameter("enddate");
			String inputRemark = request.getParameter("inputRemark");
			String description = request.getParameter("description");

			String final_response = pmsService.saveMainTask(functionName, moduleName, responsibility, managerName,
					teamLeader, developer, startdate, enddate, inputRemark, description);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return null;
	}

	// getDevTaskDetails

	@RequestMapping(value = { "/getDevTaskDetails" }, method = RequestMethod.POST)
	public JSONArray getDevTaskDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside @@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			HttpSession htt = request.getSession(true);
			String uname = (String) htt.getAttribute("username");
			JSONArray final_response = pmsService.getDevTaskDetails(uname);
			System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		return null;

	}

	// 17/1 Task Details
	@RequestMapping(value = { "/getDevAssignedTaskDetails" }, method = RequestMethod.POST)
	public JSONArray getDevAssignedTaskDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside @@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

				String crno = request.getParameter("crno");
			String tid = request.getParameter("tid");
			JSONArray final_response = pmsService.getDevAssignedTaskDetails( crno, tid);
			System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		return null;

	}

	// updateTaskStatus

	@RequestMapping(value = { "/updateTaskStatus" }, method = RequestMethod.POST)
	public String updateTaskStatus(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside @@@@@@@ ");
		PrintWriter out = null;
		String reStatus = null;

		try {
			out = response.getWriter();

//				HttpSession htt = request.getSession(true);
//				String uname = (String) htt.getAttribute("username");
			String userfullname = (String) session.getAttribute("fullname");
			String crno = request.getParameter("crno");
			String tid = request.getParameter("tid");
			String status = request.getParameter("Status");
			String remark = request.getParameter("Remark");
			String Manager_Name = request.getParameter("Manager_Name");
			String Team_Leader = request.getParameter("Team_Leader");
			String Developer = request.getParameter("Developer");
			String End_Date = request.getParameter("End_Date");
			reStatus = pmsService.updateTaskStatus(crno, tid, status, remark, Manager_Name, Team_Leader, Developer,
					End_Date, userfullname);
			System.out.println("Update reponse is = " + reStatus);

			out.print(reStatus);
			System.out.println("below status" + reStatus);

		} catch (Exception e) {
			e.printStackTrace();

		}

		return null;

	}

	// 18/1
	@RequestMapping(value = { "/getImplTaskList" }, method = RequestMethod.POST)
	public JSONArray getImplTaskList(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside @@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			HttpSession htt = request.getSession(true);
			String uname = (String) htt.getAttribute("username");
			String tStatus = request.getParameter("TStatus");

			System.out.println("js pend status " + tStatus);
			JSONArray final_response = pmsService.getImplTaskList(uname, tStatus);
			System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		return null;
	}

	// Impl task Details
	@RequestMapping(value = { "/ViewImplTaskDetails" }, method = RequestMethod.GET)
	public String ViewImplTaskDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Inside ViewImplTaskDetails method");

		String crno = request.getParameter("crno");
		String tid = request.getParameter("tid");

		return "Pms/ViewImplTaskDetails";
	}

	@RequestMapping(value = { "/ViewImplCompleteTaskDetails" }, method = RequestMethod.GET)
	public String ViewImplCompleteTaskDetails(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("Inside ViewImplCompleteTaskDetails method");

		String crno = request.getParameter("crno");
		String tid = request.getParameter("tid");

		return "Pms/ViewImplCompleteTaskDetails";
	}

	// get details Impl getDevAssignedTaskDetails
	@RequestMapping(value = { "/getImplTaskDetails" }, method = RequestMethod.POST)
	public JSONArray getImplTaskDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside @@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			HttpSession htt = request.getSession(true);
			String uname = (String) htt.getAttribute("username");
			String crno = request.getParameter("crno");
			String tid = request.getParameter("tid");
			JSONArray final_response = pmsService.getImplTaskDetails(uname, crno, tid);
			System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
		return null;

	}

//		18/24
	@RequestMapping(value = { "/pendingRdDocumentsBySI" }, method = RequestMethod.POST)
	public JSONArray pendingRdDocumentsBySI(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside  pendingRdDocumentsBySI Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			JSONArray final_response = pmsService.pendingRdDocumentsBySI();

			System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		// return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/ApproveRdDetailsBySI" }, method = RequestMethod.POST)
	public void ApproveRdDetailsBySI(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Inside ApproveRdDetailsBySI method");

		String crno = request.getParameter("crno");
		String status = request.getParameter("status");

		System.out.println("crno  " + crno);

		PrintWriter out = null;
		try {
//							HttpSession htt = request.getSession(true);

			out = response.getWriter();
			String result = pmsService.ApproveRdDetailsBySI(crno, status);
			System.out.println("Result value: " + result);
			out.print(result);
		} catch (Exception e) {
			System.out.println("Exception in ApproveRdDetailsBySI: " + e);
		}

	}

	@RequestMapping(value = { "/pendingUdDocumentsBySI" }, method = RequestMethod.POST)
	public JSONArray pendingUdDocumentsBySI(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside  pendingUdDocumentsBySI Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			JSONArray final_response = pmsService.pendingUdDocumentsBySI();

			System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		// return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/ApproveUDDetailsBySI" }, method = RequestMethod.POST)
	public void ApproveUDDetailsBySI(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Inside ApproveUDDetailsBySI method");

		String crno = request.getParameter("crno");
		String status = request.getParameter("status");

		System.out.println("crno  " + crno);

		PrintWriter out = null;
		try {
//							HttpSession htt = request.getSession(true);

			out = response.getWriter();
			String result = pmsService.ApproveUDDetailsBySI(crno, status);
			System.out.println("Result value: " + result);
			out.print(result);
		} catch (Exception e) {
			System.out.println("Exception in ApproveUDDetailsBySI: " + e);
		}

	}

	// 25/24
	@RequestMapping(value = { "/getPonumber" }, method = RequestMethod.POST)
	public JSONArray getPonumber(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;
		String sname = null;
		try {
			out = response.getWriter();
//				String Po_number=request.getParameter("docName");
			JSONArray final_response = pmsService.getPonumber();
			out.print(final_response);

			// System.out.println("SITE NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;
	}

	@RequestMapping(value = { "/getproducSuiteNames" }, method = RequestMethod.POST)
	public JSONArray getproducSuite(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;
		String sname = null;
		try {
			out = response.getWriter();
			String poNumber = request.getParameter("ponum");
			JSONArray final_response = pmsService.getproducSuite(poNumber);
			out.print(final_response);

			// System.out.println("SITE NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;
	}

	@RequestMapping(value = { "/getSecuritytool" }, method = RequestMethod.POST)
	public JSONArray getSecuritytool(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;
		String sname = null;
		try {
			out = response.getWriter();
			String producsuite = request.getParameter("suitname");
			JSONArray final_response = pmsService.getSecuritytool(producsuite);
			out.print(final_response);

			// System.out.println("SITE NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;
	}

	@RequestMapping(value = { "/getFunctionName" }, method = RequestMethod.POST)
	public JSONArray getFunctionName(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;
		String sname = null;
		try {
			out = response.getWriter();
			// String moduleName = request.getParameter("moduleName");
			// System.out.println("ticketype:::"+location);
			JSONArray final_response = pmsService.getFunctionName();

			out.print(final_response);

			// System.out.println("SITE NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;
	}

	@RequestMapping(value = { "/getselectrddetails" }, method = RequestMethod.POST)
	public JSONArray getselectrddetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;
		String sname = null;
		try {
			out = response.getWriter();
			String selectrddetails = request.getParameter("selectrddetails");
			// System.out.println("ticketype:::"+location);
			JSONArray final_response = pmsService.getselectrddetails(selectrddetails);

			out.print(final_response);

			// System.out.println("SITE NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;
	}

	@RequestMapping(value = { "/getRDDropdownValue" }, method = RequestMethod.POST)
	public JSONArray getRDDropdownValue(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;
		String sname = null;
		try {
			out = response.getWriter();
			// String moduleName = request.getParameter("moduleName");
			// System.out.println("ticketype:::"+location);
			JSONArray final_response = pmsService.getRDDropdownValue();

			out.print(final_response);

			// System.out.println("SITE NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;
	}

	@RequestMapping(value = { "/getimplformcdetails" }, method = RequestMethod.POST)
	public JSONArray getimplformcdetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;
		String sname = null;
		try {
			out = response.getWriter();
			String selectrddetails = request.getParameter("selectrddetails");
			// System.out.println("ticketype:::"+location);
			JSONArray final_response = pmsService.getimplformcdetails(selectrddetails);

			out.print(final_response);

			// System.out.println("SITE NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;
	}

	@RequestMapping(value = { "/ApprovedUDListImpl" }, method = RequestMethod.POST)
	public String ApprovedUDListImpl(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside  ApprovedUDByMD Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			HttpSession htt = request.getSession(true);
			String uname = (String) htt.getAttribute("username");

			JSONArray final_response = pmsService.ApprovedUDListImpl(uname);

			System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		// return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/getUDDetails" }, method = RequestMethod.POST)
	public JSONArray getUDDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside getUDDetails ");
		PrintWriter out = null;

		try {
			out = response.getWriter();
			HttpSession htt = request.getSession(true);
			String uname = (String) htt.getAttribute("username");
			String crno = request.getParameter("crno");
			String uid = request.getParameter("uid");
			System.out.println("Crradavud " + crno);
			JSONArray final_response = pmsService.getUDDetails(crno, uid, uname);

			System.out.println(" reponse is = " + final_response);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//			return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/ViewUdApprovedImpl" }, method = RequestMethod.GET)
	public String ViewUdApprovedImpl(ModelMap model) {

//			return "/Pms/PublishProject";
		return "/Pms/ProjectKickOfMeeting";
//			return "/Pms/ApprovedUDList";
	}

	// 30/1
	@RequestMapping(value = { "/getRDdetails" }, method = RequestMethod.POST)
	public JSONArray getRDdetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;
		String sname = null;
		try {
			out = response.getWriter();
			String uid = request.getParameter("uid");
			HttpSession htt = request.getSession(true);
			String uname = (String) htt.getAttribute("username");
			// System.out.println("ticketype:::"+location);
			JSONArray final_response = pmsService.getRDdetails(uid, uname);

			out.print(final_response);

			// System.out.println("SITE NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;
	}

//		30/24
	@RequestMapping(value = { "/submittedUdByMe" }, method = RequestMethod.POST)
	public String submittedUdByMe(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside  submittedUdByMe Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();
			HttpSession htt = request.getSession(true);
			String uname = (String) htt.getAttribute("username");

			JSONArray final_response = pmsService.submittedUdByMe(uname);

			System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		// return "Dashboard";
		return null;

	}

	// 31/1
	@RequestMapping(value = { "/rejectUDbyMD" }, method = RequestMethod.POST)
	public void rejectUDbyMD(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Inside rejectUDbyMD method");

		PrintWriter out = null;
		try {
			out = response.getWriter();
			HttpSession htt = request.getSession(true);
			String uname = (String) htt.getAttribute("username");
			String company = (String) htt.getAttribute("usercompany");
			System.out.println("usernamemeeem login==" + uname);
			System.out.println("company login==" + company);
			String crno = request.getParameter("crno");
			String rejectreason = request.getParameter("val");
			String SMnote = request.getParameter("SMnote");
			String tid = request.getParameter("tid");

			String result = pmsService.rejectUDbyMD(crno, company, rejectreason, SMnote, uname, tid);
			System.out.println("rejecte rejectUDbyMD Result : " + result);
			out.print(result);
		} catch (Exception e) {
			System.out.println("Exception rejectUDbyMD Company: " + e);
		}
	}

//		31/24
	@RequestMapping(value = { "/rejectedUdByMeDetails" }, method = RequestMethod.POST)
	public JSONArray rejectedUdByMeDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside  rejectedUdByMeDetails Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			JSONArray final_response = pmsService.rejectedUdByMeDetails();

			System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		// return "Dashboard";
		return null;

	}

//  31/1
	@RequestMapping(value = { "/getManagerByTool" }, method = RequestMethod.POST)
	public JSONArray getManagerByTool(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;
		String sname = null;
		try {
			out = response.getWriter();
			String poNumber = request.getParameter("poID");
			JSONArray final_response = pmsService.getManagerByTool(poNumber);
			out.print(final_response);

			// System.out.println("SITE NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;
	}

	// get masked po
	@RequestMapping(value = { "/getMaskedPOFile" }, method = RequestMethod.POST)
	public JSONArray getMaskedPOFile(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;
		String sname = null;
		try {
			out = response.getWriter();
			String poNumber = request.getParameter("poID");
			JSONArray final_response = pmsService.getMaskedPOFile(poNumber);
			out.print(final_response);

			// System.out.println("SITE NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		return null;
	}

	@RequestMapping(value = { "/getpmsdetails" }, method = RequestMethod.POST)
	public JSONArray getpmsdetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;

		try {
			out = response.getWriter();
			String Projectdata = request.getParameter("Projectdata");
			// System.out.println("ticketype:::"+location);
			JSONArray final_response = pmsService.getpmsdetails(Projectdata);

			out.print(final_response);

			System.out.println("SITE NAME GET SUCCESS" + final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;
	}

	// get getPonumber by projectname
	@RequestMapping(value = { "/getPoByCustomerName" }, method = RequestMethod.POST) //
	public JSONArray getPoByCustomerName(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;
		String sname = null;
		try {
			out = response.getWriter();
			String projName = request.getParameter("projName");
			JSONArray final_response = pmsService.getPoByCustomerName(projName);
			out.print(final_response);

			// System.out.println("SITE NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;
	}

//		5/2/24
	@RequestMapping(value = { "/getproductSuite" }, method = RequestMethod.POST)
	public JSONArray getproductSuite(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;
		String sname = null;
		try {
			out = response.getWriter();
//				String Po_number=request.getParameter("docName");
			JSONArray final_response = pmsService.getproductSuite();
			out.print(final_response);

			// System.out.println("SITE NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;
	}

	@RequestMapping(value = { "/getSecuritytoolName" }, method = RequestMethod.POST)
	public JSONArray getSecuritytoolName(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;
		String sname = null;
		try {
			out = response.getWriter();
			String producsuite = request.getParameter("suitname");
			JSONArray final_response = pmsService.getSecuritytoolName(producsuite);
			out.print(final_response);

			// System.out.println("SITE NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;
	}

	@RequestMapping(value = { "/getProductManagerByTool" }, method = RequestMethod.POST)
	public JSONArray getProductManagerByTool(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;
		String sname = null;
		try {
			out = response.getWriter();
			String suitname = request.getParameter("suitname");
			JSONArray final_response = pmsService.getProductManagerByTool(suitname);
			out.print(final_response);

			// System.out.println("SITE NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;
	}

	@RequestMapping(value = { "/getCustomerList" }, method = RequestMethod.POST)
	public JSONArray getCustomerList(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;
		String sname = null;
		try {
			out = response.getWriter();
			String suitname = request.getParameter("securityTool");
			JSONArray final_response = pmsService.getCustomerList(suitname);
			out.print(final_response);

			// System.out.println("SITE NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;
	}

//		7/2/24
	@RequestMapping(value = { "/scheduleMeetings" }, method = RequestMethod.POST)
	public JSONArray scheduleMeetings(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside  scheduleMeetings Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			JSONArray final_response = pmsService.scheduleMeetings();

			System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		return null;

	}

	@RequestMapping(value = { "/getScheduleMeetingData" }, method = RequestMethod.POST)
	public void getScheduleMeetingData(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Inside getScheduleMeetingData method");

		String crno = request.getParameter("crno");
		System.out.println("controller Cr no : " + crno);

//					String tid = request.getParameter("tid");
//						int crno1=Integer.parseInt(crno);
		PrintWriter out = null;
		try {

			HttpSession htt = request.getSession(true);

			System.out.println("usernamemeeem login==" + crno);
//				            System.out.println("usernamemeeem login==" + tid);

			out = response.getWriter();
			JSONArray array = (JSONArray) pmsService.getScheduleMeetingData(crno);
			System.out.println("List value: " + array);
			out.print(array);
		} catch (Exception e) {
			System.out.println("Exception in getScheduleMeetingData method: " + e);
		}

	}

	@RequestMapping(value = { "/ExportAllData" }, method = RequestMethod.POST)

	public void Exportallpurchaseorder(ModelMap model, HttpServletRequest req, HttpServletResponse res) {

		PrintWriter out = null;

		String tableName = req.getParameter("exportdata");
		String fromDate = req.getParameter("fromDate");
		String toDate = req.getParameter("toDate");

		System.out.println(fromDate + "  to dateeess " + toDate);
		try {
			out = res.getWriter();
			out.print(pmsService.Exportallpurchaseorder(tableName, fromDate, toDate));
		} catch (Exception exe) {
			exe.printStackTrace();
		} finally {
			out.close();
		}
	}

	@RequestMapping(value = { "/PiechartPMS" }, method = RequestMethod.POST)
	public JSONArray PiechartPMS(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside  scheduleMeetings Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();
			String uname = (String) session.getAttribute("username");
			String userfullname = (String) session.getAttribute("fullname");
			String role = (String) session.getAttribute("role");
			System.out.println("roletype of  reponse is = " + role);
			JSONArray final_response = pmsService.PiechartPMS(uname, userfullname, role);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
		return null;
	}

	@RequestMapping(value = { "/BarchartSCM" }, method = RequestMethod.POST)
	public JSONArray BarchartSCM(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside  BarchartSCM Controller  ");
		PrintWriter out = null;

		try {
			out = response.getWriter();
			String uname = (String) session.getAttribute("username");
			String userfullname = (String) session.getAttribute("fullname");
			String role = (String) session.getAttribute("role");

			System.out.println("roletype of chart = " + role);
			JSONArray final_response = pmsService.BarchartSCM(uname, userfullname, role);

			System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
		return null;

	}

	@RequestMapping(value = { "/getApprovePO" }, method = RequestMethod.POST)
	public JSONArray getApprovePO(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;
		String sname = null;
		try {
			out = response.getWriter();
			String approvePO = request.getParameter("approvePO");
			JSONArray final_response = pmsService.getApprovePO(approvePO);
			out.print(final_response);

			// System.out.println("SITE NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;
	}

	@RequestMapping(value = { "/saveTaskWithoutPO" }, method = RequestMethod.POST)
	public JSONArray saveTaskWithoutPO(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		PrintWriter out = null;

		try {
			out = response.getWriter();
			HttpSession htt = request.getSession(true);

			String uname = (String) session.getAttribute("username");
			String userfullname = (String) session.getAttribute("fullname");
			String role = (String) session.getAttribute("role");

			String functionName = request.getParameter("functionName");
			String Responsibility = request.getParameter("Responsibility");
			String customerName = request.getParameter("customerName");
			String productsuit = request.getParameter("productsuit");
			String productname = request.getParameter("productname");
			String teamLeader = request.getParameter("teamLeader");
			String ModuleName = request.getParameter("ModuleName");
			String developer = request.getParameter("developer");
			String startdate = request.getParameter("startdate");
			String enddate = request.getParameter("enddate");
			String inputRemark = request.getParameter("inputRemark");
			String description = request.getParameter("description");
			String selectMe = request.getParameter("selectMe");
			String testerName = request.getParameter("testerName");
			String weightage = request.getParameter("weightage");
			
			
			//24/07
			String supportteamLeader = request.getParameter("supportteamLeader");
			String support = request.getParameter("support");
			//

			String final_response = pmsService.saveTaskWithoutPO(functionName, Responsibility, customerName,
					productsuit, productname, teamLeader, ModuleName, developer, startdate, enddate, inputRemark,
					description, userfullname, uname, role, selectMe, testerName, weightage, supportteamLeader, support);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return null;
	}
	
	
	@RequestMapping(value = { "/saveTaskFromMobileDevice" }, method = RequestMethod.POST)
	public JSONArray saveTaskFromMobileDevice(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		PrintWriter out = null;

		try {
			out = response.getWriter();
			HttpSession htt = request.getSession(true);
			    
			String uname = request.getParameter("username");
			String userfullname = request.getParameter("fullname");
			String role =request.getParameter("role");

			String functionName = request.getParameter("functionName");
			String Responsibility = request.getParameter("Responsibility");
			String customerName = request.getParameter("customerName");
			String productsuit = request.getParameter("productsuit");
			String productname = request.getParameter("productname");
			String teamLeader = request.getParameter("teamLeader");
			String ModuleName = request.getParameter("ModuleName");
			String developer = request.getParameter("developer");
			String startdate = request.getParameter("startdate");
			String enddate = request.getParameter("enddate");
			String inputRemark = request.getParameter("inputRemark");
			String description = request.getParameter("description");
			String selectMe = request.getParameter("selectMe");
			String testerName = request.getParameter("testerName");
			String weightage = request.getParameter("weightage");
			
			
			//24/07
			String supportteamLeader = request.getParameter("supportteamLeader");
			String support = request.getParameter("support");
			//

			String final_response = pmsService.saveTaskWithoutPO(functionName, Responsibility, customerName,
					productsuit, productname, teamLeader, ModuleName, developer, startdate, enddate, inputRemark,
					description, userfullname, uname, role, selectMe, testerName, weightage, supportteamLeader, support);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return null;
	}
	
	

	@RequestMapping(value = { "/ViewMyTaskDetails" }, method = RequestMethod.GET)
	public String ViewMyTaskDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Inside ViewMyTaskDetails method");

		String crno = request.getParameter("crno");
		String tid = request.getParameter("tid");

		return "Pms/ViewMyTaskDetails";
	}

	@RequestMapping(value = { "/getMyTaskList" }, method = RequestMethod.POST)
	public JSONArray getMyTaskList(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside @@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			HttpSession htt = request.getSession(true);
			String uname = (String) htt.getAttribute("username");
			String userfullname = (String) session.getAttribute("fullname");
			String role = (String) session.getAttribute("role");

			JSONArray final_response = pmsService.getMyTaskList(uname, userfullname, role);
			System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		return null;
	}
	
	
	@RequestMapping(value = { "/getMyTaskListMobileDevice" }, method = RequestMethod.POST)
	public JSONArray getMyTaskListFromMobile(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside @@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();
			String userfullname = request.getParameter("fullname");

			JSONArray final_response = pmsService.getMyTaskListMobileDevice(userfullname);
//			System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		return null;
	}
	

	@RequestMapping(value = { "/TesterTask" }, method = RequestMethod.GET)
	public String TesterTask(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		return "Pms/TesterTask";
	}

	@RequestMapping(value = { "/ViewTesterTaskDetails" }, method = RequestMethod.GET)
	public String ViewTesterTaskDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response) {

		String crno = request.getParameter("crno");
		String tid = request.getParameter("tid");
		return "Pms/ViewTesterTaskDetails";
	}

	// getTesterTaskList

	@RequestMapping(value = { "/getTesterTaskList" }, method = RequestMethod.POST)
	public JSONArray getTesterTaskList(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside @@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			HttpSession htt = request.getSession(true);
			String uname = (String) htt.getAttribute("username");
			String userfullname = (String) session.getAttribute("fullname");
			JSONArray final_response = pmsService.getTesterTaskList(uname, userfullname);

			out.print(final_response);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
		return null;
	}

	@RequestMapping(value = { "/containerChartData" }, method = RequestMethod.POST)
	public JSONArray containerChartData(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside  scheduleMeetings Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();
			String uname = (String) session.getAttribute("username");
			String userfullname = (String) session.getAttribute("fullname");
			String role = (String) session.getAttribute("role");
			System.out.println("roletype of  reponse is = " + role);
			JSONArray final_response = pmsService.containerChartData(uname, userfullname, role);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
		return null;
	}

	@RequestMapping(value = { "/cardDashboardData" }, method = RequestMethod.POST)
	public JSONArray cardDashboardData(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside  scheduleMeetings Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();
			String uname = (String) session.getAttribute("username");
			String userfullname = (String) session.getAttribute("fullname");
			String role = (String) session.getAttribute("role");
			System.out.println("roletype of  reponse is = " + role);
			JSONArray final_response = pmsService.cardDashboardData(uname, userfullname, role);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
		return null;
	}

	@RequestMapping(value = { "/AssignedTasksByTL" }, method = RequestMethod.GET)
	public String AssignedTasksByTL(ModelMap model) {
		System.out.println("Inside AssignedTasksByTL method");

		return "Pms/AssignedTasksByTL";
	}
	
	
	//29/07
	@RequestMapping(value = { "/AssignedTasksByMe" }, method = RequestMethod.GET)
	public String AssignedTasksByMe(ModelMap model) {
		System.out.println("Inside AssignedTasksByTL method");

		return "Pms/AssignedTasksByMe";
	}
	//task assign by self
//	@RequestMapping(value = { "/getTaskAssignedBySELF" }, method = RequestMethod.GET)
//	public JSONArray getTaskAssignedBySelf(ModelMap model, HttpServletRequest request,
//	        HttpServletResponse response, HttpSession session) {
//	    PrintWriter out = null;
//	    try {
//	        out = response.getWriter();
//	        JSONArray final_response = pmsService.getTaskAssignedBySelf();
//	        out.print(final_response);
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	    } finally {
//	        out.close();
//	    }
//	    return null;
//	}
	@RequestMapping(value = "/getTaskAssignedBySELF", method = RequestMethod.GET)
	public void getTaskAssignedBySelf(
	        HttpServletRequest request,
	        HttpServletResponse response) {

	    try {

	        int start = Integer.parseInt(request.getParameter("start"));
	        int length = Integer.parseInt(request.getParameter("length"));

	        JSONArray result =
	                pmsService.getTaskAssignedBySelf(start, length);

	        response.setContentType("application/json");

	        response.getWriter().print(result);

	    } catch (Exception e) {

	        e.printStackTrace();
	    }
	}
	
	@RequestMapping(value = { "/AssignedTasksBySelf" }, method = RequestMethod.GET)
	public String AssignedTasksBySelf(ModelMap model) {
	    System.out.println("Inside AssignedTasksBySelf method");
	    return "Pms/AssignedTasksBySelf";
	}
	@RequestMapping(value = { "/getAssignedTaskTL" }, method = RequestMethod.POST)
	public JSONArray getAssignedTaskTL(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside @@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			HttpSession htt = request.getSession(true);
			String uname = (String) htt.getAttribute("username");
			String userfullname = (String) session.getAttribute("fullname");
			String role = (String) session.getAttribute("role");

			JSONArray final_response = pmsService.getAssignedTaskTL(uname, userfullname,role);
			System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		return null;
	}
	
	
	//29/07
	@RequestMapping(value = { "/getAssignedTaskMe" }, method = RequestMethod.POST)
	public JSONArray getAssignedTaskMe(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("inside controller");
		System.out.println("Inside @@@@@@@ ");
		PrintWriter out = null;

		try {
			System.out.println("inside try");
			out = response.getWriter();

			HttpSession htt = request.getSession(true);
			String uname = (String) htt.getAttribute("username");
			String userfullname = (String) session.getAttribute("fullname");

			JSONArray final_response = pmsService.getAssignedTaskMe(uname, userfullname);
			System.out.println("MastersControllerrrr reponse is::= " + final_response);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		return null;
	}
	//
	

	@RequestMapping(value = { "/TeamMembersList" }, method = RequestMethod.GET)
	public void TeamMembers(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("innnnn Exception in Groupchecked Controller : ");
		PrintWriter out = null;

		try {
			out = response.getWriter();
			HttpSession htt = request.getSession(true);

			String uname = (String) htt.getAttribute("username");
			String userfullname = (String) session.getAttribute("fullname");
			String role = (String) session.getAttribute("role");
			JSONObject result = pmsService.TeamMembers(uname, userfullname, role);
			System.out.println("Result value in Groupchecked: " + result);
			out.print(result);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception in Groupchecked Controller : " + e);
		}

	}

	@RequestMapping(value = { "/getTaskDetailList" }, method = RequestMethod.POST)
	public JSONArray getTaskDetailList(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;
		String sname = null;
		try {
			out = response.getWriter();
			String customername = request.getParameter("customer_name");
			// System.out.println("ticketype:::"+location);
			JSONArray final_response = pmsService.getTaskDetailList(customername);

			out.print(final_response);

			// System.out.println("SITE NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;
	}

	@RequestMapping(value = { "/getProductSuiteName" }, method = RequestMethod.POST)
	public JSONArray getProductSuiteName(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;
		String sname = null;
		try {
			out = response.getWriter();
			String module_name = request.getParameter("module_name");
			// System.out.println("ticketype:::"+location);
			JSONArray final_response = pmsService.getProductSuiteName(module_name);

			out.print(final_response);

			// System.out.println("SITE NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;
	}

	@RequestMapping(value = { "/getTaskdetails" }, method = RequestMethod.POST)
	public JSONArray getTaskdetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;
		String sname = null;
		try {
			out = response.getWriter();
			String module_name = request.getParameter("module_name");
			String customer_name = request.getParameter("customer_name");

			// System.out.println("ticketype:::"+location);
			JSONArray final_response = pmsService.getTaskdetails(module_name, customer_name);

			out.print(final_response);

			// System.out.println("SITE NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;
	}

	@RequestMapping(value = { "/getLatestProjectList" }, method = RequestMethod.POST)
	public JSONArray getLatestProjectList(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;
		try {
			out = response.getWriter();
			// String module_name = request.getParameter("module_name");

			// System.out.println("ticketype:::"+location);
			JSONArray final_response = pmsService.getLatestProjectList();

			out.print(final_response);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
		return null;
	}

	@RequestMapping(value = { "/ViewTaskDetails" }, method = RequestMethod.GET)
	public String ViewTaskDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Inside ViewImplTaskDetails method");

		String crno = request.getParameter("crno");
		String tid = request.getParameter("tid");

		return "Pms/ViewTaskDetails";
	}

	@RequestMapping(value = { "/AssignedTasksByTester" }, method = RequestMethod.GET)
	public String AssignedTasksByTester(ModelMap model, HttpServletRequest request, HttpServletResponse response) {

		String crno = request.getParameter("crno");
		String tid = request.getParameter("tid");

		return "Pms/AssignedTasksByTester";
	}

	@RequestMapping(value = { "/ViewAssignedTasksByTester" }, method = RequestMethod.GET)
	public String ViewAssignedTasksByTester(ModelMap model, HttpServletRequest request, HttpServletResponse response) {

		String crno = request.getParameter("crno");
		String tid = request.getParameter("tid");

		return "Pms/ViewAssignedTasksByTester";
	}

	@RequestMapping(value = { "/getAssignedTaskTester" }, method = RequestMethod.POST)
	public JSONArray getAssignedTaskTester(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside @@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			HttpSession htt = request.getSession(true);
			String uname = (String) htt.getAttribute("username");
			String userfullname = (String) session.getAttribute("fullname");

			JSONArray final_response = pmsService.getAssignedTaskTester(uname, userfullname);
			System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		return null;
	}

	@RequestMapping(value = { "/getprojectontrack" }, method = RequestMethod.POST)
	public JSONArray getprojectontrack(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;
		try {
			out = response.getWriter();
			// String module_name = request.getParameter("module_name");

			// System.out.println("ticketype:::"+location);
			JSONArray final_response = pmsService.getprojectontrack();

			out.print(final_response);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
		return null;
	}

	@RequestMapping(value = { "/getTotalcompletedproject" }, method = RequestMethod.POST)
	public JSONArray getTotalcompletedproject(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;
		try {
			out = response.getWriter();
			String methodName = request.getParameter("methodName");
			System.out.println("Innn thodName ");
			System.out.println("methodNamemethodName " + methodName);
			
			String role = (String) session.getAttribute("role");
			
			JSONArray final_response = pmsService.getTotalcompletedproject(methodName,role);

			out.print(final_response);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
		return null;
	}

	@RequestMapping(value = { "/getActivitiesdalayscount" }, method = RequestMethod.POST)
	public JSONArray getActivitiesdalayscount(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;
		try {
			out = response.getWriter();
			// String module_name = request.getParameter("module_name");

			// System.out.println("ticketype:::"+location);
			JSONArray final_response = pmsService.getActivitiesdalayscount();

			out.print(final_response);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
		return null;
	}

	@RequestMapping(value = { "/getMgrDelaysActivities" }, method = RequestMethod.POST)
	public JSONArray getMgrDelaysActivities(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;
		try {
			out = response.getWriter();
			// String module_name = request.getParameter("module_name");
			String userfullname = (String) session.getAttribute("fullname");
			// System.out.println("ticketype:::"+location);
			JSONArray final_response = pmsService.getMgrDelaysActivities(userfullname);

			out.print(final_response);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
		return null;
	}

	@RequestMapping(value = { "/getproductsuite" }, method = RequestMethod.POST)
	public JSONArray getproductsuite(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;

		try {
			// Retrieve PrintWriter to write response
			out = response.getWriter();

			// Retrieve selected project name from request parameters
			String projectNames = request.getParameter("projectNames");

			// Call service method to get product suite information based on project name
			JSONArray final_response = pmsService.getproductsuite(projectNames);

			// Print product suite information to console for debugging
			System.out.println("MastersControllerrrr response is: " + final_response);

			// Write product suite information to response
			out.print(final_response);

			// Log success message
			System.out.println("Product suite information retrieved successfully: " + final_response);

		} catch (Exception e) {
			// Handle exceptions
			e.printStackTrace();
		} finally {
			// Close PrintWriter
			if (out != null) {
				out.close();
			}
		}

		// Return null since response is handled directly within the method
		return null;
	}

	@RequestMapping(value = { "/getproductmgrname" }, method = RequestMethod.POST)
	public JSONArray getproductmgrname(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;

		try {
			// Retrieve PrintWriter to write response
			out = response.getWriter();

			// Retrieve selected project name from request parameters
			String projectmgrname = request.getParameter("projectmgrname");
			String productsuite = request.getParameter("productsuite");

			// Call service method to get product suite information based on project name
			JSONArray final_response = pmsService.getproductmgrname(projectmgrname, productsuite);

			// Print product suite information to console for debugging
			System.out.println("MastersControllerrrr response is: " + final_response);

			// Write product suite information to response
			out.print(final_response);

			// Log success message
			System.out.println("Product suite information retrieved successfully: " + final_response);

		} catch (Exception e) {
			// Handle exceptions
			e.printStackTrace();
		} finally {
			// Close PrintWriter
			if (out != null) {
				out.close();
			}
		}

		// Return null since response is handled directly within the method
		return null;
	}

	@RequestMapping(value = { "/getfunctionname" }, method = RequestMethod.POST)
	public JSONArray getfunctionname(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;

		try {
			// Retrieve PrintWriter to write response
			out = response.getWriter();

			// Retrieve selected project name from request parameters
			String projectmgrname = request.getParameter("productmanager");
			String productsuite = request.getParameter("productsuite");
			String teamleader = request.getParameter("teamleader");

			// Call service method to get product suite information based on project name
			JSONArray final_response = pmsService.getfunctionname(projectmgrname, productsuite, teamleader);

			// Print product suite information to console for debugging
			System.out.println("MastersControllerrrr response is: " + final_response);

			// Write product suite information to response
			out.print(final_response);

			// Log success message
			System.out.println("Product suite information retrieved successfully: " + final_response);

		} catch (Exception e) {
			// Handle exceptions
			e.printStackTrace();
		} finally {
			// Close PrintWriter
			if (out != null) {
				out.close();
			}
		}

		// Return null since response is handled directly within the method
		return null;
	}

	@RequestMapping(value = { "/getallfunctionname" }, method = RequestMethod.POST)
	public JSONArray getallfunctionname(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;

		try {
			// Retrieve PrintWriter to write response
			out = response.getWriter();
			System.out.println("Inn getallfunctionname method");

			String projectmgrname = request.getParameter("productmanager");
			String productsuite = request.getParameter("projectName");
			String teamleader = request.getParameter("teamleader");
			String allfunction = request.getParameter("allfunction");

			JSONArray final_response = pmsService.getallfunctionname(projectmgrname, productsuite, teamleader,
					allfunction);

			System.out.println("MastersControllerrrr response is: " + final_response);

			out.print(final_response);

			System.out.println("Product suite information retrieved successfully: " + final_response);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}

		// Return null since response is handled directly within the method
		return null;
	}

	@RequestMapping(value = { "/getListdelayproject" }, method = RequestMethod.POST)
	public JSONArray getListdelayproject(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;
		try {
			out = response.getWriter();
			// String module_name = request.getParameter("module_name");

			// System.out.println("ticketype:::"+location);
			JSONArray final_response = pmsService.getListdelayproject();

			out.print(final_response);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
		return null;
	}

	@RequestMapping(value = { "/getproductsuiteActontrack" }, method = RequestMethod.POST)
	public JSONArray getproductsuiteActontrack(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;
		String sname = null;
		try {
			out = response.getWriter();
			String projectNames = request.getParameter("projectNames");
			// System.out.println("ticketype:::"+location);
			JSONArray final_response = pmsService.getproductsuiteActontrack(projectNames);

			out.print(final_response);

			// System.out.println("SITE NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;
	}

	@RequestMapping(value = { "/getproductmgrnameActonTrack" }, method = RequestMethod.POST)
	public JSONArray getproductmgrnameActonTrack(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {

		PrintWriter out = null;

		try {
			// Retrieve PrintWriter to write response
			out = response.getWriter();

			// Retrieve selected project name from request parameters
			String projectmgrname = request.getParameter("projectmgrname");
			String productsuite = request.getParameter("productsuite");

			// Call service method to get product suite information based on project name
			JSONArray final_response = pmsService.getproductmgrnameActonTrack(projectmgrname, productsuite);

			// Print product suite information to console for debugging
			System.out.println("MastersControllerrrr response is: " + final_response);

			// Write product suite information to response
			out.print(final_response);

			// Log success message
			System.out.println("Product suite information retrieved successfully: " + final_response);

		} catch (Exception e) {
			// Handle exceptions
			e.printStackTrace();
		} finally {
			// Close PrintWriter
			if (out != null) {
				out.close();
			}
		}

		// Return null since response is handled directly within the method
		return null;
	}

	@RequestMapping(value = { "/getfunctionnameActonTrack" }, method = RequestMethod.POST)
	public JSONArray getfunctionnameActonTrack(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;

		try {
			// Retrieve PrintWriter to write response
			out = response.getWriter();

			// Retrieve selected project name from request parameters
			String projectmgrname = request.getParameter("productmanager");
			String productsuite = request.getParameter("productsuite");
			String teamleader = request.getParameter("teamleader");

			// Call service method to get product suite information based on project name
			JSONArray final_response = pmsService.getfunctionnameActonTrack(projectmgrname, productsuite, teamleader);

			// Print product suite information to console for debugging
			System.out.println("MastersControllerrrr response is: " + final_response);

			// Write product suite information to response
			out.print(final_response);

			// Log success message
			System.out.println("Product suite information retrieved successfully: " + final_response);

		} catch (Exception e) {
			// Handle exceptions
			e.printStackTrace();
		} finally {
			// Close PrintWriter
			if (out != null) {
				out.close();
			}
		}

		// Return null since response is handled directly within the method
		return null;
	}

	@RequestMapping(value = { "/getallfunctionnameActonTracks" }, method = RequestMethod.POST)
	public JSONArray getallfunctionnameActonTracks(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {

		PrintWriter out = null;

		try {
			// Retrieve PrintWriter to write response
			out = response.getWriter();

			// Retrieve selected project name from request parameters
			String projectmgrname = request.getParameter("productmanager");
			String productsuite = request.getParameter("productsuite");
			String teamleader = request.getParameter("teamleader");
			String allfunction = request.getParameter("allfunction");

			// Call service method to get product suite information based on project name
			JSONArray final_response = pmsService.getallfunctionnameActonTracks(projectmgrname, productsuite,
					teamleader, allfunction);

			// Print product suite information to console for debugging
			System.out.println("MastersControllerrrr response is: " + final_response);

			// Write product suite information to response
			out.print(final_response);

			// Log success message
			System.out.println("Product suite information retrieved successfully: " + final_response);

		} catch (Exception e) {
			// Handle exceptions
			e.printStackTrace();
		} finally {
			// Close PrintWriter
			if (out != null) {
				out.close();
			}
		}

		// Return null since response is handled directly within the method
		return null;
	}

	@RequestMapping(value = { "/getPMactonTrack" }, method = RequestMethod.POST)
	public JSONArray getPMactonTrack(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;
		try {

			out = response.getWriter();
			String uname = (String) session.getAttribute("username");
			String userfullname = (String) session.getAttribute("fullname");
			String role = (String) session.getAttribute("role");
			System.out.println("roletype of  reponse is = " + role);
			JSONArray final_response = pmsService.getPMactonTrack(uname, userfullname, role);

			out.print(final_response);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
		return null;
	}

	@RequestMapping(value = { "/getproductsuiteActontrackPM" }, method = RequestMethod.POST)
	public JSONArray getproductsuiteActontrackPM(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {

		PrintWriter out = null;
		String sname = null;
		try {
			out = response.getWriter();
			String projectNames = request.getParameter("projectNames");
			String userfullname = (String) session.getAttribute("fullname");
			// System.out.println("ticketype:::"+location);
			JSONArray final_response = pmsService.getproductsuiteActontrackPM(projectNames, userfullname);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;
	}

	@RequestMapping(value = { "/getDevNameActonTrackPM" }, method = RequestMethod.POST)
	public JSONArray getDevNameActonTrackPM(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;

		try {
			// Retrieve PrintWriter to write response
			out = response.getWriter();

			// Retrieve selected project name from request parameters
			String producttool = request.getParameter("producttool");
			String tlnames = request.getParameter("tlnames");

			// Call service method to get product suite information based on project name
			JSONArray final_response = pmsService.getDevNameActonTrackPM(producttool, tlnames);

			// Print product suite information to console for debugging
			System.out.println("MastersControllerrrr response is: " + final_response);

			// Write product suite information to response
			out.print(final_response);

			// Log success message
			System.out.println("Product suite information retrieved successfully: " + final_response);

		} catch (Exception e) {
			// Handle exceptions
			e.printStackTrace();
		} finally {
			// Close PrintWriter
			if (out != null) {
				out.close();
			}
		}

		// Return null since response is handled directly within the method
		return null;
	}

	@RequestMapping(value = { "/getfunctionnameActonTrackforPM" }, method = RequestMethod.POST)
	public JSONArray getfunctionnameActonTrackforPM(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {

		PrintWriter out = null;
		try {

			out = response.getWriter();
			String projectname = request.getParameter("projectname");
			String Teamleadername = request.getParameter("Teamleadername");
			String Devname = request.getParameter("Devname");
			JSONArray final_response = pmsService.getfunctionnameActonTrackforPM(projectname, Teamleadername, Devname);

			out.print(final_response);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
		return null;
	}

	@RequestMapping(value = { "/getallfunctionnameActonTracksPM" }, method = RequestMethod.POST)
	public JSONArray getallfunctionnameActonTracksPM(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {

		PrintWriter out = null;

		try {
			// Retrieve PrintWriter to write response
			out = response.getWriter();

			// Retrieve selected project name from request parameters
			String projectname = request.getParameter("projectname");
			String tlname = request.getParameter("tlname");
			String devname = request.getParameter("devname");
			String allfunction = request.getParameter("allfunction");
			String userfullname = (String) session.getAttribute("fullname");

			// Call service method to get product suite information based on project name
			JSONArray final_response = pmsService.getallfunctionnameActonTracksPM(projectname, tlname, devname,
					allfunction, userfullname);

			// Print product suite information to console for debugging
			System.out.println("MastersControllerrrr response is: " + final_response);

			// Write product suite information to response
			out.print(final_response);

			// Log success message
			System.out.println("Product suite information retrieved successfully: " + final_response);

		} catch (Exception e) {
			// Handle exceptions
			e.printStackTrace();
		} finally {
			// Close PrintWriter
			if (out != null) {
				out.close();
			}
		}

		// Return null since response is handled directly within the method
		return null;
	}

	@RequestMapping(value = { "/getallfunctionnameActonTracksPMDly" }, method = RequestMethod.POST)
	public JSONArray getallfunctionnameActonTracksDly(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {

		PrintWriter out = null;

		try {
			// Retrieve PrintWriter to write response
			out = response.getWriter();

			// Retrieve selected project name from request parameters
			String projectname = request.getParameter("projectname");
			String tlname = request.getParameter("tlname");
			String devname = request.getParameter("devname");
			String allfunction = request.getParameter("allfunction");
			String userfullname = (String) session.getAttribute("fullname");
			// Call service method to get product suite information based on project name
			JSONArray final_response = pmsService.getallfunctionnameActonTracksDly(projectname, tlname, devname,
					allfunction, userfullname);

			// Print product suite information to console for debugging
			System.out.println("MastersControllerrrr response is: " + final_response);

			// Write product suite information to response
			out.print(final_response);

			// Log success message
			System.out.println("Product suite information retrieved successfully: " + final_response);

		} catch (Exception e) {
			// Handle exceptions
			e.printStackTrace();
		} finally {
			// Close PrintWriter
			if (out != null) {
				out.close();
			}
		}

		// Return null since response is handled directly within the method
		return null;
	}

	@RequestMapping(value = { "/getMgrTotalProject" }, method = RequestMethod.POST)
	public JSONArray getMgrTotalProject(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;

		try {
			// Retrieve PrintWriter to write response
			out = response.getWriter();

			// Retrieve selected project name from request parameters

			String userfullname = (String) session.getAttribute("fullname");
			String role = (String) session.getAttribute("role");
			

			// Call service method to get product suite information based on project name
			JSONArray final_response = pmsService.getMgrTotalProject(userfullname,role);

			// Print product suite information to console for debugging
			System.out.println("MastersControllerrrr response is: " + final_response);

			// Write product suite information to response
			out.print(final_response);

			// Log success message
			System.out.println("Product suite information retrieved successfully: " + final_response);

		} catch (Exception e) {
			// Handle exceptions
			e.printStackTrace();
		} finally {
			// Close PrintWriter
			if (out != null) {
				out.close();
			}
		}

		// Return null since response is handled directly within the method
		return null;
	}

	@RequestMapping(value = { "/getprojectontrackMGR" }, method = RequestMethod.POST)
	public JSONArray getprojectontrackMGR(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;

		try {
			// Retrieve PrintWriter to write response
			out = response.getWriter();

			// Retrieve selected project name from request parameters

			String userfullname = (String) session.getAttribute("fullname");
			String role = (String) session.getAttribute("role");

			// Call service method to get product suite information based on project name
			JSONArray final_response = pmsService.getprojectontrackMGR(userfullname,role);

			// Print product suite information to console for debugging
			System.out.println("MastersControllerrrr response is: " + final_response);

			// Write product suite information to response
			out.print(final_response);

			// Log success message
			System.out.println("Product suite information retrieved successfully: " + final_response);

		} catch (Exception e) {
			// Handle exceptions
			e.printStackTrace();
		} finally {
			// Close PrintWriter
			if (out != null) {
				out.close();
			}
		}

		// Return null since response is handled directly within the method
		return null;
	}

	@RequestMapping(value = { "/getprojectcompletedMGR" }, method = RequestMethod.POST)
	public JSONArray getprojectcompletedMGR(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;

		try {
			// Retrieve PrintWriter to write response
			out = response.getWriter();

			// Retrieve selected project name from request parameters

			String userfullname = (String) session.getAttribute("fullname");
			String role = (String) session.getAttribute("role");

			// Call service method to get product suite information based on project name
			JSONArray final_response = pmsService.getprojectcompletedMGR(userfullname,role);

			// Print product suite information to console for debugging
			System.out.println("MastersControllerrrr response is: " + final_response);

			// Write product suite information to response
			out.print(final_response);

			// Log success message
			System.out.println("Product suite information retrieved successfully: " + final_response);

		} catch (Exception e) {
			// Handle exceptions
			e.printStackTrace();
		} finally {
			// Close PrintWriter
			if (out != null) {
				out.close();
			}
		}

		// Return null since response is handled directly within the method
		return null;
	}

	@RequestMapping(value = { "/getprojectdealyedMGR" }, method = RequestMethod.POST)
	public JSONArray getprojectdealyedMGR(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;

		try {
			// Retrieve PrintWriter to write response
			out = response.getWriter();

			// Retrieve selected project name from request parameters

			String userfullname = (String) session.getAttribute("fullname");
			String role = (String) session.getAttribute("role");

			// Call service method to get product suite information based on project name
			JSONArray final_response = pmsService.getprojectdealyedMGR(userfullname,role);

			// Print product suite information to console for debugging
			System.out.println("MastersControllerrrr response is: " + final_response);

			// Write product suite information to response
			out.print(final_response);

			// Log success message
			System.out.println("Product suite information retrieved successfully: " + final_response);

		} catch (Exception e) {
			// Handle exceptions
			e.printStackTrace();
		} finally {
			// Close PrintWriter
			if (out != null) {
				out.close();
			}
		}

		// Return null since response is handled directly within the method
		return null;
	}

	@RequestMapping(value = { "/getAllActivities" }, method = RequestMethod.POST)
	public JSONArray getAllActivities(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;

		try {
			out = response.getWriter();

			String uname = (String) session.getAttribute("username");
			String role = (String) session.getAttribute("role");
			String designation = (String) session.getAttribute("designation");

			JSONArray final_response = pmsService.getAllActivities(uname, role, designation);

			System.out.println("MastersControllerrrr response is: " + final_response);

			out.print(final_response);

			System.out.println("Product suite information retrieved successfully: " + final_response);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}

		// Return null since response is handled directly within the method
		return null;
	}

	@RequestMapping(value = { "/getAllActivitiesByProj" }, method = RequestMethod.POST)
	public JSONArray getAllActivitiesByProj(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;

		try {
			out = response.getWriter();

//            String projectmgrname = request.getParameter("productmanager");
			String projectName = request.getParameter("projectName");
//            String teamleader = request.getParameter("teamleader");
//            String allfunction = request.getParameter("allfunction");

			String uname = (String) session.getAttribute("username");
			String role = (String) session.getAttribute("role");
			String designation = (String) session.getAttribute("designation");

			JSONArray final_response = pmsService.getAllActivitiesByProj(projectName, uname, role, designation);

			System.out.println("MastersControllerrrr response is: " + final_response);

			out.print(final_response);

			System.out.println("Product suite information retrieved successfully: " + final_response);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}
		return null;
	}

	@RequestMapping(value = { "/getAllActivitiesByMGR" }, method = RequestMethod.POST)
	public JSONArray getAllActivitiesByMGR(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;

		try {
			out = response.getWriter();

			String projectmgrname = request.getParameter("productmanager");
			String projectName = request.getParameter("projectName");
//            String teamleader = request.getParameter("teamleader");
//            String allfunction = request.getParameter("allfunction");

			String uname = (String) session.getAttribute("username");
			String role = (String) session.getAttribute("role");
			String designation = (String) session.getAttribute("designation");

			JSONArray final_response = pmsService.getAllActivitiesByMGR(projectName, projectmgrname, uname, role,
					designation);

			System.out.println("MastersControllerrrr response is: " + final_response);

			out.print(final_response);

			System.out.println("Product suite information retrieved successfully: " + final_response);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}
		return null;
	}

	@RequestMapping(value = { "/getAllActivitiesByTL" }, method = RequestMethod.POST)
	public JSONArray getAllActivitiesByTL(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;

		try {
			out = response.getWriter();

			String projectmgrname = request.getParameter("productmanager");
			String projectName = request.getParameter("projectName");
			String teamleader = request.getParameter("teamleader");
//            String allfunction = request.getParameter("allfunction");

			String uname = (String) session.getAttribute("username");
			String role = (String) session.getAttribute("role");
			String designation = (String) session.getAttribute("designation");

			JSONArray final_response = pmsService.getAllActivitiesByTL(projectName, projectmgrname, teamleader, uname,
					role, designation);

			System.out.println("MastersControllerrrr response is: " + final_response);

			out.print(final_response);

			System.out.println("Product suite information retrieved successfully: " + final_response);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}
		return null;
	}

	@RequestMapping(value = { "/getTeamLeaderTotalproject" }, method = RequestMethod.POST)
	public JSONArray getTeamLeaderTotalproject(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;
		try {
			out = response.getWriter();
			String methodName = request.getParameter("methodName");
			String userfullname = (String) session.getAttribute("fullname");
			String role = (String) session.getAttribute("role");

			System.out.println("Innn thodName ");
			System.out.println("methodNamemethodName " + methodName);
			JSONArray final_response = pmsService.getTeamLeaderTotalproject(methodName, userfullname, role);

			out.print(final_response);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
		return null;
	}

	@RequestMapping(value = { "/getTeamLeaderTotalcompletedproject" }, method = RequestMethod.POST)
	public JSONArray getTeamLeaderTotalcompletedproject(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {

		PrintWriter out = null;
		try {
			out = response.getWriter();
			String methodName = request.getParameter("methodName");
			String userfullname = (String) session.getAttribute("fullname");
			String role = (String) session.getAttribute("role");
			
			System.out.println("Innn thodName ");
			System.out.println("methodNamemethodName " + methodName);
			JSONArray final_response = pmsService.getTeamLeaderTotalcompletedproject(methodName, userfullname, role);

			out.print(final_response);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
		return null;
	}

	@RequestMapping(value = { "/getTeamLeaderDelayedProjectDetails" }, method = RequestMethod.POST)
	public JSONArray getTeamLeaderDelayedProjectDetails(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {

		PrintWriter out = null;

		try {
			out = response.getWriter();

//            String projectmgrname = request.getParameter("productmanager");
//            String productsuite = request.getParameter("productsuite");
//            String teamleader = request.getParameter("teamleader");
//            String allfunction = request.getParameter("allfunction");

			String fullname = (String) session.getAttribute("fullname");
			String role = (String) session.getAttribute("role");
			String designation = (String) session.getAttribute("designation");
			String delayedProjectName = request.getParameter("delayedProjectName");

			JSONArray final_response = pmsService.getTeamLeaderDelayedProjectDetails(fullname, role, designation,
					delayedProjectName);

			System.out.println("PMSControllerrrr response is: " + final_response);

			out.print(final_response);

			System.out.println(
					"getTeamLeaderDelayedProjectDetails information retrieved successfully: " + final_response);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}

		// Return null since response is handled directly within the method
		return null;
	}

	@RequestMapping(value = { "/getTeamLeaderActivityOnTrack" }, method = RequestMethod.POST)
	public JSONArray getTeamLeaderActivityOnTrack(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {

		PrintWriter out = null;
		try {

			out = response.getWriter();
			String uname = (String) session.getAttribute("username");
			String userfullname = (String) session.getAttribute("fullname");
			String role = (String) session.getAttribute("role");
			System.out.println("roletype of  reponse is = " + role);
			JSONArray final_response = pmsService.getTeamLeaderActivityOnTrack(uname, userfullname, role);

			out.print(final_response);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
		return null;
	}

	@RequestMapping(value = { "/getTeamLeaderActivities" }, method = RequestMethod.POST)
	public JSONArray getTeamLeaderActivities(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;

		try {
			out = response.getWriter();

//            String projectmgrname = request.getParameter("productmanager");
//            String productsuite = request.getParameter("productsuite");
//            String teamleader = request.getParameter("teamleader");
//            String allfunction = request.getParameter("allfunction");

			String uname = (String) session.getAttribute("fullname");
			String role = (String) session.getAttribute("role");
			String designation = (String) session.getAttribute("designation");

			JSONArray final_response = pmsService.getTeamLeaderActivities(uname, role, designation);

			System.out.println("MastersControllerrrr response is: " + final_response);

			out.print(final_response);

			System.out.println("Product suite information retrieved successfully: " + final_response);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}

		// Return null since response is handled directly within the method
		return null;
	}

	@RequestMapping(value = { "/getTeamLeaderFunctionName" }, method = RequestMethod.POST)
	public JSONArray getTeamLeaderFunctionName(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;
		try {

			out = response.getWriter();
			String uname = (String) session.getAttribute("username");
			String userfullname = (String) session.getAttribute("fullname");
			String role = (String) session.getAttribute("role");
			System.out.println("roletype of  reponse is = " + role);
			JSONArray final_response = pmsService.getTeamLeaderFunctionName(uname, userfullname, role);

			out.print(final_response);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
		return null;
	}

	@RequestMapping(value = { "/getTeamLeaderDetailsByProjectName" }, method = RequestMethod.POST)
	public JSONArray getTeamLeaderDetailsByProjectName(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {

		PrintWriter out = null;

		try {
			out = response.getWriter();

//            String projectmgrname = request.getParameter("productmanager");
//            String productsuite = request.getParameter("productsuite");
//            String teamleader = request.getParameter("teamleader");
//            String allfunction = request.getParameter("allfunction");

			String uname = (String) session.getAttribute("fullname");
			String role = (String) session.getAttribute("role");
			String designation = (String) session.getAttribute("designation");
			String projectName = request.getParameter("productsuite");

			JSONArray final_response = pmsService.getTeamLeaderDetailsByProjectName(uname, role, designation,
					projectName);

			System.out.println("MastersControllerrrr response is: " + final_response);

			out.print(final_response);

			System.out.println("Product suite information retrieved successfully: " + final_response);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}

		// Return null since response is handled directly within the method
		return null;
	}

	@RequestMapping(value = { "/getTeamLeaderAssignName" }, method = RequestMethod.POST)
	public JSONArray getTeamLeaderAssignName(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;

		try {
			out = response.getWriter();

//            String projectmgrname = request.getParameter("productmanager");
//            String productsuite = request.getParameter("productsuite");
//            String teamleader = request.getParameter("teamleader");
//            String allfunction = request.getParameter("allfunction");

			String fullname = (String) session.getAttribute("fullname");
			String role = (String) session.getAttribute("role");
			String designation = (String) session.getAttribute("designation");
//			String projectName = request.getParameter("projectNames");

			JSONArray final_response = pmsService.getTeamLeaderAssignName(fullname, role, designation);

			System.out.println("PMSControllerrrr response is: " + final_response);

			out.print(final_response);

			System.out.println("getTeamLeaderAssignName information retrieved successfully: " + final_response);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}

		// Return null since response is handled directly within the method
		return null;
	}

	@RequestMapping(value = { "/getTeamLeaderDetailsByAssignToName" }, method = RequestMethod.POST)
	public JSONArray getTeamLeaderDetailsByAssignToName(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {

		PrintWriter out = null;

		try {
			out = response.getWriter();

//            String projectmgrname = request.getParameter("productmanager");
//            String productsuite = request.getParameter("productsuite");
//            String teamleader = request.getParameter("teamleader");
//            String allfunction = request.getParameter("allfunction");

			String fullname = (String) session.getAttribute("fullname");
			String role = (String) session.getAttribute("role");
			String designation = (String) session.getAttribute("designation");
			String projectName = request.getParameter("projectName");
			String assignto = request.getParameter("assignto");

			JSONArray final_response = pmsService.getTeamLeaderDetailsByAssignToName(fullname, role, designation,
					projectName, assignto);

			System.out.println("PMSControllerrrr response is: " + final_response);

			out.print(final_response);

			System.out.println("Project Name information retrieved successfully: " + final_response);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}

		// Return null since response is handled directly within the method
		return null;
	}

	@RequestMapping(value = { "/getTeamLeaderDetailsByfunctionName" }, method = RequestMethod.POST)
	public JSONArray getTeamLeaderDetailsByfunctionName(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {

		PrintWriter out = null;

		try {
			out = response.getWriter();

//            String projectmgrname = request.getParameter("productmanager");
//            String productsuite = request.getParameter("productsuite");
//            String teamleader = request.getParameter("teamleader");
//            String allfunction = request.getParameter("allfunction");

			String fullname = (String) session.getAttribute("fullname");
			String role = (String) session.getAttribute("role");
			String designation = (String) session.getAttribute("designation");
			String functionName = request.getParameter("functionName");
			String projectName = request.getParameter("projectName");
			String assignTo = request.getParameter("assignTo");

			JSONArray final_response = pmsService.getTeamLeaderDetailsByfunctionName(fullname, role, designation,
					functionName, projectName, assignTo);

			System.out.println("PMSControllerrrr response is: " + final_response);

			out.print(final_response);

			System.out.println(
					"getTeamLeaderDetailsByfunctionName information retrieved successfully: " + final_response);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}

		// Return null since response is handled directly within the method
		return null;
	}

	@RequestMapping(value = { "/getTeamLeaderActivityDelayed" }, method = RequestMethod.POST)
	public JSONArray getTeamLeaderActivityDelayed(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {

		PrintWriter out = null;
		try {

			out = response.getWriter();
			String uname = (String) session.getAttribute("username");
			String userfullname = (String) session.getAttribute("fullname");
			String role = (String) session.getAttribute("role");
			System.out.println("roletype of  reponse is = " + role);
			JSONArray final_response = pmsService.getTeamLeaderActivityDelayed(uname, userfullname, role);

			out.print(final_response);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
		return null;
	}

	@RequestMapping(value = { "/getTeamLeaderDelayedProjectByProjectName" }, method = RequestMethod.POST)
	public JSONArray getTeamLeaderDelayedProjectByProjectName(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {

		PrintWriter out = null;

		try {
			out = response.getWriter();

//            String projectmgrname = request.getParameter("productmanager");
//            String productsuite = request.getParameter("productsuite");
//            String teamleader = request.getParameter("teamleader");
//            String allfunction = request.getParameter("allfunction");

			String fullname = (String) session.getAttribute("fullname");
			String role = (String) session.getAttribute("role");
			String designation = (String) session.getAttribute("designation");
			String projectName = request.getParameter("ProjectName");
			String functionName = request.getParameter("functionName");
			String assignToName = request.getParameter("assignToName");

			JSONArray final_response = pmsService.getTeamLeaderDelayedProjectByProjectName(fullname, role, designation,
					projectName, functionName, assignToName);

			System.out.println("PMSControllerrrr response is: " + final_response);

			out.print(final_response);

			System.out.println(
					"getTeamLeaderDelayedProjectDetails information retrieved successfully: " + final_response);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}

		// Return null since response is handled directly within the method
		return null;
	}

	@RequestMapping(value = { "/getTeamLeadActivitiesDelayedByProjectName" }, method = RequestMethod.POST)
	public JSONArray getTeamLeadActivitiesDelayedByProjectName(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {

		PrintWriter out = null;
		String sname = null;
		try {
			out = response.getWriter();
			String projectNames = request.getParameter("ProjectName");
			String fullname = (String) session.getAttribute("fullname");

			// System.out.println("ticketype:::"+location);
			JSONArray final_response = pmsService.getTeamLeadActivitiesDelayedByProjectName(projectNames, fullname);

			out.print(final_response);

			// System.out.println("SITE NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;
	}

	@RequestMapping(value = { "/getAssignToDelayedProjectByProjectName" }, method = RequestMethod.POST)
	public JSONArray getAssignToDelayedProjectByProjectName(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {

		PrintWriter out = null;

		try {
			out = response.getWriter();
			String fullname = (String) session.getAttribute("fullname");
			String role = (String) session.getAttribute("role");
			String designation = (String) session.getAttribute("designation");

			String projectName = request.getParameter("projectName");
			String assignTo = request.getParameter("assignTo");

			JSONArray final_response = pmsService.getAssignToDelayedProjectByProjectName(fullname, role, designation,
					projectName, assignTo);

			System.out.println("PMSControllerrrr response is: " + final_response);

			out.print(final_response);

			System.out.println(
					"getAssignToDelayedProjectByProjectName information retrieved successfully: " + final_response);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}

		// Return null since response is handled directly within the method
		return null;
	}

	@RequestMapping(value = { "/getActivitiesdalaysByProj" }, method = RequestMethod.POST)
	public JSONArray getActivitiesdalaysByProj(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;
		try {
			out = response.getWriter();

			String projectName = request.getParameter("projectName");
//	           String projectmgrname = request.getParameter("productmanager");
//	            String teamleader = request.getParameter("teamleader");
//	            String allfunction = request.getParameter("allfunction");

			String uname = (String) session.getAttribute("username");
			String role = (String) session.getAttribute("role");
			String designation = (String) session.getAttribute("designation");

			JSONArray final_response = pmsService.getActivitiesdalaysByProj(projectName, uname, role, designation);

			out.print(final_response);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
		return null;
	}

	@RequestMapping(value = { "/getActivitiesdalaysByMGR" }, method = RequestMethod.POST)
	public JSONArray getActivitiesdalaysByMGR(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;
		try {
			out = response.getWriter();
			System.out.println("innnn getActivitiesdalaysByManager");
			String projectName = request.getParameter("projectName");
			String projectmgrname = request.getParameter("productmanager");
//	            String teamleader = request.getParameter("teamleader");
//	            String allfunction = request.getParameter("allfunction");

			String uname = (String) session.getAttribute("username");
			String role = (String) session.getAttribute("role");
			String designation = (String) session.getAttribute("designation");

			JSONArray final_response = pmsService.getActivitiesdalaysByMGR(projectName, projectmgrname, uname, role,
					designation);

			out.print(final_response);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
		return null;
	}

	@RequestMapping(value = { "/getActivitiesdalaysByTL" }, method = RequestMethod.POST)
	public JSONArray getActivitiesdalaysByTL(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;
		try {
			out = response.getWriter();
			System.out.println("innnn getActivitiesdalaysByManager");
			String projectName = request.getParameter("projectName");
			String projectmgrname = request.getParameter("productmanager");
			String teamleader = request.getParameter("teamleader");
//	            String allfunction = request.getParameter("allfunction");

			String uname = (String) session.getAttribute("username");
			String role = (String) session.getAttribute("role");
			String designation = (String) session.getAttribute("designation");

			JSONArray final_response = pmsService.getActivitiesdalaysByTL(projectName, projectmgrname, teamleader,
					uname, role, designation);

			out.print(final_response);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
		return null;
	}

	@RequestMapping(value = { "/getDelayedProjectByFunctionName" }, method = RequestMethod.POST)
	public JSONArray getDelayedProjectByFunctionName(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {

		PrintWriter out = null;

		try {
			out = response.getWriter();
			String fullname = (String) session.getAttribute("fullname");
			String role = (String) session.getAttribute("role");
			String designation = (String) session.getAttribute("designation");

			String delayFunctionName = request.getParameter("delayFunctionName");
			String projectName = request.getParameter("projectName");
			String assignTo = request.getParameter("assignTo");

			JSONArray final_response = pmsService.getDelayedProjectByFunctionName(fullname, role, designation,
					delayFunctionName, projectName, assignTo);

			System.out.println("PMSControllerrrr response is: " + final_response);

			out.print(final_response);

			System.out.println("getDelayedProjectByFunctionName information retrieved successfully: " + final_response);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}

		// Return null since response is handled directly within the method
		return null;
	}

	@RequestMapping(value = { "/getTeamLeadAssignToActivitiesDelayedByProjectName" }, method = RequestMethod.POST)
	public JSONArray getTeamLeadAssignToActivitiesDelayedByProjectName(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {

		PrintWriter out = null;
		String sname = null;
		try {
			out = response.getWriter();
			String projectNames = request.getParameter("ProjectName");
			String fullname = (String) session.getAttribute("fullname");

			// System.out.println("ticketype:::"+location);
			JSONArray final_response = pmsService.getTeamLeadAssignToActivitiesDelayedByProjectName(projectNames,
					fullname);

			out.print(final_response);

			// System.out.println("SITE NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;
	}

	@RequestMapping(value = { "/getTeamLeaderFunctionNameByAssignTo" }, method = RequestMethod.POST)
	public JSONArray getTeamLeaderFunctionNameByAssignTo(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {

		PrintWriter out = null;
		try {

			out = response.getWriter();
			String uname = (String) session.getAttribute("username");
			String userfullname = (String) session.getAttribute("fullname");
			String role = (String) session.getAttribute("role");
			String projectName = request.getParameter("projectName");
			String assignToName = request.getParameter("assignToName");
			System.out.println("roletype of  reponse is = " + role);
			JSONArray final_response = pmsService.getTeamLeaderFunctionNameByAssignTo(uname, userfullname, role,
					projectName, assignToName);

			out.print(final_response);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
		return null;
	}

	@RequestMapping(value = { "/getproductmgrnameforDelayMD" }, method = RequestMethod.POST)
	public JSONArray getproductmgrnameforDelayMD(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {

		PrintWriter out = null;

		try {
			// Retrieve PrintWriter to write response
			out = response.getWriter();

			// Retrieve selected project name from request parameters
			String projectmgrname = request.getParameter("projectNames");

			// Call service method to get product suite information based on project name
			JSONArray final_response = pmsService.getproductmgrnameforDelayMD(projectmgrname);

			// Print product suite information to console for debugging
			System.out.println("MastersControllerrrr response is: " + final_response);

			// Write product suite information to response
			out.print(final_response);

			// Log success message
			System.out.println("Product suite information retrieved successfully: " + final_response);

		} catch (Exception e) {
			// Handle exceptions
			e.printStackTrace();
		} finally {
			// Close PrintWriter
			if (out != null) {
				out.close();
			}
		}

		// Return null since response is handled directly within the method
		return null;
	}

	@RequestMapping(value = { "/updateModifyDate" }, method = RequestMethod.POST)
	public String updateModifyDate(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside @@@@@@@  updateModifyDate");
		PrintWriter out = null;
		String reStatus = null;

		try {
			out = response.getWriter();

			HttpSession htt = request.getSession(true);
//				String uname = (String) htt.getAttribute("username");
			String crno = request.getParameter("crno");
			String tid = request.getParameter("tid");
			String status = request.getParameter("Status");
			String remark = request.getParameter("Remark");
			String End_Date = request.getParameter("End_Date");
			String fullname = (String) htt.getAttribute("fullname");
			String role = (String) session.getAttribute("role");
			String designation = (String) session.getAttribute("designation");

			reStatus = pmsService.updateModifyDate(crno, tid, status, remark, End_Date, fullname, role, designation);
			System.out.println("Update reponse is = " + reStatus);

			out.print(reStatus);
			System.out.println("below status" + reStatus);

		} catch (Exception e) {
			e.printStackTrace();

		}

		return null;

	}

	@RequestMapping(value = { "/getMyCompletedTaskList" }, method = RequestMethod.POST)
	public JSONArray getMyCompletedTaskList(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside @@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			HttpSession htt = request.getSession(true);
			String uname = (String) htt.getAttribute("username");
			String userfullname = (String) session.getAttribute("fullname");
			String role = (String) session.getAttribute("role");

			JSONArray final_response = pmsService.getMyCompletedTaskList(uname, userfullname, role);
			System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
		return null;
	}

	@RequestMapping(value = { "/ViewCompletedTaskDetails" }, method = RequestMethod.GET)
	public String ViewCompletedTaskDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Inside ViewMyTaskDetails method");

		String crno = request.getParameter("crno");
		String tid = request.getParameter("tid");

		return "Pms/ViewCompletedTaskDetails";
	}

	@RequestMapping(value = { "/getallMGRdelayActivity" }, method = RequestMethod.POST)
	public JSONArray getallMGRdelayActivity(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;
		try {
			out = response.getWriter();

			String userfullname = (String) session.getAttribute("fullname");
			String role = (String) session.getAttribute("role");
			JSONArray final_response = pmsService.getallMGRdelayActivity(userfullname,role);

			System.out.println("MastersControllerrrr response is: " + final_response);

			out.print(final_response);

			System.out.println("Product suite information retrieved successfully: " + final_response);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}
		return null;
	}

	@RequestMapping(value = { "/getImplReviseTaskDate" }, method = RequestMethod.POST)
	public JSONArray getImplReviseTaskDate(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside @@@@@@@  getImplReviseTaskDate");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			HttpSession htt = request.getSession(true);
			String uname = (String) htt.getAttribute("username");
			String tStatus = request.getParameter("TStatus");
			String role = (String) session.getAttribute("role");
			String fullname = (String) session.getAttribute("fullname");

			System.out.println("js pend status " + tStatus);
			JSONArray final_response = pmsService.getImplReviseTaskDate(uname, tStatus, role, fullname);
			System.out.println("PMSControllerrrr reponse is = " + final_response);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		return null;
	}

	@RequestMapping(value = { "/updateRevisedTaskDate" }, method = RequestMethod.POST)
	public String updateRevisedTaskDate(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside @@@@@@@ updateRevisedTaskDate");
		PrintWriter out = null;
		String reStatus = null;

		try {
			out = response.getWriter();

			HttpSession htt = request.getSession(true);
			String role = (String) htt.getAttribute("role");
			String uname = (String) htt.getAttribute("username");
//				String role = (String) htt.getAttribute("role");
			String crno = request.getParameter("crno");
			String tid = request.getParameter("tid");
			String status = request.getParameter("Status");
			String remark = request.getParameter("Remark");
			String Developer = request.getParameter("Developer");

			String updateEnd_Date = request.getParameter("updateEnd_Date");
			reStatus = pmsService.updateRevisedTaskDate(crno, tid, status, remark, Developer, updateEnd_Date, role,
					uname);
			System.out.println("Update reponse is = " + reStatus);

			out.print(reStatus);
			System.out.println("below status" + reStatus);

		} catch (Exception e) {
			e.printStackTrace();

		}

		return null;

	}

	@RequestMapping(value = { "/ViewImplReviseTaskDate" }, method = RequestMethod.GET)
	public String ViewImplReviseTaskDate(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Inside ViewImplReviseTaskDate method");

		String crno = request.getParameter("crno");
		String tid = request.getParameter("tid");

		return "Pms/ViewImplReviseTaskDate";
	}

	@RequestMapping(value = { "/getReviseTaskList" }, method = RequestMethod.POST)
	public JSONArray getReviseTaskList(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside @@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			HttpSession htt = request.getSession(true);
			String uname = (String) htt.getAttribute("username");
			String userfullname = (String) session.getAttribute("fullname");
			String role = (String) session.getAttribute("role");

			JSONArray final_response = pmsService.getReviseTaskList(uname, userfullname, role);
			System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		return null;
	}

	@RequestMapping(value = { "/ViewReviseTaskDetails" }, method = RequestMethod.GET)
	public String ViewReviseTaskDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Inside ViewMyTaskDetails method");

		String crno = request.getParameter("crno");
		String tid = request.getParameter("tid");

		return "Pms/ViewReviseTaskDetails";
	}

	@RequestMapping(value = { "/getprojectnameForMGR" }, method = RequestMethod.POST)
	public JSONArray getprojectnameForMGR(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;
		try {

			out = response.getWriter();
			String uname = (String) session.getAttribute("username");
			String userfullname = (String) session.getAttribute("fullname");
			String role = (String) session.getAttribute("role");
			System.out.println("roletype of  reponse is = " + role);
			JSONArray final_response = pmsService.getprojectnameForMGR(uname, userfullname, role);

			out.print(final_response);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
		return null;
	}

	@RequestMapping(value = { "/getDeveloperActivitiesByProjectName" }, method = RequestMethod.POST)
	public JSONArray getDeveloperActivitiesByProjectName(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {

		PrintWriter out = null;

		try {
			out = response.getWriter();

//            String projectmgrname = request.getParameter("productmanager");
			String productsuitename = request.getParameter("productsuitename");
//            String teamleader = request.getParameter("teamleader");
//            String allfunction = request.getParameter("allfunction");

			String fullname = (String) session.getAttribute("fullname");
			String role = (String) session.getAttribute("role");
			String designation = (String) session.getAttribute("designation");

			JSONArray final_response = pmsService.getDeveloperActivitiesByProjectName(fullname, role, designation,
					productsuitename);

			System.out.println("PMS response is: " + final_response);

			out.print(final_response);

			System.out.println("getDeveloperActivities information retrieved successfully: " + final_response);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}

		// Return null since response is handled directly within the method
		return null;
	}

	@RequestMapping(value = { "/getDeveloperActivityOnTrack" }, method = RequestMethod.POST)
	public JSONArray getDeveloperActivityOnTrack(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {

		PrintWriter out = null;
		try {

			out = response.getWriter();
			String uname = (String) session.getAttribute("username");
			String fullname = (String) session.getAttribute("fullname");
			String role = (String) session.getAttribute("role");
			System.out.println("roletype of  reponse is = " + role);
			JSONArray final_response = pmsService.getDeveloperActivityOnTrack(uname, fullname, role);

			out.print(final_response);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
		return null;
	}

	@RequestMapping(value = { "/getDeveloperActivities" }, method = RequestMethod.POST)
	public JSONArray getDeveloperActivities(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;

		try {
			out = response.getWriter();

//            String projectmgrname = request.getParameter("productmanager");
//            String productsuite = request.getParameter("productsuite");
//            String teamleader = request.getParameter("teamleader");
//            String allfunction = request.getParameter("allfunction");

			String uname = (String) session.getAttribute("fullname");
			String role = (String) session.getAttribute("role");
			String designation = (String) session.getAttribute("designation");

			JSONArray final_response = pmsService.getDeveloperActivities(uname, role, designation);

			System.out.println("PMS response is: " + final_response);

			out.print(final_response);

			System.out.println("getDeveloperActivities information retrieved successfully: " + final_response);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}

		// Return null since response is handled directly within the method
		return null;
	}

	@RequestMapping(value = { "/getDeveloperFunctionNameByProjectName" }, method = RequestMethod.POST)
	public JSONArray getDeveloperFunctionNameByProjectName(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {

		PrintWriter out = null;
		try {

			out = response.getWriter();
			String uname = (String) session.getAttribute("username");
			String fullname = (String) session.getAttribute("fullname");
			String role = (String) session.getAttribute("role");
			String projectName = request.getParameter("projectName");

			System.out.println("roletype of  reponse is = " + role);
			JSONArray final_response = pmsService.getDeveloperFunctionNameByProjectName(uname, fullname, role,
					projectName);

			out.print(final_response);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
		return null;
	}

	@RequestMapping(value = { "/getDeveloperActivitiesByFunctionName" }, method = RequestMethod.POST)
	public JSONArray getDeveloperActivitiesByFunctionName(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {

		PrintWriter out = null;

		try {
			out = response.getWriter();

//            String projectmgrname = request.getParameter("productmanager");
			String productsuitename = request.getParameter("productsuitename");
			String functionName = request.getParameter("functionName");

//            String teamleader = request.getParameter("teamleader");
//            String allfunction = request.getParameter("allfunction");

			String fullname = (String) session.getAttribute("fullname");
			String role = (String) session.getAttribute("role");
			String designation = (String) session.getAttribute("designation");

			JSONArray final_response = pmsService.getDeveloperActivitiesByFunctionName(fullname, role, designation,
					productsuitename, functionName);

			System.out.println("PMS response is: " + final_response);

			out.print(final_response);

			System.out.println("getDeveloperActivities information retrieved successfully: " + final_response);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}

		// Return null since response is handled directly within the method
		return null;
	}

	@RequestMapping(value = { "/getDeveloperDelayActivities" }, method = RequestMethod.POST)
	public JSONArray getDeveloperDelayActivities(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {

		PrintWriter out = null;

		try {
			out = response.getWriter();

//            String projectmgrname = request.getParameter("productmanager");
//            String productsuite = request.getParameter("productsuite");
//            String teamleader = request.getParameter("teamleader");
//            String allfunction = request.getParameter("allfunction");

			String fullname = (String) session.getAttribute("fullname");
			String role = (String) session.getAttribute("role");
			String designation = (String) session.getAttribute("designation");

			JSONArray final_response = pmsService.getDeveloperDelayActivities(fullname, role, designation);

			System.out.println("PMS response is: " + final_response);

			out.print(final_response);

			System.out.println("getDeveloperDelayActivities information retrieved successfully: " + final_response);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}

		// Return null since response is handled directly within the method
		return null;
	}

	@RequestMapping(value = { "/getDeveloperDelayActivity" }, method = RequestMethod.POST)
	public JSONArray getDeveloperDelayActivity(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;
		try {

			out = response.getWriter();
			String uname = (String) session.getAttribute("username");
			String fullname = (String) session.getAttribute("fullname");
			String role = (String) session.getAttribute("role");
			System.out.println("roletype of  reponse is = " + role);
			JSONArray final_response = pmsService.getDeveloperDelayActivity(uname, fullname, role);

			out.print(final_response);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
		return null;
	}

	@RequestMapping(value = { "/getDeveloperDelayActByProjectName" }, method = RequestMethod.POST)
	public JSONArray getDeveloperDelayActByProjectName(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {

		PrintWriter out = null;

		try {
			out = response.getWriter();

//            String projectmgrname = request.getParameter("productmanager");
//            String productsuite = request.getParameter("productsuite");
//            String teamleader = request.getParameter("teamleader");
//            String allfunction = request.getParameter("allfunction");

			String fullname = (String) session.getAttribute("fullname");
			String role = (String) session.getAttribute("role");
			String designation = (String) session.getAttribute("designation");
			String projectName = request.getParameter("productsuite");
			String functionName = request.getParameter("functionName");

			JSONArray final_response = pmsService.getDeveloperDelayActByProjectName(fullname, role, designation,
					projectName, functionName);

			System.out.println("PMS response is: " + final_response);

			out.print(final_response);

			System.out.println("getDeveloperDelayActivities information retrieved successfully: " + final_response);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}

		// Return null since response is handled directly within the method
		return null;
	}

	@RequestMapping(value = { "/getDeveloperDelayActByProjectNameOnChange" }, method = RequestMethod.POST)
	public JSONArray getDeveloperDelayActByProjectNameOnChange(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {

		PrintWriter out = null;

		try {
			out = response.getWriter();

//            String projectmgrname = request.getParameter("productmanager");
//            String productsuite = request.getParameter("productsuite");
//            String teamleader = request.getParameter("teamleader");
//            String allfunction = request.getParameter("allfunction");

			String fullname = (String) session.getAttribute("fullname");
			String role = (String) session.getAttribute("role");
			String designation = (String) session.getAttribute("designation");
			String projectName = request.getParameter("projectName");

			JSONArray final_response = pmsService.getDeveloperDelayActByProjectNameOnChange(fullname, role, designation,
					projectName);

			System.out.println("PMS response is: " + final_response);

			out.print(final_response);

			System.out.println("getDeveloperDelayActivities information retrieved successfully: " + final_response);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}

		// Return null since response is handled directly within the method
		return null;
	}

	@RequestMapping(value = { "/getDeveloperDelayActByFunctiontName" }, method = RequestMethod.POST)
	public JSONArray getDeveloperDelayActByFunctiontName(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {

		PrintWriter out = null;

		try {
			out = response.getWriter();

//            String projectmgrname = request.getParameter("productmanager");
//            String productsuite = request.getParameter("productsuite");
//            String teamleader = request.getParameter("teamleader");
//            String allfunction = request.getParameter("allfunction");

			String fullname = (String) session.getAttribute("fullname");
			String role = (String) session.getAttribute("role");
			String designation = (String) session.getAttribute("designation");
			String projectName = request.getParameter("productsuite");
			String functionName = request.getParameter("functionName");

			JSONArray final_response = pmsService.getDeveloperDelayActByFunctiontName(fullname, role, designation,
					projectName, functionName);

			System.out.println("PMS response is: " + final_response);

			out.print(final_response);

			System.out.println("getDeveloperDelayActivities information retrieved successfully: " + final_response);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}
		return null;
	}

	@RequestMapping(value = { "/getAllActivitiesMGR" }, method = RequestMethod.POST)
	public JSONArray getAllActivitiesMGR(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;

		try {
			out = response.getWriter();

			String userfullname = (String) session.getAttribute("fullname");
			String role = (String) session.getAttribute("role");
			JSONArray final_response = pmsService.getAllActivitiesMGR(userfullname, role);

			System.out.println("MastersControllerrrr response is: " + final_response);

			out.print(final_response);

			System.out.println("Product suite information retrieved successfully: " + final_response);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}
		return null;
	}

	@RequestMapping(value = { "/getTeamLeaderByMGR" }, method = RequestMethod.POST)
	public JSONArray getTeamLeaderByMGR(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;
		String sname = null;
		try {
			out = response.getWriter();
			// String moduleName = request.getParameter("moduleName");
			// System.out.println("ticketype:::"+location);
			String userfullname = (String) session.getAttribute("fullname");
			JSONArray final_response = pmsService.getTeamLeaderByMGR(userfullname);

			out.print(final_response);

			// System.out.println("SITE NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;
	}

	@RequestMapping(value = { "/getActivitiesMGRByProj" }, method = RequestMethod.POST)
	public JSONArray getActivitiesMGRByProj(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;

		try {
			out = response.getWriter();

			String userfullname = (String) session.getAttribute("fullname");
			String role = (String) session.getAttribute("role");
			String projectName = request.getParameter("projectname");
			JSONArray final_response = pmsService.getActivitiesMGRByProj(userfullname, role, projectName);

			System.out.println("MastersControllerrrr response is: " + final_response);

			out.print(final_response);

			System.out.println("Product suite information retrieved successfully: " + final_response);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}

		// Return null since response is handled directly within the method
		return null;
	}

	@RequestMapping(value = { "/getMGRTrackActivityByTL" }, method = RequestMethod.POST)
	public JSONArray getMGRTrackActivityByTL(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;

		try {
			out = response.getWriter();

			String userfullname = (String) session.getAttribute("fullname");
			String role = (String) session.getAttribute("role");
			String projectName = request.getParameter("projectname");
			String tlName = request.getParameter("tlname");

			JSONArray final_response = pmsService.getMGRTrackActivityByTL(userfullname, role, projectName, tlName);

			System.out.println("MastersControllerrrr response is: " + final_response);

			out.print(final_response);

			System.out.println("Product suite information retrieved successfully: " + final_response);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}

		// Return null since response is handled directly within the method
		return null;
	}

	@RequestMapping(value = { "/getMGRTrackActivityByDev" }, method = RequestMethod.POST)
	public JSONArray getMGRTrackActivityByDev(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;

		try {
			out = response.getWriter();

			String userfullname = (String) session.getAttribute("fullname");
			String role = (String) session.getAttribute("role");
			String projectName = request.getParameter("projectname");
			String tlName = request.getParameter("tlname");
			String devName = request.getParameter("devname");

			JSONArray final_response = pmsService.getMGRTrackActivityByDev(userfullname, role, projectName, tlName,
					devName);

			System.out.println("MastersControllerrrr response is: " + final_response);

			out.print(final_response);

			System.out.println("Product suite information retrieved successfully: " + final_response);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}
		return null;
	}

	@RequestMapping(value = { "/getMGRdelayActivityByProj" }, method = RequestMethod.POST)
	public JSONArray getMGRdelayActivityByProj(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;

		try {
			out = response.getWriter();

			String projectName = request.getParameter("projectName");
			String userfullname = (String) session.getAttribute("fullname");
			String role = (String) session.getAttribute("role");

			JSONArray final_response = pmsService.getMGRdelayActivityByProj(projectName, userfullname, role);

			System.out.println("MastersControllerrrr response is: " + final_response);

			out.print(final_response);
			System.out.println("Product suite information retrieved successfully: " + final_response);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}
		return null;
	}

	@RequestMapping(value = { "/getMGRdelayActivityByTL" }, method = RequestMethod.POST)
	public JSONArray getMGRdelayActivityByTL(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;

		try {
			out = response.getWriter();

			String projectName = request.getParameter("projectName");
			String tlname = request.getParameter("tlname");
			String userfullname = (String) session.getAttribute("fullname");

			JSONArray final_response = pmsService.getMGRdelayActivityByTL(projectName, tlname, userfullname);

			System.out.println("MastersControllerrrr response is: " + final_response);

			out.print(final_response);
			System.out.println("Product suite information retrieved successfully: " + final_response);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}
		return null;
	}

	@RequestMapping(value = { "/getMGRdelayActivityByDev" }, method = RequestMethod.POST)
	public JSONArray getMGRdelayActivityByDev(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;

		try {
			out = response.getWriter();

			String projectName = request.getParameter("projectName");
			String tlname = request.getParameter("tlname");
			String devname = request.getParameter("devname");
//			String allfunction = request.getParameter("allfunction");
			String userfullname = (String) session.getAttribute("fullname");

			JSONArray final_response = pmsService.getMGRdelayActivityByDev(projectName, tlname, devname, userfullname);

			System.out.println("MastersControllerrrr response is: " + final_response);

			out.print(final_response);
			System.out.println("Product suite information retrieved successfully: " + final_response);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}
		return null;
	}

	@RequestMapping(value = { "/getProjectListDeveloper" }, method = RequestMethod.POST)
	public JSONArray getProjectListDeveloper(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;
		try {
			out = response.getWriter();
			String methodName = request.getParameter("methodName");
			String userfullname = (String) session.getAttribute("fullname");
			String role = (String) session.getAttribute("role");
			System.out.println("Innn thodName ");
			System.out.println("methodNamemethodName " + methodName);
			JSONArray final_response = pmsService.getProjectListDeveloper(methodName, userfullname,role);

			out.print(final_response);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
		return null;
	}

	@RequestMapping(value = { "/getDeveloperExtendedDateTasks" }, method = RequestMethod.POST)
	public JSONArray getDeveloperExtendedDateTasks(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {

		PrintWriter out = null;
		try {
			out = response.getWriter();

			String fullname = (String) session.getAttribute("fullname");
			String role = (String) session.getAttribute("role");
			String designation = (String) session.getAttribute("designation");

			JSONArray final_response = pmsService.getDeveloperExtendedDateTasks(fullname, role, designation);
			System.out.println("PMS response is: " + final_response);

			out.print(final_response);
			System.out.println(" information retrieved successfully: " + final_response);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}
		return null;
	}

	@RequestMapping(value = { "/getDeveloperDelayedTasks" }, method = RequestMethod.POST)
	public JSONArray getDeveloperDelayedTasks(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;

		try {
			out = response.getWriter();

			String fullname = (String) session.getAttribute("fullname");
			String role = (String) session.getAttribute("role");
			String designation = (String) session.getAttribute("designation");

			JSONArray final_response = pmsService.getDeveloperDelayedTasks(fullname, role, designation);

			System.out.println("PMS response is: " + final_response);
			out.print(final_response);
			System.out.println("getDeveloperDelayedTasks information retrieved successfully: " + final_response);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}
		return null;
	}

	@RequestMapping(value = { "/updateMultipleEndDate" }, method = RequestMethod.POST)
	public JSONArray updateMultipleEndDate(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;
		System.out.println("INNN updateMultipleEndDate");
		try {
			out = response.getWriter();

			String fullname = (String) session.getAttribute("fullname");
			String role = (String) session.getAttribute("role");
			String designation = (String) session.getAttribute("designation");

			String updatedDates = request.getParameter("updatedDates");
//			System.out.println("Date arrayyyy "+updatedDates);			
			String final_response = pmsService.updateMultipleEndDate(fullname, role, designation, updatedDates);

			System.out.println("updateMultipleEndDate response is: " + final_response);
			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}
		return null;
	}

	@RequestMapping(value = { "/approveMultipleEndDate" }, method = RequestMethod.POST)
	public String approveMultipleEndDate(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;
		System.out.println("INNN approveMultipleEndDate");
		try {
			out = response.getWriter();

			String fullname = (String) session.getAttribute("fullname");
			String role = (String) session.getAttribute("role");
			String designation = (String) session.getAttribute("designation");

			String checkedIds = request.getParameter("checkedIds");
//			System.out.println("Date arrayyyy "+checkedIds);			

			String final_response = pmsService.approveMultipleEndDate(fullname, role, designation, checkedIds);
			System.out.println("updateMultipleEndDate response is: " + final_response);
			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}
		return null;
	}

	// 18/05
	@RequestMapping(value = { "/getProductSuiteTree" }, method = RequestMethod.POST)
	public JSONArray getProductSuiteTree(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;

		try {
			out = response.getWriter();

			JSONArray final_response = pmsService.getProductSuiteTree();

			System.out.println("PMS response is: " + final_response);
			out.print(final_response);
			System.out.println("getProductSuite: " + final_response);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}
		return null;
	}

	// 18/05
	@RequestMapping(value = { "/getSecuritySolutionTree" }, method = RequestMethod.POST)
	public JSONArray getSecuritySolutionTree(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;

		try {
			out = response.getWriter();

			String product_suite = request.getParameter("product_suite");

			JSONArray final_response = pmsService.getSecuritySolutionTree(product_suite);

			System.out.println("PMS response is: " + final_response);
			out.print(final_response);
			System.out.println("getProductSuite: " + final_response);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}
		return null;
	}

	// 18/05
	@RequestMapping(value = { "/getTreeMasterDetails" }, method = RequestMethod.POST)
	public JSONArray getTreeMasterDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		PrintWriter out = null;

		try {
			out = response.getWriter();

			String product_suite = request.getParameter("product_suite");
			String security_solution = request.getParameter("security_solution");
			String project_name = request.getParameter("project_name");

			String final_response = pmsService.getTreeMasterDetails(product_suite, security_solution, project_name);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return null;
	}

	// 18/05
	@RequestMapping(value = { "/getTreeMasterListing" }, method = RequestMethod.POST)
	public JSONArray getTreeMasterListing(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		PrintWriter out = null;
		try {
			out = response.getWriter();

			String subjectList = null;
			JSONArray final_response = pmsService.getTreeMasterListing();
			out.print(final_response);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
		return null;
	}

	// 18/05
	@RequestMapping(value = { "/deleteTreeMaster" }, method = RequestMethod.POST)
	public JSONArray deleteTreeMaster(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside deleteProductMaster Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;
		try {
			out = response.getWriter();
			int srno = Integer.parseInt(request.getParameter("srno"));

			String final_response = pmsService.deleteTreeMaster(srno);
			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		return null;

	}

	// 21/05
	@RequestMapping(value = { "/updatetreemaster" }, method = RequestMethod.POST)
	public JSONArray updatetreemaster(@RequestParam("sr_no") String srNo, ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		PrintWriter out = null;

		try {
			out = response.getWriter();

			String productsuitupdate = request.getParameter("productsuitupdate1");
			String securitysolutionupdate = request.getParameter("securitysolutionupdate11");
			String projectnameupdate = request.getParameter("projectnameupdate1");
			int sr_no = Integer.parseInt(srNo);
//				int sr_no = Integer.parseInt(request.getParameter("sr_no1")); 

			String final_response = pmsService.updatetreemaster(productsuitupdate, securitysolutionupdate,
					projectnameupdate, sr_no);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return null;
	}

	// 18/05
	@RequestMapping(value = { "/gettreesuitList" }, method = RequestMethod.POST)
	public JSONArray gettreesuitList(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;

		try {
			out = response.getWriter();
			JSONArray final_response = pmsService.gettreesuitList();
			// System.out.println("getCompositeCompanyList reponse is = " + final_response);
			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (out != null)
				out.close();
		}

		return null;
	}

	@RequestMapping(value = { "/UpdateManualPORaiseBySI" }, method = RequestMethod.POST)
	public void UpdateManualPORaiseBySI(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			@RequestParam("taskData") String taskData, @RequestParam("fileUpload") MultipartFile[] pouploadfile1) {
		PrintWriter out = null;
		String final_response = "";

		try {

			System.out.println("in UpdateManualPORaiseBySI @@@@@@@");
			out = response.getWriter();

			String loginuser = (String) session.getAttribute("username");
			String loginUserCompany = (String) session.getAttribute("companyname");

			String crno = request.getParameter("crno");
			String proposalType = request.getParameter("Proposaltype");
			String fixedyear = request.getParameter("fixedyear");
			String Subscriptionyear = request.getParameter("Subscriptionyear");
			String Perpetualyear = request.getParameter("Perpetualyear");
			String subscriptionANDperpetualYear = request.getParameter("subscriptionANDperpetualYear");

			String tennurestartdate = request.getParameter("tennurestartdate");
			String tennureenddate = request.getParameter("tennureenddate");
			String tennureMonth = request.getParameter("tennureMonth");
			String tennureYear = request.getParameter("tennureYear");

			String warrantystart = request.getParameter("warrantystart");
			String warrantyend = request.getParameter("warrantyend");
			String warrantyMonth = request.getParameter("warrantyMonth");
			String warrantyYear = request.getParameter("warrantyYear");

			String amcstartdate = request.getParameter("amcstartdate");
			String amcenddate = request.getParameter("amcenddate");
			String AMCMonth = request.getParameter("AMCMonth");
			String AMCYear = request.getParameter("AMCYear");
			String poRefNo = request.getParameter("poRefNo");

			// Call the service method to update manual PO raise
			final_response = pmsService.UpdateManualPORaiseBySI(crno, proposalType, fixedyear, Subscriptionyear,
					Perpetualyear, subscriptionANDperpetualYear, tennurestartdate, tennureenddate, tennureMonth,
					tennureYear, warrantystart, warrantyend, warrantyMonth, warrantyYear, amcstartdate, amcenddate,
					AMCMonth, AMCYear, poRefNo, taskData, pouploadfile1);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
			if (out != null) {
				out.print("error");
			}
		}
	}

	@RequestMapping(value = { "/savefileUploadKey" }, method = RequestMethod.POST)
	public void savefileUploadKey(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			@RequestParam("file") MultipartFile[] fileUploadKey) {
		PrintWriter out = null;
		String final_response = "";

		try {
			System.out.println("in savefileUploadKey @@@@@@@");
			out = response.getWriter();
			System.out.println("file " + Arrays.toString(fileUploadKey));

			for (MultipartFile file : fileUploadKey) {
				System.out.println("File name: " + file.getOriginalFilename() + ", size: " + file.getSize());
			}

			// Call the service method to handle the files
			final_response = pmsService.savefileUploadKey(fileUploadKey);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
			if (out != null) {
				out.print("error");
			}
		}
	}

	// 24/05
	@RequestMapping(value = { "/updateMultipleData" }, method = RequestMethod.POST)
	public String updateMultipleData(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;
		System.out.println("INNN updateMultipleData");
		System.out.println("CheckedIds:");
		try {
			out = response.getWriter();

			String checkedIds = request.getParameter("checkedIds");
			System.out.println("CheckedIds:" + checkedIds);

			String final_response = pmsService.updateMultipleData(checkedIds);
			System.out.println("updateMultipleEndDate response is: " + final_response);
			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}
		return null;
	}

	// 01/06
	@RequestMapping(value = { "/getprojectonhold" }, method = RequestMethod.POST)
	public JSONArray getprojectonhold(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;
		try {
			out = response.getWriter();
			// String module_name = request.getParameter("module_name");

			// System.out.println("ticketype:::"+location);
			JSONArray final_response = pmsService.getprojectonhold();

			out.print(final_response);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
		return null;
	}

	
	@RequestMapping(value = { "/ReactivateAccount" }, method = RequestMethod.GET)
	public String ReactivateAccount(ModelMap model, HttpServletRequest request, HttpServletResponse response) {

	return "Pms/ReactivateAccount";
	}	
	
	
	
	//28/10
	@RequestMapping(value = { "/provideFeedback" }, method = RequestMethod.GET)
	public String provideFeedback(ModelMap model, HttpServletRequest request, HttpServletResponse response) {

	return "Pms/provideFeedback";
	}	
	//
	
	//28/10
	@RequestMapping(value = { "/clientFeedback" }, method = RequestMethod.GET)
	public String clientFeedback(ModelMap model, HttpServletRequest request, HttpServletResponse response) {

	return "Pms/clientFeedback";
	}	
	//

	
	@RequestMapping(value = { "/getDeactivatedAccounts" }, method = RequestMethod.POST)
    public JSONArray getDeactivatedAccounts(ModelMap model, HttpServletRequest request, HttpServletResponse response,
            HttpSession session) {

        PrintWriter out = null;   
        try {
            out = response.getWriter();
            
            String fullname = (String) session.getAttribute("fullname");
			String role = (String) session.getAttribute("role");
			String designation = (String) session.getAttribute("designation");
			
            JSONArray final_response = pmsService.getDeactivatedAccounts(fullname,role,designation);
            System.out.println("PMS response is: " + final_response);

            out.print(final_response);
            System.out.println(" information retrieved successfully: " + final_response);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
        return null;
    }
	
	@RequestMapping(value = { "/activateAccounts" }, method = RequestMethod.POST)
    public String activateAccounts(ModelMap model, HttpServletRequest request, HttpServletResponse response,
            HttpSession session) {

        PrintWriter out = null;
        System.out.println("INNN activateAccounts");
        try {
            out = response.getWriter();
            
            String fullname = (String) session.getAttribute("fullname");
			String role = (String) session.getAttribute("role");
			String designation = (String) session.getAttribute("designation");
			
			String checkedIds = request.getParameter("checkedIds");
//			System.out.println("Date arrayyyy "+checkedIds);		
			
			

			String final_response = pmsService.activateAccounts(fullname,role,designation, checkedIds);
			System.out.println("activateAccounts response is: " + final_response);
            out.print(final_response);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
        return null;
    }
	
	
	
	
	
	//05/06
		@RequestMapping(value = { "/getAllDeveloperList" }, method = RequestMethod.POST)
		public JSONArray getAllDeveloperList(ModelMap model, HttpServletRequest request, HttpServletResponse response,
				HttpSession session) {

			PrintWriter out = null;
			String sname = null;
			try {
				out = response.getWriter();

				String role = (String) session.getAttribute("role");
				
				JSONArray final_response = pmsService.getAllDeveloperList(role);

				out.print(final_response);

			} catch (Exception e) {
				e.printStackTrace();
			}

			finally {
				out.close();
			}

			return null;
		}
		
		
		
		
		//07/06
		@RequestMapping(value = { "/getReassignTaskSideDetails" }, method = RequestMethod.POST)
		public JSONArray getReassignTaskSideDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
				HttpSession session) {

			PrintWriter out = null;
			String sname = null;
			try {
				out = response.getWriter();
				System.out.println("in getReassignTaskSideDetails");
				String fullname = (String) session.getAttribute("fullname");
				String role = (String) session.getAttribute("role");
				
				JSONArray final_response = pmsService.getReassignTaskSideDetails(role, fullname);

				out.print(final_response);

			} catch (Exception e) {
				e.printStackTrace();
			}

			finally {
				out.close();
			}

			return null;
		}
		
		
		
		
		//10/06
		@RequestMapping(value = { "/reassinTaskToDeveloper" }, method = RequestMethod.POST)
	    public String reassinTaskToDeveloper(ModelMap model, HttpServletRequest request, HttpServletResponse response,
	            HttpSession session) {

	        PrintWriter out = null;
	        System.out.println("INNN reassinTaskToDeveloper");
	        try {
	            out = response.getWriter();
	            
	            String fullname = (String) session.getAttribute("fullname");
				String role = (String) session.getAttribute("role");
				String designation = (String) session.getAttribute("designation");
				
				//String checkedIds = request.getParameter("checkedIds");
				String selectedNames = request.getParameter("selectedNames");
				System.out.println("Date arrayyyy selectedNames"+selectedNames);			

				String final_response = pmsService.reassinTaskToDeveloper(fullname,role,designation, selectedNames);
				System.out.println("reassinTaskToDeveloper response is: " + final_response);
	            out.print(final_response);

	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            if (out != null) {
	                out.close();
	            }
	        }
	        return null;
	    }
		
		
		
		//18/06
		@RequestMapping(value = { "/ActivitiesCompletedcount" }, method = RequestMethod.POST)
		public JSONArray ActivitiesCompletedcount(ModelMap model, HttpServletRequest request, HttpServletResponse response,
				HttpSession session) {

			PrintWriter out = null;
			try {
				out = response.getWriter();
				// String module_name = request.getParameter("module_name");

				// System.out.println("ticketype:::"+location);
				String role = (String) session.getAttribute("role");
				System.out.println("Role Type of User::"+role);
				
				String userfullname = (String) session.getAttribute("fullname");
				
				JSONArray final_response = pmsService.ActivitiesCompletedcount(role,userfullname);

				out.print(final_response);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				out.close();
			}
			return null;
		}
		//
		
		
		
		
		//28/06
		@RequestMapping(value = { "/getprojectonholdformgr" }, method = RequestMethod.POST)
		public JSONArray getprojectonholdformgr(ModelMap model, HttpServletRequest request, HttpServletResponse response,
				HttpSession session) {

				PrintWriter out = null;
				try {
					out = response.getWriter();
					// String module_name = request.getParameter("module_name");

					// System.out.println("ticketype:::"+location);
					String role = (String) session.getAttribute("role");
					
					String userfullname = (String) session.getAttribute("fullname");
					
					JSONArray final_response = pmsService.getprojectonholdformgr(role,userfullname);

					out.print(final_response);
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					out.close();
				}
				return null;
			}
		//
		
		
		@RequestMapping(value = { "/getMaskedPOList" }, method = RequestMethod.POST)
		public JSONArray getMaskedPOList(ModelMap model, HttpServletRequest request, HttpServletResponse response,
				HttpSession session) {
			System.out.println("Inside @@@@@@@ ");
			PrintWriter out = null;

			try {
				out = response.getWriter();

				HttpSession htt = request.getSession(true);
//				String uname = (String) htt.getAttribute("username");
//				String userfullname = (String) session.getAttribute("fullname");
				String role = (String) session.getAttribute("role");

				JSONArray final_response = pmsService.getMaskedPOList(role);
				System.out.println("MastersControllerrrr reponse is = " + final_response);

				out.print(final_response);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				out.close();
			}
			return null;
		}
		
		
		
		
			//17/08
				@RequestMapping(value = { "/ActivitiesCompletedcountNew" }, method = RequestMethod.POST)
				public JSONArray ActivitiesCompletedcountNew(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {

					PrintWriter out = null;
					try {
						out = response.getWriter();
						// String module_name = request.getParameter("module_name");

						// System.out.println("ticketype:::"+location);
						String role = (String) session.getAttribute("role");
						System.out.println("Role Type of User::"+role);
						
						String userfullname = (String) session.getAttribute("fullname");
						
						String methodName= request.getParameter("methodName");
						
						JSONArray final_response = pmsService.ActivitiesCompletedcountNew(role,userfullname,methodName);

						out.print(final_response);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						out.close();
					}
					return null;
				}
				//Mayur Changes 22-08-2024
				
				@RequestMapping(value = { "/totalprojectNamesList" }, method = RequestMethod.POST)
				public JSONArray totalprojectNamesList(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {

					PrintWriter out = null;
					try {
						out = response.getWriter();
						System.out.println("Innn totalprojectNamesList ");
						
						JSONArray final_response = pmsService.totalprojectNamesList();

						out.print(final_response);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						out.close();
					}
					return null;
				}
				
				@RequestMapping(value = { "/totalprojectbyName" }, method = RequestMethod.POST)
				public JSONArray totalprojectbyName(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {

					PrintWriter out = null;
					try {
						out = response.getWriter();
						System.out.println("Innn totalprojectDetails ");
						String selected_Project = request.getParameter("selected_Project");
						String productSuite = request.getParameter("productSuite");
						String productTool = request.getParameter("productTool");
						String managerName = request.getParameter("managerName");
						String status = request.getParameter("status");
						
						
						System.out.println("selected_Project "+selected_Project);
						System.out.println("productSuite "+productSuite);
						System.out.println("productTool "+productTool);
						System.out.println("managerName "+managerName);
						System.out.println("status "+status);

						
						JSONArray final_response = pmsService.totalprojectbyName(selected_Project,productSuite,productTool,managerName,status);

						out.print(final_response);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						out.close();
					}
					return null;
				}
				
				@RequestMapping(value = { "/getProductSuiteTotalProj" }, method = RequestMethod.POST)
				public JSONArray getProductSuiteTotalProj(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {

					PrintWriter out = null;
					try {
						out = response.getWriter();
						System.out.println("Innn getProductSuite ");
						
						JSONArray final_response = pmsService.getProductSuiteTotalProj();

						out.print(final_response);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						out.close();
					}
					return null;
				}
				
				@RequestMapping(value = { "/getProductToolsTotalProj" }, method = RequestMethod.POST)
				public JSONArray getProductToolsTotalProj(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {

					PrintWriter out = null;
					try {
						out = response.getWriter();
						System.out.println("Innn getProductToolsTotalProj ");
						
						JSONArray final_response = pmsService.getProductToolsTotalProj();

						out.print(final_response);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						out.close();
					}
					return null;
				}
				
				@RequestMapping(value = { "/getManagerTotalProj" }, method = RequestMethod.POST)
				public JSONArray getManagerTotalProj(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {

					PrintWriter out = null;
					try {
						out = response.getWriter();
						System.out.println("Innn getManagerTotalProj ");
						
						JSONArray final_response = pmsService.getManagerTotalProj();

						out.print(final_response);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						out.close();
					}
					return null;
				}
				
				@RequestMapping(value = { "/getStatusTotalProj" }, method = RequestMethod.POST)
				public JSONArray getStatusTotalProj(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {

					PrintWriter out = null;
					try {
						out = response.getWriter();
						System.out.println("Innn getStatusTotalProj ");
						
						JSONArray final_response = pmsService.getStatusTotalProj();

						out.print(final_response);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						out.close();
					}
					return null;
				}
				
				
				@RequestMapping(value = { "/getprodSuiteByProjName" }, method = RequestMethod.POST)
				public JSONArray getprodSuiteByProjName(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {

					PrintWriter out = null;
					try {
						out = response.getWriter();
						System.out.println("Innn getStatusTotalProj ");
						String selected_Project = request.getParameter("selected_Project");
						
						JSONArray final_response = pmsService.getprodSuiteByProjName(selected_Project);

						out.print(final_response);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						out.close();
					}
					return null;
				}
				
				@RequestMapping(value = { "/getprodToolByProdSuite" }, method = RequestMethod.POST)
				public JSONArray getprodToolByProdSuite(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {

					PrintWriter out = null;
					try {
						out = response.getWriter();
						System.out.println("Innn getprodToolByProdSuite ");
						
						String productSuite = request.getParameter("productSuite");
						
						JSONArray final_response = pmsService.getprodToolByProdSuite(productSuite);

						out.print(final_response);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						out.close();
					}
					return null;
				}
				
				@RequestMapping(value = { "/getProductToolTotalAct" }, method = RequestMethod.POST)
				public JSONArray getProductToolTotalAct(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {

					PrintWriter out = null;
					try {
						out = response.getWriter();
						System.out.println("Innn getProductToolTotalAct ");
					
						JSONArray final_response = pmsService.getProductToolTotalAct();

						out.print(final_response);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						out.close();
					}
					return null;
				}
				
				@RequestMapping(value = { "/getManagerByProdTool" }, method = RequestMethod.POST)
				public JSONArray getManagerByProdTool(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {

					PrintWriter out = null;
					try {
						out = response.getWriter();
						System.out.println("Innn getManagerByProdTool ");
					
						String productTool = request.getParameter("productTool");
						
					
						JSONArray final_response = pmsService.getManagerByProdTool(productTool);

						out.print(final_response);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						out.close();
					}
					return null;
				}
				
				
				@RequestMapping(value = { "/getMangerNameTotalAct" }, method = RequestMethod.POST)
				public JSONArray getMangerNameTotalAct(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {

					PrintWriter out = null;
					try {
						out = response.getWriter();
						System.out.println("Innn getMangerNameTotalAct ");
					
						JSONArray final_response = pmsService.getMangerNameTotalAct();

						out.print(final_response);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						out.close();
					}
					return null;
				}
				
				
				@RequestMapping(value = { "/getStatusByManager" }, method = RequestMethod.POST)
				public JSONArray getStatusByManager(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {

					PrintWriter out = null;
					try {
						out = response.getWriter();
						System.out.println("Innn getStatusByManager ");
//						String selected_Project = request.getParameter("selected_Project");
//						String productSuite = request.getParameter("productSuite");
//						String productTool = request.getParameter("productTool");
						String managerName = request.getParameter("managerName");
					
						JSONArray final_response = pmsService.getStatusByManager(managerName);

						out.print(final_response);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						out.close();
					}
					return null;
				}
				
				@RequestMapping(value = { "/getStatusTotalProject" }, method = RequestMethod.POST)
				public JSONArray getStatusTotalProject(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {

					PrintWriter out = null;
					try {
						out = response.getWriter();
						System.out.println("Innn getStatusTotalProject ");
					
						JSONArray final_response = pmsService.getStatusTotalProject();

						out.print(final_response);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						out.close();
					}
					return null;
				}
				
				
				//Mayur Chnages 23-08-2024
				//			Cmplte Project ////
				@RequestMapping(value = { "/cmplteprojectList" }, method = RequestMethod.POST)
				public JSONArray cmplteprojectList(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {

					PrintWriter out = null;
					try {
						out = response.getWriter();
						System.out.println("Innn cmplteprojectList ");
						
						JSONArray final_response = pmsService.cmplteprojectList();

						out.print(final_response);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						out.close();
					}
					return null;
				}
				
				@RequestMapping(value = { "/getProductSuiteCmplteProj" }, method = RequestMethod.POST)
				public JSONArray getProductSuiteCmplteProj(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {

					PrintWriter out = null;
					try {
						out = response.getWriter();
						System.out.println("Innn getProductSuiteCmplteProj ");
						
						JSONArray final_response = pmsService.getProductSuiteCmplteProj();

						out.print(final_response);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						out.close();
					}
					return null;
				}
				
				@RequestMapping(value = { "/productToolCmpltProj" }, method = RequestMethod.POST)
				public JSONArray productToolCmpltProj(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {

					PrintWriter out = null;
					try {
						out = response.getWriter();
						System.out.println("Innn productToolCmpltProj ");
						
						JSONArray final_response = pmsService.productToolCmpltProj();

						out.print(final_response);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						out.close();
					}
					return null;
				}
				
				@RequestMapping(value = { "/getManagerCmplteProj" }, method = RequestMethod.POST)
				public JSONArray getManagerCmplteProj(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {

					PrintWriter out = null;
					try {
						out = response.getWriter();
						System.out.println("Innn getManagerCmplteProj ");
						
						JSONArray final_response = pmsService.getManagerCmplteProj();

						out.print(final_response);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						out.close();
					}
					return null;
				}
				
				@RequestMapping(value = { "/getprojectNameCmplteProject" }, method = RequestMethod.POST)
				public JSONArray getprojectNameCmplteProject(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {

					PrintWriter out = null;
					try {
						out = response.getWriter();
						System.out.println("Innn getprojectNameCmplteProject ");
						
						String projectName = request.getParameter("projectName");
						
						JSONArray final_response = pmsService.getprojectNameCmplteProject(projectName);

						out.print(final_response);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						out.close();
					}
					return null;
				}
				
				

				@RequestMapping(value = { "/getTotalcompletedprojectList" }, method = RequestMethod.POST)
				public JSONArray getTotalcompletedprojectList(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {

					PrintWriter out = null;
					try {
						out = response.getWriter();
						System.out.println("Innn getTotalcompletedprojectList ");
						
						String projectName = request.getParameter("projectName");
						String productSuite = request.getParameter("productSuite");
						String productTool = request.getParameter("productTool");
						String managerName = request.getParameter("managerName");
						
						JSONArray final_response = pmsService.getTotalcompletedprojectList(projectName,productSuite,productTool,managerName);

						out.print(final_response);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						out.close();
					}
					return null;
				}
				
				
				@RequestMapping(value = { "/getproductSuiteCmplteProject" }, method = RequestMethod.POST)
				public JSONArray getproductSuiteCmplteProject(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {

					PrintWriter out = null;
					try {
						out = response.getWriter();
						System.out.println("Innn getproductSuiteCmplteProject ");
						
						String productSuite = request.getParameter("productSuite");
						
						JSONArray final_response = pmsService.getproductSuiteCmplteProject(productSuite);

						out.print(final_response);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						out.close();
					}
					return null;
				}
				
				@RequestMapping(value = { "/getmanagerCmplteProject" }, method = RequestMethod.POST)
				public JSONArray getmanagerCmplteProject(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {

					PrintWriter out = null;
					try {
						out = response.getWriter();
						System.out.println("Innn getmanagerCmplteProject ");
						
						String productTool = request.getParameter("productTool");
						
						JSONArray final_response = pmsService.getmanagerCmplteProject(productTool);

						out.print(final_response);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						out.close();
					}
					return null;
				}
				
				@RequestMapping(value = { "/getProductToolsCmplProj" }, method = RequestMethod.POST)
				public JSONArray getProductToolsCmplProj(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {

					PrintWriter out = null;
					try {
						out = response.getWriter();
						System.out.println("Innn getProductToolsCmplProj ");
						
						
						
						JSONArray final_response = pmsService.getProductToolsCmplProj();

						out.print(final_response);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						out.close();
					}
					return null;
				}
				
				
				//On Hold Project Filter
				@RequestMapping(value = { "/onHoldprojectList" }, method = RequestMethod.POST)
				public JSONArray onHoldprojectList(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {

					PrintWriter out = null;
					try {
						out = response.getWriter();
						System.out.println("Innn onHoldprojectList ");
						
						JSONArray final_response = pmsService.onHoldprojectList();

						out.print(final_response);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						out.close();
					}
					return null;
				}
				
				@RequestMapping(value = { "/getProductSuiteonHoldProj" }, method = RequestMethod.POST)
				public JSONArray getProductSuiteonHoldProj(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {

					PrintWriter out = null;
					try {
						out = response.getWriter();
						System.out.println("Innn getProductSuiteonHoldProj ");
						
						JSONArray final_response = pmsService.getProductSuiteonHoldProj();

						out.print(final_response);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						out.close();
					}
					return null;
				}
				
				@RequestMapping(value = { "/getProductToolsOnHoldProj" }, method = RequestMethod.POST)
				public JSONArray getProductToolsOnHoldProj(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {

					PrintWriter out = null;
					try {
						out = response.getWriter();
						System.out.println("Innn getProductToolsOnHoldProj ");
						
						
						
						JSONArray final_response = pmsService.getProductToolsOnHoldProj();

						out.print(final_response);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						out.close();
					}
					return null;
				}
				
				@RequestMapping(value = { "/getManagerOnHoldProj" }, method = RequestMethod.POST)
				public JSONArray getManagerOnHoldProj(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {

					PrintWriter out = null;
					try {
						out = response.getWriter();
						System.out.println("Innn getManagerOnHoldProj ");
						
						JSONArray final_response = pmsService.getManagerOnHoldProj();

						out.print(final_response);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						out.close();
					}
					return null;
				}
				
				
				@RequestMapping(value = { "/getprojectonholdDataTable" }, method = RequestMethod.POST)
				public JSONArray getprojectonholdDataTable(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {

					PrintWriter out = null;
					try {
						out = response.getWriter();
						 String projectName = request.getParameter("projectName");
						 String projectSuite = request.getParameter("projectSuite");
						 String projectTool = request.getParameter("projectTool");
						 String managerName = request.getParameter("managerName");

						
						JSONArray final_response = pmsService.getprojectonholdDataTable(projectName,projectSuite,projectTool,managerName);

						out.print(final_response);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						out.close();
					}
					return null;
				}
				
				@RequestMapping(value = { "/getPSuiteonHold" }, method = RequestMethod.POST)
				public JSONArray getPSuiteonHold(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {

					PrintWriter out = null;
					try {
						out = response.getWriter();
						System.out.println("Innn getPSuiteonHold ");
						
						String projectName = request.getParameter("projectName");
						
						JSONArray final_response = pmsService.getPSuiteonHold(projectName);

						out.print(final_response);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						out.close();
					}
					return null;
				}
				
				@RequestMapping(value = { "/getPToolOnHold" }, method = RequestMethod.POST)
				public JSONArray getPToolOnHold(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {

					PrintWriter out = null;
					try {
						out = response.getWriter();
						System.out.println("Innn getPToolOnHold ");
						
						String productSuite = request.getParameter("productSuite");
						
						JSONArray final_response = pmsService.getPToolOnHold(productSuite);

						out.print(final_response);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						out.close();
					}
					return null;
				}
				
				
				@RequestMapping(value = { "/getPManagerOnHold" }, method = RequestMethod.POST)
				public JSONArray getPManagerOnHold(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {

					PrintWriter out = null;
					try {
						out = response.getWriter();
						System.out.println("Innn getPManagerOnHold ");
						
						String productTool = request.getParameter("productTool");
						
						JSONArray final_response = pmsService.getPManagerOnHold(productTool);

						out.print(final_response);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						out.close();
					}
					return null;
				}
				
	
// Shubham --delay project 23.08.24
				
				@RequestMapping(value = { "/delayProjectList" }, method = RequestMethod.POST)
				public JSONArray delayProjectList(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {

					PrintWriter out = null;
					try {
						out = response.getWriter();
						System.out.println("Innn cmplteprojectList ");
						
//						JSONArray final_response = pmsService.cmplteprojectList();
						JSONArray final_response = pmsService.delayProjectList();

						out.print(final_response);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						out.close();
					}
					return null;
				}
				
				@RequestMapping(value = { "/getProductSuiteDelayProj" }, method = RequestMethod.POST)
				public JSONArray getProductSuiteDelayProj(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {

					PrintWriter out = null;
					try {
						out = response.getWriter();
						System.out.println("Innn getProductSuiteDelayProj ");
						
//						JSONArray final_response = pmsService.getProductSuiteCmplteProj();
						JSONArray final_response = pmsService.getProductSuiteDelayProj();

						out.print(final_response);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						out.close();
					}
					return null;
				}
				
				@RequestMapping(value = { "/productToolDelayProj" }, method = RequestMethod.POST)
				public JSONArray productToolDelayProj(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {

					PrintWriter out = null;
					try {
						out = response.getWriter();
						System.out.println("Innn productToolDelayProj ");
						
//						JSONArray final_response = pmsService.productToolCmpltProj();
						JSONArray final_response = pmsService.productToolDelayProj();

						out.print(final_response);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						out.close();
					}
					return null;
				}
				
				@RequestMapping(value = { "/getManagerDelayProj" }, method = RequestMethod.POST)
				public JSONArray getManagerDelayProj(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {

					PrintWriter out = null;
					try {
						out = response.getWriter();
						System.out.println("Innn getManagerDelayProj ");
						
//						JSONArray final_response = pmsService.getManagerCmplteProj();
						JSONArray final_response = pmsService.getManagerDelayProj();

						out.print(final_response);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						out.close();
					}
					return null;
				}
				
				 
				
				@RequestMapping(value = { "/getDelayedProjectListByName" }, method = RequestMethod.POST)
				public JSONArray getDelayedProjectListByName(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {

					PrintWriter out = null;
					try {
						out = response.getWriter();
						System.out.println("Innn getTotalcompletedprojectList ");
						
						String projectName = request.getParameter("projectName");
						String productSuite = request.getParameter("productSuite");
						String productTool = request.getParameter("productTool");
						String managerName = request.getParameter("managerName");
						
						JSONArray final_response = pmsService.getTotalDelayprojectList(projectName,productSuite,productTool,managerName);

						out.print(final_response);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						out.close();
					}
					return null;
				}
				
				
		// onchange 
				
				@RequestMapping(value = { "/getProdSuiteByProject" }, method = RequestMethod.POST)
				public JSONArray getProdSuiteByProject(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {

					PrintWriter out = null;
					try {
						out = response.getWriter();
						System.out.println("Innn getprojectNameCmplteProject ");
						
						String projectName = request.getParameter("projectName");
						
						JSONArray final_response = pmsService.getProdSuiteByProject(projectName); 
 
						out.print(final_response);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						out.close();
					}
					return null;
				}
				
				

				@RequestMapping(value = { "/getDelayProdToolBySuite" }, method = RequestMethod.POST)
				public JSONArray getDelayProdToolBySuite(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {

					PrintWriter out = null;
					try {
						out = response.getWriter();
						System.out.println("Innn getDelayProdToolBySuite ");
						
						String productSuite = request.getParameter("productSuite");
						
						JSONArray final_response = pmsService.getDelayProdToolBySuite(productSuite);   //getproductSuiteCmplteProject

						out.print(final_response);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						out.close();
					}
					return null;
				}
				
				
				@RequestMapping(value = { "/getDelayManagerByTool" }, method = RequestMethod.POST)
				public JSONArray getDelayManagerByTool(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {

					PrintWriter out = null;
					try {
						out = response.getWriter();
						System.out.println("Innn getmanagerCmplteProject ");
						
						String productTool = request.getParameter("productTool");
						
						JSONArray final_response = pmsService.getDelayManagerByTool(productTool);  // getmanagerCmplteProject

						out.print(final_response);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						out.close();
					}
					return null;
				}
				
				
				
				//03/09/2024
				@RequestMapping(value = { "/getEmployeeDataForHR" }, method = RequestMethod.POST)
				public JSONArray getEmployeeDataForHR(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {

					PrintWriter out = null;
					try {
						out = response.getWriter();
						System.out.println("Innn getEmployeeDataForHR ");
						
						
						JSONArray final_response = pmsService.getEmployeeDataForHR(); 
						System.out.println("final_response empData "+final_response);

						out.print(final_response);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						out.close();
					}
					return null;
				}
				//
				
				
				
				//03/09/2024
				@RequestMapping(value = { "/getEmployeeDataCount" }, method = RequestMethod.POST)
				public JSONArray getEmployeeDataCount(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {

					PrintWriter out = null;
					try {
						out = response.getWriter();
						System.out.println("Innn getEmployeeDataForHR ");
						
						
						JSONArray final_response = pmsService.getEmployeeDataCount(); 
						System.out.println("final_response empData "+final_response);

						out.print(final_response);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						out.close();
					}
					return null;
				}
				
				//
				
				
				//04/09
				
				@RequestMapping(value = { "/getEmployeeCountsByRole" }, method = RequestMethod.POST)
				public JSONArray getEmployeeCountsByRole(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {

					PrintWriter out = null;
					try {
						out = response.getWriter();
						System.out.println("Innn getEmployeeDataForHR ");
						
						
						JSONArray final_response = pmsService.getEmployeeCountsByRole(); 
						System.out.println("final_response empData "+final_response);

						out.print(final_response);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						out.close();
					}
					return null;
				}
				//
				
				
				//05/09/2024
				
				@RequestMapping(value = { "/getEmployeeDataOfNewEmps" }, method = RequestMethod.POST)
				public JSONArray getEmployeeDataOfNewEmps(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {

					PrintWriter out = null;
					try {
						out = response.getWriter();
						System.out.println("Innn getEmployeeDataForHR ");
						
						
						JSONArray final_response = pmsService.getEmployeeDataOfNewEmps(); 
						System.out.println("final_response empData "+final_response);

						out.print(final_response);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						out.close();
					}
					return null;
				}
				//
				
				
				
				//06/09/2024
				@RequestMapping(value = { "/getTotalEmployees" }, method = RequestMethod.POST)
				public JSONArray getTotalEmployees(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {

					PrintWriter out = null;
					try {
						out = response.getWriter();
						
						JSONArray final_response = pmsService.getTotalEmployees();

						out.print(final_response);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						out.close();
					}
					return null;
				}
				
				
				@RequestMapping(value = { "/getActiveEmpsOnPms" }, method = RequestMethod.POST)
				public JSONArray getActiveEmpsOnPms(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {

					PrintWriter out = null;
					try {
						out = response.getWriter();
						
						JSONArray final_response = pmsService.getActiveEmpsOnPms();

						out.print(final_response);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						out.close();
					}
					return null;
				}
				//
				
				
				//09/09
				@RequestMapping(value = { "/getMaleEmps" }, method = RequestMethod.POST)
				public JSONArray getMaleEmps(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {

					PrintWriter out = null;
					try {
						out = response.getWriter();
						
						JSONArray final_response = pmsService.getMaleEmps();

						out.print(final_response);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						out.close();
					}
					return null;
				}
				//
				
				
				
				//09/09
				@RequestMapping(value = { "/getFemaleEmps" }, method = RequestMethod.POST)
				public JSONArray getFemaleEmps(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {

					PrintWriter out = null;
					try {
						out = response.getWriter();
						
						JSONArray final_response = pmsService.getFemaleEmps();

						out.print(final_response);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						out.close();
					}
					return null;
				}
				//
				
				
				
				//11/09
				@RequestMapping(value = { "/getProjectDetails1" }, method = RequestMethod.POST)
			    public JSONArray getProjectDetails1(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {
					

					PrintWriter out = null;
					try {
						out = response.getWriter();
						
						String phaseName=null;
						
						JSONArray final_response = pmsService.getAssigneProjectNames(phaseName);

						out.print(final_response);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						out.close();
					}
					return null;
				
			    }
				//
				
				
				
				//16/09
				@RequestMapping(value = { "/getAssignTaskDetails" }, method = RequestMethod.POST)
				public JSONArray getAssignTaskDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {

					PrintWriter out = null;
					String sname = null;
					try {
						out = response.getWriter();
						String selectrddetails = request.getParameter("selectrddetails");
						// System.out.println("ticketype:::"+location);
						JSONArray final_response = pmsService.getAssignTaskDetails(selectrddetails);

						out.print(final_response);

						// System.out.println("SITE NAME GET SUCCESS");

					} catch (Exception e) {
						e.printStackTrace();
					}

					finally {
						out.close();
					}

					return null;
				}
				//
				
				
				
				
				//10/10
				@RequestMapping(value = { "/ActivitiesOnHoldcount" }, method = RequestMethod.POST)
				public JSONArray ActivitiesOnHoldcount(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {

					PrintWriter out = null;
					try {
						out = response.getWriter();
						// String module_name = request.getParameter("module_name");

						// System.out.println("ticketype:::"+location);
						String role = (String) session.getAttribute("role");
						System.out.println("Role Type of User::"+role);
						
						String userfullname = (String) session.getAttribute("fullname");
						
						JSONArray final_response = pmsService.ActivitiesOnHoldcount(role,userfullname);

						out.print(final_response);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						out.close();
					}
					return null;
				}
				//
				
				
				
				//17/10
				@RequestMapping(value = { "/getDeveloperExtendedStartEndDateTasks" }, method = RequestMethod.POST)
				public JSONArray getDeveloperExtendedStartEndDateTasks(ModelMap model, HttpServletRequest request,
						HttpServletResponse response, HttpSession session) {

					PrintWriter out = null;
					try {
						out = response.getWriter();

						String fullname = (String) session.getAttribute("fullname");
						String role = (String) session.getAttribute("role");
						String designation = (String) session.getAttribute("designation");

						JSONArray final_response = pmsService.getDeveloperExtendedStartEndDateTasks(fullname, role, designation);
						System.out.println("PMS response is: " + final_response);

						out.print(final_response);
						System.out.println(" information retrieved successfully: " + final_response);

					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						if (out != null) {
							out.close();
						}
					}
					return null;
				}
				//
				
				
				
				
				//17/10
				@RequestMapping(value = { "/updateMultipleStartEndDate" }, method = RequestMethod.POST)
				public JSONArray updateMultipleStartEndDate(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {

					PrintWriter out = null;
					System.out.println("INNN updateMultipleEndDate");
					try {
						out = response.getWriter();

						String fullname = (String) session.getAttribute("fullname");
						String role = (String) session.getAttribute("role");
						String designation = (String) session.getAttribute("designation");

						String updatedStartDates = request.getParameter("updatedStartDates");
						String updatedEndDates = request.getParameter("updatedEndDates");
						String updateDatesReason = request.getParameter("updateDatesReason");
						

						System.out.println("ARRAYARRAY::::"+updatedEndDates+"hwhh::"+updateDatesReason);
						
//						System.out.println("Date arrayyyy "+updatedDates);			
						String final_response = pmsService.updateMultipleStartEndDate(fullname, role, designation, updatedStartDates, updatedEndDates, updateDatesReason);

						System.out.println("updateMultipleEndDate response is: " + final_response);
						out.print(final_response);

					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						if (out != null) {
							out.close();
						}
					}
					return null;
				}
				//
				
				
				//17/10
				@RequestMapping(value = { "/approveMultipleStartEndDateMan" }, method = RequestMethod.POST)
				public String approveMultipleStartEndDateMan(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {

					PrintWriter out = null;
					System.out.println("INNN approveMultipleEndDate");
					try {
						out = response.getWriter();

						String fullname = (String) session.getAttribute("fullname");
						String role = (String) session.getAttribute("role");
						String designation = (String) session.getAttribute("designation");

						String checkedIds = request.getParameter("checkedIds");
//						System.out.println("Date arrayyyy "+checkedIds);			

						String final_response = pmsService.approveMultipleStartEndDateMan(fullname, role, designation, checkedIds);
						System.out.println("updateMultipleEndDate response is: " + final_response);
						out.print(final_response);

					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						if (out != null) {
							out.close();
						}
					}
					return null;
				}
				//
				
				
				
				//17/10
				@RequestMapping(value = { "/getDeveloperExtendedDateTasksMan" }, method = RequestMethod.POST)
				public JSONArray getDeveloperExtendedDateTasksMan(ModelMap model, HttpServletRequest request,
						HttpServletResponse response, HttpSession session) {

					PrintWriter out = null;
					try {
						out = response.getWriter();

						String fullname = (String) session.getAttribute("fullname");
						String role = (String) session.getAttribute("role");
						String designation = (String) session.getAttribute("designation");

						JSONArray final_response = pmsService.getDeveloperExtendedDateTasksMan(fullname, role, designation);
						System.out.println("PMS response is: " + final_response);

						out.print(final_response);
						System.out.println(" information retrieved successfully: " + final_response);

					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						if (out != null) {
							out.close();
						}
					}
					return null;
				}
				//
				
				
				
				//19/10
				@RequestMapping(value = { "/getListOfReviseDateHistory" }, method = RequestMethod.POST)
				public JSONArray getListOfReviseDateHistory(ModelMap model, HttpServletRequest request,
						HttpServletResponse response, HttpSession session) {

					PrintWriter out = null;
					try {
						out = response.getWriter();

						String taskDetails=request.getParameter("taskDetails");
						
						JSONArray final_response = pmsService.getListOfReviseDateHistory(taskDetails);
						System.out.println("PMS response is: " + final_response);

						out.print(final_response);
						System.out.println(" information retrieved successfully: " + final_response);

					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						if (out != null) {
							out.close();
						}
					}
					return null;
				}
				//
				
				
				
//				@RequestMapping(value = { "/getExcelExport" }, method = RequestMethod.POST)
//				public JSONArray getExcelExport(ModelMap model, HttpServletRequest request, HttpServletResponse response,
//						HttpSession session) {
//
//					PrintWriter out = null;
//					try {
//						out = response.getWriter();
//						
//						String temp= request.getParameter("jArray");
//						JSONArray jArray=new JSONArray(temp);
//						String excelExportPath= request.getParameter("excelExportPath");
//						
//						JSONArray final_response = pmsService.getExcelExport(jArray, excelExportPath);
//
//						out.print(final_response);
//					} catch (Exception e) {
//						e.printStackTrace();
//					} finally {
//						out.close();
//					}
//					return null;
//				}
				
				
				
				//06/11
				@RequestMapping(value = { "/getListOfFeedback" }, method = RequestMethod.POST)
				public JSONArray getListOfFeedback(ModelMap model, HttpServletRequest request,
						HttpServletResponse response, HttpSession session) {
					
					System.out.println("inside getListOfFeedback controller");

					PrintWriter out = null;
					try {
						out = response.getWriter();

//						String taskDetails=request.getParameter("taskDetails");
						
						JSONArray final_response = pmsService.getListOfFeedback();
						System.out.println("PMS response is: " + final_response);

						out.print(final_response);
						System.out.println(" information retrieved successfully: " + final_response);

					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						if (out != null) {
							out.close();
						}
					}
					return null;
				}
				//
				
				
				
				//06/11
				@RequestMapping(value = { "/getListOfClientFeedback" }, method = RequestMethod.POST)
				public JSONArray getListOfClientFeedback(ModelMap model, HttpServletRequest request,
						HttpServletResponse response, HttpSession session) {
					
					System.out.println("inside getListOfClientFeedback controller");

					PrintWriter out = null;
					try {
						out = response.getWriter();

//						String taskDetails=request.getParameter("taskDetails");
						
						JSONArray final_response = pmsService.getListOfClientFeedback();
						System.out.println("PMS response is: " + final_response);

						out.print(final_response);
						System.out.println(" information retrieved successfully: " + final_response);

					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						if (out != null) {
							out.close();
						}
					}
					return null;
				}
				//
				
				
				//06/11
				@RequestMapping(value = { "/getAllFeedbackCounts" }, method = RequestMethod.POST)
				public JSONArray getAllFeedbackCounts(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {
					System.out.println("Inside  scheduleMeetings Controller@@@@@@@@@@@@ ");
					PrintWriter out = null;

					try {
						out = response.getWriter();
						
						JSONArray final_response = pmsService.getAllFeedbackCounts();

						out.print(final_response);

					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						out.close();
					}
					return null;
				}
				//
				
				
				
				//06/11
				@RequestMapping(value = { "/getTopThreePerformers" }, method = RequestMethod.POST)
				public JSONArray getTopThreePerformers(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {
					System.out.println("Inside  scheduleMeetings Controller@@@@@@@@@@@@ ");
					PrintWriter out = null;

					try {
						out = response.getWriter();
						
						JSONArray final_response = pmsService.getTopThreePerformers();

						out.print(final_response);

					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						out.close();
					}
					return null;
				}
				//
				
				
				
				//07/11
				@RequestMapping(value = { "/getEmployeesHiredThisMonth" }, method = RequestMethod.POST)
				public JSONArray getEmployeesHiredThisMonth(ModelMap model, HttpServletRequest request,
						HttpServletResponse response, HttpSession session) {
					
					System.out.println("inside getEmployeesHiredThisMonth controller");

					PrintWriter out = null;
					try {
						out = response.getWriter();

//						String taskDetails=request.getParameter("taskDetails");
						
						JSONArray final_response = pmsService.getEmployeesHiredThisMonth();
						System.out.println("PMS response is: " + final_response);

						out.print(final_response);
						System.out.println(" information retrieved successfully: " + final_response);

					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						if (out != null) {
							out.close();
						}
					}
					return null;
				}
				//
				
				
				
				//07/11
				@RequestMapping(value = { "/getHiredComapreCounts" }, method = RequestMethod.POST)
				public JSONArray getHiredComapreCounts(ModelMap model, HttpServletRequest request,
						HttpServletResponse response, HttpSession session) {
					
					System.out.println("inside getHiredComapreCounts controller");

					PrintWriter out = null;
					try {
						out = response.getWriter();

//						String taskDetails=request.getParameter("taskDetails");
						
						JSONArray final_response = pmsService.getHiredComapreCounts();
						System.out.println("PMS response is: " + final_response);

						out.print(final_response);
						System.out.println(" information retrieved successfully: " + final_response);

					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						if (out != null) {
							out.close();
						}
					}
					return null;
				}
				//
				
				
				@RequestMapping(value = { "/saveCustomizationTask" }, method = RequestMethod.POST)
				public JSONArray saveCustomizationTask(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {
					PrintWriter out = null;

					try {
						out = response.getWriter();
						HttpSession htt = request.getSession(true);

						String uname = (String) session.getAttribute("username");
						String userfullname = (String) session.getAttribute("fullname");
						String role = (String) session.getAttribute("role");
						String designation = (String) session.getAttribute("designation");

						String customerName = request.getParameter("customerName");
						String productsuit = request.getParameter("productsuit");
						String productname = request.getParameter("productname");
						String ModuleName = request.getParameter("ModuleName");
						String enddate = request.getParameter("enddate");
						String priority = request.getParameter("inputRemark");
						String description = request.getParameter("description");
						String expectedOutput = request.getParameter("expectedOutput");

						String final_response = pmsService.saveCustomizationTask(customerName,
								productsuit, productname, ModuleName, enddate, priority,
								description,expectedOutput, userfullname, uname, role, designation);

						out.print(final_response);

					} catch (Exception e) {
						e.printStackTrace();
						// TODO: handle exception
					}
					return null;
				}
				
				
				@RequestMapping(value = { "/getCustomTaskData" }, method = RequestMethod.POST)
				public JSONArray getCustomTaskData(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {
					PrintWriter out = null;
					try {
						out = response.getWriter();

						String userfullname = (String) session.getAttribute("fullname");
						String role = (String) session.getAttribute("role");
						String designation = (String) session.getAttribute("designation");
						
						JSONArray final_response = pmsService.getCustomTaskData(userfullname, role, designation);
						out.print(final_response);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						out.close();
					}
					return null;
				}
				
				
				@RequestMapping(value = { "/getCustomTaskList" }, method = RequestMethod.POST)
				public JSONArray getCustomTaskList(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {

					PrintWriter out = null;
					String sname = null;
					try {
						out = response.getWriter();
						System.out.println("in getReassignTaskSideDetails");
						String fullname = (String) session.getAttribute("fullname");
						String role = (String) session.getAttribute("role");						
						
						JSONArray final_response = pmsService.getCustomTaskList(role, fullname);

						out.print(final_response);

					} catch (Exception e) {
						e.printStackTrace();
					}

					finally {
						out.close();
					}

					return null;
				}
				
				
				@RequestMapping(value = { "/assignCustomTaskToDeveloper" }, method = RequestMethod.POST)
			    public String assignCustomTaskToDeveloper(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			            HttpSession session) {

			        PrintWriter out = null;
			        System.out.println("INNN reassinTaskToDeveloper");
			        try {
			            out = response.getWriter();
			            
			            String fullname = (String) session.getAttribute("fullname");
						String role = (String) session.getAttribute("role");
						String designation = (String) session.getAttribute("designation");
						
						//String checkedIds = request.getParameter("checkedIds");
						String selectedNames = request.getParameter("selectedNames");
						String updatedDates = request.getParameter("updatedDates");
						System.out.println("Date arrayyyy selectedNames"+selectedNames);			

						String final_response = pmsService.assignCustomTaskToDeveloper(fullname,role,designation, selectedNames, updatedDates);
						System.out.println("reassinTaskToDeveloper response is: " + final_response);
			            out.print(final_response);

			        } catch (Exception e) {
			            e.printStackTrace();
			        } finally {
			            if (out != null) {
			                out.close();
			            }
			        }
			        return null;
			    }

				
				
				@RequestMapping(value = { "/getMyCustomizationTaskList" }, method = RequestMethod.POST)
				public JSONArray getMyCustomizationTaskList(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {
					System.out.println("Inside @@@@@@@ ");
					PrintWriter out = null;

					try {
						out = response.getWriter();

						HttpSession htt = request.getSession(true);
//						String uname = (String) htt.getAttribute("username");
						String userfullname = (String) session.getAttribute("fullname");
						String role = (String) session.getAttribute("role");
						String designation = (String) session.getAttribute("designation");
						
						JSONArray final_response = pmsService.getMyCustomizationTaskList(userfullname, role, designation);
						System.out.println("MastersControllerrrr reponse is = " + final_response);

						out.print(final_response);

					} catch (Exception e) {
						e.printStackTrace();
					}

					finally {
						out.close();
					}
					return null;
				}
				
				
				@RequestMapping(value = { "/ViewMyCutomizationTask" }, method = RequestMethod.GET)
				public String ViewMyCutomizationTask(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
					System.out.println("Inside ViewMyCutomizationTask method");

					String crno = request.getParameter("crno");

					return "Pms/ViewMyCutomizationTask";
				}
				
				
				
				@RequestMapping(value = { "/getCustomTaskDetails" }, method = RequestMethod.POST)
				public JSONArray getCustomTaskDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {
					System.out.println("Inside @@@@@@@ ");
					PrintWriter out = null;

					try {
						out = response.getWriter();

						HttpSession htt = request.getSession(true);
						String role = (String) session.getAttribute("role");
						String designation = (String) session.getAttribute("designation");
						String userfullname = (String) session.getAttribute("fullname");
						
						String crno = request.getParameter("crno");
						JSONArray final_response = pmsService.getCustomTaskDetails(role, userfullname, designation, crno);
						System.out.println("MastersControllerrrr reponse is = " + final_response);

						out.print(final_response);

					} catch (Exception e) {
						e.printStackTrace();
					}

					finally {
						out.close();
					}
					return null;

				}
				
				
				
				

				@RequestMapping(value = { "/updateCustomTaskStatus" }, method = RequestMethod.POST)
				public String updateCustomTaskStatus(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {
					System.out.println("Inside @@@@@@@ ");
					PrintWriter out = null;
					String reStatus = null;

					try {
						out = response.getWriter();

//							HttpSession htt = request.getSession(true);
//							String uname = (String) htt.getAttribute("username");
						String role = (String) session.getAttribute("role");
						String designation = (String) session.getAttribute("designation");
						String userfullname = (String) session.getAttribute("fullname");
						
						String crno = request.getParameter("crno");
						String status = request.getParameter("Status");
						String testerName = request.getParameter("testerName");
						String testerDescription = request.getParameter("testerDescription");
						
						reStatus = pmsService.updateCustomTaskStatus(crno, status, testerName, testerDescription, role, userfullname, designation );

						out.print(reStatus);

					} catch (Exception e) {
						e.printStackTrace();

					}
					return null;
				}
				
				
				
				
				//14/11
				//12/11
				@RequestMapping(value = { "/getPMOnHoldProject" }, method = RequestMethod.POST)
				public JSONArray getPMOnHoldProject(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {

					PrintWriter out = null;
					try {

						out = response.getWriter();
						String uname = (String) session.getAttribute("username");
						String userfullname = (String) session.getAttribute("fullname");
						String role = (String) session.getAttribute("role");
						System.out.println("roletype of  reponse is = " + role);
						JSONArray final_response = pmsService.getPMOnHoldProject(uname, userfullname, role);

						out.print(final_response);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						out.close();
					}
					return null;
				}
				//
				
				
				
				@RequestMapping(value = { "/getTeamLeaderByMGROnhold" }, method = RequestMethod.POST)
				public JSONArray getTeamLeaderByMGROnhold(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {

					PrintWriter out = null;
					String sname = null;
					try {
						out = response.getWriter();
						// String moduleName = request.getParameter("moduleName");
						// System.out.println("ticketype:::"+location);
						String userfullname = (String) session.getAttribute("fullname");
						JSONArray final_response = pmsService.getTeamLeaderByMGROnhold(userfullname);

						out.print(final_response);

						// System.out.println("SITE NAME GET SUCCESS");

					} catch (Exception e) {
						e.printStackTrace();
					}

					finally {
						out.close();
					}

					return null;
				}
				
				
				
				
				//12/11
				@RequestMapping(value = { "/getAllActivitiesMGROnhold" }, method = RequestMethod.POST)
				public JSONArray getAllActivitiesMGROnhold(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {

					PrintWriter out = null;

					try {
						out = response.getWriter();

						String userfullname = (String) session.getAttribute("fullname");
						String role = (String) session.getAttribute("role");
						JSONArray final_response = pmsService.getAllActivitiesMGROnhold(userfullname, role);

						System.out.println("MastersControllerrrr response is: " + final_response);

						out.print(final_response);

						System.out.println("Product suite information retrieved successfully: " + final_response);

					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						if (out != null) {
							out.close();
						}
					}
					return null;
				}
				//
				
				
				//12/11
				@RequestMapping(value = { "/ActivitiesCompletedcountNewMan" }, method = RequestMethod.POST)
				public JSONArray ActivitiesCompletedcountNewMan(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {

					PrintWriter out = null;
					try {
						out = response.getWriter();
						// String module_name = request.getParameter("module_name");

						// System.out.println("ticketype:::"+location);
						String role = (String) session.getAttribute("role");
						System.out.println("Role Type of User::"+role);
						
						String userfullname = (String) session.getAttribute("fullname");
						
						String methodName= request.getParameter("methodName");
						
						JSONArray final_response = pmsService.ActivitiesCompletedcountNewMan(role,userfullname,methodName);

						out.print(final_response);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						out.close();
					}
					return null;
				}
				
				

				@RequestMapping(value = { "/ViewCutomizationTestingTask" }, method = RequestMethod.GET)
				public String ViewCutomizationTestingTask(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
					System.out.println("Inside ViewCutomizationTestingTask method");

					String crno = request.getParameter("crno");

					return "Pms/ViewCutomizationTestingTask";
				}
				
				
				
				//14/11
				@RequestMapping(value = { "/getActivitiesUploadedToday" }, method = RequestMethod.POST)
				public JSONArray getActivitiesUploadedToday(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {
					System.out.println("Inside @@@@@@@ ");
					PrintWriter out = null;

					try {
						out = response.getWriter();

						HttpSession htt = request.getSession(true);
						String uname = (String) htt.getAttribute("username");
						String userfullname = (String) session.getAttribute("fullname");
						String role = (String) session.getAttribute("role");

						JSONArray final_response = pmsService.getActivitiesUploadedToday(uname, userfullname, role);
						System.out.println("MastersControllerrrr reponse is = " + final_response);

						out.print(final_response);

					} catch (Exception e) {
						e.printStackTrace();
					}

					finally {
						out.close();
					}
					return null;
				}
				
				
				@RequestMapping(value = { "/getCustomizationTestingTaskList" }, method = RequestMethod.POST)
				public JSONArray getCustomizationTestingTaskList(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {
					System.out.println("Inside @@@@@@@ ");
					PrintWriter out = null;

					try {
						out = response.getWriter();

						HttpSession htt = request.getSession(true);
//						String uname = (String) htt.getAttribute("username");
						String userfullname = (String) session.getAttribute("fullname");
						String role = (String) session.getAttribute("role");
						String designation = (String) session.getAttribute("designation");
						
						JSONArray final_response = pmsService.getCustomizationTestingTaskList(userfullname, role, designation);
						System.out.println("MastersControllerrrr reponse is = " + final_response);

						out.print(final_response);

					} catch (Exception e) {
						e.printStackTrace();
					}

					finally {
						out.close();
					}
					return null;
				}

				
				
				@RequestMapping(value = { "/getCustomTaskTestingDetails" }, method = RequestMethod.POST)
				public JSONArray getCustomTaskTestingDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {
					System.out.println("Inside @@@@@@@ ");
					PrintWriter out = null;

					try {
						out = response.getWriter();

						HttpSession htt = request.getSession(true);
						String role = (String) session.getAttribute("role");
						String designation = (String) session.getAttribute("designation");
						String userfullname = (String) session.getAttribute("fullname");
						
						String crno = request.getParameter("crno");
						JSONArray final_response = pmsService.getCustomTaskTestingDetails(role, userfullname, designation, crno);
						System.out.println("MastersControllerrrr reponse is = " + final_response);

						out.print(final_response);

					} catch (Exception e) {
						e.printStackTrace();
					}
					finally {
						out.close();
					}
					return null;
				}
				
				

				@RequestMapping(value = { "/updateCustomTestingTaskStatus" }, method = RequestMethod.POST)
				public String updateCustomTestingTaskStatus(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {
					System.out.println("Inside @@@@@@@ updateCustomTestingTaskStatus");
					PrintWriter out = null;
					String reStatus = null;

					try {
						out = response.getWriter();

						String role = (String) session.getAttribute("role");
						String designation = (String) session.getAttribute("designation");
						String userfullname = (String) session.getAttribute("fullname");
						
						String crno = request.getParameter("crno");
						String status = request.getParameter("Status");
						String reopenReason = request.getParameter("reopenReason");
						
						reStatus = pmsService.updateCustomTestingTaskStatus(crno, status, role, userfullname, designation,reopenReason );
						System.out.println("Update reponse is = " + reStatus);

						out.print(reStatus);
						System.out.println("below status" + reStatus);

					} catch (Exception e) {
						e.printStackTrace();
					}
					return null;
				}
				
				
				
				@RequestMapping(value = { "/getCustomTaskTestingData" }, method = RequestMethod.POST)
				public JSONArray getCustomTaskTestingData(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {
					PrintWriter out = null;
					try {
						out = response.getWriter();

						String userfullname = (String) session.getAttribute("fullname");
						String role = (String) session.getAttribute("role");
						String designation = (String) session.getAttribute("designation");
						
						JSONArray final_response = pmsService.getCustomTaskTestingData(userfullname, role, designation);
						out.print(final_response);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						out.close();
					}
					return null;
				}
				
				
				
				@RequestMapping(value = { "/getCustomTaskTestedList" }, method = RequestMethod.POST)
				public JSONArray getCustomTaskTestedList(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {
					PrintWriter out = null;
					try {
						out = response.getWriter();

						String userfullname = (String) session.getAttribute("fullname");
						String role = (String) session.getAttribute("role");
						String designation = (String) session.getAttribute("designation");
						
						JSONArray final_response = pmsService.getCustomTaskTestedList(userfullname, role, designation);
						out.print(final_response);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						out.close();
					}
					return null;
				}
				
				
				@RequestMapping(value = { "/ViewAllCustomizationTask" }, method = RequestMethod.GET)
				public String ViewAllCustomizationTask(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
					System.out.println("Inside ViewAllCutomizationTask method");

					String crno = request.getParameter("crno");

					return "Pms/ViewAllCustomizationTask";
				}
				
				
				@RequestMapping(value = { "/getCustomizationReadyTaskList" }, method = RequestMethod.POST)
				public JSONArray getCustomizationReadyTaskList(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {
					System.out.println("Inside @@@@@@@ ");
					PrintWriter out = null;

					try {
						out = response.getWriter();

						HttpSession htt = request.getSession(true);
//						String uname = (String) htt.getAttribute("username");
						String userfullname = (String) session.getAttribute("fullname");
						String role = (String) session.getAttribute("role");
						String designation = (String) session.getAttribute("designation");
						
						JSONArray final_response = pmsService.getCustomizationReadyTaskList(userfullname, role, designation);
						System.out.println("MastersControllerrrr reponse is = " + final_response);

						out.print(final_response);

					} catch (Exception e) {
						e.printStackTrace();
					}
					finally {
						out.close();
					}
					return null;
				}
				
				
				
				@RequestMapping(value = { "/getCustomTaskReadytoDeliverList" }, method = RequestMethod.POST)
				public JSONArray getCustomTaskReadytoDeliverList(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {
					PrintWriter out = null;
					try {
						out = response.getWriter();

						String userfullname = (String) session.getAttribute("fullname");
						String role = (String) session.getAttribute("role");
						String designation = (String) session.getAttribute("designation");
						
						JSONArray final_response = pmsService.getCustomTaskReadytoDeliverList(userfullname, role, designation);
						out.print(final_response);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						out.close();
					}
					return null;
				}
				
				
				
				@RequestMapping(value = { "/ViewReadyToDeliverTask" }, method = RequestMethod.GET)
				public String ViewReadyToDeliverTask(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
					System.out.println("Inside ViewReadyToDeliverTask method");

					String crno = request.getParameter("crno");

					return "Pms/ViewReadyToDeliverTask";
				}

				@RequestMapping(value = { "/updateReadyTaskStatus" }, method = RequestMethod.POST)
				public String updateReadyTaskStatus(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {
					PrintWriter out = null;
					String reStatus = null;

					try {
						out = response.getWriter();

						String role = (String) session.getAttribute("role");
						String designation = (String) session.getAttribute("designation");
						String userfullname = (String) session.getAttribute("fullname");
						
						String crno = request.getParameter("crno");
						String status = request.getParameter("Status"); 
						String patchURL = request.getParameter("patchURL"); 
						
						reStatus = pmsService.updateReadyTaskStatus(crno, status, role, userfullname, designation, patchURL );

						out.print(reStatus);
					} catch (Exception e) {
						e.printStackTrace();
					}
					return null;
				}
				
				
				
				
				//16/11
				@RequestMapping(value = { "/getListForDeletedActivities" }, method = RequestMethod.POST)
				public JSONArray getListForDeletedActivities(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {
					System.out.println("Inside @@@@@@@ ");
					PrintWriter out = null;

					try {
						out = response.getWriter();

						HttpSession htt = request.getSession(true);
						
						String prodSuit=request.getParameter("prodSuit");
						String secTool=request.getParameter("secTool");
						String custName=request.getParameter("custName");
						String projectStatus=request.getParameter("projectStatus");
						
						String uname = (String) session.getAttribute("username");
						

						JSONArray final_response = pmsService.getListForDeletedActivities(prodSuit,secTool,custName,projectStatus,uname);
						System.out.println("MastersControllerrrr reponse is = " + final_response);

						out.print(final_response);

					} catch (Exception e) {
						e.printStackTrace();
					}

					finally {
						out.close();
					}
					return null;
				}
				//
				
				
				
				
				//16/11
				@RequestMapping(value = { "/deleteActivitiesData" }, method = RequestMethod.POST)
				public String deleteActivitiesData(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {

					PrintWriter out = null;
					System.out.println("INNN updateMultipleData");
					System.out.println("CheckedIds:");
					try {
						out = response.getWriter();

						String checkedIds = request.getParameter("checkedIds");
						System.out.println("CheckedIds:" + checkedIds);

						String final_response = pmsService.deleteActivitiesData(checkedIds);
						System.out.println("updateMultipleEndDate response is: " + final_response);
						out.print(final_response);

					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						if (out != null) {
							out.close();
						}
					}
					return null;
				}
				//
				
				
				@RequestMapping(value = { "/renderNotifications" }, method = RequestMethod.POST)
				public JSONArray renderNotifications(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {
					// System.out.println("Inside updateTheme Controller@@@@@@@@@@@@ ");
					PrintWriter out = null;

					try {
						out = response.getWriter();

//						String type = request.getParameter("type");
//						String value = request.getParameter("value");
//						String uname = (String) session.getAttribute("username");
						
						String role = (String) session.getAttribute("role");
						String userfullname = (String) session.getAttribute("fullname");
						String designation = (String) session.getAttribute("designation");
					
						JSONArray final_response = pmsService.renderNotifications(userfullname, designation, role);

						out.print(final_response);

					} catch (Exception e) {
						e.printStackTrace();
					}

					finally {
						out.close();
					}
					return null;
				}
				
				
				@RequestMapping(value = { "/saveCustomTaskAddRow" }, method = RequestMethod.POST)
				public JSONArray saveCustomTaskAddRow(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session, String taskData) {
					PrintWriter out = null;

					try {
						out = response.getWriter();
						HttpSession htt = request.getSession(true);
						String role = (String) session.getAttribute("role");
						String userfullname = (String) session.getAttribute("fullname");
						String designation = (String) session.getAttribute("designation");
						
						System.out.println(" funame " + taskData);

						String final_response = pmsService.saveCustomTaskAddRow(taskData, userfullname, role, designation);

						out.print(final_response);

					} catch (Exception e) {
						e.printStackTrace();
						// TODO: handle exception
					}
					return null;
				}
				
				
				
				
				
				//21/11
				@RequestMapping(value = { "/getTodaysProgressModalData" }, method = RequestMethod.POST)
				public JSONArray getTodaysProgressModalData(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {
					System.out.println("Inside @@@@@@@ ");
					PrintWriter out = null;

					try {
						out = response.getWriter();

						HttpSession htt = request.getSession(true);
						String uname = (String) htt.getAttribute("username");
						String crno = request.getParameter("crno");
						String tid = request.getParameter("tid");
						JSONArray final_response = pmsService.getTodaysProgressModalData(uname, crno, tid);
						System.out.println("MastersControllerrrr reponse is = " + final_response);

						out.print(final_response);

					} catch (Exception e) {
						e.printStackTrace();
					}

					finally {
						out.close();
					}
					return null;

				}
				//
				
				
				
				//21/11
				@RequestMapping(value = { "/saveTodaysProgress" }, method = RequestMethod.POST)
				public String saveTodaysProgress(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
					PrintWriter out = null;
					try {
						out = response.getWriter();
						String userfullname = (String) session.getAttribute("fullname");
						String crno = request.getParameter("crno");
						String functionNameModal = request.getParameter("functionNameModal");
						String moduleNameModal = request.getParameter("moduleNameModal");
						String customerNameModal = request.getParameter("customerNameModal");
						String productNameModal = request.getParameter("productNameModal");
						String productSuiteNameModal = request.getParameter("productSuiteNameModal");
						String taskDescModal = request.getParameter("taskDescModal");
						String dateModal = request.getParameter("dateModal");
						String progressModal = request.getParameter("progressModal");
						
						String finals = pmsService.saveTodaysProgress(functionNameModal, moduleNameModal, customerNameModal, productNameModal,productSuiteNameModal, taskDescModal, dateModal, progressModal, crno, userfullname);
						out.print(finals);
					} catch (IOException e) {
						e.printStackTrace();
					}
					return null;
				}
				//
				
				
				
				
				//26/11
				@RequestMapping(value = { "/dashboardTableForHeadProject" }, method = RequestMethod.POST)
				public JSONArray dashboardTableForHeadProject(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {
					
					System.out.println("inside dashboardTableForHeadProject controller");

					PrintWriter out = null;

					try {
						out = response.getWriter();

						String uname = (String) session.getAttribute("username");
						String role = (String) session.getAttribute("role");
						String designation = (String) session.getAttribute("designation");

						JSONArray final_response = pmsService.dashboardTableForHeadProject(uname, role, designation);

						System.out.println("MastersControllerrrr response is: " + final_response);

						out.print(final_response);

						System.out.println("Product suite information retrieved successfully: " + final_response);

					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						if (out != null) {
							out.close();
						}
					}

					// Return null since response is handled directly within the method
					return null;
				}
				//
				
				
				
				
				//25/11
				@RequestMapping(value = { "/saveIssueCustomizationTask" }, method = RequestMethod.POST)
				public JSONArray saveIssueCustomizationTask(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {
					PrintWriter out = null;

					try {
						out = response.getWriter();
						HttpSession htt = request.getSession(true);

						String uname = (String) session.getAttribute("username");
						String userfullname = (String) session.getAttribute("fullname");
						String role = (String) session.getAttribute("role");
						String designation = (String) session.getAttribute("designation");
						
						
						String taskData = request.getParameter("taskData");
						System.out.println("taskDatataskDatataskDatataskData::::"+taskData);
						

						String customerName = request.getParameter("customerName");
						String productsuit = request.getParameter("productsuit");
						String productname = request.getParameter("productname");
						String ModuleName = request.getParameter("ModuleName");
						String enddate = request.getParameter("enddate");
						String priority = request.getParameter("inputRemark");
						String description = request.getParameter("description");
						String expectedOutput = request.getParameter("expectedOutput");

						String final_response = pmsService.saveIssueCustomizationTask(customerName,
								productsuit, productname, ModuleName, enddate, priority,
								description,expectedOutput, userfullname, uname, role, designation, taskData);

						out.print(final_response);

					} catch (Exception e) {
						e.printStackTrace();
						// TODO: handle exception
					}
					return null;
				}
				
				
				
				@RequestMapping(value = { "/getClosedCustomTaskList" }, method = RequestMethod.POST)
				public JSONArray getClosedCustomTaskList(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {
					PrintWriter out = null;
					try {
						out = response.getWriter();

						String userfullname = (String) session.getAttribute("fullname");
						String role = (String) session.getAttribute("role");
						String designation = (String) session.getAttribute("designation");
						
						JSONArray final_response = pmsService.getClosedCustomTaskList(userfullname, role, designation);
						out.print(final_response);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						out.close();
					}
					return null;
				}
				
				
				@RequestMapping(value = { "/getOperationalTaskList" }, method = RequestMethod.POST)
				public JSONArray getOperationalTaskList(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {
					PrintWriter out = null;
					try {
						out = response.getWriter();

						String userfullname = (String) session.getAttribute("fullname");
						String role = (String) session.getAttribute("role");
						String designation = (String) session.getAttribute("designation");
						
						JSONArray final_response = pmsService.getOperationalTaskList(userfullname, role, designation);
						out.print(final_response);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						out.close();
					}
					return null;
				}
				
				
				@RequestMapping(value = { "/getPonumberSMapproved" }, method = RequestMethod.POST)
				public JSONArray getPonumberSMapproved(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {

					PrintWriter out = null;
					String sname = null;
					try {
						out = response.getWriter();
//							String Po_number=request.getParameter("docName");
						JSONArray final_response = pmsService.getPonumberSMapproved();
						out.print(final_response);

						// System.out.println("SITE NAME GET SUCCESS");

					} catch (Exception e) {
						e.printStackTrace();
					}

					finally {
						out.close();
					}

					return null;
				}
				
				
				@RequestMapping(value = { "/getCustomTaskDataByMGR" }, method = RequestMethod.POST)
				public JSONArray getCustomTaskDataByMGR(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {
					PrintWriter out = null;
					try {
						out = response.getWriter();

						String userfullname = (String) session.getAttribute("fullname");
						String role = (String) session.getAttribute("role");
						String designation = (String) session.getAttribute("designation");
						
						JSONArray final_response = pmsService.getCustomTaskDataByMGR(userfullname, role, designation);
						out.print(final_response);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						out.close();
					}
					return null;
				}
				
				
				
				
				@RequestMapping(value = { "/updateOpTask" }, method = RequestMethod.POST)
				public JSONArray updateOpTask(@RequestParam("srno") String srNo, ModelMap model, HttpServletRequest request,
						HttpServletResponse response, HttpSession session) {
					PrintWriter out = null;

					try {
						out = response.getWriter();

						String userfullname = (String) session.getAttribute("fullname");
						String role = (String) session.getAttribute("role");
						String designation = (String) session.getAttribute("designation");
						
						String developer = request.getParameter("developer");
						String testerName = request.getParameter("testerName");
						String plannedDate = request.getParameter("plannedDate");
						String statusUpdate = request.getParameter("statusUpdate");
						int sr_no = Integer.parseInt(srNo);
						
//							int sr_no = Integer.parseInt(request.getParameter("sr_no1")); 

						String final_response = pmsService.updateOpTask(userfullname, role,
								designation, sr_no, developer, testerName, plannedDate, statusUpdate );

						out.print(final_response);

					} catch (Exception e) {
						e.printStackTrace();
						// TODO: handle exception
					}
					return null;
				}
				
				
				
				
				
				
				
				
				//06/12
				@RequestMapping(value = { "/getOperationalTaskListFirst" }, method = RequestMethod.POST)
				public JSONArray getOperationalTaskListFirst(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {
					PrintWriter out = null;
					try {
						out = response.getWriter();

						String userfullname = (String) session.getAttribute("fullname");
						String role = (String) session.getAttribute("role");
						String designation = (String) session.getAttribute("designation");
						
						JSONArray final_response = pmsService.getOperationalTaskListFirst(userfullname, role, designation);
						out.print(final_response);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						out.close();
					}
					return null;
				}
				
				
				
				//07/12
				@RequestMapping(value = { "/getOperationalTaskListSecond" }, method = RequestMethod.POST)
				public JSONArray getOperationalTaskListSecond(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {
					PrintWriter out = null;
					try {
						out = response.getWriter();

						String userfullname = (String) session.getAttribute("fullname");
						String role = (String) session.getAttribute("role");
						String designation = (String) session.getAttribute("designation");
						
						JSONArray final_response = pmsService.getOperationalTaskListSecond(userfullname, role, designation);
						out.print(final_response);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						out.close();
					}
					return null;
				}
				
				
				
				//07/12
				@RequestMapping(value = { "/getOperationalTaskListThird" }, method = RequestMethod.POST)
				public JSONArray getOperationalTaskListThird(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {
					PrintWriter out = null;
					try {
						out = response.getWriter();

						String userfullname = (String) session.getAttribute("fullname");
						String role = (String) session.getAttribute("role");
						String designation = (String) session.getAttribute("designation");
						
						JSONArray final_response = pmsService.getOperationalTaskListThird(userfullname, role, designation);
						out.print(final_response);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						out.close();
					}
					return null;
				}
				
				
				
				
				//06/12
				@RequestMapping(value = { "/getAllProductSuites" }, method = RequestMethod.POST)
				public JSONArray getAllProductSuites(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {

					PrintWriter out = null;
					String sname = null;
					try {
						out = response.getWriter();
						
						String userfullname = (String) session.getAttribute("fullname");
						JSONArray final_response = pmsService.getAllProductSuites(userfullname);

						out.print(final_response);

					} catch (Exception e) {
						e.printStackTrace();
					}

					finally {
						out.close();
					}

					return null;
				}
				
				
				
				
				
				@RequestMapping(value = { "/getAllData" }, method = RequestMethod.POST)
				public JSONArray getAllData(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {

					PrintWriter out = null;
					String sname = null;
					try {
						out = response.getWriter();
						
						String userfullname = (String) session.getAttribute("fullname");
						JSONArray final_response = pmsService.getAllData(userfullname);

						out.print(final_response);

					} catch (Exception e) {
						e.printStackTrace();
					}

					finally {
						out.close();
					}

					return null;
				}
				
				
				@RequestMapping(value = { "/getHeadPersons" }, method = RequestMethod.POST)
				public JSONArray getHeadPersons(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {

					PrintWriter out = null;
					String sname = null;
					try {
						out = response.getWriter();
//										String userid = request.getParameter("userID");
						// System.out.println("ticketype:::"+location);
						JSONArray final_response = pmsService.getHeadPersons();

						out.print(final_response);

						// System.out.println("SITE NAME GET SUCCESS");

					} catch (Exception e) {
						e.printStackTrace();
					}

					finally {
						out.close();
					}

					return null;
				}
				
				
				
				@RequestMapping(value = { "/getSalesTeam" }, method = RequestMethod.POST)
				public JSONArray getSalesTeam(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {

					PrintWriter out = null;
					String sname = null;
					try {
						out = response.getWriter();
//										String userid = request.getParameter("userID");
						// System.out.println("ticketype:::"+location);
						JSONArray final_response = pmsService.getSalesTeam();

						out.print(final_response);

						// System.out.println("SITE NAME GET SUCCESS");

					} catch (Exception e) {
						e.printStackTrace();
					}

					finally {
						out.close();
					}

					return null;
				}
				
				
				@RequestMapping(value = { "/getAllManagers" }, method = RequestMethod.POST)
				public JSONArray getAllManagers(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {

					PrintWriter out = null;
					String sname = null;
					try {
						out = response.getWriter();
//										String userid = request.getParameter("userID");
						// System.out.println("ticketype:::"+location);
						JSONArray final_response = pmsService.getAllManagers();

						out.print(final_response);

						// System.out.println("SITE NAME GET SUCCESS");

					} catch (Exception e) {
						e.printStackTrace();
					}

					finally {
						out.close();
					}

					return null;
				}
				
				
				
				@RequestMapping(value = { "/getTaskChart" }, method = RequestMethod.POST)
				public JSONArray getTaskChart(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {
					System.out.println("Inside  getTaskChart Controller@@@@@@@@@@@@ ");
					PrintWriter out = null;

					try {
						out = response.getWriter();
						String uname = (String) session.getAttribute("username");
						String userfullname = (String) session.getAttribute("fullname");
						String role = (String) session.getAttribute("role");
						String solution = request.getParameter("solution");
						
						System.out.println("roletype of  reponse is = " + role);
						JSONArray final_response = pmsService.getTaskChart(uname, userfullname, role,solution);

						out.print(final_response);

					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						out.close();
					}
					return null;
				}
				
				
	
				@RequestMapping(value = { "/getOperationalTaskUserList" }, method = RequestMethod.POST)
				public JSONArray getOperationalTaskUserList(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {
					PrintWriter out = null;
					try {
						out = response.getWriter();

						String userfullname = (String) session.getAttribute("fullname");
						String role = (String) session.getAttribute("role");
						String designation = (String) session.getAttribute("designation");
						
						JSONArray final_response = pmsService.getOperationalTaskUserList(userfullname, role, designation);
						out.print(final_response);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						out.close();
					}
					return null;
				}
				
				
				@RequestMapping(value = { "/getOperationalTaskTeamWise" }, method = RequestMethod.POST)
				public JSONArray getOperationalTaskTeamWise(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {
					PrintWriter out = null;
					try {
						out = response.getWriter();

						String userfullname = (String) session.getAttribute("fullname");
						String role = (String) session.getAttribute("role");
						String designation = (String) session.getAttribute("designation");
						
						JSONArray final_response = pmsService.getOperationalTaskTeamWise(userfullname, role, designation);
						out.print(final_response);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						out.close();
					}
					return null;
				}
				
				
				@RequestMapping(value = { "/getPendingAssignTask" }, method = RequestMethod.POST)
				public JSONArray getPendingAssignTask(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {
					PrintWriter out = null;
					try {
						out = response.getWriter();

						String userfullname = (String) session.getAttribute("fullname");
						String role = (String) session.getAttribute("role");
						String designation = (String) session.getAttribute("designation");
						
						JSONArray final_response = pmsService.getPendingAssignTask(userfullname, role, designation);
						out.print(final_response);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						out.close();
					}
					return null;
				}
				
				
				
				@RequestMapping(value = { "/getDueForTodayTask" }, method = RequestMethod.POST)
				public JSONArray getDueForTodayTask(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {
					PrintWriter out = null;
					try {
						out = response.getWriter();

						String userfullname = (String) session.getAttribute("fullname");
						String role = (String) session.getAttribute("role");
						String designation = (String) session.getAttribute("designation");
						
						JSONArray final_response = pmsService.getDueForTodayTask(userfullname, role, designation);
						out.print(final_response);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						out.close();
					}
					return null;
				}
				
				
				
				@RequestMapping(value = { "/getSolutionNames" }, method = RequestMethod.POST)
				public JSONArray getSolutionNames(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {

					PrintWriter out = null;
					String sname = null;
					try {
						out = response.getWriter();
					//	String moduleName = request.getParameter("moduleName");
						// System.out.println("ticketype:::"+location);
						String userfullname = (String) session.getAttribute("fullname");
						String role = (String) session.getAttribute("role");
						
						JSONArray final_response = pmsService.getSolutionNames(userfullname, role);

						out.print(final_response);

						// System.out.println("SITE NAME GET SUCCESS");

					} catch (Exception e) {
						e.printStackTrace();
					}
					finally {
						out.close();
					}
					return null;
				}
				
				
				@RequestMapping(value = { "/getOpTaskByCustomer" }, method = RequestMethod.POST)
				public JSONArray getOpTaskByCustomer(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {

					PrintWriter out = null;

					try {
						out = response.getWriter();
						String role = (String) session.getAttribute("role");
						String designation = (String) session.getAttribute("designation");
						String customer = request.getParameter("customer");
						String userfullname = (String) session.getAttribute("fullname");

						JSONArray final_response = pmsService.getOpTaskByCustomer(role, designation, customer,userfullname);
						System.out.println("MastersControllerrrr response is: " + final_response);

						out.print(final_response);

						System.out.println("Product suite information retrieved successfully: " + final_response);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						if (out != null) {
							out.close();
						}
					}
					// Return null since response is handled directly within the method
					return null;
				}
				
				
				
				@RequestMapping(value = { "/getOpTaskBySolution" }, method = RequestMethod.POST)
				public JSONArray getOpTaskBySolution(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {

					PrintWriter out = null;

					try {
						out = response.getWriter();
						String role = (String) session.getAttribute("role");
						String designation = (String) session.getAttribute("designation");
						String solution = request.getParameter("solution");
						String userfullname = (String) session.getAttribute("fullname");

						JSONArray final_response = pmsService.getOpTaskBySolution(role, designation, solution,userfullname);
						System.out.println("MastersControllerrrr solution is: " + final_response);

						out.print(final_response);

						System.out.println("solution retrieved successfully: " + final_response);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						if (out != null) {
							out.close();
						}
					}

					// Return null since response is handled directly within the method
					return null;
				}
				
				
				@RequestMapping(value = { "/getDetailsBySelectedDate" }, method = RequestMethod.POST)
				public JSONArray getDetailsBySelectedDate(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {

					PrintWriter out = null;

					try {
						out = response.getWriter();
						String role = (String) session.getAttribute("role");
						String designation = (String) session.getAttribute("designation");
						String clickDate = request.getParameter("clickDate");
						String userfullname = (String) session.getAttribute("fullname");

						JSONArray final_response = pmsService.getDetailsBySelectedDate(role, designation, clickDate,userfullname);
						System.out.println("getDetailsBySelectedDate is: " + final_response);

						out.print(final_response);

						System.out.println("solution retrieved successfully: " + final_response);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						if (out != null) {
							out.close();
						}
					}
					// Return null since response is handled directly within the method
					return null;
				}
				
				
				
				@RequestMapping(value = { "/getDetailsByCount" }, method = RequestMethod.POST)
				public JSONArray getDetailsByCount(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {

					PrintWriter out = null;

					try {
						out = response.getWriter();
						String role = (String) session.getAttribute("role");
						String designation = (String) session.getAttribute("designation");
						String userfullname = (String) session.getAttribute("fullname");
						
						String data = request.getParameter("mainData");
						String countType = request.getParameter("countType");

						JSONArray final_response = pmsService.getDetailsByCount(role, designation, userfullname, data, countType);
						System.out.println("getDetailsByCount is: " + final_response);

						out.print(final_response);

						System.out.println("getDetailsByCount retrieved successfully: " + final_response);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						if (out != null) {
							out.close();
						}
					}
					return null;
				}
				
				
				@RequestMapping(value = { "/DownloadComplianceSheet" }, method = RequestMethod.GET)
				public ResponseEntity<InputStreamResource> DownloadComplianceSheet(HttpServletRequest request)
						throws IOException {

					String filename1 = pmsService.DownloadComplianceSheet();
					// System.out.println("filename1 " + filename1);

					String filename = "C:\\".concat(filename1);

					File file = new File(filename);
					// System.out.println("filename " + file.getName());
					InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

					HttpHeaders headers = new HttpHeaders();
					headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
					headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
					headers.add("Pragma", "no-cache");
					headers.add("Expires", "0");

					ResponseEntity<InputStreamResource> responseEntity = ResponseEntity.ok().headers(headers)
							.contentLength(file.length())
							// .contentType(MediaType.parseMediaType("application/txt")).body(resource);
							.contentType(MediaType.APPLICATION_OCTET_STREAM).body(resource);

					return responseEntity;
				}
				
				
				@RequestMapping(value = { "/submitCompliance" }, method = RequestMethod.POST)
				public String submitCompliance(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
					PrintWriter out = null;
					try {
						out = response.getWriter();

						String productSuit = request.getParameter("productSuit");
						String securitytool = request.getParameter("Securitytool");
						String customerName = request.getParameter("customerName");
						String refNO = request.getParameter("refNO");
						String description = request.getParameter("Description");
						String salesManager = request.getParameter("salesManager");
						String complianceFile = request.getParameter("complianceFile");
						
						String role = (String) session.getAttribute("role");
						String designation = (String) session.getAttribute("designation");
						String userfullname = (String) session.getAttribute("fullname");
						
						String finals = pmsService.submitCompliance(productSuit, securitytool, customerName, refNO,complianceFile, role, userfullname, designation, description, salesManager);
						out.print(finals);
					} catch (IOException e) {
						e.printStackTrace();
					}
					return null;

				}
				
				
				
				@RequestMapping(value = { "/saveComplianceFile" }, method = RequestMethod.POST)
				public String saveComplianceFile(ModelMap model, @RequestParam("bulkUserData") MultipartFile bulkUserData,
						HttpServletRequest request, HttpServletResponse response, HttpSession session) {
					// System.out.println("Inside saveBulkUploadUserData Controller@@@@@@@@@@@@ ");
					PrintWriter out = null;

					try {
						out = response.getWriter();

						// System.out.println("bulkUserData FILE NAME:
						// "+bulkUserData.getOriginalFilename());
						// System.out.println("bulkUserData FILE SIZE: "+bulkUserData.getSize());
						String userfullname = (String) session.getAttribute("fullname");
						String uname = (String) session.getAttribute("username");
						 String role = (String) session.getAttribute("role");
						 
						 	String productSuit = request.getParameter("productSuit");
							String securitytool = request.getParameter("Securitytool");
							String customerName = request.getParameter("customerName");
							String refNO = request.getParameter("refNO"); 
							String Srno = request.getParameter("Srno");
						 
						String final_response = pmsService.saveComplianceFile(bulkUserData,userfullname,uname, role, productSuit, securitytool, customerName, refNO, Srno);

						System.out.println("saveBulkUploadTaskFile reponse is = " + final_response);

						// System.out.println("saveBulkUploadUserData GET SUCCESS");

						out.print(final_response);

					} catch (Exception e) {
						e.printStackTrace();
					}
					finally {
						out.close();
					}
					return null;
				}
				
				
				
				@RequestMapping(value = { "/getComplianceList" }, method = RequestMethod.POST)
				public JSONArray getComplianceList(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {
					// System.out.println("Inside getComplianceList Controller@@@@@@@@@@@@ ");
					PrintWriter out = null;
					String sname = null;
					try {
						out = response.getWriter();

						JSONArray final_response = pmsService.getComplianceList();

						// System.out.println("getComplianceList reponse is = " + final_response);
						out.print(final_response);
						// System.out.println("getComplianceList SUCCESS");

					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						out.close();
					}
					return null;
				}
				
				
				@RequestMapping(value = { "/deleteCompEntry" }, method = RequestMethod.POST)
				public JSONArray deleteCompEntry(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {
					// System.out.println("Inside deleteComposite Controller@@@@@@@@@@@@ ");
					PrintWriter out = null;
					String sname = null;

					try {
						out = response.getWriter();
						int crno = Integer.parseInt(request.getParameter("crno"));

						String final_response = pmsService.deleteCompEntry(crno);
						out.print(final_response);

					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						out.close();
					}
					return null;
				}
				
				
				
				@RequestMapping(value = { "/getRFPTaskList" }, method = RequestMethod.POST)
				public JSONArray getRFPTaskList(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {

					PrintWriter out = null;
					String sname = null;
					try {
						out = response.getWriter();
						System.out.println("in getReassignTaskSideDetails");
						String fullname = (String) session.getAttribute("fullname");
						String role = (String) session.getAttribute("role");						
						
						JSONArray final_response = pmsService.getRFPTaskList(role, fullname); // getRFPTaskList

						out.print(final_response);

					} catch (Exception e) {
						e.printStackTrace();
					}
					finally {
						out.close();
					}
					return null;
				}
				
				
				
				@RequestMapping(value = { "/assignRFPTaskToDeveloper" }, method = RequestMethod.POST)
			    public String assignRFPTaskToDeveloper(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			            HttpSession session) {

			        PrintWriter out = null;
			        System.out.println("INNN reassinTaskToDeveloper");
			        try {
			            out = response.getWriter();
			            
			            String fullname = (String) session.getAttribute("fullname");
						String role = (String) session.getAttribute("role");
						String designation = (String) session.getAttribute("designation");
						
						String selectedNames = request.getParameter("selectedNames");
						String updatedDates = request.getParameter("updatedDates");
						System.out.println("Date arrayyyy selectedNames"+selectedNames);			

						String final_response = pmsService.assignRFPTaskToDeveloper(fullname,role,designation, selectedNames, updatedDates);
			            out.print(final_response);

			        } catch (Exception e) {
			            e.printStackTrace();
			        } finally {
			            if (out != null) {
			                out.close();
			            }
			        }
			        return null;
			    }
				
				
				
				
				@RequestMapping(value = { "/getRFPTaskDataByMGR" }, method = RequestMethod.POST)
				public JSONArray getRFPTaskDataByMGR(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {
					PrintWriter out = null;
					try {
						out = response.getWriter();

						String userfullname = (String) session.getAttribute("fullname");
						String role = (String) session.getAttribute("role");
						String designation = (String) session.getAttribute("designation");
						
						JSONArray final_response = pmsService.getRFPTaskDataByMGR(userfullname, role, designation);
						out.print(final_response);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						out.close();
					}
					return null;
				}
				
				
				
				@RequestMapping(value = { "/saveRFPTaskAddRow" }, method = RequestMethod.POST)
				public JSONArray saveRFPTaskAddRow(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session, String taskData) {
					PrintWriter out = null;

					try {
						out = response.getWriter();
						HttpSession htt = request.getSession(true);
						String role = (String) session.getAttribute("role");
						String userfullname = (String) session.getAttribute("fullname");
						String designation = (String) session.getAttribute("designation");
						
						System.out.println(" funame " + taskData);

						String final_response = pmsService.saveRFPTaskAddRow(taskData, userfullname, role, designation);

						out.print(final_response);

					} catch (Exception e) {
						e.printStackTrace();
						// TODO: handle exception
					}
					return null;
				}
				
				
				
				@RequestMapping(value = { "/updateRFPTask" }, method = RequestMethod.POST)
				public JSONArray updateRFPTask(@RequestParam("srno") String srNo, ModelMap model, HttpServletRequest request,
						HttpServletResponse response, HttpSession session) {
					PrintWriter out = null;

					try {
						out = response.getWriter();

						String userfullname = (String) session.getAttribute("fullname");
						String role = (String) session.getAttribute("role");
						String designation = (String) session.getAttribute("designation");
						
						String developer = request.getParameter("developer");
						String testerName = request.getParameter("testerName");
						String statusUpdate = request.getParameter("statusUpdate");
						String targetDate = request.getParameter("targetDate");
						int sr_no = Integer.parseInt(srNo);
						
//							int sr_no = Integer.parseInt(request.getParameter("sr_no1")); 

						String final_response = pmsService.updateRFPTask(userfullname, role,
								designation, sr_no, developer, testerName, statusUpdate,targetDate);

						out.print(final_response);

					} catch (Exception e) {
						e.printStackTrace();
						// TODO: handle exception
					}
					return null;
				}
				
				
				
				@RequestMapping(value = { "/getMyRFPTaskList" }, method = RequestMethod.POST)
				public JSONArray getMyRFPTaskList(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {
					System.out.println("Inside @@@@@@@ ");
					PrintWriter out = null;

					try {
						out = response.getWriter();

						HttpSession htt = request.getSession(true);
//						String uname = (String) htt.getAttribute("username");
						String userfullname = (String) session.getAttribute("fullname");
						String role = (String) session.getAttribute("role");
						String designation = (String) session.getAttribute("designation");
						
						JSONArray final_response = pmsService.getMyRFPTaskList(userfullname, role, designation);
						System.out.println("MastersControllerrrr reponse is = " + final_response);

						out.print(final_response);

					} catch (Exception e) {
						e.printStackTrace();
					}

					finally {
						out.close();
					}
					return null;
				}
				
				
				
				@RequestMapping(value = { "/getRFPTaskTestingData" }, method = RequestMethod.POST)
				public JSONArray getRFPTaskTestingData(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {
					PrintWriter out = null;
					try {
						out = response.getWriter();

						String userfullname = (String) session.getAttribute("fullname");
						String role = (String) session.getAttribute("role");
						String designation = (String) session.getAttribute("designation");
						
						JSONArray final_response = pmsService.getRFPTaskTestingData(userfullname, role, designation);
						out.print(final_response);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						out.close();
					}
					return null;
				}
				
				
				@RequestMapping(value = { "/ViewMyRFPTask" }, method = RequestMethod.GET)
				public String ViewMyRFPTask(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
					System.out.println("Inside ViewMyRFPTask method");

					String crno = request.getParameter("crno");

					return "Pms/ViewMyRFPTask";
				}
				
				
				
				@RequestMapping(value = { "/getRFPTaskDetails" }, method = RequestMethod.POST)
				public JSONArray getRFPTaskDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {
					System.out.println("Inside @@@@@@@ getRFPTaskDetails");
					PrintWriter out = null;

					try {
						out = response.getWriter();

						HttpSession htt = request.getSession(true);
						String role = (String) session.getAttribute("role");
						String designation = (String) session.getAttribute("designation");
						String userfullname = (String) session.getAttribute("fullname");
						
						String crno = request.getParameter("crno");
						JSONArray final_response = pmsService.getRFPTaskDetails(role, userfullname, designation, crno);
						System.out.println("MastersControllerrrr reponse is = " + final_response);

						out.print(final_response);

					} catch (Exception e) {
						e.printStackTrace();
					}

					finally {
						out.close();
					}
					return null;
				}
				
				
				
				@RequestMapping(value = { "/updateRFPTaskStatus" }, method = RequestMethod.POST)
				public String updateRFPTaskStatus(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {
					System.out.println("Inside @@@@@@@ ");
					PrintWriter out = null;
					String reStatus = null;

					try {
						out = response.getWriter();

//							HttpSession htt = request.getSession(true);
//							String uname = (String) htt.getAttribute("username");
						String role = (String) session.getAttribute("role");
						String designation = (String) session.getAttribute("designation");
						String userfullname = (String) session.getAttribute("fullname");
						
						String crno = request.getParameter("crno");
						String status = request.getParameter("Status");
						String testerName = request.getParameter("testerName");
						String testerDescription = request.getParameter("testerDescription");
						
						reStatus = pmsService.updateRFPTaskStatus(crno, status, testerName, testerDescription, role, userfullname, designation );
						System.out.println("Update reponse is = " + reStatus);

						out.print(reStatus);
						System.out.println("below status" + reStatus);

					} catch (Exception e) {
						e.printStackTrace();

					}
					return null;
				}
				
				
				
				@RequestMapping(value = { "/getRFPTestingTaskList" }, method = RequestMethod.POST)
				public JSONArray getRFPTestingTaskList(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {
					System.out.println("Inside @@@@@@@ ");
					PrintWriter out = null;

					try {
						out = response.getWriter();

						HttpSession htt = request.getSession(true);
//						String uname = (String) htt.getAttribute("username");
						String userfullname = (String) session.getAttribute("fullname");
						String role = (String) session.getAttribute("role");
						String designation = (String) session.getAttribute("designation");
						
						JSONArray final_response = pmsService.getRFPTestingTaskList(userfullname, role, designation);
						System.out.println("MastersControllerrrr reponse is = " + final_response);

						out.print(final_response);

					} catch (Exception e) {
						e.printStackTrace();
					}
					finally {
						out.close();
					}
					return null;
				}
				
				
				
				@RequestMapping(value = { "/ViewRFPTestingTask" }, method = RequestMethod.GET)
				public String ViewRFPTestingTask(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
					System.out.println("Inside ViewCutomizationTestingTask method");

					String crno = request.getParameter("crno");

					return "Pms/ViewRFPTestingTask";
				}
				
				
				@RequestMapping(value = { "/getRFPTestingDetails" }, method = RequestMethod.POST)
				public JSONArray getRFPTestingDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {
					System.out.println("Inside @@@@@@@ ");
					PrintWriter out = null;

					try {
						out = response.getWriter();

						HttpSession htt = request.getSession(true);
						String role = (String) session.getAttribute("role");
						String designation = (String) session.getAttribute("designation");
						String userfullname = (String) session.getAttribute("fullname");
						
						String crno = request.getParameter("crno");
						JSONArray final_response = pmsService.getRFPTestingDetails(role, userfullname, designation, crno);
						System.out.println("MastersControllerrrr reponse is = " + final_response);

						out.print(final_response);

					} catch (Exception e) {
						e.printStackTrace();
					}

					finally {
						out.close();
					}
					return null;
				}
				
				
				@RequestMapping(value = { "/getRFPTestedDetails" }, method = RequestMethod.POST)
				public JSONArray getRFPTestedDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {
					System.out.println("Inside @@@@@@@ ");
					PrintWriter out = null;

					try {
						out = response.getWriter();

						HttpSession htt = request.getSession(true);
						String role = (String) session.getAttribute("role");
						String designation = (String) session.getAttribute("designation");
						String userfullname = (String) session.getAttribute("fullname");
						
						String crno = request.getParameter("crno");
						JSONArray final_response = pmsService.getRFPTestedDetails(role, userfullname, designation, crno);
						System.out.println("MastersControllerrrr reponse is = " + final_response);

						out.print(final_response);

					} catch (Exception e) {
						e.printStackTrace();
					}

					finally {
						out.close();
					}
					return null;
				}
				
				
				
				@RequestMapping(value = { "/updateRFPTestingTaskStatus" }, method = RequestMethod.POST)
				public String updateRFPTestingTaskStatus(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {
					System.out.println("Inside @@@@@@@ updateRFPTestingTaskStatus");
					PrintWriter out = null;
					String reStatus = null;

					try {
						out = response.getWriter();

						String role = (String) session.getAttribute("role");
						String designation = (String) session.getAttribute("designation");
						String userfullname = (String) session.getAttribute("fullname");
						
						String crno = request.getParameter("crno");
						String status = request.getParameter("Status");
						String testerFailDesc = request.getParameter("testerFailDesc");
						String testerPassDesc = request.getParameter("testerPassDesc");
						
						reStatus = pmsService.updateRFPTestingTaskStatus(crno, status, role, userfullname, designation,testerFailDesc,testerPassDesc );

						out.print(reStatus);
					} catch (Exception e) {
						e.printStackTrace();
					}
					return null;
				}
				
				
				
				@RequestMapping(value = { "/getRFPTaskTestedList" }, method = RequestMethod.POST)
				public JSONArray getRFPTaskTestedList(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {
					PrintWriter out = null;
					try {
						out = response.getWriter();

						String userfullname = (String) session.getAttribute("fullname");
						String role = (String) session.getAttribute("role");
						String designation = (String) session.getAttribute("designation");
						
						JSONArray final_response = pmsService.getRFPTaskTestedList(userfullname, role, designation);
						out.print(final_response);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						out.close();
					}
					return null;
				}
				
				
				@RequestMapping(value = { "/getRFPReadyTaskList" }, method = RequestMethod.POST)
				public JSONArray getRFPReadyTaskList(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {
					System.out.println("Inside @@@@@@@ ");
					PrintWriter out = null;

					try {
						out = response.getWriter();

						HttpSession htt = request.getSession(true);
						String userfullname = (String) session.getAttribute("fullname");
						String role = (String) session.getAttribute("role");
						String designation = (String) session.getAttribute("designation");
						
						JSONArray final_response = pmsService.getRFPReadyTaskList(userfullname, role, designation);
						System.out.println("MastersControllerrrr reponse is = " + final_response);

						out.print(final_response);

					} catch (Exception e) {
						e.printStackTrace();
					}
					finally {
						out.close();
					}
					return null;
				}
				
				
				@RequestMapping(value = { "/getRFPTaskReadytoDeliverList" }, method = RequestMethod.POST)
				public JSONArray getRFPTaskReadytoDeliverList(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {
					PrintWriter out = null;
					try {
						out = response.getWriter();

						String userfullname = (String) session.getAttribute("fullname");
						String role = (String) session.getAttribute("role");
						String designation = (String) session.getAttribute("designation");
						
						JSONArray final_response = pmsService.getRFPTaskReadytoDeliverList(userfullname, role, designation);
						out.print(final_response);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						out.close();
					}
					return null;
				}
				
				
				
				@RequestMapping(value = { "/ViewReadyToDeliverRFPTask" }, method = RequestMethod.GET)
				public String ViewReadyToDeliverRFPTask(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
					System.out.println("Inside ViewReadyToDeliverRFPTask method");

					String crno = request.getParameter("crno");

					return "Pms/ViewReadyToDeliverRFPTask";
				}
				
				
				@RequestMapping(value = { "/updateReadyRFPTaskStatus" }, method = RequestMethod.POST)
				public String updateReadyRFPTaskStatus(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {
					System.out.println("Inside @@@@@@@ updateCustomTestingTaskStatus");
					PrintWriter out = null;
					String reStatus = null;

					try {
						out = response.getWriter();

						String role = (String) session.getAttribute("role");
						String designation = (String) session.getAttribute("designation");
						String userfullname = (String) session.getAttribute("fullname");
						
						String crno = request.getParameter("crno");
						String status = request.getParameter("Status"); 
						String patchURL = request.getParameter("patchURL"); 
						
						reStatus = pmsService.updateReadyRFPTaskStatus(crno, status, role, userfullname, designation, patchURL );
						System.out.println("Update reponse is = " + reStatus);

						out.print(reStatus);
						System.out.println("below status" + reStatus);

					} catch (Exception e) {
						e.printStackTrace();
					}
					return null;
				}
				
				
				@RequestMapping(value = { "/markAsCloseList" }, method = RequestMethod.POST)
				public JSONArray markAsCloseList(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {
					System.out.println("Inside @@@@@@@ ");
					PrintWriter out = null;

					try {
						out = response.getWriter();

						HttpSession htt = request.getSession(true);
						String userfullname = (String) session.getAttribute("fullname");
						String role = (String) session.getAttribute("role");
						String designation = (String) session.getAttribute("designation");
						
						JSONArray final_response = pmsService.markAsCloseList(userfullname, role, designation);
						System.out.println("MastersControllerrrr reponse is = " + final_response);

						out.print(final_response);

					} catch (Exception e) {
						e.printStackTrace();
					}
					finally {
						out.close();
					}
					return null;
				}
				
				@RequestMapping(value = { "/getRFPTaskClosedList" }, method = RequestMethod.POST)
				public JSONArray getRFPTaskClosedList(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {
					PrintWriter out = null;
					try {
						out = response.getWriter();

						String userfullname = (String) session.getAttribute("fullname");
						String role = (String) session.getAttribute("role");
						String designation = (String) session.getAttribute("designation");
						
						JSONArray final_response = pmsService.getRFPTaskClosedList(userfullname, role, designation);
						out.print(final_response);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						out.close();
					}
					return null;
				}
				
				
				@RequestMapping(value = { "/ViewMarkCloseRFPTask" }, method = RequestMethod.GET)
				public String ViewMarkCloseRFPTask(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
					System.out.println("Inside ViewMarkCloseRFPTask method");

					String crno = request.getParameter("crno");

					return "Pms/ViewMarkCloseRFPTask";
				}
				
				@RequestMapping(value = { "/updateCloseRFPTaskStatus" }, method = RequestMethod.POST)
				public String updateCloseRFPTaskStatus(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {
					System.out.println("Inside @@@@@@@ updateCloseRFPTaskStatus");
					PrintWriter out = null;
					String reStatus = null;

					try {
						out = response.getWriter();

						String role = (String) session.getAttribute("role");
						String designation = (String) session.getAttribute("designation");
						String userfullname = (String) session.getAttribute("fullname");
						
						String crno = request.getParameter("crno");
						String status = request.getParameter("Status"); 
						String patchURL = request.getParameter("patchURL"); 
						
						reStatus = pmsService.updateCloseRFPTaskStatus(crno, status, role, userfullname, designation, patchURL );
						System.out.println("Update reponse is = " + reStatus);

						out.print(reStatus);
						System.out.println("below status" + reStatus);

					} catch (Exception e) {
						e.printStackTrace();
					}
					return null;
				}
				
				
				@RequestMapping(value = { "/getAllRFPTaskList" }, method = RequestMethod.POST)
				public JSONArray getAllRFPTaskList(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {
					PrintWriter out = null;
					try {
						out = response.getWriter();

						String userfullname = (String) session.getAttribute("fullname");
						String role = (String) session.getAttribute("role");
						String designation = (String) session.getAttribute("designation");
						
						JSONArray final_response = pmsService.getAllRFPTaskList(userfullname, role, designation);
						out.print(final_response);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						out.close();
					}
					return null;
				}
				
				@RequestMapping(value = { "/ViewRFPTaskDetails" }, method = RequestMethod.GET)
				public String ViewRFPTaskDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
					System.out.println("Inside ViewRFPTaskDetails method");

					String crno = request.getParameter("crno");

					return "Pms/ViewRFPTaskDetails";
				}
				
				
				@RequestMapping(value = { "/getRFPTaskDetailsAll" }, method = RequestMethod.POST)
				public JSONArray getRFPTaskDetailsAll(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {
					System.out.println("Inside @@@@@@@ ");
					PrintWriter out = null;

					try {
						out = response.getWriter();

						HttpSession htt = request.getSession(true);
						String role = (String) session.getAttribute("role");
						String designation = (String) session.getAttribute("designation");
						String userfullname = (String) session.getAttribute("fullname");
						
						String crno = request.getParameter("crno");
						JSONArray final_response = pmsService.getRFPTaskDetailsAll(role, userfullname, designation, crno);
						System.out.println("MastersControllerrrr reponse is = " + final_response);

						out.print(final_response);

					} catch (Exception e) {
						e.printStackTrace();
					}
					finally {
						out.close();
					}
					return null;
				}
				
				
				@RequestMapping(value = { "/getAllAssignToList" }, method = RequestMethod.POST)
				public JSONArray getAllAssignToList(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {

					PrintWriter out = null;
					String sname = null;
					try {
						out = response.getWriter();

						String role = (String) session.getAttribute("role");
						
						JSONArray final_response = pmsService.getAllAssignToList(role);

						out.print(final_response);

					} catch (Exception e) {
						e.printStackTrace();
					}

					finally {
						out.close();
					}

					return null;
				}
				
				
				@RequestMapping(value = { "/getRFPTaskListFirst" }, method = RequestMethod.POST)
				public JSONArray getRFPTaskListFirst(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {
					PrintWriter out = null;
					try {
						out = response.getWriter();

						String userfullname = (String) session.getAttribute("fullname");
						String role = (String) session.getAttribute("role");
						String designation = (String) session.getAttribute("designation");
						
						JSONArray final_response = pmsService.getRFPTaskListFirst(userfullname, role, designation);
						out.print(final_response);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						out.close();
					}
					return null;
				}
				
				
				@RequestMapping(value = { "/getRFPTaskListThird" }, method = RequestMethod.POST)
				public JSONArray getRFPTaskListThird(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {
					PrintWriter out = null;
					try {
						out = response.getWriter();

						String userfullname = (String) session.getAttribute("fullname");
						String role = (String) session.getAttribute("role");
						String designation = (String) session.getAttribute("designation");
						
						JSONArray final_response = pmsService.getRFPTaskListThird(userfullname, role, designation);
						out.print(final_response);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						out.close();
					}
					return null;
				}
				
				
				
				@RequestMapping(value = { "/getRFPDetailsByCount" }, method = RequestMethod.POST)
				public JSONArray getRFPDetailsByCount(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {

					PrintWriter out = null;

					try {
						out = response.getWriter();
						String role = (String) session.getAttribute("role");
						String designation = (String) session.getAttribute("designation");
						String userfullname = (String) session.getAttribute("fullname");
						
						String data = request.getParameter("mainData");
						String countType = request.getParameter("countType");

						JSONArray final_response = pmsService.getRFPDetailsByCount(role, designation, userfullname, data, countType);
						System.out.println("getDetailsByCount is: " + final_response);

						out.print(final_response);

						System.out.println("getDetailsByCount retrieved successfully: " + final_response);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						if (out != null) {
							out.close();
						}
					}
					return null;
				}
				
				
				@RequestMapping(value = { "/getRFPTaskByHead" }, method = RequestMethod.POST)
				public JSONArray getRFPTaskByCustomer(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {

					PrintWriter out = null;

					try {
						out = response.getWriter();
						String role = (String) session.getAttribute("role");
						String designation = (String) session.getAttribute("designation");
						String fHead = request.getParameter("fHead");
						String userfullname = (String) session.getAttribute("fullname");

						JSONArray final_response = pmsService.getRFPTaskByHead(role, designation, fHead,userfullname);
						System.out.println("MastersControllerrrr response is: " + final_response);

						out.print(final_response);

						System.out.println("Product suite information retrieved successfully: " + final_response);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						if (out != null) {
							out.close();
						}
					}
					// Return null since response is handled directly within the method
					return null;
				}
				
				
				
				@RequestMapping(value = { "/getRFPTaskBySolution" }, method = RequestMethod.POST)
				public JSONArray getRFPTaskBySolution(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {

					PrintWriter out = null;

					try {
						out = response.getWriter();
						String role = (String) session.getAttribute("role");
						String designation = (String) session.getAttribute("designation");
						String solution = request.getParameter("solution");
						String userfullname = (String) session.getAttribute("fullname");

						JSONArray final_response = pmsService.getRFPTaskBySolution(role, designation, solution,userfullname);
						System.out.println("MastersControllerrrr solution is: " + final_response);

						out.print(final_response);

						System.out.println("solution retrieved successfully: " + final_response);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						if (out != null) {
							out.close();
						}
					}
					// Return null since response is handled directly within the method
					return null;
				}
				
				
				@RequestMapping(value = { "/ViewUploadedRFPTask" }, method = RequestMethod.GET)
				public String ViewUploadedRFPTask(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
					System.out.println("Inside ViewUploadedRFPTask method");

					String crno = request.getParameter("crno");

					return "Pms/ViewUploadedRFPTask";
				}
				
				
				@RequestMapping(value = { "/getFHList" }, method = RequestMethod.POST)
				public JSONArray getimplementerList(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {

					PrintWriter out = null;

					try {
						out = response.getWriter();
						String role = (String) session.getAttribute("role");
						JSONArray final_response = pmsService.getFHList(role);
						out.print(final_response);

					} catch (Exception e) {
						e.printStackTrace();
					}

					finally {
						if (out != null)
							out.close();
					}
					return null;
				}
				
				
				@RequestMapping(value = { "/getAllTLList" }, method = RequestMethod.POST)
				public JSONArray getAllTLList(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {

					PrintWriter out = null;

					try {
						out = response.getWriter();
						String role = (String) session.getAttribute("role");
						JSONArray final_response = pmsService.getAllTLList(role);
						out.print(final_response);

					} catch (Exception e) {
						e.printStackTrace();
					}
					finally {
						if (out != null)
							out.close();
					}
					return null;
				}
				
				
				
				@RequestMapping(value = { "/saveTeamMaster" }, method = RequestMethod.POST)
				public String saveTeamMaster(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
					PrintWriter out = null;
					try {
						out = response.getWriter();

						String productsuit = request.getParameter("productsuit");
						String productname = request.getParameter("securitysolution");
						String functionalHead = request.getParameter("functionalHead");
						String am_dmName = request.getParameter("AM_DMname");
						String Tlname = request.getParameter("Tlname");
						String mappedWith = request.getParameter("mappedWith");
						String phaseType = request.getParameter("phaseType");
						
						String userfullname = (String) session.getAttribute("fullname");
						
						String finals = pmsService.saveTeamMaster(productsuit, productname, functionalHead, am_dmName,Tlname, mappedWith, userfullname, phaseType );
						out.print(finals);
					} catch (IOException e) {
						e.printStackTrace();
					}
					return null;

				}
				
				@RequestMapping(value = { "/getTeamMasterList" }, method = RequestMethod.POST)
				public JSONArray getTeamMasterList(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {
					PrintWriter out = null;
					try {
						out = response.getWriter();
						String role = (String) session.getAttribute("role");
					
						JSONArray final_response = pmsService.getTeamMasterList(role);
						out.print(final_response);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						out.close();
					}
					return null;
				}
				
				
				@RequestMapping(value = { "/getSolutionChart" }, method = RequestMethod.POST)
				public JSONArray getSolutionChart(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {
					System.out.println("Inside  getTaskChart Controller@@@@@@@@@@@@ ");
					PrintWriter out = null;

					try {
						out = response.getWriter();
//						String uname = (String) session.getAttribute("username");
//						String userfullname = (String) session.getAttribute("fullname");
//						String role = (String) session.getAttribute("role");
//						String solution = request.getParameter("solution");
						
						JSONArray final_response = pmsService.getSolutionChart();

						out.print(final_response);

					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						out.close();
					}
					return null;
				}
				
				
				@RequestMapping(value = { "/getSolutionwiseTeam" }, method = RequestMethod.POST)
				public JSONArray getSolutionwiseTeam(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {
					PrintWriter out = null;
					try {
						out = response.getWriter();

//						String userfullname = (String) session.getAttribute("fullname");
//						String role = (String) session.getAttribute("role");
//						String designation = (String) session.getAttribute("designation");
						
						JSONArray final_response = pmsService.getSolutionwiseTeam();
						out.print(final_response);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						out.close();
					}
					return null;
				}
				
				
				
				@RequestMapping(value = { "/getTeamChart" }, method = RequestMethod.POST)
				public JSONArray getTeamChart(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {
					PrintWriter out = null;
					try {
						out = response.getWriter();
						
						String chartName = request.getParameter("chartName");
						
						System.out.println("chartName contr "+chartName);
						
						JSONArray final_response = pmsService.getTeamChart(chartName);
						out.print(final_response);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						out.close();
					}
					return null;
				}
				
				
				@RequestMapping(value = { "/getTaskCount" }, method = RequestMethod.POST)
				public JSONArray getTaskCount(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {
					PrintWriter out = null;
					try {
						out = response.getWriter();
						
						String tableName = request.getParameter("tableName");
						String getFrom = request.getParameter("getFrom");
		
						JSONArray final_response = pmsService.getTaskCount(tableName, getFrom);
						out.print(final_response);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						out.close();
					}
					return null;
				}
				
				@RequestMapping(value = { "/getRFPManagerTaskList" }, method = RequestMethod.POST)
				public JSONArray getRFPManagerTaskList(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {

					PrintWriter out = null;
					String sname = null;
					try {
						out = response.getWriter();
						System.out.println("in getReassignTaskSideDetails");
						String fullname = (String) session.getAttribute("fullname");
						String role = (String) session.getAttribute("role");						
						
						JSONArray final_response = pmsService.getRFPManagerTaskList(role, fullname); // getRFPTaskList

						out.print(final_response);

					} catch (Exception e) {
						e.printStackTrace();
					}
					finally {
						out.close();
					}
					return null;
				}
				
				@RequestMapping(value = { "/getRFPTaskAssignedByMGR" }, method = RequestMethod.POST)
				public JSONArray getRFPTaskAssignedByMGR(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {
					PrintWriter out = null;
					try {
						out = response.getWriter();

						String userfullname = (String) session.getAttribute("fullname");
						String role = (String) session.getAttribute("role");
						String designation = (String) session.getAttribute("designation");
						
						JSONArray final_response = pmsService.getRFPTaskAssignedByMGR(userfullname, role, designation);
						out.print(final_response);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						out.close();
					}
					return null;
				}
				
				
				@RequestMapping(value = { "/assignRFPTaskByTL" }, method = RequestMethod.POST)
			    public String assignRFPTaskByTL(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			            HttpSession session) {

			        PrintWriter out = null;
			        System.out.println("INNN reassinTaskToDeveloper");
			        try {
			            out = response.getWriter();
			            
			            String fullname = (String) session.getAttribute("fullname");
						String role = (String) session.getAttribute("role");
						String designation = (String) session.getAttribute("designation");
						
						String selectedNames = request.getParameter("selectedNames");
						String updatedDates = request.getParameter("updatedDates");
						System.out.println("Date arrayyyy selectedNames"+selectedNames);			

						String final_response = pmsService.assignRFPTaskByTL(fullname,role,designation, selectedNames, updatedDates);
			            out.print(final_response);

			        } catch (Exception e) {
			            e.printStackTrace();
			        } finally {
			            if (out != null) {
			                out.close();
			            }
			        }
			        return null;
			    }
				
				
				
				@RequestMapping(value = { "/getTaskByName" }, method = RequestMethod.POST)
				public JSONArray getTaskByName(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {

					PrintWriter out = null;

					try {
						out = response.getWriter();
//						String role = (String) session.getAttribute("role");
//						String designation = (String) session.getAttribute("designation");
//						String userfullname = (String) session.getAttribute("fullname");
						
						String type = request.getParameter("type");
						String selectedName = request.getParameter("selectedName");
						JSONArray final_response = pmsService.getTaskByName(selectedName, type);

						out.print(final_response);

						System.out.println("Product suite information retrieved successfully: " + final_response);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						if (out != null) {
							out.close();
						}
					}
					// Return null since response is handled directly within the method
					return null;
				}
				
				
				@RequestMapping(value = { "/getTaskByDeveloper" }, method = RequestMethod.POST)
				public JSONArray getTaskByDeveloper(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {
					PrintWriter out = null;
					try {
						out = response.getWriter();

						String userfullname = (String) session.getAttribute("fullname");
						String role = (String) session.getAttribute("role");
						String designation = (String) session.getAttribute("designation");
						
						String value = request.getParameter("selectedValue");
						String getFrom = request.getParameter("getFrom");
						
						JSONArray final_response = pmsService.getTaskByDeveloper(userfullname, role, designation,value, getFrom);
						out.print(final_response);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						out.close();
					}
					return null;
				}
				
				
				@RequestMapping(value = { "/getRFPTaskByDev" }, method = RequestMethod.POST)
				public JSONArray getRFPTaskByDev(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {

					PrintWriter out = null;
					try {
						out = response.getWriter();
						String role = (String) session.getAttribute("role");
						String designation = (String) session.getAttribute("designation");
						String fHead = request.getParameter("developer");
						String userfullname = (String) session.getAttribute("fullname");
						
						String value = request.getParameter("selectedValue");

						JSONArray final_response = pmsService.getRFPTaskByDev( fHead, value);

						out.print(final_response);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						if (out != null) {
							out.close();
						}
					}
					return null;
				}
				
				
				@RequestMapping(value = { "/getRFPTaskByDevTillDate" }, method = RequestMethod.POST)
				public JSONArray getRFPTaskByDevTillDate(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {

					PrintWriter out = null;
					try {
						out = response.getWriter();
						String fHead = request.getParameter("developer");

						JSONArray final_response = pmsService.getRFPTaskByDevTillDate(fHead);

						out.print(final_response);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						if (out != null) {
							out.close();
						}
					}
					return null;
				}
				
				
				@RequestMapping(value = { "/getRFPTaskByCountDev" }, method = RequestMethod.POST)
				public JSONArray getRFPTaskByCountDev(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {

					PrintWriter out = null;
					try {
						out = response.getWriter();
						
						String data = request.getParameter("mainData");
						String countType = request.getParameter("countType");
						String value = request.getParameter("selectedValue");

						JSONArray final_response = pmsService.getRFPTaskByCountDev( data, countType,value);
						System.out.println("getDetailsByCount is: " + final_response);

						out.print(final_response);

						System.out.println("getDetailsByCount retrieved successfully: " + final_response);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						if (out != null) {
							out.close();
						}
					}
					return null;
				}
				
				
				@RequestMapping(value = { "/getTillTodayTask" }, method = RequestMethod.POST)
				public JSONArray getTillTodayTask(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {
					PrintWriter out = null;
					try {
						out = response.getWriter();

						String userfullname = (String) session.getAttribute("fullname");
						String role = (String) session.getAttribute("role");
						String designation = (String) session.getAttribute("designation");
						
						String value = request.getParameter("selectedValue");
						String getFrom = request.getParameter("getFrom");
						
						JSONArray final_response = pmsService.getTillTodayTask(userfullname, role, designation,value, getFrom);
						out.print(final_response);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						out.close();
					}
					return null;
				}
				
				
				@RequestMapping(value = { "/getListForReviseDate" }, method = RequestMethod.POST)
				public JSONArray getListForReviseDate(ModelMap model, HttpServletRequest request,
						HttpServletResponse response, HttpSession session) {

					PrintWriter out = null;
					try {
						out = response.getWriter();

						String fullname = (String) session.getAttribute("fullname");
						String role = (String) session.getAttribute("role");
						String designation = (String) session.getAttribute("designation");

						JSONArray final_response = pmsService.getListForReviseDate(fullname, role, designation);
						System.out.println("PMS response is: " + final_response);

						out.print(final_response);
						System.out.println(" information retrieved successfully: " + final_response);

					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						if (out != null) {
							out.close();
						}
					}
					return null;
				}
				
				
				@RequestMapping(value = { "/updateReviseDate" }, method = RequestMethod.POST)
				public JSONArray updateReviseDate(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {

					PrintWriter out = null;
					System.out.println("INNN updateMultipleEndDate");
					try {
						out = response.getWriter();

						String fullname = (String) session.getAttribute("fullname");
						String role = (String) session.getAttribute("role");
						String designation = (String) session.getAttribute("designation");

						String updatedEndDates = request.getParameter("updatedStartDates");
						String updateDatesReason = request.getParameter("updateDatesReason");
						

						System.out.println("ARRAYARRAY::::"+updatedEndDates+"hwhh::"+updateDatesReason);
						
//						System.out.println("Date arrayyyy "+updatedDates);			
						String final_response = pmsService.updateReviseDate(fullname, role, designation, updatedEndDates, updateDatesReason);

						System.out.println("updateMultipleEndDate response is: " + final_response);
						out.print(final_response);

					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						if (out != null) {
							out.close();
						}
					}
					return null;
				}
				//
				
				@RequestMapping(value = { "/getReviedDateTasksList" }, method = RequestMethod.POST)
				public JSONArray getReviedDateTasksList(ModelMap model, HttpServletRequest request,
						HttpServletResponse response, HttpSession session) {

					PrintWriter out = null;
					try {
						out = response.getWriter();

						String fullname = (String) session.getAttribute("fullname");
						String role = (String) session.getAttribute("role");
						String designation = (String) session.getAttribute("designation");

						JSONArray final_response = pmsService.getReviedDateTasksList(fullname, role, designation);
						out.print(final_response);

					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						if (out != null) {
							out.close();
						}
					}
					return null;
				}
				
				
				@RequestMapping(value = { "/approveRevisedRFPDate" }, method = RequestMethod.POST)
				public String approveRevisedRFPDate(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {

					PrintWriter out = null;
					System.out.println("INNN approveMultipleEndDate");
					try {
						out = response.getWriter();

						String fullname = (String) session.getAttribute("fullname");
						String role = (String) session.getAttribute("role");
						String designation = (String) session.getAttribute("designation");

						String checkedIds = request.getParameter("checkedIds");
						String final_response = pmsService.approveRevisedRFPDate(fullname, role, designation, checkedIds);
						System.out.println("updateMultipleEndDate response is: " + final_response);
						out.print(final_response);

					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						if (out != null) {
							out.close();
						}
					}
					return null;
				}
				
				@RequestMapping(value = { "/saveDelayReason" }, method = RequestMethod.POST)
				public String saveDelayReason(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
					PrintWriter out = null;
					try {
						out = response.getWriter();

						String crno = request.getParameter("crno");
						String myDelayReason = request.getParameter("myDelayReason");
						String fullname = (String) session.getAttribute("fullname");
						
						String finals = pmsService.saveDelayReason(crno, myDelayReason, fullname);
						out.print(finals);
					} catch (IOException e) {
						e.printStackTrace();
					}
					return null;
				}
				
				
				@RequestMapping(value = { "/getProjectsByTL" }, method = RequestMethod.POST)
				public JSONArray getProjectsByTL(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {
					PrintWriter out = null;
					try {
						out = response.getWriter();

						String userfullname = (String) session.getAttribute("fullname");
						String role = (String) session.getAttribute("role");
						String designation = (String) session.getAttribute("designation");
						
						JSONArray final_response = pmsService.getProjectsByTL(userfullname, role, designation);
						out.print(final_response);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						out.close();
					}
					return null;
				}
				
				
				@RequestMapping(value = { "/getTaskLists" }, method = RequestMethod.POST)
				public JSONArray getTotalTask(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {
					PrintWriter out = null;
					try {
						out = response.getWriter();

						String userfullname = (String) session.getAttribute("fullname");
						String role = (String) session.getAttribute("role");
						String designation = (String) session.getAttribute("designation");
						
						String type = request.getParameter("type");
						String value = request.getParameter("selectedValue");
						
						JSONArray final_response = pmsService.getTaskLists(userfullname, role, designation, type, value);
						out.print(final_response);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						out.close();
					}
					return null;
				}
				
				
				@RequestMapping(value = { "/getRFPCardCounts" }, method = RequestMethod.POST)
				public JSONArray getRFPCardCounts(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {
					PrintWriter out = null;
					try {
						out = response.getWriter();

						String userfullname = (String) session.getAttribute("fullname");
						String role = (String) session.getAttribute("role");
						String designation = (String) session.getAttribute("designation");
						
						String value = request.getParameter("selectedValue");
						
						JSONArray final_response = pmsService.getRFPCardCounts(userfullname, role, designation,value);
						out.print(final_response);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						out.close();
					}
					return null;
				}
				
				
				@RequestMapping(value = { "/assignTicket" }, method = RequestMethod.POST)
				public String assignTicket(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
					PrintWriter out = null;
					try {
						out = response.getWriter();

						String id = request.getParameter("id");
						String branch = request.getParameter("branch");
						String flag = request.getParameter("flag");
						String ip_add = request.getParameter("ip_add");
						String mail_msg = request.getParameter("mail_msg");
						String problem = request.getParameter("problem");
						String subject = request.getParameter("subject");
						String r_date = request.getParameter("r_date");
												
						String finals = pmsService.assignTicket(id, branch, flag, ip_add, mail_msg,problem,subject, r_date);
						out.print(finals);
					} catch (IOException e) {
						e.printStackTrace();
					}
					return null;

				}
				
				
				@RequestMapping(value = { "/getTaskDetailsMobile" }, method = RequestMethod.POST)
				public JSONArray getTaskDetailsMobile(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {
					System.out.println("Inside @@@@@@@ ");
					PrintWriter out = null;

					try {
						out = response.getWriter();

							String crno = request.getParameter("crno");
						JSONArray final_response = pmsService.getTaskDetailsMobile( crno);

						out.print(final_response);

					} catch (Exception e) {
						e.printStackTrace();
					}

					finally {
						out.close();
					}
					return null;
				}
				
				
				@RequestMapping(value = { "/getCompletedTaskListMobile" }, method = RequestMethod.POST)
				public JSONArray getCompletedTaskListMobile(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {
					PrintWriter out = null;

					try {
						out = response.getWriter();
						String userfullname = request.getParameter("fullname");

						JSONArray final_response = pmsService.getCompletedTaskListMobile(userfullname);

						out.print(final_response);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						out.close();
					}
					return null;
				}
				

				@RequestMapping(value = { "/getAssignedTaskByMeMobile" }, method = RequestMethod.POST)
				public JSONArray getAssignedTaskByMeMobile(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {

					PrintWriter out = null;

					try {
						out = response.getWriter();

						String userfullname = request.getParameter("fullname");
						JSONArray final_response = pmsService.getAssignedTaskByMeMobile(userfullname);
						out.print(final_response);

					} catch (Exception e) {
						e.printStackTrace();
					}
					finally {
						out.close();
					}
					return null;
				}
				
		
				@RequestMapping(value = { "/saveDataFromMobDevice" }, method = RequestMethod.POST)
				public JSONArray saveTaskFromMobDevice(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {
					PrintWriter out = null;

					try {
						out = response.getWriter();
						HttpSession htt = request.getSession(true);

//						String uname = request.getParameter("username");
						String userfullname = request.getParameter("fullname");
//						String role = request.getParameter("role");

						String projectName = request.getParameter("projectName");
						String functionName = request.getParameter("functionName");
						String Responsibility = request.getParameter("Responsibility");
						String customerName = request.getParameter("customerName");
						String productsuit = request.getParameter("productsuit");
						String productname = request.getParameter("productname");												

						String final_response = pmsService.saveTaskFromMobDevice(functionName, Responsibility, customerName,
								productsuit, productname, userfullname, projectName);

						out.print(final_response);

					} catch (Exception e) {
						e.printStackTrace();
						// TODO: handle exception
					}
					return null;
				}
				
				
				
				@RequestMapping(value = { "/getSavedProjectData" }, method = RequestMethod.GET)
				public JSONArray getSavedProjectData(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {

					PrintWriter out = null;

					try {
						out = response.getWriter();

//						String userfullname = request.getParameter("fullname");
						JSONArray final_response = pmsService.getSavedProjectData();
						out.print(final_response);

					} catch (Exception e) {
						e.printStackTrace();
					}
					finally {
						out.close();
					}
					return null;
				}
				
				
				
				@RequestMapping(value = { "/getGeneralTasksList" }, method = RequestMethod.POST)
				public JSONArray getGeneralTasksList(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {
					System.out.println("Inside @@@@@@@ ");
					PrintWriter out = null;

					try {
						out = response.getWriter();

						HttpSession htt = request.getSession(true);
						String uname = (String) htt.getAttribute("username");
						String userfullname = (String) session.getAttribute("fullname");
						String role = (String) session.getAttribute("role");

						JSONArray final_response = pmsService.getGeneralTasksList(uname, userfullname, role);
						System.out.println("MastersControllerrrr reponse is = " + final_response);

						out.print(final_response);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						out.close();
					}
					return null;
				}
				
				
				
				@RequestMapping(value = { "/getRfpTasksList" }, method = RequestMethod.POST)
				public JSONArray getRfpTasksList(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {
					System.out.println("Inside @@@@@@@ ");
					PrintWriter out = null;

					try {
						out = response.getWriter();

						HttpSession htt = request.getSession(true);
						String uname = (String) htt.getAttribute("username");
						String userfullname = (String) session.getAttribute("fullname");
						String role = (String) session.getAttribute("role");

						JSONArray final_response = pmsService.getRfpTasksList(uname, userfullname, role);
						System.out.println("MastersControllerrrr reponse is = " + final_response);

						out.print(final_response);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						out.close();
					}
					return null;
				}
				
				
				
				@RequestMapping(value = { "/getOperationalTasksList" }, method = RequestMethod.POST)
				public JSONArray getOperationalTasksList(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {
					System.out.println("Inside @@@@@@@ ");
					PrintWriter out = null;

					try {
						out = response.getWriter();

						HttpSession htt = request.getSession(true);
						String uname = (String) htt.getAttribute("username");
						String userfullname = (String) session.getAttribute("fullname");
						String role = (String) session.getAttribute("role");

						JSONArray final_response = pmsService.getOperationalTasksList(uname, userfullname, role);
						System.out.println("MastersControllerrrr reponse is = " + final_response);

						out.print(final_response);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						out.close();
					}
					return null;
				}
				
				
				
				@RequestMapping(value = { "/ViewGeneralTaskDetails" }, method = RequestMethod.GET)
				public String ViewGeneralTaskDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
					System.out.println("Inside ViewGeneralTaskDetails method");

					String crno = request.getParameter("crno");
					String tid = request.getParameter("tid");

					return "Pms/ViewGeneralTaskDetails";
				}
				
				
				
				@RequestMapping(value = { "/getGeneralTaskDetails" }, method = RequestMethod.POST)
				public JSONArray getGeneralTaskDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session) {
					System.out.println("Inside @@@@@@@ ");
					PrintWriter out = null;

					try {
						out = response.getWriter();

							String crno = request.getParameter("crno");
						String tid = request.getParameter("tid");
						JSONArray final_response = pmsService.getGeneralTaskDetails( crno, tid);
						System.out.println("MastersControllerrrr reponse is = " + final_response);

						out.print(final_response);

					} catch (Exception e) {
						e.printStackTrace();
					}

					finally {
						out.close();
					}
					return null;

				}
}

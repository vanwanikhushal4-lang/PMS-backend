package com.velox.itsm.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.bouncycastle.crypto.tls.PRFAlgorithm;
import org.json.JSONArray;
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
import org.springframework.web.multipart.MultipartFile;

import com.velox.itsm.model.SOFTWARE;
import com.velox.itsm.model.SOFTWARE_RELEASE;
import com.velox.itsm.service.EFormService;

@Controller
@RequestMapping("/EFormActivity")
public class EFormActivityController {

	@Autowired
	EFormService eFormService;

	@RequestMapping(value = { "/getPID" }, method = RequestMethod.POST)
	public JSONArray getPID(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside getServiceCatalogueSubject Controller@@@@@@@@@@@@");
		PrintWriter out = null;
		String subject = "";

		try {
			out = response.getWriter();

			JSONArray final_response = eFormService.getPID();

			System.out.println("getServiceCatalogueSubject reponse is = " + final_response);

			out.print(final_response);

			System.out.println("getServiceCatalogueSubject NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;

	}

	@RequestMapping(value = { "/ApprovalGroup" }, method = RequestMethod.POST)
	public JSONArray ApprovalGroup(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside ApprovalGroghghgup Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String subject = "";

		try {
			out = response.getWriter();
			String pid = request.getParameter("pid");
			JSONArray final_response = eFormService.ApprovalGroup(pid);

			out.print(final_response);

			System.out.println("getServiceCatalogueSubject NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;

	}

	@RequestMapping(value = { "/getUserSelectedDetails" }, method = RequestMethod.POST)
	public JSONArray getUserSelectedDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside getUserSelectedDetails Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String subject = "";

		try {
			out = response.getWriter();
			String apname = request.getParameter("approvalname");
			String[] split = apname.split("~");
			String approvalname = split[0];
			System.out.println("gggggggg" + approvalname);
			JSONArray final_response = eFormService.getUserSelectedDetails(approvalname);
			out.print(final_response);

			System.out.println("getServiceCatalogueSubject NAME GET SUCCESS" + final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;

	}

	@RequestMapping(value = { "/getItGroupUser" }, method = RequestMethod.POST)
	public JSONArray getItGroupUser(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside getItGroupUser Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String subject = "";

		try {
			out = response.getWriter();

			JSONArray final_response = eFormService.getItGroupUser();
			out.print(final_response);

			System.out.println("getItGroupUser NAME GET SUCCESS" + final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		return null;
	}

	@RequestMapping(value = { "/insertSoftwareRequest" }, method = RequestMethod.POST)
	public String insertServiceRequestCatalogueRequest(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session, @RequestParam("empPic") MultipartFile empPic,
			ModelMap modelMap) {
		PrintWriter out;
		try {

			out = response.getWriter();
			String fullname = request.getParameter("name1");
			String compname = request.getParameter("compname");
			String site = request.getParameter("site");
			String department = request.getParameter("department");
			String phone = request.getParameter("phone");
			String emailid = request.getParameter("emailid");
			String pid = request.getParameter("pid");
			String approup = request.getParameter("approup");
			String softwarename = request.getParameter("sname");
			String cost = request.getParameter("cost");

			String description = request.getParameter("description");
			String rperiod = request.getParameter("rperiod");
//			String assetCheck = request.getParameter("assetCheck");

			String typecategory = request.getParameter("typecategory");

			String assetname = request.getParameter("assetname");
			String ip = request.getParameter("ip");
			String st = request.getParameter("st");
			String compName = request.getParameter("compName");
			String serverIP = request.getParameter("ipaddress");
			String ServerOwnerName = request.getParameter("ownername");
			String ServerHostOrAssetCode = request.getParameter("hostname");
			Boolean assetcheck = true;

			String asset_Ipaddress = request.getParameter("asset_Ipaddress");
			String aname = request.getParameter("aname");
			String atag = request.getParameter("atag");
			String astatus = request.getParameter("astatus");
			String acategory = request.getParameter("acategory");
			String asset_sub_category = request.getParameter("asset_sub_category");

			if (typecategory.equals("Server")) {
				assetcheck = false;
				asset_Ipaddress = "NA";
				aname = "NA";
				atag = "NA";
				astatus = "NA";
				acategory = "NA";
				asset_sub_category = "NA";
				assetname = "NA";
				ip = "NA";
				compName = "NA";

			}

//			System.out.println("assetCheckassetCheckassetCheck" + assetCheck);

			String final_response = eFormService.insertSoftwareRequest(fullname, compname, site, department, phone,
					emailid, empPic, pid, softwarename, cost, description, approup, rperiod, assetcheck,
					asset_Ipaddress, aname, atag, astatus, acategory, asset_sub_category, typecategory, assetname, ip,
					st, serverIP, ServerOwnerName, ServerHostOrAssetCode);

			System.out.println("eFormController reponse is = " + final_response);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = { "/getPendingSoftwareReqauest" }, method = RequestMethod.POST)
	public String getPendingSoftwareReqauest(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		PrintWriter out;
		try {
			out = response.getWriter();

			JSONArray final_response = eFormService.getPendingSoftwareReqauest();

			System.out.println("getPendingSoftwareReqauest reponse is = " + final_response);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = { "/gatherSoftwareDetails" }, method = RequestMethod.POST)
	public String gatherSoftwareDetails(HttpServletRequest request, HttpServletResponse response) {
		PrintWriter out = null;
		try {
			out = response.getWriter();
			String id = request.getParameter("ticketid");
			JSONArray final_reponse = eFormService.gatherSoftwareDetails(id);
			out.print(final_reponse);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = { "/GetSoftwareDetails" }, method = RequestMethod.POST)
	public JSONArray GetSoftwareDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside GetSoftwareDetails Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String subject = "";

		try {
			out = response.getWriter();
			String sname = request.getParameter("sname");
			System.out.println("sname is " + sname);
			JSONArray final_response = eFormService.GetSoftwareDetails(sname);

			out.print(final_response);

			System.out.println("getServiceCatalogueSubject NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
		return null;
	}

	@RequestMapping(value = { "/InsertRequestApprovedByItCompliance" }, method = RequestMethod.POST)
	public String InsertRequestApprovedByItCompliance(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session, @RequestParam("assignPic") MultipartFile empPic,
			ModelMap modelMap) {
		PrintWriter out;
		try {
			out = response.getWriter();
			String appByITComp = request.getParameter("nameupdateTP");
			String status = request.getParameter("statusupdateENG");

			String Approvenote = request.getParameter("Approvenote");
			;
			String ticketidupdateTDassign = request.getParameter("ticketidupdateTDassign");
			;
			String RaisedByName = request.getParameter("nameupdateUDassign");
			String requestcategory = request.getParameter("rcat");
			String ApprovalName = null;
			String phone = null;
			String emailid = null;
			String pid = null;
			String softwarename = request.getParameter("sname");
			String CompanyRaisedBy = request.getParameter("companyupdateUDassign");
			String licensekey = request.getParameter("liscencekey");
			licensekey = (licensekey == null || licensekey.equals("")) ? "NA" : licensekey;
			System.out.println("}gdhgh" + licensekey);
			String final_response = eFormService.InsertRequestApprovedByItCompliance(appByITComp, status, Approvenote,
					requestcategory, empPic, phone, emailid, pid, softwarename, CompanyRaisedBy, RaisedByName,
					ticketidupdateTDassign, licensekey);
			System.out.println("eFormController reponse is = " + final_response);
			out.print(final_response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = { "/getPendingToApproveRequestByManager" }, method = RequestMethod.POST)
	public String getPendingToApproveRequestByManager(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		PrintWriter out;
		try {
			out = response.getWriter();

			JSONArray final_response = eFormService.getPendingToApproveRequestByManager();

			System.out.println("getPendingSoftwareReqauest reponse is = " + final_response);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = { "/InsertRequestApprovedByMAnager" }, method = RequestMethod.POST)
	public String InsertRequestApprovedByMAnager(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session, @RequestParam("assignPic") MultipartFile empPic,
			ModelMap modelMap) {
		PrintWriter out;
		try {
			out = response.getWriter();
			String appByITComp = request.getParameter("nameupdateTP");
			String status = request.getParameter("statusupdateENG");

			String Approvenote = request.getParameter("Approvenote");
			
			String ticketidupdateTDassign = request.getParameter("ticketidupdateTDassign");
			
			String RaisedByName = request.getParameter("nameupdateUDassign");
			String pid=request.getParameter("pid");
			String site = null;
//		        String ApprovalName =request.getParameter("username2");
			String phone = null;
			String emailid = null;
		
			String softwarename = null;
			String ApprovalName = null;
			String CompanyRaisedBy = request.getParameter("companyupdateUDassign");

			String final_response = eFormService.InsertRequestApprovedByMAnager(appByITComp, status, Approvenote,
					ApprovalName, empPic, phone, emailid, pid, softwarename, CompanyRaisedBy, RaisedByName,
					ticketidupdateTDassign);

			System.out.println("eFormController reponse is = " + final_response);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = { "/getPendingSoftwareReqauestInTc" }, method = RequestMethod.POST)
	public String getPendingSoftwareReqauestInTc(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		PrintWriter out;
		try {
			out = response.getWriter();

			JSONArray final_response = eFormService.getPendingSoftwareReqauestInTc();

			System.out.println("getPendingSoftwareReqauest reponse is = " + final_response);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = { "/gatherSoftwareRequestDetails" }, method = RequestMethod.POST)
	public JSONArray gatherTicketDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside gatherSoftwareRequestDetails Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			String ticketid = request.getParameter("ticketid");

			System.out.println("ticketid is = " + ticketid);

			JSONArray final_response = eFormService.gatherSoftwareRequestDetails(ticketid);

			System.out.println("UserActivityControllerrrr reponse is = " + final_response);

			out.print(final_response);

			System.out.println("gatherTicketDetails GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//			return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/InsertRequestApprovedByRemotSupport" }, method = RequestMethod.POST)
	public String InsertRequestApprovedByRemotSupport(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session, @RequestParam("assignPic") MultipartFile empPic,
			ModelMap modelMap) {
		PrintWriter out;
		try {
			out = response.getWriter();
			String appByITComp = request.getParameter("nameupdateTP");
			String status = request.getParameter("statusupdateENG");

			String Approvenote = request.getParameter("Approvenote");
			
			String ticketidupdateTDassign = request.getParameter("ticketidupdateTDassign");
			
			String RaisedByName = request.getParameter("nameupdateUDassign");
			String site = null;
			String phone = null;
			String emailid = null;
			String pid = request.getParameter("pid");
			String softwarename = request.getParameter("sname");
			String ApprovalName = null;
			String requestCartegory = request.getParameter("rcat");

			String CompanyRaisedBy = request.getParameter("companyupdateUDassign");

			String final_response = eFormService.InsertRequestApprovedByRemotSupport(appByITComp, status, Approvenote,
					ApprovalName, empPic, phone, emailid, pid, softwarename, CompanyRaisedBy, RaisedByName,
					ticketidupdateTDassign, requestCartegory);

			System.out.println("eFormController reponse is = " + final_response);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = { "/getUserRequestList" }, method = RequestMethod.POST)
	public String getUserRequestList(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		PrintWriter out;
		try {
			out = response.getWriter();

			JSONArray final_response = eFormService.getUserRequestList();

			System.out.println("getPendingSoftwareReqauest reponse is = " + final_response);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = { "/getRequestActivityLog" }, method = RequestMethod.POST)
	public JSONArray getRequestActivityLog(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside getRequestActivityLog Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			String ticketid = request.getParameter("ticketid");
			String type = request.getParameter("type");
			System.out.println("ticketid is = " + ticketid);

			JSONArray final_response = eFormService.getRequestActivityLog(ticketid, type);

			System.out.println("UserActivityControllerrrr reponse is = " + final_response);

			out.print(final_response);

			System.out.println("getRequestActivityLog GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//			return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/getRequestID" }, method = RequestMethod.POST)
	public String getRequestID(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		PrintWriter out;
		try {
			out = response.getWriter();
			String requestype = request.getParameter("requestType");
			out.print(eFormService.getRequestID(requestype));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = { "/getUserRequestTracking" }, method = RequestMethod.POST)
	public String getUserRequestTracking(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		PrintWriter out;
		try {
			out = response.getWriter();
			String ticketId = request.getParameter("ticketid");
			String reqType = request.getParameter("reqType");
			out.print(eFormService.getUserRequestTracking(ticketId, reqType));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = { "/getSoftwares" }, method = RequestMethod.POST)
	public String getSoftwares(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		PrintWriter out;
		try {
			out = response.getWriter();
			out.print(eFormService.getSoftwares());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = { "/closeSoftwareRequestRequest" }, method = RequestMethod.POST)
	public String closeSoftwareRequestRequest(HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		PrintWriter out;
		try {

			out = response.getWriter();
			String ticketid = request.getParameter("ticketid");
			String closereason = request.getParameter("closereason");
			out.print(eFormService.closeSoftwareRequestRequest(ticketid, closereason));

		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@RequestMapping(value = { "/RequestReopenResolvedTicket" }, method = RequestMethod.POST)
	public String RequestReopenResolvedTicket(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session, @RequestParam("reopenPic") MultipartFile reopenPic, ModelMap modelMap) {

		PrintWriter out;
		try {

			out = response.getWriter();
			String ticketid = request.getParameter("ticketidupdateTD");
			String reopenreason = request.getParameter("reopenreason");
			out.print(eFormService.RequestReopenResolvedTicket(ticketid, reopenreason, reopenPic));

		} catch (Exception e) {
			// TODO: handle exception
		}

		return null;
	}

	@RequestMapping(value = { "/getWorkInProgressInTc" }, method = RequestMethod.POST)

	public String getWorkInProgressInTc(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		PrintWriter out;
		try {
			out = response.getWriter();
			out.print(eFormService.getWorkInProgressInTc());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = { "/getLoginUserSoftwares" }, method = RequestMethod.GET)
	public void getLoginUserSoftwares(HttpServletRequest request, HttpServletResponse response) {
		PrintWriter out;
		try {
			out = response.getWriter();
			JSONArray loginUserSoftwares = eFormService.getLoginUserSoftwares();
			out.print(loginUserSoftwares);
			System.out.println("software name" + loginUserSoftwares);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	//////////////// Release Software//////////////////
	@RequestMapping(value = { "/insertSoftwareRelease" }, method = RequestMethod.POST)
	public void insertSoftwareRelease(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("empPic") MultipartFile empPic) {
		PrintWriter out;
		try {
			out = response.getWriter();

			String fullname = request.getParameter("name1");
			String compname = request.getParameter("compname");
			String site = request.getParameter("site");
			String department = request.getParameter("department");
			String phone = request.getParameter("phone");
			String emailid = request.getParameter("emailid");
			String softwarename = request.getParameter("sname");
			String applieddate = request.getParameter("cost");
			String description = request.getParameter("description");
			String assetcode = request.getParameter("rperiod");
			String pid=request.getParameter("pid");
			String approup=request.getParameter("approup");

			String AssetCodeDL = request.getParameter("assetname");
			String Ip_AddressDL = request.getParameter("ip");
			String StatusDL = request.getParameter("st");
			String ComputerNameDL = request.getParameter("compName");

			String typecategory = request.getParameter("typecategory");
			String Server_IP = request.getParameter("ipaddress");
			String Server_ownername = request.getParameter("ownername");
			String Server_hostname = request.getParameter("hostname");
			if (typecategory.equals("Server")) {
				AssetCodeDL = "NA";
				Ip_AddressDL = "NA";
				StatusDL = "NA";

				ComputerNameDL = "NA";

			}

			else if (typecategory.equals("Laptop") || typecategory.equals("Desktop")) {
				Server_IP = "NA";
				Server_ownername = "NA";
				Server_hostname = "NA";
			}

			String final_response = eFormService.insertSoftwareRelease(pid,approup,fullname, compname, site, department, phone,
					emailid, empPic, softwarename, applieddate, description, assetcode, typecategory, AssetCodeDL,
					Ip_AddressDL, StatusDL, ComputerNameDL, Server_IP, Server_ownername, Server_hostname);

			System.out.println("eFormController reponse is = " + final_response);

			out.print(final_response);

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@RequestMapping(value = { "/getUserReleaseRequestList" }, method = RequestMethod.POST)
	public String getUserReleaseRequestList(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		PrintWriter out;
		try {
			out = response.getWriter();

			JSONArray final_response = eFormService.getUserReleaseRequestList();

			System.out.println("getPendingSoftwareReqauest reponse is = " + final_response);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = { "/gatherSoftwareReleaseDetails" }, method = RequestMethod.POST)
	public String gatherSoftwareReleaseDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		PrintWriter out;
		try {
			out = response.getWriter();

			String id = request.getParameter("ticketid");
			String type = request.getParameter("type");
			JSONArray final_response = eFormService.gatherSoftwareReleaseDetails(id, type);

			System.out.println("getPendingSoftwareReqauest reponse is = " + final_response);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = { "/getPendingSoftwareRelease" }, method = RequestMethod.POST)
	public void getPendingSoftwareRelease(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("affan malik ");
		PrintWriter writer = null;
		try {
			writer = response.getWriter();
			JSONArray pendingSoftwareRelease = eFormService.getPendingSoftwareRelease();
			writer.print(pendingSoftwareRelease);
			System.out.println("dfgdgdfgdfgdgdfgg" + pendingSoftwareRelease);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@RequestMapping(value = { "/getReleaseActivityLog" }, method = RequestMethod.POST)
	public JSONArray getReleaseActivityLog(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside getReleaseActivityLog Controller@@@@@@@@@@@@ ");

		PrintWriter out = null;

		try {
			out = response.getWriter();

			String ticketid = request.getParameter("ticketid");

			System.out.println("ticketid is = " + ticketid);

			JSONArray final_response = eFormService.getReleaseActivityLog(ticketid);

			System.out.println("UserActivityControllerrrr reponse is = " + final_response);

			out.print(final_response);

			System.out.println("getRequestActivityLog GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//			return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/gatherSoftwareReleaseDetailsToApp" }, method = RequestMethod.POST)
	public String gatherSoftwareReleaseDetails(HttpServletRequest request, HttpServletResponse response) {
		PrintWriter out = null;
		try {
			out = response.getWriter();
			String id = request.getParameter("ticketid");
			JSONArray final_reponse = eFormService.gatherSoftwareReleaseDetailsToApp(id);
			out.print(final_reponse);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = { "/InsertReleaseRequestAppByItCompliance" }, method = RequestMethod.POST)
	public String InsertReleaseRequestAppByItCompliance(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session, @RequestParam("assignPic") MultipartFile empPic,
			ModelMap modelMap) {
		PrintWriter out;
		try {
			out = response.getWriter();
			String appByITComp = request.getParameter("nameupdateTP");
			String status = request.getParameter("statusupdateENG");

			String Approvenote = request.getParameter("Approvenote");
			;
			String ticketidupdateTDassign = request.getParameter("ticketidupdateTDassign");
			;
			String RaisedByName = request.getParameter("nameupdateUDassign");
			String Request_category = request.getParameter("requestcatassign");
//		        String ApprovalName =null;
//		        String phone = null;
//		        String emailid = null;
//		        String pid = null;
//		        String softwarename = null;
			String CompanyRaisedBy = request.getParameter("companyupdateUDassign");
			String final_response = eFormService.InsertReleaseRequestAppByItCompliance(appByITComp, status, Approvenote,
					empPic, CompanyRaisedBy, RaisedByName, ticketidupdateTDassign, Request_category);

			System.out.println("eFormController reponse is = " + final_response);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = { "/getReleaseSoftwareInTc" }, method = RequestMethod.POST)
	public void getReleaseSoftwareInTc(HttpServletResponse response, HttpServletRequest request) {
		PrintWriter out;
		try {
			out = response.getWriter();
			JSONArray final_response = eFormService.getReleaseSoftwareInTc();
			System.out.println("dghhfghghfgh" + final_response);
			out.print(final_response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@RequestMapping(value = { "/getPendingSoftwareReqauestInEng" }, method = RequestMethod.POST)
	public String getPendingSoftwareReqauestInEng(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		PrintWriter out;
		try {
			out = response.getWriter();

			JSONArray final_response = eFormService.getPendingSoftwareReqauestInEng();

			System.out.println("getPendingSoftwareReqauest reponse is = " + final_response);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = { "/getWorkInProgressInEng" }, method = RequestMethod.POST)
	public String getWorkInProgressInEng(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		PrintWriter out;
		try {
			out = response.getWriter();

			JSONArray final_response = eFormService.getWorkInProgressInEng();

			System.out.println("getPendingSoftwareReqauest reponse is = " + final_response);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = { "/InsertReleseRequestByRemotSupport" }, method = RequestMethod.POST)
	public String InsertReleseRequestApprovedByRemotSupport(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session, @RequestParam("assignPic") MultipartFile empPic,
			ModelMap modelMap) {
		PrintWriter out;
		try {
			System.out.println("controller calling software relese method");
			out = response.getWriter();

			String softwarenamerelese = request.getParameter("sname");
			String name = request.getParameter("nameupdateUDassign");
			String companyname = request.getParameter("companyupdateUDassign");

			String nameid = request.getParameter("nameupdateUDassign");
			String reqid = request.getParameter("ticketidupdateTDassign");
			String statusR = request.getParameter("statusupdateENG");
			String note = request.getParameter("Approvenote");

			String appByITComp = request.getParameter("nameupdateTP");
			String RaisedByName = request.getParameter("nameupdateUDassign");
			String site = null;
			String ApprovalName = request.getParameter("username2");
			String phone = null;
			String emailid = null;
			String pid = null;
			String softwarename = null;
			// String ApprovalName=null;
			String CompanyRaisedBy = request.getParameter("companyupdateUDassign");
			String requestcatassign=request.getParameter("requestcatassign"); 

			String final_response = eFormService.InsertReleseRequestByRemotSupport(name, companyname, nameid, reqid,
					statusR, note, empPic, emailid, pid, CompanyRaisedBy, RaisedByName, appByITComp,
					softwarenamerelese,requestcatassign);

			System.out.println("eFormController reponse is = " + final_response);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = { "/getPendingSoftwareReqauestforMailAdmin" }, method = RequestMethod.POST)
	public void getPendingSoftwareReqauestforMailAdmin(HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		PrintWriter out;
		try {
			out = response.getWriter();

			JSONArray final_response = eFormService.getPendingSoftwareReqauestforMailAdmin();

			System.out.println("getPendingSoftwareReqauest reponse is = " + final_response);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@RequestMapping(value = { "/InsertRequestApprovedByMailAdmin" }, method = RequestMethod.POST)
	public void InsertRequestApprovedByItMailAdmin(HttpServletRequest request, HttpServletResponse response,
			HttpSession session, @RequestParam("assignPic") MultipartFile empPic, ModelMap modelMap) {
		PrintWriter out;
		try {
			out = response.getWriter();
			String appByITComp = request.getParameter("nameupdateTP");
			String status = request.getParameter("statusupdateENG");

			String Approvenote = request.getParameter("Approvenote");
			;
			String ticketid = request.getParameter("ticketidupdateTDassign");
			;
			String RaisedByName = request.getParameter("nameupdateUDassign");
			String requestcategory = request.getParameter("rcat");

			String softwarename = request.getParameter("sname");
			String CompanyRaisedBy = request.getParameter("companyupdateUDassign");
			String final_response = eFormService.InsertRequestApprovedByMailAdmin(appByITComp, status, Approvenote,
					requestcategory, empPic, softwarename, CompanyRaisedBy, RaisedByName, ticketid);
			System.out.println("eFormController reponse is = " + final_response);
			out.print(final_response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@RequestMapping(value = { "/insertSoftwareTransferRequest" }, method = RequestMethod.POST)
	public void insertSoftwareTransferRequest(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("empPic") MultipartFile empPic) {
		PrintWriter out;
		try {

			out = response.getWriter();
			String fullname = request.getParameter("name1");
			String compname = request.getParameter("compname");
			String site = request.getParameter("site");
			String department = request.getParameter("department");
			String phone = request.getParameter("phone");
			String emailid = request.getParameter("emailid");
			String pid = request.getParameter("pid");
			String approup = request.getParameter("approup");

			String softwarename = request.getParameter("sname");
			String AppliedDate = request.getParameter("cost");
			String assetCode = request.getParameter("rperiod");
			String description = request.getParameter("description");

			String actionType = request.getParameter("actionType");
			

			String typecategory = request.getParameter("typecategory");
			String toEmployee = request.getParameter("usernamesofbehalf");

			String newassetCode = request.getParameter("newassetCodeSU");
			String currentDate = request.getParameter("newDate");

			
			
			String ipaddress = request.getParameter("ipaddress");
			 String ownername =request.getParameter("ownername");
			String hostname=request.getParameter("hostname");
			String assetname = request.getParameter("assetname");
			String ip = request.getParameter("ip");
			String st = request.getParameter("st");
			String compName = request.getParameter("compName");
			String from_asset=request.getParameter("fromAsset");
			
//			String asset_Ipaddress = request.getParameter("asset_Ipaddress");
//			String aname = request.getParameter("aname");
//			String atag = request.getParameter("atag");
//			String astatus = request.getParameter("astatus");
//			String acategory = request.getParameter("acategory");
//			String asset_sub_category = request.getParameter("asset_sub_category");

			
//		        System.out.println("assetCheckassetCheckassetCheck"+assetCheck);
			
			
			String final_response = eFormService.insertSoftwareTransferRequest(fullname, compname, site, department,
					phone, emailid, empPic, pid, approup, softwarename, approup, AppliedDate, assetCode, actionType,
					toEmployee, newassetCode, currentDate,typecategory,description, assetname, ip, st, ipaddress, ownername,hostname,compName,from_asset);
//		        
			System.out.println("eFormController reponse is = " + final_response);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = { "/getPendingToApproveTransferRequestByManager" }, method = RequestMethod.POST)
	public void getPendingToApproveTransferRequestByManager(HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		PrintWriter out;
		try {
			out = response.getWriter();

			JSONArray final_response = eFormService.getPendingToApproveTransferRequestByManager();

			System.out.println("getPendingTrasnfereqauest reponse is = " + final_response);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@RequestMapping(value = { "/gatherTransferSoftwareDetails" }, method = RequestMethod.POST)
	public String gatherTransferSoftwareDetails(HttpServletRequest request, HttpServletResponse response) {
		PrintWriter out = null;
		try {
			out = response.getWriter();
			String id = request.getParameter("ticketid");
			JSONArray final_reponse = eFormService.gatherTransferSoftwareDetails(id);
			out.print(final_reponse);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = { "/InsertTransferRequestApprovedByManager" }, method = RequestMethod.POST)
	public String InsertTransferRequestApprovedByItCompliance(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session, @RequestParam("assignPic") MultipartFile empPic,
			ModelMap modelMap) {
		PrintWriter out;
		try {
			out = response.getWriter();
			String appByITComp = request.getParameter("nameupdateTP");
			String status = request.getParameter("statusupdateENG");

			String Approvenote = request.getParameter("Approvenote");
			
			String ticketidupdateTDassign = request.getParameter("ticketidupdateTDassign");
			
			String RaisedByName = request.getParameter("nameupdateUDassign");
			
			String CompanyRaisedBy = request.getParameter("companyupdateUDassign");
			String  temployee =request.getParameter("temployee");
			String reqcat=request.getParameter("reqcat");
			String final_response = eFormService.InsertTransferRequestApprovedByManager(appByITComp, status,
					Approvenote, empPic, CompanyRaisedBy, RaisedByName, ticketidupdateTDassign,reqcat,temployee);

			System.out.println("eFormController reponse is = " + final_response);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = { "/getPendingTransferReqauest" }, method = RequestMethod.POST)
	public void getPendingTransferReqauest(HttpServletRequest request, HttpServletResponse response) {
		PrintWriter out;
		try {
			out = response.getWriter();

			JSONArray final_response = eFormService.getPendingTransferReqauest();

//				System.out.println("getPendingTransferReqauest reponse is = " + final_response);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = { "/gatherTransferViewDetails" }, method = RequestMethod.POST)
	public void gatherTransferViewDetails(HttpServletRequest request, HttpServletResponse response) {
		PrintWriter out;
		try {
			out = response.getWriter();

			String tid = request.getParameter("ticketid");
			JSONArray final_response = eFormService.gatherTransferViewDetails(tid);

//				System.out.println("getPendingTransferReqauest reponse is = " + final_response);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = { "/InsertTransferRequestByItCompliance" }, method = RequestMethod.POST)
	public String InsertTransferRequestByItCompliance(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session, @RequestParam("assignPic") MultipartFile empPic,
			ModelMap modelMap) {
		PrintWriter out;
		try {
			out = response.getWriter();
			String appByITComp = request.getParameter("nameupdateTP");
			String status = request.getParameter("statusupdateENG");
			String Approvenote = request.getParameter("Approvenote");
			;
			String ticketidupdateTDassign = request.getParameter("ticketidupdateTDassign");
			;
			String RaisedByName = request.getParameter("nameupdateUDassign");
			String requestcategory = request.getParameter("rcat");
			String ApprovalName = null;
			String phone = null;
			String emailid = null;
			String pid = null;
			String softwarename = request.getParameter("sname");
			String CompanyRaisedBy = request.getParameter("companyupdateUDassign");
			String licensekey = request.getParameter("liscencekey");
			licensekey = (licensekey == null || licensekey.equals("")) ? "NA" : licensekey;
//			System.out.println("}gdhgh" + licensekey);
			String reqcat=request.getParameter("reqcat");
			String final_response = eFormService.InsertTransferRequestByItCompliance(appByITComp, status, Approvenote,
					requestcategory, empPic, phone, emailid, pid, softwarename, CompanyRaisedBy, RaisedByName,
					ticketidupdateTDassign, licensekey,reqcat);
			System.out.println("eFormController reponse is = " + final_response);
			out.print(final_response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = { "/getUserTransferList" }, method = RequestMethod.POST)
	public String getUserTransferList(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		PrintWriter out;
		try {
			out = response.getWriter();

			JSONArray final_response = eFormService.getUserTransferList();

			System.out.println("getPendingSoftwareReqauest reponse is = " + final_response);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

//		getPendingSoftwareTrasnferInTc
	@RequestMapping(value = { "/getPendingSoftwareTransferInTc" }, method = RequestMethod.POST)
	public String getPendingSoftwareTransferInTc(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		PrintWriter out;
		try {
			out = response.getWriter();

			JSONArray final_response = eFormService.getPendingSoftwareTransferInTc();

			System.out.println("getPendingSoftwareTransferInTc reponse is = " + final_response);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = { "/InsertTransferRequestApprovedByRemotSupport" }, method = RequestMethod.POST)
	public String InsertTransferRequestApprovedByRemotSupport(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session, @RequestParam("assignPic") MultipartFile empPic,
			ModelMap modelMap) {
		PrintWriter out;
		try {
			out = response.getWriter();
			String appByITComp = request.getParameter("nameupdateTP");
			String status = request.getParameter("statusupdateENG");

			String Approvenote = request.getParameter("Approvenote");
			;
			String ticketidupdateTDassign = request.getParameter("ticketidupdateTDassign");
			;
			String RaisedByName = request.getParameter("nameupdateUDassign");
			;
			String site = null;
//		        String ApprovalName =request.getParameter("username2");
			String phone = null;
			String emailid = null;
			String pid = null;
			String softwarename = null;
			String ApprovalName = null;
			String requestCartegory = request.getParameter("rcat");

			String CompanyRaisedBy = request.getParameter("companyupdateUDassign");

			String final_response = eFormService.InsertTransferRequestApprovedByRemotSupport(appByITComp, status,
					Approvenote, ApprovalName, empPic, phone, emailid, pid, softwarename, CompanyRaisedBy, RaisedByName,
					ticketidupdateTDassign, requestCartegory);

			System.out.println("eFormController reponse is = " + final_response);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	///////////////////////////// Work in progress transfer
	///////////////////////////// Request/////////////////////////////////////

	@RequestMapping(value = { "/getWorkInProgressTransferInTc" }, method = RequestMethod.POST)

	public String getWorkInProgressTransferInTc(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		PrintWriter out;
		try {
			out = response.getWriter();
			out.print(eFormService.getWorkInProgressTransferInTc());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = { "/InsertTransferRequestApprovedByRT" }, method = RequestMethod.POST)
	public String InsertTransferRequestApprovedByRT(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session, @RequestParam("assignPic") MultipartFile empPic,
			ModelMap modelMap) {
		PrintWriter out;
		try {
			out = response.getWriter();
			String appByITComp = request.getParameter("nameupdateTP");
			String status = request.getParameter("statusupdateENG");

			String Approvenote = request.getParameter("Approvenote");
			;
			String ticketidupdateTDassign = request.getParameter("ticketidupdateTDassign");
			;
			String RaisedByName = request.getParameter("nameupdateUDassign");
			;
			String site = null;
//		        String ApprovalName =request.getParameter("username2");
			String phone = null;
			String emailid = null;
			String pid = null;
			String softwarename = null;
			String ApprovalName = null;
			String requestCartegory = request.getParameter("rcat");

			String CompanyRaisedBy = request.getParameter("companyupdateUDassign");

			String final_response = eFormService.InsertTransferRequestApprovedByRT(appByITComp, status, Approvenote,
					ApprovalName, empPic, phone, emailid, pid, softwarename, CompanyRaisedBy, RaisedByName,
					ticketidupdateTDassign, requestCartegory);

			

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = { "/closeSoftwareRequestTransfer" }, method = RequestMethod.POST)
	public String closeSoftwareRequestTransfer(HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		PrintWriter out;
		try {

			out = response.getWriter();
			String ticketid = request.getParameter("ticketid");
			String closereason = request.getParameter("closereason");
			out.print(eFormService.closeSoftwareRequestTransfer(ticketid, closereason));

		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@RequestMapping(value = { "/getNTReleaseSoftwareInTc" }, method = RequestMethod.POST)
	public void getNTReleaseSoftwareInTc(HttpServletResponse response, HttpServletRequest request) {
		PrintWriter out;
		try {
			out = response.getWriter();
			String listingType=request.getParameter("listingType");
//			System.out.println("ffgffffffffffff"+listingType);
			JSONArray final_response = eFormService.getNTReleaseSoftwareInTc(listingType);
		
			out.print(final_response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	/////////////////////////////GET TICKET AND CHECK IT RELEASE OR NOT//////////////
	
	@RequestMapping(value = { "/getSoftwareReleaseTicket" }, method = RequestMethod.POST)
	public void getSoftwareReleaseTicket(HttpServletResponse response, HttpServletRequest request) {
		PrintWriter out;
		try {
			out = response.getWriter();
			String softwareName=request.getParameter("sname");
			String reqType=request.getParameter("reqType");
		
			out.print(eFormService.getSoftwareReleaseTicket(softwareName,reqType));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	@RequestMapping(value = { "/closeReleaseRequestRequest" }, method = RequestMethod.POST)
	public void closeReleaseRequestRequest(HttpServletResponse response, HttpServletRequest request) {
		PrintWriter out;
		try {
			out = response.getWriter();
			String ticketid=request.getParameter("ticketid");
			String closereason=request.getParameter("closereason");
		
			out.print(eFormService.closeReleaseRequestRequest(ticketid,closereason));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
//	
	
	
	
	@RequestMapping(value = { "/getPendingServerSoftwareTransferInTc" }, method = RequestMethod.POST)
	public String getPendingServerSoftwareTransferInTc(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		PrintWriter out;
		try {
			out = response.getWriter();

			JSONArray final_response = eFormService.getPendingServerSoftwareTransferInTc();

			System.out.println("getPendingSoftwareTransferInTc reponse is = " + final_response);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value = { "/InsertServerTransferRequestApprovedByNTAdmin" }, method = RequestMethod.POST)
	public void InsertServerTransferRequestApprovedByNTAdmin(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session, @RequestParam("assignPic") MultipartFile empPic,
			ModelMap modelMap) {
		PrintWriter out;
		try {
			out = response.getWriter();
			String appByITComp = request.getParameter("nameupdateTP");
			String status = request.getParameter("statusupdateENG");

			String Approvenote = request.getParameter("Approvenote");
			;
			String ticketidupdateTDassign = request.getParameter("ticketidupdateTDassign");
			;
			String RaisedByName = request.getParameter("nameupdateUDassign");
			;
			String site = null;
//		        String ApprovalName =request.getParameter("username2");
			String phone = null;
			String emailid = null;
			String pid = null;
			String softwarename = null;
			String ApprovalName = null;
			String requestCartegory = request.getParameter("rcat");

			String CompanyRaisedBy = request.getParameter("companyupdateUDassign");

			String final_response = eFormService.InsertServerTransferRequestApprovedByNTAdmin(appByITComp, status,
					Approvenote, ApprovalName, empPic, phone, emailid, pid, softwarename, CompanyRaisedBy, RaisedByName,
					ticketidupdateTDassign, requestCartegory);

			System.out.println("eFormController reponse is = " + final_response);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	@RequestMapping(value = { "/getWorkInProgressServerTransferInTc" }, method = RequestMethod.POST)

	public String InsertTransferRequestApprovedByNT(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		PrintWriter out;
		try {
			out = response.getWriter();
			out.print(eFormService.getWorkInProgressServerTransferInTc());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = { "/InsertTransferRequestApprovedByNT" }, method = RequestMethod.POST)
	public String getWorkInProgressServerTransferInTc(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session, @RequestParam("assignPic") MultipartFile empPic,
			ModelMap modelMap) {
		PrintWriter out;
		try {
			out = response.getWriter();
			String appByITComp = request.getParameter("nameupdateTP");
			String status = request.getParameter("statusupdateENG");

			String Approvenote = request.getParameter("Approvenote");
		
			String ticketidupdateTDassign = request.getParameter("ticketidupdateTDassign");
			
			String RaisedByName = request.getParameter("nameupdateUDassign");
			
			String site = null;
//		        String ApprovalName =request.getParameter("username2");
			String phone = null;
			String emailid = null;
			String pid = null;
			String softwarename = null;
			String ApprovalName = null;
			String requestCartegory = request.getParameter("rcat");

			String CompanyRaisedBy = request.getParameter("companyupdateUDassign");

			String final_response = eFormService.InsertTransferRequestApprovedByNT(appByITComp, status, Approvenote,
					ApprovalName, empPic, phone, emailid, pid, softwarename, CompanyRaisedBy, RaisedByName,
					ticketidupdateTDassign, requestCartegory);
			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value = { "/getReleaseSoftwareInTcForResolution" }, method = RequestMethod.POST)
	public void getReleaseSoftwareInTcForResolution(HttpServletResponse response, HttpServletRequest request) {
		PrintWriter out;
		try {
			out = response.getWriter();
			JSONArray final_response = eFormService.getReleaseSoftwareInTcForResolution();
			System.out.println("dghhfghghfgh" + final_response);
			out.print(final_response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	@RequestMapping(value = { "/InsertReleseRequestForResolution" }, method = RequestMethod.POST)
	public String InsertReleseRequestForResolution(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session, @RequestParam("assignPic") MultipartFile empPic,
			ModelMap modelMap) {
		PrintWriter out;
		try {
//			System.out.println("controller calling software relese method");
			out = response.getWriter();

			String softwarenamerelese = request.getParameter("sname");
			String name = request.getParameter("nameupdateUDassign");
			String companyname = request.getParameter("companyupdateUDassign");

			String nameid = request.getParameter("nameupdateUDassign");
			String reqid = request.getParameter("ticketidupdateTDassign");
			String statusR = request.getParameter("statusupdateENG");
			String note = request.getParameter("Approvenote");

			String appByITComp = request.getParameter("nameupdateTP");
			String RaisedByName = request.getParameter("nameupdateUDassign");
			String site = null;
			String ApprovalName = request.getParameter("username2");
			String phone = null;
			String emailid = null;
			String pid = null;
			String softwarename = null;
			// String ApprovalName=null;
			String CompanyRaisedBy = request.getParameter("companyupdateUDassign");
			String requestcatassign=request.getParameter("requestcatassign"); 

			String final_response = eFormService.InsertReleseRequestForResolution(name, companyname, nameid, reqid,
					statusR, note, empPic, emailid, pid, CompanyRaisedBy, RaisedByName, appByITComp,
					softwarenamerelese,requestcatassign);

			System.out.println("eFormController reponse is = " + final_response);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = { "/InsertReleseRequestByRemotSupportForResolve" }, method = RequestMethod.POST)
	public String InsertReleseRequestByRemotSupportForResolve(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session, @RequestParam("assignPic") MultipartFile empPic,
			ModelMap modelMap) {
		PrintWriter out;
		try {
//			System.out.println("controller calling software relese method");
			out = response.getWriter();

			String softwarenamerelese = request.getParameter("sname");
			String name = request.getParameter("nameupdateUDassign");
			String companyname = request.getParameter("companyupdateUDassign");

			String nameid = request.getParameter("nameupdateUDassign");
			String reqid = request.getParameter("ticketidupdateTDassign");
			String statusR = request.getParameter("statusupdateENG");
			String note = request.getParameter("Approvenote");

			String appByITComp = request.getParameter("nameupdateTP");
			String RaisedByName = request.getParameter("nameupdateUDassign");
			String site = null;
			String ApprovalName = request.getParameter("username2");
			String phone = null;
			String emailid = null;
			String pid = null;
			String softwarename = null;
			// String ApprovalName=null;
			String CompanyRaisedBy = request.getParameter("companyupdateUDassign");
			String requestcatassign=request.getParameter("requestcatassign"); 

			String final_response = eFormService.InsertReleseRequestByRemotSupportForResolve(name, companyname, nameid, reqid,
					statusR, note, empPic, emailid, pid, CompanyRaisedBy, RaisedByName, appByITComp,
					softwarenamerelese,requestcatassign);

			System.out.println("eFormController reponse is = " + final_response);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value = { "/InsertTransferRequestApprovedBy2ndManager" }, method = RequestMethod.POST)
	public String InsertTransferRequestApprovedBy2ndManager(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session, @RequestParam("assignPic1") MultipartFile empPic,
			ModelMap modelMap) {
		PrintWriter out;
		try {
			out = response.getWriter();
			String appByITComp = request.getParameter("nameupdateTP1");
			String status = request.getParameter("statusupdateENG1");

			String Approvenote = request.getParameter("Approvenote1");
			
			String ticketidupdateTDassign = request.getParameter("ticketidupdateTDassign1");
			
			String RaisedByName = request.getParameter("nameupdateUDassign1");
			
			String CompanyRaisedBy = request.getParameter("companyupdateUDassign1");
			String  temployee =request.getParameter("temployee1");
			String reqcat=request.getParameter("reqcat1");
			String final_response = eFormService.InsertTransferRequestApprovedBy2ndManager(appByITComp, status,
					Approvenote, empPic, CompanyRaisedBy, RaisedByName, ticketidupdateTDassign,reqcat,temployee);

			System.out.println("eFormController reponse is = " + final_response);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value = { "/GetSoftwareDetailOfLoginUser" }, method = RequestMethod.POST)
	public JSONArray GetSoftwareDetailOfLoginUser(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside GetSoftwareDetails Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String subject = "";

		try {
			out = response.getWriter();
			String sname = request.getParameter("sname");
			System.out.println("sname is " + sname);
			JSONArray final_response = eFormService.GetSoftwareDetailOfLoginUser(sname);

			out.print(final_response);

			System.out.println("getServiceCatalogueSubject NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
		return null;
	}
	
	//Business Request Method start
	
			@RequestMapping(value = {"/insertBusinessRequest"}, method = RequestMethod.POST)
			public String insertBusniessRequestCatalogueRequest(ModelMap model, HttpServletRequest request, HttpServletResponse response,
					HttpSession session, @RequestParam("empPic") MultipartFile empPic, ModelMap modelMap)
			{
				
				System.out.println("Inside bussiness Request Controller");
				PrintWriter out;
				try
				{
					System.out.println("Inside bussiness Request Controller Try Block");
					out=response.getWriter();
			        String fullname = request.getParameter("name1");
			        String compname = request.getParameter("compname");
			        String site = request.getParameter("site");
			        String department = request.getParameter("department");
			        String phone = request.getParameter("phone");
			        String emailid = request.getParameter("emailid");
			        String pid = request.getParameter("pid");
			        String approup = request.getParameter("approup");		        
			        String requestfor = request.getParameter("requestfor");
			        String domain = request.getParameter("domain");		        
			        String description = request.getParameter("description");
			        String  rperiod=request.getParameter("rperiod");		        
			        String  typecategory=request.getParameter("typecategory");
			        String  newDate=request.getParameter("newDate");
			       
			       		      
			        String final_response = eFormService.insertBusinessRequest(fullname,compname,site,department,phone,emailid,pid,approup,requestfor,domain,description,rperiod,typecategory,newDate,empPic);
	 
					System.out.println("eFormController reponse is = " + final_response);
								
					out.print(final_response);
					System.out.println("Inside bussiness Request Controller end Of Controller");
				}
				catch (Exception e) {
					e.printStackTrace();
				}
				return null;
			}
			
			
			@RequestMapping(value = {"/getUserBusinessRequestList"}, method = RequestMethod.POST)
			public String getUserBusinessRequestList(ModelMap model, HttpServletRequest request, HttpServletResponse response,
					HttpSession session)
			{
				PrintWriter out;
				try
				{
					out=response.getWriter();
			        				
					JSONArray final_response = eFormService.getUserBusinessRequestList();

					System.out.println("getPendingSoftwareReqauest reponse is = " + final_response);
								
					out.print(final_response);
			        
				}
				catch (Exception e) {
					e.printStackTrace();
				}
				return null;
			}
			
			// view  business request 
			
			@RequestMapping(value = { "/gatherBusinessRequestDetails" }, method = RequestMethod.POST)
			public JSONArray gatherBusinessTicketDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
					HttpSession session) {
				System.out.println("Inside gatherSoftwareRequestDetails Controller@@@@@@@@@@@@ ");
				PrintWriter out = null;

				try {
					out = response.getWriter();

					String ticketid = request.getParameter("ticketid");
				
					System.out.println("ticketid is = " + ticketid);

					JSONArray final_response = eFormService.gatherBusinessRequestDetails(ticketid);

					System.out.println("UserActivityControllerrrr reponse is = " + final_response);

					out.print(final_response);

					System.out.println("gatherTicketDetails GET SUCCESS");

				} catch (Exception e) {
					e.printStackTrace();
				}

				finally {
					out.close();
				}
//				return "Dashboard";
				return null;

			}
			
			
			//Ticket Activity log
			
			@RequestMapping(value = { "/getBusinessRequestActivityLog" }, method = RequestMethod.POST)
			public JSONArray getBusinessRequestActivityLog(ModelMap model, HttpServletRequest request, HttpServletResponse response,
					HttpSession session) {
				System.out.println("Inside getRequestActivityLog Controller@@@@@@@@@@@@ ");
				PrintWriter out = null;

				try {
					out = response.getWriter();

					String ticketid = request.getParameter("ticketid");

					System.out.println("ticketid in business is = " + ticketid);

					JSONArray final_response = eFormService.getBusinessRequestActivityLog(ticketid);

					System.out.println("UserActivityControllerrrr reponse is = " + final_response);

					out.print(final_response);

					System.out.println("getRequestActivityLog GET SUCCESS");

				} catch (Exception e) {
					e.printStackTrace();
				}

				finally {
					out.close();
				}
//				return "Dashboard";
				return null;

			}
			
			//business request tracking
			
			@RequestMapping(value = {"/getBusinessRequestID"}, method = RequestMethod.POST)
			public JSONArray getBusinessRequestID(ModelMap model, HttpServletRequest request, HttpServletResponse response,
					HttpSession session)
			{
				PrintWriter out;
				System.out.println("inside business request ID");
				try
				{
					out=response.getWriter();			
					String requestype=request.getParameter("requestType");
					System.out.println("inside business request ID is: " + requestype);
					out.print(eFormService.getBusinessRequestID(requestype));
				}
				catch (Exception e) {
					e.printStackTrace();
				}
				return null;
			}
			
			// 
			
			@RequestMapping(value = {"/getUserBusinessRequestTracking"}, method = RequestMethod.POST)
			public String getUserBusinessRequestTracking(ModelMap model, HttpServletRequest request, HttpServletResponse response,
					HttpSession session)
			{
				PrintWriter out;
				System.out.println("inside business request TRACKING");
				try
				{
					out=response.getWriter();		
					String ticketid=request.getParameter("ticketid");
					String requesttype = request.getParameter("requesttype");
					System.out.println("inside business request ID" + ticketid);
					System.out.println("inside business request ID" + requesttype);
					out.print(eFormService.getUserBusinessRequestTracking(ticketid,requesttype));
				}
				catch (Exception e) {
					e.printStackTrace();
				}
				return null;
			}
			
			
			@RequestMapping(value = { "/getUserBusinessRaisedRequest" }, method = RequestMethod.POST)
			public JSONArray getUserBusinessRaisedTicket(ModelMap model, HttpServletRequest request, HttpServletResponse response,
					HttpSession session) {
				System.out.println("Inside getUserBusinessRaisedRequest Controller@@@@@@@@@@@@ ");
				PrintWriter out = null;
				String sname = null;

				try {
					out = response.getWriter();
						
					//public JSONArray getUserRaisedRequest(String ticketlist);
					
					String ticketlist = null;
					JSONArray final_response = eFormService.getUserBusinessRaisedRequest();

					System.out.println("getbusinessRaisedTicketList reponse is = " + final_response);

					out.print(final_response);

					System.out.println("getBusinessRaisedTicketList SUCCESS");

				} catch (Exception e) {
					e.printStackTrace();
				}

				finally {
					out.close();
				}
//				return "Dashboard";
				return null;

			}
			
			
			// view detail
			
			@RequestMapping(value = { "/getrBusinessRequestDetails" }, method = RequestMethod.POST)
			public JSONArray getBusinessRequestTicketDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
					HttpSession session) {
				System.out.println("Inside gatherSoftwareRequestDetails Controller@@@@@@@@@@@@ ");
				PrintWriter out = null;

				try {
					out = response.getWriter();

					String ticketid = request.getParameter("ticketid");
				
					System.out.println("ticketid is = " + ticketid);

					JSONArray final_response = eFormService.gatherBusinesRequestRequestDetails(ticketid);

					System.out.println("UserActivityControllerrrr reponse is = " + final_response);

					out.print(final_response);

					System.out.println("gatherTicketDetails GET SUCCESS");

				} catch (Exception e) {
					e.printStackTrace();
				}

				finally {
					out.close();
				}
//				return "Dashboard";
				return null;

			}
			
			//ticket Action
			
			@RequestMapping(value = {"/gatherBusinessActionDetails"},method = RequestMethod.POST)
			public String getBusinessActionDetails(HttpServletRequest request,HttpServletResponse response)
			{
				PrintWriter out=null;
				try
				{
					out=response.getWriter();
					String id=request.getParameter("ticketid");
					JSONArray final_reponse=eFormService.gatherBusinessActionDetails(id);
					out.print(final_reponse);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
				return null;
			}
			
			
			// Insert TicketAction 
			
			@RequestMapping(value = {"/InsertBusinessRequestApprovedByMAnager"}, method = RequestMethod.POST)
			public String InsertBusinessRequestApprovedByMAnager(ModelMap model, HttpServletRequest request, HttpServletResponse response,
					HttpSession session, @RequestParam("assignPic") MultipartFile empPic, ModelMap modelMap)
			{
				PrintWriter out;
				try
				{
					out=response.getWriter();
			        String appByITComp = request.getParameter("nameupdateTP");
			        String Status = request.getParameter("statusupdateENG");
			       
			        String Approvenote = request.getParameter("Approvenote");;
			        String  ticketidupdateTDassign= request.getParameter("ticketidupdateTDassign");;
			        String RaisedByName=request.getParameter("nameupdateUDassign");;
			        String site =null;
//			        String ApprovalName =request.getParameter("nameupdateTP");
			        String phone = null;
			        String emailid = null;
			        String pid = null;
//			        String softwarename = null;
			        String ApprovalName=null;
			        String CompanyRaisedBy =request.getParameter("companyupdateUDassign");
			        
			        String final_response = eFormService.InsertBusinessRequestApprovedByMAnager(appByITComp, Status, Approvenote,ApprovalName,empPic,phone, emailid, pid,CompanyRaisedBy,RaisedByName,ticketidupdateTDassign);

					System.out.println("eFormController reponse is = " + final_response);
								
					out.print(final_response);
			        
				}
				catch (Exception e) {
					e.printStackTrace();
				}
				return null;
			}
			
			
			
			// Gal Update flow
			
			//Show List
			
			@RequestMapping(value = { "/getGalUpdateBuinessRequest" }, method = RequestMethod.POST)
			public JSONArray getGalUpdateBusinessRequest(ModelMap model, HttpServletRequest request, HttpServletResponse response,
					HttpSession session) {
				System.out.println("Inside getUserBusinessRaisedRequest Controller@@@@@@@@@@@@ ");
				PrintWriter out = null;
				String sname = null;

				try {
					out = response.getWriter();
						
					//public JSONArray getUserRaisedRequest(String ticketlist);
					
					String ticketlist = null;
					JSONArray final_response = eFormService.getGalUpdateBusinessRequest();

					System.out.println("getbusinessRaisedTicketList reponse is = " + final_response);

					out.print(final_response);

					System.out.println("getBusinessRaisedTicketList SUCCESS");

				} catch (Exception e) {
					e.printStackTrace();
				}

				finally {
					out.close();
				}
//				return "Dashboard";
				return null;

			}
			
			// Insert Gal Update 
			
					@RequestMapping(value = {"/InsertBusinessRequestApprovedByGalUpdate"}, method = RequestMethod.POST)
					public String InsertBusinessRequestApprovedByGalUpdate(ModelMap model, HttpServletRequest request, HttpServletResponse response,
							HttpSession session, @RequestParam("assignPic") MultipartFile empPic, ModelMap modelMap)
					{
						PrintWriter out;
						try
						{
							out=response.getWriter();
					        String appByITComp = request.getParameter("nameupdateTP");
					        String Status = request.getParameter("statusupdateENG");
					       
					        String Approvenote = request.getParameter("Approvenote");;
					        String  ticketidupdateTDassign= request.getParameter("ticketidupdateTDassign");;
					        String RaisedByName=request.getParameter("nameupdateUDassign");;
					        String site =null;
//					        String ApprovalName =request.getParameter("nameupdateTP");
					        String phone = null;
					        String emailid = null;
					        String pid = null;
//					        String softwarename = null;
					        String ApprovalName=null;
					        String CompanyRaisedBy =request.getParameter("companyupdateUDassign");
					        
					        String final_response = eFormService.InsertBusinessRequestApprovedByGalUpdate(appByITComp, Status, Approvenote,ApprovalName,empPic,phone, emailid, pid,CompanyRaisedBy,RaisedByName,ticketidupdateTDassign);

							System.out.println("eFormController reponse is = " + final_response);
										
							out.print(final_response);
					        
						}
						catch (Exception e) {
							e.printStackTrace();
						}
						return null;
					}
					
			
			
			// mailupdate  Update flow
			
					//Show List
					
					@RequestMapping(value = { "/MailAdminBuinessRequest" }, method = RequestMethod.POST)
					public JSONArray MailAdminBusinessRequest(ModelMap model, HttpServletRequest request, HttpServletResponse response,
							HttpSession session) {
						System.out.println("Inside getUserBusinessRaisedRequest Controller@@@@@@@@@@@@ ");
						PrintWriter out = null;
						String sname = null;

						try {
							out = response.getWriter();
								
							//public JSONArray getUserRaisedRequest(String ticketlist);
							
							String ticketlist = null;
							JSONArray final_response = eFormService.getMailAdminBusinessRequest();

							System.out.println("getbusinessRaisedTicketList reponse is = " + final_response);

							out.print(final_response);

							System.out.println("getBusinessRaisedTicketList SUCCESS");

						} catch (Exception e) {
							e.printStackTrace();
						}

						finally {
							out.close();
						}
//						return "Dashboard";
						return null;

					}
					
					// insert mail admin
					
					@RequestMapping(value = {"/InsertBusinessRequestApprovedByMailAdmin"}, method = RequestMethod.POST)
					public String InsertBusinessRequestApprovedByMailAdmin(ModelMap model, HttpServletRequest request, HttpServletResponse response,
							HttpSession session, @RequestParam("assignPic") MultipartFile empPic, ModelMap modelMap)
					{
						PrintWriter out;
						try
						{
							out=response.getWriter();
					        String appByITComp = request.getParameter("nameupdateTP");
					        String Status = request.getParameter("statusupdateENG");				       
					        String Approvenote = request.getParameter("Approvenote");;
					        String  ticketidupdateTDassign= request.getParameter("ticketidupdateTDassign");;
					        String RaisedByName=request.getParameter("nameupdateUDassign");;
					        String site =null;
//					        String ApprovalName =request.getParameter("nameupdateTP");
					        String phone = null;
					        String emailid = null;
					        String pid = null;
					        String ApprovalName=null;
					        String CompanyRaisedBy =request.getParameter("companyupdateUDassign");
					        
					        String final_response = eFormService.InsertBusinessRequestApprovedByMailAdmin(appByITComp, Status, Approvenote,ApprovalName,empPic,phone, emailid, pid,CompanyRaisedBy,RaisedByName,ticketidupdateTDassign);

							System.out.println("eFormController reponse is = " + final_response);
										
							out.print(final_response);
					        
						}
						catch (Exception e) {
							e.printStackTrace();
						}
						return null;
					}
					
					
		//Show List
					
					@RequestMapping(value = { "/MailAdminBucket" }, method = RequestMethod.POST)
					public JSONArray MailAdminBucket(ModelMap model, HttpServletRequest request, HttpServletResponse response,
							HttpSession session) {
						System.out.println("Inside getUserBusinessRaisedRequest Controller@@@@@@@@@@@@ ");
						PrintWriter out = null;
						String sname = null;

						try {
							out = response.getWriter();
								
							//public JSONArray getUserRaisedRequest(String ticketlist);
							
							String ticketlist = null;
							JSONArray final_response = eFormService.getMailAdminBucket();

							System.out.println("getbusinessRaisedTicketList reponse is = " + final_response);

							out.print(final_response);

							System.out.println("getBusinessRaisedTicketList SUCCESS");

						} catch (Exception e) {
							e.printStackTrace();
						}

						finally {
							out.close();
						}
//						return "Dashboard";
						return null;

					}
					
					// close the resolved request 
					
					@RequestMapping(value = {"/closeBusinessResolvedRequest"},method = RequestMethod.POST)
					public String closeBusinessResolvedRequest(HttpServletRequest request, HttpServletResponse response,
							HttpSession session)
					{
						
						System.out.println("inside close ticket controller");
						PrintWriter out;
						try {						
							out=response.getWriter();
							String ticketid=request.getParameter("ticketid");
							System.out.println("value of ticket : " + ticketid);
							String closereason=request.getParameter("closereason");
							out.print(eFormService.closeBusinessResolvedRequest(ticketid,closereason));
							System.out.println("inside close ticket controller end : ");
							
						} catch (Exception e) {
							// TODO: handle exception
						}
						return null;
					}
					
					
					//reopen ticket
					
					@RequestMapping(value = {"/RequestReopenResolvedBusinessTicket"}, method = RequestMethod.POST)
					public String RequestReopenResolvedBusinessTicket(ModelMap model, HttpServletRequest request, HttpServletResponse response,
							HttpSession session, @RequestParam("reopenPic") MultipartFile reopenPic, ModelMap modelMap)
					{
						
						PrintWriter out;
						try {						
							out=response.getWriter();
							String ticketid=request.getParameter("ticketidupdateTD");
							String reopenreason=request.getParameter("reopenreason");
							out.print(eFormService.RequestReopenResolvedBusinessTicket(ticketid,reopenreason,reopenPic));
							
						} catch (Exception e) {
							// TODO: handle exception
						}
						
						return null;
					}
					

					//get details reopen ticket
					
					@RequestMapping(value = { "/getBusinessReOpenRequestDetails" }, method = RequestMethod.POST)
					public JSONArray getBusinessReOpenTicketDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
							HttpSession session) {
						System.out.println("Inside gatherSoftwareRequestDetails Controller@@@@@@@@@@@@ ");
						PrintWriter out = null;

						try {
							out = response.getWriter();

							String ticketid = request.getParameter("ticketid");
						
							System.out.println("ticketid is = " + ticketid);

							JSONArray final_response = eFormService.getBusinessReopenRequestDetails(ticketid);

							System.out.println("UserActivityControllerrrr reponse is = " + final_response);

							out.print(final_response);

							System.out.println("gatherTicketDetails GET SUCCESS");

						} catch (Exception e) {
							e.printStackTrace();
						}

						finally {
							out.close();
						}
//						return "Dashboard";
						return null;

					}
		
					// Eform Business END
					
					@RequestMapping(value = { "/getReleasePendingToApproveRequestByManager" }, method = RequestMethod.POST)
					public String getReleasePendingToApproveRequestByManager(ModelMap model, HttpServletRequest request,
							HttpServletResponse response, HttpSession session) {
						PrintWriter out;
						try {
							out = response.getWriter();

							JSONArray final_response = eFormService.getReleasePendingToApproveRequestByManager();

							System.out.println("getReleasePendingToApproveRequestByManager reponse is = " + final_response);

							out.print(final_response);

						} catch (Exception e) {
							e.printStackTrace();
						}
						return null;
					}
					
					@RequestMapping(value = { "/AssignSoftwareReleaseDetails" }, method = RequestMethod.POST)
					public String AssignSoftwareReleaseDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
							HttpSession session) {
						PrintWriter out;
						try {
							out = response.getWriter();

							String id = request.getParameter("ticketid");
							JSONArray final_response = eFormService.AssignSoftwareReleaseDetails(id);

							System.out.println("AssignSoftwareReleaseDetails reponse is = " + final_response);

							out.print(final_response);

						} catch (Exception e) {
							e.printStackTrace();
						}
						return null;
					}
					@RequestMapping(value = { "/InsertReleaseApprovedByMAnager" }, method = RequestMethod.POST)
					public String InsertReleaseApprovedByMAnager(ModelMap model, HttpServletRequest request,
							HttpServletResponse response, HttpSession session, @RequestParam("assignPic") MultipartFile empPic,
							ModelMap modelMap) {
						PrintWriter out;
						try {
							out = response.getWriter();
							String appByITComp = request.getParameter("nameupdateTP");
							String status = request.getParameter("statusupdateENG");

							String Approvenote = request.getParameter("Approvenote");
							
							String ticketidupdateTDassign = request.getParameter("ticketidupdateTDassign");
							
							String RaisedByName = request.getParameter("nameupdateUDassign");
							String pid=request.getParameter("pid");
							String site = null;
//						        String ApprovalName =request.getParameter("username2");
							String phone = null;
							String emailid = null;
						
							String softwarename = null;
							String ApprovalName = null;
							String CompanyRaisedBy = request.getParameter("companyupdateUDassign");

							String final_response = eFormService.InsertReleaseApprovedByMAnager(appByITComp, status, Approvenote,
									ApprovalName, empPic, phone, emailid, pid, softwarename, CompanyRaisedBy, RaisedByName,
									ticketidupdateTDassign);

							System.out.println("eFormController reponse is = " + final_response);

							out.print(final_response);

						} catch (Exception e) {
							e.printStackTrace();
						}
						return null;
					}
					
					@RequestMapping(value = { "/getReleasePendingToApproveRequestByITCompliance" }, method = RequestMethod.POST)
					public String getReleasePendingToApproveRequestByITCompliance(ModelMap model, HttpServletRequest request,
							HttpServletResponse response, HttpSession session) {
						PrintWriter out;
						try {
							out = response.getWriter();

							JSONArray final_response = eFormService.getReleasePendingToApproveRequestByITCompliance();

							System.out.println("getReleasePendingToApproveRequestByITCompliance reponse is = " + final_response);

							out.print(final_response);

						} catch (Exception e) {
							e.printStackTrace();
						}
						return null;
					}
					
					/////////////////////////RE OPEN IN SOFTWARE TRANSFER START/////////////
					@RequestMapping(value = { "/SoftwareTransferReopenResolvedTicket" }, method = RequestMethod.POST)
					public String SoftwareTransferReopenResolvedTicket(ModelMap model, HttpServletRequest request,
							HttpServletResponse response, HttpSession session, @RequestParam("reopenPic") MultipartFile reopenPic,
							ModelMap modelMap) {
						PrintWriter out;
						try {
							out = response.getWriter();
							
							String tid = request.getParameter("ticketidupdateTDassign");
							
							String RaisedByName = request.getParameter("nameupdateUDassign");
							String reopenreason=request.getParameter("reopenreason");
							
							String final_response = eFormService.SoftwareTransferReopenResolvedTicket(
									 RaisedByName, tid,reopenreason,reopenPic);

							System.out.println("eFormController reponse is = " + final_response);

							out.print(final_response);

						} catch (Exception e) {
							e.printStackTrace();
						}
						return null;
					}
					
					

					@RequestMapping(value = { "/getSoftwaredetailsList" }, method = RequestMethod.POST)
					public String getSoftwaredetailsList(ModelMap model, HttpServletRequest request, HttpServletResponse response,
							HttpSession session) {
						PrintWriter out;
						try {
							out = response.getWriter();

							JSONArray final_response = eFormService.getSoftwaredetailsList();

							System.out.println("getSoftwaredetailsList reponse is = " + final_response);

							out.print(final_response);

						} catch (Exception e) {
							e.printStackTrace();
						}
						return null;
					}
					
					@RequestMapping(value = { "/DownloadFile" }, method = RequestMethod.GET)
					public ResponseEntity<InputStreamResource> downloadFile(HttpServletRequest request) throws IOException {
						
						String filename1=request.getParameter("filename");
						//System.out.println("filename1 "+filename1);
						
						String filename="C:\\ITHelpDesk\\".concat(filename1);		
						
						File file = new File(filename);
						//System.out.println("filename "+file.getName());
						InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

						HttpHeaders headers = new HttpHeaders();
						headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName(
								)));
						headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
						headers.add("Pragma", "no-cache");
						headers.add("Expires", "0");

						ResponseEntity<InputStreamResource> responseEntity = ResponseEntity.ok().headers(headers).contentLength(file.length())
								//.contentType(MediaType.parseMediaType("application/txt")).body(resource);
								.contentType(MediaType.APPLICATION_OCTET_STREAM).body(resource);

						return responseEntity;
					}
					
					
		// SMTP Flow Start
					

@RequestMapping(value = { "/insertSMTPSoftwareRequest" }, method = RequestMethod.POST)
public String insertSoftwareRequest(ModelMap model, HttpServletRequest request,
		HttpServletResponse response, HttpSession session, @RequestParam("empPic") MultipartFile empPic,
		ModelMap modelMap) {
	PrintWriter out;
	try {

		out = response.getWriter();
		String fullname = request.getParameter("name1");
		String compname = request.getParameter("compname");
		String site = request.getParameter("site");
		String department = request.getParameter("department");
		String phone = request.getParameter("phone");
		String emailid = request.getParameter("emailid");
		String pid = request.getParameter("pid");
		String approup = request.getParameter("approup");
		String appserver=request.getParameter("appserver");
		String appserverIp=request.getParameter("appserverIp");
		String applicationServerloc=request.getParameter("applicationServerloc");
		String servercityname=request.getParameter("cityname");
		String noOfMail=request.getParameter("noOfMail");
		String mailsize=request.getParameter("mailsize");
		String description=request.getParameter("description");
		String ExpDate=request.getParameter("ExpDate");

		String final_response = eFormService.insertSoftwareRequest(fullname,compname,site,department,phone,emailid,pid,approup,appserver,appserverIp,applicationServerloc,
				servercityname,noOfMail,mailsize,description,ExpDate,empPic);

		System.out.println("eFormController reponse is = " + final_response);

		out.print(final_response);

	} catch (Exception e) {
		e.printStackTrace();
	}
	return null;
}

//SMTP INSERT DATA END
@RequestMapping(value = { "/getSMTPUserSelectedDetails" }, method = RequestMethod.POST)
public JSONArray getSMTPUserSelectedDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
		HttpSession session) {
	System.out.println("Inside getUserSelectedDetails Controller@@@@@@@@@@@@ ");
	PrintWriter out = null;
	String subject="";


	try {
		out = response.getWriter();
		String apname=request.getParameter("approvalname");

		String[] split = apname.split("~");
		String approvalname=split[0];
		String fullName=split[1];
		System.out.println("gggggggg"+approvalname);
		JSONArray final_response = eFormService.getUserSelectedDetails(approvalname,fullName);
			out.print(final_response);
					
//			System.out.println("getServiceCatalogueSubject NAME GET SUCCESS"+final_response);
		
	} catch (Exception e) {
		e.printStackTrace();
	}

	finally {
		out.close();
	}

	return null;

}



@RequestMapping(value = {"/getSMTPRequestList"}, method = RequestMethod.POST)
public String getSMTPRequestList(ModelMap model, HttpServletRequest request, HttpServletResponse response,
		HttpSession session)
{
	PrintWriter out;
	try
	{
		out=response.getWriter();
        				
		JSONArray final_response = eFormService.getSMTPRequestList();

		System.out.println("getSMTPRequestList reponse is = " + final_response);
					
		out.print(final_response);
        
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	return null;
}

@RequestMapping(value = { "/gatherSMTPRequestDetails" }, method = RequestMethod.POST)
public JSONArray gatherSMTPRequestDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
		HttpSession session) {
	System.out.println("Inside gatherSMTPRequestDetails Controller@@@@@@@@@@@@ ");
	PrintWriter out = null;

	try {
		out = response.getWriter();

		String ticketid = request.getParameter("ticketid");
	
		System.out.println("ticketid is = " + ticketid);

		JSONArray final_response = eFormService.gatherSMTPRequestDetails(ticketid);

		System.out.println("UserActivityControllerrrr reponse is = " + final_response);

		out.print(final_response);

		System.out.println("gatherTicketDetails GET SUCCESS");

	} 
	catch (Exception e) {
		e.printStackTrace();
	}
	return null;
		}


@RequestMapping(value = { "/getSMTPRequestActivityLog" }, method = RequestMethod.POST)
public JSONArray getSMTPRequestActivityLog(ModelMap model, HttpServletRequest request, HttpServletResponse response,
		HttpSession session) {
	System.out.println("Inside getSMTPRequestActivityLog Controller@@@@@@@@@@@@ ");
	PrintWriter out = null;

	try {
		out = response.getWriter();

		String ticketid = request.getParameter("ticketid");

		System.out.println("ticketid in business is = " + ticketid);

		JSONArray final_response = eFormService.getSMTPRequestActivityLog(ticketid);

		System.out.println("UserActivityControllerrrr reponse is = " + final_response);

		out.print(final_response);

		System.out.println("getSMTPRequestActivityLog GET SUCCESS");

	} catch (Exception e) {
		e.printStackTrace();
	}

	finally {
		out.close();
	}
//	return "Dashboard";
	return null;

}

@RequestMapping(value = {"/getSMTPRequestID"}, method = RequestMethod.POST)
public JSONArray getSMTPRequestID(ModelMap model, HttpServletRequest request, HttpServletResponse response,
		HttpSession session)
{
	PrintWriter out;
	System.out.println("inside SMTP request ID");
	try
	{
		out=response.getWriter();			


		JSONArray final_response = eFormService.getSMTPRequestID();
		out.print(final_response);
		//System.out.println("hello sir "+final_response);
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	return null;
}

@RequestMapping(value = {"/getUserSMTPRequestTracking"}, method = RequestMethod.POST)
public String getUserSMTPRequestTracking(ModelMap model, HttpServletRequest request, HttpServletResponse response,
		HttpSession session)
{
	PrintWriter out;
	System.out.println("inside SMT[ request TRACKING");
	try
	{
		out=response.getWriter();		
		String ticketid=request.getParameter("ticketid");
		String requesttype = request.getParameter("requesttype");
		System.out.println("inside business request ID" + ticketid);
		JSONArray final_response=eFormService.getUserSMTPRequestTracking(ticketid);
		System.out.println("controller response :" + final_response);
		out.print(final_response);
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	return null;
}

@RequestMapping(value = { "/getUserSMTPRaisedRequest" }, method = RequestMethod.POST)
public JSONArray getUserSMTPRaisedRequest(ModelMap model, HttpServletRequest request, HttpServletResponse response,
		HttpSession session) {
	System.out.println("Inside getUserSMTPRaisedRequest Controller@@@@@@@@@@@@ ");
	PrintWriter out = null;
	String sname = null;

	try {
		out = response.getWriter();
			
		//public JSONArray getUserRaisedRequest(String ticketlist);
		
		String ticketlist = null;
		JSONArray final_response = eFormService.getUserSMTPRaisedRequest();

		System.out.println("getUserSMTPRaisedRequest reponse is = " + final_response);

		out.print(final_response);

		System.out.println("getUserSMTPRaisedRequest SUCCESS");

	} catch (Exception e) {
		e.printStackTrace();
	}

	finally {
		out.close();
	}
//	return "Dashboard";
	return null;

}

//view detail

		@RequestMapping(value = { "/getSMTPPendingApprovalDetails" }, method = RequestMethod.POST)
		public JSONArray getSMTPRequestTicketDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
				HttpSession session) {
			System.out.println("Inside getSMTPPendingApprovalDetails Controller@@@@@@@@@@@@ ");
			PrintWriter out = null;

			try {
				out = response.getWriter();

				String ticketid = request.getParameter("ticketid");
			
				System.out.println("ticketid is = " + ticketid);

				JSONArray final_response = eFormService.getSMTPPendingApprovalDetails(ticketid);

				System.out.println("getSMTPPendingApprovalDetails reponse is = " + final_response);

				out.print(final_response);

				System.out.println("gatherTicketDetails GET SUCCESS");

			} catch (Exception e) {
				e.printStackTrace();
			}

			finally {
				out.close();
			}
//			return "Dashboard";
			return null;

		}

		@RequestMapping(value = { "/getSMTPPendingTicketRequestActivityLog" }, method = RequestMethod.POST)
		public JSONArray getSMTPPendingTicketRequestActivityLog(ModelMap model, HttpServletRequest request, HttpServletResponse response,
				HttpSession session) {
			System.out.println("Inside getSMTPPendingTicketRequestActivityLog Controller@@@@@@@@@@@@ ");
			PrintWriter out = null;					

			try {
				out = response.getWriter();
				
				String ticketid = request. getParameter("ticketid");
					
				System.out.println("ticketid is = " + ticketid);
				
				JSONArray final_response = eFormService.getSMTPPendingTicketRequestActivityLog(ticketid);

				System.out.println("getSMTPPendingTicketRequestActivityLog reponse is = " + final_response);
							
					out.print(final_response);
							
					System.out.println("getTicketActivityLog GET SUCCESS");
				
			} catch (Exception e) {
				e.printStackTrace();
			}

			finally {
				out.close();
			}
			return null;
			
		}

		//ticket Action
		
				@RequestMapping(value = {"/SMTPPendingActionDetails"},method = RequestMethod.POST)
				public String SMTPPendingActionDetails(HttpServletRequest request,HttpServletResponse response)
				{
					PrintWriter out=null;
					try
					{
						out=response.getWriter();
						String id=request.getParameter("ticketid");
						JSONArray final_reponse=eFormService.SMTPPendingActionDetails(id);
						out.print(final_reponse);
					}
					catch (Exception e) {
						e.printStackTrace();
					}
					return null;
				}
				

				// Insert TicketAction 
				
				@RequestMapping(value = {"/InsertSMTPRequestApprovedByMAnager"}, method = RequestMethod.POST)
				public String InsertSMTPRequestApprovedByMAnager(ModelMap model, HttpServletRequest request, HttpServletResponse response,
						HttpSession session, @RequestParam("assignPic") MultipartFile empPic, ModelMap modelMap)
				{
					PrintWriter out;
					try
					{
						out=response.getWriter();
				        String appByITComp = request.getParameter("nameupdateTP");
				        String Status = request.getParameter("statusupdateENG");
				       System.out.println("epic file name in daoimpl  : " + empPic);
				        String Approvenote = request.getParameter("Approvenote");;
				        String  ticketidupdateTDassign= request.getParameter("ticketidupdateTDassign");;
				        String RaisedByName=request.getParameter("nameupdateUDassign");;
				        String site =null;
//				        String ApprovalName =request.getParameter("nameupdateTP");
				        String phone = null;
				        String emailid = null;
				        String pid = null;
//				        String softwarename = null;
				        String ApprovalName=null;
				        String CompanyRaisedBy =request.getParameter("companyupdateUDassign");
				        
				        String final_response = eFormService.InsertSMTPRequestApprovedByMAnager(appByITComp, Status, Approvenote,ApprovalName,empPic,phone, emailid, pid,CompanyRaisedBy,RaisedByName,ticketidupdateTDassign);

						System.out.println("eFormController reponse is = " + final_response);
									
						out.print(final_response);
				        
					}
					catch (Exception e) {
						e.printStackTrace();
					}
					return null;
				}




//mailupdate  Update flow

//Show List

@RequestMapping(value = { "/MailAdminSMTPRequest" }, method = RequestMethod.POST)
public JSONArray MailAdminSMTPRequest(ModelMap model, HttpServletRequest request, HttpServletResponse response,
		HttpSession session) {
	System.out.println("Inside getUserBusinessRaisedRequest Controller@@@@@@@@@@@@ ");
	PrintWriter out = null;
	String sname = null;

	try {
		out = response.getWriter();
			
		//public JSONArray getUserRaisedRequest(String ticketlist);
		
		String ticketlist = null;
		JSONArray final_response = eFormService.getMailAdminSMTPRequest();

		System.out.println("getbusinessRaisedTicketList reponse is = " + final_response);

		out.print(final_response);

		System.out.println("getBusinessRaisedTicketList SUCCESS");

	} catch (Exception e) {
		e.printStackTrace();
	}

	finally {
		out.close();
	}
//	return "Dashboard";
	return null;

}

// insert mail admin

@RequestMapping(value = {"/InsertSMTPRequestApprovedByMailAdmin"}, method = RequestMethod.POST)
public String InsertSMTPRequestApprovedByMailAdmin(ModelMap model, HttpServletRequest request, HttpServletResponse response,
		HttpSession session, @RequestParam("assignPic") MultipartFile empPic, ModelMap modelMap)
{
	PrintWriter out;
	try
	{
		out=response.getWriter();
        String appByITComp = request.getParameter("nameupdateTP");
        String Status = request.getParameter("statusupdateENG");				       
        String Approvenote = request.getParameter("Approvenote");;
        String  ticketidupdateTDassign= request.getParameter("ticketidupdateTDassign");;
        String RaisedByName=request.getParameter("nameupdateUDassign");;
        String site =null;
//        String ApprovalName =request.getParameter("nameupdateTP");
        String phone = null;
        String emailid = null;
        String pid = null;
        String ApprovalName=null;
        String CompanyRaisedBy =request.getParameter("companyupdateUDassign");
        
        String final_response = eFormService.InsertSMTPRequestApprovedByMailAdmin(appByITComp, Status, Approvenote,ApprovalName,empPic,phone, emailid, pid,CompanyRaisedBy,RaisedByName,ticketidupdateTDassign);

		System.out.println("eFormController reponse is = " + final_response);
					
		out.print(final_response);
        
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	return null;
}


//Show List

@RequestMapping(value = { "/MailAdminSMTPBucket" }, method = RequestMethod.POST)
public JSONArray MailAdminSMTPBucket(ModelMap model, HttpServletRequest request, HttpServletResponse response,
		HttpSession session) {
	System.out.println("Inside getUserBusinessRaisedRequest Controller@@@@@@@@@@@@ ");
	PrintWriter out = null;
	String sname = null;

	try {
		out = response.getWriter();
			
		//public JSONArray getUserRaisedRequest(String ticketlist);
		
		String ticketlist = null;
		JSONArray final_response = eFormService.getMailAdminSMTPBucket();

		System.out.println("getbusinessRaisedTicketList reponse is = " + final_response);

		out.print(final_response);

		System.out.println("getBusinessRaisedTicketList SUCCESS");

	} catch (Exception e) {
		e.printStackTrace();
	}

	finally {
		out.close();
	}
//	return "Dashboard";
	return null;

}

// close the resolved request 

@RequestMapping(value = {"/closeSMTPResolvedRequest"},method = RequestMethod.POST)
public String closeSMTPResolvedRequest(HttpServletRequest request, HttpServletResponse response,
		HttpSession session)
{
	
	System.out.println("inside close ticket controller");
	PrintWriter out;
	try {						
		out=response.getWriter();
		String ticketid=request.getParameter("ticketid");
		System.out.println("value of ticket : " + ticketid);
		String closereason=request.getParameter("closereason");
		out.print(eFormService.closeSMTPResolvedRequest(ticketid,closereason));
		System.out.println("inside close ticket controller end : ");
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	return null;
}


//reopen ticket

@RequestMapping(value = {"/RequestReopenResolvedSMTPTicket"}, method = RequestMethod.POST)
public String RequestReopenResolvedSMTPTicket(ModelMap model, HttpServletRequest request, HttpServletResponse response,
		HttpSession session, @RequestParam("reopenPic") MultipartFile reopenPic, ModelMap modelMap)
{
	
	PrintWriter out;
	try {						
		out=response.getWriter();
		String ticketid=request.getParameter("ticketidupdateTD");
		String reopenreason=request.getParameter("reopenreason");
		out.print(eFormService.RequestReopenResolvedSMTPTicket(ticketid,reopenreason,reopenPic));
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	
	return null;
}


//get details reopen ticket

@RequestMapping(value = { "/getSMTPReOpenRequestDetails" }, method = RequestMethod.POST)
public JSONArray getSMTPReOpenTicketDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
		HttpSession session) {
	System.out.println("Inside gatherSoftwareRequestDetails Controller@@@@@@@@@@@@ ");
	PrintWriter out = null;

	try {
		out = response.getWriter();

		String ticketid = request.getParameter("ticketid");
	
		System.out.println("ticketid is = " + ticketid);

		JSONArray final_response = eFormService.getSMTPReopenRequestDetails(ticketid);

		System.out.println("UserActivityControllerrrr reponse is = " + final_response);

		out.print(final_response);

		System.out.println("gatherTicketDetails GET SUCCESS");

	} catch (Exception e) {
		e.printStackTrace();
	}

	finally {
		out.close();
	}
//	return "Dashboard";
	return null;

}

//mail admin view ticket

@RequestMapping(value = { "/getrSMTPRequestDetails" }, method = RequestMethod.POST)
public JSONArray getSMTPFlowRequestTicketDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
		HttpSession session) {
	System.out.println("Inside gatherSoftwareRequestDetails Controller@@@@@@@@@@@@ ");
	PrintWriter out = null;

	try {
		out = response.getWriter();

		String ticketid = request.getParameter("ticketid");
	
		System.out.println("ticketid is = " + ticketid);

		JSONArray final_response = eFormService.gatherSMTPRequestRequestDetails(ticketid);

		System.out.println("UserActivityControllerrrr reponse is = " + final_response);

		out.print(final_response);

		System.out.println("gatherTicketDetails GET SUCCESS");

	} catch (Exception e) {
		e.printStackTrace();
	}

	finally {
		out.close();
	}
//	return "Dashboard";
	return null;

}


// SMTP bUSINESS activitylog

@RequestMapping(value = { "/getSMTPTicketRequestActivityLog" }, method = RequestMethod.POST)
public JSONArray getSMTPActivityRequestActivityLog(ModelMap model, HttpServletRequest request, HttpServletResponse response,
		HttpSession session) {
	System.out.println("Inside getRequestActivityLog Controller@@@@@@@@@@@@ ");
	PrintWriter out = null;

	try {
		out = response.getWriter();

		String ticketid = request.getParameter("ticketid");

		System.out.println("ticketid is = " + ticketid);

		JSONArray final_response = eFormService.getSMTPActivityTicketRequestActivityLog(ticketid);

		System.out.println("UserActivityControllerrrr reponse is = " + final_response);

		out.print(final_response);

		System.out.println("getRequestActivityLog GET SUCCESS");

	} catch (Exception e) {
		e.printStackTrace();
	}

	finally {
		out.close();
	}
//	return "Dashboard";
	return null;

}

					
					
		// SMTP Flow End
					
}
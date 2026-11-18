package com.velox.itsm.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//import javax.xml.ws.spi.http.HttpContext;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.velox.itsm.config.Multiperpose;
import com.velox.itsm.service.UserActivityService;


@Controller
@RequestMapping("/UserActivity")
public class UserActivityController {

	@Autowired
	UserActivityService userActivityService;
	
	 @Autowired
	    private ServletContext servletContext;

	
	@RequestMapping(value = { "/getAllUserDetails" }, method = RequestMethod.POST)
	public String getAllUserDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside getAllUserDetails Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String details = null;
		 String LoginUser = null;
		 String  fullname=null;
		try {
//            HttpSession session = request.getSession(true);
            LoginUser = session.getAttribute("username").toString();
             fullname = session.getAttribute("fullname").toString();
            System.out.println("username****" + LoginUser);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exceptioon e***" + e);
        }

		try {
			out = response.getWriter();
			
			JSONArray final_response = userActivityService.getAllUserDetails(LoginUser);

			System.out.println("MastersControllerrrr reponse is = " + final_response);
						
				out.print(final_response);
						
				System.out.println("getAllUserDetails GET SUCCESS");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;

	}
	
	
//	
//	@RequestMapping(value = { "/getAllUserDetails" }, method = RequestMethod.POST)
//	public String getAllUserDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
//			HttpSession session) {
//		System.out.println("Inside getAllUserDetails Controller@@@@@@@@@@@@ ");
//		PrintWriter out = null;
//		String details = null;
//		 String LoginUser = null;
//		try {
////            HttpSession session = request.getSession(true);
//            LoginUser = session.getAttribute("username").toString();
//            System.out.println("username****" + LoginUser);
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("Exceptioon e***" + e);
//        }
//
//		try {
//			out = response.getWriter();
//			
//			JSONArray final_response = userActivityService.getAllUserDetails(LoginUser);
//
//			System.out.println("MastersControllerrrr reponse is = " + final_response);
//						
//				out.print(final_response);
//						
//				System.out.println("getAllUserDetails GET SUCCESS");
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		finally {
//			out.close();
//		}
//
//		return null;
//
//	}
	
	

	@RequestMapping(value = { "/getVlxProposalApprovedMDData" }, method = RequestMethod.POST)
	public void getVlxProposalApprovedMDData(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Inside getVlxProposalApprovalMDData method");
		
		String crno=request.getParameter("crno");
		 String tid = request.getParameter("tid");
//		int crno1=Integer.parseInt(crno);
		PrintWriter out = null;
		try {
			
			HttpSession htt = request.getSession(true);
            String uname = (String) htt.getAttribute("username");
            System.out.println("usernamemeeem login==" + uname);
            System.out.println("usernamemeeem login==" + crno);
            System.out.println("usernamemeeem login==" + tid);

			out = response.getWriter();
			JSONArray array = (JSONArray) userActivityService.getVlxProposalApprovedMDData(crno,uname,tid);
			System.out.println("List value: "+array);
			out.print(array);
		}
		catch(Exception e) {
			System.out.println("Exception in getAttachmentCSData method: "+e);
		}
		
	}
	
	@RequestMapping(value = { "/getVlxProposalApprovalMDData" }, method = RequestMethod.POST)
	public void getVlxProposalApprovalMDData(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Inside getVlxProposalApprovalMDData method");
		
		String crno=request.getParameter("crno");
		 String tid = request.getParameter("tid");
//		int crno1=Integer.parseInt(crno);
		PrintWriter out = null;
		try {
			
			HttpSession htt = request.getSession(true);
            String uname = (String) htt.getAttribute("username");
            System.out.println("usernamemeeem login==" + uname);
            System.out.println("usernamemeeem login==" + crno);
            System.out.println("usernamemeeem login==" + tid);

			out = response.getWriter();
			JSONArray array = (JSONArray) userActivityService.getVlxProposalApprovalMDData(crno,uname,tid);
			System.out.println("List value: "+array);
			out.print(array);
		}
		catch(Exception e) {
			System.out.println("Exception in getAttachmentCSData method: "+e);
		}
		
	}
	
	

	@RequestMapping(value = { "/UpdateVlxPropMDApprove" }, method = RequestMethod.POST)
	public void UpdateVlxPropMDApprove(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Inside UpdateVlxPropMDApprove method");
		
		 String crno = request.getParameter("crno");
        String status = request.getParameter("status");
	     String tid = request.getParameter("tid");
	     String MDnote = request.getParameter("MDnote");
		
		PrintWriter out = null;
		try {
			HttpSession htt = request.getSession(true);
           String uname = (String) htt.getAttribute("username");
           String company = (String) htt.getAttribute("usercompany");
           System.out.println("usernamemeeem login==" + uname);
			
			out = response.getWriter();
			String result = userActivityService.UpdateVlxPropMDApprove(crno,status,tid,uname,company,MDnote);
			System.out.println("Result value: "+result);
			out.print(result);
		}
		catch(Exception e) {
			System.out.println("Exception in Asave Company: "+e);
		}

	}
	@RequestMapping(value = { "/vlxProposalApproveDetails" }, method = RequestMethod.POST)
	public JSONArray vlxProposalApproveDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,HttpSession session) {
		System.out.println("Inside cm vlxProposalApproveDetails Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
	
		try {
			out = response.getWriter();
			
			 String uname = (String) session.getAttribute("username");
			 String company = (String) session.getAttribute("usercompany");
			JSONArray final_response = userActivityService.vlxProposalApproveDetails(uname,company);

			System.out.println("MastersControllerrrr reponse is = " + final_response);
						
				out.print(final_response);
						
				System.out.println("username GET SUCCESS");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;
		
	}
	
	@RequestMapping(value = { "/getApprovaalCollnMangData" }, method = RequestMethod.POST)
	public void getApprovaalCollnMangData(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Inside getApprovaalSaleMngData method");
		
		String crno=request.getParameter("crno");
		 String tid = request.getParameter("tid");
//		int crno1=Integer.parseInt(crno);
		PrintWriter out = null;
		try {
			
			HttpSession htt = request.getSession(true);
            String uname = (String) htt.getAttribute("username");
            System.out.println("usernamemeeem login==" + uname);
            System.out.println("usernamemeeem login==" + crno);
            System.out.println("usernamemeeem login==" + tid);

			out = response.getWriter();
			JSONArray array = (JSONArray) userActivityService.getApprovaalCollnMangData(crno,uname,tid);
			System.out.println("List value: "+array);
			out.print(array);
		}
		catch(Exception e) {
			System.out.println("Exception in getAttachmentCSData method: "+e);
		}
		
	}
	@RequestMapping(value = { "/ApprovedCollnMangDetails" }, method = RequestMethod.POST)
	public void ApprovedCollnMangDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,HttpSession session) {
		System.out.println("Inside ApprovalCRFDetails method");
		
		PrintWriter out = null;
		try {
			
			String uname = (String) session.getAttribute("username");
			String company = (String) session.getAttribute("usercompany");
			String role = (String) session.getAttribute("role");
            System.out.println("usernamemeeem login==" + uname);

			out = response.getWriter();
			JSONArray array = (JSONArray) userActivityService.ApprovedCollnMangDetails(uname,company,role);
			System.out.println("List value: "+array);
			out.print(array);
		}
		catch(Exception e) {
			System.out.println("Exception in ApplicationUserController getBranchList method: "+e);
		}
		
	}
	@RequestMapping(value = { "/getUserDashboardData" }, method = RequestMethod.POST)
	public JSONArray getUserDashboardData(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside getTPDashboardData Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		
		try {
			out = response.getWriter();
			String loginuser=(String)session.getAttribute("username");
			String loginUserCompany = session.getAttribute("companyname").toString();
			String chartdata = null;
			JSONArray final_response = userActivityService.getUserDashboardData(loginuser,loginUserCompany);

			System.out.println("getTPDashboardData reponse is = " + final_response);

			out.print(final_response);

			System.out.println("getTPDashboardData SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}
	

	@RequestMapping(value = { "/PoRaiseByMeDetails" }, method = RequestMethod.POST)
	public JSONArray PoRaiseByMeDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,HttpSession session) {
		System.out.println("Inside cm details Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
	
		try {
			out = response.getWriter();
			
			 String uname = (String) session.getAttribute("username");
			 String company = (String) session.getAttribute("usercompany");
			 String role = (String) session.getAttribute("role");
			JSONArray final_response = userActivityService.PoRaiseByMeDetails(uname,company,role);

			System.out.println("MastersControllerrrr reponse is = " + final_response);
						
				out.print(final_response);
						
				System.out.println("username GET SUCCESS");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;
		
	}

	@RequestMapping(value = { "/getUpdateCollnMangpprove" }, method = RequestMethod.POST)
	public void getUpdateCollnMangpprove(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Inside getUpdateCollnMangpprove method");
		
		 String crno = request.getParameter("crno");
        String status = request.getParameter("status");
	     String tid = request.getParameter("tid");
	     String aMnote = request.getParameter("AMnote");
		
		PrintWriter out = null;
		try {
			HttpSession htt = request.getSession(true);
           String uname = (String) htt.getAttribute("username");
           String company = (String) htt.getAttribute("usercompany");
           System.out.println("usernamemeeem login==" + uname);
			
			out = response.getWriter();
			String result = userActivityService.getUpdateCollnMangpprove(crno,status,tid,uname,company,aMnote);
			System.out.println("Result value: "+result);
			out.print(result);
		}
		catch(Exception e) {
			System.out.println("Exception in Asave Company: "+e);
		}

	}
	
	@RequestMapping(value = { "/SaleMngApprByMeDetails" }, method = RequestMethod.POST)
	public JSONArray saleMngApprByMeDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,HttpSession session) {
		System.out.println("Inside cm details Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
	
		try {
			out = response.getWriter();
			
			 String uname = (String) session.getAttribute("username");
			 String company = (String) session.getAttribute("usercompany");
			 String userfullname = (String) session.getAttribute("fullname");
			 
			JSONArray final_response = userActivityService.saleMngApprByMeDetails(uname,company,userfullname);

			System.out.println("MastersControllerrrr reponse is = " + final_response);
						
				out.print(final_response);
						
				System.out.println("username GET SUCCESS");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;
		
	}
	
	
	
	
	@RequestMapping(value = { "/insertUserRaiseTicket" }, method = RequestMethod.POST)
	public String insertUserRaiseTicket(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session, @RequestParam("empPic") MultipartFile empPic, ModelMap modelMap) {
		System.out.println("Inside insertUserRaiseTicket Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String details = null;
		
		try {
			out = response.getWriter();
			
	        String fullname = request.getParameter("name1");
	        String datepicker5 = request.getParameter("datepicker5");
	        String phone = request.getParameter("phone");
	        String emailid = request.getParameter("emailid");
	        String compname = request.getParameter("compname");
	        String site = request.getParameter("site");
	        String category = request.getParameter("category");
	        String subcat1 = request.getParameter("subcat1");
	        String subcat2 = request.getParameter("subcat2");
	        String requestmode = request.getParameter("requestmode");
	        String department = request.getParameter("department");
	        String subject = request.getParameter("sub");
	        String description = request.getParameter("description");
	        String priority = request.getParameter("priority");
	        String severity = request.getParameter("severity");
	        String username = request.getParameter("username");
	        String vipuser = request.getParameter("vipuser");

	        String assetTag = request.getParameter("atag");
	        String assetName = request.getParameter("aname");
	        String AssetCategory = request.getParameter("acategory");
	        String AssetStatus = request.getParameter("astatus");	
	        String assetcheckboc=request.getParameter("assetCheck");
	        String asset_sub_category = request.getParameter("asset_sub_category");	
	        String asset_Ipaddress=request.getParameter("asset_Ipaddress");
//	        System.out.println("dgdggfdfg gff dhghgyhgdh"+assetcheckboc);
			String AssetCheck="";
//			System.out.println("FFFFFFFFFFFFFFFFFFF"+Multiperpose.getsesssionvalue());
			try {
				
					if(assetcheckboc==null)
				{
					AssetCheck="false";
				}
					if(!(assetcheckboc==null))
					{
				if (assetcheckboc.equals("on")) {
					AssetCheck = "true";
				}
				}
//				System.out.println(" selected value is " + assetcheckboc);
			} catch (NullPointerException e) {
				e.printStackTrace();
			}
	     
	        System.out.println("fullname: "+fullname);
	        System.out.println("username: "+username);
	        System.out.println("datepicker5: "+datepicker5);
	        System.out.println("phone: "+phone);
	        System.out.println("emailid: "+emailid);
	        System.out.println("compname: "+compname);
	        System.out.println("site: "+site);
	        System.out.println("category: "+category);
	        System.out.println("subcat1: "+subcat1);
	        System.out.println("subcat2: "+subcat2);
	        System.out.println("requestmode: "+requestmode);
	        System.out.println("department "+department);
	        System.out.println("subject:"+subject);
	        System.out.println("description: "+description);
	        System.out.println("priority:"+priority);
	        System.out.println("severity:"+severity);
	        System.out.println("EMPIC FILE NAME: "+empPic.getOriginalFilename());
	        System.out.println("EMPIC FILE SIZE: "+empPic.getSize());
	        System.out.println("VIPUSER: "+vipuser);
			
			String final_response = userActivityService.insertUserRaiseTicket(fullname, datepicker5, phone, emailid, compname, site, category, subcat1, subcat2, requestmode, department, subject, description, priority, severity, empPic, username, vipuser,assetTag,assetName,AssetCategory,AssetStatus,AssetCheck,asset_sub_category,asset_Ipaddress);

			System.out.println("MastersControllerrrr reponse is = " + final_response);
						
				out.print(final_response);
						
				System.out.println("insertUserRaiseTicket GET SUCCESS");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;

	}
	
	
	@RequestMapping(value = { "/getUserTicketList" }, method = RequestMethod.POST)
	public JSONArray getUserTicketList(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside getUserTicketList Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;
	

		try {
			out = response.getWriter();
			
			String userlist=null;
			JSONArray final_response = userActivityService.getUserTicketList(userlist);

			System.out.println("getUserTicketList reponse is = " + final_response);
						
				out.print(final_response);
						
				System.out.println("getUserTicketList SUCCESS");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;
		
	}
	
	@RequestMapping(value = { "/gatherUserTicketDetails" }, method = RequestMethod.POST)
	public JSONArray gatherUserTicketDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside gatherUserTicketDetails Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		
	

		try {
			out = response.getWriter();
			
			String ticketid = request. getParameter("ticketid");
			
			System.out.println("ticketid is = " + ticketid);
			
			JSONArray final_response = userActivityService.gatherUserTicketDetails(ticketid);
			model.addAttribute("Company_Of_Ticket",final_response.getJSONObject(0).getString("T_COMPANY"));	
			System.out.println("UserActivityControllerrrr reponse is = " + final_response);
						
				out.print(final_response);
						
				System.out.println("gatherUserTicketDetails GET SUCCESS");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;
		
	}

	@RequestMapping(value = { "/getVlxProposalApprovedData" }, method = RequestMethod.POST)
	public void getVlxProposalApprovedData(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Inside getVlxProposalApprovedData method");
		
		String crno=request.getParameter("crno");
		 String tid = request.getParameter("tid");
//		int crno1=Integer.parseInt(crno);
		PrintWriter out = null;
		try {
			
			HttpSession htt = request.getSession(true);
            String uname = (String) htt.getAttribute("username");
            System.out.println("usernamemeeem login==" + uname);
            System.out.println("usernamemeeem login==" + crno);
            System.out.println("usernamemeeem login==" + tid);

			out = response.getWriter();
			JSONArray array = (JSONArray) userActivityService.getVlxProposalApprovedData(crno,uname,tid);
			System.out.println("List value: "+array);
			out.print(array);
		}
		catch(Exception e) {
			System.out.println("Exception in getAttachmentCSData method: "+e);
		}
		
	}
	@RequestMapping(value = { "/vlxProposalMDPendingDetails" }, method = RequestMethod.POST)
	public JSONArray vlxProposalMDPendingDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,HttpSession session) {
		System.out.println("Inside cm details Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
	
		try {
			out = response.getWriter();
			
			 String uname = (String) session.getAttribute("username");
			 String company = (String) session.getAttribute("usercompany");
			JSONArray final_response = userActivityService.vlxProposalMDPendingDetails(uname,company);

			System.out.println("MastersControllerrrr reponse is = " + final_response);
						
				out.print(final_response);
						
				System.out.println("username GET SUCCESS");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;
		
	}

	
	@RequestMapping(value = { "/getUserTicketID" }, method = RequestMethod.POST)
	public JSONArray getUserTicketID(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside getUserTicketID Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
//		String details = null;
	

		try {
			out = response.getWriter();
			
		//	String details = request.getParameter("lastmonth");
			String details = request.getParameter("timePeriod"); 
			String selecttype = request.getParameter("selectType");
			System.out.println("details :"+details);
			System.out.println("selecttype :"+selecttype);
			
			JSONArray final_response = userActivityService.getUserTicketID(details,selecttype);

			System.out.println("UserActivityControllerrrr reponse is = " + final_response);
						
				out.print(final_response);
						
				System.out.println("getUserTicketID GET SUCCESS");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}
	@RequestMapping(value = { "/getVlxProposalData" }, method = RequestMethod.POST)
	public void getVlxProposalData(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Inside getApprovaalSaleMngData method");
		
		String crno=request.getParameter("crno");
		 String tid = request.getParameter("tid");
//		int crno1=Integer.parseInt(crno);
		PrintWriter out = null;
		try {
			
			HttpSession htt = request.getSession(true);
            String uname = (String) htt.getAttribute("username");
            System.out.println("usernamemeeem login==" + uname);
            System.out.println("usernamemeeem login==" + crno);
            System.out.println("usernamemeeem login==" + tid);

			out = response.getWriter();
			JSONArray array = (JSONArray) userActivityService.getVlxProposalData(crno,uname,tid);
			System.out.println("List value: "+array);
			out.print(array);
		}
		catch(Exception e) {
			System.out.println("Exception in getAttachmentCSData method: "+e);
		}
		
	}
	
	
	@RequestMapping(value = { "/vlxProposalRejectedSIDetails" }, method = RequestMethod.POST)
	public void vlxProposalRejectedSIDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside vlxProposalRejectedSIDetails method");

		PrintWriter out = null;
		try {

			String uname = (String) session.getAttribute("username");
			String company = (String) session.getAttribute("usercompany");
			String fullname = (String) session.getAttribute("fullname");
			System.out.println("usernamemeeem login==" + uname);

			out = response.getWriter();
			JSONArray array = (JSONArray) userActivityService.vlxProposalRejectedSIDetails(uname, company,fullname);
			System.out.println("List value: " + array);
			out.print(array);
		} catch (Exception e) {
			System.out.println("Exception in ApplicationUserController getBranchList method: " + e);
		}

	}

	@RequestMapping(value = { "/vlxProposalSendBymeDetails" }, method = RequestMethod.POST)
	public JSONArray vlxProposalSendBymeDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,HttpSession session) {
		
		PrintWriter out = null;
	
		try {
			out = response.getWriter();
			
			 String uname = (String) session.getAttribute("username");
			 String company = (String) session.getAttribute("usercompany");
			JSONArray final_response = userActivityService.vlxProposalSendBymeDetails(uname,company);

			System.out.println("MastersControllerrrr reponse is = " + final_response);
						
				out.print(final_response);
						
				System.out.println("username GET SUCCESS");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;
		
	}
	
	@RequestMapping(value = { "/vlxProposalPendingDetails" }, method = RequestMethod.POST)
	public JSONArray vlxProposalPendingDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,HttpSession session) {
		System.out.println("Inside cm details Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
	
		try {
			out = response.getWriter();
			
			 String uname = (String) session.getAttribute("username");
			 String company = (String) session.getAttribute("usercompany");
			 String userfullname = (String) session.getAttribute("fullname");
			 
			JSONArray final_response = userActivityService.vlxProposalPendingDetails(uname,company,userfullname);

			System.out.println("MastersControllerrrr reponse is = " + final_response);
						
				out.print(final_response);
						
				System.out.println("username GET SUCCESS");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;
		
	}
	

	@RequestMapping(value = { "/getVlxProposalPendingData" }, method = RequestMethod.POST)
	public void getVlxProposalPendingData(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Inside getVlxProposalPendingData method");
		
		String crno=request.getParameter("crno");
		 String tid = request.getParameter("tid");
//		int crno1=Integer.parseInt(crno);
		PrintWriter out = null;
		try {
			
			HttpSession htt = request.getSession(true);
            String uname = (String) htt.getAttribute("username");
            System.out.println("usernamemeeem login==" + uname);
            System.out.println("usernamemeeem login==" + crno);
            System.out.println("usernamemeeem login==" + tid);

			out = response.getWriter();
			JSONArray array = (JSONArray) userActivityService.getVlxProposalPendingData(crno,uname,tid);
			System.out.println("List value: "+array);
			out.print(array);
		}
		catch(Exception e) {
			System.out.println("Exception in getAttachmentCSData method: "+e);
		}
		
	}
	
	@RequestMapping(value = { "/UpdateVlxPropSaleMangApprove" }, method = RequestMethod.POST)
	public void UpdateVlxPropSaleMangApprove(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Inside UpdateVlxPropSaleMangApprove method");

		String crno = request.getParameter("crno");
		String status = request.getParameter("status");
		String tid = request.getParameter("tid");
		String SMnote = request.getParameter("SMnote");

		PrintWriter out = null;
		try {
			HttpSession htt = request.getSession(true);
			String uname = (String) htt.getAttribute("username");
			String company = (String) htt.getAttribute("usercompany");
			System.out.println("usernamemeeem login==" + uname);

			out = response.getWriter();
			String result = userActivityService.UpdateVlxPropSaleMangApprove(crno, status, tid, uname, company,SMnote);
			System.out.println("Result value: " + result);
			out.print(result);
		} catch (Exception e) {
			System.out.println("Exception in Asave Company: " + e);
		}

	}

	@RequestMapping(value = { "/vlxPropApproveBymeDetails" }, method = RequestMethod.POST)
	public void vlxPropApproveBymeDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,HttpSession session) {
		System.out.println("Inside vlxPropApproveBymeDetails method");
		
		PrintWriter out = null;
		try {
			
			String uname = (String) session.getAttribute("username");
			String company = (String) session.getAttribute("usercompany");
			String userfullname = (String) session.getAttribute("fullname");
            System.out.println("usernamemeeem login==" + uname);

			out = response.getWriter();
			JSONArray array = (JSONArray) userActivityService.vlxPropApproveBymeDetails(uname,company,userfullname);
			System.out.println("List value: "+array);
			out.print(array);
		}
		catch(Exception e) {
			System.out.println("Exception in ApplicationUserController getBranchList method: "+e);
		}
		
	}
	@RequestMapping(value = { "/getUserTicketTracking" }, method = RequestMethod.POST)
	public JSONArray getUserTicketTracking(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside getUserTicketTracking Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		
	

		try {
			out = response.getWriter();
			
			String ticketid = request. getParameter("ticketid");
				
			System.out.println("ticketid is = " + ticketid);
			
			JSONArray final_response = userActivityService.getUserTicketTracking(ticketid);

			System.out.println("userActivityControllerrrr reponse is = " + final_response);
						
				out.print(final_response);
						
				System.out.println("getUserTicketTracking GET SUCCESS");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;
		
	}
	
	@RequestMapping(value = { "/getUserTicketTrackingMessage" }, method = RequestMethod.POST)
	public JSONArray getUserTicketTrackingMessage(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside getUserTicketTrackingMessage Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		
	

		try {
			out = response.getWriter();
			
			int ticketid = Integer.parseInt(request. getParameter("ticketid"));
				
			System.out.println("ticketid is = " + ticketid);
			
			JSONArray final_response = userActivityService.getUserTicketTrackingMessage(ticketid);

			System.out.println("userActivityControllerrrr reponse is = " + final_response);
						
				out.print(final_response);
						
				System.out.println("getUserTicketTrackingMessage GET SUCCESS");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;
		
	}
	
	@RequestMapping(value = { "/getResolvedUserTicketList" }, method = RequestMethod.POST)
	public JSONArray getResolvedUserTicketList(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside getResolvedUserTicketList Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;
	

		try {
			out = response.getWriter();
			
			String userlist=null;
			JSONArray final_response = userActivityService.getResolvedUserTicketList(userlist);

			System.out.println("getResolvedUserTicketList reponse is = " + final_response);
						
				out.print(final_response);
						
				System.out.println("getResolvedUserTicketList SUCCESS");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;
		
	}
	
	@RequestMapping(value = { "/closeUserResolvedTicket" }, method = RequestMethod.POST)
	public String closeUserResolvedTicket(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside closeUserResolvedTicket Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String details = null;
		
		try {
			out = response.getWriter();
			
			String ticketid = request. getParameter("ticketid");
	        String closereason = request.getParameter("closereason");
	       
	        System.out.println("ticketid: "+ticketid);
	        System.out.println("closereason: "+closereason);
	      
			String final_response1 = userActivityService.closeUserResolvedTicket(ticketid, closereason);

			System.out.println("UserActivityControllerrrr reponse is = " + final_response1);
				out.print(final_response1);
				System.out.println("closeUserResolvedTicket GET SUCCESS");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;

	}
	
	@RequestMapping(value = { "/UserReopenResolvedTicket" }, method = RequestMethod.POST)
	public JSONArray UserReopenResolvedTicket(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session, @RequestParam("reopenPic") MultipartFile reopenPic, ModelMap modelMap) {
		System.out.println("Inside UserReopenResolvedTicket Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		
	

		try {
			out = response.getWriter();
					
			String RequesterName = request.getParameter("nameupdateUDreopen");
			String RequesterCompany = request.getParameter("companyupdateUDreopen");
			String RequesterBranch = request.getParameter("siteupdateUDreopen");
			String RequesterDept = request.getParameter("deptupdateUDreopen");
			String RequesterSubDept = request.getParameter("subdeptupdateUDreopen");
			String RequesterLocation = request.getParameter("locationupdateUDreopen");
			String RequesterPhone = request.getParameter("phoneupdateUDreopen");
			String RequesterEmail = request.getParameter("emailupdateUDreopen");
	        
			String TicketID = request.getParameter("ticketidupdateTDreopen");
			String TicketStatus = request.getParameter("statusupdateTDreopen");
			String TicketRaiseDate = request.getParameter("raisedateupdateTDreopen");
			String Category = request.getParameter("categoryupdateTDreopen");
			String SubCat1 = request.getParameter("subcat1updateTDreopen");
			String SubCat2 = request.getParameter("subcat2updateTDreopen");
			String Subject = request.getParameter("subjectupdateTDreopen");
			String Priority = request.getParameter("priorityupdateTDreopen");
			String Severity = request.getParameter("severityupdateTDreopen");
			String T_Description = request.getParameter("descriptionupdateTDreopen");
			String T_RequestMode = request.getParameter("RequestModeupdateTDreopen");
			String ReopenReason = request.getParameter("reopenreason");
			
			
			System.out.println("RequesterName is = " + RequesterName);
			System.out.println("RequesterCompany is = " + RequesterCompany);
			System.out.println("RequesterBranch is = " + RequesterBranch);
			System.out.println("RequesterDept is = " + RequesterDept);
			System.out.println("RequesterSubDept is = " + RequesterSubDept);
			System.out.println("RequesterLocation is = " + RequesterLocation);
			System.out.println("RequesterPhone is = " + RequesterPhone);
			System.out.println("RequesterEmail is = " + RequesterEmail);
			
			System.out.println("TicketID is = " + TicketID);
			System.out.println("TicketStatus is = " + TicketStatus);
			System.out.println("TicketRaiseDate is = " + TicketRaiseDate);
			System.out.println("Category is = " + Category);
			System.out.println("SubCat1 is = " + SubCat1);
			System.out.println("SubCat2 is = " + SubCat2);
			System.out.println("Subject is = " + Subject);
			
			System.out.println("Priority is = " + Priority);
			System.out.println("Severity is = " + Severity);
			System.out.println("T_Description is = " + T_Description);
			System.out.println("T_RequestMode is = " + T_RequestMode);
			System.out.println("ReopenReason is = " + ReopenReason);
			
			System.out.println("EMPIC FILE NAME: "+reopenPic.getOriginalFilename());
	        System.out.println("EMPIC FILE SIZE: "+reopenPic.getSize());
			
			String final_response = userActivityService.UserReopenResolvedTicket(RequesterName, RequesterCompany, RequesterBranch, RequesterDept, RequesterSubDept, RequesterLocation, RequesterPhone, RequesterEmail, TicketID, TicketStatus, TicketRaiseDate, Category, SubCat1, SubCat2, Subject, Priority, Severity, T_Description, T_RequestMode, ReopenReason, reopenPic);

			System.out.println("UserActivityControllerrrr reponse is = " + final_response);
						
				out.print(final_response);
						
				System.out.println("UserReopenResolvedTicket GET SUCCESS");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;
		
	}
	
	@RequestMapping(value = { "/getClosedUserTicketList" }, method = RequestMethod.POST)
	public JSONArray getClosedUserTicketList(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside getClosedUserTicketList Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;
	

		try {
			out = response.getWriter();
			
			String userlist=null;
			JSONArray final_response = userActivityService.getClosedUserTicketList(userlist);

			System.out.println("getClosedUserTicketList reponse is = " + final_response);
						
				out.print(final_response);
						
				System.out.println("getClosedUserTicketList SUCCESS");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;
		
	}
	
	@RequestMapping(value = { "/UserPasswordreset" }, method = RequestMethod.POST)
	public JSONArray UserPasswordreset(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside UserPasswordreset Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		
		try {
			out = response.getWriter();
					
			String user = request.getParameter("user");
	        String oldpass = request.getParameter("oldpass");
	        String newpass = request.getParameter("newpass");
	        String cnfnewpass = request.getParameter("cnfnewpass");
	       			
			System.out.println("user is = " + user);
			System.out.println("oldpass is = " + oldpass);
			System.out.println("newpass is = " + newpass);
			System.out.println("cnfnewpass is = " + cnfnewpass);
						
			String final_response = userActivityService.UserPasswordreset(user, oldpass, newpass, cnfnewpass);

			System.out.println("UserActivityControllerrrr reponse is = " + final_response);
						
				out.print(final_response);
						
				System.out.println("UserPasswordreset GET SUCCESS");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;
		
	}
	
	@RequestMapping(value = { "/getTicketActivityLog" }, method = RequestMethod.POST)
	public JSONArray getTicketActivityLog(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside getTicketActivityLog Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		
	

		try {
			out = response.getWriter();
			
			String ticketid = request. getParameter("ticketid");
				
			System.out.println("ticketid is = " + ticketid);
			
			JSONArray final_response = userActivityService.getTicketActivityLog(ticketid);

			System.out.println("getTicketActivityLog reponse is = " + final_response);
						
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
	
	@RequestMapping(value = { "/insertServiceCatalogueRequest" }, method = RequestMethod.POST)
	public String insertServiceCatalogueRequest(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session, @RequestParam("empPic") MultipartFile empPic, ModelMap modelMap) {
		System.out.println("Inside insertServiceCatalogueRequest Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String details = null;
		
		try {
			out = response.getWriter();
			
	        String fullname = request.getParameter("name1");
	        String datepicker5 = request.getParameter("datepicker5");
	        String phone = request.getParameter("phone");
	        String emailid = request.getParameter("emailid");
	        String compname = request.getParameter("compname");
	        String site = request.getParameter("site");
	        String category = request.getParameter("category");
	        String subcat1 = request.getParameter("subcat1");
	        String subcat2 = request.getParameter("subcat2");
	        String requestmode = "Portal";
	        String department = request.getParameter("department");
	        String subject = request.getParameter("sub");
	        String description = request.getParameter("description");
	        String priority = request.getParameter("priority");
	        String username = request.getParameter("username");
	        String vipuser = request.getParameter("vipuser");
	        String severity=request.getParameter("severity");

	     
	        System.out.println("fullname: "+fullname);
	        System.out.println("username: "+username);
	        System.out.println("datepicker5: "+datepicker5);
	        System.out.println("phone: "+phone);
	        System.out.println("emailid: "+emailid);
	        System.out.println("compname: "+compname);
	        System.out.println("site: "+site);
	        System.out.println("category: "+category);
	        System.out.println("subcat1: "+subcat1);
	        System.out.println("subcat2: "+subcat2);
	        System.out.println("requestmode: "+requestmode);
	        System.out.println("department "+department);
	        System.out.println("subject:"+subject);
	        System.out.println("description: "+description);
	        System.out.println("priority:"+priority);
	        System.out.println("EMPIC FILE NAME: "+empPic.getOriginalFilename());
	        System.out.println("EMPIC FILE SIZE: "+empPic.getSize());
	        System.out.println("VIPUSER: "+vipuser);
			
			String final_response = userActivityService.insertServiceCatalogueRequest(fullname, datepicker5, phone, emailid, compname, site, category, subcat1, subcat2, requestmode, department, subject, description, priority, empPic, username, vipuser,severity);

			System.out.println("MastersControllerrrr reponse is = " + final_response);
						
				out.print(final_response);
						
				System.out.println("insertServiceCatalogueRequest GET SUCCESS");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;

	}
	
	@RequestMapping(value = { "/getSelfHelpList" }, method = RequestMethod.POST)
	public JSONArray getSelfHelpList(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside getSelfHelpList Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
	

		try {
			out = response.getWriter();
			
			String selfhelplist=null;
			JSONArray final_response = userActivityService.getSelfHelpList(selfhelplist);

			System.out.println("getSelfHelpList reponse is = " + final_response);
						
				out.print(final_response);
						
				System.out.println("getSelfHelpList SUCCESS");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;
		
	}
	
	@RequestMapping(value = { "/gatherSelfHelpDetails" }, method = RequestMethod.POST)
	public JSONArray gatherSelfHelpDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside gatherSelfHelpDetails Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		
	

		try {
			out = response.getWriter();
			
			String selfhelpid = request.getParameter("selfhelpid");
				
			System.out.println("selfhelpid is = " + selfhelpid);
			
			JSONArray final_response = userActivityService.gatherSelfHelpDetails(selfhelpid);

			System.out.println("gatherSelfHelpDetails reponse is = " + final_response);
						
				out.print(final_response);
						
				System.out.println("gatherSelfHelpDetails GET SUCCESS");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;
		
	}
	
	@RequestMapping(value = {"/insertServiceRequestCatalogueRequest"}, method = RequestMethod.POST)
	public String insertServiceRequestCatalogueRequest(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session, @RequestParam("empPic") MultipartFile empPic, ModelMap modelMap)
	{
		
		
		
		System.out.println("Inside insertServiceRequestCatalogueRequest Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String details = null;
		
		try {
			out = response.getWriter();
			String approvel_level_email=request.getParameter("otheremail");
	        String fullname = request.getParameter("name1");
	        String datepicker5 = request.getParameter("datepicker5");
	        String phone = request.getParameter("phone");
	        String emailid = request.getParameter("emailid");
	        String compname = request.getParameter("compname");
	        String site = request.getParameter("site");
	        String category = request.getParameter("category");
	        String subcat1 = request.getParameter("subcat1");
	        String subcat2 = request.getParameter("subcat2");
	        String requestmode = "Portal";
	        String department = request.getParameter("department");
	        String subject = request.getParameter("sub");
	        String description = request.getParameter("description");
	        String priority = request.getParameter("priority");
	        String username = request.getParameter("username");
	        String vipuser = request.getParameter("vipuser");
	        
	        
	        String approval1username = request.getParameter("username1");
	        System.out.println("WITHOUT SPLIT  " +approval1username);
	            String approval1usernamenew[]= approval1username.split("~");
	            approval1username= approval1usernamenew[0];
	            
	         
	            System.out.println("NEW USERNAME  "+ approval1username);
	          
	        String groupname = request.getParameter("groupname");
	        String designationlevel1 = request.getParameter("designationlevel1");
	        String requesttype = request.getParameter("requesttype");
	        String approve_level1_FullName =request.getParameter("otherfullname");
	        if(requesttype.equals("Standard")) {
	        	approval1username="NA";
	        	approve_level1_FullName="NA";
	        	approvel_level_email="NA";
            }
	        String severity =request.getParameter("severity");
	        String approve_level =request.getParameter("approve_level");
	        String requestcost =request.getParameter("requestcost");
	        String designationlevel2 =request.getParameter("designationlevel2");
	        String otheremailforbehalf =request.getParameter("otheremailforbehalf");
	        System.out.println("otheremailsdvfd"+otheremailforbehalf);
	        

	        String assetTag = request.getParameter("atag");
	        String assetName = request.getParameter("aname");
	        String AssetCategory = request.getParameter("acategory");
	        String AssetStatus = request.getParameter("astatus");	
	        String assetcheckboc=request.getParameter("assetCheck");
	        String asset_sub_category = request.getParameter("asset_sub_category");	
	        String asset_Ipaddress=request.getParameter("asset_Ipaddress");
	        
	        
	        
	        String AssetCheck="";
			try {
				if(assetcheckboc==null)
				{
					AssetCheck="false";
				}
				if (assetcheckboc.equals("on")) {
					AssetCheck = "true";
				}
//				System.out.println(" selected value is " + assetcheckboc);
			} catch (NullPointerException e) {
				e.printStackTrace();
			}
	     
//	        System.out.println("approve_level1_FullName: "+approve_level1_FullName);
//	        
//	        System.out.println("username1: "+approval1username);
//	        System.out.println("groupname: "+groupname);
//	        System.out.println("designationlevel1: "+designationlevel1);	
//	        System.out.println("requesttype: "+requesttype);
//	     
//	        System.out.println("fullname: "+fullname);
//	        System.out.println("username: "+username);
//	        System.out.println("datepicker5: "+datepicker5);
//	        System.out.println("phone: "+phone);
//	        System.out.println("emailid: "+emailid);
//	        System.out.println("compname: "+compname);
//	        System.out.println("site: "+site);
//	        System.out.println("category: "+category);
//	        System.out.println("subcat1: "+subcat1);
//	        System.out.println("subcat2: "+subcat2);
//	        System.out.println("requestmode: "+requestmode);
//	        System.out.println("department "+department);
//	        System.out.println("subject:"+subject);
//	        System.out.println("description: "+description);
//	        System.out.println("priority:"+priority);
//	        System.out.println("EMPIC FILE NAME: "+empPic.getOriginalFilename());
//	        System.out.println("EMPIC FILE SIZE: "+empPic.getSize());
//	        System.out.println("VIPUSER: "+vipuser);
	      
	      
		String final_response = userActivityService.insertServiceRequestCatalogueRequest(fullname, datepicker5, phone, emailid, compname, site, category, subcat1, subcat2, requestmode, department, subject, description, priority, empPic, username, vipuser,approval1username,groupname,designationlevel1,requesttype,severity,approve_level,requestcost,designationlevel2,approve_level1_FullName,approvel_level_email,otheremailforbehalf,assetTag,assetName,AssetCategory,AssetStatus,AssetCheck,asset_sub_category,asset_Ipaddress);

			System.out.println("MastersControllerrrr reponse is = " + final_response);
						
			out.print(final_response);
						
				System.out.println("insertServiceCatalogueRequest GET SUCCESS");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;
	}
	
	@RequestMapping(value = { "/getServiceRequest" }, method = RequestMethod.POST)
    public JSONArray getServiceRequest(ModelMap model, HttpServletRequest request, HttpServletResponse response,
                    HttpSession session) {
            System.out.println("Inside getUserTicketList Controller@@@@@@@@@@@@ ");
            PrintWriter out = null;
            String sname = null;
    

            try {
                    out = response.getWriter();
                    
                    String userlist=null;
                    JSONArray final_response = userActivityService.getServiceRequest(userlist);

                    System.out.println("getUserTicketList reponse is = " + final_response);
                                            
                            out.print(final_response);
                                            
                            System.out.println("getUserTicketList SUCCESS");
                    
            } catch (Exception e) {
                    e.printStackTrace();
            }

            finally {
                    out.close();
            }
//            return "Dashboard";
            return null;
            
    }
	
	 @RequestMapping(value = { "/gatherUserServiceRequest" }, method = RequestMethod.POST)
	    public JSONArray gatherUserServiceRequest(ModelMap model, HttpServletRequest request, HttpServletResponse response,
	                    HttpSession session) {
	            System.out.println("Inside gatherUserServiceRequest Controller@@@@@@@@@@@@ ");
	            PrintWriter out = null;
	            
	    

	            try {
	                    out = response.getWriter();
	                    
	                    String ticketid = request. getParameter("ticketid");
	                            
	                    System.out.println("ticketid is = " + ticketid);
	                    
	                    JSONArray final_response = userActivityService.gatherUserServiceRequest(ticketid);

	                    System.out.println("UserActivityControllerrrr reponse is = " + final_response);
	                                            
	                            out.print(final_response);
	                                            
	                            System.out.println("gatherUserTicketDetails GET SUCCESS");
	                    
	            } catch (Exception e) {
	                    e.printStackTrace();
	            }

	            finally {
	                    out.close();
	            }
//	            return "Dashboard";
	            return null;
	            
	    }
	
	 
		@RequestMapping(value = { "/getServiceActivityLog" }, method = RequestMethod.POST)
		public JSONArray getServiceActivityLog(ModelMap model, HttpServletRequest request, HttpServletResponse response,
				HttpSession session) {
			System.out.println("Inside getServiceActivityLog Controller@@@@@@@@@@@@ ");
			PrintWriter out = null;
			
		

			try {
				out = response.getWriter();
				
				String ticketid = request. getParameter("ticketid");
					
				System.out.println("ticketid is = " + ticketid);
				
				JSONArray final_response = userActivityService.getServiceActivityLog(ticketid);

				System.out.println("getServiceActivityLog reponse is = " + final_response);
							
					out.print(final_response);
							
					System.out.println("getServiceActivityLog GET SUCCESS");
				
			} catch (Exception e) {
				e.printStackTrace();
			}

			finally {
				out.close();
			}
			return null;
			
		}
		
		
		@RequestMapping(value = { "/getUserRequestID" }, method = RequestMethod.POST)
		public JSONArray getUserRequestID(ModelMap model, HttpServletRequest request, HttpServletResponse response,
				HttpSession session) {
			System.out.println("Inside getUserRequestID Controller@@@@@@@@@@@@ ");
			PrintWriter out = null;
			String details = null;
		

			try {
				out = response.getWriter();
				
				JSONArray final_response = userActivityService.getUserRequestID(details);

				System.out.println("UserActivityControllerrrr reponse is = " + final_response);
							
					out.print(final_response);
							
					System.out.println("getUserTicketID GET SUCCESS");
				
			} catch (Exception e) {
				e.printStackTrace();
			}

			finally {
				out.close();
			}
//			return "Dashboard";
			return null;

		}
		
		@RequestMapping(value = { "/getUserServiceTracking" }, method = RequestMethod.POST)
		public JSONArray getUserServiceTracking(ModelMap model, HttpServletRequest request, HttpServletResponse response,
				HttpSession session) {
			System.out.println("Inside getUserServiceTracking Controller@@@@@@@@@@@@ ");
			PrintWriter out = null;
			
		

			try {
				out = response.getWriter();
				
				String ticketid = request. getParameter("ticketid");
					
				System.out.println("ticketid is = " + ticketid);
				
				JSONArray final_response = userActivityService.getUserServiceTracking(ticketid);

				System.out.println("userActivityControllerrrr reponse is = " + final_response);
							
					out.print(final_response);
							
					System.out.println("getUserTicketTracking GET SUCCESS");
				
			} catch (Exception e) {
				e.printStackTrace();
			}

			finally {
				out.close();
			}
//			return "Dashboard";
			return null;
	}
		
		
		@RequestMapping(value = { "/getResolvedRequest" }, method = RequestMethod.POST)
		public JSONArray getResolvedRequest(ModelMap model, HttpServletRequest request, HttpServletResponse response,
				HttpSession session) {
			System.out.println("Inside getResolvedRequest Controller@@@@@@@@@@@@ ");
			PrintWriter out = null;
			String sname = null;

			try {
				out = response.getWriter();

				String userlist = null;
				JSONArray final_response = userActivityService.getResolvedRequest(userlist);

				System.out.println("getResolvedUserTicketList reponse is = " + final_response);

				out.print(final_response);

				System.out.println("getResolvedUserTicketList SUCCESS");

			} catch (Exception e) {
				e.printStackTrace();
			}

			finally {
				out.close();
			}
//			return "Dashboard";
			return null;

		}
		@RequestMapping(value = { "/gatherResolvedRequestsDetails" }, method = RequestMethod.POST)
		public JSONArray gatherResolvedRequestsDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
				HttpSession session) {
			System.out.println("Inside gatherResolvedRequestsDetails Controller@@@@@@@@@@@@ ");
			PrintWriter out = null;
			
		

			try {
				out = response.getWriter();
				
				String ticketid = request. getParameter("ticketid");
					
				System.out.println("ticketid is = " + ticketid);
				
				JSONArray final_response = userActivityService.gatherResolvedRequestsDetails(ticketid);

				System.out.println("UserActivityControllerrrr reponse is = " + final_response);
							
					out.print(final_response);
							
					System.out.println("gatherUserTicketDetails GET SUCCESS");
				
			} catch (Exception e) {
				e.printStackTrace();
			}

			finally {
				out.close();
			}
			return null;
		}

		@RequestMapping(value = { "/closeUserResolvedRequest" }, method = RequestMethod.POST)
		public String closeUserResolvedRequest(ModelMap model, HttpServletRequest request, HttpServletResponse response,
				HttpSession session) {
			System.out.println("Inside closeUserResolvedRequest Controller@@@@@@@@@@@@ ");
			PrintWriter out = null;
			String details = null;

			try {
				out = response.getWriter();//closeUserResolvedTicket

				String ticketid = request.getParameter("ticketid");
				String closereason = request.getParameter("closereason");

				System.out.println("ticketid: " + ticketid);
				System.out.println("closereason: " + closereason);

				String final_response1 = userActivityService.closeUserResolvedRequest(ticketid, closereason);

				System.out.println("UserActivityControllerrrr reponse is = " + final_response1);
				out.print(final_response1);
				System.out.println("closeUserResolvedTicket GET SUCCESS");

			} catch (Exception e) {
				e.printStackTrace();
			}

			finally {
				out.close();
			}

			return null;

		}
		
		@RequestMapping(value = { "/getUserRaisedRequest" }, method = RequestMethod.POST)
		public JSONArray getUserRaisedTicket(ModelMap model, HttpServletRequest request, HttpServletResponse response,
				HttpSession session) {
			System.out.println("Inside getUserRaisedRequest Controller@@@@@@@@@@@@ ");
			PrintWriter out = null;
			String sname = null;

			try {
				out = response.getWriter();

				String ticketlist = null;
				JSONArray final_response = userActivityService.getUserRaisedRequest(ticketlist);

				System.out.println("getAllVIPRaisedTicketList reponse is = " + final_response);

				out.print(final_response);

				System.out.println("getAllVIPRaisedTicketList SUCCESS");

			} catch (Exception e) {
				e.printStackTrace();
			}

			finally {
				out.close();
			}
//			return "Dashboard";
			return null;

		}
		
		
		@RequestMapping(value = { "/Getotherinformaion" }, method = RequestMethod.POST)
		public JSONArray getSelectedServiceCatalogueData(ModelMap model, HttpServletRequest request, HttpServletResponse response,
				HttpSession session) {
			System.out.println("Inside Getotherinformaion Controller@@@@@@@@@@@@ ");
			PrintWriter out = null;
			try {
				out = response.getWriter();
				
				String othername = request.getParameter("othername");
				String othercompany = request.getParameter("othercompany");
				
				System.out.println();
				JSONArray final_response = userActivityService.Getotherinformaion(othercompany,othername);

				System.out.println("Getotherinformaion reponse is = " + final_response);
							
					out.print(final_response);
							
					System.out.println("Getotherinformaion GET SUCCESS");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				out.close();
			}
			return null;
		}
		@RequestMapping(value = { "/getServiceRequestDashboardData" }, method = RequestMethod.POST)
		public JSONArray getServiceRequestDashboardData(ModelMap model, HttpServletRequest request, HttpServletResponse response,
				HttpSession session) {
			System.out.println("Inside getTPDashboardData Controller@@@@@@@@@@@@ ");
			PrintWriter out = null;
			
			try {
				out = response.getWriter();
				String loginuser=(String)session.getAttribute("username");
				String loginUserCompany = session.getAttribute("companyname").toString();
				String chartdata = null;
				JSONArray final_response = userActivityService.getServiceRequestDashboardData(loginuser,loginUserCompany);

				System.out.println("getTPDashboardData reponse is = " + final_response);

				out.print(final_response);

				System.out.println("getTPDashboardData SUCCESS");

			} catch (Exception e) {
				e.printStackTrace();
			}

			finally {
				out.close();
			}
//			return "Dashboard";
			return null;

		}
		@RequestMapping(value = { "/getServiceRequestListing" }, method = RequestMethod.POST)
		public JSONArray getServiceRequestListing(ModelMap model, HttpServletRequest request, HttpServletResponse response,
				HttpSession session) {
			System.out.println("Inside getTPDashboardData Controller@@@@@@@@@@@@ ");
			PrintWriter out = null;
			
			try {
				out = response.getWriter();
			
				String chartdata = request.getParameter("status");
				JSONArray final_response = userActivityService.getServiceRequestListing(chartdata);

				System.out.println("getTPDashboardData reponse is = " + final_response);

				out.print(final_response);

				System.out.println("getTPDashboardData SUCCESS");

			} catch (Exception e) {
				e.printStackTrace();
			}

			finally {
				out.close();
			}
//			return "Dashboard";
			return null;

		}
		@RequestMapping(value = { "/getDashboardListingForTickets" }, method = RequestMethod.POST)
		public JSONArray getDashboardListingForTickets(ModelMap model, HttpServletRequest request, HttpServletResponse response,
				HttpSession session) {
			System.out.println("Inside getDashboardListingForTickets Controller@@@@@@@@@@@@ ");
			PrintWriter out = null;
			
			try {
				out = response.getWriter();
			
				String chartdata = request.getParameter("status");
				JSONArray final_response = userActivityService.getDashboardListingForTickets(chartdata);

				System.out.println("getDashboardListingForTickets reponse is = " + final_response);

				out.print(final_response);

				System.out.println("getTPDashboardData SUCCESS");

			} catch (Exception e) {
				e.printStackTrace();
			}

			finally {
				out.close();
			}
//			return "Dashboard";
			return null;

		}
		
		@RequestMapping(value = { "/getAlldataAccordingsubject" }, method = RequestMethod.POST)
		public String getAlldataAccordingsubject(ModelMap model, HttpServletRequest request, HttpServletResponse response,
				HttpSession session) {
			System.out.println("Inside getAlldataAccordingsubject Controller@@@@@@@@@@@@ ");
			PrintWriter out = null;
				try {
				out = response.getWriter();
				String subject=request.getParameter("subject");
				String company=request.getParameter("company");
				JSONArray final_response = userActivityService.getAlldataAccordingsubject(subject,company);

				System.out.println("MastersControllerrrr reponse is = " + final_response);
							
					out.print(final_response);
							
					System.out.println("getAlldataAccordingsubject GET SUCCESS");
				
			} catch (Exception e) {
				e.printStackTrace();
			}

			finally {
				out.close();
			}

			return null;

		}
		
		
		@RequestMapping(value = { "/getallusernameforraiseonbehalf" }, method = RequestMethod.POST)
		public String getallusernameforraiseonbehalf(ModelMap model, HttpServletRequest request, HttpServletResponse response,
				HttpSession session) {
			System.out.println("Inside getallusernameforraiseonbehalf Controller@@@@@@@@@@@@ ");
			PrintWriter out = null;
				try {
				out = response.getWriter();
				String company=request.getParameter("company");
				JSONArray final_response = userActivityService.getallusernameforraiseonbehalf(company);

				System.out.println("MastersControllerrrr reponse is = ghgthggfh" + final_response);
							
					out.print(final_response);
							
					System.out.println("getallusernameforraiseonbehalf GET SUCCESS");
				
					
					
					
			} catch (Exception e) {
				e.printStackTrace();
			}

			finally {
				out.close();
			}

			return null;

		}
		
		@RequestMapping(value = { "/getApprovaalSaleMngData" }, method = RequestMethod.POST)
		public void getApprovaalSaleMngData(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
			System.out.println("Inside getApprovaalSaleMngData method");
			
			String crno=request.getParameter("crno");
			 String tid = request.getParameter("tid");
//			int crno1=Integer.parseInt(crno);
			PrintWriter out = null;
			try {
				
				HttpSession htt = request.getSession(true);
	            String uname = (String) htt.getAttribute("username");
	            System.out.println("usernamemeeem login==" + uname);
	            System.out.println("usernamemeeem login==" + crno);
	            System.out.println("usernamemeeem login==" + tid);

				out = response.getWriter();
				JSONArray array = (JSONArray) userActivityService.getApprovaalSaleMngData(crno,uname,tid);
				System.out.println("List value: "+array);
				out.print(array);
			}
			catch(Exception e) {
				System.out.println("Exception in getAttachmentCSData method: "+e);
			}
			
		}
		

		@RequestMapping(value = { "/inserRaiseOnBehalfTicket" }, method = RequestMethod.POST)
		public String inserRaiseOnBehalfTicket(ModelMap model, HttpServletRequest request, HttpServletResponse response,
				HttpSession session, @RequestParam("empPic") MultipartFile empPic, ModelMap modelMap) {
			System.out.println("Inside inserRaiseOnBehalfTicket Controller@@@@@@@@@@@@ ");
			PrintWriter out = null;
			String details = null;
			
			try {
				out = response.getWriter();
				
		        String fullname = request.getParameter("name1");
		        String datepicker5 = request.getParameter("datepicker5");
		        String phone = request.getParameter("otherphone");
		        String emailid = request.getParameter("otheremail");
		        String compname = request.getParameter("othercompname");
		        String site = request.getParameter("othersite");
		        String category = request.getParameter("category");
		        String subcat1 = request.getParameter("subcat1");
		        String subcat2 = request.getParameter("subcat2");
		        String requestmode = request.getParameter("requestmode");
		        String department = request.getParameter("otherdepart");
		        String subject = request.getParameter("sub");
		        String description = request.getParameter("description");
		        String priority = request.getParameter("priority");
		        String severity = request.getParameter("severity");
		        String usernameofraiseby = request.getParameter("username");
		        String vipuser = request.getParameter("vipuserother");
		        String t_request = request.getParameter("otherusername");
		        String assetTag = request.getParameter("atag");
		        String assetName = request.getParameter("aname");
		        String AssetCategory = request.getParameter("acategory");
		        String AssetStatus = request.getParameter("astatus");	
		        String assetcheckboc=request.getParameter("assetCheck");
				
		        String asset_sub_category = request.getParameter("asset_sub_category");	
		        String asset_Ipaddress=request.getParameter("asset_Ipaddress");
//		        System.out.println("dgdggfdfg gff dhghgyhgdh"+assetcheckboc);
				String AssetCheck="";
				try {
					if(assetcheckboc==null)
					{
						AssetCheck="false";
					}
					if (assetcheckboc.equals("on")) {
						AssetCheck = "true";
					}
//					System.out.println(" selected value is " + assetcheckboc);
				} catch (NullPointerException e) {
					e.printStackTrace();
				}
		        

		     
//		        System.out.println("fullname: "+fullname);
//		        System.out.println("username: "+usernameofraiseby);
//		        System.out.println("datepicker5: "+datepicker5);
//		        System.out.println("phone: "+phone);
//		        System.out.println("emailid: "+emailid);
//		        System.out.println("compname: "+compname);
//		        System.out.println("site: "+site);
//		        System.out.println("category: "+category);
//		        System.out.println("subcat1: "+subcat1);
//		        System.out.println("subcat2: "+subcat2);
//		        System.out.println("requestmode: "+requestmode);
//		        System.out.println("department "+department);
//		        System.out.println("subject:"+subject);
//		        System.out.println("description: "+description);
//		        System.out.println("priority:"+priority);
//		        System.out.println("severity:"+severity);
//		        System.out.println("EMPIC FILE NAME: "+empPic.getOriginalFilename());
//		        System.out.println("EMPIC FILE SIZE: "+empPic.getSize());
		        System.out.println("t_request: fgfgdgdfgdg"+t_request);
				String otherfullname=request.getParameter("otherfullname");
				String final_response = userActivityService.inserRaiseOnBehalfTicket(fullname, datepicker5, phone, emailid, compname, site, category, subcat1, subcat2, requestmode, department, subject, description, priority, severity, empPic, usernameofraiseby, vipuser,t_request,otherfullname,assetTag,assetName,AssetCategory,AssetStatus,AssetCheck,asset_sub_category,asset_Ipaddress);

				System.out.println("MastersControllerrrr reponse is = " + final_response);
							
					out.print(final_response);
								
					System.out.println("inserRaiseOnBehalfTicket GET SUCCESS");
				
			} catch (Exception e) {
				e.printStackTrace();
			}

			finally {
				out.close();
			}

			return null;

		}
		
		
		@RequestMapping(value = { "/insertFormA" }, method = RequestMethod.POST)
		public String insertFormA(ModelMap model, HttpServletRequest request, HttpServletResponse response,
				HttpSession session, ModelMap modelMap) {
			System.out.println("Inside insertFormA Controller@@@@@@@@@@@@ ");
			PrintWriter out = null;
			String details = null;
			
			try {
				out = response.getWriter();
				
		        String dateforma = request.getParameter("dateforma");
		        String salemangname = request.getParameter("salemangname");
		        
		        String distributorpartyname = request.getParameter("distributorpartyname");
		        String distributorprojectname = request.getParameter("distributorprojectname");
		        String distributortechpersonname = request.getParameter("distributortechpersonname");
		        String distributorprsndesignation = request.getParameter("distributorprsndesignation");
		        String distributorcontactnumber = request.getParameter("distributorcontactnumber");
		        String distributoremailid = request.getParameter("distributoremailid");
		        
		        String partnerpartyname = request.getParameter("partnerpartyname");
		        String partnerprojectname = request.getParameter("partnerprojectname");
		        String partnertechpersonname = request.getParameter("partnertechpersonname");
		        String partnerprsndesignation = request.getParameter("partnerprsndesignation");
		        String partnercontactnumber = request.getParameter("partnercontactnumber");
		        String partneremailid = request.getParameter("partneremailid");
		        
		        String customerpartyname = request.getParameter("customerpartyname");
		        String customerprojectname = request.getParameter("customerprojectname");
		        String customertechpersonname = request.getParameter("customertechpersonname");
		        String customerprsndesignation = request.getParameter("customerprsndesignation");
		        String customercontactnumber = request.getParameter("customercontactnumber");
		        String customeremailid = request.getParameter("customeremailid");
		        
		        String implementorpartyname = request.getParameter("implementorpartyname");
		        String implementorprojectname = request.getParameter("implementorprojectname");	
		        String implementortechpersonname=request.getParameter("implementortechpersonname");
				 String implementorprsndesignation = request.getParameter("implementorprsndesignation");	
		        String implementorcontactnumber=request.getParameter("implementorcontactnumber");
		        String implementoremailid=request.getParameter("implementoremailid");
		     

		        

				String final_response = userActivityService.insertFormA(dateforma, salemangname, distributorpartyname, distributorprojectname, distributortechpersonname,
						distributorprsndesignation, distributorcontactnumber, distributoremailid, partnerpartyname, partnerprojectname, partnertechpersonname, partnerprsndesignation, partnercontactnumber, partneremailid, customerpartyname, customerprojectname, customertechpersonname,customerprsndesignation,customercontactnumber,customeremailid,
						implementorpartyname,implementorprojectname,implementortechpersonname,implementorprsndesignation,implementorcontactnumber,implementoremailid);

				System.out.println("MastersControllerrrr reponse is = " + final_response);
							
					out.print(final_response);
								
					System.out.println("insertFormA GET SUCCESS");
				
			} catch (Exception e) {
				e.printStackTrace();
			}

			finally {
				out.close();
			}

			return null;

		}
		
		
		@RequestMapping(value = { "/insertForm2" }, method = RequestMethod.POST)
		public String insertForm2(ModelMap model, HttpServletRequest request, HttpServletResponse response,
				HttpSession session, ModelMap modelMap) {
			System.out.println("Inside insertForm2 Controller@@@@@@@@@@@@ ");
			PrintWriter out = null;
			String details = null;
			
			try {
				out = response.getWriter();
				
		        String form2date = request.getParameter("form2date");
		        String form2customername = request.getParameter("form2customername");
		        
		        String RPFTIMELINES = request.getParameter("RPFTIMELINES");
		        String potimeline = request.getParameter("potimeline");
		        String firstinvoicegeneratedate = request.getParameter("radiosss");
		        String radiosss = request.getParameter("distributorprsndesignation");
		        String projstartdate = request.getParameter("projstartdate");
		        String projenddate = request.getParameter("projenddate");
		        
		        String pymentterms = request.getParameter("pymentterms");
		        String projecthead = request.getParameter("projecthead");
		       

		        

				String final_response = userActivityService.insertForm2(form2date, form2customername, RPFTIMELINES, potimeline, firstinvoicegeneratedate,
						radiosss, projstartdate, projenddate, pymentterms, projecthead);

				System.out.println("MastersControllerrrr reponse is = " + final_response);
							
				out.print(final_response);
								
					System.out.println("insertFormA GET SUCCESS");
				
			} catch (Exception e) {
				e.printStackTrace();
			}

			finally {
				out.close();
			}

			return null;

		}
		
		@RequestMapping(value = { "/insertPurchaseOrder" }, method = RequestMethod.POST)
		public String insertPurchaseOrder(@RequestParam("pouploadfile") MultipartFile[] pouploadfile1,@RequestParam("advinvoicefile") MultipartFile[] advinvoicefile1,
				@RequestParam("massPOfile") MultipartFile[] massPOfile1,@RequestParam("productFeaturedFileList") MultipartFile[] productFeaturedFileList,@RequestParam("invoicefile") MultipartFile[] invoiceuploadfile,@RequestParam("attendanceFile") MultipartFile[] attendanceuploadFile,@RequestParam("calculationfile") MultipartFile[] calculationuploadfile,ModelMap model, HttpServletRequest request, HttpServletResponse response,
				HttpSession session, ModelMap modelMap) {
			System.out.println("Inside insertForm2 Controller@@@@@@@@@@@@ ");
			PrintWriter out = null;
			String details = null;
			
			try {
				out = response.getWriter();
				
				String loginuser=(String)session.getAttribute("username");
				String loginUserCompany = session.getAttribute("companyname").toString();
				
		       // String pouploadfile = request.getParameter("pouploadfile");
				
				String potype = request.getParameter("potype");
				String proposalType = request.getParameter("proposalType");
			    String proposalids = request.getParameter("proposalids");
			    String vpuploadfileProposal = request.getParameter("vpuploadfileProposal");
			        
		       
			    String ponumber = request.getParameter("ponumber");
			    String customerEmail = request.getParameter("customerEmail");
			    String podate = request.getParameter("podate");
			    String customername = request.getParameter("customername");
			    String productsuit = request.getParameter("selectedSideBarValuesFinalprodSuit");		        
		    	String securitytool = request.getParameter("selectedSideBarValuesFinalSECTool");
		        String paymentterms = request.getParameter("paymentterms");
		        String prodliscense = request.getParameter("prodliscense");
		        String prodamount = request.getParameter("prodamount");
		     
		        String advaninvoice = request.getParameter("advaninvoice");
		        String advinvoicefile = request.getParameter("advinvoicefile");
		        String proddescrip = request.getParameter("proddescrip");
		        
		      
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
		        
		        String sInote = request.getParameter("SInote");
		        String firstApprover = request.getParameter("firstApprover");
		        String SecondApprovername = request.getParameter("SecondApprovername");
	
		
		       
		        System.out.println(" productsuit data :"+productsuit);
		        System.out.println(" securitytool data :"+securitytool);
		        System.out.println(" proposalType data :"+proposalType+" proposalids data :"+
		        proposalids+" vpuploadfileProposal data :"+vpuploadfileProposal);

		        
		        String fixedyear = request.getParameter("fixedyear");
		        String subscriptionyear = request.getParameter("Subscriptionyear");
		        String perpetualyear = request.getParameter("Perpetualyear");
		        String subscriptionANDperpetualYear = request.getParameter("subscriptionANDperpetualYear");
		        
		        
		        //13/09
		        String customerName = request.getParameter("customerName");
		        //
		        

				String final_response = userActivityService.insertPurchaseOrder(pouploadfile1, proddescrip, customername, paymentterms, prodliscense,
						prodamount, warrantystart, warrantyend, advaninvoice, advinvoicefile1,loginuser,loginUserCompany, proposalType,proposalids,vpuploadfileProposal,
			 potype, ponumber, podate, amcstartdate, amcenddate,  productsuit,
			 securitytool,warrantyMonth,warrantyYear,AMCMonth,AMCYear,sInote,tennurestartdate,tennureenddate,tennureMonth,tennureYear,firstApprover,SecondApprovername,fixedyear,subscriptionyear,perpetualyear,massPOfile1,productFeaturedFileList,invoiceuploadfile,attendanceuploadFile,calculationuploadfile, customerEmail, subscriptionANDperpetualYear, customerName);

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
		

		@RequestMapping(value = {"/insertServiceRequestCatalogueRequestOnBehalf"}, method = RequestMethod.POST)
		public String insertServiceRequestCatalogueRequestOnBehalf(ModelMap model, HttpServletRequest request, HttpServletResponse response,
				HttpSession session, @RequestParam("empPic") MultipartFile empPic, ModelMap modelMap)
		{
			
			
			
			System.out.println("Inside insertServiceRequestCatalogueRequestOnBehalf Controller@@@@@@@@@@@@ ");
			PrintWriter out = null;
			String details = null;
			
			try {
				out = response.getWriter();
				
		        String fullname = request.getParameter("otherfullnameforbehalf");
		        String datepicker5 = request.getParameter("datepicker5");
		        String phone = request.getParameter("otherphoneforbehalf");
		        String emailid = request.getParameter("otheremailforbehalf");
		        String compname = request.getParameter("othercompnameforbehalf");
		        String site = request.getParameter("othersiteforbehalf");
		        String category = request.getParameter("category");
		        String subcat1 = request.getParameter("subcat1");
		        String subcat2 = request.getParameter("subcat2");
		        String requestmode = "Portal";
		        String department = request.getParameter("otherdepartforbehalf");
		        String subject = request.getParameter("sub");
		        String description = request.getParameter("description");
		        String priority = request.getParameter("priority");
		        String username = request.getParameter("username");
		        String vipuser = request.getParameter("vipuserotherforbehalf");
		        String t_requester = request.getParameter("otherusernameforbehalf");
		        String app_level1_fullname = request.getParameter("otherfullname");
		        
		        String approval1username = request.getParameter("username1");
		        System.out.println("WITHOUT SPLIT  " +approval1username);
		            String approval1usernamenew[]= approval1username.split("~");
		            approval1username= approval1usernamenew[0];
		            
		            System.out.println("NEW USERNAME  "+ approval1username);
		          
		        String groupname = request.getParameter("groupname");
		        String designationlevel1 = request.getParameter("designationlevel1");
		        String requesttype = request.getParameter("requesttype");
		        String severity =request.getParameter("severity");
		        String approve_level =request.getParameter("approve_level");
		        String requestcost =request.getParameter("requestcost");
		        String designationlevel2 =request.getParameter("designationlevel2");
		        String otheremailforbehalf =request.getParameter("otheremailforbehalf");

		        String assetTag = request.getParameter("atag");
		        String assetName = request.getParameter("aname");
		        String AssetCategory = request.getParameter("acategory");
		        String AssetStatus = request.getParameter("astatus");	
		        String assetcheckboc=request.getParameter("assetCheck");
		        String asset_sub_category = request.getParameter("asset_sub_category");	
		        String asset_Ipaddress=request.getParameter("asset_Ipaddress");
//		        System.out.println("dgdggfdfg gff dhghgyhgdh"+assetcheckboc);
				String AssetCheck="";
				try {
					if(assetcheckboc==null)
					{
						AssetCheck="false";
					}
					if (assetcheckboc.equals("on")) {
						AssetCheck = "true";
					}
//					System.out.println(" selected value is " + assetcheckboc);
				} catch (NullPointerException e) {
					e.printStackTrace();
				}


		        
		        System.out.println("username1: "+approval1username);
		        System.out.println("groupname: "+groupname);
		        System.out.println("designationlevel1: "+designationlevel1);
		        System.out.println("requesttype: "+requesttype);
		     
		        System.out.println("fullname: "+fullname);
		        System.out.println("username: "+username);
		        System.out.println("datepicker5: "+datepicker5);
		        System.out.println("phone: "+phone);
		        System.out.println("emailid: "+emailid);
		        System.out.println("compname: "+compname);
		        System.out.println("site: "+site);
		        System.out.println("category: "+category);
		        System.out.println("subcat1: "+subcat1);
		        System.out.println("subcat2: "+subcat2);
		        System.out.println("requestmode: "+requestmode);
		        System.out.println("department "+department);
		        System.out.println("subject:"+subject);
		        System.out.println("description: "+description);
		        System.out.println("priority:"+priority);
		        System.out.println("EMPIC FILE NAME: "+empPic.getOriginalFilename());
		        System.out.println("EMPIC FILE SIZE: "+empPic.getSize());
		        System.out.println("VIPUSER: "+vipuser);
				
			String final_response = userActivityService.insertServiceRequestCatalogueRequestOnBehalf(fullname, datepicker5, phone, emailid, compname, site, category, subcat1, subcat2, requestmode, department, subject, description, priority, empPic, username, vipuser,approval1username,groupname,designationlevel1,requesttype,severity,approve_level,requestcost,designationlevel2,t_requester,app_level1_fullname,otheremailforbehalf,assetTag,assetName,AssetCategory,AssetStatus,AssetCheck,asset_sub_category,asset_Ipaddress);

				System.out.println("MastersControllerrrr reponse is = " + final_response);
							
				out.print(final_response);
							
					System.out.println("insertServiceRequestCatalogueRequestOnBehalf GET SUCCESS");
				
			} catch (Exception e) {
				e.printStackTrace();
			}

			finally {
				out.close();
			}

			return null;
		}
		@RequestMapping(value = { "/getUserDetailsForUpdate" }, method = RequestMethod.POST)
		public String getUserDetailsForUpdate(ModelMap model, HttpServletRequest request, HttpServletResponse response,
				HttpSession session) {
			System.out.println("Inside getUserDetailsForUpdate Controller@@@@@@@@@@@@ ");
			PrintWriter out = null;
			String details = null;
			 String LoginUser = null;
			try {
//	            HttpSession session = request.getSession(true);
	            LoginUser = session.getAttribute("username").toString();
	            System.out.println("username****" + LoginUser);
	        } catch (Exception e) {
	            e.printStackTrace();
	            System.out.println("Exceptioon e***" + e);
	        }

			try {
				out = response.getWriter();
				
				JSONArray final_response = userActivityService.getUserDetailsForUpdate(LoginUser);

				System.out.println("MastersControllerrrr reponse is = " + final_response);
							
					out.print(final_response);
							
					System.out.println("getAllUserDetails GET SUCCESS");
				
			} catch (Exception e) {
				e.printStackTrace();
			}

			finally {
				out.close();
			}

			return null;

		}
		
		
	

@RequestMapping(value = { "/updateLoginUserProfile" }, method = RequestMethod.POST)
public String updateLoginUserProfile(ModelMap model, HttpServletRequest request, HttpServletResponse response,
		HttpSession session, ModelMap modelMap) {
	System.out.println("Inside inserRaiseOnBehalfTicket Controller@@@@@@@@@@@@ ");
	PrintWriter out = null;
	String details = null;
	
	try {
		out = response.getWriter();
		
        String cno = request.getParameter("cno");
        String emailid = request.getParameter("mail");
        String cname = request.getParameter("cname");
        String site = request.getParameter("BranchName");
       // String department = request.getParameter("otherdepart");
        String location = request.getParameter("location");
        String dname = request.getParameter("dname");
        String subDepartment = request.getParameter("subDepartment");
        String designation = request.getParameter("designation");
        String username = request.getParameter("username");
        
        //System.out.println("fullname: "+fullname);
        System.out.println("username: "+username);
       // System.out.println("datepicker5: "+datepicker5);
        System.out.println("phone: "+cno);
        System.out.println("emailid: "+emailid);
        System.out.println("compname: "+cname);
        System.out.println("site: "+site+" locatoino"+location+"  dname"+dname+"subDe"+subDepartment);

       
		String final_response = userActivityService.updateLoginUserProfile(username,cname,site,location,dname,subDepartment,emailid,cno,designation);

		System.out.println("MastersControllerrrr reponse is = " + final_response);
					
			out.print(final_response);
					
			System.out.println("inserRaiseOnBehalfTicket GET SUCCESS");
		
	} catch (Exception e) {
		e.printStackTrace();
	}

	finally {
		out.close();
	}

	return null;

}
@RequestMapping(value = { "/ReopenResolvedServiceRequest" }, method = RequestMethod.POST)
public JSONArray ReopenResolvedServiceRequest(ModelMap model, HttpServletRequest request, HttpServletResponse response,
		HttpSession session, @RequestParam("reopenPic") MultipartFile reopenPic, ModelMap modelMap) {
	System.out.println("Inside UserReopenResolvedTicket Controller@@@@@@@@@@@@ ");
	PrintWriter out = null;
	


	try {
		out = response.getWriter();
				
		String RequesterName = request.getParameter("nameupdateUDreopen");
		String RequesterCompany = request.getParameter("companyupdateUDreopen");
		String RequesterBranch = request.getParameter("siteupdateUDreopen");
		String RequesterDept = request.getParameter("deptupdateUDreopen");
		String RequesterSubDept = request.getParameter("subdeptupdateUDreopen");
		String RequesterLocation = request.getParameter("locationupdateUDreopen");
		String RequesterPhone = request.getParameter("phoneupdateUDreopen");
		String RequesterEmail = request.getParameter("emailupdateUDreopen");
        
		String TicketID = request.getParameter("ticketidupdateTDreopen");
		String TicketStatus = request.getParameter("statusupdateTDreopen");
		String TicketRaiseDate = request.getParameter("raisedateupdateTDreopen");
		String Category = request.getParameter("categoryupdateTDreopen");
		String SubCat1 = request.getParameter("subcat1updateTDreopen");
		String SubCat2 = request.getParameter("subcat2updateTDreopen");
		String Subject = request.getParameter("subjectupdateTDreopen");
		String Priority = request.getParameter("priorityupdateTDreopen");
		String Severity = request.getParameter("severityupdateTDreopen");
		String T_Description = request.getParameter("descriptionupdateTDreopen");
		String T_RequestMode = request.getParameter("RequestModeupdateTDreopen");
		String ReopenReason = request.getParameter("reopenreason");
		
		
		System.out.println("RequesterName is = " + RequesterName);
		System.out.println("RequesterCompany is = " + RequesterCompany);
		System.out.println("RequesterBranch is = " + RequesterBranch);
		System.out.println("RequesterDept is = " + RequesterDept);
		System.out.println("RequesterSubDept is = " + RequesterSubDept);
		System.out.println("RequesterLocation is = " + RequesterLocation);
		System.out.println("RequesterPhone is = " + RequesterPhone);
		System.out.println("RequesterEmail is = " + RequesterEmail);
		
		System.out.println("TicketID is = " + TicketID);
		System.out.println("TicketStatus is = " + TicketStatus);
		System.out.println("TicketRaiseDate is = " + TicketRaiseDate);
		System.out.println("Category is = " + Category);
		System.out.println("SubCat1 is = " + SubCat1);
		System.out.println("SubCat2 is = " + SubCat2);
		System.out.println("Subject is = " + Subject);
		
		System.out.println("Priority is = " + Priority);
		System.out.println("Severity is = " + Severity);
		System.out.println("T_Description is = " + T_Description);
		System.out.println("T_RequestMode is = " + T_RequestMode);
		System.out.println("ReopenReason is = " + ReopenReason);
		
		System.out.println("EMPIC FILE NAME: "+reopenPic.getOriginalFilename());
        System.out.println("EMPIC FILE SIZE: "+reopenPic.getSize());
		
		String final_response = userActivityService.ReopenResolvedServiceRequest(RequesterName, RequesterCompany, RequesterBranch, RequesterDept, RequesterSubDept, RequesterLocation, RequesterPhone, RequesterEmail, TicketID, TicketStatus, TicketRaiseDate, Category, SubCat1, SubCat2, Subject, Priority, Severity, T_Description, T_RequestMode, ReopenReason, reopenPic);

		System.out.println("UserActivityControllerrrr reponse is = " + final_response);
					
			out.print(final_response);
					
			System.out.println("UserReopenResolvedTicket GET SUCCESS");
		
	} catch (Exception e) {
		e.printStackTrace();
	}

	finally {
		out.close();
	}
//	return "Dashboard";
	return null;
	
}		

@RequestMapping(value = { "/chekingSLA" }, method = RequestMethod.POST)
public String chekingSLA(HttpServletRequest request, HttpServletResponse response,
		HttpSession session) {
	System.out.println("Inside getTPDashboardData Controller@@@@@@@@@@@@ ");
	PrintWriter out = null;
	
	try {
		out = response.getWriter();
		String company=request.getParameter("company");
		String priority=request.getParameter("priority");
		String severity=request.getParameter("severity");
		JSONArray final_response = userActivityService.chekingSLA(company,priority,severity);

		System.out.println("getTPDashboardData reponse is =dfdfdfdfdf " + final_response);

		out.print(final_response);

		System.out.println("getTPDashboardData SUCCESS");

	} catch (Exception e) {
		e.printStackTrace();
	}

	finally {
		out.close();
	}
//	return "Dashboard";
	return null;

}
@RequestMapping(value = { "/GetAssetinformaion" }, method = RequestMethod.POST)
public JSONArray GetAssetinformaion(ModelMap model, HttpServletRequest request, HttpServletResponse response,
		HttpSession session) {
	System.out.println("Inside Getotherinformaion Controller@@@@@@@@@@@@ ");
	PrintWriter out = null;
	try {
		out = response.getWriter();
		
		String othername = request.getParameter("asset");
		
		String[] split = othername.split("~");
		String assetname=split[0];
		System.out.println();
		JSONArray final_response = userActivityService.GetAssetinformaion(assetname);

		System.out.println("Getotherinformaion reponse is = " + final_response);
					
			out.print(final_response);
					
			System.out.println("Getotherinformaion GET SUCCESS");
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	finally {
		out.close();
	}
	return null;
}

@RequestMapping(value = { "/getProblemTicketsListing" }, method = RequestMethod.POST)
public JSONArray getProblemTicketsListing(ModelMap model, HttpServletRequest request, HttpServletResponse response,
		HttpSession session) {
	System.out.println("Inside getProblemTicketsListing Controller@@@@@@@@@@@@ ");
	PrintWriter out = null;
	try {
		out = response.getWriter();
		
		String othername = request.getParameter("status");
		String dates = request.getParameter("dates");
		JSONArray final_response = userActivityService.getProblemTicketsListing(othername,dates);

		System.out.println("Getotherinformaion reponse is = " + final_response);
					
			out.print(final_response);
					
			System.out.println("Getotherinformaion GET SUCCESS");
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	finally {
		out.close();
	}
	return null;
}

@RequestMapping(value = { "/getIncidentCategoryListing" }, method = RequestMethod.POST)
public JSONArray getIncidentCategoryListing(ModelMap model, HttpServletRequest request, HttpServletResponse response,
		HttpSession session) {
	System.out.println("Inside getTPDashboardData Controller@@@@@@@@@@@@ ");
	PrintWriter out = null;
	
	try {
		out = response.getWriter();
	
		String chartdata = request.getParameter("category");
		String lastmonth = request.getParameter("lastmonth");
		JSONArray final_response = userActivityService.getIncidentCategoryListing(chartdata,lastmonth);

		System.out.println("getTPDashboardData reponse is = " + final_response);

		out.print(final_response);

		System.out.println("getTPDashboardData SUCCESS");

	} catch (Exception e) {
		e.printStackTrace();
	}

	finally {
		out.close();
	}
//	return "Dashboard";
	return null;

}



@RequestMapping(value = { "/getPieListForCategoryServiceRequest" }, method = RequestMethod.POST)
public JSONArray getPieListForCategoryServiceRequest(ModelMap model, HttpServletRequest request, HttpServletResponse response,
		HttpSession session) {
	System.out.println("Inside getPieListForCategoryServiceRequest Controller@@@@@@@@@@@@ ");
	PrintWriter out = null;
	
	try {
		out = response.getWriter();
	
		String chartdata = request.getParameter("category");
		
		String lastmonth = request.getParameter("lastmonth");
		JSONArray final_response = userActivityService.getPieListForCategoryServiceRequest(chartdata,lastmonth);

		System.out.println("getPieListForCategoryServiceRequest reponse is = " + final_response);

		out.print(final_response);

		System.out.println("getPieListForCategoryServiceRequest SUCCESS");

	} catch (Exception e) {
		e.printStackTrace();
	}

	finally {
		out.close();
	}
//	return "Dashboard";
	return null;

}



@RequestMapping(value = { "/getIncidentPrioritySeverityListing" }, method = RequestMethod.POST)
public JSONArray getIncidentPrioritySeverityListing(ModelMap model, HttpServletRequest request, HttpServletResponse response,
		HttpSession session) {
	System.out.println("Inside getIncidentPrioritySeverityListing Controller@@@@@@@@@@@@ ");
	PrintWriter out = null;
	
	try {
		out = response.getWriter();
	
		String priority = request.getParameter("priority");
		String severity = request.getParameter("severity");
		String lastmonth = request.getParameter("lastmonth");
		JSONArray final_response = userActivityService.getIncidentPrioritySeverityListing(priority,severity,lastmonth);

		System.out.println("getIncidentPrioritySeverityListing reponse is = " + final_response);

		out.print(final_response);

		System.out.println("getIncidentPrioritySeverityListing SUCCESS");

	} catch (Exception e) {
		e.printStackTrace();
	}

	finally {
		out.close();
	}
//	return "Dashboard";
	return null;

}

@RequestMapping(value = { "/getServicePrioritySeverityListing" }, method = RequestMethod.POST)
public JSONArray getServicePrioritySeverityListing(ModelMap model, HttpServletRequest request, HttpServletResponse response,
		HttpSession session) {
	System.out.println("Inside getServicePrioritySeverityListing Controller@@@@@@@@@@@@ ");
	PrintWriter out = null;
	
	try {
		out = response.getWriter();
	
		String priority = request.getParameter("priority");
		String severity = request.getParameter("severity");
		String lastmonth = request.getParameter("lastmonth");
		JSONArray final_response = userActivityService.getServicePrioritySeverityListing(priority,severity,lastmonth);

		System.out.println("getServicePrioritySeverityListing reponse is = " + final_response);

		out.print(final_response);

		System.out.println("getServicePrioritySeverityListing SUCCESS");

	} catch (Exception e) {
		e.printStackTrace();
	}

	finally {
		out.close();
	}
//	return "Dashboard";
	return null;

}


@RequestMapping(value = { "/getallUserByLocationBased" }, method = RequestMethod.POST)
public JSONArray getallUserByLocationBased(ModelMap model, HttpServletRequest request, HttpServletResponse response,
		HttpSession session) {
	System.out.println("Inside getServicePrioritySeverityListing Controller@@@@@@@@@@@@ ");
	PrintWriter out = null;
	
	try {
		out = response.getWriter();
	
		String company = request.getParameter("company");
		String location = request.getParameter("location");	
		JSONArray final_response = userActivityService.getallUserByLocationBased(company,location);

		System.out.println("getServicePrioritySeverityListing reponse is = " + final_response);

		out.print(final_response);

		System.out.println("getServicePrioritySeverityListing SUCCESS");

	} catch (Exception e) {
		e.printStackTrace();
	}

	finally {
		out.close();
	}
//	return "Dashboard";
	return null;

}

@RequestMapping(value = { "/getVlxProposalSIRejectedData" }, method = RequestMethod.POST)
public void getVlxProposalSIRejectedData(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
	System.out.println("Inside getVlxProposalSIRejectedData method");

	String crno = request.getParameter("crno");
	String tid = request.getParameter("tid");
//	int crno1=Integer.parseInt(crno);
	PrintWriter out = null;
	try {

		HttpSession htt = request.getSession(true);
		String uname = (String) htt.getAttribute("username");
		System.out.println("usernamemeeem login==" + uname);
		System.out.println("usernamemeeem login==" + crno);
		System.out.println("usernamemeeem login==" + tid);

		out = response.getWriter();
		JSONArray array = (JSONArray) userActivityService.getVlxProposalSIRejectedData(crno, uname, tid);
		System.out.println("List value: " + array);
		out.print(array);
	} catch (Exception e) {
		System.out.println("Exception in getAttachmentCSData method: " + e);
	}

}



@RequestMapping(value = {"/veloxproposalUpdateDetails"},method = RequestMethod.POST )
public String veloxproposalUpdateDetails(HttpServletRequest request, HttpServletResponse response,HttpSession session)
{
	PrintWriter out=null;
	try {
		out=response.getWriter();
		
		
		String uname = (String) session.getAttribute("username");
		String company = (String) session.getAttribute("usercompany");
       System.out.println("usernamemeeem login==" + uname);
       
   
		
		String veloxdata=request.getParameter("veloxdata");
		String poinitiator=request.getParameter("poinitiator");
		String poinitiatorno=request.getParameter("poinitiatorno");
		String FirstApprovername=request.getParameter("FirstApprovername");
		
		String firstapprovercontact=request.getParameter("firstapprovercontact");
		String secondApprovername=request.getParameter("secondApprovername");
		String secondapprovercontact=request.getParameter("secondapprovercontact");
		String clientname=request.getParameter("clientname");
		String Description=request.getParameter("Description");
		String totalpriceforallproduct =request.getParameter("totalpriceforallproduct");
		String deploysupport =request.getParameter("deploysupport");
		String clouddeploycharges =request.getParameter("clouddeploycharges");
		String subtotalB =request.getParameter("subtotalB");
		String resoucesamount=request.getParameter("resoucesamount");
		String ATC=request.getParameter("ATC");
		String subtotalAB=request.getParameter("subtotalAB");
		
		String Proposaltype =request.getParameter("Proposaltype");
		String Perpetualyear=request.getParameter("Perpetualyear");
		String Subscriptionyear =request.getParameter("Subscriptionyear");					
		String Amcsecondyear=request.getParameter("Amcsecondyear");
		String Amcthirdyear=request.getParameter("Amcthirdyear");
		String Amcfourthyear=request.getParameter("Amcfourthyear");
		String Amcfiveyear=request.getParameter("Amcfiveyear");
		String secondyearsubscription=request.getParameter("secondyearsubscription");
		String thirdyearsubscription=request.getParameter("thirdyearsubscription");	
		
		   String productsuitselect=request.getParameter("productsuitselect");
		    String Scanplusprodversion=request.getParameter("Scanplusprodversion");
		    String SecureITprodversion=request.getParameter("SecureITprodversion");
		    String enccustomername=request.getParameter("enccustomername");
		    String fixedyear=request.getParameter("fixedyear");
		    
						
		
		
		String folderPath = "/WEB-INF/VeloxProposalPDF/veloxlogo.png";
	    String fullPathVlxLogo = servletContext.getRealPath(folderPath);
	    String fullPathVlxEnd = servletContext.getRealPath("/WEB-INF/VeloxProposalPDF/end.png");
	    String fullPathSwachBharat = servletContext.getRealPath("/WEB-INF/VeloxProposalPDF/swachBharat.png");
	    String Letterhead = servletContext.getRealPath("/WEB-INF/VeloxProposalPDF/Letterhead.PNG");
	    String signature = servletContext.getRealPath("/WEB-INF/VeloxProposalPDF/signature.PNG");
	    System.out.println("fullPath "+fullPathVlxLogo);
	    System.out.println("signature "+signature);
	    
	    String IntegrationchargeYesNo = request.getParameter("IntegrationCharges");
	    String IntegrationCharges = request.getParameter("integrationcharge");
	    String Total_C=request.getParameter("totalc");
	    String GSTPERCENTAGE=request.getParameter("total18percentage");
	    String Grand_Total=request.getParameter("grandtotal");
		
		String crno =request.getParameter("crno");
		String tid =request.getParameter("tid");
		String SInote=request.getParameter("SInote");
		
		
		String amcstartdate = request.getParameter("amcstartdate");
		String AMCmonthyear = request.getParameter("AMCmonthyear");
		String AMCMonth = request.getParameter("AMCMonth");
		String AMCYear = request.getParameter("AMCYear");
		String amcenddate = request.getParameter("amcenddate");
		String productsuitdetails = request.getParameter("productsuitdetails");
		String securitysolutiondetails = request.getParameter("securitysolutiondetails");
		String descforamc = request.getParameter("descforamc");
		String totalcostAMC = request.getParameter("totalcostAMC");
		String GRANDTOTALFORAMC = request.getParameter("GRANDTOTALFORAMC");
		String gstforamc = request.getParameter("gstforamc");
		
		String subtotalAResource = request.getParameter("subtotalAResource");
		String gstdataforresource = request.getParameter("gstdataforresource");
		String grandtotalforresource = request.getParameter("grandtotalforresource");
		
		String contactperson = request.getParameter("contactperson");
					
	   
//		String finals=userActivityService.veloxproposalUpdateDetails(veloxdata,poinitiator,poinitiatorno,FirstApprovername,firstapprovercontact,secondApprovername,secondapprovercontact,clientname,
//				Description,totalpriceforallproduct,deploysupport,clouddeploycharges,subtotalB,subtotalAB,uname,crno,tid,SInote);
		String finals=userActivityService.veloxproposalUpdateDetails(veloxdata,poinitiator,poinitiatorno,FirstApprovername,firstapprovercontact,secondApprovername,secondapprovercontact,clientname,Description,totalpriceforallproduct,deploysupport,clouddeploycharges,subtotalB,subtotalAB,uname,resoucesamount,ATC,Proposaltype,Perpetualyear,
				Subscriptionyear,Amcsecondyear,Amcthirdyear,Amcfourthyear,Amcfiveyear,secondyearsubscription,thirdyearsubscription,fullPathVlxLogo,fullPathVlxEnd,fullPathSwachBharat,
				IntegrationchargeYesNo,IntegrationCharges,Total_C,GSTPERCENTAGE,Grand_Total,productsuitselect,Scanplusprodversion,SecureITprodversion,enccustomername,Letterhead,signature,
				fixedyear,crno,tid,SInote,amcstartdate,AMCmonthyear,AMCMonth,AMCYear,
				amcenddate,productsuitdetails,securitysolutiondetails,descforamc,totalcostAMC,GRANDTOTALFORAMC,gstforamc,
				gstdataforresource ,grandtotalforresource ,subtotalAResource,contactperson );
		out.print(finals);
	}
	catch (IOException e)
	{
		e.printStackTrace();
	}
return null;

}



@RequestMapping(value = { "/vlxPropRejectedBymeDetails" }, method = RequestMethod.POST)
public void vlxPropRejectedBymeDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
		HttpSession session) {
	System.out.println("Inside vlxPropRejectedBymeDetails method");

	PrintWriter out = null;
	try {

		String uname = (String) session.getAttribute("username");
		String company = (String) session.getAttribute("usercompany");
		String userfullname = (String) session.getAttribute("fullname");
		System.out.println("usernamemeeem login==" + uname);

		out = response.getWriter();
		JSONArray array = (JSONArray) userActivityService.vlxPropRejectedBymeDetails(uname, company,userfullname);
		System.out.println("List value: " + array);
		out.print(array);
	} catch (Exception e) {
		System.out.println("Exception in ApplicationUserController getBranchList method: " + e);
	}

}


@RequestMapping(value = { "/getVlxProposalSMRejectedData" }, method = RequestMethod.POST)
public void getVlxProposalSMRejectedData(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
	System.out.println("Inside getVlxProposalSMRejectedData method");

	String crno = request.getParameter("crno");
	String tid = request.getParameter("tid");
//	int crno1=Integer.parseInt(crno);
	PrintWriter out = null;
	try {

		HttpSession htt = request.getSession(true);
		String uname = (String) htt.getAttribute("username");
		System.out.println("usernamemeeem login==" + uname);
		System.out.println("usernamemeeem login==" + crno);
		System.out.println("usernamemeeem login==" + tid);

		out = response.getWriter();
		JSONArray array = (JSONArray) userActivityService.getVlxProposalSMRejectedData(crno, uname, tid);
		System.out.println("List value: " + array);
		out.print(array);
	} catch (Exception e) {
		System.out.println("Exception in getAttachmentCSData method: " + e);
	}

}


@RequestMapping(value = { "/SMrejectVP" }, method = RequestMethod.POST)
public void sMrejectVP(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
	System.out.println("Inside ccreject method");

	String crno = request.getParameter("crno");
    String rejectreason = request.getParameter("val");
	String SMnote = request.getParameter("SMnote");
    String tid = request.getParameter("tid");

	PrintWriter out = null;
	try {
		HttpSession htt = request.getSession(true);
		String uname = (String) htt.getAttribute("username");
		String company = (String) htt.getAttribute("usercompany");
		System.out.println("usernamemeeem login==" + uname);
		System.out.println("company login==" + company);
		out = response.getWriter();
		String result = userActivityService.SMrejectVP(crno,company,rejectreason,SMnote,uname,tid);
		System.out.println("Result value: "+result);
		out.print(result);
	} catch (Exception e) {
		System.out.println("Exception in Asave Company: " + e);
	}

}


@RequestMapping(value = { "/SaleMngPending_RegistrationeDetails" }, method = RequestMethod.POST)
public JSONArray SaleMngPending_RegistrationeDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,HttpSession session) {
	System.out.println("Inside cm details Controller@@@@@@@@@@@@ ");
	PrintWriter out = null;

	try {
		out = response.getWriter();
		
		 String uname = (String) session.getAttribute("username");
		 String company = (String) session.getAttribute("usercompany");
		 String fullname = (String) session.getAttribute("fullname");
		
		 
		JSONArray final_response = userActivityService.SaleMngPending_RegistrationeDetails(uname,company,fullname);

		System.out.println("MastersControllerrrr reponse is = " + final_response);
					
			out.print(final_response);
					
			System.out.println("username GET SUCCESS");
		
	} catch (Exception e) {
		e.printStackTrace();
	}

	finally {
		out.close();
	}
//	return "Dashboard";
	return null;
	
}
@RequestMapping(value = { "/SalesIniraised_RegistrationDetails" }, method = RequestMethod.POST)
public JSONArray SalesIniraised_RegistrationDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,HttpSession session) {
	System.out.println("Inside cm details Controller@@@@@@@@@@@@ ");
	PrintWriter out = null;

	try {
		out = response.getWriter();
		
		 String uname = (String) session.getAttribute("username");
		 String company = (String) session.getAttribute("usercompany");
		
		 
		JSONArray final_response = userActivityService.SalesIniraised_RegistrationDetails(uname,company);

		System.out.println("MastersControllerrrr reponse is = " + final_response);
					
			out.print(final_response);
					
			System.out.println("username GET SUCCESS");
		
	} catch (Exception e) {
		e.printStackTrace();
	}

	finally {
		out.close();
	}
//	return "Dashboard";
	return null;
	
}


@RequestMapping(value = { "/getRaisedRegistraionlist" }, method = RequestMethod.POST)
public JSONArray getRaisedRegistraionlist(ModelMap model, HttpServletRequest request,
		HttpServletResponse response, HttpSession session) {
	//System.out.println("Inside getCompositeCompanyList Controller@@@@@@@@@@@@ ");
	PrintWriter out = null;
	
	
	
	String crno=request.getParameter("crno");
	String tid = request.getParameter("tid");
//	int crno1=Integer.parseInt(crno);
	
	try {
		
		HttpSession htt = request.getSession(true);
        String uname = (String) htt.getAttribute("username");
        System.out.println("usernamemeeem login==" + uname);
        System.out.println("usernamemeeem login==" + crno);
        System.out.println("usernamemeeem tid login==" + tid);

		out = response.getWriter();
		JSONArray array = (JSONArray) userActivityService.getRaisedRegistraionlist(crno,uname,tid);
		System.out.println("List value: "+array);
		out.print(array);
	
	}catch (Exception e) {
		e.printStackTrace();
	}

	finally {
		if (out != null)
			out.close();
	}

	return null;

}


@RequestMapping(value = { "/pendingFORM3Details" }, method = RequestMethod.POST)
public void pendingFORM3Details(ModelMap model, HttpServletRequest request, HttpServletResponse response,HttpSession session) {
	System.out.println("Inside /pendingFORM3Details method");
	
	PrintWriter out = null;
	try {
		
		String uname = (String) session.getAttribute("username");
		String company = (String) session.getAttribute("usercompany");
		 String fullname = (String) session.getAttribute("fullname");
        System.out.println("usernamemeeem login==" + uname);

		out = response.getWriter();
		JSONArray array = (JSONArray) userActivityService.pendingFORM3Details(uname,company,fullname);
		System.out.println("List value: "+array);
		out.print(array);
	}
	catch(Exception e) {
		System.out.println("Exception in ApplicationUserController getBranchList method: "+e);
	}
	
}

@RequestMapping(value = { "/getPendingFORM3Data" }, method = RequestMethod.POST)
public void getPendingFORM3Data(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
	System.out.println("Inside getPendingFORM3Data method");
	
	String crno=request.getParameter("crno");
	 String tid = request.getParameter("tid");
//	int crno1=Integer.parseInt(crno);
	PrintWriter out = null;
	try {
		
		HttpSession htt = request.getSession(true);
        String uname = (String) htt.getAttribute("username");
        
        String fullname = (String) htt.getAttribute("fullname");
        System.out.println("usernamemeeem login==" + uname);
        System.out.println("usernamemeeem login==" + crno);
        System.out.println("usernamemeeem login==" + tid);

		out = response.getWriter();
		JSONArray array = (JSONArray) userActivityService.getPendingFORM3Data(crno,uname,tid,fullname);
		System.out.println("List value: "+array);
		out.print(array);
	}
	catch(Exception e) {
		System.out.println("Exception in getAttachmentCSData method: "+e);
	}
	
}



@RequestMapping(value = {"/InsertForm3"},method = RequestMethod.POST )
public String InsertForm3(HttpServletRequest request, HttpServletResponse response,HttpSession session)
{
	PrintWriter out=null;
	try {
		out=response.getWriter();
		HttpSession htt = request.getSession(true);
        String uname = (String) htt.getAttribute("username");
        String fullname = (String) htt.getAttribute("fullname");
        System.out.println("usernamemeeem login==" + uname);
        
		String date=request.getParameter("date");
		String projeimplementorname=request.getParameter("projeimplementorname");
		String customername=request.getParameter("customername");
		String projectname=request.getParameter("projectname");	
		
		String serverAvail=request.getParameter("serverAvail");
		String ServerAvail_Responsibility=request.getParameter("Responsibility");
		String server_startdate=request.getParameter("startdate");
		String server_enddate=request.getParameter("enddate");
		String installvlxlicenseate=request.getParameter("installvlxlicense");
		String Responsibilityvlxlicense=request.getParameter("Responsibilityvlxlicense");
		String startdatevlxlicense=request.getParameter("startdatevlxlicense");
		String enddatevlxlicense=request.getParameter("enddatevlxlicense");
		String UATTesting=request.getParameter("UATTesting");
		String Responsibilityuattesting=request.getParameter("Responsibilityuattesting");
		String startdateuattesting=request.getParameter("startdateuattesting");
		String enddateuattesting=request.getParameter("enddateuattesting");
		String productiongolive=request.getParameter("productiongolive");
		String Responsibilitygolive=request.getParameter("Responsibilitygolive");
		String startdategolive=request.getParameter("startdategolive");
		String enddategolive=request.getParameter("enddategolive");
		String rollout=request.getParameter("rollout");
		String Responsibilityrollout=request.getParameter("Responsibilityrollout");
		String startdaterollout=request.getParameter("startdaterollout");
		String enddaterollout=request.getParameter("enddaterollout");
		String demolive=request.getParameter("demolive");
		String Responsibilitydemo=request.getParameter("Responsibilitydemo");
		String startdatedemo=request.getParameter("startdatedemo");
		String enddatedemo=request.getParameter("enddatedemo");
        String paymentterms=request.getParameter("paymentterms");
		String Responsibilitypaymentterms=request.getParameter("Responsibilitypaymentterms");
		String startdatepaymentterms=request.getParameter("startdatepaymentterms");
		String enddatepaymentterms=request.getParameter("enddatepaymentterms");
		String signoff=request.getParameter("signoff");
		String Responsibilitysignoff=request.getParameter("Responsibilitysignoff");
		String startdatesignoff=request.getParameter("startdatesignoff");
		String enddatesignoff=request.getParameter("enddatesignoff");
		
		String poNumber=request.getParameter("poNumber");
		String crno=request.getParameter("crno");
		String tid=request.getParameter("tid");
		
		String productLicense=request.getParameter("productLicense");
		String jsonImplFormC=request.getParameter("jsonImplFormC");
		
		String CustImplementorName=request.getParameter("ImplementorName");
		String CustImplementorNumber=request.getParameter("ImplementorNumber");
		String cusImplementorEmail=request.getParameter("cusImplementorEmail");
		String SalesManagerName=request.getParameter("SalesManagerName");
		String EndCustomerName=request.getParameter("EndCustomerName");
		String EndCustomerNumber=request.getParameter("EndCustomerNumber");
		
		
		
		
		String finals=userActivityService.InsertForm3(date,projeimplementorname,customername,projectname,serverAvail,ServerAvail_Responsibility,server_startdate,server_enddate,installvlxlicenseate
				,Responsibilityvlxlicense,startdatevlxlicense,enddatevlxlicense,UATTesting,Responsibilityuattesting,startdateuattesting,enddateuattesting,productiongolive,
				Responsibilitygolive,startdategolive,enddategolive,rollout,Responsibilityrollout,startdaterollout,enddaterollout,demolive,Responsibilitydemo,startdatedemo,enddatedemo,paymentterms,
				Responsibilitypaymentterms,startdatepaymentterms,enddatepaymentterms,signoff,Responsibilitysignoff,startdatesignoff,enddatesignoff,crno,tid,uname,poNumber,productLicense,jsonImplFormC, fullname,
				CustImplementorName ,CustImplementorNumber,cusImplementorEmail,SalesManagerName,EndCustomerName,EndCustomerNumber);
		out.print(finals);
	}
	catch (IOException e)
	{
		e.printStackTrace();
	}
return null;

}		 

@RequestMapping(value = { "/registFormCollnMangApprove" }, method = RequestMethod.POST)
public void registFormCollnMangApprove(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
	System.out.println("Inside getUpdateCollnMangpprove method");
	
	 String crno = request.getParameter("crno");
     String status = request.getParameter("status");
     String tid = request.getParameter("tid");
	
	PrintWriter out = null;
	try {
		HttpSession htt = request.getSession(true);
        String uname = (String) htt.getAttribute("username");
        String company = (String) htt.getAttribute("usercompany");
        System.out.println("usernamemeeem login==" + uname);
		
		out = response.getWriter();
		String result = userActivityService.registFormCollnMangApprove(crno,status,tid,uname,company);
		System.out.println("Result value: "+result);
		out.print(result);
	}
	catch(Exception e) {
		System.out.println("Exception in Asave Company: "+e);
	}

}



@RequestMapping(value = { "/CMapprovedRegistrationDetails" }, method = RequestMethod.POST)
public JSONArray CMapprovedRegistrationDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,HttpSession session) {
	System.out.println("Inside cm details Controller@@@@@@@@@@@@ ");
	PrintWriter out = null;

	try {
		out = response.getWriter();
		
		 String uname = (String) session.getAttribute("username");
		 String company = (String) session.getAttribute("usercompany");
		 String fullname = (String) session.getAttribute("fullname");
		 String role = (String) session.getAttribute("role");
		
		 
		JSONArray final_response = userActivityService.CMapprovedRegistrationDetails(uname,company,fullname,role);

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

@RequestMapping(value = { "/getApprovedCMRegistraionlist" }, method = RequestMethod.POST)
public JSONArray getApprovedCMRegistraionlist(ModelMap model, HttpServletRequest request,
		HttpServletResponse response, HttpSession session) {
	//System.out.println("Inside getCompositeCompanyList Controller@@@@@@@@@@@@ ");
	PrintWriter out = null;
	
	
	
	String crno=request.getParameter("crno");
	String tid = request.getParameter("tid");
//	int crno1=Integer.parseInt(crno);
	
	try {
		
		HttpSession htt = request.getSession(true);
        String uname = (String) htt.getAttribute("username");
        System.out.println("usernamemeeem login==" + uname);
        System.out.println("usernamemeeem login==" + crno);
        System.out.println("usernamemeeem tid login==" + tid);

		out = response.getWriter();
		JSONArray array = (JSONArray) userActivityService.getApprovedCMRegistraionlist(crno,uname,tid);
		System.out.println("List value: "+array);
		out.print(array);
	
	}catch (Exception e) {
		e.printStackTrace();
	}

	finally {
		if (out != null)
			out.close();
	}

	return null;

}



@RequestMapping(value = { "/submittedFORM3Details" }, method = RequestMethod.POST)
public void submittedFORM3Details(ModelMap model, HttpServletRequest request, HttpServletResponse response,HttpSession session) {
	System.out.println("Inside /pendingFORM3Details method");
	
	PrintWriter out = null;
	try {
		
		String uname = (String) session.getAttribute("username");
		String company = (String) session.getAttribute("usercompany");
        System.out.println("usernamemeeem login==" + uname);

		out = response.getWriter();
		JSONArray array = (JSONArray) userActivityService.submittedFORM3Details(uname,company);
		System.out.println("List value: "+array);
		out.print(array);
	}
	catch(Exception e) {
		System.out.println("Exception in ApplicationUserController getBranchList method: "+e);
	}
	
}

@RequestMapping(value = { "/getSubmittedFORM3Data" }, method = RequestMethod.POST)
public void getSubmittedFORM3Data(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
	System.out.println("Inside getPendingFORM3Data method");
	
	String crno=request.getParameter("crno");
	 String tid = request.getParameter("tid");
//	int crno1=Integer.parseInt(crno);
	PrintWriter out = null;
	try {
		
		HttpSession htt = request.getSession(true);
        String uname = (String) htt.getAttribute("username");
      
        System.out.println("usernamemeeem login==" + uname);
        System.out.println("usernamemeeem login==" + crno);
        System.out.println("usernamemeeem login==" + tid);

		out = response.getWriter();
		JSONArray array = (JSONArray) userActivityService.getSubmittedFORM3Data(crno,uname,tid);
		System.out.println("List value: "+array);
		out.print(array);
	}
	catch(Exception e) {
		System.out.println("Exception in getAttachmentCSData method: "+e);
	}
	
}
@RequestMapping(value = { "/getCheckerContactNo" }, method = RequestMethod.POST)
public String getCheckerContactNo(ModelMap model, HttpServletRequest request, HttpServletResponse response,
		HttpSession session) {
	
	PrintWriter out=null;
	try {
		out=response.getWriter();
		
		
		String uname = (String) session.getAttribute("username");
//		String company = (String) session.getAttribute("usercompany");
//        System.out.println("usernamemeeem login==" + uname);
		
		String checkerApprovername=request.getParameter("checkerApprovername");
	
		JSONArray final_response = userActivityService.getCheckerContactNo(checkerApprovername);

	//	System.out.println("Controllerrrr reponse is checkerApprovername  = " + final_response);
					
			out.print(final_response);
	
		
	}
	catch (IOException e)
	{
		e.printStackTrace();
	}
	finally {
		out.close();
	}

	return null;

}


@RequestMapping(value = { "/SaleMngFormABDetails" }, method = RequestMethod.POST)
public JSONArray SaleMngFormABDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,HttpSession session) {
	//System.out.println("Inside cm details Controller@@@@@@@@@@@@ ");
	PrintWriter out = null;

	try {
		out = response.getWriter();
		
		 String uname = (String) session.getAttribute("username");
		 String company = (String) session.getAttribute("usercompany");
		 String userfullname = (String) session.getAttribute("fullname");
		JSONArray final_response = userActivityService.SaleMngFormABDetails(uname,company,userfullname);

		System.out.println("MastersControllerrrr reponse is = " + final_response);
					
			out.print(final_response);
					
			System.out.println("username GET SUCCESS");
		
	} catch (Exception e) {
		e.printStackTrace();
	}

	finally {
		out.close();
	}
//	return "Dashboard";
	return null;
	
}

@RequestMapping(value = { "/getDataSaleMngFormABDetails" }, method = RequestMethod.POST)
public void getDataSaleMngFormABDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
	
	 String crno=request.getParameter("crno");
	 String tid = request.getParameter("tid");
//	int crno1=Integer.parseInt(crno);
	PrintWriter out = null;
	try {
		
		HttpSession htt = request.getSession(true);
        String uname = (String) htt.getAttribute("username");
        System.out.println("usernamemeeem login==" + uname);
        System.out.println("usernamemeeem login==" + crno);
        System.out.println("usernamemeeem login==" + tid);

		out = response.getWriter();
		JSONArray array = (JSONArray) userActivityService.getDataSaleMngFormABDetails(crno,uname,tid);
		System.out.println("List value: "+array);
		out.print(array);
	}
	catch(Exception e) {
		System.out.println("Exception in getAttachmentCSData method: "+e);
	}
	
}

@RequestMapping(value = { "/trackDetails" }, method = RequestMethod.POST)
public JSONArray trackDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,HttpSession session) {
	System.out.println("Inside trackDetails details Controller@@@@@@@@@@@@ ");
	PrintWriter out = null;

	try {
		out = response.getWriter();
		String fromDate = request.getParameter("fromDate");
		
		 System.out.println("fromDate55555555555"+fromDate);
		 String toDate = request.getParameter("toDate");
		 String selecttype = request.getParameter("selecttype");
		 String selectType2 = request.getParameter("selectType2");
		JSONArray final_response = userActivityService.trackDetails(fromDate,toDate,selecttype,selectType2);

		System.out.println("MastersControllerrrr reponse is = " + final_response);
					
			out.print(final_response);
					
			System.out.println("username GET SUCCESS");
		
	} catch (Exception e) {
		e.printStackTrace();
	}

	finally {
		out.close();
	}
//	return "Dashboard";
	return null;
	
}



@RequestMapping(value = { "/submittedFormABseniorMangDetails" }, method = RequestMethod.POST)
public void submittedFormABseniorMangDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,HttpSession session) {

	
	PrintWriter out = null;
	try {
		
		String uname = (String) session.getAttribute("username");
		String company = (String) session.getAttribute("usercompany");
		String fullname = (String) session.getAttribute("fullname");
        
		out = response.getWriter();
		JSONArray array = (JSONArray) userActivityService.submittedFormABseniorMangDetails(uname,company,fullname);
		System.out.println("List value: "+array);
		out.print(array);
	}
	catch(Exception e) {
		System.out.println("Exception in ApplicationUserController getBranchList method: "+e);
	}
	
}

@RequestMapping(value = { "/getSubmittedFormABData" }, method = RequestMethod.POST)
public void getSubmittedFormABData(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
	
	
	String crno=request.getParameter("crno");
	 String tid = request.getParameter("tid");
//	int crno1=Integer.parseInt(crno);
	PrintWriter out = null;
	try {
		
		HttpSession htt = request.getSession(true);
        String uname = (String) htt.getAttribute("username");
        System.out.println("usernamemeeem login==" + uname);
        System.out.println("usernamemeeem login==" + crno);
        System.out.println("usernamemeeem login==" + tid);

		out = response.getWriter();
		JSONArray array = (JSONArray) userActivityService.getSubmittedFormABData(crno,uname,tid);
		System.out.println("List value: "+array);
		out.print(array);
	}
	catch(Exception e) {
		System.out.println("Exception in getAttachmentCSData method: "+e);
	}
	
}



@RequestMapping(value = { "/MDrejectVP" }, method = RequestMethod.POST)
public void MDrejectVP(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
	System.out.println("Inside MDrejectVP method");

	String crno = request.getParameter("crno");
    String rejectreason = request.getParameter("val");
	String MDnote = request.getParameter("MDnote");
	
	System.out.println("md note :"+MDnote);
    String tid = request.getParameter("tid");

	PrintWriter out = null;
	try {
		HttpSession htt = request.getSession(true);
		String uname = (String) htt.getAttribute("username");
		String company = (String) htt.getAttribute("usercompany");
		System.out.println("usernamemeeem login==" + uname);
		System.out.println("company login==" + company);
		out = response.getWriter();
		String result = userActivityService.MDrejectVP(crno,company,rejectreason,MDnote,uname,tid);
		System.out.println("Result value: "+result);
		out.print(result);
	} catch (Exception e) {
		System.out.println("Exception in Asave Company: " + e);
	}

}




@RequestMapping(value = { "/vlxProposalRejectDetails" }, method = RequestMethod.POST)
public JSONArray vlxProposalRejectDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,HttpSession session) {
	System.out.println("Inside cm vlxProposalRejectDetails Controller@@@@@@@@@@@@ ");
	PrintWriter out = null;
	

	try {
		out = response.getWriter();
		
		 String uname = (String) session.getAttribute("username");
		 String company = (String) session.getAttribute("usercompany");
		JSONArray final_response = userActivityService.vlxProposalRejectDetails(uname,company);

		System.out.println("MastersControllerrrr reponse is = " + final_response);
					
			out.print(final_response);
					
			System.out.println("username GET SUCCESS");
		
	} catch (Exception e) {
		e.printStackTrace();
	}

	finally {
		out.close();
	}
//	return "Dashboard";
	return null;
	
}

@RequestMapping(value = { "/vlxProposalRejectedMDDetails" }, method = RequestMethod.POST)
public void vlxProposalRejectedMDDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
		HttpSession session) {
	System.out.println("Inside vlxProposalRejectedMDDetails method");

	PrintWriter out = null;
	try {

		String uname = (String) session.getAttribute("username");
		String company = (String) session.getAttribute("usercompany");
		String fullname = (String) session.getAttribute("fullname");
		System.out.println("usernamemeeem login==" + uname);

		out = response.getWriter();
		JSONArray array = (JSONArray) userActivityService.vlxProposalRejectedMDDetails(uname, company,fullname);
		System.out.println("List value: " + array);
		out.print(array);
	} catch (Exception e) {
		System.out.println("Exception in ApplicationUserController getBranchList method: " + e);
	}

}


@RequestMapping(value = { "/getVlxProposalMDRejectedData" }, method = RequestMethod.POST)
public void getVlxProposalMDRejectedData(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
	System.out.println("Inside getVlxProposalMDRejectedData method");

	String crno = request.getParameter("crno");
	String tid = request.getParameter("tid");
//	int crno1=Integer.parseInt(crno);
	PrintWriter out = null;
	try {

		HttpSession htt = request.getSession(true);
		String uname = (String) htt.getAttribute("username");
		System.out.println("usernamemeeem login==" + uname);
		System.out.println("usernamemeeem login==" + crno);
		System.out.println("usernamemeeem login==" + tid);

		out = response.getWriter();
		JSONArray array = (JSONArray) userActivityService.getVlxProposalMDRejectedData(crno, uname, tid);
		System.out.println("List value: " + array);
		out.print(array);
	} catch (Exception e) {
		System.out.println("Exception in getAttachmentCSData method: " + e);
	}

}

@RequestMapping(value = { "/insertPOFormAB" }, method = RequestMethod.POST)
public JSONArray insertPOFormAB(ModelMap model, HttpServletRequest request, HttpServletResponse response,
		HttpSession session) {

	PrintWriter out = null;
	
	try {
		out = response.getWriter();
		
		String loginuser=(String)session.getAttribute("username");
		String loginUserCompany = session.getAttribute("companyname").toString();
		  
        
        String dateforma = request.getParameter("dateforma");
        String salemangname = request.getParameter("salemangname");
        String formApoNo = request.getParameter("formApoNo");
        
        String distributorpartyname = request.getParameter("distributorpartyname");
        String distributorprojectname = request.getParameter("distributorprojectname");
        String distributortechpersonname = request.getParameter("distributortechpersonname");
        String distributorprsndesignation = request.getParameter("distributorprsndesignation");
        String distributorcontactnumber = request.getParameter("distributorcontactnumber");
        String distributoremailid = request.getParameter("distributoremailid");
        
        String partnerpartyname = request.getParameter("partnerpartyname");
        String partnerprojectname = request.getParameter("partnerprojectname");
        String partnertechpersonname = request.getParameter("partnertechpersonname");
        String partnerprsndesignation = request.getParameter("partnerprsndesignation");
        String partnercontactnumber = request.getParameter("partnercontactnumber");
        String partneremailid = request.getParameter("partneremailid");
        
        String customerpartyname = request.getParameter("customerpartyname");
        String customerprojectname = request.getParameter("customerprojectname");
        String customertechpersonname = request.getParameter("customertechpersonname");
        String customerprsndesignation = request.getParameter("customerprsndesignation");
        String customercontactnumber = request.getParameter("customercontactnumber");
        String customeremailid = request.getParameter("customeremailid");
        
        String implementorpartyname = request.getParameter("implementorpartyname");
        String implementorprojectname = request.getParameter("implementorprojectname");	
        String implementortechpersonname=request.getParameter("implementortechpersonname");
		String implementorprsndesignation = request.getParameter("implementorprsndesignation");	
        String implementorcontactnumber=request.getParameter("implementorcontactnumber");
        String implementoremailid=request.getParameter("implementoremailid");
       
        String form2date = request.getParameter("form2date");
        String form2customername = request.getParameter("form2customername");
        
        String RPFTIMELINES = request.getParameter("RPFTIMELINES");
        String potimeline = request.getParameter("potimeline");
        String firstinvoicegeneratedate = request.getParameter("firstinvoicegeneratedate");
        String radiosss = request.getParameter("radiosss");
        String chartpaymntno = request.getParameter("chartpaymntno");
        String projstartdate = request.getParameter("projstartdate");
        String projenddate = request.getParameter("projenddate");
        String pymentterms = request.getParameter("pymentterms");
        String projecthead = request.getParameter("projecthead");
        String poform2No = request.getParameter("poform2No");
        String remarks = request.getParameter("Remarks");
        
        String crno = request.getParameter("crno");
        String tid = request.getParameter("tid");
        
        String endcustomerpartyname = request.getParameter("endcustomerpartyname");
        String endcustomerprojectname = request.getParameter("endcustomerprojectname");	
        String endcustomertechpersonname=request.getParameter("endcustomertechpersonname");
		String endcustomerprsndesignation = request.getParameter("endcustomerprsndesignation");	
        String endcustomercontactnumber=request.getParameter("endcustomercontactnumber");
        String endcustomeremailid=request.getParameter("endcustomeremailid");
        
        String jsonImplFormC = request.getParameter("jsonImplFormC");
        String sMnote = request.getParameter("SMnote");
        String potype = request.getParameter("potype");
        System.out.println("jsonImplFormC "+jsonImplFormC);

		String final_response = userActivityService.insertPOFormAB( 
				loginuser,loginUserCompany,dateforma, salemangname, distributorpartyname, distributorprojectname, distributortechpersonname,
				distributorprsndesignation, distributorcontactnumber, distributoremailid, partnerpartyname, partnerprojectname, partnertechpersonname, partnerprsndesignation, partnercontactnumber, partneremailid, customerpartyname, customerprojectname, customertechpersonname,customerprsndesignation,customercontactnumber,customeremailid,
				implementorpartyname,implementorprojectname,implementortechpersonname,implementorprsndesignation,implementorcontactnumber,implementoremailid,
				form2date, form2customername, RPFTIMELINES, potimeline, firstinvoicegeneratedate,radiosss, projstartdate, projenddate, pymentterms, 
				projecthead,  formApoNo, poform2No, remarks,chartpaymntno,crno,tid,jsonImplFormC,endcustomerpartyname,endcustomerprojectname,endcustomertechpersonname,endcustomerprsndesignation,endcustomercontactnumber,endcustomeremailid,sMnote,potype);

		System.out.println("MastersControllerrrr reponse is = " + final_response);
					
			out.print(final_response);
						
			System.out.println("insertFormA GET SUCCESS");
		
	} catch (Exception e) {
		e.printStackTrace();
	}

	finally {
		out.close();
	}
//	return "Dashboard";
	return null;

}

@RequestMapping(value = { "/rejectRFtoACmgr" }, method = RequestMethod.POST)
public void rejectRFtoACmgr(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
	System.out.println("Inside ccreject method");

	String crno = request.getParameter("crno");
    String rejectreason = request.getParameter("val");
	String SMnote = request.getParameter("SMnote");
    String tid = request.getParameter("tid");

	PrintWriter out = null;
	try {
		HttpSession htt = request.getSession(true);
		String uname = (String) htt.getAttribute("username");
		String company = (String) htt.getAttribute("usercompany");
		System.out.println("usernamemeeem login==" + uname);
		System.out.println("company login==" + company);
		out = response.getWriter();
		String result = userActivityService.rejectRFtoACmgr(crno,company,rejectreason,SMnote,uname,tid);
		System.out.println("Result value: "+result);
		out.print(result);
	} catch (Exception e) {
		System.out.println("Exception in Asave Company: " + e);
	}

}

@RequestMapping(value = { "/Rejectrfdetails" }, method = RequestMethod.POST)
public JSONArray Rejectrfdetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,HttpSession session) {
	System.out.println("Inside cm details Controller@@@@@@@@@@@@ ");
	PrintWriter out = null;

	try {
		out = response.getWriter();
		
		 String uname = (String) session.getAttribute("username");
		 String company = (String) session.getAttribute("usercompany");
		 String role = (String) session.getAttribute("role");
		
		 
		JSONArray final_response = userActivityService.Rejectrfdetails(uname,company,role);

		System.out.println("MastersControllerrrr reponse is = " + final_response);
					
			out.print(final_response);
					
			System.out.println("username GET SUCCESS");
		
	} catch (Exception e) {
		e.printStackTrace();
	}

	finally {
		out.close();
	}
//	return "Dashboard";
	return null;
	
}



@RequestMapping(value = { "/getfrom3details" }, method = RequestMethod.POST)
public String getfrom3details(ModelMap model, HttpServletRequest request, HttpServletResponse response,
		HttpSession session) {
	System.out.println("Inside getUserDetailsForUpdate Controller@@@@@@@@@@@@ ");
	PrintWriter out = null;
	String details = null;
	 String LoginUser = null;
	try {
//        HttpSession session = request.getSession(true);
        LoginUser = session.getAttribute("username").toString();
        		String ponumber = request.getParameter("ponumber");
        
	
		out = response.getWriter();
		
		JSONArray final_response = userActivityService.getfrom3details(LoginUser,ponumber);

		System.out.println("MastersControllerrrr reponse is = " + final_response);
					
			out.print(final_response);
					
			System.out.println("getAllUserDetails GET SUCCESS");
		
	} catch (Exception e) {
		e.printStackTrace();
	}

	finally {
		out.close();
	}

	return null;

	}

@RequestMapping(value = { "/getPoRaisedData" }, method = RequestMethod.POST)
public void getPoRaisedData(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
	System.out.println("Inside getPoRaisedData method");
	
	String crno=request.getParameter("crno");
	 String tid = request.getParameter("tid");
//	int crno1=Integer.parseInt(crno);
	PrintWriter out = null;
	try {
		
		HttpSession htt = request.getSession(true);
        String uname = (String) htt.getAttribute("username");
        System.out.println("usernamemeeem login==" + uname);
        System.out.println("usernamemeeem login==" + crno);
        System.out.println("usernamemeeem login==" + tid);

		out = response.getWriter();
		JSONArray array = (JSONArray) userActivityService.getPoRaisedData(crno,uname,tid);
		System.out.println("List value: "+array);
		out.print(array);
	}
	catch(Exception e) {
		System.out.println("Exception in getAttachmentCSData method: "+e);
	}
	
}


@RequestMapping(value = { "/SendReviseProposalList" }, method = RequestMethod.POST)
public JSONArray SendReviseProposalList(ModelMap model, HttpServletRequest request, HttpServletResponse response,HttpSession session) {
	
	PrintWriter out = null;

	try {
		out = response.getWriter();
		
		 String uname = (String) session.getAttribute("username");
		 String company = (String) session.getAttribute("usercompany");
		JSONArray final_response = userActivityService.SendReviseProposalList(uname,company);

		System.out.println("MastersControllerrrr reponse is = " + final_response);
					
			out.print(final_response);
					
			System.out.println("username GET SUCCESS");
		
	} catch (Exception e) {
		e.printStackTrace();
	}

	finally {
		out.close();
	}
//	return "Dashboard";
	return null;
	
}

@RequestMapping(value = { "/getReviseProposalListData" }, method = RequestMethod.POST)
public void getReviseProposalListData(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
	System.out.println("Inside getReviseProposalListData method");

	String crno = request.getParameter("crno");
	String tid = request.getParameter("tid");
//	int crno1=Integer.parseInt(crno);
	PrintWriter out = null;
	try {

		HttpSession htt = request.getSession(true);
		String uname = (String) htt.getAttribute("username");
		System.out.println("usernamemeeem login==" + uname);
		System.out.println("usernamemeeem login==" + crno);
		System.out.println("usernamemeeem login==" + tid);

		out = response.getWriter();
		JSONArray array = (JSONArray) userActivityService.getReviseProposalListData(crno, uname, tid);
		System.out.println("List value: " + array);
		out.print(array);
	} catch (Exception e) {
		System.out.println("Exception in getAttachmentCSData method: " + e);
	}

}



@RequestMapping(value = {"/SubmitReviseProposal"},method = RequestMethod.POST )
public String submitReviseProposal(HttpServletRequest request, HttpServletResponse response,HttpSession session)
{
	PrintWriter out=null;
	try {
		out=response.getWriter();
		
		
		String uname = (String) session.getAttribute("username");
		String company = (String) session.getAttribute("usercompany");
       System.out.println("usernamemeeem login==" + uname);
       
   
		
		String veloxdata=request.getParameter("veloxdata");
		String poinitiator=request.getParameter("poinitiator");
		String poinitiatorno=request.getParameter("poinitiatorno");
		String FirstApprovername=request.getParameter("FirstApprovername");
		
		String firstapprovercontact=request.getParameter("firstapprovercontact");
		String secondApprovername=request.getParameter("secondApprovername");
		String secondapprovercontact=request.getParameter("secondapprovercontact");
		String clientname=request.getParameter("clientname");
		String Description=request.getParameter("Description");
		String totalpriceforallproduct =request.getParameter("totalpriceforallproduct");
		String deploysupport =request.getParameter("deploysupport");
		String clouddeploycharges =request.getParameter("clouddeploycharges");
		String subtotalB =request.getParameter("subtotalB");
		String resoucesamount=request.getParameter("resoucesamount");
		String ATC=request.getParameter("ATC");
		String subtotalAB=request.getParameter("subtotalAB");
		
		String Proposaltype =request.getParameter("Proposaltype");
		String Perpetualyear=request.getParameter("Perpetualyear");
		String Subscriptionyear =request.getParameter("Subscriptionyear");					
		String Amcsecondyear=request.getParameter("Amcsecondyear");
		String Amcthirdyear=request.getParameter("Amcthirdyear");
		String Amcfourthyear=request.getParameter("Amcfourthyear");
		String Amcfiveyear=request.getParameter("Amcfiveyear");
		String secondyearsubscription=request.getParameter("secondyearsubscription");
		String thirdyearsubscription=request.getParameter("thirdyearsubscription");	
		
		   String productsuitselect=request.getParameter("productsuitselect");
		    String Scanplusprodversion=request.getParameter("Scanplusprodversion");
		    String SecureITprodversion=request.getParameter("SecureITprodversion");
		    String enccustomername=request.getParameter("enccustomername");
		    String fixedyear=request.getParameter("fixedyear");
		    
						
		
		
		String folderPath = "/WEB-INF/VeloxProposalPDF/veloxlogo.png";
	    String fullPathVlxLogo = servletContext.getRealPath(folderPath);
	    String fullPathVlxEnd = servletContext.getRealPath("/WEB-INF/VeloxProposalPDF/end.png");
	    String fullPathSwachBharat = servletContext.getRealPath("/WEB-INF/VeloxProposalPDF/swachBharat.png");
	    String Letterhead = servletContext.getRealPath("/WEB-INF/VeloxProposalPDF/Letterhead.PNG");
	    String signature = servletContext.getRealPath("/WEB-INF/VeloxProposalPDF/signature.PNG");
	    System.out.println("fullPath "+fullPathVlxLogo);
	    System.out.println("signature "+signature);
	    
	    String IntegrationchargeYesNo = request.getParameter("IntegrationCharges");
	    String IntegrationCharges = request.getParameter("integrationcharge");
	    String Total_C=request.getParameter("totalc");
	    String GSTPERCENTAGE=request.getParameter("total18percentage");
	    String Grand_Total=request.getParameter("grandtotal");
		
		String crno =request.getParameter("crno");
		String tid =request.getParameter("tid");
		String SInote=request.getParameter("SInote");
		
		String amcstartdate = request.getParameter("amcstartdate");
		String AMCmonthyear = request.getParameter("AMCmonthyear");
		String AMCMonth = request.getParameter("AMCMonth");
		String AMCYear = request.getParameter("AMCYear");
		String amcenddate = request.getParameter("amcenddate");
		String productsuitdetails = request.getParameter("productsuitdetails");
		String securitysolutiondetails = request.getParameter("securitysolutiondetails");
		String descforamc = request.getParameter("descforamc");
		String totalcostAMC = request.getParameter("totalcostAMC");
		String GRANDTOTALFORAMC = request.getParameter("GRANDTOTALFORAMC");
		String gstforamc = request.getParameter("gstforamc");
		
		String subtotalAResource = request.getParameter("subtotalAResource");
		String gstdataforresource = request.getParameter("gstdataforresource");
		String grandtotalforresource = request.getParameter("grandtotalforresource");
		
		String contactperson = request.getParameter("contactperson");
					
	   
		String veloxdata1 = request.getParameter("veloxdata1");
		String subscriptionANDperpetualYear = request.getParameter("subscriptionANDperpetualYear");
		String perpetualSubsAnnualperpType = request.getParameter("perpetualSubsAnnualperpType");
		String perpetualSubs3yearperpType = request.getParameter("perpetualSubs3yearperpType");
		String deploysupport21 = request.getParameter("deploysupport21");
		String clouddeploycharges21 = request.getParameter("clouddeploycharges21");
		String IntegrationCharges21 = request.getParameter("IntegrationCharges21");
		String integrationcharge21 = request.getParameter("integrationcharge21");
		String subtotalB21 = request.getParameter("subtotalB21");
		String totalc21 = request.getParameter("totalc21");
		String total18percentage21 = request.getParameter("total18percentage21");
		String grandtotal21 = request.getParameter("grandtotal21");
		String resoucesamount21 = request.getParameter("resoucesamount21");
					
	   
//		String finals=userActivityService.veloxproposalUpdateDetails(veloxdata,poinitiator,poinitiatorno,FirstApprovername,firstapprovercontact,secondApprovername,secondapprovercontact,clientname,
//				Description,totalpriceforallproduct,deploysupport,clouddeploycharges,subtotalB,subtotalAB,uname,crno,tid,SInote);
		String finals=userActivityService.submitReviseProposal(veloxdata,poinitiator,poinitiatorno,FirstApprovername,firstapprovercontact,secondApprovername,secondapprovercontact,clientname,Description,totalpriceforallproduct,deploysupport,clouddeploycharges,subtotalB,subtotalAB,uname,resoucesamount,ATC,Proposaltype,Perpetualyear,
				Subscriptionyear,Amcsecondyear,Amcthirdyear,Amcfourthyear,Amcfiveyear,secondyearsubscription,thirdyearsubscription,fullPathVlxLogo,fullPathVlxEnd,fullPathSwachBharat,
				IntegrationchargeYesNo,IntegrationCharges,Total_C,GSTPERCENTAGE,Grand_Total,productsuitselect,Scanplusprodversion,SecureITprodversion,enccustomername,Letterhead,signature,fixedyear,crno,tid,SInote,amcstartdate,AMCmonthyear,AMCMonth,AMCYear,
				amcenddate,productsuitdetails,securitysolutiondetails,descforamc,totalcostAMC,GRANDTOTALFORAMC,gstforamc,
				gstdataforresource ,grandtotalforresource ,subtotalAResource,contactperson,veloxdata1 , subscriptionANDperpetualYear , perpetualSubsAnnualperpType, perpetualSubs3yearperpType, deploysupport21 , clouddeploycharges21 , 
				 IntegrationCharges21 , integrationcharge21 ,  subtotalB21 ,  totalc21 ,  total18percentage21 ,  grandtotal21 , resoucesamount21);
		out.print(finals);
	}
	catch (IOException e)
	{
		e.printStackTrace();
	}
return null;

}


@RequestMapping(value = { "/reviseProposalSendBySIDetails" }, method = RequestMethod.POST)
public JSONArray reviseProposalSendBySIDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,HttpSession session) {
	
	PrintWriter out = null;

	try {
		out = response.getWriter();
		
		 String uname = (String) session.getAttribute("username");
		 String company = (String) session.getAttribute("usercompany");
		JSONArray final_response = userActivityService.reviseProposalSendBySIDetails(uname,company);

		System.out.println("MastersControllerrrr reponse is = " + final_response);
					
			out.print(final_response);
					
			System.out.println("username GET SUCCESS");
		
	} catch (Exception e) {
		e.printStackTrace();
	}

	finally {
		out.close();
	}
//	return "Dashboard";
	return null;
	
}

@RequestMapping(value = { "/getReviseProposalSIsendData" }, method = RequestMethod.POST)
public void getReviseProposalSIsendData(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
	System.out.println("Inside getReviseProposalSIsendData method");
	
	String crno=request.getParameter("crno");
	 String tid = request.getParameter("tid");
//	int crno1=Integer.parseInt(crno);
	PrintWriter out = null;
	try {
		
		HttpSession htt = request.getSession(true);
        String uname = (String) htt.getAttribute("username");
        System.out.println("usernamemeeem login==" + uname);
        System.out.println("usernamemeeem login==" + crno);
        System.out.println("usernamemeeem login==" + tid);

		out = response.getWriter();
		JSONArray array = (JSONArray) userActivityService.getReviseProposalSIsendData(crno,uname,tid);
		System.out.println("List value: "+array);
		out.print(array);
	}
	catch(Exception e) {
		System.out.println("Exception in getAttachmentCSData method: "+e);
	}
	
}

@RequestMapping(value = { "/vlxProposalaprdetails" }, method = RequestMethod.POST)
public JSONArray vlxProposalaprdetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,HttpSession session) {
	
	PrintWriter out = null;

	try {
		out = response.getWriter();
		
		 String uname = (String) session.getAttribute("username");
		 String company = (String) session.getAttribute("usercompany");
		 String role = (String) session.getAttribute("role");
		 String userfullname = (String) session.getAttribute("fullname");
		 
		JSONArray final_response = userActivityService.vlxProposalaprdetails(uname,company,role,userfullname);

		System.out.println("MastersControllerrrr reponse is = " + final_response);
					
			out.print(final_response);
					
			System.out.println("username GET SUCCESS");
		
	} catch (Exception e) {
		e.printStackTrace();
	}

	finally {
		out.close();
	}
//	return "Dashboard";
	return null;
	
}

@RequestMapping(value = { "/purchaseorderdetails" }, method = RequestMethod.POST)
public JSONArray purchaseorderdetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,HttpSession session) {
	
	PrintWriter out = null;

	try {
		out = response.getWriter();
		
		 String uname = (String) session.getAttribute("username");
		 String company = (String) session.getAttribute("usercompany");
		 String role = (String) session.getAttribute("role");
		JSONArray final_response = userActivityService.purchaseorderdetails(uname,company,role);

		System.out.println("MastersControllerrrr reponse is = " + final_response);
					
			out.print(final_response);
					
			System.out.println("username GET SUCCESS");
		
	} catch (Exception e) {
		e.printStackTrace();
	}

	finally {
		out.close();
	}
//	return "Dashboard";
	return null;
	
}



////////////////////////////            Revise Propsal  2 

@RequestMapping(value = { "/revisedProposalPendingListSM" }, method = RequestMethod.POST)
public JSONArray revisedProposalPendingListSM(ModelMap model, HttpServletRequest request, HttpServletResponse response,HttpSession session) {
	System.out.println("Inside cm details Controller@@@@@@@@@@@@ ");
	PrintWriter out = null;

	try {
		out = response.getWriter();
		
		 String uname = (String) session.getAttribute("username");
		 String company = (String) session.getAttribute("usercompany");
		 String userfullname = (String) session.getAttribute("fullname");
		 
		JSONArray final_response = userActivityService.revisedProposalPendingListSM(uname,company,userfullname);

		System.out.println("MastersControllerrrr reponse is = " + final_response);
					
			out.print(final_response);
					
			System.out.println("username GET SUCCESS");
		
	} catch (Exception e) {
		e.printStackTrace();
	}

	finally {
		out.close();
	}
//	return "Dashboard";
	return null;
	
}

@RequestMapping(value = { "/getRevisedProposalPendingDataSM" }, method = RequestMethod.POST)
public void getRevisedProposalPendingDataSM(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
	System.out.println("Inside getRevisedProposalPendingDataSM method");
	
	String crno=request.getParameter("crno");
	 String tid = request.getParameter("tid");
//	int crno1=Integer.parseInt(crno);
	PrintWriter out = null;
	try {
		
		HttpSession htt = request.getSession(true);
       String uname = (String) htt.getAttribute("username");
       System.out.println("usernamemeeem login==" + uname);
       System.out.println("usernamemeeem login==" + crno);
       System.out.println("usernamemeeem login==" + tid);

		out = response.getWriter();
		JSONArray array = (JSONArray) userActivityService.getRevisedProposalPendingDataSM(crno,uname,tid);
		System.out.println("List value: "+array);
		out.print(array);
	}
	catch(Exception e) {
		System.out.println("Exception in getAttachmentCSData method: "+e);
	}
	
}

@RequestMapping(value = { "/revisedProposalApproveListSM" }, method = RequestMethod.POST)
public void revisedProposalApproveListSM(ModelMap model, HttpServletRequest request, HttpServletResponse response,HttpSession session) {
	System.out.println("Inside revisedProposalApproveListSM method");
	
	PrintWriter out = null;
	try {
		
		String uname = (String) session.getAttribute("username");
		String company = (String) session.getAttribute("usercompany");
		String userfullname = (String) session.getAttribute("fullname");
       System.out.println("usernamemeeem login==" + uname);

		out = response.getWriter();
		JSONArray array = (JSONArray) userActivityService.revisedProposalApproveListSM(uname,company,userfullname);
		System.out.println("List value: "+array);
		out.print(array);
	}
	catch(Exception e) {
		System.out.println("Exception in ApplicationUserController getBranchList method: "+e);
	}
	
}

@RequestMapping(value = { "/getRevisedProposalApprovedDataSM" }, method = RequestMethod.POST)
public void getRevisedProposalApprovedDataSM(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
	System.out.println("Inside getVlxProposalApprovedData method");
	
	String crno=request.getParameter("crno");
	 String tid = request.getParameter("tid");
//	int crno1=Integer.parseInt(crno);
	PrintWriter out = null;
	try {
		
		HttpSession htt = request.getSession(true);
       String uname = (String) htt.getAttribute("username");
       System.out.println("usernamemeeem login==" + uname);
       System.out.println("usernamemeeem login==" + crno);
       System.out.println("usernamemeeem login==" + tid);

		out = response.getWriter();
		JSONArray array = (JSONArray) userActivityService.getRevisedProposalApprovedDataSM(crno,uname,tid);
		System.out.println("List value: "+array);
		out.print(array);
	}
	catch(Exception e) {
		System.out.println("Exception in getAttachmentCSData method: "+e);
	}
	
}

@RequestMapping(value = { "/UpdateRevisedPropSMApprove" }, method = RequestMethod.POST)
public void UpdateRevisedPropSMApprove(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
	System.out.println("Inside UpdateVlxPropSaleMangApprove method");

	String crno = request.getParameter("crno");
	String status = request.getParameter("status");
	String tid = request.getParameter("tid");
	String SMnote = request.getParameter("SMnote");

	PrintWriter out = null;
	try {
		HttpSession htt = request.getSession(true);
		String uname = (String) htt.getAttribute("username");
		String company = (String) htt.getAttribute("usercompany");
	  String userfullname = (String) htt.getAttribute("fullname");
		System.out.println("usernamemeeem login==" + uname);
		System.out.println("userfullname userfullname==" + userfullname);

		out = response.getWriter();
		String result = userActivityService.UpdateRevisedPropSMApprove(crno, status, tid, uname, company,SMnote,userfullname);
		System.out.println("Result value: " + result);
		out.print(result);
	} catch (Exception e) {
		System.out.println("Exception in Asave Company: " + e);
	}

}

@RequestMapping(value = { "/revisedProposalRejectedListSM" }, method = RequestMethod.POST)
public void revisedProposalRejectedListSM(ModelMap model, HttpServletRequest request, HttpServletResponse response,
		HttpSession session) {
	System.out.println("Inside revisedProposalRejectedListSM method");

	PrintWriter out = null;
	try {

		String uname = (String) session.getAttribute("username");
		String company = (String) session.getAttribute("usercompany");
		String userfullname = (String) session.getAttribute("fullname");
		System.out.println("usernamemeeem login==" + uname);

		out = response.getWriter();
		JSONArray array = (JSONArray) userActivityService.revisedProposalRejectedListSM(uname, company,userfullname);
		System.out.println("List value: " + array);
		out.print(array);
	} catch (Exception e) {
		System.out.println("Exception in ApplicationUserController getBranchList method: " + e);
	}

}

@RequestMapping(value = { "/getRevisedProposalRejectedDataSM" }, method = RequestMethod.POST)
public void getRevisedProposalRejectedDataSM(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
	System.out.println("Inside getVlxProposalSMRejectedData method");

	String crno = request.getParameter("crno");
	String tid = request.getParameter("tid");
//	int crno1=Integer.parseInt(crno);
	PrintWriter out = null;
	try {

		HttpSession htt = request.getSession(true);
		String uname = (String) htt.getAttribute("username");
		System.out.println("usernamemeeem login==" + uname);
		System.out.println("usernamemeeem login==" + crno);
		System.out.println("usernamemeeem login==" + tid);

		out = response.getWriter();
		JSONArray array = (JSONArray) userActivityService.getRevisedProposalRejectedDataSM(crno, uname, tid);
		System.out.println("List value: " + array);
		out.print(array);
	} catch (Exception e) {
		System.out.println("Exception in getAttachmentCSData method: " + e);
	}

}


@RequestMapping(value = { "/RejectRevisedProposalSM" }, method = RequestMethod.POST)
public void RejectRevisedProposalSM(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
	System.out.println("Inside ccreject method");

	String crno = request.getParameter("crno");
   String rejectreason = request.getParameter("val");
	String SMnote = request.getParameter("SMnote");
   String tid = request.getParameter("tid");

	PrintWriter out = null;
	try {
		HttpSession htt = request.getSession(true);
		String uname = (String) htt.getAttribute("username");
		String company = (String) htt.getAttribute("usercompany");
		System.out.println("usernamemeeem login==" + uname);
		System.out.println("company login==" + company);
		out = response.getWriter();
		String result = userActivityService.RejectRevisedProposalSM(crno,company,rejectreason,SMnote,uname,tid);
		System.out.println("Result value: "+result);
		out.print(result);
	} catch (Exception e) {
		System.out.println("Exception in Asave Company: " + e);
	}

}

@RequestMapping(value = { "/revisedProposalRejectedListSI" }, method = RequestMethod.POST)
public void revisedProposalRejectedListSI(ModelMap model, HttpServletRequest request, HttpServletResponse response,
		HttpSession session) {
	System.out.println("Inside revisedProposalRejectedListSI method");

	PrintWriter out = null;
	try {

		String uname = (String) session.getAttribute("username");
		String company = (String) session.getAttribute("usercompany");
		String fullname = (String) session.getAttribute("fullname");
		System.out.println("usernamemeeem login==" + uname);

		out = response.getWriter();
		JSONArray array = (JSONArray) userActivityService.revisedProposalRejectedListSI(uname, company,fullname);
		System.out.println("List value: " + array);
		out.print(array);
	} catch (Exception e) {
		System.out.println("Exception in ApplicationUserController getBranchList method: " + e);
	}

}


@RequestMapping(value = { "/getRevisedProposalRejectedDataSI" }, method = RequestMethod.POST)
public void getRevisedProposalRejectedDataSI(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
	System.out.println("Inside getRevisedProposalRejectedDataSI method");

	String crno = request.getParameter("crno");
	String tid = request.getParameter("tid");
//	int crno1=Integer.parseInt(crno);
	PrintWriter out = null;
	try {

		HttpSession htt = request.getSession(true);
		String uname = (String) htt.getAttribute("username");
		System.out.println("usernamemeeem login==" + uname);
		System.out.println("usernamemeeem login==" + crno);
		System.out.println("usernamemeeem login==" + tid);

		out = response.getWriter();
		JSONArray array = (JSONArray) userActivityService.getRevisedProposalRejectedDataSI(crno, uname, tid);
		System.out.println("List value: " + array);
		out.print(array);
	} catch (Exception e) {
		System.out.println("Exception in getAttachmentCSData method: " + e);
	}

}


@RequestMapping(value = {"/rejectedRevisedProposalUpdateSI"},method = RequestMethod.POST )
public String rejectedRevisedProposalUpdateSI(HttpServletRequest request, HttpServletResponse response,HttpSession session)
{
	PrintWriter out=null;
	try {
		out=response.getWriter();
		
		
		String uname = (String) session.getAttribute("username");
		String company = (String) session.getAttribute("usercompany");
      System.out.println("usernamemeeem login==" + uname);
      
  
		
		String veloxdata=request.getParameter("veloxdata");
		String poinitiator=request.getParameter("poinitiator");
		String poinitiatorno=request.getParameter("poinitiatorno");
		String FirstApprovername=request.getParameter("FirstApprovername");
		
		String firstapprovercontact=request.getParameter("firstapprovercontact");
		String secondApprovername=request.getParameter("secondApprovername");
		String secondapprovercontact=request.getParameter("secondapprovercontact");
		String clientname=request.getParameter("clientname");
		String Description=request.getParameter("Description");
		String totalpriceforallproduct =request.getParameter("totalpriceforallproduct");
		String deploysupport =request.getParameter("deploysupport");
		String clouddeploycharges =request.getParameter("clouddeploycharges");
		String subtotalB =request.getParameter("subtotalB");
		String resoucesamount=request.getParameter("resoucesamount");
		String ATC=request.getParameter("ATC");
		String subtotalAB=request.getParameter("subtotalAB");
		
		String Proposaltype =request.getParameter("Proposaltype");
		String Perpetualyear=request.getParameter("Perpetualyear");
		String Subscriptionyear =request.getParameter("Subscriptionyear");					
		String Amcsecondyear=request.getParameter("Amcsecondyear");
		String Amcthirdyear=request.getParameter("Amcthirdyear");
		String Amcfourthyear=request.getParameter("Amcfourthyear");
		String Amcfiveyear=request.getParameter("Amcfiveyear");
		String secondyearsubscription=request.getParameter("secondyearsubscription");
		String thirdyearsubscription=request.getParameter("thirdyearsubscription");	
		
		   String productsuitselect=request.getParameter("productsuitselect");
		    String Scanplusprodversion=request.getParameter("Scanplusprodversion");
		    String SecureITprodversion=request.getParameter("SecureITprodversion");
		    String enccustomername=request.getParameter("enccustomername");
		    String fixedyear=request.getParameter("fixedyear");
		    
						
		
		
		String folderPath = "/WEB-INF/VeloxProposalPDF/veloxlogo.png";
	    String fullPathVlxLogo = servletContext.getRealPath(folderPath);
	    String fullPathVlxEnd = servletContext.getRealPath("/WEB-INF/VeloxProposalPDF/end.png");
	    String fullPathSwachBharat = servletContext.getRealPath("/WEB-INF/VeloxProposalPDF/swachBharat.png");
	    String Letterhead = servletContext.getRealPath("/WEB-INF/VeloxProposalPDF/Letterhead.PNG");
	    String signature = servletContext.getRealPath("/WEB-INF/VeloxProposalPDF/signature.PNG");
	    System.out.println("fullPath "+fullPathVlxLogo);
	    System.out.println("signature "+signature);
	    
	    String IntegrationchargeYesNo = request.getParameter("IntegrationCharges");
	    String IntegrationCharges = request.getParameter("integrationcharge");
	    String Total_C=request.getParameter("totalc");
	    String GSTPERCENTAGE=request.getParameter("total18percentage");
	    String Grand_Total=request.getParameter("grandtotal");
		
		String crno =request.getParameter("crno");
		String tid =request.getParameter("tid");
		String SInote=request.getParameter("SInote");
		
		
		String amcstartdate = request.getParameter("amcstartdate");
		String AMCmonthyear = request.getParameter("AMCmonthyear");
		String AMCMonth = request.getParameter("AMCMonth");
		String AMCYear = request.getParameter("AMCYear");
		String amcenddate = request.getParameter("amcenddate");
		String productsuitdetails = request.getParameter("productsuitdetails");
		String securitysolutiondetails = request.getParameter("securitysolutiondetails");
		String descforamc = request.getParameter("descforamc");
		String totalcostAMC = request.getParameter("totalcostAMC");
		String GRANDTOTALFORAMC = request.getParameter("GRANDTOTALFORAMC");
		String gstforamc = request.getParameter("gstforamc");
		
		String subtotalAResource = request.getParameter("subtotalAResource");
		String gstdataforresource = request.getParameter("gstdataforresource");
		String grandtotalforresource = request.getParameter("grandtotalforresource");
		
		String contactperson = request.getParameter("contactperson");
					
	   
		String veloxdata1 = request.getParameter("veloxdata1");
		String subscriptionANDperpetualYear = request.getParameter("subscriptionANDperpetualYear");
		String perpetualSubsAnnualperpType = request.getParameter("perpetualSubsAnnualperpType");
		String perpetualSubs3yearperpType = request.getParameter("perpetualSubs3yearperpType");
		String deploysupport21 = request.getParameter("deploysupport21");
		String clouddeploycharges21 = request.getParameter("clouddeploycharges21");
		String IntegrationCharges21 = request.getParameter("IntegrationCharges21");
		String integrationcharge21 = request.getParameter("integrationcharge21");
		String subtotalB21 = request.getParameter("subtotalB21");
		String totalc21 = request.getParameter("totalc21");
		String total18percentage21 = request.getParameter("total18percentage21");
		String grandtotal21 = request.getParameter("grandtotal21");
		String resoucesamount21 = request.getParameter("resoucesamount21");
		
		
		//04/07
		String proposalFor = request.getParameter("proposalFor");
		String PartnerName = request.getParameter("PartnerName");
		//
					
	   
//		String finals=userActivityService.veloxproposalUpdateDetails(veloxdata,poinitiator,poinitiatorno,FirstApprovername,firstapprovercontact,secondApprovername,secondapprovercontact,clientname,
//				Description,totalpriceforallproduct,deploysupport,clouddeploycharges,subtotalB,subtotalAB,uname,crno,tid,SInote);
		String finals=userActivityService.rejectedRevisedProposalUpdateSI(veloxdata,poinitiator,poinitiatorno,FirstApprovername,firstapprovercontact,secondApprovername,secondapprovercontact,clientname,Description,totalpriceforallproduct,deploysupport,clouddeploycharges,subtotalB,subtotalAB,uname,resoucesamount,ATC,Proposaltype,Perpetualyear,
				Subscriptionyear,Amcsecondyear,Amcthirdyear,Amcfourthyear,Amcfiveyear,secondyearsubscription,thirdyearsubscription,fullPathVlxLogo,fullPathVlxEnd,fullPathSwachBharat,
				IntegrationchargeYesNo,IntegrationCharges,Total_C,GSTPERCENTAGE,Grand_Total,productsuitselect,Scanplusprodversion,SecureITprodversion,enccustomername,Letterhead,signature,fixedyear,crno,tid,SInote,amcstartdate,AMCmonthyear,AMCMonth,AMCYear,
				amcenddate,productsuitdetails,securitysolutiondetails,descforamc,totalcostAMC,GRANDTOTALFORAMC,gstforamc,
				gstdataforresource ,grandtotalforresource ,subtotalAResource,contactperson,veloxdata1 , subscriptionANDperpetualYear , perpetualSubsAnnualperpType, perpetualSubs3yearperpType, deploysupport21 , clouddeploycharges21 , 
				 IntegrationCharges21 , integrationcharge21 ,  subtotalB21 ,  totalc21 ,  total18percentage21 ,  grandtotal21 , resoucesamount21, proposalFor, PartnerName);
		out.print(finals);
	}
	catch (IOException e)
	{
		e.printStackTrace();
	}
return null;

}


@RequestMapping(value = { "/revisedProposalPendingDetailsMD" }, method = RequestMethod.POST)
public JSONArray revisedProposalPendingDetailsMD(ModelMap model, HttpServletRequest request, HttpServletResponse response,HttpSession session) {
	System.out.println("Inside  revisedProposalPendingDetailsMD Controller@@@@@@@@@@@@ ");
	PrintWriter out = null;

	try {
		out = response.getWriter();
		
		 String uname = (String) session.getAttribute("username");
		 String company = (String) session.getAttribute("usercompany");
		JSONArray final_response = userActivityService.revisedProposalPendingDetailsMD(uname,company);

		System.out.println("MastersControllerrrr reponse is = " + final_response);
					
			out.print(final_response);
					
			System.out.println("username GET SUCCESS");
		
	} catch (Exception e) {
		e.printStackTrace();
	}

	finally {
		out.close();
	}
//	return "Dashboard";
	return null;
	
}



@RequestMapping(value = { "/getRevisedProposalApprovalDataMD" }, method = RequestMethod.POST)
public void getRevisedProposalApprovalDataMD(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
	System.out.println("Inside getVlxProposalApprovalMDData method");
	
	String crno=request.getParameter("crno");
	 String tid = request.getParameter("tid");
//	int crno1=Integer.parseInt(crno);
	PrintWriter out = null;
	try {
		
		HttpSession htt = request.getSession(true);
        String uname = (String) htt.getAttribute("username");
        System.out.println("usernamemeeem login==" + uname);
        System.out.println("usernamemeeem login==" + crno);
        System.out.println("usernamemeeem login==" + tid);

		out = response.getWriter();
		JSONArray array = (JSONArray) userActivityService.getRevisedProposalApprovalDataMD(crno,uname,tid);
		System.out.println("List value: "+array);
		out.print(array);
	}
	catch(Exception e) {
		System.out.println("Exception in getAttachmentCSData method: "+e);
	}
	
}


@RequestMapping(value = { "/UpdateRevisedProposalApproveMD" }, method = RequestMethod.POST)
public void UpdateRevisedProposalApproveMD(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
	System.out.println("Inside UpdateVlxPropMDApprove method");
	
	 String crno = request.getParameter("crno");
     String status = request.getParameter("status");
     String tid = request.getParameter("tid");
	
	PrintWriter out = null;
	try {
		HttpSession htt = request.getSession(true);
        String uname = (String) htt.getAttribute("username");
        String company = (String) htt.getAttribute("usercompany");
        System.out.println("usernamemeeem login==" + uname);
		
		out = response.getWriter();
		String result = userActivityService.UpdateRevisedProposalApproveMD(crno,status,tid,uname,company);
		System.out.println("Result value: "+result);
		out.print(result);
	}
	catch(Exception e) {
		System.out.println("Exception in Asave Company: "+e);
	}

}

@RequestMapping(value = { "/revisedProposalApproveListMD" }, method = RequestMethod.POST)
public JSONArray revisedProposalApproveListMD(ModelMap model, HttpServletRequest request, HttpServletResponse response,HttpSession session) {
	System.out.println("Inside cm vlxProposalApproveDetails Controller@@@@@@@@@@@@ ");
	PrintWriter out = null;

	try {
		out = response.getWriter();
		
		 String uname = (String) session.getAttribute("username");
		 String company = (String) session.getAttribute("usercompany");
		JSONArray final_response = userActivityService.revisedProposalApproveListMD(uname,company);

		System.out.println("MastersControllerrrr reponse is = " + final_response);
					
			out.print(final_response);
					
			System.out.println("username GET SUCCESS");
		
	} catch (Exception e) {
		e.printStackTrace();
	}

	finally {
		out.close();
	}
//	return "Dashboard";
	return null;
	
}


@RequestMapping(value = { "/getRevisedProposalApprovedDataMD" }, method = RequestMethod.POST)
public void getRevisedProposalApprovedDataMD(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
	System.out.println("Inside getRevisedProposalApprovedDataMD method");
	
	String crno=request.getParameter("crno");
	 String tid = request.getParameter("tid");
//	int crno1=Integer.parseInt(crno);
	PrintWriter out = null;
	try {
		
		HttpSession htt = request.getSession(true);
        String uname = (String) htt.getAttribute("username");
        System.out.println("usernamemeeem login==" + uname);
        System.out.println("usernamemeeem login==" + crno);
        System.out.println("usernamemeeem login==" + tid);

		out = response.getWriter();
		JSONArray array = (JSONArray) userActivityService.getRevisedProposalApprovedDataMD(crno,uname,tid);
		System.out.println("List value: "+array);
		out.print(array);
	}
	catch(Exception e) {
		System.out.println("Exception in getAttachmentCSData method: "+e);
	}
	
}

@RequestMapping(value = { "/updateRegistrationFormList" }, method = RequestMethod.POST)
public JSONArray updateRegistrationFormList(ModelMap model, HttpServletRequest request, HttpServletResponse response,HttpSession session) {
	System.out.println("Inside cm details Controller@@@@@@@@@@@@ ");
	PrintWriter out = null;

	try {
		out = response.getWriter();
		
		 String uname = (String) session.getAttribute("username");
		 String company = (String) session.getAttribute("usercompany");
		
		 
		JSONArray final_response = userActivityService.updateRegistrationFormList(uname,company);

		System.out.println("MastersControllerrrr reponse is = " + final_response);
					
			out.print(final_response);
					
			System.out.println("username GET SUCCESS");
		
	} catch (Exception e) {
		e.printStackTrace();
	}

	finally {
		out.close();
	}
//	return "Dashboard";
	return null;
	
}



@RequestMapping(value = { "/getUpdateRegistrationFormData" }, method = RequestMethod.POST)
public JSONArray getUpdateRegistrationFormData(ModelMap model, HttpServletRequest request,
		HttpServletResponse response, HttpSession session) {
	//System.out.println("Inside getCompositeCompanyList Controller@@@@@@@@@@@@ ");
	PrintWriter out = null;
	
	
	
	String crno=request.getParameter("crno");
	String tid = request.getParameter("tid");
//	int crno1=Integer.parseInt(crno);
	
	try {
		
		HttpSession htt = request.getSession(true);
        String uname = (String) htt.getAttribute("username");
        

		out = response.getWriter();
		JSONArray array = (JSONArray) userActivityService.getUpdateRegistrationFormData(crno,uname,tid);
		
		out.print(array);
	
	}catch (Exception e) {
		e.printStackTrace();
	}

	finally {
		if (out != null)
			out.close();
	}

	return null;

}

@RequestMapping(value = { "/SMrejectPO" }, method = RequestMethod.POST)
public void SMrejectPO(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
	System.out.println("Inside ccreject method");

	String crno = request.getParameter("crno");
    String rejectreason = request.getParameter("val");
	String SMnote = request.getParameter("SMnote");
    String tid = request.getParameter("tid");

	PrintWriter out = null;
	try {
		HttpSession htt = request.getSession(true);
		String uname = (String) htt.getAttribute("username");
		String company = (String) htt.getAttribute("usercompany");
		System.out.println("usernamemeeem login==" + uname);
		System.out.println("company login==" + company);
		out = response.getWriter();
		String result = userActivityService.SMrejectPO(crno,company,rejectreason,SMnote,uname,tid);
		System.out.println("Result value: "+result);
		out.print(result);
	} catch (Exception e) {
		System.out.println("Exception in Asave Company: " + e);
	}

}

@RequestMapping(value = { "/PORejectedBymeDetails" }, method = RequestMethod.POST)
public void PORejectedBymeDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
		HttpSession session) {
	System.out.println("Inside vlxPropRejectedBymeDetails method");

	PrintWriter out = null;
	try {

		String uname = (String) session.getAttribute("username");
		String company = (String) session.getAttribute("usercompany");
		String userfullname = (String) session.getAttribute("fullname");
		System.out.println("usernamemeeem login==" + uname);

		out = response.getWriter();
		JSONArray array = (JSONArray) userActivityService.PORejectedBymeDetails(uname, company,userfullname);
		System.out.println("List value: " + array);
		out.print(array);
	} catch (Exception e) {
		System.out.println("Exception in ApplicationUserController getBranchList method: " + e);
	}

}

@RequestMapping(value = { "/PORejectedSMDetails" }, method = RequestMethod.POST)
public void PORejectedSMDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
		HttpSession session) {
	System.out.println("Inside PORejectedSMDetails method");

	PrintWriter out = null;
	try {

		String uname = (String) session.getAttribute("username");
		String company = (String) session.getAttribute("usercompany");
		String userfullname = (String) session.getAttribute("fullname");
		System.out.println("usernamemeeem login==" + uname);

		out = response.getWriter();
		JSONArray array = (JSONArray) userActivityService.PORejectedSMDetails(uname, company,userfullname);
		System.out.println("List value: " + array);
		out.print(array);
	} catch (Exception e) {
		System.out.println("Exception in ApplicationUserController getBranchList method: " + e);
	}

}

@RequestMapping(value = { "/getPoRejectedSMData" }, method = RequestMethod.POST)
public void getPoRejectedSMData(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
	System.out.println("Inside getPoRaisedData method");
	
	String crno=request.getParameter("crno");
	 String tid = request.getParameter("tid");
//	int crno1=Integer.parseInt(crno);
	PrintWriter out = null;
	try {
		
		HttpSession htt = request.getSession(true);
        String uname = (String) htt.getAttribute("username");
        System.out.println("usernamemeeem login==" + uname);
        System.out.println("usernamemeeem login==" + crno);
        System.out.println("usernamemeeem login==" + tid);

		out = response.getWriter();
		JSONArray array = (JSONArray) userActivityService.getPoRejectedSMData(crno,uname,tid);
		System.out.println("List value: "+array);
		out.print(array);
	}
	catch(Exception e) {
		System.out.println("Exception in getAttachmentCSData method: "+e);
	}
	
}


@RequestMapping(value = { "/getVlxProposalRejectedMDData" }, method = RequestMethod.POST)
public void getVlxProposalRejectedMDData(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
	System.out.println("Inside getVlxProposalApprovalMDData method");
	
	String crno=request.getParameter("crno");
	 String tid = request.getParameter("tid");
//	int crno1=Integer.parseInt(crno);
	PrintWriter out = null;
	try {
		
		HttpSession htt = request.getSession(true);
        String uname = (String) htt.getAttribute("username");
        System.out.println("usernamemeeem login==" + uname);
        System.out.println("usernamemeeem login==" + crno);
        System.out.println("usernamemeeem login==" + tid);

		out = response.getWriter();
		JSONArray array = (JSONArray) userActivityService.getVlxProposalRejectedMDData(crno,uname,tid);
		System.out.println("List value: "+array);
		out.print(array);
	}
	catch(Exception e) {
		System.out.println("Exception in getAttachmentCSData method: "+e);
	}
	
}

@RequestMapping(value = { "/insertRejectedPurchaseOrder" }, method = RequestMethod.POST)
public String insertRejectedPurchaseOrder(@RequestParam("pouploadfile") MultipartFile[] pouploadfile1,@RequestParam("advinvoicefile") MultipartFile[] advinvoicefile1,
		@RequestParam("massPOfile") MultipartFile[] massPOfile1,@RequestParam("productFeaturedFileList") MultipartFile[] productFeaturedFileList,ModelMap model, HttpServletRequest request, HttpServletResponse response,
		HttpSession session, ModelMap modelMap) {
	System.out.println("Inside insertForm2 Controller@@@@@@@@@@@@ ");
	PrintWriter out = null;
	String details = null;
	
	try {
		out = response.getWriter();
		
		String loginuser=(String)session.getAttribute("username");
		String loginUserCompany = session.getAttribute("companyname").toString();
		
       // String pouploadfile = request.getParameter("pouploadfile");
		
		String potype = request.getParameter("potype");
		String proposalType = request.getParameter("proposalType");
	    String proposalids = request.getParameter("proposalids");
	    String vpuploadfileProposal = request.getParameter("vpuploadfileProposal");
	        
       
	    String ponumber = request.getParameter("ponumber");
	    String podate = request.getParameter("podate");
	    String customername = request.getParameter("customername");
	    String productsuit = request.getParameter("selectedSideBarValuesFinalprodSuit");		        
    	String securitytool = request.getParameter("selectedSideBarValuesFinalSECTool");
        String paymentterms = request.getParameter("paymentterms");
        String prodliscense = request.getParameter("prodliscense");
        String prodamount = request.getParameter("prodamount");
     
        String advaninvoice = request.getParameter("advaninvoice");
        String advinvoicefile = request.getParameter("advinvoicefile");
        String proddescrip = request.getParameter("proddescrip");
        
      
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
        
        String sInote = request.getParameter("SInote");
        String firstApprover = request.getParameter("firstApprover");
        String SecondApprovername = request.getParameter("SecondApprovername");


       
        System.out.println(" productsuit data :"+productsuit);
        System.out.println(" securitytool data :"+securitytool);
        System.out.println(" proposalType data :"+proposalType+" proposalids data :"+
        proposalids+" vpuploadfileProposal data :"+vpuploadfileProposal);

        
        String fixedyear = request.getParameter("fixedyear");
        String subscriptionyear = request.getParameter("Subscriptionyear");
        String perpetualyear = request.getParameter("Perpetualyear");
        String crno = request.getParameter("crno");
        String tid = request.getParameter("tid");
        

		String final_response = userActivityService.insertRejectedPurchaseOrder(pouploadfile1, proddescrip, customername, paymentterms, prodliscense,
				prodamount, warrantystart, warrantyend, advaninvoice, advinvoicefile1,loginuser,loginUserCompany, proposalType,proposalids,vpuploadfileProposal,
	 potype, ponumber, podate, amcstartdate, amcenddate,  productsuit,
	 securitytool,warrantyMonth,warrantyYear,AMCMonth,AMCYear,sInote,tennurestartdate,tennureenddate,tennureMonth,tennureYear,firstApprover,SecondApprovername,fixedyear,subscriptionyear,perpetualyear,crno,tid,massPOfile1,productFeaturedFileList);

		System.out.println("MastersControllerrrr reponse is = " + final_response);							
			out.print(final_response);
						
			System.out.println("insertFormA GET SUCCESS");
		
	} catch (Exception e) {
		e.printStackTrace();
	}

	finally {
		out.close();
	}

	return null;

}


@RequestMapping(value = { "/getApprovedPoData" }, method = RequestMethod.POST)
public void getApprovedPoData(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
	System.out.println("Inside getApprovedPoData method");
	
	String crno=request.getParameter("crno");
	 String tid = request.getParameter("tid");
//	int crno1=Integer.parseInt(crno);
	PrintWriter out = null;
	try {
		
		HttpSession htt = request.getSession(true);
        String uname = (String) htt.getAttribute("username");
        System.out.println("usernamemeeem login==" + uname);
        System.out.println("usernamemeeem login==" + crno);
        System.out.println("usernamemeeem login==" + tid);

		out = response.getWriter();
		JSONArray array = (JSONArray) userActivityService.getApprovedPoData(crno,uname,tid);
		System.out.println("List value: "+array);
		out.print(array);
	}
	catch(Exception e) {
		System.out.println("Exception in getAttachmentCSData method: "+e);
	}
	
}




@RequestMapping(value = { "/createdVeloxLicenseDetails" }, method = RequestMethod.POST)
public JSONArray createdVeloxLicenseDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,HttpSession session) {
	
	PrintWriter out = null;

	try {
		out = response.getWriter();
		
		 String uname = (String) session.getAttribute("username");
		 String company = (String) session.getAttribute("usercompany");
		JSONArray final_response = userActivityService.createdVeloxLicenseDetails(uname,company);

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




///  getVlxLicenseData  



@RequestMapping(value = { "/getVlxLicenseData" }, method = RequestMethod.POST)
public void getVlxLicenseData(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
	System.out.println("Inside getVlxLicenseData method");
	
	String crno=request.getParameter("crno");
	 String tid = request.getParameter("tid");
//	int crno1=Integer.parseInt(crno);
	PrintWriter out = null;
	try {
		
		HttpSession htt = request.getSession(true);
        String uname = (String) htt.getAttribute("username");
        System.out.println("usernamemeeem login==" + uname);
        System.out.println("usernamemeeem login==" + crno);
        System.out.println("usernamemeeem login==" + tid);

		out = response.getWriter();
		JSONArray array = (JSONArray) userActivityService.getVlxLicenseData(crno,uname,tid);
		System.out.println("List value: "+array);
		out.print(array);
	}
	catch(Exception e) {
		System.out.println("Exception in getAttachmentCSData method: "+e);
	}
	
}

@RequestMapping(value = { "/getPoRejectedDataSM" }, method = RequestMethod.POST)
public void getPoRejectedDataSM(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
	System.out.println("Inside getPoRaisedData method");
	
	String crno=request.getParameter("crno");
	 String tid = request.getParameter("tid");
//	int crno1=Integer.parseInt(crno);
	PrintWriter out = null;
	try {
		
		HttpSession htt = request.getSession(true);
        String uname = (String) htt.getAttribute("username");
        System.out.println("usernamemeeem login==" + uname);
        System.out.println("usernamemeeem login==" + crno);
        System.out.println("usernamemeeem login==" + tid);

		out = response.getWriter();
		JSONArray array = (JSONArray) userActivityService.getPoRejectedDataSM(crno,uname,tid);
		System.out.println("List value: "+array);
		out.print(array);
	}
	catch(Exception e) {
		System.out.println("Exception in getAttachmentCSData method: "+e);
	}
	
}

@RequestMapping(value = { "/proposalLicensePendingDetails" }, method = RequestMethod.POST)
public JSONArray proposalLicensePendingDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,HttpSession session) {
	System.out.println("Inside cm details Controller@@@@@@@@@@@@ ");
	PrintWriter out = null;

	try {
		out = response.getWriter();
		
		 String uname = (String) session.getAttribute("username");
		 String company = (String) session.getAttribute("usercompany");
		 String userfullname = (String) session.getAttribute("fullname");
		 
		JSONArray final_response = userActivityService.proposalLicensePendingDetails(uname,company,userfullname);

		System.out.println("MastersControllerrrr reponse is = " + final_response);
					
			out.print(final_response);
					
			System.out.println("username GET SUCCESS");
		
	} catch (Exception e) {
		e.printStackTrace();
	}

	finally {
		out.close();
	}
//	return "Dashboard";
	return null;
	
}

@RequestMapping(value = { "/getProposalLicenseDataSM" }, method = RequestMethod.POST)
public void getProposalLicenseDataSM(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
	System.out.println("Inside getVlxLicenseData method");
	
	String crno=request.getParameter("crno");
	 String tid = request.getParameter("tid");
//	int crno1=Integer.parseInt(crno);
	PrintWriter out = null;
	try {
		
		HttpSession htt = request.getSession(true);
        String uname = (String) htt.getAttribute("username");
        System.out.println("usernamemeeem login==" + uname);
        System.out.println("usernamemeeem login==" + crno);
        System.out.println("usernamemeeem login==" + tid);

		out = response.getWriter();
		JSONArray array = (JSONArray) userActivityService.getProposalLicenseDataSM(crno,uname,tid);
		System.out.println("List value: "+array);
		out.print(array);
	}
	catch(Exception e) {
		System.out.println("Exception in getAttachmentCSData method: "+e);
	}
	
}

@RequestMapping(value = { "/ApproveProposalLicenseSM" }, method = RequestMethod.POST)
public void ApproveProposalLicenseSM(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
	System.out.println("Inside UpdateVlxPropSaleMangApprove method");

	String crno = request.getParameter("crno");
	String status = request.getParameter("status");
	String tid = request.getParameter("tid");
	String SMnote = request.getParameter("SMnote");

	PrintWriter out = null;
	try {
		HttpSession htt = request.getSession(true);
		String uname = (String) htt.getAttribute("username");
		String company = (String) htt.getAttribute("usercompany");
		System.out.println("usernamemeeem login==" + uname);

		out = response.getWriter();
		String result = userActivityService.ApproveProposalLicenseSM(crno, status, tid, uname, company,SMnote);
		System.out.println("Result value: " + result);
		out.print(result);
	} catch (Exception e) {
		System.out.println("Exception in Asave Company: " + e);
	}

}

@RequestMapping(value = { "/proposalLicenseApprovedDetailsSM" }, method = RequestMethod.POST)
public void proposalLicenseApprovedDetailsSM(ModelMap model, HttpServletRequest request, HttpServletResponse response,HttpSession session) {
	System.out.println("Inside proposalLicenseApprovedDetailsSM method");
	
	PrintWriter out = null;
	try {
		
		String uname = (String) session.getAttribute("username");
		String company = (String) session.getAttribute("usercompany");
		String userfullname = (String) session.getAttribute("fullname");
        System.out.println("usernamemeeem login==" + uname);

		out = response.getWriter();
		JSONArray array = (JSONArray) userActivityService.proposalLicenseApprovedDetailsSM(uname,company,userfullname);
		System.out.println("List value: "+array);
		out.print(array);
	}
	catch(Exception e) {
		System.out.println("Exception in ApplicationUserController getBranchList method: "+e);
	}
	
}


@RequestMapping(value = { "/getProposalLicenseApprovedDataSM" }, method = RequestMethod.POST)
public void getProposalLicenseApprovedDataSM(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
	System.out.println("Inside getVlxLicenseData method");
	
	String crno=request.getParameter("crno");
	 String tid = request.getParameter("tid");
//	int crno1=Integer.parseInt(crno);
	PrintWriter out = null;
	try {
		
		HttpSession htt = request.getSession(true);
        String uname = (String) htt.getAttribute("username");
        System.out.println("usernamemeeem login==" + uname);
        System.out.println("usernamemeeem login==" + crno);
        System.out.println("usernamemeeem login==" + tid);

		out = response.getWriter();
		JSONArray array = (JSONArray) userActivityService.getProposalLicenseApprovedDataSM(crno,uname,tid);
		System.out.println("List value: "+array);
		out.print(array);
	}
	catch(Exception e) {
		System.out.println("Exception in getAttachmentCSData method: "+e);
	}
	
}


@RequestMapping(value = { "/proposalLicensePendingDetailsBH" }, method = RequestMethod.POST)
public JSONArray proposalLicensePendingDetailsBH(ModelMap model, HttpServletRequest request, HttpServletResponse response,HttpSession session) {
	System.out.println("Inside cm details Controller@@@@@@@@@@@@ ");
	PrintWriter out = null;

	try {
		out = response.getWriter();
		
		 String uname = (String) session.getAttribute("username");
		 String company = (String) session.getAttribute("usercompany");
		 String userfullname = (String) session.getAttribute("fullname");
		 
		JSONArray final_response = userActivityService.proposalLicensePendingDetailsBH(uname,company,userfullname);

		System.out.println("MastersControllerrrr reponse is = " + final_response);
					
			out.print(final_response);
					
			System.out.println("username GET SUCCESS");
		
	} catch (Exception e) {
		e.printStackTrace();
	}

	finally {
		out.close();
	}
//	return "Dashboard";
	return null;
	
}

@RequestMapping(value = { "/getProposalLicenseDataBH" }, method = RequestMethod.POST)
public void getProposalLicenseDataBH(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
	System.out.println("Inside getVlxLicenseData method");
	
	String crno=request.getParameter("crno");
	 String tid = request.getParameter("tid");
//	int crno1=Integer.parseInt(crno);
	PrintWriter out = null;
	try {
		
		HttpSession htt = request.getSession(true);
        String uname = (String) htt.getAttribute("username");
        System.out.println("usernamemeeem login==" + uname);
        System.out.println("usernamemeeem login==" + crno);
        System.out.println("usernamemeeem login==" + tid);

		out = response.getWriter();
		JSONArray array = (JSONArray) userActivityService.getProposalLicenseDataBH(crno,uname,tid);
		System.out.println("List value: "+array);
		out.print(array);
	}
	catch(Exception e) {
		System.out.println("Exception in getAttachmentCSData method: "+e);
	}
	
}


@RequestMapping(value = { "/ApproveProposalLicenseBH" }, method = RequestMethod.POST)
public void ApproveProposalLicenseBH(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
	System.out.println("Inside UpdateVlxPropSaleMangApprove method");

	String crno = request.getParameter("crno");
	String status = request.getParameter("status");
	String tid = request.getParameter("tid");
	String BHnote = request.getParameter("BHnote");

	PrintWriter out = null;
	try {
		HttpSession htt = request.getSession(true);
		String uname = (String) htt.getAttribute("username");
		String company = (String) htt.getAttribute("usercompany");
		System.out.println("usernamemeeem login==" + uname);

		out = response.getWriter();
		String result = userActivityService.ApproveProposalLicenseBH(crno, status, tid, uname, company,BHnote);
		System.out.println("Result value: " + result);
		out.print(result);
	} catch (Exception e) {
		System.out.println("Exception in Asave Company: " + e);
	}

}
@RequestMapping(value = { "/proposalLicenseApprovedDetailsBH" }, method = RequestMethod.POST)
public void proposalLicenseApprovedDetailsBH(ModelMap model, HttpServletRequest request, HttpServletResponse response,HttpSession session) {
	System.out.println("Inside proposalLicenseApprovedDetailsSM method");
	
	PrintWriter out = null;
	try {
		
		String uname = (String) session.getAttribute("username");
		String company = (String) session.getAttribute("usercompany");
		String userfullname = (String) session.getAttribute("fullname");
		String roletype = (String) session.getAttribute("role");
        System.out.println("usernamemeeem login==" + uname);

		out = response.getWriter();
		JSONArray array = (JSONArray) userActivityService.proposalLicenseApprovedDetailsBH(uname,company,userfullname, roletype );
		System.out.println("List value: "+array);
		out.print(array);
	}
	catch(Exception e) {
		System.out.println("Exception in ApplicationUserController getBranchList method: "+e);
	}
	
}


@RequestMapping(value = { "/getProposalLicenseApprovedDataBH" }, method = RequestMethod.POST)
public void getProposalLicenseApprovedDataBH(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
	System.out.println("Inside getVlxLicenseData method");
	
	String crno=request.getParameter("crno");
	 String tid = request.getParameter("tid");
//	int crno1=Integer.parseInt(crno);
	PrintWriter out = null;
	try {
		
		HttpSession htt = request.getSession(true);
        String uname = (String) htt.getAttribute("username");
        System.out.println("usernamemeeem login==" + uname);
        System.out.println("usernamemeeem login==" + crno);
        System.out.println("usernamemeeem login==" + tid);

		out = response.getWriter();
		JSONArray array = (JSONArray) userActivityService.getProposalLicenseApprovedDataBH(crno,uname,tid);
		System.out.println("List value: "+array);
		out.print(array);
	}
	catch(Exception e) {
		System.out.println("Exception in getAttachmentCSData method: "+e);
	}
	
}

@RequestMapping(value = { "/manualProposalSendBymeDetailsSI" }, method = RequestMethod.POST)
public JSONArray manualProposalSendBymeDetailsSI(ModelMap model, HttpServletRequest request, HttpServletResponse response,HttpSession session) {
	
	PrintWriter out = null;

	try {
		out = response.getWriter();
		
		 String uname = (String) session.getAttribute("username");
		 String company = (String) session.getAttribute("usercompany");
		JSONArray final_response = userActivityService.manualProposalSendBymeDetailsSI(uname,company);

		System.out.println("MastersControllerrrr reponse is = " + final_response);
					
			out.print(final_response);
					
			System.out.println("username GET SUCCESS");
		
	} catch (Exception e) {
		e.printStackTrace();
	}

	finally {
		out.close();
	}
//	return "Dashboard";
	return null;
	
}

@RequestMapping(value = { "/getManualProposalDataSI" }, method = RequestMethod.POST)
public void getManualProposalDataSI(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
	System.out.println("Inside getApprovaalSaleMngData method");
	
	String crno=request.getParameter("crno");
	 String tid = request.getParameter("tid");
//	int crno1=Integer.parseInt(crno);
	PrintWriter out = null;
	try {
		
		HttpSession htt = request.getSession(true);
        String uname = (String) htt.getAttribute("username");
        System.out.println("usernamemeeem login==" + uname);
        System.out.println("usernamemeeem login==" + crno);
        System.out.println("usernamemeeem login==" + tid);

		out = response.getWriter();
		JSONArray array = (JSONArray) userActivityService.getManualProposalDataSI(crno,uname,tid);
		System.out.println("List value: "+array);
		out.print(array);
	}
	catch(Exception e) {
		System.out.println("Exception in getAttachmentCSData method: "+e);
	}
	
}

@RequestMapping(value = { "/manualProposalPendingDetailsSM" }, method = RequestMethod.POST)
public JSONArray manualProposalPendingDetailsSM(ModelMap model, HttpServletRequest request, HttpServletResponse response,HttpSession session) {
	System.out.println("Inside cm details Controller@@@@@@@@@@@@ ");
	PrintWriter out = null;

	try {
		out = response.getWriter();
		
		 String uname = (String) session.getAttribute("username");
		 String company = (String) session.getAttribute("usercompany");
		 String userfullname = (String) session.getAttribute("fullname");
		 
		JSONArray final_response = userActivityService.manualProposalPendingDetailsSM(uname,company,userfullname);

		System.out.println("MastersControllerrrr reponse is = " + final_response);
					
			out.print(final_response);
					
			System.out.println("username GET SUCCESS");
		
	} catch (Exception e) {
		e.printStackTrace();
	}

	finally {
		out.close();
	}
//	return "Dashboard";
	return null;
	
}



@RequestMapping(value = { "/getManualProposalDataSM" }, method = RequestMethod.POST)
public void getManualProposalDataSM(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
	System.out.println("Inside getApprovaalSaleMngData method");
	
	String crno=request.getParameter("crno");
	 String tid = request.getParameter("tid");
//	int crno1=Integer.parseInt(crno);
	PrintWriter out = null;
	try {
		
		HttpSession htt = request.getSession(true);
        String uname = (String) htt.getAttribute("username");
        System.out.println("usernamemeeem login==" + uname);
        System.out.println("usernamemeeem login==" + crno);
        System.out.println("usernamemeeem login==" + tid);

		out = response.getWriter();
		JSONArray array = (JSONArray) userActivityService.getManualProposalDataSM(crno,uname,tid);
		System.out.println("List value: "+array);
		out.print(array);
	}
	catch(Exception e) {
		System.out.println("Exception in getAttachmentCSData method: "+e);
	}
	
}


@RequestMapping(value = { "/ApproveManualProposalLicenseSM" }, method = RequestMethod.POST)
public void ApproveManualProposalLicenseSM(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
	System.out.println("Inside UpdateVlxPropSaleMangApprove method");

	String crno = request.getParameter("crno");
	String status = request.getParameter("status");
	String tid = request.getParameter("tid");
	String SMnote = request.getParameter("SMnote");

	PrintWriter out = null;
	try {
		HttpSession htt = request.getSession(true);
		String uname = (String) htt.getAttribute("username");
		String company = (String) htt.getAttribute("usercompany");
		System.out.println("usernamemeeem login==" + uname);

		out = response.getWriter();
		String result = userActivityService.ApproveManualProposalLicenseSM(crno, status, tid, uname, company,SMnote);
		System.out.println("Result value: " + result);
		out.print(result);
	} catch (Exception e) {
		System.out.println("Exception in Asave Company: " + e);
	}

}

@RequestMapping(value = { "/manualProposalApprovedDetailsSM" }, method = RequestMethod.POST)
public void manualProposalApprovedDetailsSM(ModelMap model, HttpServletRequest request, HttpServletResponse response,HttpSession session) {
	System.out.println("Inside vlxPropApproveBymeDetails method");
	
	PrintWriter out = null;
	try {
		
		String uname = (String) session.getAttribute("username");
		String company = (String) session.getAttribute("usercompany");
		String userfullname = (String) session.getAttribute("fullname");
        System.out.println("usernamemeeem login==" + uname);

		out = response.getWriter();
		JSONArray array = (JSONArray) userActivityService.manualProposalApprovedDetailsSM(uname,company,userfullname);
		System.out.println("List value: "+array);
		out.print(array);
	}
	catch(Exception e) {
		System.out.println("Exception in ApplicationUserController getBranchList method: "+e);
	}
	
}


@RequestMapping(value = { "/getManualProposalApprovedDataSM" }, method = RequestMethod.POST)
public void getManualProposalApprovedDataSM(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
	System.out.println("Inside getApprovaalSaleMngData method");
	
	String crno=request.getParameter("crno");
	 String tid = request.getParameter("tid");
//	int crno1=Integer.parseInt(crno);
	PrintWriter out = null;
	try {
		
		HttpSession htt = request.getSession(true);
        String uname = (String) htt.getAttribute("username");
        System.out.println("usernamemeeem login==" + uname);
        System.out.println("usernamemeeem login==" + crno);
        System.out.println("usernamemeeem login==" + tid);

		out = response.getWriter();
		JSONArray array = (JSONArray) userActivityService.getManualProposalApprovedDataSM(crno,uname,tid);
		System.out.println("List value: "+array);
		out.print(array);
	}
	catch(Exception e) {
		System.out.println("Exception in getAttachmentCSData method: "+e);
	}
	
}

@RequestMapping(value = { "/manualProposalPendingDetailsMD" }, method = RequestMethod.POST)
public JSONArray manualProposalPendingDetailsMD(ModelMap model, HttpServletRequest request, HttpServletResponse response,HttpSession session) {
	System.out.println("Inside cm details Controller@@@@@@@@@@@@ ");
	PrintWriter out = null;

	try {
		out = response.getWriter();
		
		 String uname = (String) session.getAttribute("username");
		 String company = (String) session.getAttribute("usercompany");
		JSONArray final_response = userActivityService.manualProposalPendingDetailsMD(uname,company);

		System.out.println("MastersControllerrrr reponse is = " + final_response);
					
			out.print(final_response);
					
			System.out.println("username GET SUCCESS");
		
	} catch (Exception e) {
		e.printStackTrace();
	}

	finally {
		out.close();
	}
//	return "Dashboard";
	return null;
	
}


@RequestMapping(value = { "/ApproveManualProposalLicenseMD" }, method = RequestMethod.POST)
public void ApproveManualProposalLicenseMD(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
	System.out.println("Inside UpdateVlxPropSaleMangApprove method");

	String crno = request.getParameter("crno");
	String status = request.getParameter("status");
	String tid = request.getParameter("tid");
	String MDnote = request.getParameter("MDnote");

	PrintWriter out = null;
	try {
		HttpSession htt = request.getSession(true);
		String uname = (String) htt.getAttribute("username");
		String company = (String) htt.getAttribute("usercompany");
		System.out.println("usernamemeeem login==" + uname);

		out = response.getWriter();
		String result = userActivityService.ApproveManualProposalLicenseMD(crno, status, tid, uname, company,MDnote);
		System.out.println("Result value: " + result);
		out.print(result);
	} catch (Exception e) {
		System.out.println("Exception in Asave Company: " + e);
	}

}

@RequestMapping(value = { "/manualProposalApprovedDetailsMD" }, method = RequestMethod.POST)
public JSONArray manualProposalApprovedDetailsMD(ModelMap model, HttpServletRequest request, HttpServletResponse response,HttpSession session) {
	System.out.println("Inside cm vlxProposalApproveDetails Controller@@@@@@@@@@@@ ");
	PrintWriter out = null;

	try {
		out = response.getWriter();
		
		 String uname = (String) session.getAttribute("username");
		 String company = (String) session.getAttribute("usercompany");
		JSONArray final_response = userActivityService.manualProposalApprovedDetailsMD(uname,company);

		System.out.println("MastersControllerrrr reponse is = " + final_response);
					
			out.print(final_response);
					
			System.out.println("username GET SUCCESS");
		
	} catch (Exception e) {
		e.printStackTrace();
	}

	finally {
		out.close();
	}
//	return "Dashboard";
	return null;
	
}


@RequestMapping(value = { "/getManualProposalApprovedDataMD" }, method = RequestMethod.POST)
public void getManualProposalApprovedDataMD(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
	System.out.println("Inside getApprovaalSaleMngData method");
	
	String crno=request.getParameter("crno");
	 String tid = request.getParameter("tid");
//	int crno1=Integer.parseInt(crno);
	PrintWriter out = null;
	try {
		
		HttpSession htt = request.getSession(true);
        String uname = (String) htt.getAttribute("username");
        System.out.println("usernamemeeem login==" + uname);
        System.out.println("usernamemeeem login==" + crno);
        System.out.println("usernamemeeem login==" + tid);

		out = response.getWriter();
		JSONArray array = (JSONArray) userActivityService.getManualProposalApprovedDataMD(crno,uname,tid);
		System.out.println("List value: "+array);
		out.print(array);
	}
	catch(Exception e) {
		System.out.println("Exception in getAttachmentCSData method: "+e);
	}
	
}

//mail send


@RequestMapping(value = { "/SendMailwithattachment" }, method = RequestMethod.POST)
public void SendMailwithattachment(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
	System.out.println("Inside SendMailwithattachment method");
	
	
	
	PrintWriter out = null;
	try {
		HttpSession htt = request.getSession(true);
        String uname = (String) htt.getAttribute("username");
        String company = (String) htt.getAttribute("usercompany");
       
        
        String crno = request.getParameter("crno");
   	    String tid = request.getParameter("tid");
        String clientname = request.getParameter("clientname");
        String EnvironmentKeyNo = request.getParameter("EnvironmentKeyNo");
        String ponumber = request.getParameter("ponumber");
        String filenameStandard = request.getParameter("filenameStandard");
        String endCustomerEmail = request.getParameter("endCustomerEmail");
        String podate = request.getParameter("podate");
        
        
        String distributorEmail = request.getParameter("distributorEmail");
        String partnerEmail = request.getParameter("partnerEmail");
        String linkForEmail = request.getParameter("linkForEmail");
        
		
		out = response.getWriter();
		String result = userActivityService.SendMailwithattachment(crno,tid,uname,company,clientname,EnvironmentKeyNo,ponumber,filenameStandard,endCustomerEmail,podate,distributorEmail, partnerEmail, linkForEmail);
		System.out.println("Result value: "+result);
		out.print(result);
	}
	catch(Exception e) {
		System.out.println("Exception in Asave Company: "+e);
	}

}


//10/1
@RequestMapping(value = { "/SMrejectMannualVP" }, method = RequestMethod.POST)
public void SMrejectMannualVP(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
	System.out.println("Inside ccreject method");

	String crno = request.getParameter("crno");
 String rejectreason = request.getParameter("val");
	String SMnote = request.getParameter("SMnote");
 String tid = request.getParameter("tid");

	PrintWriter out = null;
	try {
		HttpSession htt = request.getSession(true);
		String uname = (String) htt.getAttribute("username");
		String company = (String) htt.getAttribute("usercompany");
		System.out.println("usernamemeeem login==" + uname);
		System.out.println("company login==" + company);
		out = response.getWriter();
		String result = userActivityService.SMrejectMannualVP(crno,company,rejectreason,SMnote,uname,tid);
		System.out.println("rejecte mannual Result : "+result);
		out.print(result);
	} catch (Exception e) {
		System.out.println("Exception in Asave Company: " + e);
	}
}



//vlxPropRejectedBySMDetails
@RequestMapping(value = { "/vlxMPropRejectedBymeDetails" }, method = RequestMethod.POST)
public void vlxMPropRejectedBymeDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
		HttpSession session) {
	System.out.println("Inside vlxMPropRejectedBymeDetails method");

	PrintWriter out = null;
	try {

		String uname = (String) session.getAttribute("username");
		String company = (String) session.getAttribute("usercompany");
		String userfullname = (String) session.getAttribute("fullname");
		System.out.println("usernamemeeem login==" + uname);

		out = response.getWriter();
		JSONArray array = (JSONArray) userActivityService.vlxMPropRejectedBymeDetails(uname, company,userfullname);
		System.out.println("List value: " + array);
		out.print(array);
	} catch (Exception e) {
		System.out.println("Exception in ApplicationUserController getBranchList method: " + e);
	}
}

// 12/ 24
@RequestMapping(value = { "/rejectedManualProposalByMD" }, method = RequestMethod.POST)
public void rejectedManualProposalByMD(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
	System.out.println("Inside rejectedManualProposalByMD method");

	String crno = request.getParameter("crno");
	String rejectreason = request.getParameter("val");
	String SMnote = request.getParameter("SMnote");
	String tid = request.getParameter("tid");

	PrintWriter out = null;
	try {
		HttpSession htt = request.getSession(true);
		String uname = (String) htt.getAttribute("username");
		String company = (String) htt.getAttribute("usercompany");
		System.out.println("usernamemeeem login==" + uname);
		System.out.println("company login==" + company);
		out = response.getWriter();
		String result = userActivityService.rejectedManualProposalByMD(crno, company, rejectreason, SMnote, uname,
				tid);
		System.out.println("rejecte mannual Result : " + result);
		out.print(result);
	} catch (Exception e) {
		System.out.println("Exception in Asave Company: " + e);
	}
}

@RequestMapping(value = { "/ManualProposalRejectByMD" }, method = RequestMethod.POST)
public JSONArray ManualProposalRejectByMD(ModelMap model, HttpServletRequest request,
		HttpServletResponse response, HttpSession session) {
	System.out.println("Inside ManualProposalRejectByMD Controller@@@@@@@@@@@@ ");
	PrintWriter out = null;

	try {
		out = response.getWriter();

		String uname = (String) session.getAttribute("username");
		String company = (String) session.getAttribute("usercompany");
		JSONArray final_response = userActivityService.ManualProposalRejectByMD(uname, company);

		System.out.println("MastersControllerrrr reponse is = " + final_response);

		out.print(final_response);

		System.out.println("username GET SUCCESS");

	} catch (Exception e) {
		e.printStackTrace();
	}

	finally {
		out.close();
	}
//return "Dashboard";
	return null;

}

@RequestMapping(value = { "/rejectedByCM" }, method = RequestMethod.POST)
public void rejectedByCM(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
	System.out.println("Inside ccreject method");

	String crno = request.getParameter("crno");
	String rejectreason = request.getParameter("val");
	String SMnote = request.getParameter("SMnote");
	String tid = request.getParameter("tid");

	PrintWriter out = null;
	try {
		HttpSession htt = request.getSession(true);
		String uname = (String) htt.getAttribute("username");
		String company = (String) htt.getAttribute("usercompany");
		System.out.println("usernamemeeem login==" + uname);
		System.out.println("company login==" + company);
		out = response.getWriter();
		String result = userActivityService.rejectedByCM(crno, company, rejectreason, SMnote, uname, tid);
		System.out.println("rejecte mannual Result : " + result);
		out.print(result);
	} catch (Exception e) {
		System.out.println("Exception in Asave Company: " + e);
	}
}


//
//vlxPropRejectedBySMDetails
@RequestMapping(value = { "/ManualPropRejectedBySMList" }, method = RequestMethod.POST)
public void ManualPropRejectedBySMList(ModelMap model, HttpServletRequest request, HttpServletResponse response,
		HttpSession session) {
	System.out.println("Inside vlxMPropRejectedBymeDetails method");

	PrintWriter out = null;
	try {

		String uname = (String) session.getAttribute("username");
		String company = (String) session.getAttribute("usercompany");
		String userfullname = (String) session.getAttribute("fullname");
		System.out.println("usernamemeeem login==" + uname);

		out = response.getWriter();
		JSONArray array = (JSONArray) userActivityService.ManualPropRejectedBySMList(uname, company,userfullname);
		System.out.println("rejectedsfsf: " + array);
		out.print(array);
	} catch (Exception e) {
		System.out.println("Exception in ApplicationUserController getBranchList method: " + e);
	}
}

//20/24
@RequestMapping(value = { "/insertManualPurchaseOrder" }, method = RequestMethod.POST)
public String insertManualPurchaseOrder(@RequestParam("pouploadfile") MultipartFile[] pouploadfile1,ModelMap model, HttpServletRequest request, HttpServletResponse response,
		HttpSession session, ModelMap modelMap) {
	System.out.println("Inside insertManualPurchaseOrder Controller@@@@@@@@@@@@ ");
	PrintWriter out = null;
	String details = null;
	
	try {
		out = response.getWriter();
		
		String loginuser=(String)session.getAttribute("username");
		String loginUserCompany = session.getAttribute("companyname").toString();
		
       // String pouploadfile = request.getParameter("pouploadfile");
		
		String potype = request.getParameter("potype");
		String proposalType = request.getParameter("proposalType");
	    String proposalids = request.getParameter("proposalids");
	    String vpuploadfileProposal = request.getParameter("vpuploadfileProposal");
	        
       
	    String ponumber = request.getParameter("ponumber");
	    String podate = request.getParameter("podate");
	    String customername = request.getParameter("customername");
	    String productsuit = request.getParameter("selectedSideBarValuesFinalprodSuit");		        
    	String securitytool = request.getParameter("selectedSideBarValuesFinalSECTool");
        String paymentterms = request.getParameter("paymentterms");
        String prodliscense = request.getParameter("prodliscense");
        String prodamount = request.getParameter("prodamount");
        String proddescrip = request.getParameter("proddescrip");
        
        String fixedyear = request.getParameter("fixedyear");
        String Subscriptionyear = request.getParameter("Subscriptionyear");
        String Perpetualyear = request.getParameter("Perpetualyear");
        String subscriptionANDperpetualYear = request.getParameter("subscriptionANDperpetualYear");
              
        System.out.println(" productsuit data :"+productsuit);
        System.out.println(" securitytool data :"+securitytool);
        System.out.println(" proposalType data :"+proposalType+" proposalids data :"+
        proposalids+" vpuploadfileProposal data :"+vpuploadfileProposal);

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
        String poReferenceNo = request.getParameter("poRefNO");
        

		String final_response = userActivityService.insertManualPurchaseOrder(pouploadfile1, proddescrip, customername, paymentterms, prodliscense,
				prodamount,loginuser,loginUserCompany, proposalType,proposalids,vpuploadfileProposal,
	 potype, ponumber, podate,productsuit,
	 securitytool, fixedyear, Subscriptionyear, Perpetualyear, subscriptionANDperpetualYear, tennurestartdate, tennureenddate,
		tennureMonth, tennureYear, warrantystart, warrantyend, warrantyMonth, warrantyYear, amcstartdate,
		amcenddate, AMCMonth, AMCYear,poReferenceNo);

		System.out.println("MastersControllerrrr reponse is = " + final_response);							
			out.print(final_response);
						
			System.out.println("insertManualPurchaseOrder GET SUCCESS");
		
	} catch (Exception e) {
		e.printStackTrace();
	}

	finally {
		out.close();
	}

	return null;

}

@RequestMapping(value = { "/rejectedProposalLicenseBH" }, method = RequestMethod.POST)
public void rejectedProposalLicenseBH(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
	System.out.println("Inside rejectedProposalLicenseBH method");

	String crno = request.getParameter("crno");
	String rejectreason = request.getParameter("val");
	String SMnote = request.getParameter("SMnote");
	String tid = request.getParameter("tid");

	PrintWriter out = null;
	try {
		HttpSession htt = request.getSession(true);
		String uname = (String) htt.getAttribute("username");
		String company = (String) htt.getAttribute("usercompany");
		System.out.println("usernamemeeem login==" + uname);
		System.out.println("company login==" + company);
		out = response.getWriter();
		String result = userActivityService.rejectedProposalLicenseBH(crno, company, rejectreason, SMnote, uname,
				tid);
		System.out.println("rejectedProposalLicenseBH Result : " + result);
		out.print(result);
	} catch (Exception e) {
		System.out.println("Exception in rejectedProposalLicenseBH : " + e);
	}
}

@RequestMapping(value = { "/proposalLicenseRejectedDetailsBH" }, method = RequestMethod.POST)
public void proposalLicenseRejectedDetailsBH(ModelMap model, HttpServletRequest request, HttpServletResponse response,HttpSession session) {
	System.out.println("Inside proposalLicenseRejectedDetailsBH method");
	
	PrintWriter out = null;
	try {
		
		String uname = (String) session.getAttribute("username");
		String company = (String) session.getAttribute("usercompany");
		String userfullname = (String) session.getAttribute("fullname");
		String roletype = (String) session.getAttribute("role");
        System.out.println("usernamemeeem login==" + uname);

		out = response.getWriter();
		JSONArray array = (JSONArray) userActivityService.proposalLicenseRejectedDetailsBH(uname,company,userfullname, roletype );
		System.out.println("List value: "+array);
		out.print(array);
	}
	catch(Exception e) {
		System.out.println("Exception in proposalLicenseRejectedDetailsBH method: "+e);
	}
	
}


	

//20/1
//license rejected by SM  
@RequestMapping(value = { "/SMrejectLicense" }, method = RequestMethod.POST)
public void SMrejectLicense(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
	System.out.println("Inside License ccreject method");

	String crno = request.getParameter("crno");
String rejectreason = request.getParameter("val");
	String SMnote = request.getParameter("SMnote");
String tid = request.getParameter("tid");

	PrintWriter out = null;
	try {
		HttpSession htt = request.getSession(true);
		String uname = (String) htt.getAttribute("username");
		String company = (String) htt.getAttribute("usercompany");
		System.out.println("usernamemeeem login==" + uname);
//		System.out.println("company login==" + company);
		out = response.getWriter();
		String result = userActivityService.SMrejectLicense(crno,rejectreason,SMnote,uname,tid);
		System.out.println("rejecte License Result : "+result);
		out.print(result);
	} catch (Exception e) {
		System.out.println("Exception in Asave Company: " + e);
	}
}

//							
@RequestMapping(value = { "/LicenseRejectedBySMList" }, method = RequestMethod.POST)
public void LicenseRejectedBySMList(ModelMap model, HttpServletRequest request, HttpServletResponse response,
		HttpSession session) {
	System.out.println("Inside vlxMPropRejectedBymeDetails method");

	PrintWriter out = null;
	try {

		String uname = (String) session.getAttribute("username");
		String company = (String) session.getAttribute("usercompany");
		String userfullname = (String) session.getAttribute("fullname");
		System.out.println("usernamemeeem login==" + uname);

		out = response.getWriter();
		JSONArray array = (JSONArray) userActivityService.LicenseRejectedBySMList(uname, userfullname);
		System.out.println("List value: " + array);
		out.print(array);
	} catch (Exception e) {
		System.out.println("Exception in ApplicationUserController getBranchList method: " + e);
	}
}

@RequestMapping(value = { "/ManualPoRaiseByMeDetails" }, method = RequestMethod.POST)
public JSONArray ManualPoRaiseByMeDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,HttpSession session) {
	System.out.println("Inside ManualPoRaiseByMeDetails Controller@@@@@@@@@@@@ ");
	PrintWriter out = null;

	try {
		out = response.getWriter();
		
		 String uname = (String) session.getAttribute("username");
		 String company = (String) session.getAttribute("usercompany");
		JSONArray final_response = userActivityService.ManualPoRaiseByMeDetails(uname,company);

		System.out.println("MastersControllerrrr reponse is = " + final_response);
					
			out.print(final_response);
					
			System.out.println("username GET SUCCESS");
		
	} catch (Exception e) {
		e.printStackTrace();
	}

	finally {
		out.close();
	}
//	return "Dashboard";
	return null;
	
}



//SI  LicenseRejectedSIList
@RequestMapping(value = { "/LicenseRejectedSIList" }, method = RequestMethod.POST)
public void LicenseRejectedSIList(ModelMap model, HttpServletRequest request, HttpServletResponse response,
		HttpSession session) {
	System.out.println("Inside LicenseRejectedSIList method");

	PrintWriter out = null;
	try {

		String uname = (String) session.getAttribute("username");
		String company = (String) session.getAttribute("usercompany");
		String userfullname = (String) session.getAttribute("fullname");
		System.out.println("usernamemeeem login==" + uname);

		out = response.getWriter();
		JSONArray array = (JSONArray) userActivityService.LicenseRejectedSIList(uname, userfullname);
		System.out.println("List value: " + array);
		out.print(array);
	} catch (Exception e) {
		System.out.println("Exception in ApplicationUserController getBranchList method: " + e);
	}
}



@RequestMapping(value = { "/getPoRaisedManualPOData" }, method = RequestMethod.POST)
public void getPoRaisedManualPOData(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
	System.out.println("Inside getPoRaisedManualPOData method");
	
	String crno=request.getParameter("crno");
	 String tid = request.getParameter("tid");
//	int crno1=Integer.parseInt(crno);
	PrintWriter out = null;
	try {
		
		HttpSession htt = request.getSession(true);
        String uname = (String) htt.getAttribute("username");
        System.out.println("usernamemeeem login==" + uname);
        System.out.println("usernamemeeem login==" + crno);
        System.out.println("usernamemeeem login==" + tid);

		out = response.getWriter();
		JSONArray array = (JSONArray) userActivityService.getPoRaisedManualPOData(crno,uname,tid);
		System.out.println("List value: "+array);
		out.print(array);
	}
	catch(Exception e) {
		System.out.println("Exception in getAttachmentCSData method: "+e);
	}
	
}

//22/24
@RequestMapping(value = { "/getManualPoRaisedData" }, method = RequestMethod.POST)
public JSONArray getManualPoRaisedData(ModelMap model, HttpServletRequest request, HttpServletResponse response,HttpSession session) {
	System.out.println("Inside getManualPoRaisedData Controller@@@@@@@@@@@@ ");
	PrintWriter out = null;

	try {
		out = response.getWriter();
		
		 String crno = request.getParameter("crno");
		 String tid = request.getParameter("tid");
		  
		JSONArray final_response = userActivityService.getManualPoRaisedData(crno,tid);

		System.out.println("MastersControllerrrr reponse is = " + final_response);
					
			out.print(final_response);
					
			System.out.println("username GET SUCCESS");
		
	} catch (Exception e) {
		e.printStackTrace();
	}

	finally {
		out.close();
	}
//	return "Dashboard";
	return null;
	
}

//1/2/24
@RequestMapping(value = { "/PORejectedByCMDetails" }, method = RequestMethod.POST)
public void PORejectedByCMDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
		HttpSession session) {
	System.out.println("Inside PORejectedByCMDetails method");

	PrintWriter out = null;
	try {

		String uname = (String) session.getAttribute("username");
		String company = (String) session.getAttribute("usercompany");
		String userfullname = (String) session.getAttribute("fullname");
		System.out.println("usernamemeeem login==" + uname);

		out = response.getWriter();
		JSONArray array = (JSONArray) userActivityService.PORejectedByCMDetails(uname, company,userfullname);
		System.out.println("List value: " + array);
		out.print(array);
	} catch (Exception e) {
		System.out.println("Exception in ApplicationUserController getBranchList method: " + e);
	}

}


//5.2.24
@RequestMapping(value = { "/getFORM3SubmitteddBySupportManager" }, method = RequestMethod.POST)
public void getFORM3SubmitteddBySupportManager(ModelMap model, HttpServletRequest request, HttpServletResponse response,HttpSession session) {
	System.out.println("Inside /getFORM3SubmitteddBySupportManager method");
	
	PrintWriter out = null;
	try {
		
		String uname = (String) session.getAttribute("username");
//		String company = (String) session.getAttribute("usercompany");
       System.out.println("usernamemeeem login==" + uname);

		out = response.getWriter();
		JSONArray array = (JSONArray) userActivityService.getFORM3SubmitteddBySupportManager(uname);
		System.out.println("List value: "+array);
		out.print(array);
	}
	catch(Exception e) {
		System.out.println("Exception in getFORM3SubmitteddBySupportManager  method: "+e);
	}
	
}


//SentMailByCMList
@RequestMapping(value = { "/SentMailByCMList" }, method = RequestMethod.POST)
public void SentMailByCMList(ModelMap model, HttpServletRequest request, HttpServletResponse response,HttpSession session) {
System.out.println("Inside proposalLicenseApprovedDetailsSM method");

PrintWriter out = null;
try {
	
	String uname = (String) session.getAttribute("username");
	String company = (String) session.getAttribute("usercompany");
	String userfullname = (String) session.getAttribute("fullname");
	String roletype = (String) session.getAttribute("role");

	out = response.getWriter();
	JSONArray array = (JSONArray) userActivityService.SentMailByCMList(uname,company,userfullname, roletype );
	System.out.println("List value: "+array);
	out.print(array);
}
catch(Exception e) {
	System.out.println("Exception in ApplicationUserController getBranchList method: "+e);
}

}

//20/2/24
@RequestMapping(value = { "/ReviseManualProposalSendBymeDetailsSI" }, method = RequestMethod.POST)
public JSONArray ReviseManualProposalSendBymeDetailsSI(ModelMap model, HttpServletRequest request, HttpServletResponse response,HttpSession session) {
	
	PrintWriter out = null;

	try {
		out = response.getWriter();
		
		 String uname = (String) session.getAttribute("username");
		 String company = (String) session.getAttribute("usercompany");
		JSONArray final_response = userActivityService.ReviseManualProposalSendBymeDetailsSI(uname,company);

		System.out.println("MastersControllerrrr reponse is = " + final_response);
					
			out.print(final_response);
					
			System.out.println("username GET SUCCESS");
		
	} catch (Exception e) {
		e.printStackTrace();
	}

	finally {
		out.close();
	}
//	return "Dashboard";
	return null;
	
}

@RequestMapping(value = {"/SubmitReviseManualProposal"},method = RequestMethod.POST )
public String SubmitReviseManualProposal(HttpServletRequest request, HttpServletResponse response,HttpSession session,@RequestParam("ManualFile") MultipartFile[] ManualReviseFile)
{
	PrintWriter out=null;
	try {
		out=response.getWriter();
		
		
		String uname = (String) session.getAttribute("username");
		String company = (String) session.getAttribute("usercompany");
       System.out.println("usernamemeeem login==" + uname);
       
   
		
		String veloxdata=request.getParameter("veloxdata");
		String poinitiator=request.getParameter("poinitiator");
		String poinitiatorno=request.getParameter("poinitiatorno");
		String FirstApprovername=request.getParameter("FirstApprovername");
		
		String firstapprovercontact=request.getParameter("firstapprovercontact");
		String secondApprovername=request.getParameter("secondApprovername");
		String secondapprovercontact=request.getParameter("secondapprovercontact");
		String clientname=request.getParameter("clientname");
		String Description=request.getParameter("Description");
		String totalpriceforallproduct =request.getParameter("totalpriceforallproduct");
		String deploysupport =request.getParameter("deploysupport");
		String clouddeploycharges =request.getParameter("clouddeploycharges");
		String subtotalB =request.getParameter("subtotalB");
		String resoucesamount=request.getParameter("resoucesamount");
		String ATC=request.getParameter("ATC");
		String subtotalAB=request.getParameter("subtotalAB");
		
		String Proposaltype =request.getParameter("Proposaltype");
		String Perpetualyear=request.getParameter("Perpetualyear");
		String Subscriptionyear =request.getParameter("Subscriptionyear");					
		String Amcsecondyear=request.getParameter("Amcsecondyear");
		String Amcthirdyear=request.getParameter("Amcthirdyear");
		String Amcfourthyear=request.getParameter("Amcfourthyear");
		String Amcfiveyear=request.getParameter("Amcfiveyear");
		String secondyearsubscription=request.getParameter("secondyearsubscription");
		String thirdyearsubscription=request.getParameter("thirdyearsubscription");	
		
		   String productsuitselect=request.getParameter("productsuitselect");
		    String Scanplusprodversion=request.getParameter("Scanplusprodversion");
		    String SecureITprodversion=request.getParameter("SecureITprodversion");
		    String enccustomername=request.getParameter("enccustomername");
		    String fixedyear=request.getParameter("fixedyear");
		    
						
		
		
		String folderPath = "/WEB-INF/VeloxProposalPDF/veloxlogo.png";
	    String fullPathVlxLogo = servletContext.getRealPath(folderPath);
	    String fullPathVlxEnd = servletContext.getRealPath("/WEB-INF/VeloxProposalPDF/end.png");
	    String fullPathSwachBharat = servletContext.getRealPath("/WEB-INF/VeloxProposalPDF/swachBharat.png");
	    String Letterhead = servletContext.getRealPath("/WEB-INF/VeloxProposalPDF/Letterhead.PNG");
	    String signature = servletContext.getRealPath("/WEB-INF/VeloxProposalPDF/signature.PNG");
	    System.out.println("fullPath "+fullPathVlxLogo);
	    System.out.println("signature "+signature);
	    
	    String IntegrationchargeYesNo = request.getParameter("IntegrationCharges");
	    String IntegrationCharges = request.getParameter("integrationcharge");
	    String Total_C=request.getParameter("totalc");
	    String GSTPERCENTAGE=request.getParameter("total18percentage");
	    String Grand_Total=request.getParameter("grandtotal");
		
		String crno =request.getParameter("crno");
		String tid =request.getParameter("tid");
		String SInote=request.getParameter("SInote");
		
		String amcstartdate = request.getParameter("amcstartdate");
		String AMCmonthyear = request.getParameter("AMCmonthyear");
		String AMCMonth = request.getParameter("AMCMonth");
		String AMCYear = request.getParameter("AMCYear");
		String amcenddate = request.getParameter("amcenddate");
		String productsuitdetails = request.getParameter("productsuitdetails");
		String securitysolutiondetails = request.getParameter("securitysolutiondetails");
		String descforamc = request.getParameter("descforamc");
		String totalcostAMC = request.getParameter("totalcostAMC");
		String GRANDTOTALFORAMC = request.getParameter("GRANDTOTALFORAMC");
		String gstforamc = request.getParameter("gstforamc");
		
		String subtotalAResource = request.getParameter("subtotalAResource");
		String gstdataforresource = request.getParameter("gstdataforresource");
		String grandtotalforresource = request.getParameter("grandtotalforresource");
		
		String contactperson = request.getParameter("contactperson");
					
	   
		String veloxdata1 = request.getParameter("veloxdata1");
		String subscriptionANDperpetualYear = request.getParameter("subscriptionANDperpetualYear");
		String perpetualSubsAnnualperpType = request.getParameter("perpetualSubsAnnualperpType");
		String perpetualSubs3yearperpType = request.getParameter("perpetualSubs3yearperpType");
		String deploysupport21 = request.getParameter("deploysupport21");
		String clouddeploycharges21 = request.getParameter("clouddeploycharges21");
		String IntegrationCharges21 = request.getParameter("IntegrationCharges21");
		String integrationcharge21 = request.getParameter("integrationcharge21");
		String subtotalB21 = request.getParameter("subtotalB21");
		String totalc21 = request.getParameter("totalc21");
		String total18percentage21 = request.getParameter("total18percentage21");
		String grandtotal21 = request.getParameter("grandtotal21");
		String resoucesamount21 = request.getParameter("resoucesamount21");
		String manualAmount = request.getParameter("amount");
					
	   
//		String finals=userActivityService.veloxproposalUpdateDetails(veloxdata,poinitiator,poinitiatorno,FirstApprovername,firstapprovercontact,secondApprovername,secondapprovercontact,clientname,
//				Description,totalpriceforallproduct,deploysupport,clouddeploycharges,subtotalB,subtotalAB,uname,crno,tid,SInote);
		String finals=userActivityService.SubmitReviseManualProposal(veloxdata,poinitiator,poinitiatorno,FirstApprovername,firstapprovercontact,secondApprovername,secondapprovercontact,clientname,Description,totalpriceforallproduct,deploysupport,clouddeploycharges,subtotalB,subtotalAB,uname,resoucesamount,ATC,Proposaltype,Perpetualyear,
				Subscriptionyear,Amcsecondyear,Amcthirdyear,Amcfourthyear,Amcfiveyear,secondyearsubscription,thirdyearsubscription,fullPathVlxLogo,fullPathVlxEnd,fullPathSwachBharat,
				IntegrationchargeYesNo,IntegrationCharges,Total_C,GSTPERCENTAGE,Grand_Total,productsuitselect,Scanplusprodversion,SecureITprodversion,enccustomername,Letterhead,signature,fixedyear,crno,tid,SInote,amcstartdate,AMCmonthyear,AMCMonth,AMCYear,
				amcenddate,productsuitdetails,securitysolutiondetails,descforamc,totalcostAMC,GRANDTOTALFORAMC,gstforamc,
				gstdataforresource ,grandtotalforresource ,subtotalAResource,contactperson,veloxdata1 , subscriptionANDperpetualYear , perpetualSubsAnnualperpType, perpetualSubs3yearperpType, deploysupport21 , clouddeploycharges21 , 
				 IntegrationCharges21 , integrationcharge21 ,  subtotalB21 ,  totalc21 ,  total18percentage21 ,  grandtotal21 , resoucesamount21,manualAmount,ManualReviseFile);
		System.out.println("uploadFile"+ManualReviseFile);
		
		out.print(finals);
	}
	catch (IOException e)
	{
		e.printStackTrace();
	}
return null;

}
@RequestMapping(value = { "/reviseManualProposalSendBySIDetails" }, method = RequestMethod.POST)
public JSONArray reviseManualProposalSendBySIDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,HttpSession session) {
	
	PrintWriter out = null;

	try {
		out = response.getWriter();
		
		 String uname = (String) session.getAttribute("username");
		 String company = (String) session.getAttribute("usercompany");
		JSONArray final_response = userActivityService.reviseManualProposalSendBySIDetails(uname,company);

		System.out.println("MastersControllerrrr reponse is = " + final_response);
					
			out.print(final_response);
					
			System.out.println("username GET SUCCESS");
		
	} catch (Exception e) {
		e.printStackTrace();
	}

	finally {
		out.close();
	}
//	return "Dashboard";
	return null;
	
}

@RequestMapping(value = { "/revisedManualProposalPendingDetailsMD" }, method = RequestMethod.POST)
public JSONArray revisedManualProposalPendingDetailsMD(ModelMap model, HttpServletRequest request, HttpServletResponse response,HttpSession session) {
	System.out.println("Inside  revisedManualProposalPendingDetailsMD Controller@@@@@@@@@@@@ ");
	PrintWriter out = null;

	try {
		out = response.getWriter();
		
		 String uname = (String) session.getAttribute("username");
		 String company = (String) session.getAttribute("usercompany");
		JSONArray final_response = userActivityService.revisedManualProposalPendingDetailsMD(uname,company);

		System.out.println("MastersControllerrrr reponse is = " + final_response);
					
			out.print(final_response);
					
			System.out.println("username GET SUCCESS");
		
	} catch (Exception e) {
		e.printStackTrace();
	}

	finally {
		out.close();
	}
//	return "Dashboard";
	return null;
	
}

@RequestMapping(value = { "/getReviseManualProposalApprovedDataMD" }, method = RequestMethod.POST)
public void getReviseManualProposalApprovedDataMD(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
	System.out.println("Inside getReviseManualProposalApprovedDataMD method");
	
	String crno=request.getParameter("crno");
	 String tid = request.getParameter("tid");
//	int crno1=Integer.parseInt(crno);
	PrintWriter out = null;
	try {
		
		HttpSession htt = request.getSession(true);
        String uname = (String) htt.getAttribute("username");
        System.out.println("usernamemeeem login==" + uname);
        System.out.println("usernamemeeem login==" + crno);
        System.out.println("usernamemeeem login==" + tid);

		out = response.getWriter();
		JSONArray array = (JSONArray) userActivityService.getReviseManualProposalApprovedDataMD(crno,uname,tid);
		System.out.println("List value: "+array);
		out.print(array);
	}
	catch(Exception e) {
		System.out.println("Exception in getAttachmentCSData method: "+e);
	}
	
}

@RequestMapping(value = { "/getManualReviseProposalApprovedDataSI" }, method = RequestMethod.POST)
public void getManualReviseProposalApprovedDataSI(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
	System.out.println("Inside getManualReviseProposalApprovedDataSI method");
	
	String crno=request.getParameter("crno");
	 String tid = request.getParameter("tid");
//	int crno1=Integer.parseInt(crno);
	PrintWriter out = null;
	try {
		
		HttpSession htt = request.getSession(true);
        String uname = (String) htt.getAttribute("username");
        System.out.println("usernamemeeem login==" + uname);
        System.out.println("usernamemeeem login==" + crno);
        System.out.println("usernamemeeem login==" + tid);

		out = response.getWriter();
		JSONArray array = (JSONArray) userActivityService.getManualReviseProposalApprovedDataSI(crno,uname,tid);
		System.out.println("List value: "+array);
		out.print(array);
	}
	catch(Exception e) {
		System.out.println("Exception in getAttachmentCSData method: "+e);
	}
	
}

@RequestMapping(value = { "/RevisemanualProposalApprovedDetailsMD" }, method = RequestMethod.POST)
public JSONArray RevisemanualProposalApprovedDetailsMD(ModelMap model, HttpServletRequest request, HttpServletResponse response,HttpSession session) {
	System.out.println("Inside cm RevisemanualProposalApprovedDetailsMD Controller@@@@@@@@@@@@ ");
	PrintWriter out = null;

	try {
		out = response.getWriter();
		
		 String uname = (String) session.getAttribute("username");
		 String company = (String) session.getAttribute("usercompany");
		JSONArray final_response = userActivityService.RevisemanualProposalApprovedDetailsMD(uname,company);

		System.out.println("MastersControllerrrr reponse is = " + final_response);
					
			out.print(final_response);
					
			System.out.println("username GET SUCCESS");
		
	} catch (Exception e) {
		e.printStackTrace();
	}

	finally {
		out.close();
	}
//	return "Dashboard";
	return null;
	
}

@RequestMapping(value = { "/getManualReviseProposalApprovedData" }, method = RequestMethod.POST)
public void getManualReviseProposalApprovedData(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
	System.out.println("Inside getManualReviseProposalApprovedData method");
	
	String crno=request.getParameter("crno");
	 String tid = request.getParameter("tid");
//	int crno1=Integer.parseInt(crno);
	PrintWriter out = null;
	try {
		
		HttpSession htt = request.getSession(true);
        String uname = (String) htt.getAttribute("username");
        System.out.println("usernamemeeem login==" + uname);
        System.out.println("usernamemeeem login==" + crno);
        System.out.println("usernamemeeem login==" + tid);

		out = response.getWriter();
		JSONArray array = (JSONArray) userActivityService.getManualReviseProposalApprovedData(crno,uname,tid);
		System.out.println("List value: "+array);
		out.print(array);
	}
	catch(Exception e) {
		System.out.println("Exception in getManualReviseProposalApprovedData method: "+e);
	}
	
}
@RequestMapping(value = { "/ApproveManualReviseProposalMD" }, method = RequestMethod.POST)
public void ApproveManualReviseProposalMD(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
	System.out.println("Inside ApproveManualReviseProposalMD method");

	String crno = request.getParameter("crno");
	String status = request.getParameter("status");
	String tid = request.getParameter("tid");
	String MDnote = request.getParameter("MDnote");

	PrintWriter out = null;
	try {
		HttpSession htt = request.getSession(true);
		String uname = (String) htt.getAttribute("username");
		String company = (String) htt.getAttribute("usercompany");
		System.out.println("usernamemeeem login==" + uname);

		out = response.getWriter();
		String result = userActivityService.ApproveManualReviseProposalMD(crno, status, tid, uname, company,MDnote);
		System.out.println("Result value: " + result);
		out.print(result);
	} catch (Exception e) {
		System.out.println("Exception in Asave Company: " + e);
	}

}


@RequestMapping(value = { "/UpdatePOdates" }, method = RequestMethod.POST)
public void UpdatePOdates(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
	System.out.println("Inside UpdatePOdates method");

	String crno = request.getParameter("crno");
	String WstartDate = request.getParameter("WstartDate");
	String WendDate = request.getParameter("WendDate");
	String AMCstartDate = request.getParameter("AMCstartDate");
	String AMCendDate = request.getParameter("AMCendDate");


	PrintWriter out = null;
	try {
		HttpSession htt = request.getSession(true);
		String uname = (String) htt.getAttribute("username");
		
		System.out.println("usernamemeeem login==" + uname);

		out = response.getWriter();
		String result = userActivityService.UpdatePOdates(crno, WstartDate, WendDate, AMCstartDate, AMCendDate,uname);
		System.out.println("Result value: " + result);
		out.print(result);
	} catch (Exception e) {
		System.out.println("Exception in Asave Company: " + e);
	}
}



@RequestMapping(value = { "/UpdatePOTenuredates" }, method = RequestMethod.POST)
public void UpdatePOTenuredates(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
	System.out.println("Inside UpdatePOdates method");

	String crno = request.getParameter("crno");
	String TenureStartDate = request.getParameter("TenureStartDate");
	String TenureEndDate = request.getParameter("TenureEndDate");

	PrintWriter out = null;
	try {
		HttpSession htt = request.getSession(true);
		String uname = (String) htt.getAttribute("username");
		
		System.out.println("usernamemeeem login==" + uname);

		out = response.getWriter();
		String result = userActivityService.UpdatePOTenuredates(crno, TenureStartDate, TenureEndDate, uname);
		System.out.println("Result value: " + result);
		out.print(result);
	} catch (Exception e) {
		System.out.println("Exception in Asave Company: " + e);
	}

}

@RequestMapping(value = { "/saveupload" }, method = RequestMethod.POST)
public String saveupload(@RequestParam("invoiceFile") MultipartFile[] invoiceFile,HttpServletRequest request, HttpServletResponse response, HttpSession session) {
	PrintWriter out = null;
	try {
		out = response.getWriter();
		String uname = (String) session.getAttribute("username");
		String crno =request.getParameter("crno");
		String tid =request.getParameter("tid");
		
		System.out.println("manualProposalFile manualProposalFile manualProposalFile " + invoiceFile);
		System.out.println("crno " + invoiceFile);
		System.out.println("tid " + invoiceFile);
		
		
		
		String finals = userActivityService.saveupload(invoiceFile,uname,crno,tid);
		out.print(finals);
	} catch (IOException e) {
		e.printStackTrace();
	}
	return null;

}



@RequestMapping(value = { "/UpdatePOtypeDateManual" }, method = RequestMethod.POST)
public String UpdatePOtypeDateManual(ModelMap model, HttpServletRequest request, HttpServletResponse response,
		HttpSession session, ModelMap modelMap) {
	System.out.println("Inside Update ManualPurchaseOrder Controller@@@@@@@@@@@@ ");
	PrintWriter out = null;
	String details = null;
	
	try {
		out = response.getWriter();
		
		String loginuser=(String)session.getAttribute("username");
		String loginUserCompany = session.getAttribute("companyname").toString();
		
        String crno = request.getParameter("crno");
		
		String proposalType = request.getParameter("Proposaltype");
	
        
        String fixedyear = request.getParameter("fixedyear");
        String Subscriptionyear = request.getParameter("Subscriptionyear");
        String Perpetualyear = request.getParameter("Perpetualyear");
        String subscriptionANDperpetualYear = request.getParameter("subscriptionANDperpetualYear");
              
        System.out.println(" proposalType data :"+proposalType);
        System.out.println(" crnocrno data :"+crno);
    

        String tennurestartdate = request.getParameter("tennurestartdate");  
        String tennureenddate = request.getParameter("tennureenddate");
        String tennureMonth = request.getParameter("tennureMonth");
        String tennureYear = request.getParameter("tennureYear");
        
        System.out.println(" tennureYear data :"+tennureYear);
        
        String warrantystart = request.getParameter("warrantystart");      
        String warrantyend = request.getParameter("warrantyend");
        String warrantyMonth = request.getParameter("warrantyMonth");
        String warrantyYear = request.getParameter("warrantyYear");
               
        String amcstartdate = request.getParameter("amcstartdate");         
        String amcenddate = request.getParameter("amcenddate");
        String AMCMonth = request.getParameter("AMCMonth");
        String AMCYear = request.getParameter("AMCYear");
        String poRefNo = request.getParameter("poRefNo");
        

		String final_response = userActivityService.UpdatePOtypeDateManual(crno,proposalType,fixedyear, Subscriptionyear, Perpetualyear, subscriptionANDperpetualYear, tennurestartdate, tennureenddate,
		tennureMonth, tennureYear, warrantystart, warrantyend, warrantyMonth, warrantyYear, amcstartdate,
		amcenddate, AMCMonth, AMCYear,poRefNo);

		System.out.println("MastersControllerrrr reponse is = " + final_response);							
			out.print(final_response);
						
			System.out.println("insertManualPurchaseOrder GET SUCCESS");
		
	} catch (Exception e) {
		e.printStackTrace();
	}

	finally {
		out.close();
	}

	return null;

}



@RequestMapping(value = { "/rejectedReviseManualProposalByMD" }, method = RequestMethod.POST)
public void rejectedReviseManualProposalByMD(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
	System.out.println("Inside rejectedReviseManualProposalByMD method");

	String crno = request.getParameter("crno");
	String rejectreason = request.getParameter("val");
	String MDnote = request.getParameter("MDnote");
	String tid = request.getParameter("tid");

	PrintWriter out = null;
	try {
		HttpSession htt = request.getSession(true);
		String uname = (String) htt.getAttribute("username");
		String company = (String) htt.getAttribute("usercompany");
		System.out.println("usernamemeeem login==" + uname);
		System.out.println("company login==" + MDnote);
		out = response.getWriter();
		String result = userActivityService.rejectedReviseManualProposalByMD(crno, company, rejectreason, MDnote, uname,
				tid);
		System.out.println("rejecte mannual Result : " + result);
		out.print(result);
	} catch (Exception e) {
		System.out.println("Exception in Asave Company: " + e);
	}
}


@RequestMapping(value = {"/updateReviseManualProposal"},method = RequestMethod.POST )
public String updateReviseManualProposal(HttpServletRequest request, HttpServletResponse response,HttpSession session,@RequestParam("ManualFile") MultipartFile[] ManualReviseFile)
{
	PrintWriter out=null;
	try {
		out=response.getWriter();
		
		
		String uname = (String) session.getAttribute("username");
		String company = (String) session.getAttribute("usercompany");
       System.out.println("usernamemeeem login==" + uname);
       
       String poinitiator = request.getParameter("poinitiator");
       String amount = request.getParameter("amount");
       String poinitiatorno = request.getParameter("poinitiatorno");
       String FirstApprovername = request.getParameter("FirstApprovername");
       String firstapprovercontact = request.getParameter("firstapprovercontact");
       String secondApprovername = request.getParameter("secondApprovername");
       String secondapprovercontact = request.getParameter("secondapprovercontact");
       String clientname = request.getParameter("clientname");
       String Description = request.getParameter("Description");
       String SecureITprodversion = request.getParameter("SecureITprodversion");
       String Proposaltype = request.getParameter("Proposaltype");
       String Perpetualyear = request.getParameter("Perpetualyear");
       String Subscriptionyear = request.getParameter("Subscriptionyear");
       
       String productsuitselect = request.getParameter("productsuitselect");
       String Scanplusprodversion = request.getParameter("Scanplusprodversion");
       String fixedyear = request.getParameter("fixedyear");
       
       String enccustomername = request.getParameter("enccustomername");
       String crno = request.getParameter("crno");
       String tid = request.getParameter("tid");
       
       String SInote = request.getParameter("SInote");
       String contactperson = request.getParameter("contactperson");
   
       
       
       System.out.println("crnooo"+crno);
       System.out.println("tiddddd"+tid);
       
       
		String finals=userActivityService.updateReviseManualProposal(uname,company,ManualReviseFile,poinitiator,amount,poinitiatorno,FirstApprovername,
				firstapprovercontact,secondApprovername,secondapprovercontact,clientname,Description,SecureITprodversion,Proposaltype,Perpetualyear,
				Subscriptionyear,productsuitselect,Scanplusprodversion,fixedyear,enccustomername,crno,tid,SInote,contactperson);
		System.out.println("uploadFile"+ManualReviseFile);
		
		out.print(finals);
	}
	catch (IOException e)
	{
		e.printStackTrace();
	}
return null;

}



@RequestMapping(value = { "/getProjectDetails" }, method = RequestMethod.POST)
public JSONArray getProjectDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,HttpSession session) {
	PrintWriter out = null;

	try {
		out = response.getWriter();
		
		 String uname = (String) session.getAttribute("username");
		 String fullname = (String) session.getAttribute("fullname");
		 String role = (String) session.getAttribute("role");
		 String designation = (String) session.getAttribute("designation");
		JSONArray final_response = userActivityService.getProjectDetails(uname, fullname, role,designation);

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




@RequestMapping(value = { "/getAllProjectList" }, method = RequestMethod.POST)
public JSONArray getAllProjectList(ModelMap model, HttpServletRequest request, HttpServletResponse response,HttpSession session) {
	PrintWriter out = null;

	try {
		out = response.getWriter();
		
//		 String uname = (String) session.getAttribute("username");
//		 String fullname = (String) session.getAttribute("fullname");
//		 String role = (String) session.getAttribute("role");
//		 String designation = (String) session.getAttribute("designation");
		 String projectName = request.getParameter("projectName");
		 
		JSONArray final_response = userActivityService.getAllProjectList(projectName);

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


@RequestMapping(value = { "/getDelayedProjectList" }, method = RequestMethod.POST)
public JSONArray getDelayedProjectList(ModelMap model, HttpServletRequest request, HttpServletResponse response,HttpSession session) {
	PrintWriter out = null;

	try {
		out = response.getWriter();
		
//		 String uname = (String) session.getAttribute("username");
		 String fullname = (String) session.getAttribute("fullname");
		 String role = (String) session.getAttribute("role");
		 String designation = (String) session.getAttribute("designation");
//		 String projectName = request.getParameter("projectName");
		 
		JSONArray final_response = userActivityService.getDelayedProjectList(role, fullname, designation);

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


@RequestMapping(value = { "/getTLProjectDetails" }, method = RequestMethod.POST)
public JSONArray getTLProjectDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,HttpSession session) {
	PrintWriter out = null;

	try {
		out = response.getWriter();
		
		 String uname = (String) session.getAttribute("username");
		 String fullname = (String) session.getAttribute("fullname");
		 String role = (String) session.getAttribute("role");
		 String designation = (String) session.getAttribute("designation");
		 String TLname = request.getParameter("TLname");
		 System.out.println("innnn adadafds "+TLname);
		JSONArray final_response = userActivityService.getTLProjectDetails(uname, fullname, role,designation, TLname);

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



@RequestMapping(value = { "/getDevProjectDetails" }, method = RequestMethod.POST)
public JSONArray getDevProjectDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,HttpSession session) {
	PrintWriter out = null;

	try {
		out = response.getWriter();
		
		 String uname = (String) session.getAttribute("username");
		 String fullname = (String) session.getAttribute("fullname");
		 String role = (String) session.getAttribute("role");
		 String designation = (String) session.getAttribute("designation");
		 String DeveloperName = request.getParameter("DeveloperName");
		 System.out.println("innnn adadafds "+DeveloperName);
		JSONArray final_response = userActivityService.getDevProjectDetails(uname, fullname, role,designation, DeveloperName);

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


@RequestMapping(value = { "/getProjectDetailsManager" }, method = RequestMethod.POST)
public JSONArray getProjectDetailsManager(ModelMap model, HttpServletRequest request, HttpServletResponse response,HttpSession session) {
	PrintWriter out = null;

	try {
		out = response.getWriter();
		
		 String uname = (String) session.getAttribute("username");
		 String fullname = (String) session.getAttribute("fullname");
		 String role = (String) session.getAttribute("role");
		 String designation = (String) session.getAttribute("designation");
		 String managerName = request.getParameter("managerName");
		 System.out.println("innnn adadafds "+managerName);
		JSONArray final_response = userActivityService.getProjectDetailsManager(managerName);

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



@RequestMapping(value = { "/getProjectDetailsProgressMng" }, method = RequestMethod.POST)
public JSONArray getProjectDetailsProgressMng(ModelMap model, HttpServletRequest request, HttpServletResponse response,HttpSession session) {
	PrintWriter out = null;

	try {
		out = response.getWriter();
		
		 String fullname = (String) session.getAttribute("fullname");
//		 String role = (String) session.getAttribute("role");
		 String managerName = request.getParameter("managerName");
		JSONArray final_response = userActivityService.getProjectDetailsProgressMng(fullname, managerName);

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



@RequestMapping(value = { "/getTaskDetailsManager" }, method = RequestMethod.POST)
public JSONArray getTaskDetailsManager(ModelMap model, HttpServletRequest request, HttpServletResponse response,HttpSession session) {
	PrintWriter out = null;

	try {
		out = response.getWriter();
		
		 String uname = (String) session.getAttribute("username");
		 String fullname = (String) session.getAttribute("fullname");
		 String role = (String) session.getAttribute("role");
		 String designation = (String) session.getAttribute("designation");
		JSONArray final_response = userActivityService.getTaskDetailsManager(uname, fullname, role,designation);

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



@RequestMapping(value = { "/getTaskDetailsTL" }, method = RequestMethod.POST)
public JSONArray getTaskDetailsTL(ModelMap model, HttpServletRequest request, HttpServletResponse response,HttpSession session) {
	PrintWriter out = null;

	try {
		out = response.getWriter();
		
		 String uname = (String) session.getAttribute("username");
		 String fullname = (String) session.getAttribute("fullname");
		 String role = (String) session.getAttribute("role");
		 String designation = (String) session.getAttribute("designation");
		JSONArray final_response = userActivityService.getTaskDetailsTL(fullname,role,designation);

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




@RequestMapping(value = { "/getTaskDetailsDev" }, method = RequestMethod.POST)
public JSONArray getTaskDetailsDev(ModelMap model, HttpServletRequest request, HttpServletResponse response,HttpSession session) {
	PrintWriter out = null;

	try {
		out = response.getWriter();
		
		 String uname = (String) session.getAttribute("username");
		 String fullname = (String) session.getAttribute("fullname");
		 String role = (String) session.getAttribute("role");
		 String designation = (String) session.getAttribute("designation");
		JSONArray final_response = userActivityService.getTaskDetailsDev(fullname,role,designation);

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



@RequestMapping(value = { "/ReviseManualProposalRejectDetailsSI" }, method = RequestMethod.POST)
public JSONArray ReviseManualProposalRejectDetailsSI(ModelMap model, HttpServletRequest request, HttpServletResponse response,HttpSession session) {
	
	PrintWriter out = null;

	try {
		out = response.getWriter();
		
		 String uname = (String) session.getAttribute("username");
		 String company = (String) session.getAttribute("usercompany");
		JSONArray final_response = userActivityService.ReviseManualProposalRejectDetailsSI(uname,company);

		System.out.println("MastersControllerrrr reponse is = " + final_response);
					
			out.print(final_response);
					
			System.out.println("username GET SUCCESS");
		
	} catch (Exception e) {
		e.printStackTrace();
	}

	finally {
		out.close();
	}
//	return "Dashboard";
	return null;
	
}

//13/05
@RequestMapping(value = { "/trackLoginActivityDetails" }, method = RequestMethod.POST)
public JSONArray trackLoginActivityDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,HttpSession session) {
	System.out.println("Inside trackDetails details Controller@@@@@@@@@@@@ ");
	PrintWriter out = null;

	try {
		out = response.getWriter();
		String fromDate = request.getParameter("fromDate");
		
		 System.out.println("fromDate55555555555"+fromDate);
		 String toDate = request.getParameter("toDate");
		 String selecttype = request.getParameter("selecttype");
		 String selectType2 = request.getParameter("selectType2");
		JSONArray final_response = userActivityService.trackLoginActivityDetails(fromDate,toDate,selecttype,selectType2);

		System.out.println("MastersControllerrrr reponse is = " + final_response);
					
			out.print(final_response);
					
			System.out.println("username GET SUCCESS");
		
	} catch (Exception e) {
		e.printStackTrace();
	}

	finally {
		out.close();
	}
//	return "Dashboard";
	return null;
	
}




//01/08
@RequestMapping(value = { "/getTaskDetailsSupport" }, method = RequestMethod.POST)
public JSONArray getTaskDetailsSupport(ModelMap model, HttpServletRequest request, HttpServletResponse response,HttpSession session) {
	PrintWriter out = null;

	try {
		out = response.getWriter();
		
		 String uname = (String) session.getAttribute("username");
		 String fullname = (String) session.getAttribute("fullname");
		 String role = (String) session.getAttribute("role");
		 String designation = (String) session.getAttribute("designation");
		JSONArray final_response = userActivityService.getTaskDetailsSupport(uname, fullname, role,designation);

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



@RequestMapping(value = { "/getProjectDetailsSupport" }, method = RequestMethod.POST)
public JSONArray getProjectDetailsSupport(ModelMap model, HttpServletRequest request, HttpServletResponse response,HttpSession session) {
	PrintWriter out = null;
	System.out.println("In supppppp");
	try {
		out = response.getWriter();
		
		 String uname = (String) session.getAttribute("username");
		 String fullname = (String) session.getAttribute("fullname");
		 String role = (String) session.getAttribute("role");
		 String designation = (String) session.getAttribute("designation");
		JSONArray final_response = userActivityService.getProjectDetailsSupport(uname, fullname, role,designation);

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






//


//09/08
@RequestMapping(value = { "/getTLProjectDetailsSupport" }, method = RequestMethod.POST)
public JSONArray getTLProjectDetailsSupport(ModelMap model, HttpServletRequest request, HttpServletResponse response,HttpSession session) {
	PrintWriter out = null;

	try {
		out = response.getWriter();
		
		 String uname = (String) session.getAttribute("username");
		 String fullname = (String) session.getAttribute("fullname");
		 String role = (String) session.getAttribute("role");
		 String designation = (String) session.getAttribute("designation");
		 String TLname = request.getParameter("TLname");
		 System.out.println("innnn adadafds "+TLname);
		JSONArray final_response = userActivityService.getTLProjectDetailsSupport(uname, fullname, role,designation, TLname);

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




@RequestMapping(value = { "/getProjectDetailsSupport1" }, method = RequestMethod.POST)
public JSONArray getProjectDetailsSupport1(ModelMap model, HttpServletRequest request, HttpServletResponse response,HttpSession session) {
	PrintWriter out = null;
	System.out.println("In supppppp");
	try {
		out = response.getWriter();
		
		 String uname = (String) session.getAttribute("username");
		 String fullname = (String) session.getAttribute("fullname");
		 String role = (String) session.getAttribute("role");
		 String designation = (String) session.getAttribute("designation");
		JSONArray final_response = userActivityService.getProjectDetailsSupport1(uname, fullname, role,designation);

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






@RequestMapping(value = { "/getDevProjectDetailsSupport" }, method = RequestMethod.POST)
public JSONArray getDevProjectDetailsSupport(ModelMap model, HttpServletRequest request, HttpServletResponse response,HttpSession session) {
	PrintWriter out = null;

	try {
		out = response.getWriter();
		
		 String uname = (String) session.getAttribute("username");
		 String fullname = (String) session.getAttribute("fullname");
		 String role = (String) session.getAttribute("role");
		 String designation = (String) session.getAttribute("designation");
		 String DeveloperName = request.getParameter("DeveloperName");
		 System.out.println("innnn adadafds "+DeveloperName);
		JSONArray final_response = userActivityService.getDevProjectDetailsSupport(uname, fullname, role,designation, DeveloperName);

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
//


@RequestMapping(value = { "/uploadInvoice" }, method = RequestMethod.POST)
public String uploadInvoice(@RequestParam("invoicefile") MultipartFile[] invoicefile,ModelMap model, HttpServletRequest request, HttpServletResponse response,
		HttpSession session, ModelMap modelMap) {
	System.out.println("Inside uploadInvoice Controller@@@@@@@@@@@@ ");
	PrintWriter out = null;
	String details = null;
	
	try {
		out = response.getWriter();
		
		String username=(String)session.getAttribute("username");
		String fullname = (String) session.getAttribute("fullname");
		String srno = request.getParameter("srno");
			
		String final_response = userActivityService.uploadInvoice(invoicefile, username, fullname, srno);
		System.out.println("uploadInvoice reponse is = " + final_response);	
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



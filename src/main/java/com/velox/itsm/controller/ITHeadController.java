package com.velox.itsm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/ITHead")
@SessionAttributes("roles")
public class ITHeadController {

	@RequestMapping(value = { "/IT-HeadHome" }, method = RequestMethod.GET)
	public String home(ModelMap model) {

		return "/ITHeadDashboard";
	}

	@RequestMapping(value = { "/SLA_Report" }, method = RequestMethod.GET)
	public String slareport(ModelMap model) {

		return "/SLA_Report";
	}

	@RequestMapping(value = { "/SLA_ENG_Report" }, method = RequestMethod.GET)
	public String sla_eng_report(ModelMap model) {

		return "/SLA_ENG_Report";
	}

	@RequestMapping(value = { "/SLA_Vendor_Report" }, method = RequestMethod.GET)
	public String sla_vendor_report(ModelMap model) {

		return "/SLA_Vendor_Report";
	}
	
	@RequestMapping(value = { "/Problem_SLA_Report" }, method = RequestMethod.GET)
	public String problemslareport(ModelMap model) {

		return "/Problem_SLA_Report";
	}
	
	@RequestMapping(value = { "/Engg_Problem_SLA_Report" }, method = RequestMethod.GET)
	public String enggproblemslareport(ModelMap model) {

		return "/Engg_Problem_SLA_Report";
	}
	
	@RequestMapping(value = { "/Vendor_Problem_SLA_Report" }, method = RequestMethod.GET)
	public String vendorproblemslareport(ModelMap model) {

		return "/Vendor_Problem_SLA_Report";
	}
	@RequestMapping(value = { "/Response_SLA_Report" }, method = RequestMethod.GET)
	public String response_SLA_report(ModelMap model) {

		return "/Response_SLA_Report";
	}
	@RequestMapping(value = { "/SR_Response_SLA_Report" }, method = RequestMethod.GET)
	public String sr_response_SLA_report(ModelMap model) {

		return "/SR_Response_SLA_Report";
	}

	
	@RequestMapping(value = { "/Service_SLA_Report" }, method = RequestMethod.GET)
	public String Service_SLA_Report(ModelMap model) {

		return "/Service_SLA_Report";
	}
}
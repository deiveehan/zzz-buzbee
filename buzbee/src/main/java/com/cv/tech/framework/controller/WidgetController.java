/**
 * 
 */
package com.cv.tech.framework.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cv.tech.framework.document.AppUserWidgets;
import com.cv.tech.framework.document.Widget;
import com.cv.tech.framework.service.WidgetService;
import com.cv.tech.framework.value.JQGridResponse;
import com.cv.tech.framework.value.MessageValue;
import com.cv.tech.framework.value.WidgetValue;

/**
 * @author Deiveehan
 *
 */
@Controller
@RequestMapping(value="widget")
public class WidgetController extends BaseController {
	Logger logger = Logger.getLogger(WidgetController.class);
	
	@Autowired
	private MongoTemplate mongoTemplate;

	@Autowired
	private WidgetService widgetService;
	
	@RequestMapping(value="/loadWidgetEdit")
	public String loadWidgetPage(Model model) {
		WidgetValue widgetValue = new WidgetValue();
		model.addAttribute("widgetValue", widgetValue);
		return "tech/widgetedit";
	}
	
	@RequestMapping(value="/getAllWidgets")
	public @ResponseBody List<Widget> getAllWidgets() {
		List<Widget> widgets = widgetService.getAllWidgets();
		return widgets;
	}
	
	@RequestMapping(value="/viewWidgets", method=RequestMethod.GET)
	@ResponseBody
	public JQGridResponse viewWidgets(@RequestParam("_search") Boolean search,
    		@RequestParam(value="filters", required=false) String filters,
    		@RequestParam(value="page", required=false) Integer page,
    		@RequestParam(value="rows", required=false) Integer rows,
    		@RequestParam(value="sidx", required=false) String sidx,
    		@RequestParam(value="sord", required=false) String sord) {
		
		List<Widget> widgetList = null;
		//Page<Widget> widgetPageList = null;
		
		JQGridResponse jqGridResponse = new JQGridResponse();
		Pageable pageRequest = new PageRequest(page-1, rows);
		long count = 0;
		int countOfWidgetListReturned = 0;
		
		//widgetPageList = widgetRepository.findAll(pageRequest);
		Query query = new Query();
		query.addCriteria(Criteria.where("userPID").is(getCurrentUserPID()));
		query.skip((page-1) * rows);
		query.limit(rows);
		
		Query countQuery = new Query();
		countQuery.addCriteria(Criteria.where("userPID").is(getCurrentUserPID()));
		
		widgetList = mongoTemplate.find(query, Widget.class);
		if(widgetList!= null) {
			countOfWidgetListReturned = widgetList.size();
		}
		count = mongoTemplate.count(new Query(), Widget.class);
		logger.info("Count : " + count);
		logger.info("Records retrieved : " + countOfWidgetListReturned);
		//widgetList = widgetPageList.getContent();
		//widgetDTOList = WidgetMapper.map(widgetPageList);
		
		jqGridResponse.setPage(1);
		
		if(widgetList!= null) {
			
			jqGridResponse.setRecords(countOfWidgetListReturned);
			jqGridResponse.setTotal((int) count);
			jqGridResponse.setPage(page);
		}
		jqGridResponse.setRows(widgetList);
		return jqGridResponse;
	}

	@RequestMapping(value="/loadSubscribeWidget", method=RequestMethod.GET)
	public String loadSubscribeWidget() {
		return "tech/subscribewidget";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public @ResponseBody String save(@ModelAttribute WidgetValue widgetValue) {
		MessageValue messageValue = new MessageValue();
		widgetValue.setUserPID(getCurrentUserPID());
		widgetValue.setAppUser(getCurrentAppUser());
		System.out.println("Gadget File : " + widgetValue.getWidgetFile().getOriginalFilename());
		System.out.println("Gadget Screenshot File : " + widgetValue.getScreenshotFile().getOriginalFilename());
		System.out.println("Gadget Icon File : " + widgetValue.getThumbnailFile().getOriginalFilename());
		widgetService.save(widgetValue);
		messageValue.setMessage("Widget added !!");
		return "Widget uploaded";
	}
	
	@RequestMapping(value="/subscribeWidget/{widgetPID}", method=RequestMethod.GET)
	public @ResponseBody MessageValue subscribeWidget(@PathVariable(value="widgetPID") String widgetPID) {
		MessageValue messageValue = new MessageValue();
		logger.info("Widget ID Passed: " + widgetPID);
		
		AppUserWidgets appUserWidgets = new AppUserWidgets();
		appUserWidgets.setWidgetPID(widgetPID);
		appUserWidgets.setUserPID(getCurrentUserPID());
		String message = widgetService.subscribeWidget(appUserWidgets);
		messageValue.setMessage(message);
		return messageValue;
	}
	
	@RequestMapping(value="/unsubscribeWidget/{widgetPID}", method=RequestMethod.GET)
	public @ResponseBody MessageValue unsubscribeWidget(@PathVariable(value="widgetPID") String widgetPID) {
		MessageValue messageValue = new MessageValue();
		logger.info("Widget ID Passed: " + widgetPID);
		
		AppUserWidgets appUserWidgets = new AppUserWidgets();
		appUserWidgets.setWidgetPID(widgetPID);
		appUserWidgets.setUserPID(getCurrentUserPID());
		String message = widgetService.unsubscribe(appUserWidgets);
		messageValue.setMessage(message);
		return messageValue;
	}
	
	@RequestMapping(value="/getMyWidgets")
	public @ResponseBody List<Widget> getMyWidgets() {
		List<Widget> widgets = widgetService.getWidgetsForUser(getCurrentUserPID());
		return widgets;
	}
	@RequestMapping(value = "/loadWidgetViewPage", method = RequestMethod.GET)
	public String loadWidgetViewPage(Model model) {
		return "tech/widgetViewPage";
	}
}

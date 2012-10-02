package com.lv.tica.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lv.tica.renderer.PageKey;
import com.lv.tica.renderer.PageKey.BRANDS;
import com.lv.tica.renderer.PageKey.DEVICE_TYPES;
import com.lv.tica.renderer.composite.CompositeHtmlRenderer;
import com.lv.tica.renderer.composite.QuestionComposite;
import com.lv.tica.renderer.composite.QuestionGroup;
import com.lv.tica.renderer.composite.QuestionProperties;

@Controller
public class DynamicHtmlController {
	
	@RequestMapping(value="/*/{brand}")
	public String aPage(HttpServletRequest req, @PathVariable("brand") String brand) {
		Map<PageKey, List<QuestionComposite>> pageQuestionMetaMap = new TreeMap<PageKey, List<QuestionComposite>>();
		List<QuestionComposite> questions = null;
		PageKey pageKey = null;
		
		if("nw".equalsIgnoreCase(brand)) {
			questions = nwDesktopPage1Questions();
			pageKey = new PageKey(DEVICE_TYPES.DESKTOP, BRANDS.NW, 1);
		} else {
			questions = lvDesktopPage1Questions();
			pageKey = new PageKey(DEVICE_TYPES.DESKTOP, BRANDS.LV, 1);
		}
		
		pageQuestionMetaMap.put(pageKey, questions);
		CompositeHtmlRenderer htmlRenderer = new CompositeHtmlRenderer(pageQuestionMetaMap);		
		req.setAttribute("dynamicContent", htmlRenderer.renderPage(pageKey));
		return "helloStuart";
	}
	
	private List<QuestionComposite> lvDesktopPage1Questions() {
		List<QuestionComposite> questions = new ArrayList<QuestionComposite>();
		QuestionGroup group1 = new QuestionGroup("group1");
		group1.add(new QuestionProperties("What is your vehicle make?", "vehicle.make", "text"));
		group1.add(new QuestionProperties("What is your vehicle model?", "vehicle.model", "text"));
		questions.add(group1);
		QuestionGroup group2 = new QuestionGroup("group2");
		group2.add(new QuestionProperties("When was your vehicle made?", "vehicle.yom", "number"));
		group2.add(new QuestionProperties("What's the regno?", "vehicle.vrn", "text"));
		questions.add(group2);
		questions.add(new QuestionProperties("What's the colour?", "vehicle.colour", "text"));
		return questions;
	}
	
	private List<QuestionComposite> nwDesktopPage1Questions() {
		List<QuestionComposite> questions = new ArrayList<QuestionComposite>();
		QuestionGroup group1 = new QuestionGroup("group1");
		group1.add(new QuestionProperties("What is your vehicle make init?", "vehicle.make", "text"));
		group1.add(new QuestionProperties("What is your vehicle model init?", "vehicle.model", "text"));
		questions.add(group1);
		QuestionGroup group2 = new QuestionGroup("group2");
		group2.add(new QuestionProperties("When was your vehicle made init?", "vehicle.yom", "number"));
		group2.add(new QuestionProperties("What's the regno init?", "vehicle.vrn", "text"));
		questions.add(group2);
		questions.add(new QuestionProperties("What's the colour init?", "vehicle.colour", "text"));
		return questions;
	}

}

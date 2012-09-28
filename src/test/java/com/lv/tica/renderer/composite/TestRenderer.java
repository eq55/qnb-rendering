package com.lv.tica.renderer.composite;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.custommonkey.xmlunit.Diff;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

import com.lv.tica.renderer.PageKey;
import com.lv.tica.renderer.PageKey.BRANDS;
import com.lv.tica.renderer.PageKey.DEVICE_TYPES;

public class TestRenderer {
	
	Map<PageKey, List<QuestionComposite>> pageQuestionMetaMap = new TreeMap<PageKey, List<QuestionComposite>>();

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDesktopSingleBrandSinglePageHtml() throws IOException, SAXException {
		List<QuestionComposite> questions = lvDesktopPage1Questions();
		PageKey pageKey = new PageKey(DEVICE_TYPES.DESKTOP, BRANDS.LV, 1);
		pageQuestionMetaMap.put(pageKey, questions);
		CompositeHtmlRenderer htmlRenderer = new CompositeHtmlRenderer(pageQuestionMetaMap);		
		String expectedHtml  =
			"<div>" +
				"<div class=\"group1\">" +
					"What is your vehicle make?<input type=\"text\" name=\"vehicle.make\"/>" +
					"What is your vehicle model?<input type=\"text\" name=\"vehicle.model\"/>" +
				"</div>" + 
				"<div class=\"group2\">" +
					"When was your vehicle made?<input type=\"number\" name=\"vehicle.yom\"/>" +
					"What's the regno?<input type=\"text\" name=\"vehicle.vrn\"/>" +
				"</div>" +
				"What's the colour?<input type=\"text\" name=\"vehicle.colour\"/>" +
			"</div>";
		Diff xmlDifference = new Diff (expectedHtml, htmlRenderer.renderPage(pageKey));
		assertTrue(xmlDifference.identical());
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

}

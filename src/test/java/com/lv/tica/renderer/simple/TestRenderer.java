package com.lv.tica.renderer.simple;

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
	
	Map<PageKey, List<QuestionProperties>> pageQuestionMetaMap = new TreeMap<PageKey, List<QuestionProperties>>();

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDesktopSingleBrandSinglePageHtml() throws IOException, SAXException {
		List<QuestionProperties> questions = lvDesktopPage1Questions();
		PageKey pageKey = new PageKey(DEVICE_TYPES.DESKTOP, BRANDS.LV, 1);
		pageQuestionMetaMap.put(pageKey, questions);
		SimpleHtmlRenderer htmlRenderer = new SimpleHtmlRenderer(pageQuestionMetaMap);		
		String expectedHtml  = "<div>" +
				"What is your vehicle make?<input type=\"text\" name=\"vehicle.make\"/>" +
				"What is your vehicle model?<input type=\"text\" name=\"vehicle.model\"/>" +
				"When was your vehicle made?<input type=\"number\" name=\"vehicle.yom\"/>" +
				"What's the regno?<input type=\"text\" name=\"vehicle.vrn\"/>" +
				"</div>";
		Diff xmlDifference = new Diff (expectedHtml, htmlRenderer.renderPage(pageKey));
		assertTrue(xmlDifference.identical());
	}

	private List<QuestionProperties> lvDesktopPage1Questions() {
		List<QuestionProperties> questions = new ArrayList<QuestionProperties>();
		questions.add(new QuestionProperties("What is your vehicle make?", "vehicle.make", "text"));
		questions.add(new QuestionProperties("What is your vehicle model?", "vehicle.model", "text"));
		questions.add(new QuestionProperties("When was your vehicle made?", "vehicle.yom", "number"));
		questions.add(new QuestionProperties("What's the regno?", "vehicle.vrn", "text"));
		return questions;
	}
	
	private List<QuestionProperties> nwDesktopPage1Questions() {
		List<QuestionProperties> questions = new ArrayList<QuestionProperties>();
		questions.add(new QuestionProperties("Vehicle make?", "vehicle.make", "text"));
		questions.add(new QuestionProperties("Vehicle model?", "vehicle.model", "text"));
		questions.add(new QuestionProperties("Vehicle manufacturer date?", "vehicle.yom", "number"));
		questions.add(new QuestionProperties("Regno?", "vehicle.vrn", "text"));
		return questions;
	}
	
	@Test
	public void testDesktopDualBrandSinglePageHtml() throws IOException, SAXException {
		PageKey lvPage1Key = new PageKey(DEVICE_TYPES.DESKTOP, BRANDS.LV, 1);
		PageKey nwPage1Key = new PageKey(DEVICE_TYPES.DESKTOP, BRANDS.NW, 1);
		pageQuestionMetaMap.put(lvPage1Key, lvDesktopPage1Questions());
		pageQuestionMetaMap.put(nwPage1Key, nwDesktopPage1Questions());
		SimpleHtmlRenderer htmlRenderer = new SimpleHtmlRenderer(pageQuestionMetaMap);		
		String lvExpectedHtml  = "<div>" +
				"What is your vehicle make?<input type=\"text\" name=\"vehicle.make\"/>" +
				"What is your vehicle model?<input type=\"text\" name=\"vehicle.model\"/>" +
				"When was your vehicle made?<input type=\"number\" name=\"vehicle.yom\"/>" +
				"What's the regno?<input type=\"text\" name=\"vehicle.vrn\"/>" +
				"</div>";
		Diff xmlDifference = new Diff (lvExpectedHtml, htmlRenderer.renderPage(lvPage1Key));
		assertTrue(xmlDifference.identical());
		String nwExpectedHtml  = "<div>" +
				"Vehicle make?<input type=\"text\" name=\"vehicle.make\"/>" +
				"Vehicle model?<input type=\"text\" name=\"vehicle.model\"/>" +
				"Vehicle manufacturer date?<input type=\"number\" name=\"vehicle.yom\"/>" +
				"Regno?<input type=\"text\" name=\"vehicle.vrn\"/>" +
				"</div>";
		xmlDifference = new Diff (nwExpectedHtml, htmlRenderer.renderPage(nwPage1Key));
		assertTrue(xmlDifference.identical());
		
	}

}

package com.lv.tica.renderer.html;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class AbstractHTMLComponent implements Renderer {

	private String name;
	
	private Map<String, String> attributes;
	
	private List<? extends Renderer> children;
	
	protected AbstractHTMLComponent(String name) {
		this.name = name;
		this.attributes = new HashMap<String, String>();
		this.children = new ArrayList<Renderer>();
	}

	@Override
	public String render() {
		StringBuilder s = new StringBuilder();
		
		s.append("<");
		s.append(name);
		
		if (attributes.size() > 0) {
			s.append(mapToString(attributes));
		}
		
		// TODO self-closing
		s.append(">");
		
		for (Renderer o : children) {
			// TODO render children
			s.append(o.render());
		}
		
		// TODO real-closing
		return s.toString();
	}

	private String mapToString(Map<String, String> attributes) {

		StringBuilder s = new StringBuilder();
		
		Set<Entry<String, String>> entrySet = attributes.entrySet();
		for (Entry<String, String> e : entrySet) {
			s.append(" ");
			s.append(e.getKey());
			s.append("=\"");
			s.append(e.getValue());
			s.append("\"");
		}
		
		return s.toString();
	}
}

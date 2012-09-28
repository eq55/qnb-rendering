package com.lv.tica.renderer;


public interface ContentRenderer {
	
	/**
	 * @return a String representing content for a logical page
	 */
	public String renderPage(PageKey pageKey);

}

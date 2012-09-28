package com.lv.tica.renderer;

public class PageKey implements Comparable<PageKey> {
	
	public enum DEVICE_TYPES {
		MOBILE, DESKTOP
	}
	
	public enum BRANDS {
		LV, NW
	}

	private DEVICE_TYPES device;
	private BRANDS brand;
	private int pageNumber;
	
	public PageKey(PageKey.DEVICE_TYPES device, PageKey.BRANDS brand, int pageNumber) {
		this.device = device;
		this.brand = brand;
		this.pageNumber = pageNumber;
	}

	@Override
	public int compareTo(PageKey otherPageKey) {
		int diff = brand.compareTo(otherPageKey.brand);
		if (diff != 0) {
			return diff;
		}
		diff = device.compareTo(otherPageKey.device);
		if (diff != 0) {
			return diff;
		}
		return pageNumber - otherPageKey.pageNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + ((device == null) ? 0 : device.hashCode());
		result = prime * result + pageNumber;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PageKey other = (PageKey) obj;
		if (brand != other.brand)
			return false;
		if (device != other.device)
			return false;
		if (pageNumber != other.pageNumber)
			return false;
		return true;
	}

}

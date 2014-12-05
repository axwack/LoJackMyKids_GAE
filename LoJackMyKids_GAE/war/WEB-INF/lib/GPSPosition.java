package com.google.android.gcm.demo.server;


public class GPSPosition {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Double lat, lng;
	private String regId;

	public GPSPosition(Double lat, Double lng, String regId){
		
		this.lat = lat;
		this.lng = lng;
		this.regId=regId;
	}

	public GPSPosition(double latitude, double longitude, String regId) {
		this.lat = latitude;
		this.lng = longitude;
		this.regId = regId;
	}
	
	
}

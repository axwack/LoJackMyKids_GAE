package com.google.android.gcm.demo.server;

import java.util.ArrayList;
import java.util.List;


public class GPSPosition {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Double lat, lng;
	private ArrayList<String> regId;
	
	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public Double getLng() {
		return lng;
	}

	public void setLng(Double lng) {
		this.lng = lng;
	}

	public List<String> getRegId() {
		return regId;
	}

	public void setRegId(ArrayList<String> regId) {
		this.regId = regId;
	}

	public GPSPosition(Double lat, Double lng, ArrayList<String> regId){
		
		this.lat = lat;
		this.lng = lng;
		this.regId=regId;
	}

	public GPSPosition(double latitude, double longitude, ArrayList<String> regId) {
		this.lat = latitude;
		this.lng = longitude;
		this.regId = regId;
	}
	
	public String toString(){
		return "GPSPosition Lat: " + this.lat + " Lng: "+ this.lng + "RegId(s): "+ this.regId.toString()+ "";
	}
	
}

package com.stoom.dsilva.api.google.service;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class GoogleModelApi {

	private String latitude;
	private String longitute;
	
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitute() {
		return longitute;
	}
	public void setLongitute(String longitute) {
		this.longitute = longitute;
	}
	@Override
	public String toString() {
		return "GoogleModelApi [latitude=" + latitude + ", longitute=" + longitute + "]";
	}
	
	

}

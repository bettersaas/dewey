package com.dewey.his.param.service;

import com.dewey.his.param.model.HotelInfoSetting;

public interface HotelInfoSettingManager {
	
	public Long save(HotelInfoSetting hotelInfoSetting);
	
	public void saveOrUpdate(HotelInfoSetting hotelInfoSetting);
	
	public void update(HotelInfoSetting hotelInfoSetting);
	
	public HotelInfoSetting getById(long id);
	
	public HotelInfoSetting getByMerId(long merId);
	
	public int deleteById(long id);

}

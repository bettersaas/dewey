package com.dewey.his.param.service.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dewey.his.param.dao.HotelInfoSettingDAO;
import com.dewey.his.param.model.HotelInfoSetting;
import com.dewey.his.param.service.HotelInfoSettingManager;

@Service("hotelInfoSettingManager")
@Scope("singleton")
@Transactional
public class HotelInfoSettingManagerImpl  implements  HotelInfoSettingManager{
	
	private HotelInfoSettingDAO  hotelInfoSettingDAO;
	
	public void setHotelInfoSettingDAO(HotelInfoSettingDAO hotelInfoSettingDAO) {
		this.hotelInfoSettingDAO = hotelInfoSettingDAO;
	}
	
	@Transactional
	public int deleteById(long id) {
		return hotelInfoSettingDAO.deleteById(HotelInfoSetting.class,id);
	}

	@Transactional(readOnly = true)
	public HotelInfoSetting getById(long id) {
		return (HotelInfoSetting)hotelInfoSettingDAO.getById(HotelInfoSetting.class,id);
	}

	@Transactional
	public void saveOrUpdate(HotelInfoSetting hotelInfoSetting) {
		hotelInfoSettingDAO.saveOrUpdate(hotelInfoSetting);		
	}

	@Transactional
	public Long save(HotelInfoSetting hotelInfoSetting) {
		return hotelInfoSettingDAO.save(hotelInfoSetting);
	}

	@Transactional
	public void update(HotelInfoSetting hotelInfoSetting) {
		hotelInfoSettingDAO.update(hotelInfoSetting);		
	}
	
	@Transactional(readOnly = true)
	public HotelInfoSetting getByMerId(long merId) {
		return hotelInfoSettingDAO.getByMerId(merId);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}

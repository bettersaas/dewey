package common.base.web;

import java.beans.PropertyEditorSupport;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

public class MyBindingInitializer implements WebBindingInitializer {

//	@InitBinder
//	public void initBinder(WebDataBinder binder) {
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//		dateFormat.setLenient(false);
//		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
//	}
	
	public void initBinder(WebDataBinder binder, WebRequest request) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
		binder.registerCustomEditor(Timestamp.class, new PropertyEditorSupport() {
			public void setAsText(String value) {
				try {
					Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(value);
					setValue(new Timestamp(date.getTime()));
				} catch (java.text.ParseException e) {
					setValue(null);
				}
			}
			public String getAsText() {
				Date value = (Date)getValue();
				return value == null ? "" : new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(value);
			}
		});
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(false));
		binder.registerCustomEditor(BigDecimal.class, new CustomNumberEditor(BigDecimal.class, false));
		binder.registerCustomEditor(Integer.class, null, new CustomNumberEditor(Integer.class, null, true));
		binder.registerCustomEditor(int.class, null, new CustomNativeEditor(Integer.class, null, true));
		binder.registerCustomEditor(Long.class, null, new CustomNumberEditor(Long.class, null, true));
		binder.registerCustomEditor(long.class, null, new CustomNativeEditor(Long.class, null, true));
		binder.registerCustomEditor(Float.class, new CustomNumberEditor(Float.class, true));
		binder.registerCustomEditor(Double.class, new CustomNumberEditor(Double.class, true));
		binder.registerCustomEditor(BigInteger.class, new CustomNumberEditor(BigInteger.class, true));
	}
	
	// public void initBinder(WebDataBinder binder, WebRequest request) {
	// SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	// dateFormat.setLenient(false);
	// binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	// }
}
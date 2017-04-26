package org.wtoip.analysis.core.util;

import com.wtoip.analysis.core.util.JSR303Util;
import com.wtoip.analysis.model.ShopDesign;

/** 
 *  @Description
 *	@author wanghongwei
 *  @date   2017年4月20日
 */
public class JSR030Test {

	public static void main(String[] args) {
		ShopDesign shopDesign = new ShopDesign();
		ShopDesign._Id id = new ShopDesign._Id();
		id.setApp("mall");
		id.setMallId("222");
		id.setMemberId("2222");
		id.setIndustryCode1("1");
		id.setIndustryCode2("1");
		id.setCreateDate("2017-04-20");
		//shopDesign.setId(id);
		shopDesign.setTotalScore(20D);
		
		JSR303Util.validate(shopDesign);
		
	}
	
}

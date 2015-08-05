package com.zxxt.serviceImp;

import java.util.List;
import java.util.Map;

import com.zxxt.dao.IbaseDao;
import com.zxxt.daoImp.BaseDaoImp;

public class UserPhoneLogServiceImp extends BaseServiceImp {
	IbaseDao dao=new BaseDaoImp();
	@Override
	public int add(Object object) {
		try {
			return dao.add(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public List<Object> selectALL(Map<String, String> map,String className) {
		StringBuffer sql=new StringBuffer(" select * from USERPHONELOG where 1=1 ");
		if(map.containsKey("startDate")&& map.containsKey("endDate"))
			sql.append(" and option_date between '"+map.get("startDate")+"' and '"+map.get("endDate")+"' ");
		else if(map.containsKey("startDate"))
			sql.append(" and option_date > '"+map.get("startDate")+"' ");
		else if(map.containsKey("endDate"))
			sql.append(" and option_date < '"+map.get("endDate")+"' ");
		
		if(map.containsKey("content")){
			sql.append(" and (platform like '%"+map.get("content")+"%' or factory like '%"+map.get("content")+"%' or hardware_version like '%"+map.get("content")+"%' or os_version like '%"+map.get("content")+"%' or application_version like '%"+map.get("content")+"%' or  errorMsg like '%"+map.get("content")+"%') ");
		}
		sql.append("order by option_date desc");
		try {
			return dao.selectALL(sql.toString(),className);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}

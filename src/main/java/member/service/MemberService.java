package member.service;

import member.dao.MemberInfoDao;
import member.dto.MemberInfo;

public class MemberService {

	public boolean join (MemberInfo memberInfo) {
		MemberInfoDao dao = new MemberInfoDao();
		
		return dao.insert(memberInfo);
		
	}
	
}

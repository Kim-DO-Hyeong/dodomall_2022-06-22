package member.service;

import member.dao.MemberInfoDao;
import member.dto.MemberInfo;

public class MemberService {

	public boolean join (MemberInfo memberInfo) {
		MemberInfoDao dao = new MemberInfoDao();
		
		if(dao.selectById(memberInfo.getId()) != null || dao.selectByTel(memberInfo.getTel()) != null || dao.selectByEmail(memberInfo.getEmail()) != null) {
			return false;
		}else {
			return dao.insert(memberInfo);
		}
	}
	
	public MemberInfo login(MemberInfo memberInfo){
		MemberInfoDao dao = new MemberInfoDao();
		
		MemberInfo selectedMemberInfo = dao.selectById(memberInfo.getId());
		
		if(selectedMemberInfo == null) {
			return null;
		}else if(!selectedMemberInfo.getPw().equals(memberInfo.getPw())) {
			return null;
		}
		
		return selectedMemberInfo;
	}
	
	public boolean update(MemberInfo memberInfo) {
		MemberInfoDao dao = new MemberInfoDao();
		
		
		if(dao.selectByTel(memberInfo.getTel()) != null || dao.selectByEmail(memberInfo.getEmail()) != null) {
			return false;
		}else {
			return dao.update(memberInfo);
		}
		
	}
	
	public boolean delete(int memberIdx) {
		MemberInfoDao dao = new MemberInfoDao();
		
		return dao.delete(memberIdx);
	}
	
}

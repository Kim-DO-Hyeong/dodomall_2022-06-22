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
	
	// 서비스에서는 바꿀 회원 정보만 알고 있으므로
	// 기존 회원 정보 (oldMemberInfo) 를 알아야 기존 회원 정보와 바꿀 회원 정보를 비교할 수 있으니깐 
	// dao 를 사용해사 기존 회원 정보를 불러와야함 
	public boolean update(MemberInfo oldMemberInfo,MemberInfo updateMemberInfo) {
		MemberInfoDao dao = new MemberInfoDao();
		
		// 기존 회원 정보를 불러옴 ( 컨트롤러가 회원 정보를 전달하도록 매개 변수를 추가했으므로 코드는 주석 처리 - ) 
//		MemberInfo oldMemberInfo = dao.selectByMemberIdx();
		String oldTel = oldMemberInfo.getTel();
		String oldEmail= oldMemberInfo.getEmail();
		
		String newTel = updateMemberInfo.getTel();
		String newEmail = updateMemberInfo.getEmail();
		
		if(!oldTel.equals(newTel) && dao.selectByTel(newTel) !=null) {
			// 기존 회원의 연락처와 바꿀 회원의 연락처가 다르고 ( 연락처를 변경한다면 ) 
			// 바꿀 회원의 연락처가 사용중이라면
			return false;
		}else if(!oldEmail.equals(newEmail) && dao.selectByEmail(newEmail) !=null){
			// 기존 회원의 이메일과 바꿀 회원의 이메일이 다르고 ( 이메일을 변경한다면 ) 
			// 바꿀 회원의 이메일이 사용중이라면 
			return false;
		}
		
		
		return dao.update(updateMemberInfo);
		
	}
	
	public boolean delete(int memberIdx) {
		MemberInfoDao dao = new MemberInfoDao();
		
		return dao.delete(memberIdx);
	}
	

	
}

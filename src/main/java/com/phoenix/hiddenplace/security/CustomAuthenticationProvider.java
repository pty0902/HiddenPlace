package com.phoenix.hiddenplace.security;

import javax.inject.Inject;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.phoenix.hiddenplace.dao.UserDao;
import com.phoenix.hiddenplace.domain.User;

public class CustomAuthenticationProvider {
	@Inject
	private UserDao dao;
	@Inject
	// private AuthorityDao authorityDao;
	// private MemberVo memberVo;
	// private AuthorityVo authorityVo;
	private PasswordEncoder passwordEncoder;
	private User user;
	// private List<GrantedAuthority> authorities = new ArrayList<>();

	// @Override
	// public Authentication authenticate(Authentication authentication) throws AuthenticationException {
	// // TODO Auto-generated method stub
	// UsernamePasswordAuthenticationToken authToken = (UsernamePasswordAuthenticationToken) authentication;
	// String mem_id = findMemberById(authToken.getName());
	//
	// if (mem_id == null) {
	// throw new UsernameNotFoundException(mem_id);
	// }
	//
	// if (!matchPassword(mem_id, authToken.getCredentials())) {
	// throw new BadCredentialsException("not matching username or password");
	// }
	//
	// try {
	// memberVo = dao.selectByMember(dto);
	// authorityVo = authorityDao.selectByAuthority(memberVo.getMem_no());
	// authorities.add(new SimpleGrantedAuthority(authorityVo.getAuthority()));
	// } catch (Exception e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	// return new UsernamePasswordAuthenticationToken(memberVo, memberVo.getMem_pw(), authorities);
	// }
	//
	// @Override
	// public boolean supports(Class<?> arg0) {
	// // TODO Auto-generated method stub
	// return true;
	// }
	//
	// private String findMemberById(String id) {
	// String mem_id = null;
	//
	// try {
	// mem_id = dao.selectByEmail(id);
	// } catch (Exception e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	// return mem_id;
	// }
	//
//	private boolean matchPassword(String id, Object credentials) {
//		user = new User();
//		boolean match = false;
//
//		try {
//			match = passwordEncoder.matches((String) credentials, dao.selectByPassword(id));
//			user.setMem_id(id);
//			user.setMem_pw(dao.selectByPassword(id));
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return match;
//	}

//	public void setDao(MemberDao dao) {
//		this.dao = dao;
//	}

	public PasswordEncoder getPasswordEncoder() {
		return passwordEncoder;
	}

	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}
}

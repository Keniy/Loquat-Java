package com.loquat.user.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.alibaba.fastjson.annotation.JSONField;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class User implements UserDetails{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	private String nickname;
	private String username;
	@JSONField(serialize = false)
	private String password;
	private String rePassword;
	private String historyPassword;
	private String email;
	private String phone;
	private String address;
	private String telephone;
	private String userface;
	private boolean enabled;
	private String remark;
	private List<Role> roles;
	private String token;

	@JSONField(serialize = false)
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<>();
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@JSONField(serialize = false)
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@JSONField(serialize = false)
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@JSONField(serialize = false)
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@JSONField(serialize = false)
	@Override
	public boolean isEnabled() {
		return true;
	}

}

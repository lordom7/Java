package com.omvg.springboot.CompaniaABC1.Util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.omvg.springboot.CompaniaABC1.Model.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenUtil {
	private static final long JWT_TOKEN_VALIDITY = 2*10*10;
	
	@Value("${jwt.secret}")
	private String secret;
	
	public String getUsernameFromToken(String token) {
		return getClaimFromToken(token, Claims::getSubject);
	}
	
	public Date getExpirationDateFromToken(String token) {
		return getClaimFromToken(token, Claims::getExpiration);
	}
	
	public <U> U getClaimFromToken(String token, Function<Claims, U> claimsResolver) {
		final Claims claims = getAllClaimsFromToken(token);
		return claimsResolver.apply(claims);
	}
	
	private Claims getAllClaimsFromToken(String token) {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
	}
	
	private Boolean isTokenExpired(String token) {
		final Date expiration = getExpirationDateFromToken(token);
		return expiration.before(new Date());	
	}
	
	public String generateToken(User user) {
		Map<String, Object> claims = new HashMap<>();
		return doGenerateToken(claims, user.getEmail());
	}
	
	private String doGenerateToken(Map<String, Object>claims, String subject) {
		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()+JWT_TOKEN_VALIDITY*100))
				.signWith(SignatureAlgorithm.HS512, secret).compact();
	}		
	
	public Boolean validateToken(String token, User user) {
		final String username =getUsernameFromToken(token);
		return (username.equals(user.getEmail())&& !isTokenExpired(token));
		
	}

}

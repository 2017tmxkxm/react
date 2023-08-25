package com.example.demo.security;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.example.demo.model.UserEntity;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
// 유저 정보를 받아 JWT를 생성
public class TokenProvider {
	private static final String SECRET_KEY = 	"FlRpX30pMqDbiAkmlfAbrmVkDD4RqISskGZmBFax5oGVxzXXWUzTR5JyskiHMIV9M10icegkpi46AdvrcX1E6CmTUBc6IFbTPiD";
	
	/** 
	 *	JWT 토큰 생성
	 */
	public String create(UserEntity userEntity) {
		// 기한 지금으로부터 1일로 설정
		Date expiryDate = Date.from(
				Instant.now()
					.plus(1, ChronoUnit.DAYS));
		
		return Jwts.builder()
				// header에 들어갈 내용 및 서명을 하기 위한 SECRET_KEY
				.signWith(SignatureAlgorithm.HS512, SECRET_KEY)
				// payload에 들어갈 내용
				.setSubject(userEntity.getId()) 	// sub
				.setIssuer("demo app") 		// iss
				.setIssuedAt(new Date())		// iat
				.setExpiration(expiryDate) 		// exp
				.compact();
 	}
	
	/** 
	 * 	토큰을 디코딩, 파싱 및 위조여부를 확인
	 * @return subject (userId)
	 */
	public String validateAndGetUserId(String token) {
		// parseClaimsJws 메서드가 Base 64로 디코딩 및 파싱
		// 즉, 헤더와 페이로드를 setSigningKey로 넘어온 시크릿을 이용해 서명 후, token의 서명과 비교.
		// 위조되지 않았다면 페이로드(Claims) 리턴, 위조라면 예외를 날림
		// 그 중 userId가 필요하므로 getBody를 부른다.
		Claims claims = Jwts.parser()
				.setSigningKey(SECRET_KEY)
				.parseClaimsJws(token)
				.getBody();
		
		return claims.getSubject();
	}
	
}

package br.com.residencia.seguranca.security.jwt;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.crypto.SecretKey;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.residencia.seguranca.dto.UserDTO;
import br.com.residencia.seguranca.entity.Role;
import br.com.residencia.seguranca.entity.User;
import br.com.residencia.seguranca.security.service.UserDetailsImpl;
import br.com.residencia.seguranca.security.service.UserService;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtils {
	private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

	@Value("${app.jwt.secret}")
	private String jwtSecret;

	@Value("${app.jwt.expiration.ms}")
	private int jwtExpirationMs;

	@Autowired
	UserService userService;

	public String generateJwtToken(Authentication authentication) {

		UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();
		SecretKey sKey = Keys.hmacShaKeyFor(jwtSecret.getBytes(StandardCharsets.UTF_8));

		User user = userService.findByUsername(userPrincipal.getUsername());

		UserDTO userDTO = new UserDTO();
		userDTO.setId(user.getId());
		userDTO.setUsername(user.getUsername());
		userDTO.setEmail(user.getEmail());

		Set<String> listRoles = new HashSet<>();
		for (Role role : user.getRoles()) {
			listRoles.add(role.getName().name());

		}

		userDTO.setRoles(listRoles);

		ObjectMapper mapper = new ObjectMapper();
		Map<String, String> userMap = new HashMap<>();
		String userJson = null;

		try {

			userJson = mapper.writeValueAsString(userDTO);

		} catch (JsonProcessingException ex) {
			System.out.println("Ocorreu um erro ao converter o DTO para Json: " + ex.getMessage());
		}

		userMap.put("user", userJson);

		return Jwts.builder().setSubject((userPrincipal.getUsername())).setIssuedAt(new Date()).setClaims(userMap)
				.setExpiration(new Date((new Date()).getTime() + jwtExpirationMs)).signWith(sKey).compact();
	}

	public String getUserNameFromJwtToken(String token) {
		SecretKey sKey = Keys.hmacShaKeyFor(jwtSecret.getBytes(StandardCharsets.UTF_8));
		return Jwts.parserBuilder().setSigningKey(sKey).build().parseClaimsJws(token).getBody().getSubject();
	}

	public boolean validateJwtToken(String authToken) {
		try {
			SecretKey sKey = Keys.hmacShaKeyFor(jwtSecret.getBytes(StandardCharsets.UTF_8));
			Jwts.parserBuilder().setSigningKey(sKey).build().parseClaimsJws(authToken).getBody().getSubject();
			return true;
		} catch (JwtException e) {
			logger.error("Token JWT inválido: {}", e.getMessage());
		}
		return false;
	}
}
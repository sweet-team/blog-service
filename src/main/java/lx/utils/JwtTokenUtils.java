package lx.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import sun.rmi.runtime.Log;

import java.util.Date;
import java.util.HashMap;

public class JwtTokenUtils {
    public static final String TOKEN_HEADER= "Authorization";
    public static final String TOKEN_PREFIX = "LxBlog ";
    public static final String SECRET = "jwtsecretkey";
    public static final String ISS = "echisan";

    private static final Long EXPIRATION_GUEST = 60*30L;
    private static final Long EXPIRATION_ADMIN = 60*60*12L;
    private static final String ROLE_CLAIMS = "role";

    public static String createToken(String username, String role, Boolean guest){
        Long expiration = guest ? EXPIRATION_GUEST : EXPIRATION_ADMIN;
        HashMap<String, Object> map = new HashMap<>();
        map.put(ROLE_CLAIMS, role);
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS512,SECRET)
                .setClaims(map)
                .setIssuer(ISS)
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration*1000))
                .compact();
    }
    public static String getUsername(String token){
        return getTokenBody(token).getSubject();
    }
    public static String getUserRole(String token){
        return (String) getTokenBody(token).get(ROLE_CLAIMS);
    }

    public static boolean isExpiration(String token){
        return getTokenBody(token).getExpiration().before(new Date());
    }
    private static Claims getTokenBody(String token){
        return Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody();
    };

}

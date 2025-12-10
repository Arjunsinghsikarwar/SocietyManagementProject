package SecurityManagementBackend.Backend.SpringSecuritySetUp.JwtService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String secretKey;


    public String generateToken(String userName){
        Map<String , Object> claims = new HashMap<>();

        return Jwts
                .builder()
                .claims()
                .add(claims)
                .subject(userName)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 60 * 60 + 30))
                .and()
                .signWith(getKey())
                .compact();
    }


    public String extractUserName(String token) {
        return getAllClaims(token).getSubject();
    }


    public Claims getAllClaims(String token){

        return Jwts
                .parser()
                .verifyWith(getKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public SecretKey getKey(){
        byte key[] = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(key);

    }

    public boolean validateToken(String token, UserDetails userDetails) {
        String userName = extractUserName(token);
        return (userDetails.getUsername().equals(userName) && !tokenExpire(token));
    }

    public boolean tokenExpire(String token){
        return getAllClaims(token).getExpiration().before(new Date());
    }
}
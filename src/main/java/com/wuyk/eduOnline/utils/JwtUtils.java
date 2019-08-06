package com.wuyk.eduOnline.utils;

import com.wuyk.eduOnline.domain.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * jwt工具类，用于分布式登录校验
 */
public class JwtUtils {

    public static final String SUBJECT = "wuyk";

    //过期时间
    public static final long EXPIRE = 1000 * 60 * 60 * 24 * 7;

    //密钥 必须保密
    public static final String APPSECRET = "wuyk666";

    /**
     * 加密生成jwt方法
     *
     * @param user
     * @return
     */
    public static String geneJsonWebToken(User user) {
        if (user == null || user.getId() == null || user.getName() == null || user.getHeadImg() == null) {
            return null;
        }
        //加密
        String token = Jwts.builder().setSubject(SUBJECT).claim("id", user.getId())
                .claim("name", user.getName())
                .claim("img", user.getHeadImg())
                //发行时间
                .setIssuedAt(new Date())
                //过期时间
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
                //签名
                .signWith(SignatureAlgorithm.HS256, APPSECRET)
                .compact();
        return token;
    }

    /**
     * 解密jwt 校验token方法
     *
     * @param token
     * @return
     */
    public static Claims checkJwt(String token) {
        try {
            final Claims claims = Jwts.parser().setSigningKey(APPSECRET).parseClaimsJws(token).getBody();
            return claims;
        } catch (Exception e) {
        }
        return null;
    }
}

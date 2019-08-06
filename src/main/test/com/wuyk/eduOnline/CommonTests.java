package com.wuyk.eduOnline;

import com.wuyk.eduOnline.domain.User;
import com.wuyk.eduOnline.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import org.junit.Test;

/**
 * Created by WUYK on 2019-07-16.
 */
public class CommonTests {

    @Test
    public void testgGneJsonWebToken() {
        User user = new User();
        user.setId(11);
        user.setName("test");
        user.setHeadImg("www.12.png");
        String token = JwtUtils.geneJsonWebToken(user);
        System.out.println(token);
    }

    @Test
    public void testCheckJwt() {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ3dXlrIiwiaWQiOjExLCJuYW1lIjoidGVzdCIsImltZyI6Ind3dy4xMi5wbmciLCJpYXQiOjE1NjMyODc4ODAsImV4cCI6MTU2Mzg5MjY4MH0.mb-GdOi5KasL9zbQkB-e0TWHEbGEpm3rDN0ioVIyG7E";
        Claims claims = JwtUtils.checkJWT(token);
        if (claims != null) {
            String name = (String) claims.get("name");
            String img = (String) claims.get("img");
            int id = (Integer) claims.get("id");
            System.out.println(name);
            System.out.println(img);
            System.out.println(id);
        }else {
            System.out.println("非法token");
        }
    }
}

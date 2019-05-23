package com.lpan.java_summarize.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Component;

@Component
public class JwtUtils {

    public static void main(String[] args) {
        String shipan = create("shipan");
        System.out.println(shipan);
        String decode = decode(shipan);
        System.out.println(decode);
        vaildate("shipan1",shipan);
    }


    /***
     *  获取一个令牌
     * @param str
     * @return
     */
    public static String create(String str){
        String sign = JWT.create().withAudience(str).sign(Algorithm.HMAC256(str));
        //System.out.println(sign);
        return sign;
    }


    /***
     *  解码一个令牌
     * @param str
     * @return
     */
    public static String decode(String str){
        DecodedJWT decode = JWT.decode(str);

        String algorithm = decode.getAlgorithm();
        System.out.println("algorithm:"+algorithm);
        String payload = decode.getPayload();
        System.out.println("payload:"+payload);
        String header = decode.getHeader();
        System.out.println("header:"+header);
        String contentType = decode.getContentType();
        System.out.println("contentType:"+ contentType);
        String s = decode.getAudience().get(0);
        System.out.println("s:"+s);
        return s;
    }

    /***
     *  
     * @param str
     * @param token
     */
    public static void vaildate(String str,String token){
        Algorithm algorithm = Algorithm.HMAC256(str);
        JWTVerifier build = JWT.require(algorithm).withAudience(str).build();
        DecodedJWT verify = build.verify(token);
    }


}

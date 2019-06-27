import cloud.nzc.auth.AuthorizationApp;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.RsaSigner;
import org.springframework.security.jwt.crypto.sign.RsaVerifier;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;
import org.springframework.test.context.junit4.SpringRunner;

import java.security.KeyPair;
import java.security.interfaces.RSAPrivateKey;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 * @version 1.0
 **/
@SpringBootTest(classes = AuthorizationApp.class)
@RunWith(SpringRunner.class)
public class TestJwt {

    //创建jwt令牌
    @Test
    public void testCreateJwt(){
        //密钥库文件
        String keystore = "xskq.keystore";
        //密钥库的密码
        String keystore_password = "xskqkeystore";

        //密钥库文件路径
        ClassPathResource classPathResource = new ClassPathResource(keystore);
        //密钥别名
        String alias  = "xskqkey";
        //密钥的访问密码
        String key_password = "123456";
        //密钥工厂
        KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(classPathResource,keystore_password.toCharArray());
        //密钥对（公钥和私钥）
        KeyPair keyPair = keyStoreKeyFactory.getKeyPair(alias, key_password.toCharArray());
        //获取私钥
        RSAPrivateKey aPrivate = (RSAPrivateKey) keyPair.getPrivate();
        //jwt令牌的内容
        Map<String,String> body = new HashMap<>();
        body.put("name","itcast");
        String bodyString = JSON.toJSONString(body);
        //生成jwt令牌
        Jwt jwt = JwtHelper.encode(bodyString, new RsaSigner(aPrivate));
        //生成jwt令牌编码
        String encoded = jwt.getEncoded();
        System.out.println(encoded);

    }

    //校验jwt令牌
    @Test
    public void testVerify(){
        //公钥
        String publickey = "-----BEGIN PUBLIC KEY-----MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAxBT9hLVHcc1iQ16liWuYTPRzwiJOWy/JTQUZdaw3RlULo9qNu8787xAxLkUq2m5fSFSVIFjATSxOx1xRDbofDIsA+IgxTd8GoCyQZBZ6ACd53Xmq3KjFXxIOYPH/ufVNGJQ2BGCff7OHAv0L8yn1wCnHEWAPxYrjL6JAhitz0sF2HiZLSQkVFFDEZm83sWikCTMWzLr4jMZQeDstqcXJp2G5loLpkyrnJADQcTe1SgWHjuJGoZmjDTS4XYjJsIRqpbhfexHgC9DQwJV8JtsilNA5GU06+sW2dhW+hMputl7wrLRFPQVBZyGTMPFzI+7W/IQ3F8kTH38f7lxhuSqA4QIDAQAB-----END PUBLIC KEY-----";
        //jwt令牌
        String jwtString = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJuYW1lIjoiaXRjYXN0In0.M5MSsWdKO2qrZv3jBV_Emx1eDQ9LYNshE_B2gViU2MQQ0BcNMF6AlgZ_5n9aG_D5_wTug9VN67orFsjMehNPrNjQM7JhvC7nFDdQ7h_pVnffZG96sgsqB01NLSlFZAA-lIsjhGh-Ivz2tl3uijLIN_xwqzgH3b3TkfmrriVyiqeW54jQUKnr4s0vnfD4Hs7xFxK87t8atVYn8Eq1DNVCd2Hs7Yxz68-9jxOv_gnf_WE1jI1ppEU2Oqx_nYSxOfDtqPCrNPfqHS3sbdFMz4cBhohWAVYhTBjoHVk7PLS-Hv7goBlylTsna5IpqYCRzRq-fZ0WGnd4vzeJRxN6z0ve-w";
        //校验jwt令牌
        Jwt jwt = JwtHelper.decodeAndVerify(jwtString, new RsaVerifier(publickey));
        //拿到jwt令牌中自定义的内容
        String claims = jwt.getClaims();
        System.out.println(claims);
    }
}

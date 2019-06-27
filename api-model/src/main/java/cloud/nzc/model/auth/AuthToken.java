package cloud.nzc.model.auth;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class AuthToken {
    /*短令牌，用户身份令牌*/
    String access_token;
    /*刷新token*/
    String refresh_token;
    /*jwt token*/
    String  jwt_token;
}

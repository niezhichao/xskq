package cloud.nzc.auth.service;

import cloud.nzc.auth.feign.UserClient;
import cloud.nzc.model.po.UserPo;
import cloud.nzc.model.util.StringUtil;
import cloud.nzc.model.vo.UserVo;
import com.mysql.fabric.xmlrpc.Client;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    ClientDetailsService clientDetailsService;
    @Autowired
    UserClient userClient;
    private final  static Logger log=LoggerFactory.getLogger(UserDetailServiceImpl.class);
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Authentication authorization=SecurityContextHolder.getContext().getAuthentication();
        if (authorization ==null){
            ClientDetails clientDetails=clientDetailsService.loadClientByClientId(username);
            if (clientDetails != null){
                String clientSecret=clientDetails.getClientSecret();
                return new User(username,clientSecret,AuthorityUtils.commaSeparatedStringToAuthorityList(""));
            }

        }
        if (StringUtils.isEmpty(username)){
            return null;
        }
        UserPo param=new UserPo(username);
        List<UserPo> userPo= userClient.getUser(param);
        log.info(userPo.toString());
        if (userPo ==null){
            return null;
        };
        String password=userPo.get(0).getuPWD();
        User userDetails=new User(username,password,AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
        return userDetails;
    }
}

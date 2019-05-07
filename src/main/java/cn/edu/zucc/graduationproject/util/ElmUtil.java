package cn.edu.zucc.graduationproject.util;
import cn.edu.zucc.graduationproject.ApiConfig.ElemeConfig;
import cn.edu.zucc.graduationproject.Dao.TokenDao;
import cn.edu.zucc.graduationproject.Service.Codeservice;
import eleme.openapi.sdk.config.Config;
import eleme.openapi.sdk.oauth.OAuthClient;
import eleme.openapi.sdk.oauth.response.Token;
import freemarker.template.utility.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class ElmUtil {
    private final static Logger logger = LoggerFactory.getLogger(ElmUtil.class);
    /**
     * 获取配置类
     * @param isSandbox 是否沙箱
     * @return
     */
    public static Config getConfig(boolean isSandbox) {
        Config config = null;
        if (isSandbox == true) {
            config = new Config(isSandbox, ElemeConfig.SANDBOX_APP_KEY, ElemeConfig.SANDBOX_APP_SECRET);
        } else {
            // TODO 填充正式环境数据
        }
        return config;
    }

    /**
     * 获取店铺授权URL地址
     * @desc 每次调用会产生一个新的授权码 需要记录code作为后续凭证
     */
    public static String getAuthUrl(Config config){
        OAuthClient client = new OAuthClient(config);
        String authUrl = client.getAuthUrl(ElemeConfig.SANDBOX_REDIRECT_URL, "all", "1234");
        return authUrl;
    }

    public static Token getToken(boolean isSandbox, String appKey, String appSecret, String callbackUrl, String code) {
        Config config = new Config(isSandbox, appKey, appSecret);

        OAuthClient client = new OAuthClient(config);

        return client.getTokenByCode(code, callbackUrl);
    }

    public static Token getRefreshToken(boolean isSandbox, String appKey, String appSecret,String refreshtoekn){
        Config config = new Config(isSandbox, appKey, appSecret);

        OAuthClient client = new OAuthClient(config);

        return client.getTokenByRefreshToken(refreshtoekn);
    }

    @Autowired
    TokenDao tokenDao;
    @Autowired
    Codeservice codeservice;
    public Token gettokenbymysql(){
        cn.edu.zucc.graduationproject.JavaBean.Token token=null;
        token=tokenDao.gettoken();
        Token etoken=new Token();
        if (token==null){
            etoken=getToken(ElemeConfig.IS_SANDBOX,ElemeConfig.SANDBOX_APP_KEY,ElemeConfig.SANDBOX_APP_SECRET,ElemeConfig.SANDBOX_REDIRECT_URL,codeservice.getcodebyshopid(ElemeConfig.SANDBOX_STORE_ID+""));
            try {
                tokenDao.countToken(etoken.getAccessToken(), etoken.getTokenType(), etoken.getExpires(), etoken.getRefreshToken(), new Date());
            }catch(Exception e){
                logger.warn("token保存失败",e);
            }
        }
        else {
            long nowtime=(new Date()).getTime();
            long oldtime=token.getDate().getTime();
            long timedifference=(nowtime-oldtime)/1000;
            long expires=token.getExpires();
            if (timedifference>=expires){
                etoken=getRefreshToken(ElemeConfig.IS_SANDBOX,ElemeConfig.SANDBOX_APP_KEY,ElemeConfig.SANDBOX_APP_SECRET,token.getRefreshToken());
                try {
                    cn.edu.zucc.graduationproject.JavaBean.Token tokenmsg=new cn.edu.zucc.graduationproject.JavaBean.Token();
                    tokenmsg.setTokenType(etoken.getTokenType());
                    tokenmsg.setDate(new Date());
                    tokenmsg.setRefreshToken(etoken.getRefreshToken());
                    tokenmsg.setExpires(etoken.getExpires());
                    tokenmsg.setAccessToken(etoken.getAccessToken());
                    tokenDao.deleteAll();
                    tokenDao.save(tokenmsg);
                }catch(Exception e){
                    logger.warn("token修改失败",e);
                }
            }else{
                etoken.setTokenType(token.getTokenType());
                etoken.setRefreshToken(token.getRefreshToken());
                etoken.setExpires(token.getExpires());
                etoken.setAccessToken(token.getAccessToken());
            }
        }
        return etoken;
    }

    public List<String> getdaylistbeforetoday(int daynum) throws ParseException {
        String startdate=null;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DATE, - daynum);
        Date d = c.getTime();
        startdate=format.format(d);
        Date strdata=format.parse(startdate);
        Date eddata=new Date();
        List<Date> result = new ArrayList<Date>();
        Calendar tempStart = Calendar.getInstance();
        tempStart.setTime(strdata);
        while(strdata.getTime()<=eddata.getTime()){
            result.add(tempStart.getTime());
            tempStart.add(Calendar.DAY_OF_YEAR, 1);
            strdata = tempStart.getTime();
        }
        List<String> datastringlist=new ArrayList<>();
        for (int i=0;i<result.size();i++){
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String dateString = formatter.format(result.get(i));
            datastringlist.add(dateString);
        }
        return datastringlist;
    }
}

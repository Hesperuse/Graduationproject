package cn.edu.zucc.graduationproject.util;
import cn.edu.zucc.graduationproject.ApiConfig.ElemeConfig;
import eleme.openapi.sdk.config.Config;
import eleme.openapi.sdk.oauth.OAuthClient;
import eleme.openapi.sdk.oauth.response.Token;

public class ElmUtil {
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
}

package cn.edu.zucc.graduationproject.ApiConfig;

public class ElemeConfig {
    //标志是否为沙箱环境
    public final static boolean IS_SANDBOX=true;

    public static String getSandboxAppKey() {
        return SANDBOX_APP_KEY;
    }

    //沙箱环境参数
    public final static String SANDBOX_APP_KEY="42uqKgwIyk";//对应Key 表示沙箱环境的应用Key
    public final static String SANDBOX_APP_SECRET="22a082f525a0ec1c4ec9db144b6b2fb8602ca9b0";//对应Secret 表示沙箱环境的应用Secret
    public final static long SANDBOX_STORE_ID=170361525;//对应沙箱环境店铺ID
    public final static String SANDBOX_STORE_URL="";//对应沙箱环境店铺URL
    public final static String SANDBOX_STORE_PASS="";//对应沙箱环境店铺密码
    public final static String SANDBOX_REDIRECT_URL="http://122.235.96.31:8080/test/elm?method=auth_back";//对应沙箱环境回调地址URL

    public final static String code="712d28883efe69e8ae7345d3e0d99864";

    //正式环境参数 暂时么有
}

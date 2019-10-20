package com.bang.invoice_ver.utils;

/**
 * 
 * Description: 常量类
 * @author wangxinbang
 * @version 1.0
 * <pre>
 * Modification History: 
 * Date         Author      Version     Description 
------------------------------------------------------------------
 * 2016年8月15日    wangxinbang       1.0        1.0 Version 
 * </pre>
 */
public class Attr {

	public class RequestAttr{
		/**登录提示消息*/
		public static final String LoginMsg = "LoginMsg";
		
	}
	
	public class SessionAttr{
		/**登录图形验证码*/
		public static final String LoginCaptcha = "LoginCaptcha";
		
		public static final String LoginUserId="LoginUserId";
		
		/**后台登录用户*/
		public static final String LoginUser="LoginUser";
		/** 后台登录用户有效时长  **/
		public static final String LoginUserMaxInactiveInterval="1800";
		/** 未登录返回给前台信息  **/
		public static final String UnLoginReturn="unlogin";
	}
	
	public class StatusAttr{
	    /** 用户状态冻结  **/
	    public static final String userStatusFrezz = "2";
	}
	
	public class RedisIdeAttr{
	    /** 用户登录菜单redis缓存key标识  **/
	    public static final String SysMenu = "sys_menu_";
	    /** 用户登录菜单redis缓存时间  **/
	    public static final String SysMenuContinue = "1800";
	    /** 用户日志记录的系统菜单redis中的key值  **/
	    public static final String SysMenuForLog = "sys_menu_for_log";
	    
	}
	
	/** mongo相关配置 **/
	public class MongoCollections{
	    /** 系统用户登录  **/
	    public static final String SysUserLogin = "log_sys_login";
	    /** 系统用户操作 **/
	    public static final String SysUserOper = "log_sys_oper";
	    /** 系统日志  **/
	    public static final String SysLog = "1";
	    /** 业务日志  **/
	    public static final String BizLog = "0";
	}
	
	/** 用户相关  **/
	public class UserRelevant{
	    /** 默认密码  **/
	    public static final String DefaultPassword = "Iqb.com";
	    /** hq总部  **/
	    public static final String HQ = "1";
	}
	
	/** 公用常量  **/
	public class CommonConst{
	    /** 版本号  **/
	    public static final String Version = "1";
	}

	/** redis锁相关常量  **/
	public class RedisLockConst{
	    /** 密码输入错误允许次数  **/
	    public static final String LoginFailPermTimes = "5";
	    /** 密码输入错误用户锁前缀  **/
	    public static final String LoginFailLockPrex = "lock_etep_login_fail_";
	    /** 密码输入错误，锁定的时间  **/
	    public static final String LoginFailLockInterval = "1800";
	}
	
	/** 邮件相关常量  **/
	public class MailConst{
	    /** 邮件host地址  **/
	    public static final String MailHost = "smtp.exmail.qq.com";
	    /** 用户名  **/
	    public static final String MailUserName = "wangxinbang@iqianbang.com";
	    /** 密码  **/
	    public static final String MailPwd = "******";
	    /** 发件人  **/
	    public static final String MailPersonal = "爱钱帮";
	}
	
	/** 字key典常量  **/
	public class DictKeyConst{
	    /** 字典常量key：是  **/
	    public static final String YESORNO_YES = "1";
	    /** 字典常量key：否  **/
	    public static final String YESORNO_NO = "0";
	}

    /** 微信相关  **/
    public class WeiXinConstant {
        /** access_token **/
        public static final String WEIXIN_ACCESSTOKEN_GET_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=${APPID}&secret=${APPSECRET}";
        /** appid **/
        public static final String WEIXIN_APPID_REG = "${APPID}";
        /** appsercret **/
        public static final String WEIXIN_APPSECRET_REG = "${APPSECRET}";
        /** access_token on redis **/
        public static final String WEIXIN_ACCESSTOKEN_REDIS_PRE = "wx_access_token_";
        /** access_token timeout on redis **/
        public static final String WEIXIN_ACCESSTOKEN_REDIS_TIMEOUT = "7000";
        /** access_token key **/
        public static final String WEIXIN_ACCESSTOKEN_KEY = "access_token";
        /** tpl_msg_send **/
        public static final String WEIXIN_TPL_MSG_SEND_URL = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=${ACCESS_TOKEN}";
        /** ACCESS_TOKEN **/
        public static final String WEIXIN_ACCESS_TOKEN_REG = "${ACCESS_TOKEN}";
        /** APP_ID **/
        public static final String APP_ID_KEY = "appId";
        /** APP_SECRET **/
        public static final String APP_SECRET_KEY = "appSecret";
        /** WX_TPL_ID **/
        public static final String WX_TPL_ID_KEY = "wxTplId";
        /** tpl Top Default Color **/
        public static final String WX_TPL_COLOR_TOP_DEFAULT = "#00DD00";
        /** tpl Default Color **/
        public static final String WX_TPL_COLOR_TPL_DEFAULT = "#173177";
        /** WxResErrCode UNSUCC **/
        public static final String WX_RES_ERR_CODE_UNSUCC = "-1";
        /** WxResErrCode SUCC **/
        public static final String WX_RES_ERR_CODE_SUCC = "0";
        /** WxResErrKey **/
        public static final String WX_RES_ERR_KEY = "errcode";
        /** status key **/
        public static final String STATUS_KEY = "status";
        /** status succ **/
        public static final String STATUS_SUCC = "1";
        /** api_ticket_url **/
        public static final String WEIXIN_API_TICKET_URL = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=${ACCESS_TOKEN}&type=jsapi";
        /** js_api_ticket key **/
        public static final String JS_API_TICKET_RET_KEY = "ticket";
        /** api_ticket on redis **/
        public static final String WEIXINJS_API_TICKET_REDIS_PRE = "wx_js_ticket_";
        /** api_ticket timeout on redis **/
        public static final String WEIXIN_API_TICKET_REDIS_TIMEOUT = "7000";
        /** url key **/
        public static final String JS_API_TICKET_URL_KEY = "url";
        /** jsapi_ticket key **/
        public static final String JS_JSAPI_TICKET_KEY = "jsapi_ticket";
        /** nonceStr key **/
        public static final String JS_API_TICKET_NONCE_STR_KEY = "nonceStr";
        /** timestamp key **/
        public static final String JS_API_TICKET_TIMESTAMP_KEY = "timestamp";
        /** signature key **/
        public static final String JS_API_TICKET_SIGNATURE_KEY = "signature";
    }

    public class BizKey {
        /** 商户id **/
        public static final String MERCHANT_CODE_KEY = "merchantCode";
        /** 商户pwd **/
        public static final String MERCHANT_PWD_KEY = "merchantPwd";
        /** 消息发送请求数据key **/
        public static final String REQUEST_ID_KEY = "requestId";
        public static final String REQUEST_TOKEN_KEY = "requestToken";
        public static final String MSG_TYPE_KEY = "msgType";
        public static final String BIZ_TYPE_KEY = "bizType";
        public static final String IS_DELAY_KEY = "isDelay";
        public static final String DELAY_TIME_KEY = "delayTime";
        public static final String IS_CALLBACK_KEY = "isCallback";
        public static final String CALLBACK_URL_KEY = "callBackUrl";
        public static final String SENDER_KEY = "sender";
        public static final String RECIEVER_KEY = "reciever";
        public static final String RECIEVER_SPLIT_KEY = ",";
        public static final String MSG_CONTENT_KEY = "msgContent";
        public static final String NOTIFY_URL_KEY = "notifyUrl";
        public static final String REMARK_KEY = "remark";
        public static final String TYPE_CODE_KEY = "typeCode";
        public static final String MSG_PARAM_KEY = "msgParam";
        public static final String IS_ASYN_KEY = "isAsyn";
        
        public static final String SENDER_EMAIL_URL_KEY = "senderEmailUrl";
        public static final String SENDER_EMAIL_PWD_KEY = "senderEmailPwd";
        public static final String SENDER_NAME_KEY = "senderName";
        
        public static final String EMAIL_SERVER_KEY = "emailServer";
        public static final String EMAIL_SUBJECT_KEY = "emailSubjet";
        
        public static final String MAIL_SMTP_AUTH = "mail.smtp.auth";
        public static final String MAIL_SMTP_AUTH_TURE = "true";
        public static final String MAIL_SMTP_AUTH_FALSE = "false";
        public static final String MAIL_SMTP_TIMEOUT = "mail.smtp.timeout";
        public static final String MAIL_SMTP_TIMEOUT_DEFAULT = "25000";
        public static final String MAIL_SMTP_SOCKETFACTORY_CLASS = "mail.smtp.socketFactory.class";
        public static final String MAIL_SMTP_SOCKETFACTORY_CLASS_VAL = "javax.net.ssl.SSLSocketFactory";
        public static final String MAIL_SMTP_PORT = "mail.smtp.port";
        public static final String MAIL_SMTP_PORT_VAL = "465";
        
        public static final String MAIL_STATUS_SUCC = "MAIL_SUCC";
        
        /** 消息发送请求数据key默认值  **/
        public static final String IS_DELAY_YES = "1";
        public static final String IS_DELAY_NO = "2";
        public static final String IS_CALLBACK_YES = "1";
        public static final String IS_CALLBACK_NO = "2";
        public static final String SECURITY_AUTH_TOKEN = "1";
        public static final String SECURITY_AUTH_PWD = "0";
        public static final String MSG_CONTENT_TYPE_TPL = "1";
        public static final String MSG_CONTENT_TYPE_NO_TPL = "0";
        public static final String IS_ASYN_YES = "1";
        public static final String IS_ASYN_NO = "0";
        
        /** 商户状态-正常 **/
        public static final String MERCHANT_STATUS_NORMAL = "1";
        /** 商户token **/
        public static final String MERCHANT_TOKEN_KEY = "token";
        /** 商户token有效时长  **/
        public static final String MERCHANT_TOKEN_INTERVAL_KEY = "interval";
        /** 商户token有效时长  **/
        public static final String MERCHANT_TOKEN_INTERVAL = "18000";
        /** 商户token可用次数  **/
        public static final String MERCHANT_TOKEN_AVAILABLE_TIMES_KEY = "availableTimes";
        /** 商户token可用次数  **/
        public static final String MERCHANT_TOKEN_AVAILABLE_TIMES = "30";
    }
    
	
}

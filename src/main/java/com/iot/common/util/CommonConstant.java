package com.iot.common.util;

public final class CommonConstant {
  
  private CommonConstant() {
  }

  // authentication & authorization
  public static final String REDIS_KEY_SSO_ADMIN_TOKEN = "AUTH:sso_admin_token";
  public static final String REDIS_KEY_SSO_USER = "AUTH:sso_user_";
  public static final int JWT_MAX_AGE_MINUTES = 60 * 24 * 7;
  public static final int JWT_ONE_STEP_MINUTES = 30;
  public static final String TOKEN_COOKIE_NAME = "jwt-token";

  // error code
  public static final String SUCCESS_CODE = "00000";
  public static final String DEFAULT_SYS_ERROR_CODE = "00099";
  public static final String DEFAULT_SYS_ERROR_MSG = "00099:系统内部错误";

  // system code
  public static final String FRAMEWORK_SYS_CODE = "COMMON";
  
  // front_type
  public static final String FRONT_TYPE = "FrontType";
  
  // message_key_internal_error
  public static final String MESSAGE_KEY_INTERNAL_ERROR = "framework.auth.login.internal.error";
  public static final String DEFAULT_COURTUUID = "00000000000000000000000000000000";
  public static final String REDIS_KEY_CURRENT_COURTUUID = "AUTH:courtuuid";
}

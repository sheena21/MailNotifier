package com.notifier.mailNotifier.util;

import org.springframework.stereotype.Component;


public class Constants {
  public  static  final String TOKEN_PREFIX="Bearer ";
  public static final long EXPIRATION_TIME = 2*60*60*1000; // hours*minutes*seconds*milliseconds
  public static final String AUTHORITIES_KEY="role";
  public static final String SECRET = "SecretKeyToJWT";

}

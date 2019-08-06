package com.smallrain.template.utils;

import java.util.Random;
import java.util.UUID;

public class BaseUtils {

  /**
   * 生成Uuid
   * 
   * @return
   */
  public static String createUuid() {
    // 穿建一个Uuid
    String uuid = UUID.randomUUID().toString();
    // 去掉“-”符号
    return uuid.replaceAll("-", "");
  }

  /**
   * 生成 随机字符串
   * 
   * @param length
   * @return
   */
  static final String RANDOM_STR_SOURCE = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
  public static String getRandomString(int length,String prefix,String end) {
    Random random = new Random();
    StringBuilder sb = new StringBuilder(prefix);
    for (int i = 0; i < length; i++) {
      int number = random.nextInt(RANDOM_STR_SOURCE.length() - 1);
      sb.append(RANDOM_STR_SOURCE.charAt(number));
    }
    sb.append(end);
    return sb.toString();
  }

}

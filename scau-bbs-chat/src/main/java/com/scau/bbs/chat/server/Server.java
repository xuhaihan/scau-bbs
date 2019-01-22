package com.scau.bbs.chat.server;

/** @Author : xhh @Date : Create in 10:41 2019/1/12 @Email : xhhscau2015@163.com 服务端接口 */
public interface Server {

  /** 初始化服务器 */
  void init();

  /** 启动服务器 */
  void start();

  /** 关闭服务器 */
  void shutdown();
}

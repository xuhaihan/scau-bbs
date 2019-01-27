package com.scau.bbs.common.base;

import com.scau.bbs.common.dto.QuarkResult;
import com.scau.bbs.common.exception.ServiceProcessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** @Author xhh Create By 2019/1/15 */
public class BaseController {

  protected final Logger logger = LoggerFactory.getLogger(this.getClass());

  protected QuarkResult restProcessor(ResultProcessor processor) {
    QuarkResult result = null;
    try {
      result = processor.process();
    } catch (ServiceProcessException e1) {
      logger.error("ServiceProcess Error Log :" + e1.getLocalizedMessage(), e1);
      result = QuarkResult.error(e1.getMessage());
    } catch (Exception e) {
      logger.error("ServiceError Log :" + e.getLocalizedMessage(), e);
      result = QuarkResult.error("服务器出现异常");
    }
    return result;
  }
}

package com.xunmaw.dormitory.controller;


import com.xunmaw.dormitory.service.AdminService;
import com.xunmaw.dormitory.response.ServerResponse;
import com.xunmaw.dormitory.service.CaptchaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;

/**
 * 验证码控制器
 *
 * @author zyp
 * @version 0.0.1
 * @since 0.0.1
 */
@Controller
public class CaptchaController {

  获取源码/数据库脚本 联系微信：xunmaw001
关注公众号：工具优选
}
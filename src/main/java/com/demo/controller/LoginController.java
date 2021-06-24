package com.demo.controller;

import com.demo.common.security.validate.ImageCode;
import com.demo.common.utils.VerifyCodeUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author ：msj
 * @date ：Created in 2021/6/24 14:40
 * @description：
 * @modified By：`
 * @version: 1.0
 */

@Controller
public class LoginController {

    /**
     * 生成验证码
     * @param request
     * @param response
     */
    @GetMapping("/imageCode")
    @ResponseBody
    public void imageCode(HttpServletRequest request, HttpServletResponse response) {
        String code = null;
        BufferedImage image = null;
        ImageCode imageCode = null;
        try {
            code = VerifyCodeUtils.generateVerifyCode(4);
            image = VerifyCodeUtils.getBufferedImage(100, 40, code);
            imageCode = new ImageCode(code, image, 100);
            request.getSession().setAttribute("IMAGE_CODE_SESSION", imageCode);
            ImageIO.write(image, "JPEG", response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

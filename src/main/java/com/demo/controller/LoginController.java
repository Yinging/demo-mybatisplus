package com.demo.controller;

import com.demo.common.request.PageFrom;
import com.demo.common.response.R;
import com.demo.common.security.validate.ImageCode;
import com.demo.common.utils.VerifyCodeUtils;
import com.demo.entity.UserEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

@RestController
@Api(tags = "登錄")
public class LoginController {

    /**
     * 生成验证码
     * @param request
     * @param response
     */
    @GetMapping("/imageCode")
    @ApiOperation(value = "生成驗證碼")
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

    @PostMapping("/user/login")
    @ApiOperation("登錄")
    public R login(@RequestBody PageFrom page) {
        return R.SUCCESS();
    }

}

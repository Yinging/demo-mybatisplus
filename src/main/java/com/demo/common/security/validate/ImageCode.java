package com.demo.common.security.validate;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

public class ImageCode {
	
	private String code;
	private BufferedImage image;
	private LocalDateTime expiryTime;
	
	public ImageCode() {}
	
	public ImageCode(String code, BufferedImage image, long expiryIn) {
		this.code = code;
		this.image = image;
		this.expiryTime = LocalDateTime.now().plusSeconds(expiryIn);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public LocalDateTime getExpiryTime() {
		return expiryTime;
	}

	public void setExpiryTime(LocalDateTime expiryTime) {
		this.expiryTime = expiryTime;
	}
	
	/**
	 * 验证码是否过期
	 * */
	public boolean isExpried() {
		return this.expiryTime.isBefore(LocalDateTime.now());
	}
	
}

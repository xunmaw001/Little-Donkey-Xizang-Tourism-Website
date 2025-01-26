package com.entity.model;

import com.entity.LuxianyudingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
 

/**
 * 路线预定
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2022-07-31 06:55:54
 */
public class LuxianyudingModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 路线图片
	 */
	
	private String luxiantupian;
		
	/**
	 * 预定时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date yudingshijian;
		
	/**
	 * 预定内容
	 */
	
	private String yudingneirong;
		
	/**
	 * 用户名
	 */
	
	private String yonghuming;
		
	/**
	 * 手机
	 */
	
	private String shouji;
		
	/**
	 * 是否审核
	 */
	
	private String sfsh;
		
	/**
	 * 审核回复
	 */
	
	private String shhf;
				
	
	/**
	 * 设置：路线图片
	 */
	 
	public void setLuxiantupian(String luxiantupian) {
		this.luxiantupian = luxiantupian;
	}
	
	/**
	 * 获取：路线图片
	 */
	public String getLuxiantupian() {
		return luxiantupian;
	}
				
	
	/**
	 * 设置：预定时间
	 */
	 
	public void setYudingshijian(Date yudingshijian) {
		this.yudingshijian = yudingshijian;
	}
	
	/**
	 * 获取：预定时间
	 */
	public Date getYudingshijian() {
		return yudingshijian;
	}
				
	
	/**
	 * 设置：预定内容
	 */
	 
	public void setYudingneirong(String yudingneirong) {
		this.yudingneirong = yudingneirong;
	}
	
	/**
	 * 获取：预定内容
	 */
	public String getYudingneirong() {
		return yudingneirong;
	}
				
	
	/**
	 * 设置：用户名
	 */
	 
	public void setYonghuming(String yonghuming) {
		this.yonghuming = yonghuming;
	}
	
	/**
	 * 获取：用户名
	 */
	public String getYonghuming() {
		return yonghuming;
	}
				
	
	/**
	 * 设置：手机
	 */
	 
	public void setShouji(String shouji) {
		this.shouji = shouji;
	}
	
	/**
	 * 获取：手机
	 */
	public String getShouji() {
		return shouji;
	}
				
	
	/**
	 * 设置：是否审核
	 */
	 
	public void setSfsh(String sfsh) {
		this.sfsh = sfsh;
	}
	
	/**
	 * 获取：是否审核
	 */
	public String getSfsh() {
		return sfsh;
	}
				
	
	/**
	 * 设置：审核回复
	 */
	 
	public void setShhf(String shhf) {
		this.shhf = shhf;
	}
	
	/**
	 * 获取：审核回复
	 */
	public String getShhf() {
		return shhf;
	}
			
}

package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 咨询记录
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2022-07-31 06:55:54
 */
@TableName("zixunjilu")
public class ZixunjiluEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ZixunjiluEntity() {
		
	}
	
	public ZixunjiluEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 景点名称
	 */
					
	private String jingdianmingcheng;
	
	/**
	 * 景点图片
	 */
					
	private String jingdiantupian;
	
	/**
	 * 咨询日期
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date zixunriqi;
	
	/**
	 * 咨询内容
	 */
					
	private String zixunneirong;
	
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
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：景点名称
	 */
	public void setJingdianmingcheng(String jingdianmingcheng) {
		this.jingdianmingcheng = jingdianmingcheng;
	}
	/**
	 * 获取：景点名称
	 */
	public String getJingdianmingcheng() {
		return jingdianmingcheng;
	}
	/**
	 * 设置：景点图片
	 */
	public void setJingdiantupian(String jingdiantupian) {
		this.jingdiantupian = jingdiantupian;
	}
	/**
	 * 获取：景点图片
	 */
	public String getJingdiantupian() {
		return jingdiantupian;
	}
	/**
	 * 设置：咨询日期
	 */
	public void setZixunriqi(Date zixunriqi) {
		this.zixunriqi = zixunriqi;
	}
	/**
	 * 获取：咨询日期
	 */
	public Date getZixunriqi() {
		return zixunriqi;
	}
	/**
	 * 设置：咨询内容
	 */
	public void setZixunneirong(String zixunneirong) {
		this.zixunneirong = zixunneirong;
	}
	/**
	 * 获取：咨询内容
	 */
	public String getZixunneirong() {
		return zixunneirong;
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

package com.entity.view;

import com.entity.LuxianyudingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 路线预定
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-07-31 06:55:54
 */
@TableName("luxianyuding")
public class LuxianyudingView  extends LuxianyudingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public LuxianyudingView(){
	}
 
 	public LuxianyudingView(LuxianyudingEntity luxianyudingEntity){
 	try {
			BeanUtils.copyProperties(this, luxianyudingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}

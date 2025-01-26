package com.entity.view;

import com.entity.ZixunjiluEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 咨询记录
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-07-31 06:55:54
 */
@TableName("zixunjilu")
public class ZixunjiluView  extends ZixunjiluEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ZixunjiluView(){
	}
 
 	public ZixunjiluView(ZixunjiluEntity zixunjiluEntity){
 	try {
			BeanUtils.copyProperties(this, zixunjiluEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}

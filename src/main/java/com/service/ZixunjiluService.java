package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZixunjiluEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZixunjiluVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZixunjiluView;


/**
 * 咨询记录
 *
 * @author 
 * @email 
 * @date 2022-07-31 06:55:54
 */
public interface ZixunjiluService extends IService<ZixunjiluEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZixunjiluVO> selectListVO(Wrapper<ZixunjiluEntity> wrapper);
   	
   	ZixunjiluVO selectVO(@Param("ew") Wrapper<ZixunjiluEntity> wrapper);
   	
   	List<ZixunjiluView> selectListView(Wrapper<ZixunjiluEntity> wrapper);
   	
   	ZixunjiluView selectView(@Param("ew") Wrapper<ZixunjiluEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZixunjiluEntity> wrapper);
   	

}


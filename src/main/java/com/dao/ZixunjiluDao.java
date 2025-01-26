package com.dao;

import com.entity.ZixunjiluEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZixunjiluVO;
import com.entity.view.ZixunjiluView;


/**
 * 咨询记录
 * 
 * @author 
 * @email 
 * @date 2022-07-31 06:55:54
 */
public interface ZixunjiluDao extends BaseMapper<ZixunjiluEntity> {
	
	List<ZixunjiluVO> selectListVO(@Param("ew") Wrapper<ZixunjiluEntity> wrapper);
	
	ZixunjiluVO selectVO(@Param("ew") Wrapper<ZixunjiluEntity> wrapper);
	
	List<ZixunjiluView> selectListView(@Param("ew") Wrapper<ZixunjiluEntity> wrapper);

	List<ZixunjiluView> selectListView(Pagination page,@Param("ew") Wrapper<ZixunjiluEntity> wrapper);
	
	ZixunjiluView selectView(@Param("ew") Wrapper<ZixunjiluEntity> wrapper);
	

}

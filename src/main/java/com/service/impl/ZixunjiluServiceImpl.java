package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.ZixunjiluDao;
import com.entity.ZixunjiluEntity;
import com.service.ZixunjiluService;
import com.entity.vo.ZixunjiluVO;
import com.entity.view.ZixunjiluView;

@Service("zixunjiluService")
public class ZixunjiluServiceImpl extends ServiceImpl<ZixunjiluDao, ZixunjiluEntity> implements ZixunjiluService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZixunjiluEntity> page = this.selectPage(
                new Query<ZixunjiluEntity>(params).getPage(),
                new EntityWrapper<ZixunjiluEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZixunjiluEntity> wrapper) {
		  Page<ZixunjiluView> page =new Query<ZixunjiluView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ZixunjiluVO> selectListVO(Wrapper<ZixunjiluEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZixunjiluVO selectVO(Wrapper<ZixunjiluEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZixunjiluView> selectListView(Wrapper<ZixunjiluEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZixunjiluView selectView(Wrapper<ZixunjiluEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

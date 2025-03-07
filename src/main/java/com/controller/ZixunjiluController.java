package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.ZixunjiluEntity;
import com.entity.view.ZixunjiluView;

import com.service.ZixunjiluService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 咨询记录
 * 后端接口
 * @author 
 * @email 
 * @date 2022-07-31 06:55:54
 */
@RestController
@RequestMapping("/zixunjilu")
public class ZixunjiluController {
    @Autowired
    private ZixunjiluService zixunjiluService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZixunjiluEntity zixunjilu, 
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date zixunriqistart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date zixunriqiend,
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			zixunjilu.setYonghuming((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ZixunjiluEntity> ew = new EntityWrapper<ZixunjiluEntity>();
                if(zixunriqistart!=null) ew.ge("zixunriqi", zixunriqistart);
                if(zixunriqiend!=null) ew.le("zixunriqi", zixunriqiend);

    	PageUtils page = zixunjiluService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zixunjilu), params), params));
		request.setAttribute("data", page);
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZixunjiluEntity zixunjilu, 
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date zixunriqistart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date zixunriqiend,
		HttpServletRequest request){
        EntityWrapper<ZixunjiluEntity> ew = new EntityWrapper<ZixunjiluEntity>();
                if(zixunriqistart!=null) ew.ge("zixunriqi", zixunriqistart);
                if(zixunriqiend!=null) ew.le("zixunriqi", zixunriqiend);

    	PageUtils page = zixunjiluService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zixunjilu), params), params));
		request.setAttribute("data", page);
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZixunjiluEntity zixunjilu){
       	EntityWrapper<ZixunjiluEntity> ew = new EntityWrapper<ZixunjiluEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zixunjilu, "zixunjilu")); 
        return R.ok().put("data", zixunjiluService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZixunjiluEntity zixunjilu){
        EntityWrapper< ZixunjiluEntity> ew = new EntityWrapper< ZixunjiluEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zixunjilu, "zixunjilu")); 
		ZixunjiluView zixunjiluView =  zixunjiluService.selectView(ew);
		return R.ok("查询咨询记录成功").put("data", zixunjiluView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZixunjiluEntity zixunjilu = zixunjiluService.selectById(id);
        return R.ok().put("data", zixunjilu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZixunjiluEntity zixunjilu = zixunjiluService.selectById(id);
        return R.ok().put("data", zixunjilu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZixunjiluEntity zixunjilu, HttpServletRequest request){
    	zixunjilu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zixunjilu);

        zixunjiluService.insert(zixunjilu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
	@IgnoreAuth
    @RequestMapping("/add")
    public R add(@RequestBody ZixunjiluEntity zixunjilu, HttpServletRequest request){
    	zixunjilu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zixunjilu);

        zixunjiluService.insert(zixunjilu);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZixunjiluEntity zixunjilu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zixunjilu);
        zixunjiluService.updateById(zixunjilu);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zixunjiluService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<ZixunjiluEntity> wrapper = new EntityWrapper<ZixunjiluEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			wrapper.eq("yonghuming", (String)request.getSession().getAttribute("username"));
		}

		int count = zixunjiluService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	
	





}

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

import com.entity.LuxianyudingEntity;
import com.entity.view.LuxianyudingView;

import com.service.LuxianyudingService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 路线预定
 * 后端接口
 * @author 
 * @email 
 * @date 2022-07-31 06:55:54
 */
@RestController
@RequestMapping("/luxianyuding")
public class LuxianyudingController {
    @Autowired
    private LuxianyudingService luxianyudingService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,LuxianyudingEntity luxianyuding, 
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date yudingshijianstart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date yudingshijianend,
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			luxianyuding.setYonghuming((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<LuxianyudingEntity> ew = new EntityWrapper<LuxianyudingEntity>();
                if(yudingshijianstart!=null) ew.ge("yudingshijian", yudingshijianstart);
                if(yudingshijianend!=null) ew.le("yudingshijian", yudingshijianend);

    	PageUtils page = luxianyudingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, luxianyuding), params), params));
		request.setAttribute("data", page);
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,LuxianyudingEntity luxianyuding, 
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date yudingshijianstart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date yudingshijianend,
		HttpServletRequest request){
        EntityWrapper<LuxianyudingEntity> ew = new EntityWrapper<LuxianyudingEntity>();
                if(yudingshijianstart!=null) ew.ge("yudingshijian", yudingshijianstart);
                if(yudingshijianend!=null) ew.le("yudingshijian", yudingshijianend);

    	PageUtils page = luxianyudingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, luxianyuding), params), params));
		request.setAttribute("data", page);
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( LuxianyudingEntity luxianyuding){
       	EntityWrapper<LuxianyudingEntity> ew = new EntityWrapper<LuxianyudingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( luxianyuding, "luxianyuding")); 
        return R.ok().put("data", luxianyudingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(LuxianyudingEntity luxianyuding){
        EntityWrapper< LuxianyudingEntity> ew = new EntityWrapper< LuxianyudingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( luxianyuding, "luxianyuding")); 
		LuxianyudingView luxianyudingView =  luxianyudingService.selectView(ew);
		return R.ok("查询路线预定成功").put("data", luxianyudingView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        LuxianyudingEntity luxianyuding = luxianyudingService.selectById(id);
        return R.ok().put("data", luxianyuding);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        LuxianyudingEntity luxianyuding = luxianyudingService.selectById(id);
        return R.ok().put("data", luxianyuding);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody LuxianyudingEntity luxianyuding, HttpServletRequest request){
    	luxianyuding.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(luxianyuding);

        luxianyudingService.insert(luxianyuding);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody LuxianyudingEntity luxianyuding, HttpServletRequest request){
    	luxianyuding.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(luxianyuding);

        luxianyudingService.insert(luxianyuding);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody LuxianyudingEntity luxianyuding, HttpServletRequest request){
        //ValidatorUtils.validateEntity(luxianyuding);
        luxianyudingService.updateById(luxianyuding);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        luxianyudingService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<LuxianyudingEntity> wrapper = new EntityWrapper<LuxianyudingEntity>();
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

		int count = luxianyudingService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	
	





}

package cn.jeefast.modules.oss.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import cn.jeefast.modules.oss.dao.SysOssDao;
import cn.jeefast.modules.oss.entity.SysOss;
import cn.jeefast.modules.oss.service.SysOssService;

import java.util.Map;



@Service("sysOssService")
public class SysOssServiceImpl extends ServiceImpl<SysOssDao, SysOss> implements SysOssService {
	@Autowired
	private SysOssDao sysOssDao;
	
	@Override
	public Page<SysOss> queryPageList(Page<SysOss> page, Map<String, Object> map) {
		page.setRecords(sysOssDao.queryPageList(page, map));
		
		return page;
	}
		
	@Override
	public void deleteBatch(Long[] ids){
		sysOssDao.deleteBatch(ids);
	}

	
	
}

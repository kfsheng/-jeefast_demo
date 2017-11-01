package cn.jeefast.modules.oss.dao;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;

import cn.jeefast.modules.oss.entity.SysOss;

/**
 * 文件上传
 * 
 * @author theodo
 * @email 36780272@qq.com
 * @date 2017-03-25 12:13:26
 */
public interface SysOssDao extends BaseMapper<SysOss> {
	int deleteBatch(Object[] id);

	List<SysOss> queryPageList(Page<SysOss> page, Map<String, Object> map);
	
}

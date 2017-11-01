package cn.jeefast.modules.api.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;

import cn.jeefast.modules.api.entity.TbUser;

/**
 * <p>
  * 用户 Mapper 接口
 * </p>
 *
 * @author theodo
 * @since 2017-10-28
 */
public interface TbUserDao extends BaseMapper<TbUser> {
	
	TbUser queryByMobile(String mobile);

}
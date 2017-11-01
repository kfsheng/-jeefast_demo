package cn.jeefast.modules.api.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;

import cn.jeefast.modules.api.entity.TbToken;

/**
 * <p>
  * 用户Token Mapper 接口
 * </p>
 *
 * @author theodo
 * @since 2017-10-28
 */
public interface TbTokenDao extends BaseMapper<TbToken> {
	
	TbToken queryByUserId(Long userId);

	TbToken queryByToken(String token);

}
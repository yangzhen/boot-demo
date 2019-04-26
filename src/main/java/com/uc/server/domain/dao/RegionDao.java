package com.uc.server.domain.dao;

import com.uc.server.config.MyMapper;
import com.uc.server.domain.entry.Region;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author yangxinyan
 * @date 2019/4/23 14:19
 */
public interface RegionDao extends MyMapper<Region> {

  @Select("select * from tmp_regions where parent_code = #{code} and enabled=1")
  public List<Region> findByParentCode(@Param("code") Integer code);


  @Select("select * from tmp_regions where enabled=1")
  public List<Region> queryAll();
}

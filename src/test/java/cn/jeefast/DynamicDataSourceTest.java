package cn.jeefast;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.jeefast.datasources.DataSourceTestService;
import cn.jeefast.modules.api.entity.TbUser;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DynamicDataSourceTest {
    @Autowired
    private DataSourceTestService dataSourceTestService;

    @Test
    public void test(){
        //数据源1
    	TbUser user = dataSourceTestService.queryObject(1L);
        System.out.println(ToStringBuilder.reflectionToString(user));

        //数据源2
        TbUser user2 = dataSourceTestService.queryObject2(1L);
        System.out.println(ToStringBuilder.reflectionToString(user2));

        //数据源1
        TbUser user3 = dataSourceTestService.queryObject(1L);
        System.out.println(ToStringBuilder.reflectionToString(user3));
    }

}

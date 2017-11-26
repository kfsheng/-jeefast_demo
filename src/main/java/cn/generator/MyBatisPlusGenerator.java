package cn.generator;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.HashMap;
import java.util.Map;

/**
 * mybatis-plus代码生成器
 * 
 * @author theodo
 * @Date 2017/10/21 12:38
 */
public class MyBatisPlusGenerator {

    public static void main(String[] args) {
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir("D:\\temp\\jeefast\\src\\main\\java");//这里写你自己的java目录
        gc.setFileOverride(true);//是否覆盖
        gc.setActiveRecord(true);
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(false);// XML columList
        gc.setAuthor("theodo");
        
        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        gc.setMapperName("%sDao");
        gc.setXmlName("%sDao");
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setControllerName("%sController");
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setTypeConvert(new MySqlTypeConvert() {
            // 自定义数据库表字段类型转换【可选】
            @Override
            public DbColumnType processTypeConvert(String fieldType) {
                return super.processTypeConvert(fieldType);
            }
        });
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("123456");
        dsc.setUrl("jdbc:mysql://127.0.0.1:3306/jeefast?characterEncoding=utf8");
        mpg.setDataSource(dsc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
         //strategy.setTablePrefix(new String[]{"pf_"});// 此处可以修改为您的表前缀
        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
         //strategy.setInclude(new String[] { "pf_notice" }); // 需要生成的表
        // 排除生成的表
        strategy.setExclude(new String[]{"qrtz_blob_triggers","qrtz_calendars","qrtz_cron_triggers",
        		                         "qrtz_fired_triggers","qrtz_job_details","qrtz_locks",
        		                         "qrtz_paused_trigger_grps","qrtz_scheduler_state","qrtz_simple_triggers",
        		                         "qrtz_simprop_triggers","qrtz_triggers"}); 
        // 自定义实体父类
     	// strategy.setSuperEntityClass("com.baomidou.demo.TestEntity");
     	// 自定义实体，公共字段
     	// strategy.setSuperEntityColumns(new String[] { "test_id", "age" });
     	// 自定义 mapper 父类
     	// strategy.setSuperMapperClass("com.baomidou.demo.TestMapper");
     	// 自定义 service 父类
     	// strategy.setSuperServiceClass("com.baomidou.demo.TestService");
     	// 自定义 service 实现类父类
     	// strategy.setSuperServiceImplClass("com.baomidou.demo.TestServiceImpl");
     	// 自定义 controller 父类
     	strategy.setSuperControllerClass("cn.jeefast.common.base.BaseController");
        // 生成 RestController 风格
     	strategy.setRestControllerStyle(true);
        
        mpg.setStrategy(strategy);

        // 包配置
        // 注意不同的模块生成时要修改对应模块包名
        PackageConfig pc = new PackageConfig();
        pc.setParent(null);
        pc.setEntity("cn.jeefast.modules.oss.entity");
        pc.setMapper("cn.jeefast.modules.oss.dao");
        pc.setXml("cn.jeefast.modules.oss.dao.mapping");
        pc.setService("cn.jeefast.modules.oss.service");        
        pc.setServiceImpl("cn.jeefast.modules.oss.service.impl");    
        pc.setController("cn.jeefast.modules.oss.controller");     
        mpg.setPackageInfo(pc);

        // 注入自定义配置，可以在 VM 中使用 cfg.abc 设置的值
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<>();
                map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
                this.setMap(map);
            }
        };
        mpg.setCfg(cfg);
        
        
        // 自定义模板配置，可以 copy 源码 mybatis-plus/src/main/resources/templates 下面内容修改，
        // 放置自己项目的 src/main/resources/templates 目录下, 默认名称一下可以不配置，也可以自定义模板名称
        TemplateConfig tc = new TemplateConfig();
        tc.setController("/templates/controller.java.vm");
        tc.setEntity("/templates/entity.java.vm");
        tc.setMapper("/templates/mapper.java.vm");
        tc.setXml("/templates/mapper.xml.vm");
        tc.setService("/templates/service.java.vm");
        tc.setServiceImpl("/templates/serviceImpl.java.vm");
        // 如上任何一个模块如果设置 空 OR Null 将不生成该模块。
        mpg.setTemplate(tc);

        // 执行生成
        mpg.execute();

        // 打印注入设置
        System.err.println(mpg.getCfg().getMap().get("abc"));
    }

}
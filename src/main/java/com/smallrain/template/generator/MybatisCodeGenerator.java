package com.smallrain.template.generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

/**
 * mybatis 代码生成器
 * 
 * @author wangying.dz3
 *
 */
public class MybatisCodeGenerator {

  public static void main(String[] args) {

    // 代码生成器
    AutoGenerator autoGenerator = new AutoGenerator();
    // set freemarker engine
    autoGenerator.setTemplateEngine(new FreemarkerTemplateEngine());

    String projectPath = System.getProperty("user.dir");
    
    // 全局配置
    GlobalConfig globalConfig = new GlobalConfig();
    globalConfig.setOutputDir(projectPath + "/src/main/java");
    globalConfig.setAuthor("wangying");
    globalConfig.setOpen(false);
    globalConfig.setSwagger2(true); // 实体属性 Swagger2 注解
    globalConfig.setFileOverride(true);
    globalConfig.setActiveRecord(true);// 不需要ActiveRecord特性的请改为false
    globalConfig.setEnableCache(false);// XML 二级缓存
    globalConfig.setBaseResultMap(true);// XML ResultMap
    globalConfig.setBaseColumnList(false);// XML columList
    // .setKotlin(true) 是否生成 kotlin 代码
    autoGenerator.setGlobalConfig(globalConfig);

    // 数据库配置
    DataSourceConfig dataSourceConfig = new DataSourceConfig();
    dataSourceConfig.setDbType(DbType.MYSQL);
    dataSourceConfig.setUrl("jdbc:mysql://106.12.204.7:3306/template?useUnicode=true&useSSL=false&characterEncoding=utf8");
    dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
    dataSourceConfig.setUsername("template");
    dataSourceConfig.setPassword("123456");
    autoGenerator.setDataSource(dataSourceConfig);

    // 包配置
    PackageConfig packageConfig = new PackageConfig();
    packageConfig.setModuleName(scanner("实体名称"));
    packageConfig.setParent("com.smallrain.template");
    autoGenerator.setPackageInfo(packageConfig);

    // 自定义配置
    InjectionConfig injectionConfig = new InjectionConfig() {
      @Override
      public void initMap() {
        // to do nothing
      }
    };

    // 如果模板引擎是 freemarker
    String templatePath = "/templates/mapper.xml.ftl";

    // 自定义输出配置
    List<FileOutConfig> focList = new ArrayList<>();
    // 自定义配置会被优先输出
    focList.add(new FileOutConfig(templatePath) {
      @Override
      public String outputFile(TableInfo tableInfo) {
        // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
        return projectPath + "/src/main/resources/mapper/" + packageConfig.getModuleName() + "/" + tableInfo.getEntityName()
            + "Mapper" + StringPool.DOT_XML;
      }
    });
    injectionConfig.setFileOutConfigList(focList);
    autoGenerator.setCfg(injectionConfig);
    
   // 配置模板
    TemplateConfig templateConfig = new TemplateConfig();
    // 配置自定义输出模板
    //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
//    templateConfig.setEntity("templates/entity2.java");
//    templateConfig.setService();
//    templateConfig.setController();

    templateConfig.setXml(null);
    autoGenerator.setTemplate(templateConfig);

    
   // 策略配置
    StrategyConfig strategy = new StrategyConfig();
    strategy.setCapitalMode(true);// 全局大写命名 ORACLE 注意
    strategy.setNaming(NamingStrategy.underline_to_camel);
    strategy.setColumnNaming(NamingStrategy.underline_to_camel);
    //strategy.setSuperEntityClass("com.baomidou.ant.common.BaseEntity");
    strategy.setEntityLombokModel(true);
    strategy.setRestControllerStyle(true);
    // 公共父类
    //strategy.setSuperControllerClass("com.baomidou.ant.common.BaseController");
    // 写于父类中的公共字段
    //strategy.setSuperEntityColumns("id");
    strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
    strategy.setControllerMappingHyphenStyle(true);
    strategy.setTablePrefix(packageConfig.getModuleName() + "_");
    autoGenerator.setStrategy(strategy);
    autoGenerator.execute();
    
  }

  /**
   * <p>
   * 读取控制台内容
   * </p>
   */
  public static String scanner(String tip) {
    @SuppressWarnings("resource")
    Scanner scanner = new Scanner(System.in);
    StringBuilder help = new StringBuilder();
    help.append("请输入" + tip + "：");
    System.out.println(help.toString());
    if (scanner.hasNext()) {
      String ipt = scanner.next();
      if (StringUtils.isNotEmpty(ipt)) {
        return ipt;
      }
    }
    throw new MybatisPlusException("请输入正确的" + tip + "！");
  }

}

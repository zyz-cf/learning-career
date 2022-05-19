package com.zyz.springboot.mybatis.util;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.builder.GeneratorBuilder;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.querys.MySqlQuery;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.fill.Column;
import com.baomidou.mybatisplus.generator.fill.Property;
import com.baomidou.mybatisplus.generator.keywords.MySqlKeyWordsHandler;
import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

/**
 * 代码生成器
 *
 * @author 张易筑
 * @date 2022/2/9-13:38 星期三
 */
public class CodeGenerator {

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入" + tip + "：");
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotBlank(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public static void main(String[] args) {
        // 全局策略配置
        GlobalConfig globalConfig = GeneratorBuilder.globalConfigBuilder()
                // 覆盖已生成文件
                .fileOverride()
                // 指定输出目录 默认值: windows:D:// linux or mac : /tmp
                .outputDir("D:\\Document\\Generator\\my-generator")
                // 生成swagger注解
                .enableSwagger()
                // 作者名
                .author("zyz")
                // 时间策略 ONLY_DATE:使用 java.util.date 代替; SQL_PACK:使用 java.sql包下时间代替; TIME_PACK: 使用 java.time 包下的java8新的时间类型
                .dateType(DateType.TIME_PACK)
                // 注释日期格式
                .commentDate("yyyy-MM-dd")
                .build();

        // 数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig
                // 驱动连接的URL、数据库连接用户名、数据库连接密码
                .Builder("jdbc:mysql://172.17.6.189:3306/rbms_test?characterEncoding=UTF-8&useUnicode=true&useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=Asia/Shanghai", "ro_ccdb_pm_dm", "Uat#2398Rife$R")
                // 类型转换,数据库=》JAVA类型
                .typeConvert(new MySqlTypeConvert())
                // 关键字处理 ,这里选取了mysql5.7文档中的关键字和保留字（含移除）
                .keyWordsHandler(new MySqlKeyWordsHandler())
                // 数据库信息查询类,默认由 dbType 类型决定选择对应数据库内置实现
                .dbQuery(new MySqlQuery())
                .build();

        // 策略配置
        StrategyConfig strategyConfig = new StrategyConfig.Builder()
                // 全局大写命名
                .enableCapitalMode()
                // 排除生成的表
                .addExclude()
                // 对应表 sys_user
                .addInclude("pms_project_score_his")
                // 表前缀
                .addTablePrefix("pms_")
                // 字段前缀
                .addFieldPrefix("tb_")
                //跳过视图
                .enableSkipView()

                .controllerBuilder()
                //@RestController 注解
                .enableRestStyle()
                //url中驼峰转连字符
                .enableHyphenStyle()
                .formatFileName("%sController")

                .entityBuilder()
                // lombok 模型
                .enableLombok()
                // 链式操作
                .enableChainModel()
                // 去掉字段前边的is
                .enableRemoveIsPrefix()
                // 自定义实体，公共字段
                //.addSuperEntityColumns("id", "createDate", "createId", "updateDate", "updateId")
                .naming(NamingStrategy.underline_to_camel)
                .columnNaming(NamingStrategy.underline_to_camel)
                .enableTableFieldAnnotation()
                .enableRemoveIsPrefix()
                .enableTableFieldAnnotation()
                .enableActiveRecord()
                .versionColumnName("version")
                .versionPropertyName("version")
                .logicDeleteColumnName("deleted")
                .logicDeletePropertyName("deleteFlag")
                .addTableFills(new Column("create_time", FieldFill.INSERT))
                .addTableFills(new Property("updateTime", FieldFill.INSERT_UPDATE))
                .idType(IdType.AUTO)
                // .formatFileName("%sEntity")
                .formatFileName("%s")

                .serviceBuilder()
                .formatServiceFileName("I%sService")
                .formatServiceImplFileName("%sServiceImpl")

                .mapperBuilder()
                .superClass(BaseMapper.class)
                .enableBaseResultMap()
                .enableBaseColumnList()
                .enableMapperAnnotation()
                .formatMapperFileName("%sMapper")
                .formatXmlFileName("%sMapper")
                .build();

        // 包配置
        PackageConfig packageConfig = new PackageConfig.Builder()
                // 父包名。如果为空，将下面子包名必须写全部，否则就只需写子包名 com.zyz
                .parent(scanner("父包名"))
                // 父包模块名 basic.core
                .moduleName(scanner("模块名"))
                .entity("model")
                .controller("controller")
                .service("service")
                .serviceImpl("service.impl")
                .mapper("dao")
                .xml("mapper")
                .build();

        // 配置模板
        // TemplateConfig templateConfig = new TemplateConfig.Builder().disable().build();//激活所有默认模板

        // 添加以上配置到AutoGenerator中
        // 数据源配置
        AutoGenerator autoGenerator = new AutoGenerator(dataSourceConfig);

        // 全局策略配置
        autoGenerator.global(globalConfig);

        // 策略配置
        autoGenerator.strategy(strategyConfig);

        // 包配置
        autoGenerator.packageInfo(packageConfig);

        // 配置模板
        // autoGenerator.template(templateConfig);

        // 生成代码
        autoGenerator.execute();
    }
}

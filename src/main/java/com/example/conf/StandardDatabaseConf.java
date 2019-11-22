package com.example.conf;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.example.mapper.standard", sqlSessionFactoryRef = "standardSqlSessionFactory",
        sqlSessionTemplateRef = "standardSqlSessionTemplate")
public class StandardDatabaseConf {

    @Bean("standardDataSourceProperties")
    @ConfigurationProperties(prefix = "spring.datasource.standard")
    public DataSourceProperties mainDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name = "standardDataSource")
    public DataSource getStandardDataSource(@Qualifier("standardDataSourceProperties") DataSourceProperties properties) {
        return DataSourceBuild.build(properties);

    }

    @Bean("standardPaginationInterceptor")
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    @Bean(name = "standardSqlSessionFactory")
    public SqlSessionFactory standardSqlSessionFactory(@Qualifier("standardDataSource") DataSource dataSource,
                                                       @Qualifier("standardPaginationInterceptor") PaginationInterceptor interceptor) throws Exception {
        MybatisSqlSessionFactoryBean bean = new MybatisSqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath:mapper/standard/*.xml"));
        Interceptor[] plugins = new Interceptor[]{interceptor};
        bean.setPlugins(plugins);
        return bean.getObject();
    }

//    @Bean(name = "standardTransactionManager")
//    public DataSourceTransactionManager standardTransactionManager(@Qualifier("standardDataSource") DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }

    @Bean("standardSqlSessionTemplate")
    public SqlSessionTemplate standardSqlSessionTemplate(@Qualifier("standardSqlSessionFactory") SqlSessionFactory sessionFactory) {
        return new SqlSessionTemplate(sessionFactory);
    }
}

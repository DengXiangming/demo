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
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.example.mapper.select", sqlSessionFactoryRef = "selectSqlSessionFactory",
        sqlSessionTemplateRef = "selectSqlSessionTemplate")
public class SelectDatabaseConf {

    @Bean("selectDataSourceProperties")
    @ConfigurationProperties(prefix = "spring.datasource.select")
    public DataSourceProperties mainDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Primary
    @Bean(name = "selectDataSource")
    public DataSource getSelectDataSource(@Qualifier("selectDataSourceProperties") DataSourceProperties properties) {
        return DataSourceBuild.build(properties);
    }

    @Bean("selectPaginationInterceptor")
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    @Primary
    @Bean(name = "selectSqlSessionFactory")
    public SqlSessionFactory selectSqlSessionFactory(@Qualifier("selectDataSource") DataSource dataSource,
                                                     @Qualifier("selectPaginationInterceptor") PaginationInterceptor interceptor) throws Exception {
        MybatisSqlSessionFactoryBean bean = new MybatisSqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath:mapper/select/*.xml"));
        Interceptor[] plugins = new Interceptor[]{interceptor};
        bean.setPlugins(plugins);
        return bean.getObject();
    }

//    @Primary
//    @Bean(name = "selectTransactionManager")
//    public DataSourceTransactionManager selectTransactionManager(@Qualifier("selectDataSource") DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }


    @Primary
    @Bean("selectSqlSessionTemplate")
    public SqlSessionTemplate selectSqlSessionTemplate(@Qualifier("selectSqlSessionFactory") SqlSessionFactory sessionFactory) {
        return new SqlSessionTemplate(sessionFactory);
    }

}

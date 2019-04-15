/*******************************************************************************
 * Copyright 2019 Tanveer Haider
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package com.techwizard.mybatis.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;


import lombok.extern.log4j.Log4j2;

@Configuration
@Log4j2
public class MyBatisConfiguration {
	
	@Autowired
	private DataBaseConfig dbConfig;
	
	private static final String MAPPER_LOCATION="mappers/*.xml";
	/***
	 * 
	 * @return
	 */
	@Bean
	public DataSource dataSource() {
	 BasicDataSource ds = new BasicDataSource();
	 ds.setDriverClassName(dbConfig.getDriverClassName());
	 ds.setUrl(dbConfig.getDbUrl());
	 ds.setUsername(dbConfig.getDbUserName());
	 ds.setPassword(dbConfig.getDbPassword());
	 ds.setInitialSize(dbConfig.getInitialConnectionPoolSize());
	 ds.setMaxTotal(dbConfig.getMaxConnectionPoolSize());
	 ds.setMaxWaitMillis(dbConfig.getMaxWaitinMillis());
	 ds.setAccessToUnderlyingConnectionAllowed(true);
	 return ds;
	}
	
	/***
	 * 
	 * @return
	 */
	@Bean
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }
	/***
	 * 
	 * @return
	 * @throws Exception
	 */
    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
    	log.info("--> set sqlSessionFactory");
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
        configuration.setJdbcTypeForNull(JdbcType.NULL);
        
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setConfiguration(configuration);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MAPPER_LOCATION));
        sessionFactory.setTypeAliasesPackage("com.techwizard.addressbook");
        
        return sessionFactory.getObject();
    }
    /***
     * 
     * @param sqlSessionFactory
     * @return
     */
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
    	log.info("---->Set SqlSessionTemplate");
    	return new SqlSessionTemplate(sqlSessionFactory);
    }
}

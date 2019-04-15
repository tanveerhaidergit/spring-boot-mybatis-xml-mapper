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

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Configuration
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DataBaseConfig {
	
	@Value("${app.datasource.driver-class-name}")
	private String driverClassName;
	
	@Value("${app.datasource.url}")
	private String dbUrl;
	
	@Value("${app.datasource.username}")
	private String dbUserName;
	
	@Value("${app.datasource.password}")
	private String dbPassword;
	
	@Value("${app.datasource.dbcp2.initial-size}")
	private int initialConnectionPoolSize;
	
	@Value("${app.datasource.dbcp2.max-total}")
	private int maxConnectionPoolSize;
	
	@Value("${app.datasource.dbcp2.max-wait-millis}")
	private int maxWaitinMillis;


}

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
package com.techwizard.addressbook.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ch.qos.logback.classic.Logger;
import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
public class BaseDao {

	@Autowired
	private SqlSessionFactory sqlSessionFactory;

	/***
	 * 
	 * @return
	 */
	protected SqlSession getSqlSession() {
		return sqlSessionFactory.openSession();
	}

	/***
	 * 
	 * @param sqlSession
	 */
	protected void closeSqlSession(SqlSession sqlSession) {
		try {
			if (null != sqlSession)
				sqlSession.close();
		} catch (Exception ex) {
			log.warn("Unable to close sql Session");
		}
	}

	/***
	 * 
	 * @param sqlId
	 * @return
	 */
	protected <T> T getSingleRowResult(String sqlId, Object parameter) {
		SqlSession sqlSession = null;
		T result = null;
		try {
			sqlSession = getSqlSession();
			result = sqlSession.selectOne(sqlId, parameter);
		} catch (Exception e) {
			log.error(e);
		} finally {
			closeSqlSession(sqlSession);
		}
		return result;
	}

	/***
	 * 
	 * @param sqlId
	 * @return
	 */
	protected <T> List<T> getMultipleRowResult(String sqlId) {
		SqlSession sqlSession = null;
		List<T> result = null;
		try {
			sqlSession = getSqlSession();
			result = sqlSession.selectList(sqlId);
		} catch (Exception e) {
			log.error(e);
		} finally {
			closeSqlSession(sqlSession);
		}
		return result;
	}

	/***
	 * 
	 * @param sqlId
	 * @return
	 */
	protected <T> List<T> getMultipleRowResult(String sqlId, Object parameter) {
		SqlSession sqlSession = null;
		List<T> result = null;
		try {
			sqlSession = getSqlSession();
			result = sqlSession.selectList(sqlId, parameter);
		} catch (Exception e) {
			log.error(e);
		} finally {
			closeSqlSession(sqlSession);
		}
		return result;
	}
	/***
	 * 
	 * @param sqlId
	 * @param row
	 */
	protected <T> void save(String sqlId, T row) {
		SqlSession sqlSession = null;
		try {
			sqlSession = getSqlSession();
			sqlSession.update(sqlId, row);
		} catch (Exception e) {
			log.error(e);
		} finally {
			closeSqlSession(sqlSession);
		}
	}
	/***
	 * 
	 * @param sqlId
	 * @param row
	 */
	protected <T> void update(String sqlId, T row) {
		SqlSession sqlSession = null;
		try {
			sqlSession = getSqlSession();
			sqlSession.update(sqlId, row);
			
		} catch (Exception e) {
			log.error(e);
		} finally {
			closeSqlSession(sqlSession);
		}
	}
	
	protected <T> void delete(String sqlId,Object parameter) {
		SqlSession sqlSession = null;
		try {
			sqlSession = getSqlSession();
			sqlSession.update(sqlId,parameter);
		} catch (Exception e) {
			log.error(e);
		} finally {
			closeSqlSession(sqlSession);
		}
	}
}

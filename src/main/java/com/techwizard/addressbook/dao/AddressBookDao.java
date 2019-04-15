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

import java.util.List;

import org.springframework.stereotype.Repository;

import com.techwizard.addressbook.AddressBook;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Repository
public class AddressBookDao extends BaseDao {
	
	/***
	 * 
	 * @param emailId
	 * @return
	 */
	public AddressBook findByEmailId(String emailId) {
		String sqlId = "findAddressByEmailId";
		return getSingleRowResult(sqlId,emailId);
	}
	
	public List<AddressBook> findByFirstNameAndDob(AddressBook addressBook) {
		String sqlId = "findAddressByFirstNameAndDateOfBirth";
		return getMultipleRowResult(sqlId,addressBook);
	}
	
	/***
	 * 
	 * @return
	 */
	public List<AddressBook> findAll(){
		String sqlId="finaAllAddresses";
		return getMultipleRowResult(sqlId);
	}
	/***
	 * 
	 * @param addressBook
	 */
	public void saveAddress(AddressBook addressBook) {
		String sqlId="insertAddress";
		save(sqlId, addressBook);
	}
	
	public void updateAddress(AddressBook addressBook) {
		String sqlId="updateAddress";
		update(sqlId, addressBook);
		
	}
	
	public void deleteAddress(Long id) {
		String sqlId="deleteAddress";
		delete(sqlId, id);
		
	}
}

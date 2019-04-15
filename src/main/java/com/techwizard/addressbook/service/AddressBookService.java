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
package com.techwizard.addressbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techwizard.addressbook.AddressBook;
import com.techwizard.addressbook.dao.AddressBookDao;

@Service
public class AddressBookService {
	
	@Autowired
	private AddressBookDao dao;
	
	public List<AddressBook> findAll(){
		return dao.findAll();
	}
	
	public List<AddressBook> findByFirstNameAndDateOfBirth(AddressBook addressBook){
		return dao.findByFirstNameAndDob(addressBook);
	}
	
	public AddressBook findByEmailId(String emailId) {
		return dao.findByEmailId(emailId);
	}
	
	public void createAddress(AddressBook addressBook) {
		dao.saveAddress(addressBook);
	}
	
	public void updateAddress(AddressBook addressBook) {
		dao.updateAddress(addressBook);
	}
	
	public void deleteAddress(Long id) {
		dao.deleteAddress(id);
	}

}

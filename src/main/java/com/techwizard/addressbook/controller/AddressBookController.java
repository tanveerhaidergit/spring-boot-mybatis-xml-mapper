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
package com.techwizard.addressbook.controller;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.techwizard.addressbook.AddressBook;
import com.techwizard.addressbook.service.AddressBookService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/api/addressbook")
public class AddressBookController {
	
	@Autowired
	private AddressBookService service;
	/***
	 * 
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping(path="",produces="application/json")
	public ResponseEntity<AddressBook> findAllAdresses(){
		List<AddressBook> addresses = service.findAll();
		return new ResponseEntity(addresses, HttpStatus.OK);
	}
	/***
	 * 
	 * @param emailId
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping(path="/{emailId}",produces="application/json")
	public ResponseEntity<AddressBook> findByEmailId(@PathVariable String emailId){
		AddressBook addressByEmailId = service.findByEmailId(emailId);
		return new ResponseEntity(addressByEmailId, HttpStatus.OK);
	}
	/***
	 * 
	 * @param firstName
	 * @param dateOfBirth
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping(path="/firstnameanddateofbirth",produces="application/json")
	public ResponseEntity<AddressBook> findByFirstNameAndDateOfBirth(@RequestParam("firstName") String firstName,
																	 @RequestParam("dateOfBirth") String dateOfBirth	){
		String[] params = dateOfBirth.split("-");
		int year = Integer.valueOf(params[0]);
		int month =Integer.valueOf(params[1]);
		int day = Integer.valueOf(params[2]);
		LocalDate dob =LocalDate.of(year, month, day);
		AddressBook addressBookParam = new AddressBook();
		addressBookParam.setFirstName(firstName);
		addressBookParam.setDateOfBirth(dob);
		List<AddressBook> addresses = service.findByFirstNameAndDateOfBirth(addressBookParam);
		return new ResponseEntity(addresses, HttpStatus.OK);
	}
	
	/***
	 * 
	 * @param addressParam
	 * @return
	 */
	@PostMapping(path="",consumes="application/json",produces="application/json")
	public ResponseEntity<AddressBook> createAddress(@RequestBody AddressBook addressParam){
		log.info("Inside createAddress method" );
		service.createAddress(addressParam);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
				buildAndExpand(addressParam.getId()).toUri();
		log.info("Uri:"+location);
		return ResponseEntity.created(location).build();
		
	}
	/***
	 * 
	 * @param id
	 * @param addressParam
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PutMapping(path="/{id}",consumes="application/json",produces="application/json")
	public ResponseEntity<AddressBook> updateAddress(@PathVariable Long id,@RequestBody AddressBook addressParam){
		log.info("Inside updateAddress method" );
		addressParam.setId(id);
		service.updateAddress(addressParam);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
		
	}
	/***
	 * 
	 * @param id
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@DeleteMapping(path="/{id}")
	public ResponseEntity deleteAddress(@PathVariable Long id) {
		log.info("Inside deleteAddress method" );
		service.deleteAddress(id);
		return new ResponseEntity(id, HttpStatus.OK);
		
	}
	
}

package com.crm.base.springbatch;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import com.crm.domain.crm.User2;

/**
 * Builds a Product from a row in the CSV file (as a set of fields)
 */
public class UserFieldSetMapper implements FieldSetMapper<User2> {
	@Override
	public User2 mapFieldSet(FieldSet fieldSet) throws BindException {
		User2 user = new User2();
		user.setId(fieldSet.readInt("id"));
		user.setUserCode(fieldSet.readString("userCode"));
		user.setUserName(fieldSet.readString("userName"));
		user.setEnglishName(fieldSet.readString("englishName"));
		return user;
	}
}

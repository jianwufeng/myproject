package com.crm.base.springbatch;

import org.springframework.batch.item.ItemProcessor;

import com.crm.domain.crm.User2;

public class ProcessDemo implements ItemProcessor<User2, User2> {

	@Override
	public User2 process(User2 item) throws Exception {
		return item;
	}

}

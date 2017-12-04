package com.crm.base.springbatch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

import com.crm.domain.crm.User2;

public class WriteDemo implements ItemWriter<User2> {

	@Override
	public void write(List<? extends User2> items) throws Exception {

		for (User2 user2 : items) {
			System.out.println(user2.getId());
			System.out.println(user2.getUserCode());
			System.out.println(user2.getUserName());
			System.out.println(user2.getEnglishName());
		}

	}

}

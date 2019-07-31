package com.test;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.transaction.ChainedTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class TransactionManager {

	@Bean(name = "chainedTransactionManager")
	public ChainedTransactionManager transactionManager(
			@Qualifier("testTransactionMgr") PlatformTransactionManager tMgr1,
			@Qualifier("alterTransactionMgr") PlatformTransactionManager tMgr2) {
		return new ChainedTransactionManager(tMgr1, tMgr2);
	}
}

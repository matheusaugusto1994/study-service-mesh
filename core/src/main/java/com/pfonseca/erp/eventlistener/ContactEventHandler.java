package com.pfonseca.erp.eventlistener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

import com.pfonseca.erp.domain.Contact;

@Component
@RepositoryEventHandler
public class ContactEventHandler {

	private Logger logger = LoggerFactory.getLogger(ContactEventHandler.class);

	@HandleBeforeCreate
	public void handleContactSave(Contact p) {
		logger.info("Before new contact. Id: "+p.getId());
	}

	@HandleAfterCreate
	public void handleAfterContactSave(Contact p) {
		logger.info("After new contact. Id: "+p.getId());
	}
	
}

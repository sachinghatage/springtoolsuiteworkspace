package com.custom.generator.generators;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class OrderIdGenerator implements IdentifierGenerator {
//implement identifier generator and override generate method
	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		return null;
	}

	
}

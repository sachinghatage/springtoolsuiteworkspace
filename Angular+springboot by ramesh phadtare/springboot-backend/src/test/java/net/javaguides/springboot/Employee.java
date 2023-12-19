package net.javaguides.springboot;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Employee {
	

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		private String firstName;
		private String lastName;
		private String emailId;
		
		
		public Employee(long id, String firstName, String lastName, String emailId) {
			super();
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
			this.emailId = emailId;
		}
		
		
	}




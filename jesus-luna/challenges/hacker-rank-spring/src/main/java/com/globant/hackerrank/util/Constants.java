package com.globant.hackerrank.util;

public class Constants {
	
	public enum ResponseConstants {
		SUCCESS("Successful"), FAILURE("Unsuccessful");
		
		private String description;
		
		private ResponseConstants(final String description) {
			this.description = description;
		}

		public String getDescription() {
			return description;
		}		
	}
}

package com.hertz.herc.franchise.validators;

import com.hertz.herc.franchise.util.LogBroker;
import com.opensymphony.xwork2.validator.ValidationException;
import com.opensymphony.xwork2.validator.validators.FieldValidatorSupport;

public class PhoneNumberFieldValidator extends FieldValidatorSupport {
	private static Class<?> classRef = PhoneNumberFieldValidator.class;

	public void validate (Object object) throws ValidationException {
		LogBroker.debug (classRef, ">>> PhoneNumberFieldValidator::validate");
		String fieldName = getFieldName ();
		LogBroker.debug (classRef, "PhoneNumberFieldValidator::validate - stage 1");
		Object value = this.getFieldValue (fieldName, object);
		LogBroker.debug (classRef, "PhoneNumberFieldValidator::validate - stage 2");

		if (! (value instanceof String)) {
			LogBroker.debug (classRef, "PhoneNumberFieldValidator::validate - stage 2a");
			return;
		}
		LogBroker.debug (classRef, "PhoneNumberFieldValidator::validate - stage 3");

		String str = ((String) value).trim ();
		LogBroker.debug (classRef, "PhoneNumberFieldValidator::validate - stage 4");
		try {
			if (str.length () != 0) {
				LogBroker.debug (classRef, "PhoneNumberFieldValidator::validate - stage 5");
				if (str.indexOf ("-", 0) <= 5) {
					LogBroker.debug (classRef, "PhoneNumberFieldValidator::validate - stage 6");
					if (str.indexOf ("-") == str.lastIndexOf ("-")) {
						LogBroker.debug (classRef, "PhoneNumberFieldValidator::validate - stage 7");
						String stdcode = str.substring (0, str.indexOf ("-"));
						String phoneNo = str.substring ((str.indexOf ("-") + 1));
						if (phoneNo.length () < 6) {
							addFieldError (fieldName, object);
						}
						try {
							LogBroker.debug (classRef, "PhoneNumberFieldValidator::validate - stage 8");
							Integer.parseInt (stdcode);
							Integer.parseInt (phoneNo);
						}
						catch (NumberFormatException nfe) {
							LogBroker.debug (classRef, "PhoneNumberFieldValidator::validate - stage 9");
							addFieldError (fieldName, object);
							LogBroker.error (classRef, "<-- validate(Object object) :" + nfe);
							return;
						}
						LogBroker.debug (classRef, "PhoneNumberFieldValidator::validate - stage 10");
						return;
					}
				}
			}
		}
		catch (Exception e) {
			LogBroker.debug (classRef, "PhoneNumberFieldValidator::validate - stage 111");
			addFieldError (fieldName, object);
			LogBroker.error (classRef, "<-- validate(Object object) :" + e);
			return;
		}
		LogBroker.debug (classRef, "PhoneNumberFieldValidator::validate - stage 100");
		LogBroker.debug (classRef, "<<< PhoneNumberFieldValidator::validate");
	}
}

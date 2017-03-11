
package com.hertz.herc.franchise.util;

/**
 * This class defines all common error codes which <br>
 * extend across different sections of HERC applications. <br>
 * 
 * Note: Any error code which has dynamic content within its  <br>
 * error message must begin with the letter 'D'. Error codes <br>
 * which contain purely static (non-dynamic) messages should begin 
 * with the letter 'N'. <br>
 * 
 * e.g. DRX001 for dynamic message or NRX001 for static where <br>
 * DRX001 may be something like "Hello {0}, My name is {1}"   <br>
 * 
 * Values {0} and {1} will be substituted dynamically to produce  <br>
 * a completed message such as: <br>
 * 
 * "Hello Mr. Anderson, My name is Agent Smith" <br>
 * 
 * NRX001 may be something like "Your first name must be at least <br>
 * 3 characters in length" <br>
 * 
 * @author Kevin Valentine
 */

public interface HercErrorConstants {

	public static final String PREFIX_INVALID_CHARS_ERROR = "NHX001"; //Prefix contains an invalid entry	
	
	public static final String TITLE_EMPTY_ERROR = "NHX002"; //Title is required
	public static final String TITLE_INVALID_CHARS_ERROR = "NHX003"; //Title contains an invalid entry.	
	
	public static final String ADDRESS1_EMPTY_ERROR = "NHX004"; //Address 1 is required
	
	public static final String ADDRESS2_EMPTY_ERROR = "NHX005"; //Address2 is required
	
	public static final String CITY_EMPTY_ERROR = "NHX006"; //City is required
	
	public static final String COUNTRY_STATE_EMPTY_ERROR = "NHX007"; //Country/State is required
	public static final String COUNTRY_STATE_INVALID_CHARS_ERROR = "NHX008"; //Country/State contains an invalid entry.
	
	public static final String PHONE_EMPTY_ERROR = "NHX009"; //Phone is required
	public static final String PHONE_INVALID_CHARS_ERROR = "NHX010"; //Phone contains an invalid entry.
	
	public static final String EMAIL_INVALID_CHARS_ERROR = "NHX011"; //Email contains an invalid entry.
	public static final String EMAIL_CONFIRMATION_INVALID_CHARS_ERROR = "NHX012"; //Reenter Email contains an invalid entry.
	
	public static final String COMMENTS_EMPTY_ERROR = "NHX013"; //Comments is required
	public static final String COMMENTS_INVALID_CHARS_ERROR = "NHX014"; //Comments contains an invalid entry.
	public static final String FSN_EXCEPTION = "NHX015";	//HertzSystemException error.
	
	public static final String ZIP_POSTAL_CODE_EMPTY_ERROR = "NHX016"; //Zip/Postal Code is required
	

	/**
	 * Herc only messages (business layer)
	 */
	public static final String LOGIN_INVALID_USERNAME_PASSWORD = "NHX100"; //Comments contains an invalid entry.
	public static final String BRANCHES_NOT_FOUND_WITHIN_SPECS = "NHX101"; //No branch could be found within 999 miles
	public static final String EMPTY_CART = "NHX102"; //You have no items in your cart
	public static final String ACCOUNT_NUMBER_INVALID = "NHX103"; //The account number you have entered is not associated with an online HERC account. Please contact a HERC sales representative for more information.
	public static final String ACCOUNT_NUMBER_EXISTS = "NHX153"; //you already have access to that account
	public static final String USERNAME_INVALID = "NHX104"; //Invalid username
	public static final String JOB_LOCATION_NAME_INVALID = "NHX105"; //Job Location Name has already been used
	public static final String JOB_LOCATION_NOT_ADDED_FOR_CLOSEST_BRANCH = "NHX106"; //Unable to add Job Location using closest Herc branch
	public static final String JOB_LOCATION_NOT_ADDED = "NHX107"; //Unable to add Job Location

	public static final String PREFERENCE_EXISTS = "NHX108"; //Preference already exists

		public static final String DIRECTIONS_UNAVAILABLE = "NHX109"; //No directions are available
	public static final String LOCATION_NOT_FOUND = "NHX110"; //Your Search did not return any results, please contact a HERC representative for more information.

	public static final String CREDENTIALS_INVALID = "NHX111"; //Your credentials are not valid.
	public static final String USERNAME_UNAVAILABLE = "NHX112"; //Username is not available 

	public static final String MEMBER_PROFILE_INVALID = "NHX113"; //Your member profile is not valid.
	public static final String EMAIL_NOT_SENT = "NHX114"; //Email was not sent
	public static final String EQUIPMENT_ID_INVALID = "NHX115"; //Invalid equipment id
	public static final String PASSWORD_INVALID = "NHX116"; //Your password is not valid
	public static final String PASSWORD_MISMATCH = "NHX117"; //Passwords do not match
	public static final String CHALLENGE_ANSWERS_MISMATCH = "NHX118"; //Challenge answers do not match
	public static final String ACCOUNT_INACTIVE = "NHX119"; //This account is not active. Please contact your company admin for more information
	public static final String ACCOUNT_NOT_APPROVED = "NHX120"; //This account has not been approved. Please contact your company admin for more information
	public static final String INVALID_QUANTITY = "NHX121"; //Quantity must be greater than 0
	public static final String MISSING_SPEC2 = "NHX122";	//Missing equipment Spec 2 
	public static final String JOB_LOCATION_NAME_REQUIRED = "NHX123";	// Job Location Name is required
	public static final String JOB_LOCATION_CITY_REQUIRED = "NHX124";	//Job Location city is required
	public static final String ADDRESS_REQUIRED = "NHX125";				//Address is required 
	public static final String INVALID_COUNTRY_STATE = "NHX126";		//Invalid country/state 
	public static final String JOB_LOCATION_COUNTRY_INVALID = "NHX127";	//Job Location Country should be same as POS
	public static final String POSTAL_CODE_INVALID = "NHX128";			//Postal Code is required
	public static final String PREFIX_INVALID = "NHX129";				//Prefix invalid 
	public static final String FIRST_NAME_INVALID = "NHX130";			//First Name is invalid 
	public static final String MIDDLE_NAME_INVALID = "NHX131";			//Middle Name is invalid
	public static final String LAST_NAME_INVALID = "NHX132";			//Last Name is invalid 
	public static final String SUFFIX_INVALID = "NHX133";				//Suffix is invalid
	public static final String BUSINESS_NAME_INVALID = "NHX134";		//Business name is invalid 
	public static final String ADDRESS1_INVALID = "NHX135";		//Address 1 is invalid
	public static final String ADDRESS2_INVALID = "NHX136";		//Address 2 is invalid
	public static final String CITY_INVALID = "NHX137";			//City is invalid 
	public static final String EMAIL1_INVALID = "NHX138";		//Email 1 is invalid
	public static final String EMAIL2_INVALID = "NHX139";		//Email 2 is invalid
	public static final String EMAIL1_EMAIL2_INVALID = "NHX140";		//Email does not match Reenter email
	public static final String PHONE_INVALID = "NHX141";		//Phone is invalid
	public static final String FAX_INVALID = "NHX142";			//Fax is invalid 
	public static final String COMMENTS_INVALID = "NHX143";		//Comments invalid
	public static final String ITEM_DATE_INVALID = "NHX144";	//Invalid date for item
	public static final String ITEM_START_END_DATE_INVALID = "NHX145";	//End date must be after start date
	public static final String ANSWER_INCORRECT = "NHX146"; 	//We're sorry, the answer you submitted was incorrect
	public static final String OPTION_UNKNOWN = "NHX147"; 		//Unknown option
	public static final String LDAP_DOWN = "NHX148";			//Ldap down error
	public static final String REQUEST_INVALID_APPROVER = "NHX149"; //Approver is not valid.
	public static final String USER_DATA_LOCKED_FOR_EDIT = "NHX150";
	public static final String USER_INVALID_ID = "NHX151";			//The User ID is invalid.
	public static final String JOB_LOCATION_REQUIRED = "NHX152";	//You must select a job location.
	public static final String USER_SESSION_EXPIRED = "NHX159";		// logged in member session timeout
	public static final String PR_EQUIPMENT_NOT_IN_POS = "NHX160";	//None of the equipment in the chosen 'Prior Rentals' item is available for your current POS.
	/** Driving directions for branch location are not available at this time. Please contact a HERC representative for more information. */
	public static final String NO_DIRECTIONS_FOR_BRANCH = "NHX162";	
	
	// Rentalman error messages
	public static final String RM_SCHEDULED_MAINTENANCE = "NHX154";
	public static final String RM_AUTO_SHUTDOWN_SITE	= "NHX155";
	public static final String RM_AUTO_SHUTDOWN_MEMBER	= "NHX156";
	public static final String RM_UNAVAILABLE			= "NHX157";
	public static final String RM_INVALID_LOCATION		= "NHX158";
	
		
//	HERC Datamigration Error Constants
	public static final String DM_INVALID_MDB_STRUCTURE = "NHX200";	//MDB source structure is not as expected.

	/**
	 * Herc Dynamic messages
	 */

	public static final String COMPANY_ACCOUNT_LOOKUP_ERROR = "DHX101"; //Error looking up company account
	public static final String COMPANY_ACCOUNT_INVALID_ERROR = "DHX102"; //Error: company account is not valid
	
	public static final String ARBITRARY_ERROR	= "DHX103";				// used for arbitrary error messages by error framework
	
	
	
	// F[C|S][N|D]_ - FormInfo, [Common|Specific], [Non Dynamic|Dynamic]
	
	// 500-599; forminfo validation - form common error messages
	public static final String FCN_INVALID_PREFIX 			= "NHX500";
	public static final String FCN_INVALID_FIRST_NAME 		= "NHX501";
	public static final String FCN_INVALID_MIDDLE_NAME		= "NHX502";
	public static final String FCN_INVALID_LAST_NAME 		= "NHX503";
	public static final String FCN_INVALID_TITLE			= "NHX504";
	public static final String FCN_INVALID_ADDRESS1			= "NHX505";


	public static final String FCN_INVALID_ADDRESS2			= "NHX506";
	public static final String FCN_INVALID_CITY				= "NHX507";
	public static final String FCN_INVALID_COUNTRY_STATE 	= "NHX508";
	public static final String FCN_INVALID_POSTAL_CODE		= "NHX509";
	public static final String FCN_INVALID_PHONE			= "NHX510";
	public static final String FCN_INVALID_FAX				= "NHX511";
	public static final String FCN_INVALID_USERID			= "NHX512";
	public static final String FCN_USERID_EXISTS			= "NHX557";
	public static final String FCN_USERID_SAME_AS_EXISTING	= "NHX558"; 
	public static final String FCN_INCORRECT_PASSWORD		= "NHX559"; 
	public static final String FCN_INVALID_PASSWORD			= "NHX513";
	public static final String FCN_PASSWORD1_NEQ_PASSWORD2	= "NHX514";
	public static final String FCN_INVALID_EMAIL			= "NHX515";
	public static final String FCN_INVALID_SUFFIX			= "NHX516";
	public static final String FCN_INVALID_BUSINESS_NAME	= "NHX517";
	public static final String FCN_EMAIL1_NEQ_EMAIL2		= "NHX518";
	public static final String FCN_INVALID_JOBSITE_NAME		= "NHX519";
	public static final String FCN_INVALID_INVOICE_NUMBER	= "NHX520";
	public static final String FCN_INVALID_COMMENTS			= "NHX521";
	public static final String FCN_INVALID_NAME				= "NHX522";
	public static final String FNC_INVALID_SSN				= "NHX523";
	public static final String FCN_REQUIRED_COUNTRYSTATECITY_OR_ZIP = "NHX556";

	public static final String FCN_INVALID_QUANTITY			= "NHX527";
	public static final String FCN_INVALID_START_DATE		= "NHX528";
	public static final String FCN_INVALID_END_DATE			= "NHX529";
	public static final String FCN_END_DATE_INVALID_RANGE	= "NHX530";
	public static final String FCN_START_DATE_BEFORE_TODAY	= "NHX543";
	public static final String FCN_END_DATE_BEFORE_TODAY	= "NHX544";
	
	public static final String FCN_INVALID_PRICE			= "NHX531";
	
	public static final String FCN_NO_ITEMS_SELECTED		= "NHX532";
	
	public static final String FCN_INVALID_CATEGORY			= "NHX533";			// M1.4.1 & S1.2
	public static final String FCN_INVALID_SUBCAT1			= "NHX534";
	public static final String FCN_INVALID_SUBCAT2			= "NHX535";
	public static final String FCN_INVALID_SPEC1			= "NHX536";
	public static final String FCN_INVALID_SPEC2			= "NHX537";
	
	public static final String FCN_INVALID_PCARD_TYPE		= "NHX538";
	public static final String FCN_INVALID_PCARD_NUMBER		= "NHX539";
	public static final String FCN_INVALID_PCARD_EXP		= "NHX540";
	public static final String FCN_INVALID_SECURITY_CODE	= "NHX541";
	public static final String FCN_INVALID_PO_NUMBER		= "NHX542";	
	
	
	public static final String FCN_INVALID_WO_NUMBER		= "NHX545";
	public static final String FCN_NONEXISTANT_START_DATE	= "NHX546";
	public static final String FCN_NONEXISTANT_END_DATE 	= "NHX547";
	public static final String FCN_NO_ACCTS_SELECTED		= "NHX548";
	public static final String FCN_NO_REPORTS_SELECTED		= "NHX549";
	public static final String FCN_NO_PREFERENCE_NAME		= "NHX550";
	public static final String FCN_PREFERENCE_NAME_SAME 	= "NHX551";
	
	public static final String FCD_INVALID_FIRST_NAME		= "DHX500";			//M1.8	
	public static final String FCD_INVALID_LAST_NAME		= "DHX501";
	public static final String FCD_INVALID_EMAIL			= "DHX502";
	public static final String FCD_INVALID_ACCOUNT_NUMBER	= "DHX503";
	public static final String FCD_INVALID_COUNTRY			= "DHX504";
	
	public static final String FCN_NONEXISTANT_FILTER		= "NHX560";
	public static final String FCN_NONEXISTANT_OPERATOR		= "NHX561";
	public static final String FCN_NONEXISTANT_FILTER_VALUE = "NHX562";
	
	

	// 700-799; forminfo validation - form specific error messages
	
	
	public static final String FSN_INVALID_INVITE_KEY						= "NHX700";		// A1.1.1
	
	public static final String FSN_INVALID_CUSTOMER_NUMBER					= "NHX701";		// A1.3.1
	public static final String FSN_INVALID_PROGRESS_THROUGH_DATE 			= "NHX702";		
	public static final String FSN_INVALID_RELEASE_AMOUNT					= "NHX703";		
	
	public static final String FSN_INVALID_AP_CONTACT						= "NHX704";		// A1.2.1
	public static final String FSN_INVALID_BUSINESS_DESCRIPTION				= "NHX705";		
	public static final String FSN_INVALID_NUMBER_OF_EMPLOYEES				= "NHX706";		
	public static final String FSN_INVALID_CORPORATE_TAXID					= "NHX707";		
	public static final String FSN_INVALID_DATE_INCORPORATED				= "NHX708";		
	public static final String FSN_INVALID_YEARS_IN_BUSINESS_UNDER_OWNERS 	= "NHX709";		
	public static final String FSN_INVALID_CONTRACTORS_LICENSE_NUMBER		= "NHX710";		
	public static final String FSN_INVALID_CONTRACTORS_LICENSE_EXP_DATE		= "NHX711";		
	public static final String FSN_INVALID_PARENT_CORPORATION				= "NHX712";		
	public static final String FSN_INVALID_DUN_NUMBER						= "NHX713";		
	public static final String FSN_INVALID_INITIAL_CREDIT_REQUIREMENT		= "NHX714";		
	public static final String FSN_INVALID_MONTHLY_CREDIT_REQUIREMENT		= "NHX715";		
	public static final String FSN_INVALID_BANK_NAME						= "NHX716";		
	public static final String FSN_INVALID_CHECKING_ACCOUNT_NUMBER			= "NHX717";		
	public static final String FSN_INVALID_LOAN_ACCOUNT_NUMBER				= "NHX718";
	public static final String FSN_INVALID_CITY_BRANCH_NAME					= "NHX719";
	public static final String FSN_INVALID_BONDING_COMPANY_NAME				= "NHX720";
	
	public static final String FSN_INVALID_CONTACT_US_SUBJECT				= "NHX721";		// H1.2
	public static final String FSN_INVALID_INVOICE_BILLING_NUMBER			= "NHX722";
	
	public static final String FSN_INVALID_TEMPORARY_LOGIN_PASSWORD			= "NHX723";		// L1.4
	public static final String FSN_INVALID_CHALLENGE_ANSWER					= "NHX724";
	public static final String FSN_CHALLENGE1_NEQ_CHALLENGE2				= "NHX725";
	
	public static final String FSN_INVALID_PERSONAL_QUESTION_ANSWER			= "NHX726";		// L1.3
	
	public static final String FSN_INVALID_COMPANY_ACCOUNT_NUMBER			= "NHX727";		// M1.6
	public static final String FSN_INVALID_COMPANY_ACCOUNT_COUNTRY			= "NHX728";		// M1.6	
	
	public static final String FSN_INVALID_JOB_LOCATION						= "NHX729";		// M1.7.1	
	public static final String FSN_INVALID_POS								= "NHX730";			
	public static final String FSN_ACCOUNT_REQUIRED							= "NHX731";
	public static final String FSN_INVALID_PREFERENCE_NAME					= "NHX732";	 	// M1.4.1
	
	public static final String FSN_INVALID_PERSONAL_QUESTION				= "NHX733";		// M1.1
	public static final String FSN_INVALID_PERSONAL_ANSWER					= "NHX734";		// M1.1
	
	
	public static final String FSN_INVALID_RENTAL_JOB_LOCATION				= "NHX735";		// R1.1.3
	public static final String FSN_COUNTRY_STATE_NEQ_POS					= "NHX736";
	public static final String FSN_INVALID_POSTAL_CODE_CITY					= "NHX737";
	
	
	public static final String FSN_CART_IS_EMPTY							= "NHX738";	   //R1.1.5
	public static final String FSN_NO_EQUIPMENT_ITEM_SELECTED				= "NHX739";
	public static final String FSN_NO_QUANTITY_SELECTED						= "NHX740";
	public static final String FSN_NO_ITEM_SELECTED							= "NHX741";
	
	public static final String FSN_NO_INVITES_FILLED_OUT					= "NHX742";		// M1.8
	public static final String FSN_PENDING_COMPANY_ACCOUNT_NUMBER			= "NHX743";		// AT1.9
	
	public static final String FSN_ETRIEVE_NO_ACCOUNT_ACCESS				= "NHX744";		// M1.5
	public static final String FSN_CHOOSE_ACCOUNT_TYPE						= "NHX748";		// M1.5
	public static final String FSN_NO_ACCOUNT_ASSOCIATED					= "NHX747";		// M1.5
	public static final String FSN_ACCOUNT_REQUIRED_TO_CONTINUE				= "NHX749";		// M1.5
	public static final String FSN_SEARCH_TEXT_INVALID						= "NHX750";		// M1.5

	public static final String FSN_ETRIEVE_INVALID_REPORT					= "NHX745";
	
	public static final String FSN_AUTHORIZED_BANK_NOT_CHECKED				= "NHX746";		//A1.2.1
	
	public static final String FSN_CHOOSE_OPT_IN							= "NHX751";		//M1.25
	
	
	//  900-999; admin tool specific error messages
	public static final String FCN_NARP_ACCOUNT_REQUIRED					= "NHX900";
	public static final String FCN_NARP_ACCOUNT1_NEQ_NARP_ACCOUNT2			= "NHX901";	
	public static final String FCN_NARP_ACCOUNT_MANAGER						= "NHX902";
	public static final String FCN_ACCOUNT_REQUIRED							= "NHX903";
	public static final String FCN_ACCOUNT1_NEQ_ACCOUNT2					= "NHX904";
	public static final String FCN_NARP_COUNTRY_NEQ_LOCAL_NARP_COUNTRY		= "NHX905";
	public static final String FCN_EMAIL_ADDRESS_REQUIRED					= "NHX906";
	public static final String FCN_EMAIL_ADDRESS1_NEQ_EMAIL_ADDRESS2		= "NHX907";
	
	public static final String FCN_COMPANY_ACCTNUM_NOT_FOUND				= "NHX908";
	public static final String FCN_INVALID_ACCOUNT							= "NHX909";
	public static final String FCN_COMPANY_DESC_REQUIRED					= "NHX910";
	public static final String FCN_ANNUAL_VOLUME_REQUIRED					= "NHX911";
	public static final String FCN_YTD_VOLUME_REQUIRED						= "NHX912";
	public static final String FCN_POTENTIAL_VOLUME_REQUIRED				= "NHX913";
	public static final String FCN_MEMBER_ID_REQUIRED						= "NHX914";
	public static final String FCN_MEMBER_ID_ALREADY_USED					= "NHX915";
//	public static final String FCN_RETURN_DATE_REQUIRED						= "NHX916";			//Overdue Email Direct Link. 
	

	public static final String FCD_INVALID_COMPANY							= "DHX900";
	
	
	public static final String HSA_USERID_INVALID 							= "NHX916";			//Herc Sales App - User ID not known. Please try again.
	public static final String HSA_PASSWORD_INVALID 						= "NHX917";			//Herc Sales App - Password is incorrect.  
	public static final String HSA_PASSWORD_INCORRECT_USERID_DISABLE 		= "NHX918";			//Herc Sales App - Password is incorrect. User ID will be disabled after next incorrect sign-on.
	public static final String HSA_USERID_DISABLED 							= "NHX919";			//Herc Sales App - User ID is disabled.
	public static final String HSA_ICNUMBER_INVALID							= "NHX920";			//Herc Sales App - Invalid IC Number
	public static final String HSA_PASSWORD_EXPIRED							= "NHX921";			//Herc Sales App - Password Expired
	public static final String HSA_ROUSE_SAML_ERROR							= "NHX930";			//Herc Sales App - Error in handshake with Rouse
	
	//AT
	public static final String FCN_NUMERIC_REQUIRED							= "NHX922";
	
	public static final String RELEASE_TIME_PASSED							= "NHX922";			//OverDue Directlink - Release Time has already passed or it is more than 24 hours from current time.
	public static final String SITE_FIRST_NAME_REQUIRED						= "NHX923";			//OverDue Directlink - Site Contact First Name is required.
	public static final String SITE_LAST_NAME_REQUIRED						= "NHX924";			//OverDue Directlink - Site Contact Last Name is required.
	public static final String PHONE_INVALID_REQUIRED						= "NHX925";			//OverDue Directlink - Phone Number is required. Or has invalid characters.
	public static final String SELECT_RELEASE_EQUIPMENT 					= "NHX926";			//OverDue Directlink - Please select at least one item to release.
	public static final String PICKUP_LOCATION_REQUIRED						= "NHX927";			//OverDue Directlink - Pickup location required.
	public static final String PICKUP_DETAILS_REQUIRED						= "NHX928";			//OverDue Directlink - Pickup Details required.
	public static final String EXTEND_DATE_INVALID							= "NHX929";			//OverDue Directlink - Extend Date must be 1 year or less.
	// HES Error Constants, will use NHX950 onwards
	public static final String HES_LIGHT_PACKAGE_INVALID_COUNT				= "NHX950";		//OverDue Directlink - Pickup Details required.
	public static final String HES_LIGHT_PACKAGE_ITEM_INVALID_COUNT			= "DHX951";		//OverDue Directlink - Extend Date must be 1 year or less.
	
	//CRES Error Constants
	public static final String FCN_INVALID_CLASSIFICATION 					= "NHX951";
	public static final String FCN_DESC_REQUIRED 							= "NHX952";
	public static final String FCN_LEAD_TYPE_REQUIRED						= "NHX953";
	public static final String STATE_EMPTY_ERROR							= "NHX954";
	public static final String COUNTRY_EMPTY_ERROR							= "NHX955";
	public static final String ACCOUNT_INVALID_ERROR						= "NHX956";
	public static final String ZIP_INVALID_LENGTH							= "NHX957";
	public static final String JOB_ZIP_INVALID_LENGTH						= "NHX958";	
	public static final String FCN_INVALID_RA_NUMBER						= "NHX959";
	public static final String FCN_INVALID_IC_NUMBER						= "NHX960";
}






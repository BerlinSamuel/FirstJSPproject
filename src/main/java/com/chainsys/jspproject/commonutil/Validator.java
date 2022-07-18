package com.chainsys.jspproject.commonutil;

import java.io.InvalidClassException;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
	public static boolean checkStringForParseInt(String data) throws InvalidInputDataException {
		// TODO--This method is incomplete
		boolean result = false;
		int len = data.length();
		for (int index = 0; index < len; index++) {
			int asc = (int) data.charAt(index);
			if (asc > 47 && asc < 58)
				result = true;
			else
				throw new InvalidInputDataException("The value in String must contain only numbers");
		}

		// if data is invalid throw new InvalidInputDataException ("The value in String
		// must contain only numbers")
		return result;
	}

	
	public static boolean checkNumberForGreaterThanZero(int data) throws InvalidInputDataException {

		boolean result = false;
		if (data > 0) {
			result = true;
		} else {
			throw new InvalidInputDataException();
		}
		return result;
	}

	public static boolean checkNumberForGreaterThanZero(float data) throws InvalidInputDataException{
	           
		   return  checkNumberForGreaterThanZero((int)data);
	         
	          }

	public static boolean checklengthOfString(String data) throws InvalidInputDataException {
		boolean result = false;

		int len = data.length();
		if (len < 15 && len > 3)
			result = true;
		else
			throw new InvalidInputDataException("length does meet required length");
		return result;
	}

	public static boolean checkStringOnly(String data) throws InvalidInputDataException {
		boolean result = false;
		String UpperCaseData = data.toUpperCase();
		char array[] = UpperCaseData.toCharArray();
		int len = array.length;

		for (int index = 0; index < len; index++) {

			int asc = (int) array[index];
			if (asc < 91 && asc > 64 || asc == 32) {
				result = true;
			} else
				throw new InvalidInputDataException("Enter only Alphabet Letter");
		}
		return result;
	}

	public static void checkEmail(String data) throws InvalidInputDataException {
		boolean result = false;
		String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
		// Matching the given data number with regular expression
		Pattern patt = Pattern.compile(regex);
		Matcher match = patt.matcher(data);
		result = match.matches();
		if (!result) {
			throw new InvalidInputDataException();
		}

	}

	public static void checkJobId(String data) throws InvalidInputDataException {
		boolean result = false;
		String pattern = "^([a-zA-Z+_]+){3,18}$";

		Pattern patt = Pattern.compile(pattern);
		Matcher match = patt.matcher(data);
		result = match.matches();
		if (!result)
			throw new InvalidInputDataException("Give the job_id like IT_PROG this format");
	}

	public static boolean checkSalLimit(float data) throws InvalidInputDataException {

		boolean result = false;
		if (data < 15000)
			throw new InvalidInputDataException("Enter Amount above 15,000 ");
		else if (data > 100000)
			throw new InvalidInputDataException("Enter Amount less than 1,00,000");
		else if (data % 100 != 0)
			throw new InvalidInputDataException("Enter amount in multiples of  hundred ");
		else
			result = true;
		return result;
	}

	public static boolean checkDateFormat(String date) throws InvalidInputDataException {

		boolean result = false;
		String pattern = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/(20[0-2][0-2]|19[89][0-9])";

		Pattern patt = Pattern.compile(pattern);
		Matcher match = patt.matcher(date);
		result = match.matches();
		if (!result)
			throw new InvalidInputDataException("Give the year from 1984 to 2022");
		return result;
	}

	public static void checkPhoneNumer(String data) throws InvalidInputDataException {
		boolean result = false;
		String pattern = "^[0-9]{10}$";
		Pattern patt = Pattern.compile(pattern);
		Matcher match = patt.matcher(data);
		result = match.matches();
		if (!result)
			throw new InvalidInputDataException("please enter 10 digit ");
	}


		public static boolean checkStringForParseFloat(String data) throws InvalidInputDataException {
			// TODO--This method is incomplete
			boolean result = false;
			int len = data.length();
			for (int index = 0; index < len; index++) {
				int asc = (int) data.charAt(index);
				if (asc > 47 && asc < 58)
					result = true;
				else
					throw new InvalidInputDataException("The value in String must contain only numbers");
			}

			// if data is invalid throw new InvalidInputDataException ("The value in String
			// must contain only numbers")
			return result;
		}
		
	}

	



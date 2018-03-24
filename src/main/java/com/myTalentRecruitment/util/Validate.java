package com.myTalentRecruitment.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;

import com.myTalentRecruitment.db.User;
import com.myTalentRecruitment.db.UserRepository;
import com.myTalentRecruitment.model.UserModel;

public abstract class Validate {
	
    private static final String PATTERN = "([a-z]|[A-Z]|\\s)+";  
	
	public static boolean validUser(UserModel userIn) {
		
		boolean valid = false;
		
        Pattern pattern = Pattern.compile(PATTERN);
        
        Matcher matcherN = pattern.matcher(userIn.getName().trim());
        Matcher matcherLN1 = pattern.matcher(userIn.getLastName1().trim());
        Matcher matcherLN2 = pattern.matcher(userIn.getLastName2().trim());
        
        if(matcherN.matches() && matcherLN1.matches() && matcherLN2.matches())
        	valid = true;  		
		
		return valid;
	}
	
	

}

package com.myTalentRecruitment.service;

import java.util.List;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myTalentRecruitment.db.Suggestion;
import com.myTalentRecruitment.db.SuggestionRepository;
import com.myTalentRecruitment.db.User;
import com.myTalentRecruitment.db.UserRepository;
import com.myTalentRecruitment.model.SuggestionModel;
import com.myTalentRecruitment.model.UserModel;
import com.myTalentRecruitment.util.Conv;
import com.myTalentRecruitment.util.Validate;

@Service
public class SuggestionService {
	
	/***************************** Metodos relacionados con Suggestion ************************************/
	@Autowired
	SuggestionRepository suggestionRepository;
	
	public SuggestionModel createSuggestion (SuggestionModel suggestionIn) {

		UserModel userIn = new UserModel(suggestionIn.getUserName(), suggestionIn.getUserLastName1(),
								  	   	 suggestionIn.getUserLastName2(), suggestionIn.getUserEmail(),
								  	   	 suggestionIn.isUserWorker());	
		
		UserModel userOut = createUser(userIn);		
		
		Suggestion suggestionBd = new Suggestion(new Timestamp(new Date().getTime()) , userOut.getId());
		
		suggestionRepository.save(suggestionBd);
		
		SuggestionModel suggestionOut = new SuggestionModel(suggestionBd.getId(), suggestionBd.getDate(), userOut.getId());

		return suggestionOut;
	}	
	
	
	
	/***************************** Metodos relacionados con User *************************************************************/
	@Autowired
	UserRepository userRepository;

	public UserModel createUser (UserModel userIn) {

		UserModel userOut = new UserModel();
		String name = "", lastName1 ="", lastName2 ="", email="";	
		
		User existUser = findUserByEmail(userIn.getEmail());
		
		if(existUser.getId()==0) {	
			
			if(Validate.validUser(userIn)) {			
				try {	
					
					User userDb = new User();			
					name = Conv.encrypt(userIn.getName());
					lastName1 = Conv.encrypt(userIn.getLastName1());
					lastName2 = Conv.encrypt(userIn.getLastName2());
					email = Conv.encrypt(userIn.getEmail());

					userDb = new User(name, lastName1, lastName2, email, userIn.isWorker());		
					userRepository.save(userDb);
					userOut = new UserModel(userDb.getId(), userIn.getName(), userIn.getLastName1(), userIn.getLastName2(), userIn.getEmail(), userIn.isWorker());

				} catch (Exception e) {
					//throw new JuegaterapiaException("Error al insertar el usuario en la base de datos");
				}		
				
			} else {
				//throw new JuegaterapiaException("Los datos deben venir formados.");
			}
			

		} else {			
			userOut = new UserModel(existUser.getId(), Conv.decrypt(existUser.getName()),
									Conv.decrypt(existUser.getLastName1()), Conv.decrypt(existUser.getLastName2()),
									Conv.decrypt(existUser.getEmail()), existUser.isWorker());			
		}

		return userOut;
	}	
	
	
	public User findUserByEmail(String email) {	
		
		User user = new User();
		User userOut = new User();
		List<User> list = userRepository.findAll();
		
		if(!list.isEmpty()){	
			
			Iterator<User> itr = list.iterator();
			while(itr.hasNext()){
				user = itr.next();
				if( Conv.decrypt(user.getEmail()).equals(email) )
					userOut = user;					
			}			
		}
		
		return userOut;
	}


	public List<UserModel> findAllUsers () {

		List<User> list = userRepository.findAll();
		List<UserModel> listOut = new ArrayList<UserModel>();

		if(!list.isEmpty()){	

			User user = new User();
			UserModel userOut = new UserModel();
			String name = "", lastName1 ="", lastName2 ="", email="";
			long id;
			boolean worker = false;
			Iterator<User> itr = list.iterator();

			while(itr.hasNext()){
				user = itr.next();

				id = user.getId();
				name = Conv.decrypt(user.getName());
				lastName1 = Conv.decrypt(user.getLastName1());
				lastName2 = Conv.decrypt(user.getLastName2());
				email = Conv.decrypt(user.getEmail());
				worker = user.isWorker();

				userOut = new UserModel(id, name, lastName1, lastName2, email, worker);
				listOut.add(userOut);
			}
		}	

		return listOut;
	}
	

}

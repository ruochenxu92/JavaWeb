package us.web.formbean;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

public class RegisterForm {
	private String username;
	private String password;
	private String password2;
	private String email;
	private String birthday;
	private String nickname;
	private Map error = new HashMap();
	
	public Map getError() {
		return error;
	}
	public void setError(Map error) {
		this.error = error;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	//username cannot be null, should be 3-8 letter
	//password cannot be null, should be 3-8 number
	//assure password cannot be null, and should be same as fi
	//email cannot be null,
	//birthday cannot be null,
	//nickname cannot be null
	public boolean validate(){
		boolean isOK = true;
		if(username==null || username.trim().equals("")){
			isOK = false;
			error.put("username", "Username cannot be empty");
		}else{
			if(!this.username.matches("[A-Za-z]{3,8}")){
				isOK = false;
				error.put("username", "Username must be 3- 8 letter");
			}
		}
		
		if(password==null || password.trim().equals("")){
			isOK = false;
			error.put("password", "password cannot be empty");
		}else{
			if(!this.password.matches("[A-Za-z]{3,8}")){
				isOK = false;
				error.put("password", "Password must be 3- 8 letter");
			}
		}
		
		
		if(password2==null || password2.trim().equals("")){
			isOK = false;
			error.put("password2", "Password2 cannot be empty");
		}else{
			if(!this.password2.equals(password)){
				isOK = false;
				error.put("password2", "two password is not same");
			}
		}
		
		if(this.email==null || this.email.trim().equals("")){
			isOK = false;
			error.put("email", "email cannot be empty");
		}else{
			if(!this.email.matches("\\w+@\\w+(\\.\\w+)+")){
				isOK = false;
				error.put("email", "Email format is not correct");
			}
		}
		
		if(this.birthday!=null && this.birthday!=null){
			try{
				DateLocaleConverter dic = new DateLocaleConverter();
				dic.convert(birthday, "MM-dd-yyyy");
			}catch(Exception e){
				isOK = false;
				error.put("birthday", "Birthday format is not correct");
			}
		}
		
		if(this.nickname==null || this.nickname.trim().equals("")){
			isOK = false;
			error.put("nickname", "nickname cannot be empty");
		}
		return isOK;
	}
}

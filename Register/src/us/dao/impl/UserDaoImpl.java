package us.dao.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.dom4j.Document;
import org.dom4j.Element;

import us.dao.UserDao;
import us.domain.User;
import us.utils.XmlUtil;

public class UserDaoImpl implements UserDao {
	@Override
	public void add(User user){
		try{
		Document document = XmlUtil.getDocument();
		Element root = document.getRootElement();
		
		Element user_tag = root.addElement("user");
		user_tag.setAttributeValue("id", user.getId());
		user_tag.setAttributeValue("username", user.getUsername());
		user_tag.setAttributeValue("password", user.getPassword());
		user_tag.setAttributeValue("email", user.getEmail());
		user_tag.setAttributeValue("birthday", user.getBirthday()==null?"":user.getBirthday().toLocaleString());
		user_tag.setAttributeValue("nickname", user.getNickname());
		XmlUtil.write2Xml(document);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		
		
	}
	
	
	@Override
	public User find(String username, String password){
		try{
			Document document = XmlUtil.getDocument();
			Element e = (Element) document.selectSingleNode("//user[@username='"+username+"' and @password='"+password+"']");
			if(e == null){
				return null;//does not find
			}
			User user = new User();
			String date = e.attributeValue("birthday");
			if(date == null || date.equals("")){
				user.setBirthday(null);
			}else{
				Date d = new Date(date);
//				SimpleDateFormat df = new SimpleDateFormat("MM-dd-yyyy");
				user.setBirthday(d);
			}
			user.setEmail(e.attributeValue("email"));
			user.setId(e.attributeValue("id"));
			user.setNickname(e.attributeValue("nickname"));
			user.setPassword(e.attributeValue("password"));
			user.setUsername(e.attributeValue("username"));
			return user;
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public boolean find(String username){
		try{
			Document document = XmlUtil.getDocument();
			Element e = (Element) document.selectSingleNode("//user[@username='"+username+"']");
			if(e == null){
				return false;//does not find
			}
			
			return true;
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	
	
	
	
	
}

package us.UserDaoImpl;

import java.util.Date;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;

import us.UserDao.UserDao;
import us.Util.XmlWriter;
import us.domain.User;

public class UserDaoImpl implements UserDao {

	@Override
	public void add(User user) {
		try {
			Document document = XmlWriter.getDocument();
			Element root = document.getRootElement();

			Element user_tag = root.addElement("user");
			user_tag.setAttributeValue("id", user.getId());
			user_tag.setAttributeValue("username", user.getUsername());
			user_tag.setAttributeValue("password", user.getPassword());
			user_tag.setAttributeValue("email", user.getEmail());
			user_tag.setAttributeValue("birthday",user.getBirthday() == null ? "" : user.getBirthday().toLocaleString());
			user_tag.setAttributeValue("nickname", user.getNickname());
			
			XmlWriter.write2Xml(document);
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public User find(String username, String password) {
		Document document;
		try {
			document = XmlWriter.getDocument();
			Element e = (Element) document.selectSingleNode("//user[@username='"+ username + "' and @password='" + password + "']");
			if (e == null) {
				return null;
			}
			User user = new User();

			String date = e.attributeValue("birthday");
			if (date == null || date.trim().equals("")) {
				user.setBirthday(null);
			} else {
				Date d = new Date(date);
				user.setBirthday(d);
			}
			user.setId(e.attributeValue("id"));
			user.setEmail(e.attributeValue("email"));
			user.setNickname(e.attributeValue("nickname"));
			user.setPassword(e.attributeValue("password"));
			user.setUsername(e.attributeValue("username"));
			return user;
		} catch (DocumentException e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	public boolean find(String username) {
		Document document;
		try {
			document = XmlWriter.getDocument();
			Element e = (Element) document.selectSingleNode("//user[@username='"
					+ username + "']");
			if (e == null) {
				return false;
			}
			return true;
		} catch (DocumentException e) {
			throw new RuntimeException(e);
		}

	}

}

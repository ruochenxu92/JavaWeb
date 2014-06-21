package cn.itcast.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import org.dom4j.Document;
import org.dom4j.Element;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;
import cn.itcast.utils.XmlUtils;

public class UserDaoXmlImpl implements UserDao {

	public User find(String username,String password){
		
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		User user = new User();
		
		try{
//			Document document = XmlUtils.getDocument();
//			Element e = (Element) document.selectSingleNode("//user[@username='"+username+"' and @password='"+password+"']");
//			if(e==null){
//				return null;
//			}
//			User user = new User();
//			user.setId(e.attributeValue("id"));
//			user.setEmail(e.attributeValue("email"));
//			user.setPassword(e.attributeValue("password"));
//			user.setUsername(e.attributeValue("username"));
//			String birth = e.attributeValue("birthday");
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//			user.setBirthday(sdf.parse(birth));
//			
//			return user;
			conn = cn.itcast.utils.JdbcUtils.getConnection();
			st = conn.createStatement();
			String sql = "select id,name,password,email,birthday from users where name='"+username+"' and password='"+password+"'";
			rs = st.executeQuery(sql);
			
			while(rs.next()){
				user.setId(rs.getString("id"));
				user.setUsername(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setBirthday(rs.getDate("birthday"));
			}
		}catch (Exception e) {
			throw new RuntimeException(e);
		}finally{
			cn.itcast.utils.JdbcUtils.release(conn, st, rs);
		}
		return user;
	}
	
	public void add(User user){
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		
		try{
//			Document document = XmlUtils.getDocument();
//			Element root = document.getRootElement();
//		
//			Element user_node = root.addElement("user");  //����user��㣬���ҵ�root
//			user_node.setAttributeValue("id", user.getId());
//			user_node.setAttributeValue("username", user.getUsername());
//			user_node.setAttributeValue("password", user.getPassword());
//			user_node.setAttributeValue("email", user.getEmail());
//			user_node.setAttributeValue("birthday", user.getBirthday().toLocaleString());
//		
//			XmlUtils.write2Xml(document);
			conn = cn.itcast.utils.JdbcUtils.getConnection();
			st = conn.createStatement();
			String sql = "insert into users (id,name,password,email) values('"+user.getId()+"','"+user.getUsername()+"','"+user.getPassword()+"','"+user.getEmail()+"')";
			st.executeUpdate(sql);
			
		}catch (Exception e) {
			throw new RuntimeException(e);
		}finally{
			cn.itcast.utils.JdbcUtils.release(conn, st, rs);
		}
		
	}
	
	public User find(String username){
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		User user = new User();
		try{
			conn = cn.itcast.utils.JdbcUtils.getConnection();
			st = conn.createStatement();
			String sql = "select id,name,password,email,birthday from users where name='"+username+"'";
			System.out.println(sql);
			rs = st.executeQuery(sql);
			while(rs.next()){
				user.setId(rs.getString("id"));
				user.setUsername(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setBirthday(rs.getDate("birthday"));
			}
			
//			Document document = XmlUtils.getDocument();
//			Element e = (Element) document.selectSingleNode("//user[@username='"+username+"']");
//			if(e==null){
//				return null;
//			}
//			User user = new User();
//			user.setId(e.attributeValue("id"));
//			user.setEmail(e.attributeValue("email"));
//			user.setPassword(e.attributeValue("password"));
//			user.setUsername(e.attributeValue("username"));
//			String birth = e.attributeValue("birthday");
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//			user.setBirthday(sdf.parse(birth));
//			
//			return user;
		
		}catch (Exception e) {
			throw new RuntimeException(e);
		}finally{
			cn.itcast.utils.JdbcUtils.release(conn,st, rs);
		}
		return user;
	}
	
	
}

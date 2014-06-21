package demo;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.KeyedHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

public class Demo2 {
	@Test
	public void testArrayHandler1() throws SQLException{
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "select * from user";
		Object result[] = (Object[]) qr.query(sql, new ArrayHandler());
		System.out.println(Arrays.asList(result));  //list  toString()
	}
		
	@Test
	public void testArrayListHandler1() throws SQLException{
		
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "select * from user";
		List<Object[]> list = (List) qr.query(sql, new ArrayListHandler());
		for(Object[] o : list){
			System.out.println(Arrays.asList(o));
		}
	}
	
	@Test
	public void testArrayListHandler() throws SQLException {
		 QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		 String sql = "select * from user";
		 List<Object[]> list = (List<Object[]>) qr.query(sql, new ArrayListHandler());	 
		 for(Object[] o : list){
			System.out.println(Arrays.asList(o));
		 }
	}
	
	@Test
	public void testColumnListHandler1() throws SQLException{
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "select * from user";
		
		List list = (List) qr.query(sql, new ColumnListHandler("id"));
		System.out.println(list);
	}

	//useful
	@Test
	public void testColumnListHandler() throws SQLException  {
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "select * from user";
		Object result = qr.query(sql, new ColumnListHandler("birthday"));
		System.out.println(result);
	}
	
	
	
	
	
	
	
	@Test
	public void testKeyedHandler1() throws Exception{
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "select * from user";
		
		Map<Integer,Map> map = (Map) qr.query(sql, new KeyedHandler("id"));
		for(Map.Entry<Integer, Map> me : map.entrySet()){
			int  id = me.getKey();
			Map<String,Object> innermap = me.getValue();
			for(Map.Entry<String, Object> innerme : innermap.entrySet()){
				String columnName = innerme.getKey();
				Object value = innerme.getValue();
				System.out.println(columnName + "=" + value);
			}
			System.out.println("----------------");
		}
	}
	
	@Test
	public void testKeyedHandler() throws SQLException{
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "select * from user";
		
		Map<Integer,Map> map = (Map<Integer, Map>) qr.query(sql, new KeyedHandler());
		for(Map.Entry<Integer, Map> me: map.entrySet()){
			
			Map<Integer, Object> innermap = me.getValue();
			
			for(Map.Entry<Integer, Object >  entry  :  innermap.entrySet()){
				System.out.println(entry.getKey()+"="+ entry.getValue());
			}
			System.out.println("------------------");
		}
		
	}
	
	
	
	
	
	
	@Test
	public void testMapHandler() throws SQLException{
		
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "select * from user";
		
		Map<String,Object> map = (Map) qr.query(sql, new MapHandler());
		for(Map.Entry<String, Object> me : map.entrySet())
		{
			System.out.println(me.getKey() + "=" + me.getValue());
		}
	}
	
	
	
	@Test
	public void testMapHandler1() throws SQLException {
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "select * from user";
		
		Map<String, Object> map = (Map) qr.query(sql, new MapHandler());
		for(Map.Entry<String, Object>   me: map.entrySet()){
			System.out.println(me.getKey() + "=" +me.getValue());
		}
	}
	
	
	
	
	@Test
	public void testMapListHandler1() throws SQLException{
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "select * from user";
		
		List<Map>list = (List) qr.query(sql, new MapListHandler());
		
		for(Map<String, Object>  map : list){
			for(Map.Entry<String, Object> 	me : map.entrySet()){
				System.out.println(me.getKey() +"  =   " +me.getValue());
			}
			
			System.out.println("----------one map has the following information------");
			
		}
		
	}
	
	
	
	
	@Test
	public void testScalarHandler() throws SQLException {
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "select count(*) from user";
		int  column  = (  (Long)  qr.query(sql, new ScalarHandler(1))    ).intValue();
		System.out.println(column);
	}
	
	
	
	


	//java.lang.ClassCastException: java.lang.Long
	@Test
	public void testScalarHandler1() throws SQLException{
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "select count(*) from user";  //[13]  list[13]
		/*long l = (Long) qr.query(sql, new ScalarHandler(1));
		int count = (int) l;*/
		//int count = Integer.parseInt(qr.query(sql, new ScalarHandler(1)).toString());
		
		int count = (   (Long)qr.query(sql, new ScalarHandler(1))  ).intValue();
		System.out.println(count);
	}
	
	
	
	
	
	
	
	
	
}

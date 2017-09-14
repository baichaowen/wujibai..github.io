import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;


public class test {

	@Test
	public void test() {
	String resource="mybatis-config.xml";
	try {
		InputStream is=Resources.getResourceAsStream(resource);
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
		SqlSession sqlsession=null;
		int count=0;
		sqlsession=factory.openSession();
		count=sqlsession.selectOne("");
		
		sqlsession.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}

}

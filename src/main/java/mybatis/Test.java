package mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class Test {
    public static void main(String[] args) {
        try {
            //读取配置文件
            InputStream is = Resources.getResourceAsStream("src/main/resources/mybatis-config.xml");
            //初始化mybatis，创建SqlSessionFactory类实例
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            //创建Session实例
            SqlSession sqlSession = sqlSessionFactory.openSession();
            Student student = new Student("201731770001", "周世昌", "男", "电子与计算机工程");
            //插入数据
            sqlSession.insert("insertStudent", student);
            //提交事务
            sqlSession.commit();
            //关闭Session
            sqlSession.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

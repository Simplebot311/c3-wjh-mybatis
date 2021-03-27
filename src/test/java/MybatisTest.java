import com.csa.dao.AccountDao;
import com.csa.dao.StudentDao;
import com.csa.domain.Account;
import com.csa.domain.Student;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.sql.Date;
import java.util.List;

/**
 * @author yufeng1900
 * @create 2021-03-25 8:36
 */
public class MybatisTest {
    public static void main(String[] args) throws Exception{
        //1.读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlmapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //3.使用工厂生产SqlSession对象
        SqlSession session = factory.openSession();
        //4.使用SqlSession创建Dao接口的代理对象
        StudentDao studentDao = session.getMapper(StudentDao.class);
        //5.使用代理对象执行方法
        List<Student> students = studentDao.findAll();
        for (Student student:students){
            System.out.println(student);
        }
        //6.释放资源
        session.close();
        in.close();
        //
    }

    @Test
    public void insertTest() throws Exception{
        //1.读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlmapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //3.使用工厂生产SqlSession对象
        SqlSession session = factory.openSession();
        //4.使用SqlSession创建Dao接口的代理对象
        AccountDao accountDao = session.getMapper(AccountDao.class);

        accountDao.insert(new Account("1","jack",1000,new Date(2021,3,10),new Date(2021,3,19)));

        List<Account> accounts = accountDao.findAll();
        for (Account account:accounts){
            System.out.println(account);
        }

        in.close();
        session.close();
    }
}

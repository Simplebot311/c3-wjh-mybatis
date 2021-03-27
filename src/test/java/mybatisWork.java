import com.csa.dao.AccountDao;
import com.csa.domain.Account;
import com.csa.domain.AccountService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.sql.Date;
import java.util.List;

/**
 * @author yufeng1900
 * @create 2021-03-27 12:03
 */
public class mybatisWork {
    public static void main(String[] args) throws Exception{
        //1.读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlmapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //3.使用工厂生产SqlSession对象
        SqlSession session = factory.openSession();
        //4.使用SqlSession创建Dao接口的代理对象
        AccountService accountService = new AccountService(session.getMapper(AccountDao.class));

        //第一题
        accountService.insert(new Account("1","jack",1000,new Date(2021,3,10),new Date(2021,3,19)));
        accountService.insert(new Account("2","tom",500,new Date(2021,3,10),new Date(2021,3,21)));
        accountService.insert(new Account("3","micky",800,new Date(2021,3,10),new Date(2021,3,21)));



        //第二题
        accountService.transfer("1","2",500);


        session.commit();


        List<Account> accounts = accountService.findAll();
        for (Account account:accounts){
            System.out.println(account);
        }

        in.close();
        session.close();
    }
}

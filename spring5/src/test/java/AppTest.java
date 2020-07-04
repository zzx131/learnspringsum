import com.zzx.entity.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppTest {
    @Test
    public void testBean(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        User user = applicationContext.getBean(User.class);
        user.add();
        System.out.println(user.getUname());
    }
}

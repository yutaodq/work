package zy.cy6.dqyt.zygl.trade;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest

/*
 *spring boot 1.4.0 版本之前使用以下三个配置
 *@RunWith(SpringJUnit4ClassRunner.class)
 *@SpringApplicationConfiguration(classes = DemoApplication.class)  
 *在spring boot 1.4.0 版本之后取消�? 
 *classes�?要指定spring boot 的启动类如：DemoApplication.class 不然WebApplicationContext不被实例�?
 * @WebAppConfiguration
*/


public class TradeAppTest {
	@Test
	public void contextLoads() {
	}

}

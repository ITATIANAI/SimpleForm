import java.sql.Timestamp;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.impl.FunctionParamDaoImpl;
import data.FunctionParameter;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring-context.xml");
		FunctionParamDaoImpl impl = (FunctionParamDaoImpl) context.getBean("funcParamDaoImpl");

		System.out.println("------Records Creation--------");
		FunctionParameter param1 = new FunctionParameter();
		param1.setName("Param1");
		param1.setDescription("Description of param1");
		param1.setCtime(new Timestamp(System.currentTimeMillis()));
		impl.save(param1);

		FunctionParameter param2 = new FunctionParameter();
		param2.setName("Param2");
		param2.setDescription("Description of param2");
		param2.setCtime(new Timestamp(System.currentTimeMillis()));
		impl.save(param2);

		System.out.println("------Listing Multiple Records--------");
		List<FunctionParameter> list = impl.getAll();

		for (FunctionParameter functionParameter : list) {
			System.out.print("ID : " + functionParameter.getId());
			System.out.print(", Name : " + functionParameter.getName());
			System.out.println(", Description : " + functionParameter.getDescription());
		}

		System.out.println("----Updating Record with ID = 1 -----");
		param1.setName("param0");
		impl.update(param1);

		System.out.println("----Listing Record with ID = 2 -----");
		FunctionParameter param3 = impl.find(new Long(2));
		System.out.print("ID : " + param3.getId());
		System.out.print(", Name : " + param3.getName());
		System.out.println(", Age : " + param3.getDescription());

		((ConfigurableApplicationContext) context).close();

	}

}

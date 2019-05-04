package cn.edu.zucc.graduationproject;
import cn.edu.zucc.graduationproject.util.ElmUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories
public class GraduationprojectApplication {
	private static Logger logger= LoggerFactory.getLogger(GraduationprojectApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(GraduationprojectApplication.class, args);
		logger.info("--------------------项目启动完成----------------------");
	}

}

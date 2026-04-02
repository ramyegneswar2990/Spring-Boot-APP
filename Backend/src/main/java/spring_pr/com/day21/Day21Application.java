package spring_pr.com.day21;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import org.springframework.stereotype.Component;

import spring_pr.com.day21.config.Car;

@SpringBootApplication
public class Day21Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Day21Application.class, args);
		// PaymentService paymentService =
		// context.getBean("creditCardPaymentService",PaymentService.class);
		// paymentService.processPayment(100.0);
		// }
		// ApplicationProperties properties =
		// context.getBean(ApplicationProperties.class);
		// System.out.println("Application Name: " + properties.getAppName());
		Car c1 = context.getBean(Car.class);
		c1.drive();
	}

}

@Component
@data
class ApplicationProperties {
	@Value("${app.name}")
	private String appName;

	public String getAppName() {
		return appName;
	}
}

// @Component
// interface PaymentService{
// public void processPayment(double amount);

// }
// @Component
// class CreditCardPaymentService implements PaymentService{
// @Override
// public void processPayment(double amount) {
// System.out.println("Processing credit card payment of " + amount);
// }
// }
// @Component
// class UpipaymentService implements PaymentService{
// @Override
// public void processPayment(double amount) {
// System.out.println("Processing UPI payment of " + amount);
// }
// }

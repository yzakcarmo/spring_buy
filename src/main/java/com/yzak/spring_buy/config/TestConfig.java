package com.yzak.spring_buy.config;

import com.yzak.spring_buy.entities.*;
import com.yzak.spring_buy.entities.enums.OrderStatus;
import com.yzak.spring_buy.entities.enums.UserRole;
import com.yzak.spring_buy.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private MarketRepository marketRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public void run(String... args) throws Exception {

        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        p1.getCategories().add(cat2);
        p2.getCategories().add(cat1);
        p2.getCategories().add(cat3);
        p3.getCategories().add(cat3);
        p4.getCategories().add(cat3);
        p5.getCategories().add(cat2);
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));


        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456", UserRole.CUSTOMER);
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456", UserRole.CUSTOMER);
        User u3 = new User(null, "Assai", "assai@market.com", "34322856474", "45361712",UserRole.MARKET);
        userRepository.saveAll(Arrays.asList(u1,u2,u3));

        Customer c1 = new Customer(null, u1, LocalDate.parse("1998-08-20"));
        Customer c2 = new Customer(null, u2, LocalDate.parse("1997-08-20"));
        customerRepository.saveAll(Arrays.asList(c1,c2));

        Market m1 = new Market(null, u3);
        marketRepository.save(m1);

        u1.setCustomer(c1);
        u2.setCustomer(c2);
        u3.setMarket(m1);
        userRepository.saveAll(Arrays.asList(u1, u2,u3));

        Address a1 = new Address(null,m1,38400, "rua", 1, "Casa", "Bairro", "testelandia", "Testestate");
        Address a2 = new Address(null, c1, 38400, "Testestreet", 1, "Casa", "Bairro", "testelandia", "Testestate");
        addressRepository.saveAll(Arrays.asList(a1,a2));

        c1.getAddresses().add(a2);
        customerRepository.save(c1);

        m1.setAddress(a1);
        marketRepository.save(m1);

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, c1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, c2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, c1);
        orderRepository.saveAll(Arrays.asList(o1,o2,o3));

        OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
        OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
        OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
        OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());
        orderItemRepository.saveAll(Arrays.asList(oi1,oi2,oi3,oi4));

        Payment pay1 = new Payment(null, Instant.parse("2019-06-20T21:53:07Z"), o1);
        o1.setPayment(pay1);

        orderRepository.save(o1);
    }
}

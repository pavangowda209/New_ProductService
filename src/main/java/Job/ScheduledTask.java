package Job;

import com.E_Commerce.first_spring.Models.Product;
import com.E_Commerce.first_spring.Repository.ProductRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public class ScheduledTask {
    private ProductRepository productRepository;

    public ScheduledTask(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Scheduled(cron = "0 0 * * *")
    public void getschedule() {
        Optional<Product>product = productRepository.findById(1);
        if(product.isPresent()) {
            System.out.println("get product with id" + product.get().getId());
        }
    }

}

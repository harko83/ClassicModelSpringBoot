package utilsTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public abstract class BaseTest {

	
	@BeforeEach
	private void setup() {
		MockitoAnnotations.initMocks(this);
		this.beforeEach();
	}
	
	protected void beforeEach() {}
}

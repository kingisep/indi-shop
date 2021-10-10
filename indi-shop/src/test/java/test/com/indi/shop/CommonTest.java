package test.com.indi.shop;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.indi.shop.IndiShopApplication;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = IndiShopApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ActiveProfiles("junit")
public abstract class CommonTest<Y> {

    @Value("${server.servlet.context-path}")
    public String applicationContext;

    protected HttpHeaders headers = new HttpHeaders();
    protected TestRestTemplate restTemplate = new TestRestTemplate();

    @LocalServerPort
    protected int randomServerPort;

    @Autowired
    protected WebApplicationContext webApplicationContext;

    protected MockMvc mvc;

    @BeforeAll
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    protected String createURLWithPort(String uri) {
        return "http://localhost:" + randomServerPort + applicationContext + uri;
    }

}

package zy.cy6.dqyt.zygl.webui.controller;
/*
 * spring-boot-starter-hateoas官方项目上案例 bookmarks
 */
import static zy.cy6.dqyt.zygl.webui.resource.ProductResource.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import zy.cy6.dqyt.zygl.query.product.ProductEntry;
import zy.cy6.dqyt.zygl.query.product.repositories.ProductQueryRepository;
import zy.cy6.dqyt.zygl.webui.ZyglApp;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ZyglApp.class)
//@WebAppConfiguration

public class ProductControllerTest {

	public static final String JLA_IDENTIFIER = "JLA";
	public static final String JLA_NAME = "JLA_NAME";
	public static final String JLA_MODEL = "JLA_MODEL";
	public static final String JLA_SIZE = "JLA_SIZE";
	public static final String JLA_UNIT = "JLA_UNIT";

	public static final String JLB_IDENTIFIER = "JLB";
	public static final String JLB_NAME = "JLB_NAME";
	public static final String JLB_MODEL = "JLB_MODEL";
	public static final String JLB_SIZE = "JLB_SIZE";
	public static final String JLB_UNIT = "JLB_UNIT";

	private MediaType contentType = new MediaType("application", "hal+json", Charset.forName("UTF-8"));;

	private MockMvc mockMvc;

	private String userName = "bdussault";

	private HttpMessageConverter mappingJackson2HttpMessageConverter;

	private ProductEntry productEntry;

	private List<ProductEntry> productList = new ArrayList<>();

	@Autowired
	private ProductQueryRepository productQueryRepository;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Autowired
	void setConverters(HttpMessageConverter<?>[] converters) {

		this.mappingJackson2HttpMessageConverter = Arrays.asList(converters).stream()
				.filter(hmc -> hmc instanceof MappingJackson2HttpMessageConverter).findAny().orElse(null);

		assertNotNull("the JSON message converter must not be null", this.mappingJackson2HttpMessageConverter);
	}

	@Before
	public void setup() throws Exception {
		ProductEntry productEntryA = new ProductEntry.Builder().identifier(JLA_IDENTIFIER).name(JLA_NAME)
				.model(JLA_MODEL).size(JLA_SIZE).unit(JLA_UNIT).build();
		ProductEntry productEntryB = new ProductEntry.Builder().identifier(JLB_IDENTIFIER).name(JLB_NAME)
				.model(JLB_MODEL).size(JLB_SIZE).unit(JLB_UNIT).build();

		this.mockMvc = webAppContextSetup(webApplicationContext).build();

		this.productQueryRepository.deleteAllInBatch();
		this.productList.add(productQueryRepository.save(productEntryA));
		this.productList.add(productQueryRepository.save(productEntryB));

	}

	@Test
	public void testGetProductes() throws Exception {
		mockMvc.perform(get(PRODUCTS_PATH)).andExpect(status().isOk()).andExpect(content().contentType(contentType))
				.andExpect(jsonPath("$._embedded.productEntries", hasSize(2)))
				.andExpect(jsonPath("$._embedded.productEntries[0].name", is(JLA_NAME)))
		.andExpect(jsonPath("$._embedded.productEntries[1].name", is(JLB_NAME)));

	}
	
//    @Test
//    public void readSingleBookmark() throws Exception {
//        mockMvc.perform(get("/" + userName + "/bookmarks/"
//                + this.bookmarkList.get(0).getId()))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(contentType))
//                .andExpect(jsonPath("$.bookmark.id", is(this.bookmarkList.get(0).getId().intValue())))
//                .andExpect(jsonPath("$.bookmark.uri", is("http://bookmark.com/1/" + userName)))
//                .andExpect(jsonPath("$.bookmark.description", is("A description")))
//                .andExpect(jsonPath("$._links.self.href", containsString("/" + userName + "/bookmarks/"
//                        + this.bookmarkList.get(0).getId())));
//    }

    @Test
    public void testGetProduct() throws Exception {
        mockMvc.perform(get("/products/"
                + this.productList.get(0).getIdentifier()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
				.andExpect(jsonPath("$.name", is(JLA_NAME)));
//
//                .andExpect(jsonPath("$.bookmark.id", is(this.bookmarkList.get(0).getId().intValue())))
//                .andExpect(jsonPath("$.bookmark.uri", is("http://bookmark.com/1/" + userName)))
//                .andExpect(jsonPath("$.bookmark.description", is("A description")))
//                .andExpect(jsonPath("$._links.self.href", containsString("/" + userName + "/bookmarks/"
//                        + this.bookmarkList.get(0).getId())));
    }

}

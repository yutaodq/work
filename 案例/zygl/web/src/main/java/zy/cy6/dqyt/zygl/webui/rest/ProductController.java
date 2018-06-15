///*
// * Copyright (c) 2016. Axon Framework
// *
// * Licensed under the Apache License, Version 2.0 (the "License");
// * you may not use this file except in compliance with the License.
// * You may obtain a copy of the License at
// *
// *     http://www.apache.org/licenses/LICENSE-2.0
// *
// * Unless required by applicable law or agreed to in writing, software
// * distributed under the License is distributed on an "AS IS" BASIS,
// * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// * See the License for the specific language governing permissions and
// * limitations under the License.
// */
//
//package zy.cy6.dqyt.zygl.webui.rest;
//
//import org.axonframework.commandhandling.CommandBus;
//import org.axonframework.commandhandling.GenericCommandMessage;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.rest.webmvc.RepositoryRestController;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import zy.cy6.dqyt.zygl.api.product.CreateProductCommand;
//import zy.cy6.dqyt.zygl.api.product.ProductId;
//import zy.cy6.dqyt.zygl.api.product.ProductName;
//import zy.cy6.dqyt.zygl.query.product.ProductEntry;
//import zy.cy6.dqyt.zygl.query.product.repositories.ProductQueryRepository;
//import zy.cy6.dqyt.zygl.query.users.UserEntry;
//import zy.cy6.dqyt.zygl.query.users.repositories.UserQueryRepository;
//
//import java.io.IOException;
//import java.util.List;
//import java.util.Optional;
//
//import javax.servlet.http.HttpServletResponse;
//
//@RestController
//
//@RequestMapping("/zygl")
//public class ProductController {
//	private final Logger log = LoggerFactory.getLogger(ProductController.class);
//
//	private final ProductQueryRepository productRepository;
//	private final UserQueryRepository userRepository;
//	
//
//	
//	@Autowired
//	public ProductController(CommandBus commandBus, ProductQueryRepository productRepository, UserQueryRepository userRepository) {
//		this.productRepository = productRepository;
//		this.userRepository = userRepository;
//
//	}
//	
//
//		@GetMapping("/prod")
//		public List<ProductEntry> restAdapter(){
//			log.info("restAdapterrestAdapterrestAdapterrestAdapter");
//
//			List<ProductEntry> products = (List<ProductEntry>) productRepository.findAll();
//					return  products;
//	    }
//		
//	
//}

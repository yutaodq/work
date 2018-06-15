package zy.cy6.dqyt.zygl.query.product;

import javax.persistence.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.hateoas.core.Relation;

import lombok.Getter;
import lombok.Setter;


/*
 *  ProductEntry productEntry = new ProductEntry.Builder().identifier("Mountain").name("aa").build();
 *  
Hibernate 各种主键生成策略详解 
1、assigned 、 主键由外部程序负责生成，在 save() 之前必须指定一个。
Hibernate 不负责维护主键生成。
与 Hibernate 和底层数据库都无关，可以跨数据库。
在存储对象前，必须要使用主键的 setter 方法给主键赋值，至于这个值怎么生成，完全由自己决定，这种方法应该尽量避免。
注释方式  :
         @Id 
         @GeneratedValue(generator = "ud") 
         @GenericGenerator(name = "ud", strategy = "assigned") 
“ud”是自定义的策略名，人为起的名字，后面均用“ud”表示。
特点：可以跨数据库，人为控制主键生成 应尽量避免。
主键生成， 特点：可以跨数据库，人为控制主键生成，应尽量避免。
 */
@Entity
@Getter
@Setter
//@Relation(value = "product", collectionRelation = "products")

public class ProductEntry {

	@Id
	@javax.persistence.Id
	
	private String identifier;
	private String name;
	private String model;
	private String size;
	private String unit;

	public ProductEntry() {
	}


	public static class Builder {
		private String identifier = "";
		private String name = "";
		private String model = "";
		private String size = "";
		private String unit = "";

		public Builder identifier(String identifier) {
			this.identifier = identifier;
			return this;
		}

		public Builder name(String name) {
			this.name = name;
			return this;
		}

		public Builder model(String model) {
			this.model = model;
			return this;
		}

		public Builder size(String size) {
			this.size = size;
			return this;
		}

		public Builder unit(String unit) {
			this.unit = unit;
			return this;
		}

		public ProductEntry build() {
			/*
			 * 在存储对象前，必须要使用主键的 setter 方法给主 键赋值
			 */
			ProductEntry product = new ProductEntry();
			product.setIdentifier(this.identifier);
			product.setName(name);
			product.setModel(model);
			product.setSize(size);
			product.setUnit(unit);
			return product;
		}

	}


}

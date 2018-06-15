package zy.cy6.dqyt.zygl.api.product;

import static com.google.common.base.Preconditions.checkNotNull;

import org.springframework.stereotype.Component;

import lombok.Getter;


@Getter
public final class CreateProductCommand {
	private ProductId productId;
	private ProductName productName;

	private CreateProductCommand() {
	}

	private CreateProductCommand(ProductId productId, ProductName productName) {
		this.productId = checkNotNull(productId, "没有工具标识符！");
		this.productName = checkNotNull(productName, "没有工具名称！");

	}

	public static CreateProductCommand create(ProductId productId, ProductName productName) {
		return new CreateProductCommand(productId, productName);
	}

}

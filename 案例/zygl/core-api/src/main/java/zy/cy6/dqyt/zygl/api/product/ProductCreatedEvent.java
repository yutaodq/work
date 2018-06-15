package zy.cy6.dqyt.zygl.api.product;

import static com.google.common.base.Preconditions.checkNotNull;

import lombok.Getter;

@Getter
public final class ProductCreatedEvent {
	private ProductId productId;
	private ProductName productName;

	private ProductCreatedEvent() {
	}

	private ProductCreatedEvent(ProductId productId, ProductName productName) {
		this.productId = checkNotNull(productId, "没有工具标识符！");
		this.productName = checkNotNull(productName, "没有工具名称！");

	}

	public static ProductCreatedEvent create(ProductId productId, ProductName productName) {
		return new ProductCreatedEvent(productId, productName);
	}

}

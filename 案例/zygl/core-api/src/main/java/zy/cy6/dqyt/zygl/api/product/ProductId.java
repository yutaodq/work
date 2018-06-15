package zy.cy6.dqyt.zygl.api.product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.MoreObjects;

import zy.cy6.dqyt.common.domain.AbstractIdentifier;
import zy.cy6.dqyt.common.domain.Identifier;


public final class ProductId extends AbstractIdentifier {
	private static final long serialVersionUID = 7650632965590448166L;
	private Logger log = LoggerFactory.getLogger(ProductId.class);

	private ProductId() {
		super();
		log.info("创建工具标识");
	}

	private ProductId(String identifier) {
		super(identifier);
	}

	public static Identifier create() {
		return new ProductId();
	}

	public static Identifier create(String identifier) {
		return new ProductId(identifier);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		return MoreObjects.toStringHelper(this).omitNullValues().add("工具标识", identifier()).toString();
	}



}

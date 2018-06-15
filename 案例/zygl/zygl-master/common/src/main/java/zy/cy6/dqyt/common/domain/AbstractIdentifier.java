package zy.cy6.dqyt.common.domain;


import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;

import org.axonframework.common.IdentifierFactory;

import lombok.EqualsAndHashCode;


@EqualsAndHashCode
public abstract class AbstractIdentifier implements Identifier,Serializable{
	private static final long serialVersionUID = 1L;
	
	private final String identifier;

	public AbstractIdentifier(){
		this(IdentifierFactory.getInstance().generateIdentifier());
	}
	
	public AbstractIdentifier(String identifier){
        this.identifier = checkNotNull(identifier, "identifier不能是null！");
		checkArgument(!identifier.trim().isEmpty(), "标识不能为空！");

	}
	

    @Override
	public String identifier() {
		return identifier;
	}

}

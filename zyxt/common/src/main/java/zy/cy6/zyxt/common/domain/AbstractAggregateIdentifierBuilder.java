package zy.cy6.zyxt.common.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter

public abstract class AbstractAggregateIdentifierBuilder {
  private String identifier = UUID.randomUUID().toString();

//  abstract AbstractAggregateIdentifierBuilder identifier(String identifier);
//  abstract AbstractAggregateIdentifierBuilder build();

}

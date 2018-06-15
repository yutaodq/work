package zy.cy6.zyxt.api.order;
import org.axonframework.common.IdentifierFactory;

public class OrderId {

    protected final String identifier;


    private OrderId(String identifier) {
        if (identifier.isEmpty()) {

        }
        this.identifier = identifier;
    }

    public static OrderId OrderId(){
        return new OrderId(IdentifierFactory.getInstance().generateIdentifier());
    }
    public static OrderId OrderId(String id){
        return new OrderId(id);
    }

}

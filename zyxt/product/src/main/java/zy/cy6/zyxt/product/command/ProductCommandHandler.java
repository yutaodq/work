package zy.cy6.zyxt.product.command;

import org.axonframework.commandhandling.model.Repository;
import org.axonframework.eventsourcing.eventstore.EventStore;

public class ProductCommandHandler {

    private Repository<Product> repository;
    private EventStore eventStore;

    public ProductCommandHandler(Repository<Product> repository, EventStore eventStore) {
        this.repository = repository;
        this.eventStore = eventStore;
    }

}

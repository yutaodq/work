package zy.cy6.zyxt.web.product.impl;

/*
 *参见 spring官方案例 spring-hateoas-examples
 */

import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandBus;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import zy.cy6.zyxt.api.product.kufang.CreateKufangCommand;
import zy.cy6.zyxt.api.product.kufang.KufangId;
import zy.cy6.zyxt.api.product.kufang.KufangName;
import zy.cy6.zyxt.query.product.KufangEntity;
import zy.cy6.zyxt.query.product.repositories.KufangQueryRepository;
import zy.cy6.zyxt.web.product.KufangResourceAssembler;
import zy.cy6.zyxt.web.product.KufangService;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class KufangServiceImpl implements KufangService {
    private final KufangQueryRepository repository;
    private final KufangResourceAssembler assembler;
    private CommandBus commandBus;
    private final CommandGateway commandGateway;

    @Autowired
    public KufangServiceImpl(CommandGateway commandGateway, CommandBus commandBus, KufangQueryRepository repository, KufangResourceAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
        this.commandBus = commandBus;
        this.commandGateway = commandGateway;
    }

    public Optional<KufangEntity> findKufangName(String name, String gg, String xh) {
        return repository.findByName(name);
    }

    public List<KufangEntity> findAllKufang() {
        log.info("所有的工具记录");
        return repository.findAll();
    }

    /*参见 EmployeeController.java
     * D:\yutao\源代码\spring-hateoas-examples\hypermedia\src\main\java\org\springframework\hateoas\examples\EmployeeController.java
     */
    //  @GetMapping(value = "/kufangs", produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<Resources<Resource<KufangEntity>>> findAll() {
        return ResponseEntity.ok(assembler.toResources(repository.findAll()));
    }

    public ResponseEntity<Resource<KufangEntity>> findOne(Long id) {
        return repository.findById(id).map(assembler::toResource).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Resource<KufangEntity>> create(KufangEntity kufang) throws Exception {
        KufangName name = KufangName.create(kufang.getName());
        log.info("KufangName name = KufangName.create(kufang.getName());");
        KufangId id = KufangId.create();
        String bz = kufang.getBz();
        CreateKufangCommand command = new CreateKufangCommand(id, name, bz);
        commandGateway.send(command);
        Optional<KufangEntity> kufangSave = repository.findByIdentifier(id.getIdentifier());

        return ResponseEntity.ok(assembler.toResource(kufangSave.get()));

    }

}

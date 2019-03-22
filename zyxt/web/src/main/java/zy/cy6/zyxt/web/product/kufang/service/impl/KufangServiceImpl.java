package zy.cy6.zyxt.web.product.kufang.service.impl;

/*
 *参见 spring官方案例 spring-hateoas-examples
 */

import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.axonframework.commandhandling.CommandBus;
import org.axonframework.commandhandling.GenericCommandMessage;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import zy.cy6.zyxt.api.product.kufang.CreateKufangCommand;
import zy.cy6.zyxt.api.product.kufang.KufangId;
import zy.cy6.zyxt.api.product.kufang.KufangName;
import zy.cy6.zyxt.api.product.kufang.RemoveKufangCommand;
import zy.cy6.zyxt.query.kufang.KufangEntity;
import zy.cy6.zyxt.query.kufang.KufangQueryService;
import zy.cy6.zyxt.web.product.kufang.resource.KufangResourceAssembler;
import zy.cy6.zyxt.web.product.kufang.service.KufangService;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class KufangServiceImpl implements KufangService {
  private final KufangResourceAssembler assembler;
  private CommandBus commandBus;
  private final CommandGateway commandGateway;
  private final KufangQueryService kufangQueryService;

  @Autowired
  public KufangServiceImpl(
      CommandGateway commandGateway,
      CommandBus commandBus,
      KufangResourceAssembler assembler,
      KufangQueryService kufangQueryService) {
    this.assembler = assembler;
    this.commandBus = commandBus;
    this.commandGateway = commandGateway;
    this.kufangQueryService = kufangQueryService;
  }

  @Override
  public Optional<KufangEntity> findKufangName(String name) {
    return kufangQueryService.findByKufangName(createKufangName(name).get());
  }

  private List<KufangEntity> findAllKufang() {
    log.info("所有的工具记录");
    return kufangQueryService.findAllKufangs();
  }

  /*参见 EmployeeController.java
   * D:\yutao\源代码\spring-hateoas-examples\hypermedia\src\main\java\org\springframework\hateoas\examples\EmployeeController.java
   */
  //  @GetMapping(value = "/kufangs", produces = MediaTypes.HAL_JSON_VALUE)

  @Override
  public ResponseEntity<List<KufangEntity>> findAll() {
    return  new ResponseEntity<List<KufangEntity>>(findAllKufang(), HttpStatus.OK);
  }

//  @Override
//  public ResponseEntity<Resources<Resource<KufangEntity>>> findAll() {
//    return ResponseEntity.ok(assembler.toResources(findAllKufang()));
//  }

  @Override
  public ResponseEntity<Resource<KufangEntity>> findOne(Long id) {
    return kufangQueryService
        .findOne(id)
        .map(assembler::toResource)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
 }
  /** 删除记录 */
  @Override
  public void remove(String id) {
    commandBus.dispatch(new GenericCommandMessage<>(removeKufangCommand(id)));
    //    return commandGateway.send(removeKufangCommand(id));

  }

  private RemoveKufangCommand removeKufangCommand(String id) {
    return RemoveKufangCommand.builder().kufangId(createKufangId(id)).build();
  }

  private KufangId createKufangId(String id) {
    return KufangId.builder().identifier(id).build();
  }

  private Optional<KufangEntity> findByIdentifier(String identifier) {
    return kufangQueryService.findByIdentifier(identifier);
  }

  /**
   * POST /countries : Create a new kufang. 创建新记录
   *
   * @param kufang the country to create
   * @return the ResponseEntity with status 201 (Created) and with body the new country, or with
   *     status 400 (Bad Request) if the country has already an ID
   * @throws if the Location URI syntax is incorrect
   */
  @Override
  public Optional<KufangEntity> create(KufangEntity kufang) {
    var command = createKufangCommand(kufang);
    commandGateway.sendAndWait(command);
    //    commandBus.dispatch(new GenericCommandMessage<>(command));
    return findByIdentifier(command.getKufangId().getIdentifier());
  }

  private CreateKufangCommand createKufangCommand(KufangEntity kufang) {
    return CreateKufangCommand.builder()
        .kufangId(createKufangId())
        .kufangName(createKufangName(kufang.getName()).get())
        .bz(kufang.getBz())
        .build();
  }

  private KufangId createKufangId() {
    return KufangId.builder().build();
  }

  private Optional<KufangName> createKufangName(String name) {
    return Optional.of(KufangName.builder().name(name).build());
  }
}

//    public ResponseEntity<Resource<KufangEntity>> create(KufangEntity kufang) throws Exception {
//        Optional<KufangEntity> kufangSave = repository.findByIdentifier(id.getIdentifier());
//        return ResponseEntity.ok(assembler.toResource(kufangSave.get()));
//    }

//  public ResponseEntity createKufang(@RequestBody KufangEntity kufang) {
//    return
// ResponseEntity.ok(assembler.toResource(kufangQueryService.findByIdentifier(command.getKufangId().getIdentifier()).get()));
//  }

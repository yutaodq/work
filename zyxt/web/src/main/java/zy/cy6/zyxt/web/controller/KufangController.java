package zy.cy6.zyxt.web.controller;

/*
 *参见 spring官方案例 spring-hateoas-examples
 */

import com.codahale.metrics.annotation.Timed;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandBus;
import org.axonframework.commandhandling.GenericCommandMessage;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zy.cy6.zyxt.api.product.kufang.CreateKufangCommand;
import zy.cy6.zyxt.api.product.kufang.KufangId;
import zy.cy6.zyxt.api.product.kufang.KufangName;
import zy.cy6.zyxt.api.product.kufang.RemoveKufangCommand;
import zy.cy6.zyxt.query.kufang.KufangEntity;
import zy.cy6.zyxt.query.kufang.KufangQueryService;
import zy.cy6.zyxt.web.product.KufangResourceAssembler;
import zy.cy6.zyxt.web.product.KufangService;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;




@RestController
@Slf4j
@RequestMapping("/api")
public class KufangController {
  private final KufangService kufangService;
  private final KufangQueryService kufangQueryService;
  private final CommandBus commandBus;

  private final KufangResourceAssembler assembler;
  private final CommandGateway commandGateway;
  private static final String ENTITY_NAME = "KufangEntity";

  @Autowired
  public KufangController(CommandBus commandBus,
                          KufangResourceAssembler assembler,
                          CommandGateway commandGateway,
                          KufangService kufangService,
                          KufangQueryService kufangQueryService) {
    this.commandBus = commandBus;
    this.assembler = assembler;
    this.commandGateway = commandGateway;
    this.kufangService = kufangService;
    this.kufangQueryService = kufangQueryService;

  }

  @GetMapping(value = "/kufangEntities", produces = MediaTypes.HAL_JSON_VALUE)
  @Timed
  public List<KufangEntity> getAllKufangs() {
    log.info("所有的工具记录");
    return kufangService.findAllKufang();
  }

  @GetMapping(value = "/kufangEntities/{id}", produces = MediaTypes.HAL_JSON_VALUE)
  public ResponseEntity<Resource<KufangEntity>> findOne(@PathVariable Long id) {
    log.info("查找一个记录");
    return kufangQueryService.findOne(id).map(assembler::toResource).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
  }

//  @DeleteMapping("/kufangEntities/{id}")
//  public ResponseEntity<Void> deleteKufang(@PathVariable Long id) {
//    log.info("删除工具记录 : {}", id);
//    CreateKufangCommand command = new CreateKufangCommand(id, name.get(), bz);
//    commandGateway.sendAndWait(command);
//    //    countryService.delete(id);
//    //    return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME,
//    // id.toString())).build();
//    return null;
//  }
  @DeleteMapping("/kufangEntities/{id}")
//  public CompletableFuture<String> remove(@PathVariable String id) {
  public void remove(@PathVariable String id) {
    KufangId kufangId = KufangId.create(id);
    RemoveKufangCommand command = new RemoveKufangCommand(kufangId);

    log.info("Executing command: kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk:{}", command.getKufangId());
     commandBus.dispatch(new GenericCommandMessage<>(command));
//    return commandGateway.send(command);
  }

  /**
   * POST /countries : Create a new kufang.
   * 创建新记录
   *
   * @param kufang the country to create
   * @return the ResponseEntity with status 201 (Created) and with body the new country, or with
   * status 400 (Bad Request) if the country has already an ID
   * @throws URISyntaxException if the Location URI syntax is incorrect
   */
//  @PostMapping("/kufangEntities")
//  public ResponseEntity createKufang(@RequestBody KufangEntity kufang) {
//    Optional<KufangName> name = createKufangName(kufang.getName());
//    KufangId id = KufangId.create();
//    String bz = kufang.getBz();
//    CreateKufangCommand command = new CreateKufangCommand(id, name.get(), bz);
//    commandGateway.sendAndWait(command);
//
//    return ResponseEntity.ok(assembler.toResource(kufangQueryService.findByIdentifier(command.getKufangId().getIdentifier()).get()));
////return kufangService.create(kufang);
//  }

  @PostMapping("/kufangEntities")
  public Optional<KufangEntity> createKufang(@RequestBody KufangEntity kufang) {
    log.info("新建库房记录 : {}", kufang.getName());
    Optional<KufangName> name = createKufangName(kufang.getName());
    KufangId id = KufangId.create();
    String bz = kufang.getBz();
    CreateKufangCommand command = CreateKufangCommand.builder()
            .kufangId(id)
//            .kufangName(name.get())
            .bz(bz)
            .build();
//            (id, name.get(), bz);

//    CreateKufangCommand command = new CreateKufangCommand(id, name.get(), bz);
    commandGateway.sendAndWait(command);
//    commandBus.dispatch(new GenericCommandMessage<>(command));
    return kufangQueryService.findByIdentifier(command.getKufangId().getIdentifier());
  }

  private Optional<KufangName> createKufangName(String name) {
    return Optional.of(KufangName.create(name));
  }


}

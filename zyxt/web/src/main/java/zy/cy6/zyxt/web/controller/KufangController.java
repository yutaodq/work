package zy.cy6.zyxt.web.controller;

/*
 *参见 spring官方案例 spring-hateoas-examples
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.*;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zy.cy6.zyxt.query.kufang.KufangEntity;
import zy.cy6.zyxt.web.product.kufang.service.KufangService;

import java.net.URISyntaxException;
import java.util.Optional;

@RestController
@Slf4j
@RequestMapping("/api")
//@ExposesResourceFor(KufangEntity.class)
public class KufangController {
  private final KufangService kufangService;
  private final EntityLinks entityLinks;
  private static final String ENTITY_NAME = "KufangEntity";

  @Autowired
  public KufangController(KufangService kufangService,
                          EntityLinks entityLinks ) {
    this.kufangService = kufangService;
    this.entityLinks = entityLinks;

  }

//  @GetMapping(value = "/kufangEntities", produces = MediaTypes.HAL_JSON_VALUE)
//  @Timed
//  public List<KufangEntity> getAllKufangs() {
//    log.info("查找所有的工具记录");
//    return kufangService.findAllKufang();
//  }

  @RequestMapping(value = "/kufangEntities", method = RequestMethod.GET)
  public HttpEntity<Resources<KufangEntity>> getAllKufangs() {
    Resources<KufangEntity> resources = new Resources<KufangEntity>(this.kufangService.findAllKufang());
//    resources.add(this.entityLinks.linkToCollectionResource(KufangEntity.class));
    return new ResponseEntity< Resources< KufangEntity > >(resources, HttpStatus.OK);
  }


  @GetMapping(value = "/kufangEntities/{id}", produces = MediaTypes.HAL_JSON_VALUE)
  public ResponseEntity<Resource<KufangEntity>> findOne(@PathVariable Long id) {
    log.info("查找一个记录");
    return kufangService.findOne(id);
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
  public void remove(@PathVariable String id) {
    log.info("删除一个记录");
    kufangService.remove(id);
  }

  /**
   * POST /countries : Create a new kufang. 创建新记录
   *
   * @param kufang the country to create
   * @return the ResponseEntity with status 201 (Created) and with body the new country, or with
   *     status 400 (Bad Request) if the country has already an ID
   * @throws URISyntaxException if the Location URI syntax is incorrect
   */
  @PostMapping("/kufangEntities")
  public Optional<KufangEntity> createKufang(@RequestBody KufangEntity kufang) {
    return kufangService.create(kufang);
  }
}

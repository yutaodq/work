package zy.cy6.zyxt.web.controller;

/*
 *参见 spring官方案例 spring-hateoas-examples
 */
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.codahale.metrics.annotation.Timed;
import zy.cy6.zyxt.api.product.kufang.CreateKufangCommand;
import zy.cy6.zyxt.api.product.kufang.KufangId;
import zy.cy6.zyxt.api.product.kufang.KufangName;
import zy.cy6.zyxt.query.product.KufangEntity;
import zy.cy6.zyxt.query.product.KufangQueryService;
import zy.cy6.zyxt.web.product.KufangResourceAssembler;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;


@RestController
@Slf4j
@RequestMapping("/api")
public class KufangController {
    private final KufangQueryService kufangService;
    private final KufangResourceAssembler assembler;
    private final CommandGateway commandGateway;
    private static final String ENTITY_NAME = "KufangEntity";

    @Autowired
    public KufangController(KufangResourceAssembler assembler, CommandGateway commandGateway, KufangQueryService kufangService) {
        this.assembler = assembler;
        this.commandGateway = commandGateway;
        this.kufangService = kufangService;
    }

    @GetMapping(value = "/kufangEntities", produces = MediaTypes.HAL_JSON_VALUE)
    @Timed
    public List<KufangEntity> getAllKufangs() {
        log.info("所有的工具记录");
        return kufangService.findAllKufang();
    }
    /**
     * org.exampleapps.greatbig.web.rest.MessageResource
     * @param query the query of the contact search
     * @return the result of the search
     */

//    @GetMapping("/_search/kufangEntities")
//    @Timed
//    public List<KufangEntity> searchContacts(@RequestParam String query) {
//        log.debug("REST request to search Contacts for query {}", query);
//        return kufangService.search(query);
//    }

    @GetMapping(value = "/kufangEntities/{id}", produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<Resource<KufangEntity>> findOne(@PathVariable Long id) {
        log.info("查找一个记录");
        return kufangService.findOne(id).map(assembler::toResource).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/kufangEntities/{id}")
    public ResponseEntity<Void> deleteCountry(@PathVariable Long id) {
        log.info("删除工具记录 : {}", id);
        //    countryService.delete(id);
        //    return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME,
        // id.toString())).build();
        return null;
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

    @PostMapping("/kufangEntities")
    public ResponseEntity createKufang(@RequestBody KufangEntity kufang) {
        kufang.getName();
        Optional<KufangName> name = createKufangName(kufang.getName());
        KufangId id = KufangId.create();
        CreateKufangCommand command = new CreateKufangCommand(id, name.get());
        commandGateway.sendAndWait(command);

        return ResponseEntity.ok(assembler.toResource(kufangService.findByIdentifier(command.getKufangId().getIdentifier()).get()));

    }

    private Optional<KufangName> createKufangName(String name) {
        return Optional.of(KufangName.create(name));
    }



}

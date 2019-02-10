package zy.cy6.zyxt.api.product.kufang;


import java.util.UUID;

public final class KufangId{
    private final String identifier;
    public KufangId() {
        this.identifier = generateIdentifier();
    }

    public KufangId(String identifier) {
        this.identifier = identifier;
    }
    static String generateIdentifier() {
        return UUID.randomUUID().toString();
    }
    public String getIdentifier() {
        return identifier;
    }
    public static KufangId create() {
        return new KufangId();
    }
    public static KufangId create(String identifier) {
        return new KufangId(identifier);
    }
    public String toString() {
        return getIdentifier();
    }

}

//@Slf4j
////@EqualsAndHashCode
//
//public final class KufangId extends AbstractAggregateIdentifier {
//
//    private KufangId() {
//        super();
//        log.info("新建：KufangId");
//    }
//
//    private KufangId(String identifier) {
//        super(identifier);
//        log.info("新建：KufangId");
//    }
//
//    public static KufangId create() {
//        return new KufangId();
//    }
//
//    public static KufangId create(String identifier) {
//        return new KufangId(identifier);
//    }
//
//    @Override
//    public String toString() {
//        return getIdentifier();
//    }
//
//    //    @Override
////    public String toString() {
////        return "库房标识{" + "identifier='" + getIdentifier() + '\'' + '}';
////    }
//}

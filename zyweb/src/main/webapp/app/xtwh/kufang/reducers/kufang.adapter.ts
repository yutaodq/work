import { createEntityAdapter, EntityAdapter } from "@ngrx/entity";
import { KufangEntity } from "app/xtwh/kufang/models/kufang.model";

/**
 * createEntityAdapter creates an object of many helper
 * functions for single or multiple operations
 * against the dictionary of records. The configuration
 * object takes a record id selector function and
 * a sortComparer option which is set to a compare
 * function if the records are to be sorted.
 */
export const adapter: EntityAdapter<KufangEntity> = createEntityAdapter<
  KufangEntity
>({
  selectId: (kufang: KufangEntity) => kufang.id,
  sortComparer: false
});

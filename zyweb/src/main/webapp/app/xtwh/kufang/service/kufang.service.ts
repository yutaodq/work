import { Injectable } from "@angular/core";
import { HttpClient, HttpResponse } from "@angular/common/http";
import { Observable, of } from "rxjs";
import { delay } from "rxjs/operators";

import { select, Store } from "@ngrx/store";
import * as fromKufangs from "app/xtwh/kufang/reducers";

import { SERVER_API_URL } from "app/app.constants";
import { createRequestOption } from "app/shared";
import {
  IKufangEntity,
  KufangEntity
} from "app/xtwh/kufang/models/kufang.model";
import { IZyEntityService } from "app/core/service/";
import { CollectionPageActions } from "app/xtwh/kufang/actions";

type EntityResponseType = HttpResponse<IKufangEntity>;
type EntityArrayResponseType = HttpResponse<IKufangEntity[]>;

const ALTER_EGOS = ["Eric"];

// @Injectable({ providedIn: "root" })
@Injectable()
export class KufangService implements IZyEntityService<IKufangEntity> {
  private resourceUrl = SERVER_API_URL + "api/kufangEntities";
  private resourceSearchUrl = SERVER_API_URL + "api/kufangEntities";
  // kufangs: Observable<IKufangEntity[]>;

  constructor(
    private http: HttpClient,
    private store: Store<fromKufangs.State>
  ) {
    // this.kufangs = store.pipe(select(fromKufangs.getKufangCollection));
  }

  isNameTaken(alterEgo: string): Observable<boolean> {
    const isTaken = ALTER_EGOS.includes(alterEgo);
    console.log(`异步验证KufangService:` + isTaken);

    return of(isTaken).pipe(delay(100));
  }

  // create(kufang: IKufangEntity): Observable<EntityResponseType> {
  //   return this.http.post<IKufangEntity>(this.resourceUrl, kufang, {
  //     observe: "response"
  //   });
  // }

  create(kufang: IKufangEntity): Observable<IKufangEntity> {
    return this.http.post<IKufangEntity>(this.resourceUrl, kufang);
  }

  update(product: IKufangEntity): Observable<EntityResponseType> {
    // update(product: IKufangEntity): Observable<EntityResponseType> {
    return this.http.put<IKufangEntity>(this.resourceUrl, product, {
      observe: "response"
    });
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http.get<IKufangEntity>(`${this.resourceUrl}/${id}`, {
      observe: "response"
    });
  }

  queryyu(): Observable<IKufangEntity[]> {
    return this.http.get<IKufangEntity[]>(this.resourceUrl);
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http.get<IKufangEntity[]>(this.resourceUrl, {
      params: options,
      observe: "response"
    });
  }

  delete(id: string): Observable<IKufangEntity> {
    console.log(`以前的状态: KufangService`);
    return this.http.delete<any>(`${this.resourceUrl}/${id}`);
  }

  search(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http.get<IKufangEntity[]>(this.resourceSearchUrl, {
      params: options,
      observe: "response"
    });
  }
}

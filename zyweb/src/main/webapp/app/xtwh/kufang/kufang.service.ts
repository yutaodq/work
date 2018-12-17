import { Injectable } from "@angular/core";
import { HttpClient, HttpResponse } from "@angular/common/http";
import { Observable, of } from "rxjs";
import { delay } from "rxjs/operators";

import { SERVER_API_URL } from "app/app.constants";
import { createRequestOption } from "app/shared";
import { IKufangEntity } from "app/shared/model/kufang.model";

type EntityResponseType = HttpResponse<IKufangEntity>;
type EntityArrayResponseType = HttpResponse<IKufangEntity[]>;

const ALTER_EGOS = ["Eric"];

// @Injectable({ providedIn: "root" })
@Injectable()
export class KufangService {
  private resourceUrl = SERVER_API_URL + "api/kufangEntities";
  private resourceSearchUrl = SERVER_API_URL + "api/kufangEntities";

  constructor(private http: HttpClient) {}

  isNameTaken(alterEgo: string): Observable<boolean> {
    const isTaken = ALTER_EGOS.includes(alterEgo);

    return of(isTaken).pipe(delay(400));
  }
  create(product: IKufangEntity): Observable<EntityResponseType> {
    return this.http.post<IKufangEntity>(this.resourceUrl, product, {
      observe: "response"
    });
  }

  update(product: IKufangEntity): Observable<EntityResponseType> {
    return this.http.put<IKufangEntity>(this.resourceUrl, product, {
      observe: "response"
    });
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http.get<IKufangEntity>(`${this.resourceUrl}/${id}`, {
      observe: "response"
    });
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http.get<IKufangEntity[]>(this.resourceUrl, {
      params: options,
      observe: "response"
    });
  }

  delete(id: number): Observable<HttpResponse<any>> {
    return this.http.delete<any>(`${this.resourceUrl}/${id}`, {
      observe: "response"
    });
  }

  search(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http.get<IKufangEntity[]>(this.resourceSearchUrl, {
      params: options,
      observe: "response"
    });
  }
}

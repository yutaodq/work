import { Injectable } from "@angular/core";
import { HttpClient, HttpResponse } from "@angular/common/http";
import { Observable } from "rxjs";

import { SERVER_API_URL } from "app/app.constants";
import { createRequestOption } from "app/shared";
import { IProductEntity } from "app/shared/model/product.model";

type EntityResponseType = HttpResponse<IProductEntity>;
type EntityArrayResponseType = HttpResponse<IProductEntity[]>;

@Injectable({ providedIn: "root" })
export class ProductService {
  private resourceUrl = SERVER_API_URL + "api/productEntities";
  private resourceSearchUrl = SERVER_API_URL + "api/productEntities";
  // private resourceSearchUrl = SERVER_API_URL + 'api/_search/productEntities';

  constructor(private http: HttpClient) {}

  create(product: IProductEntity): Observable<EntityResponseType> {
    return this.http.post<IProductEntity>(this.resourceUrl, product, {
      observe: "response"
    });
  }

  update(product: IProductEntity): Observable<EntityResponseType> {
    return this.http.put<IProductEntity>(this.resourceUrl, product, {
      observe: "response"
    });
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http.get<IProductEntity>(`${this.resourceUrl}/${id}`, {
      observe: "response"
    });
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http.get<IProductEntity[]>(this.resourceUrl, {
      params: options,
      observe: "response"
    });
  }

  // getAll(req?: any) {
  //     const options = createRequestOption(req);
  //   return this.http.get<IProductEntity[]>(this.resourceUrl, { params: options, observe: 'response' });
  // }

  delete(id: number): Observable<HttpResponse<any>> {
    return this.http.delete<any>(`${this.resourceUrl}/${id}`, {
      observe: "response"
    });
  }

  search(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http.get<IProductEntity[]>(this.resourceSearchUrl, {
      params: options,
      observe: "response"
    });
  }
}

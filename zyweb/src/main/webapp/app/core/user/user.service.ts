// import { Injectable } from "@angular/core";
// import { HttpClient, HttpResponse } from "@angular/common/http";
// import { Observable, of } from "rxjs";
//
// import { SERVER_API_URL } from "app/app.constants";
// import { createRequestOption } from "app/shared/util/request-util";
// import { IUser } from "./user.model";
//
// @Injectable({ providedIn: "root" })
// export class UserServiceYu {
//   private resourceUrl = SERVER_API_URL + "api/users";
//
//   constructor(private http: HttpClient) {}
//
//   create(user: IUser): Observable<HttpResponse<IUser>> {
//     return this.http.post<IUser>(this.resourceUrl, user, {
//       observe: "response"
//     });
//   }
//
//   update(user: IUser): Observable<HttpResponse<IUser>> {
//     return this.http.put<IUser>(this.resourceUrl, user, {
//       observe: "response"
//     });
//   }
//
//   find(component: string): Observable<HttpResponse<IUser>> {
//     return this.http.get<IUser>(`${this.resourceUrl}/${component}`, {
//       observe: "response"
//     });
//   }
//
//   query(req?: any): Observable<HttpResponse<IUser[]>> {
//     const options = createRequestOption(req);
//     return this.http.get<IUser[]>(this.resourceUrl, {
//       params: options,
//       observe: "response"
//     });
//   }
//
//   delete(component: string): Observable<HttpResponse<any>> {
//     return this.http.delete(`${this.resourceUrl}/${component}`, {
//       observe: "response"
//     });
//   }
//
//   authorities(): Observable<string[]> {
//     return of(["ROLE_USER", "ROLE_ADMIN"]);
//   }
// }

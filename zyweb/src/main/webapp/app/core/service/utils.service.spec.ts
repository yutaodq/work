import { TestBed, inject } from "@angular/core/testing";
import { JwtModule, JWT_OPTIONS, JwtHelperService } from "@auth0/angular-jwt";
import { UtilsService } from "./utils.service";

describe("UtilsService", () => {
  let service: UtilsService;
  let jwt: JwtHelperService;
  let token = "test_token";
  let value = "test value";

  beforeEach(() => {
    jwt = new JwtHelperService({});
    service = new UtilsService(jwt);
  });

  afterEach(() => {
    service.removeToken(token);
    jwt = null;
    service = null;
  });

  it("should be created", () => {
    expect(service).toBeTruthy();
  });

  it("should get token", () => {
    service.writeToken(token, value);
    expect(service.getToken(token)).toBe(value);
  });

  it("should not get token", () => {
    expect(service.getToken(token)).toBeNull();
  });

  /*
  it('should be expired', (() => {
      let jwtStr = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6IkplcnJ5IiwiaWF0IjoxNTE0NzE5NDE0LCJleHAiOjE1MTQ3MjMwMTR9.NdZrn-DxzmgvlmefXZGse_OvBh1dhTS5WZQnuBhOX3o";
      service.writeToken(token, jwtStr);
      expect(service.isTokenExpired()).toBeTruthy();   // should be expired
  }));
  */

  it("check expired", () => {
    let jwtStr =
      "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6IkplcnJ5IiwiaWF0IjoxNTE0NzE5NDE0LCJleHAiOjE1MTQ3MjMwMTR9.NdZrn-DxzmgvlmefXZGse_OvBh1dhTS5WZQnuBhOX3o";
    let date = jwt.getTokenExpirationDate(jwtStr);
    expect(jwt.getTokenExpirationDate(jwtStr)).toMatch(/Sun Dec 31 2017/); // should be 2017-12-31
  });
});

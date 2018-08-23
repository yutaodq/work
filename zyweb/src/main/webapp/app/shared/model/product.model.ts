export interface IProductEntity {
  id?: number;
  identifier?: string;
  name?: string;
  gg?: string;
  xh?: string;
}

export class ProductEntity implements IProductEntity {
  constructor(public id?: number,
              public identifier?: string,
              public name?: string,
              public gg?: string,
              public xh?: string) {
  }
}

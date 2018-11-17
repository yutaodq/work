export interface IKufangEntity {
  id?: number;
  identifier?: string;
  name?: string;
}

export class KufangEntity implements IKufangEntity {
  constructor(
    public id?: number,
    public identifier?: string,
    public name?: string
  ) {}
}

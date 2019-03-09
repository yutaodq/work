export interface IUserEntity {
  id?: number;
  identifier?: string;
  name?: string;
  bz?: string;
}

export class UserEntity implements IUserEntity {
  constructor(
    public id?: number,
    public identifier?: string,
    public name?: string,
    public bz?: string
  ) {}
}

export interface IUserEntity {
  username: string;
  id?: number;
  identifier?: string;
  password?: string;
  rememberMe?: boolean;
}

// export class UserEntity implements IUserEntity {
//   constructor(
//     public id?: number,
//     public identifier?: string,
//     public name?: string,
//     public bz?: string
//   ) {}
// }

export interface Jwt {
}

export class User {
  constructor(
    public status: string
  ){

  }
}

export class JwtResponse{
  constructor(
    public jwttoken: string
  ){

  }
}


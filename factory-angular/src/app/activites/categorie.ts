import { Activite } from './activite';

export class Categorie {
  public categoriesFilles: Array<Categorie>;
  public categorieMere: Categorie;
  public activites: Array<Activite>;

  constructor(
      public id?: number,
      public libelle?: string
                ){}

}

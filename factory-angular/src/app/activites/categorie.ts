import { Activite } from './activite';

export class Categorie {
  public id;
  public libelle;
  public categoriesFilles: Array<Categorie>;
  public categorieMere: Categorie;
  public activites: Array<Activite>;

  constructor(){}

}

export class Activite {
	public id;
	public fournisseur;

    constructor(
    	public nom?: string,
    	public codeUnique?: string, 
    	public nbParticipantsMin?: number,
    	public nbParticipantsMax?: number, 
    	public duree?: number,
    	public tarifPersonne?: number, 

    	public activee?: boolean, 
    	public nbApproximatif?: boolean, 
    	public description?: string, 
    	public lienYoutube?: string, 
    	public image?: string, 

    	public niveau?: any,
    	public reservations?: any,
    	public categories?: any,
    	public lieu?: any

    	) { }
}
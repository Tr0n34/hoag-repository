package fr.hoag.models.referentials;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import fr.hoag.models.users.interfaces.Adress;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FrenchAdress implements Adress {

    @JsonProperty("feature[0].properties.street")
    private String numeroVoie;

    private String voie;
    private String codeInsee;
    private String codePostal;
    private String ville;
    private Country country;

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("numeroVoie", numeroVoie)
                .add("voie", voie)
                .add("codeInsee", codeInsee)
                .add("codePostal", codePostal)
                .add("ville", ville)
                .add("country", country)
                .toString();
    }

    public String getNumeroVoie() {
        return numeroVoie;
    }

    public void setNumeroVoie(String numeroVoie) {
        this.numeroVoie = numeroVoie;
    }

    public String getVoie() {
        return voie;
    }

    public void setVoie(String voie) {
        this.voie = voie;
    }

    public String getCodeInsee() {
        return codeInsee;
    }

    public void setCodeInsee(String codeInsee) {
        this.codeInsee = codeInsee;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    @Override
    public Country getCountry() {
        return this.country;
    }

    @Override
    public void setCountry(Country country) {
        this.country = country;
    }

    /*
    {
   "type":"FeatureCollection",
   "version":"draft",
   "features":[
      {
         "type":"Feature",
         "geometry":{
            "type":"Point",
            "coordinates":[
               2.290084,
               49.897443
            ]
         },
         "properties":{
            "label":"8 Boulevard du Port 80000 Amiens",
            "score":0.49159121588068583,
            "housenumber":"8",
            "id":"80021_6590_00008",
            "type":"housenumber",
            "name":"8 Boulevard du Port",
            "postcode":"80000",
            "citycode":"80021",
            "x":648952.58,
            "y":6977867.25,
            "city":"Amiens",
            "context":"80, Somme, Hauts-de-France",
            "importance":0.6706612694243868,
            "street":"Boulevard du Port"
         }
      }
   ],
   "attribution":"BAN",
   "licence":"ODbL 1.0",
   "query":"8 bd du port",
   "limit":1
}
     */

}

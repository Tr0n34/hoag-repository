package fr.hoag.models.referentials;

import com.google.common.base.MoreObjects;

/**
 * Norme ISO-3166
 * <ul>
 *     <li>Code Alpha-2 : Code à deux lettres (recommandé code international commun).</li>
 *     <li>Code Alpha-3 : Code à trois lettres (permettant une association viseulle avec le nom du pays).</li>
 *     <li>Code Alpha-4 : Code à quatre lettres (représentation d'un nom devenu obsolète).</li>
 * </ul>
 */
public class Country {

    public enum Status {
        OFFICIALLY_ASSIGNED,
        USER_ASSIGNED,
        EXCEPTIONNALY_RESERVED,
        TRANSITIONNALY_RESERVED,
        INDETERMINATELY_RESERVED,
        FORMERLY_ASSIGNED,
        UNASSIGNED
    }

    private String codeAlpha2;
    private String codeAlpha3;
    private String codeAlpha4;
    private String code;
    private String shortName;
    private String longName;
    private String comments;

    public Country(String codeAlpha2, String codeAlpha3, String codeAlpha4, String code, String shortName, String longName, String comments) {
        this.codeAlpha2 = codeAlpha2;
        this.codeAlpha3 = codeAlpha3;
        this.codeAlpha4 = codeAlpha4;
        this.code = code;
        this.shortName = shortName;
        this.longName = longName;
        this.comments = comments;
    }



}
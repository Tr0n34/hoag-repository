package fr.hoag.models.referentials;

/**
 * Organisme source de la position géographique d'une adresse française.
 */
public enum SourcePosition {
    COMMUNE,
    CADASTRE,
    ARCEP,
    LAPOSTE,
    INSEE,
    SDIS,
    INCONNUE
}

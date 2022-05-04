package fr.hoag.repositories.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@Table(
        name = "countries",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "UK_COUNTRY_CODE",
                        columnNames = {
                                "country_code"
                        }
                ),
                @UniqueConstraint(
                        name = "UK_ALPHA3",
                        columnNames = {
                                "alpha_3"
                        }
                )
                ,
                @UniqueConstraint(
                        name = "UK_ALPHA2",
                        columnNames = {
                                "alpha_2"
                        }
                )
        }
)
@Getter
@Setter
@Builder(builderMethodName = "create")
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@ToString
@EqualsAndHashCode
public class CountryDto {

    @Id
    @GeneratedValue
    private UUID id;
    @Column(length = 63)
    private String name;
    @Column(name = "alpha_2", length = 2)
    @JsonProperty("alpha-2")
    private String alpha2;
    @Column(name = "alpha_3", length = 3)
    @JsonProperty("alpha-3")
    private String alpha3;
    @Column(name = "country_code", length = 2)
    @JsonProperty("country-code")
    private String countryCode;
    @Column(length = 63)
    private String region;
    @Column(name = "sub_region", length = 63)
    @JsonProperty("sub-region")
    private String subRegion;
    @Column(name = "intermediate_region", length = 63)
    @JsonProperty("intermediate_region")
    private String intermediateRegion;
    @Column(name = "region_code", length = 3)
    @JsonProperty("region-code")
    private String regionCode;
    @Column(name = "sub_region_code", length = 3)
    @JsonProperty("sub-region-code")
    private String subRegionCode;
    @Column(name = "intermediate_region_code", length = 3)
    @JsonProperty("intermediate-region-code")
    private String intermediateRegionCode;

}

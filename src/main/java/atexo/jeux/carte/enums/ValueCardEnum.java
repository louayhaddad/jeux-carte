package atexo.jeux.carte.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ValueCardEnum {
    AS("as"),
    DEUX("deux"),
    TROIS("trois"),
    QUATRE("quatre"),
    CINQ("cinq"),
    SIX("six"),
    SEPT("sept"),
    HUIT("huit"),
    NEUF("neuf"),
    DIX("dix"),
    VALET("valet"),
    DAME("dame"),
    ROI("roi");

    private String value;
}
